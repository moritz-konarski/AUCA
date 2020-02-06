public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.setAction1(() -> System.out.print("Action 1! "));
        test.setAction2(e -> System.out.print(e + " "));
        System.out.println(test.setAction3(e -> e * 2));
    }

    void setAction1(T1 t) {
        t.m();
    }

    void setAction2(T2 t) {
        t.m(4.5);
    }

    double setAction3(T3 t) {
        return t.m(5.5);
    }
}

interface T1 {
    void m();
}

interface T2 {
    void m(Double d);
}

interface T3 {
    double m(Double d);
}
