public class Pet {
    //attributes or fields
    private String name;
    private double age;
    private Type type;

    //methods (public)
    public Pet(String name, double age, Type type){
        this.name = name;
        this.age = age;
        this.type = type;
    }
    @Override
    public String toString(){
        return name + " is a " + type + " age " + age;
    }
}