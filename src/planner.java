import javax.swing.*;
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

    public planner(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        SpinnerNumberModel uurModel = new SpinnerNumberModel(0, 0, 23, 1);  //hier wordt grens voor uren gezet
        SpinnerNumberModel minModel = new SpinnerNumberModel(0, 0, 59, 1);  //hier wordt grens voor minuten gezet
        spinUur.setModel(uurModel);  //hier wordt spinUur gekoppeld aan de bovenstaande grens
        spinMin.setModel(minModel);  //hier wordt spinMin gekoppeld aan de bovenstaande grens
        spinMin.setModel(minModel);
        this.pack();
        appointments = new ArrayList<String>();  //Hier wordt de array geïnitieerd om de afspraken in op te slaan

        buttonAddNameDate.addActionListener(new ActionListener() {  //Hier gaan we ervoor zorgen dat de knop "Maak afspraak" werkt en in de textAppointments de afsrpaak neerzet en in de textmessage "Afspraak gemaakt!"
            @Override
            public void actionPerformed(ActionEvent e) {
                String appointment = String.valueOf(textFieldNaam.getText());  // Hier wordt de waarde uit de textFieldNaam gepakt om deze in de array te zetten
                int uur = (int) spinUur.getValue();  // hier boven en onder worden de waarden van de jspinners gepakt
                int minuut = (int) spinMin.getValue();
                String newAppointment = String.format("%s om %02d:%02d", appointment, uur, minuut); // hier wordt een string gemaakt met de naam en tijd
                if (appointments.contains(newAppointment)) { //hier wordt de bovenstaande string vergeleken met al bestaande strings in de array
                    textMessage.setText("Afspraak bestaat al!");  // als er al een afspraak is met dezelfde naam en tijd dan krijg je deze tekst in textMessage
                } else {
                    appointments.add(newAppointment);  //bestaat de afspraak nog niet dan wordt deze hier toegevoegd aan de array
                    textAppointments.setText(String.join("\n", appointments));  //hier komt de afsrpaak in de textAppointment te voor schijn
                    textMessage.setText("Afspraak gemaakt!");  //en hier de mededeling in textMessage
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new planner("Appointment planner");  //geeft de frame van de app een titel
        frame.setVisible(true);  //maakt de app zichtbaar
    }

}



