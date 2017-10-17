package example;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * computeIfAbsent
 *
 * @author Huai_Shuo
 * @date 15/12/11
 */
public class computeIfAbsent {

    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        cache.put(0, 0);
        cache.put(1, 1);
        // 普通方式
        System.out.println("Fibonacci(7) = " + fibonacci(7));
        // 采用java7的同步线程方式及java8的本地缓存的方式
        System.out.println("FibonacciJava8(7) = " + fibonacciJava8(7));
        System.out.println("FibonacciJava7(7) = " + fibonacciJava7(7));

        // 构建多值Map样例代码
        Map<String, HashSet<String>> map1 = new HashMap<>();
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("apple");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("orange");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("pear");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("banana");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("water");
        System.out.println(map1);

        //测试多线程并发处理，是否同步操作
        Map<String, String> map2 = new ConcurrentHashMap<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            exec.execute(() -> {
                map2.computeIfAbsent("name", k -> genValue2(k));
                map2.computeIfAbsent("addr", k -> genValue2(k));
                map2.computeIfAbsent("email", k -> genValue2(k));
                map2.computeIfAbsent("mobile", k -> genValue2(k));
            });
        }
        exec.shutdown();
        exec.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(map2);
    }

    static HashSet<String> genValue(String str) {
        return new HashSet<String>();
    }

    static String genValue2(String str) {
        System.out.println("===");
        return str + "2";
    }

    /**
     * 普通的实现方式 普通方式使用大量的计算，存在性能问题. 并且计算量随着n的增加呈指数级增加，需要用到一些缓存策略，并且是线程安全的.
     *
     * @param n
     * @return
     */
    static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;

        System.out.println("calculating Fibonacci(" + n + ")");
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    /**
     * 采用java8的本地缓存方式 如果缓存MAP中不存在指定key的值，会自动调用mappingFunction(key)计算key的value
     * 然后将key = value放入到缓存Map,java8会使用thread-safe的方式从cache中存取记录
     *
     * @param n
     * @return
     */
    static int fibonacciJava8(int n) {
        return cache.computeIfAbsent(n, (key) -> {
            System.out.println("calculating FibonacciJava8 " + n);
            return fibonacciJava8(n - 2) + fibonacciJava8(n - 1);
        });
    }

    /**
     * 在java7中的实现方式
     * 在java7中，通过synchronized进行线程同步，检查缓存是否存在key对应的值，如果不存在才进行计算并放入缓存中
     * 为了更好的性能，需要使用 double-checked locking，那样代码会更复杂
     *
     * @param n
     * @return
     */
    static int fibonacciJava7(int n) {
        if (n == 0 || n == 1)
            return n;

        Integer result = cache.get(n);

        if (result == null) {
            synchronized (cache) {
                result = cache.get(n);

                if (result == null) {
                    System.out.println("calculating FibonacciJava7(" + n + ")");
                    result = fibonacciJava7(n - 2) + fibonacciJava7(n - 1);
                    cache.put(n, result);
                }
            }
        }
        return result;
    }


}
