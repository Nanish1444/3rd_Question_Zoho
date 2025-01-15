import java.util.*;

class TaxiBooking{
   public static  ArrayList<Taxi> taxiList = new ArrayList<>();
   static int taxiLimit=10;
   static int idGenerator=1;
   public static ArrayList<ArrayList<Taxi>> taxiBookingHistory = new ArrayList<>();
   public static int[] totalearn = new int[taxiLimit];

   public String booking(int customerId,char pickupLocation,char dropLocation,int pickupTime){
    if(taxiList.size()<taxiLimit){
        taxiList.add(new Taxi());;
    }
    Taxi readyTaxi=null;
    int minDistance=Integer.MAX_VALUE;

    for(Taxi check : taxiList){
        if(check.getDropTime()<=pickupTime && Math.abs(check.getCurrentLocation()-pickupLocation)<=minDistance){
            if(Math.abs(check.getCurrentLocation()-pickupLocation)==minDistance){
                
                if(readyTaxi!=null && check.getAmount()<readyTaxi.getAmount()){
                    readyTaxi=check;
                }
            }
            else{
                readyTaxi=check;
                minDistance=Math.abs(check.getCurrentLocation()-pickupLocation);
            }
        }
    }
    if(readyTaxi!=null){
        
        readyTaxi.setCurrentLocation(dropLocation);
       
        readyTaxi.setTaxiNo(taxiList.indexOf(readyTaxi)+1);
       
        readyTaxi.setCustomerId(idGenerator++);
       
        readyTaxi.setPickUpLocation(pickupLocation);
       
        readyTaxi.setDropLocation(dropLocation);
       
        readyTaxi.setPickUpTime(pickupTime);
       
        readyTaxi.setDropTime(pickupTime+Math.abs(pickupLocation-dropLocation));
        
        readyTaxi.setAmount((Math.abs(pickupLocation-dropLocation)*15-5)*10+100);
        
        totalearn[readyTaxi.getTaxiNo()-1]+=readyTaxi.getAmount();

        if(taxiBookingHistory.size()>=readyTaxi.getTaxiNo()){

            taxiBookingHistory.get(readyTaxi.getTaxiNo()-1).add(new Taxi(readyTaxi));
       
        }
        else{

            taxiBookingHistory.add(new ArrayList<Taxi>());
            
            taxiBookingHistory.get(readyTaxi.getTaxiNo()-1).add(new Taxi(readyTaxi));
        }
    }

    return readyTaxi!=null?"Taxi can Allocated \n Taxi "+readyTaxi.getTaxiNo()+" is Allotted":"Currently Taxi is not Available";
   }


   public void display(){

    System.out.println("_________________");

    for(int i=0;i<taxiBookingHistory.size();i++){

        ArrayList<Taxi> temp =taxiBookingHistory.get(i);

        System.out.println("Taxi No:"+(i+1)+" TotalEarnings :"+totalearn[i]);{

            for(Taxi t : temp){

                System.out.println(t);

                
            }
        }
    }
    System.out.println("________________");
   }


}