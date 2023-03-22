import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class planner extends JFrame {
    private JLabel name;
    private JPanel panelMain;
    private JTextField textName;
    private JLabel timeSlot;
    private JLabel hour;
    private JLabel minute;
    private JTextArea textMessage;
    private JButton addPerson;
    private JTextArea textAppointments;
    private JSpinner spinnerHour;
    int theHour;
    private JSpinner spinnerMinute;
    int theMin;

    public planner() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        createUIComponents();

        addPerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                theHour = (int) spinnerHour.getValue();
                theMin = (int) spinnerMinute.getValue();
                textAppointments.setText(name + " at " + theHour + ":" + theMin);
            }
        });

        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new planner();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        SpinnerNumberModel spinnerHour = new SpinnerNumberModel(0, 0, 23, 1);
        theHour = (int) spinnerHour.getValue();

        SpinnerNumberModel spinnerMinute = new SpinnerNumberModel(0, 0, 59, 1);
        theMin = (int) spinnerMinute.getValue();
        }
}
