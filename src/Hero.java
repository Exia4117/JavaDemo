public class Hero {
    public String Name;

    public String getName() {
        return Name;
    }

    public float hp;
    public Hero(){

    }
    public Hero(String name){
        this.Name =name;
    }
    public String toString(){
        return Name;
    }
}
