import java.util.*;

public class TravelScanner {
    private ArrayList<Travel> travels;
    private Map<Integer, Integer> bikeMap;
    public TravelScanner(ArrayList<Travel> travels) {
        this.travels = travels;
        this.bikeMap = addBikeNumbersToMap(sortListOfBikeNumber());
    }

    private ArrayList<Integer> sortListOfBikeNumber(){
        ArrayList<Integer> bikeNumbers = new ArrayList<>();
        for (int i = 1; i < travels.size(); i++) {
            bikeNumbers.add(Integer.parseInt(travels.get(i).getBikeNumber()));
        }
        Collections.sort(bikeNumbers);
        return bikeNumbers;
    }
    private Map<Integer, Integer> addBikeNumbersToMap(ArrayList<Integer> bikeNumbers) {
        Map<Integer, Integer> bikeMap = new HashMap<>();
        int counter = 0, bikeNumber = bikeNumbers.get(0);
        for (int x: bikeNumbers) {
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

    public List<Integer> getMostUsedBike(){
        int maxValue = Collections.max(bikeMap.values());
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : bikeMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                keys.add(entry.getKey());
            }
        }
        return keys;

    }
    public List<Integer> getLeastUsedBike(){
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
