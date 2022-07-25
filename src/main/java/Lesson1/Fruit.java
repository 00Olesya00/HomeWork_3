package Lesson1;

public class Fruit<E extends Number> {

        public static void main(String[] args) {
           Fruit<Integer> AppleFruit = new Fruit<>(1);
            Fruit<Double> OrangeFruit = new Fruit<>(1.5);

            System.out.println(((Fruit<?>) AppleFruit).sum());
            System.out.println(OrangeFruit.sum());
            System.out.println(AppleFruit.isSumEquals(OrangeFruit));

        }

        private boolean isSumEquals(Fruit<?> fruit) {
            return Math.abs(fruit.sum() - this.sum()) < 1.5;
        }
        private E[] nums;

        public Fruit(E... nums) {
            this.nums = nums;
        }

        public double sum() {
            double sum = 0;
            for (E num : nums) {
                sum += num.doubleValue();
            }

            return sum;
        }
    }

