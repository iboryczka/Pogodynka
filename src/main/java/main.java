
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
               
        String n = "Warszawa";
        String n2 = "Szczecin";
        Map<String, double[]> dataMap = new HashMap<>();
        Map<String, double[]> dataMap2 = new HashMap<>();
        DataRetriever dr = new DataRetrieverWunderground();
        DataRetriever dr2 = new DataRetrieverForecastIO();
        List<City> lista = new ArrayList<>();
        City c = dr.getCity(n);
        City c2 = dr.getCity(n2);
        //System.out.println(c.toString());
        
        List<Map<String, double[]>> dataList = new ArrayList<>();
        dataList.add(dr2.getData(c));
        dataList.add(dr.getData(c));
        
        List<Map<String, double[]>> dataList2 = new ArrayList<>();
        dataList2.add(dr2.getData(c2));
        dataList2.add(dr.getData(c2));
        
        DataEditor de = new DataEditor();
        c.temperatureData = de.mergeData(dataList);
        c2.temperatureData = de.mergeData(dataList2);
        
        lista.add(c);
        lista.add(c2);
        
        DataSaver saver = new DataSaver();
        saver.saveData(lista);
        
    }
}
