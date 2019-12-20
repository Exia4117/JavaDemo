import java.util.concurrent.TimeUnit;

class Obj {
    public volatile int number = 0;

    public void ADDTO60() {
        number = 60;
    }

    public void ADDPlusPlus() {
        number++;
    }
}

public class JUC_Demo {

    public static void main(String[] args) {
//        seeOKByVolatile();
        noAtomicity();
    }

    //volatile无法保证原子性
    public static void noAtomicity() {
        Obj demo = new Obj();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.ADDPlusPlus();
                }
            }, String.valueOf(i)).start();

        }
        //如果当前活跃线程数 > 2（主线程和gc线程），表示还没有算完，将CPU让给计算线程，直至算完
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\tfinally the number is \t" + demo.number);
    }

    //volatile可以保证可见性，及时通知其他线程，主内存的变量已经被修改
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


