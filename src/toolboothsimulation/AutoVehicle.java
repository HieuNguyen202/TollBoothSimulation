package toolboothsimulation;
public class AutoVehicle extends Vehicle {
    private final int DEFAULT_PER_VIHICLE_DELAY_TIME=1;
    public AutoVehicle(double arivalTime){super(arivalTime);}
    public double getWaitTime(){return super.getWaitTime()+ DEFAULT_PER_VIHICLE_DELAY_TIME;}
    public String toString() {return "Automatic Vehicle - "+super.toString();}
}
