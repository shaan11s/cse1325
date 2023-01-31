public class Pet {
    //attributes or fields
    private String name;
    private double age;
    private Type type;
    public static final double humanLifespan = 80;

    //methods (public)
    public Pet(String name, double age, Type type){
        this.name = name;
        this.age = age;
        this.type = type;
    }

    //human age method
    public double humanAge(){
    double humanAge = humanLifespan * age / type.lifespan();
    return humanAge;
    }


    @Override
    public String toString(){
        return name + " is a " + type + " age " + age + " or " + humanAge() + " in human-equivalent years.";
    }
}