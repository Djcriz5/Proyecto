package guideUserInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoBuscar extends JDialog{
    private static final long serialVersionUID = -6500078283010200355L;
    private JPanel            buttonPane;
    private JButton           okButton;
    private JButton           cancelButton;
    private JTextField        reposNombre;
    private JLabel            lblNombre;

    public DialogoBuscar() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 461, 224);
        getContentPane().setLayout(null);
        buttonPane = new JPanel();
        buttonPane.setBounds(0, 88, 428, 39);
        buttonPane.setBackground(Color.DARK_GRAY);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane);
        {
            okButton = new JButton("OK");
            okButton.setBackground(new Color(65, 105, 225));
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
        }
        {
            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    setVisible(false);
                }
            });
            cancelButton.setBackground(new Color(220, 20, 60));
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
        }

        reposNombre = new JTextField();
        reposNombre.setBounds(197, 33, 216, 26);
        getContentPane().add(reposNombre);
        reposNombre.setColumns(10);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setBounds(48, 36, 69, 20);
        getContentPane().add(lblNombre);
        this.setVisible(true);
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JTextField getReposNombre() {
        return reposNombre;
    }

    public void setReposNombre(JTextField reposNombre) {
        this.reposNombre = reposNombre;
    }
}