package dev.jdog.randomlocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Locations {
    private HashMap<String, Coordinates> locations = new HashMap<>();
//    private String[] locations = {"Phoenix", "Dallas", "San Francisco", "Seattle", "New York City", "Portland", "Tallahassee", "Quebec", "Ottawa", "London", "Paris", "Rome", "Madrid", "Berlin", "Moscow", "New Delhi", "Beijing", "Hong Kong", "Tokyo", "Wellington", "Sydney", "Rio de Janeiro", "Bogota", "Buenos Aires", "Lima", "Honolulu"};

    public Locations() {
        locations.put("Phoenix", new Coordinates(-22945, -6851));
        locations.put("Dallas", new Coordinates(-19824, -6709));
        locations.put("San Francisco", new Coordinates(-25067, -7720));
        locations.put("Seattle", new Coordinates(-25050, -9751));
        locations.put("New York City", new Coordinates(-15157, -8337));
        locations.put("Portland", new Coordinates(-25130, -9326));
        locations.put("Tallahassee", new Coordinates(-17261, -6234));
        locations.put("Quebec", new Coordinates(-14577, -9582));
        locations.put("Ottawa", new Coordinates(-15501, -9302));
        locations.put("London", new Coordinates(-16, -10547));
        locations.put("Paris", new Coordinates(494, -9994));
        locations.put("Rome", new Coordinates(2559, -8577));
        locations.put("Madrid", new Coordinates(-755, -8272));
        locations.put("Berlin", new Coordinates(2746, -10754));
        locations.put("Moscow", new Coordinates(7705, -11419));
        locations.put("New Delhi", new Coordinates(15818, -5860));
        locations.put("Beijing", new Coordinates(23841, -8169));
        locations.put("Hong Kong", new Coordinates(23382, -4563));
        locations.put("Tokyo", new Coordinates(28611, -7305));
        locations.put("Wellington", new Coordinates(35795, 8457));
        locations.put("Sydney", new Coordinates(30968, 6938));
        locations.put("Rio de Janeiro", new Coordinates(-8843, 4697));
        locations.put("Bogota", new Coordinates(-15168, -948));
        locations.put("Buenos Aires", new Coordinates(-11965, 7089));
        locations.put("Lima", new Coordinates(-15777, 2468));
        locations.put("Honolulu", new Coordinates(-32329, -4363));
    }


    public String random() {
        Random generator = new Random();
        Object[] names = locations.keySet().toArray();

        return (String) names[generator.nextInt(names.length)];
    }

    public Coordinates getCords(String name) {
        return locations.get(name); 
    }

    public ArrayList<String> getNames() {
        return new ArrayList<String>(locations.keySet());
    }
}
