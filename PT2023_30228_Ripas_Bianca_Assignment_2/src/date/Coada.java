package date;

import java.util.LinkedList;
public class Coada extends Thread {
    private boolean k;
    private LinkedList<Client> coada = new LinkedList<>();

    public int getSize() {
        return coada.size();
    }
    public void adaugaClient(Client client) {
        coada.add(client);
    }
   public void stergeClient() {
        if(coada.size()>0){
            coada.removeFirst();
        }
    }
    public static Client getClient(int ID, int servingTime, int arrivingTime) {
        return new Client(ID, servingTime, arrivingTime);
    }
    @Override
    public void run() {
        while (open(k)) {
            if (coada.isEmpty()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (!coada.isEmpty()) {
                try {
                    sleep(coada.getFirst().getServingTime() * 1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.stergeClient();
            }
        }
    }
    public LinkedList<Client> getCoada() {
        return coada;
    }

    public boolean open(boolean k) {
        k = true;
        return k;
    }

}