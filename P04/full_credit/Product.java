public abstract class Product{

    protected double cost;
    protected String name;

    public Product(String name, double cost)throws RuntimeException{

        this.name = name;
        this.cost = cost;

        if(cost <0){
            throw new RuntimeException("Cost must be a positive integer.");
        }

    }

    public abstract double price();

    @Override
    public String toString(){
        return (name + " ($" + cost + ")");
    }

}




