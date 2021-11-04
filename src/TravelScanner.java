import java.util.ArrayList;

public class TravelScanner {

    public static void getMostUsedBike(ArrayList<Travel> travels) {
        String bikeNumber = "", saveBikeNumber = "";
        int counter = 0, saveCounter = 0;
        for (int i = 1; i < travels.size(); i++) {
            if (!bikeNumber.equals(travels.get(i).getBikeNumber())){
                bikeNumber = travels.get(i).getBikeNumber();
                counter = 0;
                for (int j = i; j < travels.size(); j++) {
                    if (bikeNumber.equals(travels.get(j).getBikeNumber())){
                        counter++;
                    }
                }
                if(saveCounter < counter){
                    saveCounter = counter;
                    saveBikeNumber = bikeNumber;
                }
            }else {
                continue;
            }
        }
        System.out.println("Bike number: " + saveBikeNumber + " Counter: " + saveCounter);


    }
}
