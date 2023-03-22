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
    private JSpinner spinnerMinute;
public planner() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panelMain);
    this.pack();

    addPerson.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = textName.getText();
            SpinnerNumberModel hourModel = new SpinnerNumberModel(0, 0, 23, 1);
            spinnerHour = new JSpinner(hourModel);
            int hour = (int) spinnerHour.getValue();

            textAppointments.setText(name +" at "+ hour);
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new planner();
        frame.setVisible(true);
    }
}
