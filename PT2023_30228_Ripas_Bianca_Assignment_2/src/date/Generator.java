package date;

import java.util.Random;
public class Generator {
    Random random = new Random();
    private int nrClienti = 0;
    private int maxArrivingTime = 0;
    private int minArrivingTime = 0;
    private int maxServingTime = 0;
    private int minServingTime = 0;

    public Generator(int nrClienti, int maxServingTime, int minServingTime, int maxArrivingTime,
                            int minArrivingTime) {
        this.nrClienti = nrClienti;
        this.maxServingTime = maxServingTime;
        this.minServingTime = minServingTime;
        this.maxArrivingTime = maxArrivingTime;
        this.minArrivingTime = minArrivingTime;
    }
    public Generator() {

    }
    public Client generare(int idClient, int maxServingTime, int minServingTime, int maxArrivingTime,
                                  int minArrivingTime) {
        int arrivingTime=0;
        int servingTime=0;
        int a=0;
        int b=0;
        a=maxArrivingTime-minArrivingTime;
        b=maxServingTime-minServingTime;
        arrivingTime =  random.nextInt(a+1) + minArrivingTime;
        servingTime = random.nextInt(b+1) + minServingTime;
        Client client = new Client(idClient, servingTime, arrivingTime);
        return client;
    }
}
