
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataEditor {

    public Map<String, double[]> mergeData(List<Map<String, double[]>> dataList) {

        Map<String, double[]> data;
        int numberOfEntries = dataList.size();
        //przypisujemy mapie 1. mapę dla ułatwienia
        data = dataList.get(0);
        //sprawdzamy klucze w 1. hashmapie (wszystkie sa identyczne)
        //uzycie tego keysetu przy zapisie do jednej hashmapy
        Set<String> keySet = data.keySet();

        // iteracja po liście, pobranie z niej hashmap, policzenie średniej
        // zapis do hashmapy
        for (int i = 1; i < numberOfEntries; i++) {
            // pobranie wartości #mapy, dodatnie do nowej tablicy
            // iteracja po kluczu
            String key;
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                key = it.next();
                // pobranie wartości głównej
                double[] mainArray = data.get(key);
                // pobranie obecnej wartości
                double[] secondaryArray = dataList.get(i).get(key);
                //dodanie 2 tablic
                for (int j = 0; j < mainArray.length; j++) {
                    mainArray[j] += secondaryArray[j];
                }
                data.replace(key, mainArray);

            }

        }
        //pętla po wartościach, wyliczenie średniej
        Set<String> ks = data.keySet();
        Iterator<String> it = ks.iterator();
        while (it.hasNext()) {
            String key = it.next();
            double[] array = data.get(key);
            for (int i = 0; i < array.length; i++) {
                //zaokrąglenie
                array[i] = new BigDecimal(array[i] / numberOfEntries)
                        .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            data.replace(key, array);
        }

        return data;
    }

    Map<String, Double> calculateMeanDaily(Map<String, double[]> dataMap) {

        Map<String, Double> meanData = new HashMap<>();
        Set<String> keySet = dataMap.keySet();

        String key;
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {

            key = it.next();
            double[] array = dataMap.get(key);
            double sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }

            sum = new BigDecimal(sum / array.length)
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            meanData.put(key, sum);
        }

        return meanData;
    }

    double returnHourly(City city, int hour, String date) {
        return city.temperatureData.get(date)[hour];
    }

}
