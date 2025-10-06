import java.util.*;

public  abstract class Device {
    private String name;
    private boolean status;
    private double powerConsuption;

    public Device(String name , boolean status , double powerConsuption){
        this.name=name;
        this.powerConsuption=powerConsuption;
        this.status=status;
    }

    public String getName(){
        return name;
    }

    public boolean getStatus(){
        return  status;
    }

    public double getPowerConsuption(){
        return powerConsuption;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setStatus(boolean status){
        this.status=status;
    }


    public void setPowerConsuption(double powerConsuption){
        this.powerConsuption=powerConsuption;
    }

    public void turnOn(){
        status=true;
        System.out.println(name + " is turn on");
    }

    public void turnOf(){
        status = false;
        System.out.println(name + " device is turned off");
    }

    public abstract void showDetails();
}

class Light extends Device{
     private  int brightness;

     public Light(String name , boolean status , double powerConsuption , int brightness){
         super(name, status, powerConsuption);
         this.brightness=brightness;
     }

     @Override
     public void showDetails(){
         System.out.println("Light: " + getName() +
                 ", Brightness: " + brightness +
                 ", Power Consumption: " + getPowerConsuption() +
                 ", Status: " + (getStatus() ? "On" : "Off"));
     }
}


class Fan extends Device{
    private int speed;

    public Fan(String name, boolean status ,double powerConsuption, int speed){
         super(name, status, powerConsuption);
        this.speed=speed;

    }

    @Override
    public void showDetails(){
        System.out.println("Fan: " + getName() +
                ", Speed : " + speed +
                ", Power Consumption: " + getPowerConsuption() +
                ", Status: " + (getStatus() ? "On" : "Off"));
    }
}

class Ac extends Device{
    private  int temperature;

    public Ac(String name , boolean status , double powerConsumption , int temperature){
        super(name , status,powerConsumption);
        this.temperature=temperature;
    }

    @Override
    public void showDetails(){
        System.out.println("AC: " + getName() +
                ", Temperature : " + temperature +
                ", Power Consumption: " + getPowerConsuption() +
                ", Status: " + (getStatus() ? "On" : "Off"));
    }
}

class HomeManager{

    ArrayList<Device> devices;


    public HomeManager(){
        devices = new ArrayList<>();
    }

   public void addDevice(Device d) {
       devices.add(d);
       System.out.println(d.getName() + " added to Home.");
   }

   public void removeDevice(Device d){
        devices.remove(d);
       System.out.println(d.getName() + " removed from Home");
   }

   public void  showAllDevices(){
        for (Device d : devices){
            d.showDetails();
        }
   }
}

