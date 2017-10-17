package example;


import java.util.Arrays;
import java.util.List;

/**
 * Lambda1
 *
 * @author Huai_Shuo
 * @date 15 /12/9
 * <p>
 * Lambda1 表达式
 */
public class Lambda1 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Lambda1 l1 = new Lambda1();
       // l1.test0();
        //l1.test1();
//        l1.test2();
       // l1.test3();
        //l1.test4();
        l1.test5();


    }

    /**
     * The Separator.
     */
    final String separator = ",";


    void test0() {
        List<String> strs = Arrays.asList("a", "b", "d");

        for (String str : strs) {
            System.out.println(str);
        }

    }

    /**
     * Test 1.
     * 在最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。
     */
    void test1() {
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

    }

    /**
     * Test 2.
     * 请注意参数e的类型是由编译器推测出来的。同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型：
     */
    void test2() {
        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));


    }

    /**
     * Test 3.
     * 在某些情况下lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样。
     */
    void test3() {
        Arrays.asList("a", "b", "d").forEach(e -> {
            System.out.print(e);
            System.out.print(e);
        });

    }

    /**
     * Test 4.
     * Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）。例如，下面两个代码片段是相等的
     */
    void test4() {
       // String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                (String e) -> System.out.print(e + separator));




        Arrays.asList("a", "b", "d").forEach(
                (String e) -> System.out.print(e + separator));

    }

    /**
     * Test 5.
     * Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。下面两个代码片段是相等的
     */
    void test5() {

        Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));


        Arrays.asList("a", "b", "d").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });


    }


}
