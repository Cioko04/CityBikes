import java.util.ArrayList;
import java.util.Collections;

public class TravelScanner {

    public static int getMostUsedBike(ArrayList<Travel> travels) {
        ArrayList<Integer> bikeNumbers = new ArrayList<>();
        for (int i = 1; i < travels.size(); i++) {
            bikeNumbers.add(Integer.parseInt(travels.get(i).getBikeNumber()));
        }
        Collections.sort(bikeNumbers);
        int temporaryCounter = 1, temporaryBike = 0, bigestCounter = 0, bikeWithBigestCounter = 0;
        for (int x: bikeNumbers) {
            if (temporaryBike != x ){
                if(temporaryCounter > bigestCounter){
                    bigestCounter = temporaryCounter;
                    bikeWithBigestCounter = temporaryBike;
                }
                temporaryBike = x;
                temporaryCounter = 1;
            }else if(temporaryBike == x){
                temporaryCounter++;
            }

        }
        return bikeWithBigestCounter;
    }
}
