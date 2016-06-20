
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataSaver {

    String filename;

    void saveData(List<City> cityList) throws FileNotFoundException {

        // utworzenie pliku
        PrintWriter out = new PrintWriter(filename);

        for (int i = 0; i < cityList.size(); i++) {

            City city = cityList.get(i);
            Map<String, double[]> dataMap = city.temperatureData;
            String cityName = city.name;
            // nazwa miasta - zapis
            out.println(cityName);

            Set<String> keySet = dataMap.keySet();
            String key;
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                String s = "";

                key = it.next();
                out.println("Data: " + key);
                out.print("Temperatura:");

                double[] tempData = dataMap.get(key);
                for (int j = 0; j < tempData.length; j++) {

                    s += " " + tempData[j];
                }

                out.println(s);
            }
            out.println();
        }
        out.close();
    }

    public DataSaver() {
        this.filename = "database.txt";
    }

}
