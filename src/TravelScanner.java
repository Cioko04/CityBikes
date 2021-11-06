import java.util.*;

public class TravelScanner {
    private static ArrayList<Integer> sortListOfBikeNumber(ArrayList<Travel> travels){
        ArrayList<Integer> bikeNumbers = new ArrayList<>();
        for (int i = 1; i < travels.size(); i++) {
            bikeNumbers.add(Integer.parseInt(travels.get(i).getBikeNumber()));
        }
        Collections.sort(bikeNumbers);
        return bikeNumbers;
    }
    private static Map<Integer, Integer> addBikeNumbersToMap(ArrayList<Integer> travels) {
        Map<Integer, Integer> bikeMap = new HashMap<>();
        int counter = 0, bikeNumber = travels.get(0);
        for (int x: travels) {
            if(x == bikeNumber){
                counter ++;
            }else if(x != bikeNumber){
                bikeMap.put(bikeNumber,counter);
                counter = 0;
                bikeNumber = x;
            }
        }
        return bikeMap;
    }

    public static List<Integer> getMostUsedBike(ArrayList<Travel> travels){
        ArrayList<Integer> bikeNumbers = sortListOfBikeNumber(travels);
        Map<Integer, Integer> bikeMap = addBikeNumbersToMap(bikeNumbers);
        int maxValue = Collections.max(bikeMap.values());
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : bikeMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                keys.add(entry.getKey());
            }
        }
        return keys;

    }
    public static List<Integer> getLeastUsedBike(ArrayList<Travel> travels){
        ArrayList<Integer> bikeNumbers = sortListOfBikeNumber(travels);
        Map<Integer, Integer> bikeMap = addBikeNumbersToMap(bikeNumbers);
        int minValue = Collections.min(bikeMap.values());
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : bikeMap.entrySet()) {
            if (entry.getValue() == minValue) {
                keys.add(entry.getKey());
            }
        }
        return keys;

    }
}
