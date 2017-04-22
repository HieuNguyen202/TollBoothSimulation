package toolboothsimulation;

public class ManuVehicle extends Vehicle {
    private final double PER_WHEEL_DELAY=1;
    private final int DEFAULT_NUM_WHEEL=4;
    private  int numWheel;
    public ManuVehicle(double arivalTime, int numWheel)
    {
        super(arivalTime);
        setNumWheel(numWheel);
    }
    public void setNumWheel(int numWheel) {
        if (numWheel > 0) this.numWheel = numWheel;
        else this.numWheel = DEFAULT_NUM_WHEEL;
    }
    public int getNumWheel() { return numWheel;}
    public double getDelayTime() {return numWheel*PER_WHEEL_DELAY;}
    public String toString() {return "Manual vehicle - "+super.toString()+" Number of wheels: "+getNumWheel();}
}
