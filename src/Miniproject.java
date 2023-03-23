import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Miniproject extends JFrame {
    private JPanel panelmain;
    private JLabel Name;
    private JTextField textField1;
    private JButton OKButton;
    private JPanel panelButton1;
public Miniproject() {
    textField1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(OKButton, textField1.getText()+ " hello!");

        }
    });
}

    public static void main(String[] args) {

    }
}
