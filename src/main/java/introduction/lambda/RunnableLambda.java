package introduction.lambda;

public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {

        //Classic Way
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello World from Thread [" + Thread.currentThread().getName() + "-" + i + "]");
                }
            }
        };

        //Lambda Way
        Runnable runnableLambda = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Hello World from Thread [" + Thread.currentThread().getName() + "-" + i + "]");
            }
        };

        Thread t = new Thread(runnableLambda);
        t.start();
        t.join();
    }
}
