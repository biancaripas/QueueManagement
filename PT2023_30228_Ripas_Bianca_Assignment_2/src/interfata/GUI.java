package interfata;
import simulator.Simulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class GUI extends JFrame {

    private JFrame frame = new JFrame("Queue");
    private JLabel l1 = new JLabel("Timp Simulare");
    private JLabel l2 = new JLabel("Nr cozi");
    private JLabel l3 = new JLabel("Minim Arriving");
    private JLabel l4 = new JLabel("Maxim Arriving ");
    private JLabel l5 = new JLabel("Minim Serving ");
    private JLabel l6 = new JLabel("Maxim Serving ");
    private JLabel l7 = new JLabel("Timp");
    private JLabel l9 = new JLabel("AVG waiting");
    private JLabel l10 = new JLabel("AVG serving ");
    private JLabel l11 = new JLabel("Nr clienti");
    private JTextField timps = new JTextField("");

    private JTextField maxs = new JTextField("");
    private JTextField mins = new JTextField("");
    private JTextField nclienti = new JTextField("");
    private JTextField ncozi = new JTextField("");
    private JTextField maxa = new JTextField("");
    private JTextField mina = new JTextField("");
    private static JTextField wait = new JTextField("");
    private static JTextField serving = new JTextField("");
    public static JTextArea write = new JTextArea();
    public static JTextField time = new JTextField("");
    private JButton button = new JButton("Start ");
    public GUI() {
        addComponents();
        jFrameSetup();
    }
    private void jFrameSetup() {

        frame.getContentPane().setBackground(new Color(255, 180, 252));
        frame.setBounds(100, 100, 1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setLocationRelativeTo(null);
    }
    public void addComponents() {
        
        l1.setBounds(24, 50, 126, 30);
        timps.setBounds(205, 50, 100, 30);
        frame.getContentPane().add(l1);
        frame.getContentPane().add(timps);

        l2.setBounds(24, 92, 151, 30);
        ncozi.setBounds(205, 92, 100, 30);
        frame.getContentPane().add(l2);
        frame.getContentPane().add(ncozi);

        l3.setBounds(24, 134, 150, 30);
        mina.setBounds(205, 134, 100, 30);
        frame.getContentPane().add(l3);
        frame.getContentPane().add(mina);

        l4.setBounds(25, 181, 150, 30);
        maxa.setBounds(205, 181, 100, 30);
        frame.getContentPane().add(l4);
        frame.getContentPane().add(maxa);

        l5.setBounds(24, 223, 150, 30);
        mins.setBounds(205, 223, 100, 30);
        frame.getContentPane().add(l5);
        frame.getContentPane().add(mins);

        l6.setBounds(24, 269, 150, 30);
        maxs.setBounds(205, 269, 100, 30);
        frame.getContentPane().add(l6);
        frame.getContentPane().add(maxs);

        l7.setBounds(24, 311, 150, 30);
        time.setBounds(205, 311, 100, 30);
        frame.getContentPane().add(l7);
        frame.getContentPane().add(time);

        l9.setBounds(24, 395, 150, 30);
        wait.setBounds(205, 395, 100, 30);
        frame.getContentPane().add(l9);
        frame.getContentPane().add(wait);

        l10.setBounds(24, 440, 150, 30);
        serving.setBounds(205, 440, 100, 30);
        frame.getContentPane().add(l10);
        frame.getContentPane().add(serving);


        l11.setBounds(25, 20, 150, 30);
        nclienti.setBounds(205, 20, 100, 30);
        frame.getContentPane().add(l11);
        frame.getContentPane().add(nclienti);
           button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Simulator test = new Simulator(Integer.parseInt(nclienti.getText()),Integer.parseInt(ncozi.getText()), Integer.parseInt(mina.getText()),
                            Integer.parseInt(maxa.getText()), Integer.parseInt(mins.getText()),
                            Integer.parseInt(maxs.getText()), Integer.parseInt(timps.getText()));
                    test.start();
                }
            });

        button.setBounds(467, 612, 200, 50);
        frame.getContentPane().add(button);
        write.setBounds(355, 19, 600, 581);
        frame.getContentPane().add(write);
    }
    public static void setTime(String text) {
        time.setText(text);
    }
    public static void wait(String text) {
        wait.setText(text);
    }
    public static void serving(String text) {
        serving.setText(text);
    }

    public static void main(String arg[]) {
        GUI interfata = new GUI();
        interfata.frame.setVisible(true);

    }
}