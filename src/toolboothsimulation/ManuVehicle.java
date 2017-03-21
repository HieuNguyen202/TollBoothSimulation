package toolboothsimulation;

public class ManuVehicle extends Vehicle {
    private final double PER_WHEEL_DELAY=1;
    private  int numWheel;

    public ManuVehicle(double arivalTime, int numWheel)
    {
        super(arivalTime);
        setNumWheel(numWheel);
    }
    public void setNumWheel(int numWheel) {
        if (numWheel > 0) {
            this.numWheel = numWheel;
        }
    }
    public int getNumWheel() { return numWheel;}
    
    public double getWaitTime() {return super.getWaitTime()+numWheel*PER_WHEEL_DELAY;}
    public String toString() {return "Manual Vehicle - "+super.toString()+" Number of Wheels: "+getNumWheel();}
}
