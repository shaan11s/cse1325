package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Computer {
    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<>();

    public Computer(String name, String model){
        this.name = name;
        this.model = model;
    }
    public Computer(BufferedReader br) throws IOException{
        this.name = br.readLine();
        this.model = br.readLine();
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) options.add(new Option(br));
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write(model + '\n');
        bw.write("" + options.size() + '\n');
        for(Option option : options) option.save(bw);
    }
    public void addOption(Option option){
        options.add(option);
    }
    public long cost(){
        int sizeOfOptions = options.size();
        long sum = 0;
        for(int i=0; i<sizeOfOptions; i++){
            Option temp = options.get(i);
            sum += temp.cost;
        }
        return sum;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append( name + " (" + model + ")\n");

        int sizeOfOptions = options.size();
        for(int i=0; i<sizeOfOptions; i++){
            Option temp = options.get(i);
            str.append("    " + temp.name + " ($");
            str.append(temp.cost +")\n");
        }

        String str2 = str.toString();
        return str2;

    }
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Computer)){
            return false;
        }

        Computer c = (Computer) o;
        String one = c.toString();
        String two = this.toString();
        return (one.equals(two));
    }
}
