package guideUserInterface;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TicketDeCompra extends JInternalFrame {
    private JTextArea         txtCAS;
    private JButton           btnNewButton;
    private JScrollPane       textPane;

    /**
     * 
     */
    private static final long serialVersionUID = -5415219723574567702L;

    /**
     * Create the frame.
     */
    public TicketDeCompra(String contenido) {
        setResizable(true);
        setBounds(100, 100, 538, 499);
        getContentPane().setLayout(null);
        txtCAS = new JTextArea();
        textPane = new JScrollPane();
        textPane.setBounds(0, 96, 522, 362);
        txtCAS.setText(contenido);
        textPane.setViewportView(txtCAS);
        getContentPane().add(textPane);
        btnNewButton = new JButton("Ticket de compra");
        btnNewButton.setBackground(new Color(0, 153, 255));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBounds(0, 0, 522, 95);
        getContentPane().add(btnNewButton);
    }

    public JButton getBtnNewButton() {
        return btnNewButton;
    }

    public void setBtnNewButton(JButton btnNewButton) {
        this.btnNewButton = btnNewButton;
    }

    public JScrollPane getTextPane() {
        return textPane;
    }

    public void setTextPane(JScrollPane textPane) {
        this.textPane = textPane;
    }
}
