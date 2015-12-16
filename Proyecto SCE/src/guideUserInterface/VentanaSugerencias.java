package guideUserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaSugerencias extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -993343925484792976L;
    private JScrollPane       textPane;
    private JTextArea         txtCAS;
    private ImageIcon         iconoEnviar;
    private JLabel            lblLabelenviar;

    /**
     * Create the frame.
     */
    public VentanaSugerencias() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 587, 576);
        getContentPane().setLayout(null);
        txtCAS = new JTextArea();
        textPane = new JScrollPane();
        textPane.setBounds(55, 150, 464, 353);
        textPane.setViewportView(txtCAS);
        getContentPane().add(textPane);

        lblLabelenviar = new JLabel("");
        lblLabelenviar.setBounds(416, 29, 103, 91);
        iconoEnviar = new ImageIcon(
                new ImageIcon(VentanaSugerencias.class.getResource("/Imagenes/enviar.png")).getImage()
                        .getScaledInstance(lblLabelenviar.getWidth(), lblLabelenviar.getHeight(), Image.SCALE_DEFAULT));
        lblLabelenviar.setIcon(iconoEnviar);
        getContentPane().add(lblLabelenviar);

        JLabel lblQuejasYSugerencias = new JLabel("Quejas y sugerencias");
        lblQuejasYSugerencias.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblQuejasYSugerencias.setForeground(Color.WHITE);
        lblQuejasYSugerencias.setBounds(71, 61, 264, 46);
        getContentPane().add(lblQuejasYSugerencias);
    }

    public JTextArea getTxtCAS() {
        return txtCAS;
    }

    public void setTxtCAS(JTextArea txtCAS) {
        this.txtCAS = txtCAS;
    }

    public JLabel getLblLabelenviar() {
        return lblLabelenviar;
    }

    public void setLblLabelenviar(JLabel lblLabelenviar) {
        this.lblLabelenviar = lblLabelenviar;
    }

}
