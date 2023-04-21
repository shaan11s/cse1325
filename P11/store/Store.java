package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Store {
    public Store(String name) {
        this.name = name;
    }
    public String name() {
        return this.name;
    }
    public Store(BufferedReader br) throws IOException{
        //get name of store
        this.name = br.readLine();

        //get number of options
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) options.add(new Option(br));
        //get number of computers
        size = Integer.parseInt(br.readLine());
        while(size-- > 0) computers.add(new Computer(br));
        //get number of customrs
        size = Integer.parseInt(br.readLine());
        while(size-- > 0) customers.add(new Customer(br));

        //read that many options
        //HERE HERE
        size = Integer.parseInt(br.readLine());
        while(size-- > 0) orders.add(new Order(br));
        //read the number on next line, repeat for that array.
    }
    public void Save(BufferedWriter bw) throws IOException{

        Save(bw, options);
        Save(bw, computers);
        Save(bw, customers);
        Save(bw, orders);

        // bw.write(name + '\n');

        // bw.write("" + options.size() + '\n');
        // for(Option option : options) option.save(bw);

        // bw.write("" + computers.size() + '\n');
        // for(Computer computers : computers) computers.save(bw);

        // bw.write("" + customers.size() + '\n');
        // for(Customer customers : customers) customers.save(bw);

        // bw.write("" + orders.size() + '\n');
        // for(Order orders : orders) orders.save(bw);

    }

    private <T extends Saveable> void Save(BufferedWriter bw, Set set) throws IOException{
        bw.write(name + '\n');

        bw.write("" + options.size() + '\n');
        for(Option option : options) option.save(bw);

        bw.write("" + computers.size() + '\n');
        for(Computer computers : computers) computers.save(bw);

        bw.write("" + customers.size() + '\n');
        for(Customer customers : customers) customers.save(bw);

        bw.write("" + orders.size() + '\n');
        for(Order orders : orders) orders.save(bw);
    }

    // ///////////////////////////////////////////////////////////
    // Customers
    
    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Options
    
    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() {
        return this.options.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Computers
    
    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() {
        return this.computers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Orders
    
    public void add(Order order) {
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {
        return this.orders.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Fields
    
    private String name;
    private TreeSet<Customer> customers = new TreeSet<>();
    private HashSet<Option> options = new HashSet<>();
    private HashSet<Computer> computers = new HashSet<>();
    private HashSet<Order> orders = new HashSet<>();
}
