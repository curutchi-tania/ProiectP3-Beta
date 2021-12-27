import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application {
    private JFrame frame;
    private JPanel mainPanel;
    private DealershipDatabase db;

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
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800,400));
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
