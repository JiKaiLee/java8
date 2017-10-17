package example;


import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Car
 * 方法引用
 *
 * @author Huai_Shuo
 * @date 15 /12/9
 */
public class Car {

    /**
     * Create car.
     *
     * @param supplier the supplier
     * @return the car
     */
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    /**
     * Collide void.
     *
     * @param car the car
     */
    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    /**
     * Follow void.
     *
     * @param another the another
     */
    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    /**
     * Repair void.
     */
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */

    public static void main(String[] args) {
        //1.第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数。
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        //2.第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
        cars.forEach(Car::collide);
        //3.第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
        cars.forEach(Car::repair);
        //4.最后，第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
