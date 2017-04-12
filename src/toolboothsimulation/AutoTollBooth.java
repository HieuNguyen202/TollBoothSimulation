package toolboothsimulation;

public class AutoTollBooth extends TollBooth {
    private static AutoTollBooth shortestBooth; //the autobooth that has the shortest line.
    public static AutoTollBooth getShortestLine() {
        return shortestBooth;
    }
    public AutoTollBooth() {
        super();
        updateShortestLine();
    }
    public void leave(double leaveTime) {
        super.leave(leaveTime);
        updateShortestLine();
    }
    public void updateShortestLine() {
        if (shortestBooth==null) {
            shortestBooth=this;
        }
        else if (length() < shortestBooth.length()) {
            shortestBooth = this;
        }
    }
    public String toString() {
        return "AutoTollBooth "+super.toString();
    }
    
}
