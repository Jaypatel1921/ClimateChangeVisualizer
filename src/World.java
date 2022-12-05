package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * A World class. The World class contains a Hashmap of Countries.
 **/
public class World {

    /**
     * Hashmap which contains a countries name, and it's respective Country object.
     */
    HashMap<String, Country> Countries;

    /**
     * Main method of the program, initializes the Countries Hashmap.
     */
    public World() {
        Countries = new HashMap<>();
        constructorHelper();
    }

    /**
     * Helper method for the constructor, goes through the .csv file containing CO2-Emissions for all countries
     * and updates the Countries hashmap accordingly.
     */
    private void constructorHelper() {
        String filename = "src/CO2-Emissions.csv";
        String line = "";
        String[] tempArr;
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(filename));
            StringBuffer sb = new StringBuffer();
            // loops through the first five lines of the csv file, which do not contain countries.
            for (int i = 0; i < 5; i++){
                br.readLine();
            }
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                try {
                    Countries.put(tempArr[0].replaceAll("\"", ""), new Country(tempArr[0].replaceAll("\"", ""),
                            Double.parseDouble(tempArr[63].replaceAll("\"", ""))));
                }
                catch (NumberFormatException e){
                    Countries.put(tempArr[0].replaceAll("\"", ""), new Country(tempArr[0].replaceAll("\"", ""),
                            0.0));
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}