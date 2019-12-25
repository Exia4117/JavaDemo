import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zhangsan = new User("zhangsan",18);
        User lisi = new User("lisi",28);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zhangsan);
        System.out.println(atomicReference.compareAndSet(zhangsan,lisi) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zhangsan,lisi) + "\t" + atomicReference.get().toString());
    }

}

class User{
    String userName;
    int age;
    User(String name,int age){
        this.userName = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.userName;
    }
}