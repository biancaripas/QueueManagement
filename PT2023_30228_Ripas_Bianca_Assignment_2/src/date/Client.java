package date;

public class Client {
    private int ID;
    private int arrivingTime;
    private int servingTime;
    public Client(int ID, int servingTime, int arrivingTime) {
        this.ID = ID;
        this.arrivingTime = arrivingTime;
        this.servingTime = servingTime;

    }
    public int getID() {
        return ID;
    }
    public int getArrivingTime() {
        return arrivingTime;
    }
    public int getServingTime() {
        return servingTime;
    }
    public int getTimp() {
       int t = getServingTime() + getArrivingTime();
        return t;
    }

}

