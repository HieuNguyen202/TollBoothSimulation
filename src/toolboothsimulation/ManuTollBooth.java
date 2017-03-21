package toolboothsimulation;
//testing github
public class ManuTollBooth extends TollBooth {
    private static ManuTollBooth shortestBooth; //the manubooth that has the shortest line.
    public ManuTollBooth() {
        super();
    }
    public static ManuTollBooth getShortestLine() {
        return shortestBooth;
    }
    public void leave(double leaveTime) {
        super.leave(leaveTime);
        updateShortestLine();
    }
    public void updateShortestLine() {
        if (getLength() < shortestBooth.getLength()) {
            shortestBooth = this;
        }
    }
    public String tosString() {
        return "";
    }
    
}
