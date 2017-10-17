package example;


/**
 * Defaulable2
 * 接口的默认方法与静态方法
 *
 * @author Huai_Shuo
 * @date 15 /12/9
 * <p>
 * 默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。
 * 相反，每个接口都必须提供一个所谓的默认实现，这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认实现）。
 * 在JVM中，默认方法的实现是非常高效的，并且通过字节码指令为方法调用提供了支持。
 * 默认方法允许继续使用现有的Java接口，而同时能够保障正常的编译过程。
 * 这方面好的例子是大量的方法被添加到java.util.Collection接口中去：stream()，parallelStream()，forEach()，removeIf()，……
 * 尽管默认方法非常强大，但是在使用默认方法时我们需要小心注意一个地方：在声明一个默认方法前，请仔细思考是不是真的有必要使用默认方法，因为默认方法会带给程序歧义，
 * 并且在复杂的继承体系中容易产生编译错误。
 */
public interface Defaulable2 {


    //Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法。
    //接口允许默认的方法，实施者可以或不实现（重写）他们。

 void test();
    /**
     * Not required.
     *
     * @return the string
     */
    default String notRequired() {
        return "Default implementation";
    }
}
