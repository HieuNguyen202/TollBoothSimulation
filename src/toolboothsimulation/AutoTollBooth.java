package toolboothsimulation;

public class AutoTollBooth extends TollBooth {
    private static AutoTollBooth shortestBooth; //the autobooth that has the shortest line.
    public static AutoTollBooth getShortestLine() {
        return shortestBooth;
    }
    public AutoTollBooth() {
        super();
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
    public String toString() {
        return "";
    }
    
}
