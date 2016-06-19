
import java.util.HashMap;
import java.util.Map;



public class City {
    
    String name;
    String country;
    double longitude;
    double latitude;
    
    Map<String, double[]> temperatureData;

    @Override
    public String toString() {
        return "City{" + "name=" + name + ", country=" + country + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
    
    public City() {
        this.name = "";
        this.country = "";
        this.longitude = 0;
        this.latitude = 0;
        this.temperatureData = new HashMap<>();
    }

    public City(String name, String country, double longitude, double latitude) {
        this.name = name;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperatureData = new HashMap<>();
    }
    
    
}
