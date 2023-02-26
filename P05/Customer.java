public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email){
        this.name = name;

        //Data Validation
        int emailCheck = email.indexOf("@");
        int emailCheck2 = email.indexOf(".");

        if(emailCheck < 0 && emailCheck2 <0){
            throw new IllegalArgumentException("Email is invalid");
        }
        this.email = email;
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
}
