package СomputerScienceProblemsJava.chapter1;

import java.util.Stack;

public class Hanoi {

    private final int numDisc;
    public final Stack<Integer> towerA = new Stack<>();
    public final Stack<Integer> towerB = new Stack<>();
    public final Stack<Integer> towerC = new Stack<>();

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(32);
        hanoi.solve();
        System.out.println(hanoi.towerA);
        System.out.println(hanoi.towerB);
        System.out.println(hanoi.towerC);
    }

    public Hanoi(int discs) {
        numDisc = discs;
        for (int i = 1; i <= discs; i++) {
            towerA.push(i);
        }
    }

    private void move(Stack<Integer> begin, Stack<Integer> end, Stack<Integer> temp, int n) {
        if (n == 1) {
            end.push(begin.pop());
        } else {
            move(begin, temp, end, n-1);
            move(begin, end, temp, 1);
            move(temp, end, begin, n-1);
        }
    }

    public void solve() {
        move(towerA, towerC, towerB, numDisc);
    }
}
