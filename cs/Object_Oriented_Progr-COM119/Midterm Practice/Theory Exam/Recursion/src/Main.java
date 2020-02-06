import java.util.Scanner;

class Node {
    private Node next;
    private Object data;

//    Node() {
//        this(null, null);
//    }

    Node(Object data) {
        this(null, data);
    }

    private Node(Node next, Object data) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 2 3 4 5 6 7");
        Node listRoot = readNumbers(scanner);
        printNumbers(listRoot);
    }

    public static Node readNumbers(Scanner scanner) {
        Node root = null;
        if (scanner.hasNextInt()) {
            root = new Node(scanner.nextInt());
        }
        Node current = root;
        while (scanner.hasNextInt()) {
            current.setNext(new Node(scanner.nextInt()));
            current = current.getNext();
        }
        return root;
    }

    public static void printNumbers(Node node) {
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }
}