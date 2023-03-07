package store;
import java.util.*;

public class Order {
    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<>();

    public Order(Customer customer){
        orderNumber = nextOrderNumber++;
        this.customer = customer;
    }
    public void addComputer(Computer computer){
        computers.add(computer);    
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Order " + orderNumber + " for " + customer.toString() + ")\n\n");

        int numComputers = computers.size();
        for(int i=0; i<numComputers; i++){
            Computer temp = computers.get(i);
            str.append(temp.toString());
        }
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
