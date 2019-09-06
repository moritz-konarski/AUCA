public class n24 {
    public static void main(String[] args) {
        new WithImplementation() {}.printMe();
    }
}

//An interface with a default method and no
//  'abstract' or 'public' modifiers
interface WithImplementation {
    default void printMe() {
        System.out.println("-----\nsome default text\n-----");
    }
}
