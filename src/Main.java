import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("przejazdy.csv");
        ArrayList<Travel> travels = readData(file);
        TravelScanner travelScanner = new TravelScanner(travels);
        System.out.println("Most used bikes id's: " + travelScanner.getMostUsedBike());
        System.out.println("Least used bikes id's: " + travelScanner.getLeastUsedBike());
        System.out.println("Most used rental place is: " + travelScanner.getMostUsedRentalPlace());
        System.out.println("Least used rental place is: " + travelScanner.getLeastUsedRentalPlace());
        System.out.println("Most used return place is: " + travelScanner.getMostUsedRenturnPlace());
        System.out.println("Least used return place is: " + travelScanner.getLeastUsedReturnPlace());
        Collection<String> idOfLongestRide = travelScanner.getLongestTravel().keySet();
        Collection<Integer> secondsOfLongestRide = travelScanner.getLongestTravel().values();
        int timeOfRide = (int) secondsOfLongestRide.toArray()[0];
        int hoursOfRide = timeOfRide/60/60;
        int minutesOfRide = timeOfRide/60%60;
        int secondsOfRide = timeOfRide%60;
        System.out.println(timeOfRide);
        System.out.println("Longest ride id's: " + idOfLongestRide.toArray()[0]);
        System.out.println("Hours: " + hoursOfRide);
        System.out.println("Minutes: " + minutesOfRide);
        System.out.println("Seconds: " + secondsOfRide);


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
