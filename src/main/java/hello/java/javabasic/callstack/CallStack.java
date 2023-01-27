package hello.java.javabasic.callstack;

public class CallStack {
    public static void main(String[] args) {
        hello();
    }

    public static void hello() {
        bye();
    }

    public static void bye() {
        System.out.println("bye");
    }
}
