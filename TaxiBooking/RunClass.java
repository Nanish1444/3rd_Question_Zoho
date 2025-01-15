import java.util.*;

class RunClass{
    public static void main(String[] args) {
        TaxiBooking taxi = new TaxiBooking();
        System.out.println("WELCOME TO CALL TAXI BOOKING");
        Scanner scan = new Scanner(System.in);
        int choice;
        do{
            System.out.println("press the number as you want  \n 1. Book the taxi  2.Taxi Booking Details  3.Exit From the App\n");

            choice = scan.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Enter a Customer Id");
                    int customerId=scan.nextInt();
                    System.out.println("Enter a pickup location (Example A B C D E)");
                    char pickup=scan.next().charAt(0);
                    System.out.println("Enter a drop location (Example A B C D E)");
                    char drop = scan.next().charAt(0);
                    System.out.println("Enter a PickUp Time");
                    int pickupTime=scan.nextInt();
                    System.out.println(taxi.booking(customerId,pickup,drop,pickupTime)); 
                    break;
                    

                
                case 2:
                    taxi.display();
                    break;
                    
                
                case 3:
                    System.out.println("Thank You...... Have a Great Day");
                    scan.close(); 
                    break;  
            }

        }while(choice!=3);

    }
}