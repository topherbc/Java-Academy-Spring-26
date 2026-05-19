package com.pluralsight.genericslimited;

public class Demo {
    public static void main(String[] args) {
        PetCarrier<Dog> dogCarrier = new PetCarrier<>(3);

        dogCarrier.add(new Dog("Chief", 8, "Scottish Terrier"));


        System.out.println(dogCarrier);
        System.out.println("Average age: " + dogCarrier.getAverageAge() + " years");
        dogCarrier.makeAllSounds();

        Dog firstDog = dogCarrier.get(0);
        System.out.println("First dog's breed: " + firstDog.getBreed());
        System.out.println();


        PetCarrier<Cat> catCarrier = new PetCarrier<>(2);

        catCarrier.add(new Cat("Claire", 2, true));
        catCarrier.add(new Cat("Cherise", 2, false));


        System.out.println(catCarrier);
        catCarrier.makeAllSounds();


        Cat firstCat = catCarrier.get(0);
        System.out.println(firstCat.getName() + " is indoor: " + firstCat.isIndoor());
        System.out.println();


        PetCarrier<Bird> birdCarrier = new PetCarrier<>(3);

        birdCarrier.add(new Bird("Tweety", 1, false));
        birdCarrier.add(new Bird("Polly", 3, true));
        birdCarrier.add(new Bird("Baby", 15, true));

        System.out.println(birdCarrier);
        System.out.println("Number of birds: " + birdCarrier.size());
        System.out.println("Average age: " + birdCarrier.getAverageAge() + " years");
        birdCarrier.makeAllSounds();
        System.out.println();


        PetCarrier<Pet> mixedCarrier = new PetCarrier<>(5);

        mixedCarrier.add(new Dog("Rex", 6, "German Shepherd"));
        mixedCarrier.add(new Cat("Shadow", 3, false));
        mixedCarrier.add(new Bird("Chirpy", 2, true));
        mixedCarrier.add(new Dog("Luna", 4, "Husky"));

        System.out.println(mixedCarrier);
        System.out.println("Total pets: " + mixedCarrier.size());
        System.out.println("Average age: " + mixedCarrier.getAverageAge() + " years");
        mixedCarrier.makeAllSounds();
        System.out.println();



        //Does not work, Must extend from Pet class
//         PetCarrier<String> stringCarrier = new PetCarrier<>(2);
//         PetCarrier<Integer> intCarrier = new PetCarrier<>(2);


    }
}
