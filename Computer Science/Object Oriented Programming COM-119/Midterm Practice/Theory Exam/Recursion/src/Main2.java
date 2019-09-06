public class Main2 {
    public static void main(String args[]) {
        Person person = new Person("John");
        Teacher teacher = new Teacher("Margaret");
        Student student = new Student("Jack");

        printInformation(person);
        printInformation(teacher);
        printInformation(student);
    }

    static void printInformation(Person person) {
        System.out.print(person.getName() + " ");
    }
}

class Person {
    protected String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Teacher extends Person {

    Teacher(String name) {
        super(name);
    }

    public String getName() {
        return "T:" + name;
    }
}

class Student extends Person {

    Student(String name) {
        super(name);
    }

    public String getName() {
        return "S:" + super.getName();
    }
}