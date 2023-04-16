package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class Order {
    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<>();

    public long cost(){
        //go through computers
        long cost = 0;
        for(int i=0; i<computers.size(); i++){
            //get computer from arraylist
            Computer tempComputer = computers.get(i);
            //add its cost to the total order cost
            cost += tempComputer.cost();
        }
        return cost;
    }

    public Order(Customer customer){
        orderNumber = nextOrderNumber++;
        this.customer = customer;
    }
    public void addComputer(Computer computer){
        computers.add(computer);    
    }
    public Order(BufferedReader br){

    }
    public void Save(BufferedWriter bw){

    }

    // public void save(BufferedWriter bw) throws IOException{
    //     bw.write((int) (orderNumber + '\n'));
    //     bw.write(customer.save(bw) + '\n');
    //     bw.write(computers.save(bw) + '\n');
    // }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        
        str.append("Order " + (orderNumber+1) + " for " + customer.toString() + ")\n\n");

        int numComputers = computers.size();
        for(int i=0; i<numComputers; i++){
            Computer temp = computers.get(i);
            str.append(temp.toString());
        }
        //add the cost to tostring
        str.append(" Total Cost " +  cost());
        String str2 = str.toString();
        return str2;
    }
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Order)){
            return false;
        }

        Order temp = (Order) o;
      if(!(this.customer.equals(temp.customer))){
          return false;
      }
      int arrSize1 = computers.size();
      int arrSize2 = temp.computers.size();
      if(!(arrSize1 == arrSize2)){
          return false;
      }
      for(int i=0; i<arrSize1; i++){
        Computer tempComp = computers.get(i);
        Computer tempComp2 = computers.get(i);
        if(tempComp != tempComp2){
            return false;
        }
      }
      return true;

    }
}
