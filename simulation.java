public class simulation {
    
    double xwarning;
    double ywarning;
    String airplanes_space ;
    double allwarnings;
    long timeElapsed;


    public simulation(double xwarning, double ywarning, String airplanes_space, double allwarnings, long timeElapsed) {
        this.xwarning = xwarning;
        this.ywarning = ywarning;
        this.airplanes_space = airplanes_space;
        this.allwarnings = allwarnings;
        this.timeElapsed = timeElapsed;
    }
    
    
    
    public simulation() {
        xwarning = 0;
        ywarning = 0;
        airplanes_space = null;
        allwarnings = 0;
        timeElapsed = 0;
    }

    public double getXwarning() {
        return xwarning;
    }

    public void setXwarning(double xwarning) {
        this.xwarning = xwarning;
    }

    public double getYwarning() {
        return ywarning;
    }

    public void setYwarning(double ywarning) {
        this.ywarning = ywarning;
    }

    public String getAirplanes_space() {
        return airplanes_space;
    }

    public void setAirplanes_space(String airplanes_space) {
        this.airplanes_space = airplanes_space;
    }

    public double getAllwarnings() {
        return allwarnings;
    }

    public void setAllwarnings(double allwarnings) {
        this.allwarnings = allwarnings;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
    
    
    
    
}
