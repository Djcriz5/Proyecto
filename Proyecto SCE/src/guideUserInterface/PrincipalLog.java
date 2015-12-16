package guideUserInterface;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PrincipalLog {
    public JFrame            frame;
    public JDesktopPane      desktopPane;
    private ImageIcon        icono;
    private ImageIcon        iconoaux;
    private JLabel           lblNewLabel;
    private JInternalFrame   internalLogin;
    private JTextField       reposNombre;
    private JLabel           lblUsuario;
    private JPasswordField   passwordField;
    private JLabel           lblContrasena;
    private JButton          btnSingUp;
    private JLabel           Mensaje;
    private JButton          btnSingIn;
    private VentanaDeCompras shop;
    private JTextField       txtRepostargeta;
    private JRadioButton     rdbtnAadirTargeta;
    private JLabel           lblExit;
    private ImageIcon        iconExit;

    /**
     * Create the application.
     */
    public PrincipalLog() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        try {
            frame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar cargar L&F");
        }
        frame = new JFrame();
        frame.setSize(900, 700);
        frame.setResizable(false);
        desktopPane = new JDesktopPane();
        desktopPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        ;
        frame.setContentPane(desktopPane);

        lblNewLabel = new JLabel("Login");
        lblNewLabel.setBounds(new Rectangle(0, 0, 900, 660));
        icono = new ImageIcon(PrincipalLog.class.getResource("/Imagenes/desktop.png"));
        iconoaux = new ImageIcon(icono.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
                Image.SCALE_DEFAULT));

        lblExit = new JLabel("");
        lblExit.setBounds(742, 50, 105, 108);
        iconExit = new ImageIcon(new ImageIcon(PrincipalLog.class.getResource("/Imagenes/salir.png")).getImage()
                .getScaledInstance(lblExit.getWidth(), lblExit.getHeight(), Image.SCALE_DEFAULT));
        lblExit.setIcon(iconExit);
        desktopPane.add(lblExit);
        lblNewLabel.setIcon(iconoaux);
        desktopPane.add(lblNewLabel);

        internalLogin = new JInternalFrame("Login");
        internalLogin.getContentPane().setBackground(Color.DARK_GRAY);
        internalLogin.setBackground(Color.DARK_GRAY);
        internalLogin.setBounds(184, 145, 489, 422);
        desktopPane.add(internalLogin);
        internalLogin.getContentPane().setLayout(null);

        reposNombre = new JTextField();
        reposNombre.setBounds(185, 97, 183, 26);
        internalLogin.getContentPane().add(reposNombre);
        reposNombre.setColumns(10);

        lblUsuario = new JLabel("Usuario");
        lblUsuario.setBackground(Color.WHITE);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(70, 97, 85, 23);
        internalLogin.getContentPane().add(lblUsuario);

        passwordField = new JPasswordField();
        passwordField.setBounds(185, 156, 183, 26);
        internalLogin.getContentPane().add(passwordField);

        lblContrasena = new JLabel("Password");
        lblContrasena.setBackground(Color.WHITE);
        lblContrasena.setForeground(Color.WHITE);
        lblContrasena.setBounds(70, 159, 85, 23);
        internalLogin.getContentPane().add(lblContrasena);

        btnSingUp = new JButton("Sing Up");
        btnSingUp.setBackground(new Color(65, 105, 225));
        btnSingUp.setBounds(253, 246, 115, 29);
        internalLogin.getContentPane().add(btnSingUp);

        Mensaje = new JLabel("Ya tienes una cuenta?");
        Mensaje.setBackground(Color.WHITE);
        Mensaje.setForeground(Color.WHITE);
        Mensaje.setBounds(70, 294, 162, 23);
        internalLogin.getContentPane().add(Mensaje);

        setBtnSingIn(new JButton("Sing in"));
        getBtnSingIn().setBackground(new Color(65, 105, 225));
        getBtnSingIn().setBounds(253, 291, 115, 29);
        internalLogin.getContentPane().add(getBtnSingIn());

        rdbtnAadirTargeta = new JRadioButton("Usar targeta");
        rdbtnAadirTargeta.setForeground(Color.WHITE);
        rdbtnAadirTargeta.setBackground(Color.DARK_GRAY);
        rdbtnAadirTargeta.setBounds(42, 194, 140, 26);
        internalLogin.getContentPane().add(rdbtnAadirTargeta);
        txtRepostargeta = new JTextField();
        txtRepostargeta.setVisible(false);
        txtRepostargeta.setEnabled(false);
        txtRepostargeta.setBorder(null);
        txtRepostargeta.setBounds(185, 198, 183, 26);
        txtRepostargeta.setBackground(Color.WHITE);
        internalLogin.getContentPane().add(txtRepostargeta);
        txtRepostargeta.setColumns(10);
        internalLogin.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JRadioButton getRdbtnAadirTargeta() {
        return rdbtnAadirTargeta;
    }

    public void setRdbtnAadirTargeta(JRadioButton rdbtnAadirTargeta) {
        this.rdbtnAadirTargeta = rdbtnAadirTargeta;
    }

    public JTextField getTxtRepostargeta() {
        return txtRepostargeta;
    }

    public void setTxtRepostargeta(JTextField txtRepostargeta) {
        this.txtRepostargeta = txtRepostargeta;
    }

    public JLabel getLblExit() {
        return lblExit;
    }

    public void setLblExit(JLabel lblExit) {
        this.lblExit = lblExit;
    }

    public JButton getBtnSingIn() {
        return btnSingIn;
    }

    public void setBtnSingIn(JButton btnSingIn) {
        this.btnSingIn = btnSingIn;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JTextField getReposNombre() {
        return reposNombre;
    }

    public void setReposNombre(JTextField reposNombre) {
        this.reposNombre = reposNombre;
    }

    public JInternalFrame getInternalLogin() {
        return internalLogin;
    }

    public void setInternalLogin(JInternalFrame internalLogin) {
        this.internalLogin = internalLogin;
    }

    public JButton getBtnSingUp() {
        return btnSingUp;
    }

    public void setBtnSingUp(JButton btnSingUp) {
        this.btnSingUp = btnSingUp;
    }
}
