package ReservationSystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class AirLine_System {



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String Date_made = null, name_of_passenger = null, address_of_passenger = null, Flight_Date = null, To = null, From = null, Passport_Number=null, Date_of_flight=null;
        String phone_number = null;
        int Capacity = 0;
        String Arrival = null;
        String Departure = null;
        int service = 0;
        boolean test = true;

        Reservations r1 = new Reservations( Date_made, Passport_Number , phone_number, name_of_passenger, address_of_passenger, Date_of_flight, To, From, Arrival,  Departure, Capacity);

        System.out.println(" ------------------------------------");
        System.out.println(" ####   Welcome To Airline_Reservation_System   #### ");
        System.out.println("-------------------------------------");
        do
        {
            do
            {

                System.out.println(" Choose the service that you want and Enter its number: \n "
                        + "(1) Reservations The Flight \n "
                        + "(2) Display_Reservations_details that found \n "
                        + "(3) Exit");
                System.out.println("-------------------------------------");
                System.out.print(": ");

                service = in.nextInt();

                if(service!=1 && service!=2 && service!=3)
                    System.out.println("Please Enter The Number Again !!!!");

            }while(service!=1 && service!=2 && service!=3);

            switch(service)
            {
                case 1:
                {
                    r1=Display();
                } break;
                case 2:
                {
                    r1.display_Reservations_details();
                } break;
                case 3:
                {
                    System.out.println("------------------------------------");
                    System.out.println(" Thanks For Using Our AirLines ");
                    test=false;
                } break;
            }

        }while(test == true);
    }
    public static Reservations Display()
    {

        Scanner obj = new Scanner(System.in);
        System.out.println("------------------------------------");

        //Passenger Name
        System.out.println("Enter The Passenger Name  ");
        System.out.print(": ");
        String  name_of_passenger=obj.next();
        System.out.println("------------------------------------");

        //Passenger Address
        System.out.println("Enter The Passenger Address  ");
        System.out.print(": ");
        String  address_of_passenger=obj.next();
        System.out.println("------------------------------------");

        //Passport Number
        System.out.println("Enter The Passport Number  ");
        System.out.print(": ");
        String Passport_Number=obj.next();
        System.out.println("------------------------------------");

        //Passengers Number
        System.out.println("Enter The Phone Number  ");
        System.out.print(": ");
        String  phone_number=obj.next();
        System.out.println("------------------------------------");

        //Date Made
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String Date_made= dtf.format(now);

        //Flight Date
        System.out.println("Enter The Flight Date  ");
        System.out.print(": ");
        String Date_of_flight=obj.next();
        System.out.println("------------------------------------");

        //To
        System.out.println("Enter The The place of take off of the Airplane  ");
        System.out.print(": ");
        String To=obj.next();
        System.out.println("------------------------------------");

        //From
        System.out.println("Enter The Airplane landing place  ");
        System.out.print(": ");
        String From=obj.next();
        System.out.println("------------------------------------");

        //Departure Time
        System.out.println("Enter The Departure Time  ");
        System.out.print(": ");
        String  Departure=obj.next();
        System.out.println("------------------------------------");

        //Arrival Time
        System.out.println("Enter The Arrival Time  ");
        System.out.print(": ");
        String Arrival=obj.next();
        System.out.println("------------------------------------");

        //Capacity
        System.out.println("Enter The Capacity Of AirAirplane  ");
        System.out.print(": ");
        int Capacity=obj.nextInt();
        System.out.println("------------------------------------");

        Reservations r = new Reservations( Date_made, name_of_passenger , phone_number, Passport_Number, address_of_passenger, Date_of_flight, To, From, Arrival,  Departure, Capacity);
        return r;

    }
}
class Reservations {
    private String Date_made;
    private Scheduled_Flight Sf;
    private Passenger p;

    public Reservations(String Date_made,String Passport_Number ,String phone_number, String name_of_passenger, String address_of_passenger, String Date_of_flight, String To, String From, String Arrival, String Departure, int Capacity)
    {
        Sf = new Scheduled_Flight(Date_of_flight, To, From, Arrival, Departure, Capacity);
        p = new Passenger(name_of_passenger , phone_number, Passport_Number, address_of_passenger);
        this.Date_made = Date_made;
    }

    public String getDate_made()
    {
        return Date_made;
    }

    public void setDate_made(String Date_made)
    {
        this.Date_made = Date_made;
    }

    public void display_Reservations_details()
    {

        p.display_Passenger_details();
        Sf.display_Scheduled_Flight_details(Date_made);
        System.out.println("------------------------------------");

    }
}
class Passenger extends Person {
    private String phone_number;
    private String Passport_Number;


    public Passenger(String Passport_Number , String phone_number, String name_of_passenger, String address_of_passenger)
    {
        super(name_of_passenger,address_of_passenger);
        this.phone_number=phone_number;
        this.Passport_Number=Passport_Number;

    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassport_Number() {
        return Passport_Number;
    }

    public void setPassport_Number(String passport_Number) {
        Passport_Number = passport_Number;
    }

    public void display_Passenger_details()
    {
        System.out.println("------------------------------------");
        System.out.println("*** Passenger Details ***");
        System.out.println(" Passenger Name : " + this.getName() + " || Passport Number : " + this.getPassport_Number() + " || Passenger Address : " + this.getAddress()+" || Passenger Phone Number : " + this.getPhone_number() );
        System.out.println("------------------------------------");

    }
}
class Scheduled_Flight extends Flight_description {
    private String Date_of_flight;

    public Scheduled_Flight(String Date_of_flight, String To, String From, String Arrival, String Departure, int Capacity)
    {
        super(To,From,Arrival,Departure,Capacity);
        this.Date_of_flight=Date_of_flight;
    }

    public void setDate_of_flight(String Date_of_flight)
    {
        this.Date_of_flight = Date_of_flight;
    }

    public String getDate_of_flight()
    {
        return Date_of_flight;
    }


    public void display_Scheduled_Flight_details(String dataMode)
    {

        System.out.println("------------------------------------");
        System.out.println("*** Flight Details ***");
        System.out.println("Data Made : " + dataMode +" || Flight Date : " + this.getDate_of_flight() + " || Flight From : " + this.getFrom() + " || Flight To :" + this.getTo() + "|| Number of travelers : " + this.getCapacity()
              +  " || Flight Departure : " + this.getDeparture() + " || Flight Arrival : " + this.getArrival() +  "\n");
        System.out.println("------------------------------------");

    }
}
class Flight_description {
    private String To;
    private String From;
    private String Arrival;
    private String Departure;
    private int Capacity;

    public Flight_description(String To, String From, String Arrival, String Departure, int Capacity)
    {
        this.To = To;
        this.From = From;
        this.Arrival=Arrival;
        this.Departure = Departure;
        this.Capacity = Capacity;
    }

    public void setTo(String To)
    {
        this.To = To;
    }

    public void setFrom(String From)
    {
        this.From = From;
    }

    public void setArrival(String Arrival)
    {
        this.Arrival = Arrival;
    }

    public void setDeparture(String Departure)
    {
        this.Departure = Departure;
    }

    public void setCapacity(int Capacity)
    {
        this.Capacity = Capacity;
    }

    public String getTo()
    {
        return To;
    }

    public String getFrom()
    {
        return From;
    }

    public String getArrival()
    {
        return Arrival;
    }

    public String getDeparture()
    {
        return Departure;
    }

    public int getCapacity()
    {
        return Capacity;
    }
}
class Person {
    private String name;
    private String address;

    public Person(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }
}
