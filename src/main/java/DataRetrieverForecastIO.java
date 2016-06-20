
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataRetrieverForecastIO extends DataRetriever {

    @Override
    public Map<String, double[]> getData(City city) {

        Map<String, double[]> dataMap = new HashMap<>();

        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormatCity = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat hourFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        // pętla po dniach
        for (int i = 0; i < 3; i++) {

            int hours;
            Date dataDate = cal.getTime();
            cal.add(Calendar.DATE, -1);
            String cityDate = dateFormatCity.format(dataDate);

            // sprawdzenie godzin w dniu
            double[] dataArray;
            if (i == 0) {
                hours = Integer.parseInt(hourFormat.format(date)) + 1;
                dataArray = new double[hours];
            } else {
                hours = 24;
                dataArray = new double[24];
            }

            String urlString = url + APIkey + "/" + city.latitude + "," + city.longitude
                    + "," + dateFormat1.format(dataDate) + "T" + dateFormat2.format(dataDate);

            try {
                URL dataURL = new URL(urlString);
                String data = loadDataString(dataURL);

                JSONObject obj = new JSONObject(data).getJSONObject("hourly");
                JSONArray array = obj.getJSONArray("data");

                for (int j = 0; j < hours; j++) {
                    JSONObject rowJSON = array.getJSONObject(j);
                    // sprawdzenie czasu pomiaru (unix)
                    Date tmpTime = new Date(rowJSON.getLong("time") * 1000);
                    // konwersja z Fahrenheit do Celcius
                    double temp = ((rowJSON.getDouble("temperature") - 32) * 0.5555);
                    // zaokrąglenie do 2 miejsc po przecinku i wpisanie do tablicy
                    dataArray[Integer.parseInt(hourFormat.format(tmpTime))] = new BigDecimal(temp)
                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
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

    public DataRetrieverForecastIO() {
        this.APIkey = "307117bb3bde2374dc23fca1d38b38bf";
        this.url = "https://api.forecast.io/forecast/";
    }

}
