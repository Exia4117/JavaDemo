import java.util.concurrent.TimeUnit;

class Obj {
    public volatile int number = 0;

    public void ADDTO60() {
        number = 60;
    }
}

public class JUC_Demo {

    public static void main(String[] args) {
        seeOKByVolatile();
    }

    public static void seeOKByVolatile() {
        Obj demo = new Obj();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\tcome in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.ADDTO60();
            System.out.println(Thread.currentThread().getName() + "\tupdate number value\t" + demo.number);
        }, "AAA").start();


        while (demo.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\tmission over \t main thread get number\t" + demo.number);
    }
}


