import java.util.ArrayList;
import java.util.Iterator;

public class TestCollection {
    public void testCollection() {
        ArrayList<Hero> heros = new ArrayList<>();
        heros.add(new Hero("gaylun"));
        System.out.println(heros.size());
        heros.add(new Hero("timo"));
        System.out.println(heros.size());
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i));

        }
        System.out.println(heros);

        Hero specialHero = new Hero("spe hero");
        heros.add(3, specialHero);
        System.out.println(heros.toString());
        System.out.println("special hero pos" + heros.indexOf(specialHero));
        Hero zeroHero = new Hero("zero hero");
        heros.add(0, zeroHero);
        System.out.println(heros.indexOf(zeroHero));
        System.out.println(heros);
        heros.remove(0);
        System.out.println(heros);
        System.out.println(heros.size());
        heros.remove(zeroHero);
        System.out.println(heros);
        System.out.println(heros.size());
        ArrayList<Hero> AnotherHeros = new ArrayList<>();
        for (Object i : heros
        ) {
            AnotherHeros.add(new Hero("hero" + i));
        }
        AnotherHeros.addAll(heros);
        System.out.println(AnotherHeros);
        heros.clear();
        System.out.println(heros);
        for (int i = 0; i < AnotherHeros.size(); i++) {
            Hero h = AnotherHeros.get(i);
            System.out.println(h);

        }
        Iterator<Hero> it = AnotherHeros.iterator();
        while(it.hasNext()){
            System.out.println(" ");
            Hero h = it.next();
            System.out.println(h);
        }
        for(Iterator<Hero> iterator = AnotherHeros.iterator();iterator.hasNext();){
            System.out.println("1");
            Hero hero = iterator.next();
            System.out.println(hero);
        }
        for (Hero h:AnotherHeros
        ) {
            System.out.println(h);
        }
    }
}
