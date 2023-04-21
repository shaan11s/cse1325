package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

//import org.w3c.dom.NameList;

public class Option implements Saveable {
    String name;
    long cost;

    public Option(String name, long cost){
        this.name = name;

        if(cost < 0){
            throw new IllegalArgumentException("Invalid Cost");
        }
        this.cost = cost;
    
    }
    public Option(BufferedReader br) throws IOException{
        this.name = br.readLine();
        this.cost = Long.parseLong(br.readLine());
    }
    @Override
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write(""+ cost + '\n');
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
    @Override
    public int hashCode(){
        return Objects.hash(name + cost);
    }
}
