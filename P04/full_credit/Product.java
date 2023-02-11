public abstract class Product{

    protected double cost;
    protected String name;

    public Product(String name, double cost){

        this.name = name;

        try{
            this.cost = cost;
        }catch(RuntimeException e){
        System.out.println("Cost can not be negative.");
        }

    }

    public abstract double price();

    @Override
    public String toString(){
        return (name + " (" + cost + ") " + price());
    }

}




