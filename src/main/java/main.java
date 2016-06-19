
import java.util.HashMap;
import java.util.Map;


public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
        String n = "Warszawa";
        Map<String, double[]> dataMap = new HashMap<>();
        DataRetriever dr = new DataRetrieverWunderground();
        DataRetriever dr2 = new DataRetrieverForecastIO();
        City c = dr.getCity(n);
        dataMap = dr2.getData(c);
        System.out.println(c.toString());
        
    }
}
