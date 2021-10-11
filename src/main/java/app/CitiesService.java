package app;

import java.sql.SQLException;
public class CitiesService {

    public static void addCity(City city) throws SQLException {
        DBHelper.preparedStatement = DBHelper.connection.prepareStatement("INSERT INTO cities (id, name) VALUES (?, ?)");
        DBHelper.preparedStatement.setString(1, city.getId());
        DBHelper.preparedStatement.setString(2, city.getName());
        DBHelper.preparedStatement.executeUpdate();
        System.out.println(city.getName() + " was added");
        DBHelper.preparedStatement.close();

    }

    public static void addPopulationAndID(String name, int population) throws SQLException {
        DBHelper.preparedStatement = DBHelper.connection.prepareStatement("SELECT id FROM cities WHERE name LIKE (?)");
        DBHelper.preparedStatement.setString(1, name);
        DBHelper.resultSet = DBHelper.preparedStatement.executeQuery();
        String id = DBHelper.resultSet.getString("id");
        DBHelper.preparedStatement = DBHelper.connection.prepareStatement("INSERT INTO city_details (city_id ,population) VALUES (?,?)");
        DBHelper.preparedStatement.setString(1, id);
        DBHelper.preparedStatement.setInt(2, population);
        DBHelper.preparedStatement.executeUpdate();
        DBHelper.preparedStatement.close();
    }


    public static void consoleWriter() throws SQLException {
        DBHelper.preparedStatement = DBHelper.connection.prepareStatement("SELECT cities.name, city_details.population FROM cities JOIN city_details WHERE cities.id = city_details.city_id");
        DBHelper.resultSet = DBHelper.preparedStatement.executeQuery();

        while (DBHelper.resultSet.next()) {
            String name = DBHelper.resultSet.getString("name");
            int population = DBHelper.resultSet.getInt("population");
            System.out.println(name + " " + population);
        }
        DBHelper.preparedStatement.close();
        DBHelper.resultSet.close();
    }
}