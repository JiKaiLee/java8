package example;


import java.lang.annotation.*;

/**
 * RepeatingAnnotations
 *
 * @author Huai_Shuo
 * @date 15 /12/9
 * <p>
 * 重复注解机制本身必须用@Repeatable注解。事实上，这并不是语言层面上的改变，更多的是编译器的技巧，底层的原理保持不变
 */
public class RepeatingAnnotations {
    /**
     * The interface Filters.
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        /**
         * Value filter [ ].
         *
         * @return the filter [ ]
         */
        Filter[] value();
    }

    /**
     * The interface Filter.
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        /**
         * Value string.
         *
         * @return the string
         */
        String value();
    }

    ;

    /**
     * The interface Filterable.
     * 正如我们看到的，这里有个使用@Repeatable( Filters.class )注解的注解类Filter，Filters仅仅是Filter注解的数组，但Java编译器并不想让程序员意识到Filters的存在。
     * 这样，接口Filterable就拥有了两次Filter（并没有提到Filter）注解。

     同时反射相关的API提供了新的函数getAnnotationsByType()来返回重复注解的类型（请注意Filterable.class.getAnnotation( Filters.class )经编译器处理后将会返回Filters的实例）。
     */
    @Filter("filter1")
    @Filter("filter2")
    @Filter("filter3")

    public interface Filterable {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
    }
}
