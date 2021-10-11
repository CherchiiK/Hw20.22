package app;

import java.util.Scanner;
import java.util.UUID;

public class City {
    private final String id;
    private final String name;

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static City createCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter name for your city:  ");
        String name = scanner.nextLine();
        return new City(UUID.randomUUID().toString(), name);
    }

    public static int informationForAddingPopulation(City city) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, add a number of population for " + city.getName());
        return scanner.nextInt();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
