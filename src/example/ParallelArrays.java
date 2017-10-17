package example;


import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ParallelArrays
 * 并行（parallel）数组
 *
 * @author Huai_Shuo
 * @date 15 /12/9
 */
public class ParallelArrays {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];


        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(1000).forEach(
                i -> System.out.print(i + " "));
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(1000).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
        //上面的代码片段使用了parallelSetAll()方法来对一个有20000个元素的数组进行随机赋值。
        // 然后，调用parallelSort方法。这个程序首先打印出前10个元素的值，之后对整个数组排序。

    }
}
