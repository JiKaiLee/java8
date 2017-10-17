package example;


import java.util.Optional;

/**
 * OptionalTest
 *
 * @author Huai_Shuo
 * @date 15 /12/9
 */
public class OptionalTest {

    /**
     * Test 1.
     * 一个允许为空值，一个不允许为空值。
     */
    static void test1() {


        Optional<String> fullName = Optional.ofNullable(null);
        ////如果Optional类的实例为非空值的话，isPresent()返回true，
        // 否从返回false。为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值。map()函数对当前Optional的值进行转化
        // 然后返回一个新的Optional实例。orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。下面是这个程序的输出
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));


    }

    static void test2() {
        Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println();

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }


}
