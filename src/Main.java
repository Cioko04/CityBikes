import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("przejazdy.csv");
        ArrayList<Travel> travels = readData(file);
        TravelScanner travelScanner = new TravelScanner(travels);

        //Return numbers of most used bike
        //getMostUsedBike(travelScanner);

        //Return numbers of least used bike
        //getLeastUsedBike(travelScanner);

        //Return names of most used rental place
        //getMostUsedRentalPlace(travelScanner);

        //Return names of least used rental place
        //getLeastUsedRentalPlace(travelScanner);

        //Return names of most used return place
        //getMostUsedReturnPlace(travelScanner);

        //Return names of least used return place
        //getLeastUsedReturnPlace(travelScanner);

        //Return data of longes travel
        getLongestRideData(travelScanner);




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
    public static void getMostUsedBike(TravelScanner travelScanner){
        System.out.println("Most used bikes number's:");
        for (int x: travelScanner.getMostUsedBike()) {
            System.out.println(x);
        }
    }
    public static void getLeastUsedBike(TravelScanner travelScanner){
        System.out.println("Least used bikes number's:");
        for (int x: travelScanner.getLeastUsedBike()) {
            System.out.println(x);
        }
    }
    public static void getMostUsedRentalPlace(TravelScanner travelScanner){
        System.out.println("Most used rental place is:");
        for (String x: travelScanner.getMostUsedRentalPlace()) {
            System.out.println(x);
        }
    }
    public static void getLeastUsedRentalPlace(TravelScanner travelScanner){
        System.out.println("Least used rental place is:");
        for (String x: travelScanner.getLeastUsedRentalPlace()) {
            System.out.println(x);
        }
    }
    public static void getMostUsedReturnPlace(TravelScanner travelScanner){
        System.out.println("Most used return place is:");
        for (String x: travelScanner.getMostUsedRenturnPlace()) {
            System.out.println(x);
        }
    }
    public static void getLeastUsedReturnPlace(TravelScanner travelScanner){
        System.out.println("Least used return place is:");
        for (String x: travelScanner.getLeastUsedReturnPlace()) {
            System.out.println(x);
        }
    }
    public static void getLongestRideData(TravelScanner travelScanner){
        System.out.printf("Longest ride id's: \n" + travelScanner.getLongestTravelId() +
                "\nTime:\n" +
                travelScanner.getTimeTravelInHours() + " hours " +
                travelScanner.getTimeTravelInMinutes() + " minutes " +
                travelScanner.getTimeTravelInSeconds() + " seconds");
    }
}
