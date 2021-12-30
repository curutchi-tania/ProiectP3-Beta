import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class FrameComenzi {
    private JFrame comenziFrame;
    private DealershipDatabase db;
    private JPanel comenziPanel;

    private void displayComenziPage() {
        comenziPanel = new JPanel();
        comenziPanel.setLayout(new BoxLayout(comenziPanel, BoxLayout.PAGE_AXIS));
        comenziPanel.setPreferredSize(new Dimension(800, 400));


        JLabel comenziDescription = new JLabel("Lista comenzilor");
        comenziPanel.add(comenziDescription);

        List<Comanda> comenzi = db.getComenzi();

        for (Comanda comanda : comenzi) {
            JPanel comandaPanel = new JPanel();

            //comandaPanel.setMaximumSize(new Dimension(300, 1000000000));
            comandaPanel.setPreferredSize(new Dimension(700,500));

            JLabel id = new JLabel("Numarul comenzii: " + comanda.getId());
            comandaPanel.add(id);

            JLabel data = new JLabel("Data comenzii: " + comanda.getData());
            comandaPanel.add(data);

            JLabel cantitate = new JLabel("Cantititate comanda: " + comanda.getCantitate());
            comandaPanel.add(cantitate);

            JLabel status = new JLabel("Statusul comenzii: " + comanda.getStatus());
            comandaPanel.add(status);

            JLabel idmasina = new JLabel("ID-ul masinii comandate: " + comanda.getIdMasina());
            comandaPanel.add(idmasina);

            JLabel idclient = new JLabel("ID-ul clientului care a facut comanda: " + comanda.getIdClient());
            comandaPanel.add(idclient);

            comenziPanel.add(comandaPanel);
        }
        comenziFrame.getContentPane().add(comenziPanel);
    }
    public void runComenzi() {
        db = new DealershipDatabase();
        db.connect();
        comenziFrame = new JFrame("Comenzi");
        comenziFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comenziFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                db.closeConnection();
            }
        });
        displayComenziPage();
        comenziFrame.pack();
        comenziFrame.setLocationRelativeTo(null);
        comenziFrame.setVisible(true);
    }
}
