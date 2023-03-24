import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class planner extends JFrame {
    private JPanel panelMain;
    private JLabel labelName;
    private JTextField textFieldNaam;
    private JLabel labelUur;
    private JSpinner spinUur;
    private JLabel labelMinuut;
    private JSpinner spinMin;
    private JTextArea textMessage;
    private JButton buttonAddNameDate;
    private JTextArea textAppointments;

    public planner(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        SpinnerNumberModel uurModel = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerNumberModel minModel = new SpinnerNumberModel(0, 0, 59, 1);
        spinUur.setModel(uurModel);
        spinMin.setModel(minModel);
        this.pack();
        buttonAddNameDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String appointment = String.valueOf(textFieldNaam.getText());
                int uur = (int) spinUur.getValue();
                int minuut = (int) spinMin.getValue();
                textAppointments.setText(String.format("%s om %02d:%02d", appointment, uur, minuut));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new planner("Appointment planner");
        frame.setVisible(true);
    }

}



