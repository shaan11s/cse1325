package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class Customer implements Comparable<Customer>,Saveable{
    private String name;
    private String email;

    public Customer(String name, String email){
        this.name = name;

        //Data Validation
        int emailCheck = email.indexOf("@");
        int emailCheck2 = email.indexOf(".");

        //optimized to not short cirucit!
        if(emailCheck < 0 || emailCheck2 <0){
            throw new IllegalArgumentException("Email is invalid");
        }
        this.email = email;
    }
    public Customer(BufferedReader br) throws IOException{
        this.name = br.readLine();
        this.email = br.readLine();
    }
    @Override
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write(email + '\n');
    }

    @Override
    public String toString(){
        String temp = "Customer: " + name + " email: " + email;
        return temp;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Customer)){
            return false;
        }

        Customer c = (Customer) o;
        return (name.equals(c.name)) && (email.equals(c.email));

    }

    @Override
    public int hashCode(){
        return Objects.hash(name + email);
    }
    @Override
    public int compareTo(Customer o) {
        String compare1 = this.name.toLowerCase();
        String compare2 = o.name.toLowerCase();

        String compareEmail1 = this.email.toLowerCase();
        String compareEmail2 = o.email.toLowerCase();

        if (compare1.charAt(0) > compare2.charAt(0)){
            return 1;
        }
        if (compare1.charAt(0) < compare2.charAt(0)){
            return -1;
        }
        if (compare1.charAt(0) == compare2.charAt(0)){

            if (compareEmail1.charAt(0) > compareEmail2.charAt(0)){
                return 1;
            }
            if (compareEmail1.charAt(0) < compareEmail2.charAt(0)){
                return -1;
            }
        }

        return 0;

        //throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
