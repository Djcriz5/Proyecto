package guideUserInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DialogoNuevoCliente extends JDialog {

    private static final long serialVersionUID = -6500078283010200355L;
    private JPanel            buttonPane;
    private JButton           okButton;
    private JButton           cancelButton;
    private JTextField        reposNombre;
    private JTextField        reposPassWord;
    private JTextField        repostargeta;
    private JLabel            lblNombre;
    private JLabel            lblPassword;
    private JRadioButton      rdbtnUsarTargeta;

    public DialogoNuevoCliente() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 523, 371);
        getContentPane().setLayout(null);
        buttonPane = new JPanel();
        buttonPane.setBounds(0, 205, 428, 39);
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

        reposPassWord = new JTextField();
        reposPassWord.setColumns(10);
        reposPassWord.setBounds(197, 75, 216, 26);
        getContentPane().add(reposPassWord);

        repostargeta = new JTextField();
        repostargeta.setVisible(false);
        repostargeta.setColumns(10);
        repostargeta.setBounds(197, 119, 216, 26);
        getContentPane().add(repostargeta);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setBounds(48, 36, 69, 20);
        getContentPane().add(lblNombre);

        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(48, 78, 79, 20);
        getContentPane().add(lblPassword);

        rdbtnUsarTargeta = new JRadioButton("Usar targeta");
        rdbtnUsarTargeta.setForeground(Color.WHITE);
        rdbtnUsarTargeta.setBackground(Color.DARK_GRAY);
        rdbtnUsarTargeta.setBounds(41, 118, 155, 29);
        getContentPane().add(rdbtnUsarTargeta);
        rdbtnUsarTargeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rdbtnUsarTargeta.isSelected()) {
                    repostargeta.setVisible(true);
                    repostargeta.setEnabled(true);
                } else {
                    repostargeta.setVisible(false);
                    repostargeta.setEnabled(false);
                }
            }
        });
        this.setVisible(true);
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JRadioButton getRdbtnUsarTargeta() {
        return rdbtnUsarTargeta;
    }

    public void setRdbtnUsarTargeta(JRadioButton rdbtnUsarTargeta) {
        this.rdbtnUsarTargeta = rdbtnUsarTargeta;
    }

    public JTextField getReposNombre() {
        return reposNombre;
    }

    public void setReposNombre(JTextField reposNombre) {
        this.reposNombre = reposNombre;
    }

    public JTextField getReposPassWord() {
        return reposPassWord;
    }

    public void setReposPassWord(JTextField reposPassWord) {
        this.reposPassWord = reposPassWord;
    }

    public JTextField getRepostargeta() {
        return repostargeta;
    }

    public void setRepostargeta(JTextField repostargeta) {
        this.repostargeta = repostargeta;
    }
}
