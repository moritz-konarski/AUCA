public class t4 {
    public static void main(String[] args) {
        Object test = new Test() {
            @Override
            public void print() {
                System.out.println("Hello");
            }
        };
        ((Test)test).print();
    }

    interface Test {
        void print();
    }
}
