package app;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//Create new City objects
        City city1 = City.createCity();
        City city2 = City.createCity();
        City city3 = City.createCity();
//Connecting to DB, set Statement and prepare for adding a unique City`s object
        DBHelper.connectionWithDB();
        DBHelper.clearTable();
// Add new city in our table
        CitiesService.addCity(city1);
        CitiesService.addCity(city2);
        CitiesService.addCity(city3);
//Copy of ID field from cities and add population
        CitiesService.addPopulationAndID(city1.getName(), City.informationForAddingPopulation(city1));
        CitiesService.addPopulationAndID(city2.getName(), City.informationForAddingPopulation(city2));
        CitiesService.addPopulationAndID(city3.getName(), City.informationForAddingPopulation(city3));
// Print Select with Join
        CitiesService.consoleWriter();
    }
}