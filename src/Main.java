import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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

    }

    public static Travel splitString(String strl){
        String[] split = strl.split(",");
        //int  id = Integer.parseInt(split[0]);
        //int bikeNumber = Integer.parseInt(split[1]);
        String id = split[1];
        String bikeNumber = split[2];
        String startTime = split[3];
        String endTime = split[4];
        String rentalPlace = split[5];
        String returnPlace = split[6];
        return new Travel(id,bikeNumber,startTime,endTime,rentalPlace,returnPlace);

    }
}
