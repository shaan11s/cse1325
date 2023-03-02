package store;
import org.w3c.dom.NameList;

public class Option {
    String name;
    long cost;

    public Option(String name, long cost){
        this.name = name;

        if(cost < 0){
            throw new IllegalArgumentException("Invalid Cost");
        }
        this.cost = cost;
    
    }
    public long cost(){
    return cost;
    }
    @Override
    public String toString(){
    String optionString = name + "($" + cost/100.0 + ")";
    return optionString;
    }
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Option)){
            return false;
        }

        Option c = (Option) o;
        return (name.equals(c.name)) && (cost == c.cost);
    }
}
