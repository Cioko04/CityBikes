public class Travel {
    String id;
    String bikeNumber;
    String startTime;
    String endTime;
    String rentalPlace;
    String returnPlace;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRentalPlace() {
        return rentalPlace;
    }

    public void setRentalPlace(String rentalPlace) {
        this.rentalPlace = rentalPlace;
    }

    public String getReturnPlace() {
        return returnPlace;
    }

    public void setReturnPlace(String returnPlace) {
        this.returnPlace = returnPlace;
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
