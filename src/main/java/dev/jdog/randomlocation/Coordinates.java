package dev.jdog.randomlocation;

public class Coordinates {
    private Integer lat;
    private Integer lon;

    public Coordinates(Integer lat, Integer lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Integer getLat() {
        return lat;
    }

    public Integer getLon() {
        return lon;
    }
}
