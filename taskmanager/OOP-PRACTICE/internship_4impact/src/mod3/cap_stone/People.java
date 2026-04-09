package mod3.cap_stone;

public abstract class People {
    private String name;

    public People(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + ": " + name;
    }
}

