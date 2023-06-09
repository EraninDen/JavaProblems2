package СomputerScienceProblemsJava.chapter1;

public class Fib4 {

    public static void main(String[] args) {
        System.out.println(fib4(9));
        System.out.println(fib4(5));
        System.out.println(fib4(40));
    }

    private static int fib4(int n) {
        int last = 0, next = 1;
        for (int i = 0; i < n; i++) {
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }
}
