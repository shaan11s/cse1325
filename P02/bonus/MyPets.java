public class MyPets {
    public static void main(String[] args){

            Pet p1 = new Pet("edge", 20, Type.BIRD);
            Pet p2 = new Pet("scrap", 9, Type.DOG);
            Pet p3 = new Pet("uzi", 5, Type.CAT);
            Pet p4 = new Pet("oscar", 2, Type.FISH);

            Pet[] allPets = {p1, p2, p3, p4};

            for(Pet m : allPets) {
                System.out.println(m);
            }

    }
}
