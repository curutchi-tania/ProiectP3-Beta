import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Application {
    private JFrame frame;
    private JPanel mainPanel;
    private DealershipDatabase db;

    private void displayCarsPage() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setPreferredSize(new Dimension(800,400));

        JLabel dealershipTitle = new JLabel("Cars");
        mainPanel.add(dealershipTitle);

        List<Masina> masini = db.getMasini();

        for (Masina masina : masini) {
            JPanel masinaPanel = new JPanel();
            masinaPanel.setBackground(Color.gray);

            JLabel marca = new JLabel(masina.getMarca());
            masinaPanel.add(marca);

            JLabel description = new JLabel(masina.getDescriere());
            masinaPanel.add(description);

            mainPanel.add(masinaPanel);
        }

        frame.getContentPane().add(mainPanel);
    }

    public void run() {
        db = new DealershipDatabase();
        db.connect();
        frame = new JFrame("Dealership");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                db.closeConnection();
            }
        });
        displayCarsPage();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
