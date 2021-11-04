import java.util.*;

public class TravelScanner {

    public static int getMostUsedBike(ArrayList<Travel> travels) {
        ArrayList<Integer> bikeNumbers = new ArrayList<>();
        for (int i = 1; i < travels.size(); i++) {
            bikeNumbers.add(Integer.parseInt(travels.get(i).getBikeNumber()));
        }
        Collections.sort(bikeNumbers);
        int counter = 0, bikeNumber = bikeNumbers.get(0), bigestCounter = 0, bikeWithBigestCounter = 0;
        for (int x: bikeNumbers) {
            if(x == bikeNumber){
                counter ++;
            }else if(x != bikeNumber){
                if(counter > bigestCounter){
                    bigestCounter = counter;
                    bikeWithBigestCounter = bikeNumber;
                }
                counter = 0;
                bikeNumber = x;
            }
        }
        return bikeWithBigestCounter;
    }
}
