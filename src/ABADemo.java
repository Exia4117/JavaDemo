import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {  //版本号原子引用解决ABA问题
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(() ->{
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程\t" + atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());
        },"t2").start();

        TimeUnit.SECONDS.sleep(2);
        //ABA问题解决
        int stamp = atomicStampedReference.getStamp();
        new Thread(() ->{
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
        },"t3").start();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程\t" + atomicStampedReference.compareAndSet(100, 2019, stamp,stamp+1) + "\t" + atomicStampedReference.getStamp());
        },"t4").start();
    }

}
