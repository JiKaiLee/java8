package example;


import java.util.Arrays;
import java.util.Collection;

/**
 * StreamTest
 * Stream API极大简化了集合框架的处理（但它的处理的范围不仅仅限于集合框架的处理）。
 *
 * @author Huai_Shuo
 * @date 15 /12/9
 */
public class StreamTest {


    /**
     * The enum Status.
     */
    private enum Status {
        /**
         * The OPEN.
         */
        OPEN, /**
         * The CLOSED.
         */
        CLOSED
    }

    ;

    /**
     * The type Task.
     */
    private static final class Task {
        /**
         * The Status.
         */
        private final Status status;
        /**
         * The Points.
         */
        private final Integer points;

        /**
         * Instantiates a new Task.
         *
         * @param status the status
         * @param points the points
         */
        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        /**
         * Gets points.
         *
         * @return the points
         */
        public Integer getPoints() {
            return points;
        }

        /**
         * Gets status.
         *
         * @return the status
         */
        public Status getStatus() {
            return status;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }


    public static void main(String[] args) {
        //Task类有一个分数的概念（或者说是伪复杂度），其次是还有一个值可以为OPEN或CLOSED的状态.让我们引入一个Task的小集合
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );
        //所有状态为OPEN的任务一共有多少分数？在Java 8以前，一般的解决方式用foreach循环，但是在Java 8里面我们可以使用stream：一串支持连续、并行聚集操作的元素。
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println("Total points: " + totalPointsOfOpenTasks);


    }

}
