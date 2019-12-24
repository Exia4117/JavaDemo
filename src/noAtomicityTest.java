import java.util.concurrent.atomic.AtomicInteger;

public class noAtomicityTest {
    public volatile int n = 0;

    public void add(){
        n++;
    }

    AtomicInteger m = new AtomicInteger();

    public void addAto() {
        m.getAndIncrement();
    }
}

//普通n++的字节码
//0: aload_0
//1: dup
//2: getfield      #2                  // Field n:I
//5: iconst_1
//6: iadd
//7: putfield      #2                  // Field n:I
//10: return

//原子整型字节码
//0: aload_0
//1: getfield      #5                  // Field m:Ljava/util/concurrent/atomic/AtomicInteger;
//4: invokevirtual #6                  // Method java/util/concurrent/atomic/AtomicInteger.getAndIncrement:()I
//7: pop
//8: return