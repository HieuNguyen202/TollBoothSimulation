package toolboothsimulation;
public class AutoVehicle extends Vehicle {
    private final int DEFAULT_PER_VEHICLE_DELAY_TIME=1;
    public AutoVehicle(double arivalTime){super(arivalTime);}
    public String toString() {return "Automatic vehicle - "+super.toString();}
    public double getDelayTime() {return DEFAULT_PER_VEHICLE_DELAY_TIME;}
}
