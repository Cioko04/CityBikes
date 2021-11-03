public class Travel {
    private String id;
    private String bikeNumber;
    private String startTime;
    private String endTime;
    private String rentalPlace;
    private String returnPlace;

    public Travel(String id, String bikeNumber, String startTime, String endTime, String rentalPlace, String returnPlace) {

        this.id = id;
        this.bikeNumber = bikeNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalPlace = rentalPlace;
        this.returnPlace = returnPlace;
    }

    public String getId() {
        return id;
    }

    public String getBikeNumber() {
        return bikeNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }


    public String getRentalPlace() {
        return rentalPlace;
    }

    public String getReturnPlace() {
        return returnPlace;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "id='" + id + '\'' +
                ", bikeNumber='" + bikeNumber + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", rentalPlace='" + rentalPlace + '\'' +
                ", returnPlace='" + returnPlace + '\'' +
                '}';
    }
}
