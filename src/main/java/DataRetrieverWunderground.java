
import java.io.IOException;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.*;
import org.json.*;

public class DataRetrieverWunderground extends DataRetriever {

    @Override
    public Map<String, double[]> getData(City city) {

        Map<String, double[]> dataMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        DateFormat dateFormatCity = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat hourFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        // pętla po dniach
        for (int i = 0; i < 3; i++) {

            Date dataDate = cal.getTime();
            cal.add(Calendar.DATE, -1);
            String cityDate = dateFormatCity.format(dataDate);

            // sprawdzenie godzin w dniu
            double[] dataArray;
            if (i == 0) {
                int hours = Integer.parseInt(hourFormat.format(date));
                dataArray = new double[hours + 1];
            } else {
                dataArray = new double[24];
            }

            String urlString = url + APIkey + "/history_" + dateFormat.format(dataDate) + "/q/" + city.name + ".json";

            try {
                URL dataURL = new URL(urlString);
                String data = loadDataString(dataURL);

                JSONObject obj = new JSONObject(data).getJSONObject("history");
                JSONArray array = obj.getJSONArray("observations");

                for (int j = 0; j < array.length(); j++) {
                    JSONObject rowJSON = array.getJSONObject(j);
                    dataArray[rowJSON.getJSONObject("date").getInt("hour")] = rowJSON.getDouble("tempm");
                }

                dataMap.put(cityDate, dataArray);

            } catch (MalformedURLException ex) {
                Logger.getLogger(DataRetrieverWunderground.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DataRetrieverWunderground.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dataMap;
    }

    @Override
    public City getCity(String cityName) {

        City city = new City();
        city.name = cityName;
        String urlString = url + APIkey + "/geolookup/q/" + cityName + ".json";
        try {
            URL dataURL = new URL(urlString);
            String data = loadDataString(dataURL);

            JSONObject obj = new JSONObject(data);
            city.latitude = obj.getJSONObject("location").getDouble("lat");
            city.longitude = obj.getJSONObject("location").getDouble("lon");
            city.country = obj.getJSONObject("location").getString("country_name");

        } catch (MalformedURLException ex) {
            // url carch
            Logger.getLogger(DataRetrieverWunderground.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Błędne miasto");
        } catch (IOException ex) {
            // data loading catch
            Logger.getLogger(DataRetrieverWunderground.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
    }

    public DataRetrieverWunderground() {
        this.APIkey = "9172ff1a9909a528";
        this.url = "http://api.wunderground.com/api/";
    }

}
