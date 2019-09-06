import java.util.ArrayList;

class Task3 {
    public static void main(String[] args) {
        int iterations = 10;
        double[] timeResult;
        double total1 = 0, total2 = 0, total3 = 0;
        try {
            for (int i = 0; i < iterations; i++) {
                System.out.printf("Case %d%n", i + 1);
                timeResult = ultimateTest(500);
                total1 += timeResult[0];
                total2 += timeResult[1];
                total3 += timeResult[2];
                System.out.println();
            }
            System.out.println("Total Average Results:");
            System.err.printf("\tFirst Version:\t%7.3f micro seconds%n", total1 / iterations);
            System.err.printf("\tSecond Version:\t%7.3f micro seconds%n", total2 / iterations);
            System.err.printf("\tJava Version:\t%7.3f micro seconds%n", total3 / iterations);
            //visualTest();
        } catch (IndexOutOfBoundsException e) {
            System.err.printf("An error occurred: %s%n", e.getMessage());
            System.exit(-1);
        }
    }

    private static double[] ultimateTest(int iterations) throws IndexOutOfBoundsException {
        Timing timer1 = new Timing();
        ArrayListInt list1 = new ArrayListInt();
        Timing timer2 = new Timing();
        ArrayListIntV2 list2 = new ArrayListIntV2();
        Timing timer3 = new Timing();
        ArrayList<Integer> list3 = new ArrayList<>();
        double total1 = 0, total2 = 0, total3 = 0;

        for (int i = 0; i < iterations; i++) {
            double time1 = 0, time2 = 0, time3 = 0;
            //######Case 0#######
            // Test the java class
            test(list3);
            list3.clear();
            // Test the second version
            test(list2);
            list2.clear();
            // Test my first Version
            test(list1);
            list1.clear();

            //######Case 1#######
            // Test the java class
            timer3.startTimer();
            test(list3);
            timer3.stopTimer();
            list3.clear();
            time3 += timer3.getTime();
            // Test the second version
            timer2.startTimer();
            test(list2);
            timer2.stopTimer();
            list2.clear();
            time2 += timer2.getTime();
            // Test my first Version
            timer1.startTimer();
            test(list1);
            timer1.stopTimer();
            list1.clear();
            time1 += timer1.getTime();

            //######Case 2#######
            // Test the java class
            timer3.startTimer();
            test(list3);
            timer3.stopTimer();
            list3.clear();
            time3 += timer3.getTime();
            // Test my first Version
            timer1.startTimer();
            test(list1);
            timer1.stopTimer();
            list1.clear();
            time1 += timer1.getTime();
            // Test the second version
            timer2.startTimer();
            test(list2);
            timer2.stopTimer();
            list2.clear();
            time2 += timer2.getTime();

            //######Case 3#######
            // Test my first Version
            timer1.startTimer();
            test(list1);
            timer1.stopTimer();
            list1.clear();
            time1 += timer1.getTime();
            // Test the second version
            timer2.startTimer();
            test(list2);
            timer2.stopTimer();
            list2.clear();
            time2 += timer2.getTime();
            // Test the java class
            timer3.startTimer();
            test(list3);
            timer3.stopTimer();
            list3.clear();
            time3 += timer3.getTime();

            //######Case 4#######
            // Test my first Version
            timer1.startTimer();
            test(list1);
            timer1.stopTimer();
            list1.clear();
            time1 += timer1.getTime();
            // Test the java class
            timer3.startTimer();
            test(list3);
            timer3.stopTimer();
            list3.clear();
            time3 += timer3.getTime();
            // Test the second version
            timer2.startTimer();
            test(list2);
            timer2.stopTimer();
            list2.clear();
            time2 += timer2.getTime();

            //######Case 5#######
            // Test the second version
            timer2.startTimer();
            test(list2);
            timer2.stopTimer();
            list2.clear();
            time2 += timer2.getTime();
            // Test my first Version
            timer1.startTimer();
            test(list1);
            timer1.stopTimer();
            list1.clear();
            time1 += timer1.getTime();
            // Test the java class
            timer3.startTimer();
            test(list3);
            timer3.stopTimer();
            list3.clear();
            time3 += timer3.getTime();

            //######Case 6#######
            // Test the second version
            timer2.startTimer();
            test(list2);
            timer2.stopTimer();
            list2.clear();
            time2 += timer2.getTime();
            // Test the java class
            timer3.startTimer();
            test(list3);
            timer3.stopTimer();
            list3.clear();
            time3 += timer3.getTime();
            // Test my first Version
            timer1.startTimer();
            test(list1);
            timer1.stopTimer();
            list1.clear();
            time1 += timer1.getTime();

            // add the time up.
            total1 += time1 / iterations / 6;
            total2 += time2 / iterations / 6;
            total3 += time3 / iterations / 6;

        }
        // Output the results.
        System.err.printf("\tFirst Version:\t%7.3f micro seconds%n", total1);
        System.err.printf("\tSecond Version:\t%7.3f micro seconds%n", total2);
        System.err.printf("\tJava Version:\t%7.3f micro seconds%n", total3);
        return new double[]{total1, total2, total3};
    }

    private static void test(ArrayListInt list) throws IndexOutOfBoundsException {
        for (int i = 0; i < 10000; i += 7) {
            list.add(i);
        }
        for (int i = 2; i < 1000; i += 12) {
            list.add(i, i * i);
        }
        for (int i = 2; i < 1000; i += 5) {
            list.remove(i);
        }
        for (int i = 2; i < 1000; i += 3) {
            list.set(i, i * i * i);
        }
    }

    private static void test(ArrayListIntV2 list) throws IndexOutOfBoundsException {
        for (int i = 0; i < 10000; i += 7) {
            list.add(i);
        }
        for (int i = 2; i < 1000; i += 12) {
            list.add(i, i * i);
        }
        for (int i = 2; i < 1000; i += 5) {
            list.remove(i);
        }
        for (int i = 2; i < 1000; i += 3) {
            list.set(i, i * i * i);
        }
    }

    private static void test(ArrayList<Integer> list) {
        for (int i = 0; i < 10000; i += 7) {
            list.add(i);
        }
        for (int i = 2; i < 1000; i += 12) {
            list.add(i, i * i);
        }
        for (int i = 2; i < 1000; i += 5) {
            list.remove(i);
        }
        for (int i = 2; i < 1000; i += 3) {
            list.set(i, i * i * i);
        }
    }

    private static void visualTest() throws IndexOutOfBoundsException {
        ArrayListIntV2 list = new ArrayListIntV2();
        list.add(12);
        System.err.println("list.add(12)");
        list.add(9);
        System.err.println("list.add(9)");
        list.add(3);
        System.err.println("list.add(3)");
        list.add(100);
        System.err.println("list.add(100)");
        System.out.println(list.toString());
        System.err.println("list.add(4, 99)");
        list.add(4, 99);
        System.out.println(list.toString());
        System.err.println("list.add(-2)");
        list.add(-2);
        System.out.println(list.toString());
        System.err.println("list.get(5)");
        System.out.println(list.get(5));
        System.out.println(list.toString());
        System.err.println("list.size()");
        System.out.println(list.size());
        System.err.println("list.remove(0)");
        list.remove(0);
        System.out.println(list.toString());
        System.err.println("list.size()");
        System.out.println(list.size());
        System.err.println("list.remove(0)");
        list.remove(0);
        System.out.println(list.toString());
        System.err.println("list.size()");
        System.out.println(list.size());
        System.err.println("list.set(0, 22)");
        list.set(0, 22);
        System.out.println(list.toString());
        System.err.println("list.size()");
        System.out.println(list.size());
    }
}
