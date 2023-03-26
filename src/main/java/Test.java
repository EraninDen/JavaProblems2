import java.util.concurrent.CompletableFuture;


public class Test {
    private Object lock = new Object();

    public void print() throws InterruptedException {

        CompletableFuture.runAsync(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Hello1 started");
                    Thread.sleep(10000);
                    System.out.println("Hello1 finished");
                    int i = 1/0;
                } catch (InterruptedException e) {
                    System.out.println("AAAAAAAAAAAAAAA");
                    e.printStackTrace();
                }
                System.out.println("1");
            }
        });

        //Этот sleep технический - не обращать внимание!!!
        System.out.println("before tech sleep");
        Thread.sleep(100);
        System.out.println("after tech sleep");

        lock = new Object();

        CompletableFuture.runAsync(()-> {
            synchronized (lock){
                System.out.println("Hello2 started");
                System.out.println("2");
                System.out.println("Hello2 finished");
            }
        });
    }

}
