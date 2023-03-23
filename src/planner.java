import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class planner extends JFrame {
    private JPanel panelMain;
    private JLabel labelName;
    private JTextField textFieldNaam;
    private JLabel labelUur;
    private JSpinner spinner1;
    private JLabel labelMinuut;
    private JSpinner spinner2;
    private JTextArea textMessage;
    private JButton buttonAddNameDate;
    private JTextArea textAppointments;

    public planner(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        this.pack();
    }
//Testing Github
    public static void main(String[] args) {
        JFrame frame = new planner("Appointment planner");
        frame.setVisible(true);
    }
}



