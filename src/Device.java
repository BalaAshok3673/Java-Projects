public class Device {
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


