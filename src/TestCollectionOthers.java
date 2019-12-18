import java.util.*;

public class TestCollectionOthers {
    public void testCollectionOthers() {
        //LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll = new LinkedList<Hero>();

        //所以可以很方便的在头部和尾部插入数据
        //在最后插入新的英雄
        ll.addLast(new Hero("hero1"));
        ll.addLast(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);

        //在最前面插入新的英雄
        ll.addFirst(new Hero("heroX"));
        System.out.println(ll);

        //查看最前面的英雄
        System.out.println(ll.getFirst());
        //查看最后面的英雄
        System.out.println(ll.getLast());

        //查看不会导致英雄被删除
        System.out.println(ll);
        //取出最前面的英雄
        System.out.println(ll.removeFirst());

        //取出最后面的英雄
        System.out.println(ll.removeLast());

        //取出会导致英雄被删除
        System.out.println(ll);

        Queue<Hero> q = new LinkedList<>();
        q.offer(new Hero("hero1"));
        q.offer(new Hero("hero2"));
        q.offer(new Hero("hero3"));
        q.offer(new Hero("hero4"));
        System.out.println(q);
        Hero h = q.poll();
        System.out.println(h);
        System.out.println(q);

        HashMap<String,String> dictionary = new HashMap<>();
        dictionary.put("adc","wuli");
        dictionary.put("apc","mofa");
        dictionary.put("t","tank");

        System.out.println(dictionary.get("t"));

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
        Collections.reverse(numbers);
        System.out.println("反转"+numbers);
        Collections.shuffle(numbers);
        System.out.println("乱序"+numbers);
        Collections.sort(numbers);
        System.out.println("排序"+numbers);
        Collections.swap(numbers,0,5);
        System.out.println("交换0和5"+numbers);
        Collections.rotate(numbers,2);
        System.out.println("向右滚动2单位"+numbers);

    }
}
