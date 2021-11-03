import java.util.ArrayList;

public class TravelScanner {

    public static ArrayList<String> getMostUsedBike(ArrayList<Travel> travels) {
        ArrayList<String> use = new ArrayList<>();
        for (int i = 0; i < travels.size(); i++) {
            for (int j = 0; j < use.size(); j++) {
                if(!use.get(j).equals(travels.get(i))){
                    use.add(travels.get(i).getBikeNumber());
                }
            }
        }
        return use;
    }
}
