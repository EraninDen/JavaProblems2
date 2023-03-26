
public class Runner {
    public static void main(String[] args) throws InterruptedException{

        for (int i = 0; i < 10; i++) {
            new Test().print();
            Thread.sleep(3000);
            System.out.println("________________________________" + (i + 1));

        }
    }
}