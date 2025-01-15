import java.util.*;

class Taxi{
    private char currentLocation='A';
    private int taxiNo;
    private int customerId;
    private char pickupLocation;
    private char dropLocation;
    private int pickupTime;
    private int dropTime;
    private int amount;

    Taxi (){

    }

    Taxi (Taxi taxi){
        this.currentLocation=taxi.currentLocation;
        this.taxiNo=taxi.taxiNo;
        this.customerId=taxi.customerId;
        this.pickupLocation=taxi.pickupLocation;
        this.dropLocation=taxi.dropLocation;
        this.pickupTime=taxi.pickupTime;
        this.dropTime=taxi.dropTime;
        this.amount=taxi.amount;
    }
    //Getter And Setter

    public void setCurrentLocation(char currentLocation){
        this.currentLocation=currentLocation;
    }
    public char getCurrentLocation(){
        return currentLocation;
    }

    public void setTaxiNo(int taxiNo){
        this.taxiNo=taxiNo;
    }

    public int getTaxiNo(){
        return taxiNo;
    }

    public void setCustomerId(int customerId){
        this.customerId=customerId;
    }
    public int getCustomerId(){
        return customerId;
    }

    public void setPickUpLocation(char pickupLocation){
        this.pickupLocation=pickupLocation;
    }
    public char getPickUpLocation(){
        return pickupLocation;
    }
    public void setDropLocation(char dropLocation){
        this.dropLocation=dropLocation;
    }
    public char getDropLocation(){
        return dropLocation;
    }  

    public void setPickUpTime(int pickupTime){
        this.pickupTime=pickupTime;
    }
    public int getPickUpTime(){
        return pickupTime;
    }

    public void setDropTime(int dropTime){
        this.dropTime=dropTime;
    }
    public int getDropTime(){
        return dropTime;

    }

    public void setAmount(int amount){
        this.amount=amount;
    }
    public int getAmount(){
        return amount;
    }


    @Override
    public String toString(){
        return taxiNo+" "+customerId+" "+pickupLocation+" "+dropLocation+" "+pickupTime+" "+dropTime+" "+amount;
    }
}