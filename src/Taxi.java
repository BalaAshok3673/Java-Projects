public class Taxi {
    private String currentLoacation;
    private int freeTime;
    private int taxiID;
    private double totalEarnings;

    public Taxi(String currentLoacation , int freeTime  , double totalEarnings){
        this.currentLoacation=currentLoacation;
        this.freeTime=freeTime;
        this.totalEarnings=totalEarnings;
        taxiID++;
    }

    public String getCurrentLoacation(){
        return currentLoacation;
    }

    public int getTaxiID() {
        return taxiID;
    }

    public int getFreeTime(){
        return freeTime;
    }

    public double getTotalEarnings(){
        return totalEarnings;
    }

    public void setCurrentLoacation(String currentLoacation){
        this.currentLoacation=currentLoacation;
    }

    public void setFreeTime(int freeTime){
        this.freeTime=freeTime;
    }

    public void setTotalEarnings(double totalEarnings){
        this.totalEarnings=totalEarnings;
    }
}
