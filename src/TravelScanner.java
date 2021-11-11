import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class TravelScanner {
    private ArrayList<Travel> travels;
    private Map<Integer, Integer> bikeMap;
    private Map<String, Integer> rentalPlaceMap;
    private Map<String, Integer> returnPlaceMap;
    private Map<String, Integer> timeTravelMap;

    public TravelScanner(ArrayList<Travel> travels) {
        this.travels = travels;
        this.bikeMap = addBikeNumbersToMap(sortListOfBikeNumber());
        this.rentalPlaceMap = addRentalPlacesToMap(sortListOfRentalPlace());
        this.returnPlaceMap = addReturnPlacesToMap(sortListOfReturnPlace());
        this.timeTravelMap = addTimeTravelMap();
    }

    private ArrayList<Integer> sortListOfBikeNumber(){
        ArrayList<Integer> bikeNumbers = new ArrayList<>();
        for (int i = 1; i < travels.size(); i++) {
            bikeNumbers.add(Integer.parseInt(travels.get(i).getBikeNumber()));
        }
        Collections.sort(bikeNumbers);
        return bikeNumbers;
    }
    private ArrayList<String> sortListOfRentalPlace(){
        ArrayList<String> rentalPlace = new ArrayList<>();
        for (int i = 1; i < travels.size(); i++) {
            if (!travels.get(i).getRentalPlace().equals("Poza stacją")){
                rentalPlace.add(travels.get(i).getRentalPlace());
            }

        }
        Collections.sort(rentalPlace);
        return rentalPlace;
    }
    private ArrayList<String> sortListOfReturnPlace(){
        ArrayList<String> returnPlace = new ArrayList<>();
        for (int i = 1; i < travels.size(); i++) {
            if (!travels.get(i).getReturnPlace().equals("Poza stacją")){
                returnPlace.add(travels.get(i).getReturnPlace());
            }

        }
        Collections.sort(returnPlace);
        return returnPlace;
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
    private Map<String, Integer> addRentalPlacesToMap(ArrayList<String> rentalPlaces) {
        Map<String, Integer> rentalPlaceMap = new HashMap<>();
        int counter = 0;
        String rentalPlace = rentalPlaces.get(0);
        for (String x: rentalPlaces) {
            if(x.equals(rentalPlace)){
                counter ++;
            }else if(!x.equals(rentalPlace)){
                rentalPlaceMap.put(rentalPlace, counter);
                counter = 0;
                rentalPlace = x;
            }
        }
        return rentalPlaceMap;
    }
    private Map<String, Integer> addReturnPlacesToMap(ArrayList<String> returnPlaces) {
        Map<String, Integer> returnPlaceMap = new HashMap<>();
        int counter = 0;
        String returnPlace = returnPlaces.get(0);
        for (String x: returnPlaces) {
            if(x.equals(returnPlace)){
                counter ++;
            }else if(!x.equals(returnPlace)){
                returnPlaceMap.put(returnPlace, counter);
                counter = 0;
                returnPlace = x;
            }
        }
        return returnPlaceMap;
    }
    private Map<String, Integer> addTimeTravelMap(){
        Map<String, Integer> timeTravelMap = new HashMap<>();
        LocalTime startTime, endTime;
        LocalDate startDate, endDate;
        String[] startDateSplit = new String[2];
        String[] endDateSplit = new String[2];
        int secondsOfTravel, daysOfTravel;
        for (int i = 1; i < travels.size(); i++) {

            startDateSplit = travels.get(i).getStartTime().split(" ");
            endDateSplit = travels.get(i).getEndTime().split(" ");

            startDate = LocalDate.parse(startDateSplit[0]);
            endDate = LocalDate.parse(endDateSplit[0]);
            startTime = LocalTime.parse(startDateSplit[1]);
            endTime = LocalTime.parse(endDateSplit[1]);

            secondsOfTravel = endTime.toSecondOfDay() - startTime.toSecondOfDay();
            daysOfTravel = endDate.getDayOfYear() - startDate.getDayOfYear();
             if(secondsOfTravel>0 && (daysOfTravel == 0)) {
                 timeTravelMap.put(travels.get(i).getId(), secondsOfTravel);
             }

        }
        return timeTravelMap;
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
    public List<String> getMostUsedRentalPlace(){
        int maxValue = Collections.max(rentalPlaceMap.values());
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : rentalPlaceMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                keys.add(entry.getKey());
            }
        }
        return keys;

    }
    public List<String> getLeastUsedRentalPlace(){
        int minValue = Collections.min(rentalPlaceMap.values());
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : rentalPlaceMap.entrySet()) {
            if (entry.getValue() == minValue) {
                keys.add(entry.getKey());
            }
        }
        return keys;

    }
    public List<String> getMostUsedRenturnPlace(){
        int maxValue = Collections.max(returnPlaceMap.values());
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : returnPlaceMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                keys.add(entry.getKey());
            }
        }
        return keys;

    }
    public List<String> getLeastUsedReturnPlace(){
        int minValue = Collections.min(returnPlaceMap.values());
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : returnPlaceMap.entrySet()) {
            if (entry.getValue() == minValue) {
                keys.add(entry.getKey());
            }
        }
        return keys;

    }
    public String getLongestTravelId(){
        int maxValue = Collections.max(timeTravelMap.values());
        String key = new String();
        for (Map.Entry<String, Integer> entry : timeTravelMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                key = entry.getKey();
            }
        }
        return key;
    }
    private int getMaxValueFromTimeTravelMap(){
        return Collections.max(timeTravelMap.values());
    }
    public int getTimeTravelInHours(){
        return Collections.max(timeTravelMap.values())/60/60;
    }
    public int getTimeTravelInMinutes(){
        return Collections.max(timeTravelMap.values())/60%60;
    }
    public int getTimeTravelInSeconds(){
        return Collections.max(timeTravelMap.values())%60;
    }


}
