package simulator;

import date.Client;
import date.Coada;
import date.Generator;
import interfata.GUI;
import interfata.GUI1;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Simulator extends Thread {
    private int nrCozi;
    private int timpulS;
    private int maxServingTime;
    private int minServingTime;
    private int maxArrivingTime;
    private int minArrivingTime;
    private ArrayList<Client> listaClienti = new ArrayList<>();
    public static Coada[] cozi;
    private int nrClienti ;
    private static int timp;
    int k=1;
    private double avgS = 0;
    private double avgW = 0;
    private GUI1 interfata;
    public void adaugaListaClienti(Client client) {
        listaClienti.add(client);
    }
   public static int getTimp() {
        return timp;
    }
    public Simulator(int nrClienti, int nrCozi, int minArrivingTime, int maxArrivingTime, int minServingTime, int maxServingTime,
                     int timpulSimularii) {
        this.nrClienti = nrClienti;
        this.minArrivingTime = minArrivingTime;
        this.maxArrivingTime = maxArrivingTime;
        this.minServingTime = minServingTime;
        this.maxServingTime = maxServingTime;
        this.timpulS = timpulSimularii;
        this.nrCozi = nrCozi;
        cozi = new Coada[nrCozi];
        int i=0;
        for ( i = 0; i < cozi.length; i++) {
            cozi[i] = new Coada();
        }
    }

    public int getCoadaPreferabila() {
        int minIndex = -1;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < cozi.length; i++) {
            if (cozi[i].getSize() < minSize) {
                minIndex = i;
                minSize = cozi[i].getSize();
            }
        }
        return minIndex;
    }
    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setBounds(400, 400, 800, 600);
        frame.setBackground(Color.CYAN);
        frame.setTitle("simulare");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(interfata = new GUI1());
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setVisible(true);
        for (int i = 1; i <= nrClienti; i++) {
            Generator generator = new Generator();
            adaugaListaClienti(
                    generator.generare(i, maxServingTime, minServingTime, maxArrivingTime, minArrivingTime));
        }
        for (Coada c : cozi) {
            c.start();
        }
        for (timp =0; timp <= timpulS; timp++) {
            String text;
            text = Integer.toString(timp);
            GUI.setTime(text);
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("file.txt",true));
                if(k==1)
                {writer.println("S-au generat aleator " + nrClienti + " clienti.");
                writer.println("Regulile sunt aceleasi pt toti " + nrClienti + " clienti.");
                writer.println("Simularea este finalizata atunci cand nu mai exista clienti in asteptare.");
                }
                k++;
                for (Client client : listaClienti) {
                    if(client.getTimp()>timp ){
                        writer.println("La timpul " + timp + " Clientul acesta  e in asteptare " );
                        writer.println( "( " + client.getID() + ","+ client.getArrivingTime() + ","  + client.getServingTime() + ")");
                    }
                    if (client.getTimp() == timp) {
                        int coadaBuna = this.getCoadaPreferabila();
                        writer.println("La timpul : " + timp + " acum acest client a plecat : ");
                        writer.println("Clientul "  +"( " + client.getID() + ","+ client.getArrivingTime() + ","  + client.getServingTime() + ")" +
                     " la coada " + coadaBuna );
                        writer.println(" Coada " + coadaBuna + " e ocupata ");
                        GUI.write.append("La timpul : " + timp );
                        GUI.write.append(  "\n" + " Coada " + coadaBuna + " e ocupata " + " de "+"( " + client.getID() + ","+ client.getArrivingTime() + ","  + client.getServingTime() + ")" + "\n");
                        cozi[coadaBuna].adaugaClient(client);
                    }

                    interfata.coloreaza();
                }
                writer.close();
            }
                    catch(IOException e){
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
            }
            interfata.coloreaza();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
       interfata.setVisible(false);
        avgW=setWaiting();
        avgS=setServing();
        System.out.println("avg wait e : " + avgW);
        System.out.println("avg serv e : " + avgS);
        GUI.wait(Double.toString(avgW));
        GUI.serving(Double.toString(avgS));
    }
    public double setWaiting() {
        int totalTimpAsteptare = 0;
        for (Client client : listaClienti) {
            totalTimpAsteptare += client.getTimp();
        }
        System.out.println("Numar clienti: " + listaClienti.size());
        System.out.println("Total timp asteptare: " + totalTimpAsteptare);
        double avgTimpAsteptare = (double) totalTimpAsteptare / listaClienti.size();
        return avgTimpAsteptare;

    }
    public double setServing() {
        int totalTimpServire = 0;
        for (Client client : listaClienti) {
            totalTimpServire += client.getServingTime();
        }
        System.out.println("Total timp servire: " + totalTimpServire);
        double avgTimpServire = (double) totalTimpServire / listaClienti.size();
        return avgTimpServire ;
    }



}
