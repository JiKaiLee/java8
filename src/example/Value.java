package example;


/**
 * Value
 * 更好的类推机制
 *
 * @author Huai_Shuo
 * @date 15/12/9
 */


public class Value<T> {
    public static <T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }


}