import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



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
    private ArrayList<String> appointments;
    private ArrayList<String> timeSlots;

    public planner(String title) {
        super(title);  // calls de title constructor uit de javax.swing.JFrame(titel vd frame)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // stopt de applicatie als het frame wordt afgesloten
        this.setContentPane(panelMain);  // zorgt ervoor dat panelMain in het frame komt en vult (Content pane is het hoofdpaneel)
        panelMain.setPreferredSize(new Dimension(500, 500));
        setResizable(false);  // hier wordt de grootte v/d panel vastgezet
        SpinnerNumberModel uurModel = new SpinnerNumberModel(0, 0, 23, 1);  // hier worden de grenzen voor uren en minuten gezet
        SpinnerNumberModel minModel = new SpinnerNumberModel(0, 0, 59, 1);  //  ""
        spinUur.setModel(uurModel);  // hier wordt spinUur en spinMin gekoppeld aan de grens hierboven
        spinMin.setModel(minModel);  //  ""
        this.pack();  // Om de frame de juiste grootte te geven voor de inhoud
        appointments = new ArrayList<String>();  // hier wordt de array begonnen om de afspraken in op te slaan
        timeSlots = new ArrayList<String>();  //

        buttonAddNameDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String appointment = String.valueOf(textFieldNaam.getText());  // hier wordt de waarde uit de textFieldNaam gepakt om deze in de array te zetten
                int uur = (int) spinUur.getValue();  // hier wordt de tijden uit de spinners gehaald en naar hun respectievelijke int gezet
                int minuut = (int) spinMin.getValue();  //  ""
                String newTimeSlot = String.format("%02d:%02d", uur, minuut);  //  String om de tijden tussen afspraken mee te vergelijken
                if (timeSlots.contains(newTimeSlot)) {  // hier wordt de boven staande string vergeleken met al bestaande strings in de array
                    textMessage.setText("Afspraak bestaat al!");  // als er al een afspraak is met dezelfde naam en tijd dan krijg je deze tekst in textMessage
                } else {
                    String newAppointment = String.format("%s om %02d:%02d", appointment, uur, minuut);  // hier wordt een string gemaakt met de naam en tijd
                    appointments.add(newAppointment);  // bestaat de afspraak nog niet dan wordt deze hier toegevoegd aan de array
                    timeSlots.add(newTimeSlot);  // de tijden worden omgezet in deze array
                    textAppointments.setText(String.join("\n", appointments));  // hier komt de afspraak in de textAppointment te voor schijn
                    textMessage.setText("Afspraak gemaakt!");
                    textFieldNaam.setText("");  //Resetten van de invoervelden.
                    spinUur.setValue(0);  //  ""
                    spinMin.setValue(0);  //  ""
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new planner("Appointment planner");  // geeft het frame van de app een titel
        frame.setVisible(true);  // maakt de app zichtbaar
    }

}



