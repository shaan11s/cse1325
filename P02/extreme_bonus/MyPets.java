
import java.util.Scanner;

public class MyPets {
    public static void main(String[] args){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Amount of Pets!");
            int size = scanner.nextInt();
            scanner.nextLine();
            Pet[] petsArr = new Pet[size];

            for(int i=0; i<petsArr.length; i++){
                System.out.println("Enter your pets name!");
                String tempName = scanner.nextLine();
                System.out.println("Enter your pets age!");
                int tempAge = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter your pets type! [BIRD, DOG, CAT, FISH]");
                String tempType = scanner.nextLine();

                Type tester = Type.valueOf(tempType);

                Pet temp = new Pet(tempName, tempAge, tester);
                petsArr[i]=temp;

            }
            // Pet p1 = new Pet("edge", 20, Type.BIRD);
            // Pet p2 = new Pet("scrap", 9, Type.DOG);
            // Pet p3 = new Pet("uzi", 5, Type.CAT);
            // Pet p4 = new Pet("oscar", 2, Type.FISH);

            // Pet[] allPets = {p1, p2, p3, p4};

            for(Pet m : petsArr) {
                System.out.println(m);
            }
            scanner.close();
    }
    
}
