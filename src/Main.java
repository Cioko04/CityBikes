import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("przejazdy.csv");
        ArrayList<Travel> travels = readData(file);
        System.out.println("Most used bikes id's: " + TravelScanner.getMostUsedBike(travels));
        System.out.println("Least used bikes id's: " + TravelScanner.getLeastUsedBike(travels));

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

    public static ArrayList<Travel> readData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Travel> travels = new ArrayList<>();

        while (scanner.hasNext()){
            String travelLine = scanner.nextLine();
            Travel travel = splitString(travelLine);
            travels.add(travel);
        }
        return travels;
    }
}
