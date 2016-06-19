
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataRetriever {

    protected String APIkey;
    protected String url;

    public Map<String, double[]> getData(City city) {
        
        

        return new HashMap<> ();
    }

    public City getCity(String cityName) {

        return new City();
    }

    public String loadDataString(URL url) throws IOException {

        Scanner scan = new Scanner(url.openStream());
        String dataString = new String();
        while (scan.hasNext()) {
            dataString += scan.nextLine();
        }
        scan.close();
        return dataString;
    }

}
