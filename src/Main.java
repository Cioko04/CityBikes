import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("przejazdy.csv");
        Scanner scanner = new Scanner(file);
        ArrayList<Travel> travels = new ArrayList<>();

        while (scanner.hasNext()){
            String travelLine = scanner.nextLine();
            Travel travel = splitString(travelLine);
            travels.add(travel);
        }
        System.out.println("Most used bike is: " + TravelScanner.getMostUsedBike(travels));

    }

    public static Travel splitString(String strl){
        String[] split = strl.split(",");
        String id = split[1];
        String bikeNumber = split[2];
        String startTime = split[3];
        String endTime = split[4];
        String rentalPlace = split[5];
        String returnPlace = split[6];
        return new Travel(id,bikeNumber,startTime,endTime,rentalPlace,returnPlace);

    }
}
