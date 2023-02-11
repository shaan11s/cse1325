import java.util.ArrayList;
import java.util.Scanner;

public class Store{

    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<Product> shoppingCart = new ArrayList<Product>();
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        Taxed.setTaxRate(.0875);
        
        Product Milk = new Taxfree("Milk", 6.98);
        Product Eggs = new Taxfree("Eggs", 5.34);
        Product Cheese = new Taxfree("Cheese", 1.35);
        Product Coconut = new Taxfree("Coconut", 6.75);
        Product Takis = new Taxed("Takis", 2.75);
        Product Jerkey = new Taxed("Jerkey", 1.75);
        Product Cookies = new Taxed("Cookies", 4.55);

        products.add(Milk);
        products.add(Eggs);
        products.add(Cheese);
        products.add(Coconut);
        products.add(Takis);
        products.add(Jerkey);
        products.add(Cookies);

        double orderTotal = 0.00;

        while(true){
            System.out.println("===========================\n");
            System.out.println("==                       ==\n");
            System.out.println("== WELCOME TO THE BODEGA ==\n");
            System.out.println("==                       ==\n");
            System.out.println("== TODAYS DEALS BELOW!!! ==\n");
            System.out.println("==                       ==\n");
            System.out.println("== enter number of item  ==\n");
            System.out.println("==    to add to cart!    ==\n");
            System.out.println("==                       ==\n");
            System.out.println("==  negative # to leave  ==\n");
            System.out.println("==========================\n\n");

        
            //System.out.println(products);
            for(int i=0; i<products.size(); i++){
                System.out.printf("%d)  ", i+1);
                System.out.println(products.get(i));
                System.out.println("            ");
                //get the TAX price this way to truncate! 
                Product temp = products.get(i);
                double price = temp.price();
                System.out.printf("    $%.2f WITH TAX\n\n", price);
                System.out.println("\n");
            }

            System.out.println("\n\n== YOUR CART ==\n\n");
           
            for(int i=0; i<shoppingCart.size(); i++){
                System.out.printf("%d)  ", i+1);
                System.out.println(shoppingCart.get(i));
                System.out.println("            ");
                //get the TAX price this way to truncate! 
                Product temp = shoppingCart.get(i);
                double price = temp.price();
                System.out.printf("    $%.2f WITH TAX\n\n", price);
                System.out.println("\n");
            }

            System.out.printf("ORDER TOTAL %.2f", orderTotal);
            System.out.println("\n\n");


            //here is error checking and loop exit NEED TO TRY CATCH PROPERLY
            //here is error checking and loop exit NEED TO TRY CATCH PROPERLY
            String input = myScanner.nextLine();


            int inputInt = Integer.parseInt(input);
            if(inputInt < 0){
                System.out.println("COME BACK SOON!");
                myScanner.close();
                System.exit(0);
            }
            //here is error checking and loop exit NEED TO TRY CATCH PROPERLY
            //here is error checking and loop exit NEED TO TRY CATCH PROPERLY



            if(input.equals("1")){
                shoppingCart.add(Milk);
                orderTotal+=Milk.price();
            }
            if(input.equals("2")){
                shoppingCart.add(Eggs);
                orderTotal+=Eggs.price();
            }
            if(input.equals("3")){
                shoppingCart.add(Cheese);
                orderTotal+=Cheese.price();
            }
            if(input.equals("4")){
                shoppingCart.add(Coconut);
                orderTotal+=Coconut.price();
            }
            if(input.equals("5")){
                shoppingCart.add(Takis);
                orderTotal+=Takis.price();
            }
            if(input.equals("6")){
                shoppingCart.add(Jerkey);
                orderTotal+=Jerkey.price();
            }
            if(input.equals("7")){
                shoppingCart.add(Cookies);
                orderTotal+=Cookies.price();
            }
        }
    }
}

