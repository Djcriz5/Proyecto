package guideUserInterface;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class VentanaDeCompras extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 8045284595207835913L;
    private JComboBox<String> cbPaqueteDelDia;
    private ImageIcon         iconoBebida;
    private JLabel            lblBebida;
    private JComboBox<String> cbBebida;
    private JButton           btnConfirmarBebida;
    private JLabel            lblGolosina;
    private JComboBox<String> cbGolosina;
    private JButton           btnConfirmarGolosina;
    private JLabel            lblHelado;
    private JComboBox<String> cbHelado;
    private JButton           btnConfirmarHelado;
    private JLabel            lblLacteo;
    private JComboBox<String> cbLacteo;
    private JButton           btnConfirmarLacteo;
    private JLabel            lblPaqueteDelDia;
    private JRadioButton      checkElegirBebida;
    private JComboBox<String> cbIngredienteEs;
    private ImageIcon         iconoHelado;
    private ImageIcon         iconoGolosina;
    private ImageIcon         iconoLacteo;
    private ImageIcon         iconoPaqueteDelDia;
    private ImageIcon         iconoPreparado;
    private JButton           btnConfirmarPaqueteDelDia;
    private JLabel            lblPreparado;
    private JRadioButton      rdbtnIngredienteExtra;
    private JComboBox<String> cbPreparado;
    private JButton           btnConfirmarPreparado;
    private JLabel            lblLblconfirmar;
    private ImageIcon         iconoConfirmar;
    private JLabel            lblLabelhome;
    private ImageIcon         iconoHome;

    /**
     * Create the frame.
     */
    public VentanaDeCompras() {
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        // variables bebida
        lblBebida = new JLabel("Bebida");
        lblBebida.setBounds(55, 21, 105, 105);
        getContentPane().add(lblBebida);
        iconoBebida = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/bebidaicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblBebida.setIcon(iconoBebida);
        getContentPane().add(lblBebida);
        cbBebida = new JComboBox<String>();
        cbBebida.setBackground(Color.WHITE);
        cbBebida.setBounds(45, 135, 115, 26);
        cbBebida.addItem("coca cola");
        cbBebida.addItem("Sprite");
        cbBebida.addItem("Nestea");
        cbBebida.addItem("Manzanita");
        cbBebida.addItem("Fanta");
        cbBebida.addItem("Boing Guayaba");
        cbBebida.addItem("Boing uva");
        cbBebida.addItem("Boing manzana");
        cbBebida.addItem("Agua embotellada");
        getContentPane().add(cbBebida);
        btnConfirmarBebida = new JButton("");
        btnConfirmarBebida.setBackground(new Color(30, 144, 255));
        btnConfirmarBebida.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarBebida.setBounds(175, 124, 42, 37);
        getContentPane().add(btnConfirmarBebida);
        // variables golosina
        lblGolosina = new JLabel("Golosina");
        lblGolosina.setBounds(312, 16, 115, 115);
        iconoGolosina = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/candyicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblGolosina.setIcon(iconoGolosina);
        getContentPane().add(lblGolosina);
        cbGolosina = new JComboBox<String>();
        cbGolosina.setBackground(Color.WHITE);
        cbGolosina.setBounds(312, 135, 115, 26);
        cbGolosina.addItem("Paleta");
        cbGolosina.addItem("Gomitas");
        cbGolosina.addItem("KitKat");
        cbGolosina.addItem("Pasitas");
        cbGolosina.addItem("gansito");
        cbGolosina.addItem("Carlos XV");
        cbGolosina.addItem("lunetas");
        getContentPane().add(cbGolosina);
        btnConfirmarGolosina = new JButton("");
        btnConfirmarGolosina.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarGolosina.setBackground(new Color(30, 144, 255));
        btnConfirmarGolosina.setBounds(442, 124, 42, 37);
        getContentPane().add(btnConfirmarGolosina);
        // variable helado
        lblHelado = new JLabel("Helado");
        lblHelado.setBounds(55, 172, 115, 115);
        iconoHelado = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/icecreamicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblHelado.setIcon(iconoHelado);
        getContentPane().add(lblHelado);
        cbHelado = new JComboBox<String>();
        cbHelado.setBackground(Color.WHITE);
        cbHelado.addItem("Helado de Yogurt");
        cbHelado.addItem("Helado fresa");
        cbHelado.addItem("Helado de Chocolate");
        cbHelado.addItem("Paleta magnum Almendras");
        cbHelado.addItem("Helado Vainilla");
        cbHelado.addItem("Helado de yogurt Taro");
        cbHelado.setBounds(45, 295, 115, 26);
        getContentPane().add(cbHelado);
        btnConfirmarHelado = new JButton("");
        btnConfirmarHelado.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarHelado.setBackground(new Color(30, 144, 255));
        btnConfirmarHelado.setBounds(175, 284, 42, 37);
        getContentPane().add(btnConfirmarHelado);
        // variables Lacteo

        lblLacteo = new JLabel("Lacteo");
        lblLacteo.setBounds(312, 177, 115, 115);
        iconoLacteo = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/milkicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblLacteo.setIcon(iconoLacteo);
        getContentPane().add(lblLacteo);
        cbLacteo = new JComboBox<String>();
        cbLacteo.setBackground(Color.WHITE);
        cbLacteo.setBounds(312, 295, 115, 26);
        cbLacteo.addItem("Griego Yoplait");
        cbLacteo.addItem("Yoplait de fresa");
        cbLacteo.addItem("Yoplait de Manzana");
        cbLacteo.addItem("Leche 400ml Santa clara");
        cbLacteo.addItem("Leche Deslactosada 400ml Santa clara");
        cbLacteo.addItem("Jugo Ades");
        getContentPane().add(cbLacteo);
        btnConfirmarLacteo = new JButton("");
        btnConfirmarLacteo.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarLacteo.setBackground(new Color(30, 144, 255));
        btnConfirmarLacteo.setBounds(442, 284, 42, 37);
        getContentPane().add(btnConfirmarLacteo);
        setBounds(0, 0, 757, 611);
        // variables paquete del dia
        lblPaqueteDelDia = new JLabel("Paquete del Dia");
        lblPaqueteDelDia.setBounds(55, 326, 120, 134);
        iconoPaqueteDelDia = new ImageIcon(
                new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/paqueteDelDia.png")).getImage()
                        .getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblPaqueteDelDia.setIcon(iconoPaqueteDelDia);
        getContentPane().add(lblPaqueteDelDia);
        cbPaqueteDelDia = new JComboBox<String>();
        cbPaqueteDelDia.setBackground(new Color(0, 0, 0));
        cbPaqueteDelDia.setEnabled(false);
        cbPaqueteDelDia.addItem("coca cola");
        cbPaqueteDelDia.addItem("Sprite");
        cbPaqueteDelDia.addItem("Nestea");
        cbPaqueteDelDia.addItem("Manzanita");
        cbPaqueteDelDia.addItem("Fanta");
        cbPaqueteDelDia.addItem("Boing Guayaba");
        cbPaqueteDelDia.addItem("Boing uva");
        cbPaqueteDelDia.addItem("Boing manzana");
        cbPaqueteDelDia.addItem("Agua embotellada");
        cbPaqueteDelDia.setBounds(55, 500, 154, 26);
        getContentPane().add(cbPaqueteDelDia);
        checkElegirBebida = new JRadioButton("Elegir bebida");
        checkElegirBebida.setBackground(new Color(30, 144, 255));
        checkElegirBebida.setBounds(55, 459, 155, 29);
        getContentPane().add(checkElegirBebida);

        btnConfirmarPaqueteDelDia = new JButton("");
        btnConfirmarPaqueteDelDia.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarPaqueteDelDia.setBackground(new Color(30, 144, 255));
        btnConfirmarPaqueteDelDia.setBounds(224, 489, 42, 37);
        getContentPane().add(btnConfirmarPaqueteDelDia);
        // variables Preparado
        cbIngredienteEs = new JComboBox<String>();
        cbIngredienteEs.setBackground(new Color(0, 0, 0));
        cbIngredienteEs.setEnabled(false);
        cbIngredienteEs.setBounds(312, 500, 152, 26);
        cbIngredienteEs.addItem("jamon extra");
        cbIngredienteEs.addItem("Pechuga de pavo");
        cbIngredienteEs.addItem("queso extra");
        cbIngredienteEs.addItem("Aguacate");
        cbIngredienteEs.addItem("Aderezos");
        cbIngredienteEs.addItem("Guacamole");
        cbIngredienteEs.addItem("BBq");
        cbIngredienteEs.addItem("Wasabi");
        getContentPane().add(cbIngredienteEs);
        lblPreparado = new JLabel("Preparado");
        lblPreparado.setBounds(312, 337, 115, 115);
        iconoPreparado = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/preparadoIcon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblPreparado.setIcon(iconoPreparado);
        getContentPane().add(lblPreparado);
        rdbtnIngredienteExtra = new JRadioButton("ingrediente extra");
        rdbtnIngredienteExtra.setBackground(new Color(30, 144, 255));
        rdbtnIngredienteExtra.setBounds(312, 459, 155, 29);
        getContentPane().add(rdbtnIngredienteExtra);
        cbPreparado = new JComboBox<String>();
        cbPreparado.addItem("Sandwich");
        cbPreparado.addItem("Sushi");
        cbPreparado.addItem("Molletes");
        cbPreparado.addItem("Tortas");
        cbPreparado.addItem("Ensalada de Atun");
        cbPreparado.addItem("Ensalada de pollo");
        cbPreparado.addItem("Pechuga Empanisada con ensalada");
        cbPreparado.addItem("Enchiladas");
        cbPreparado.addItem("Orden de tacos");
        cbPreparado.addItem("Guisado Del dia");
        cbPreparado.setBounds(478, 460, 152, 26);
        getContentPane().add(cbPreparado);
        btnConfirmarPreparado = new JButton("");
        btnConfirmarPreparado.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarPreparado.setBackground(new Color(30, 144, 255));
        btnConfirmarPreparado.setBounds(479, 489, 42, 37);
        getContentPane().add(btnConfirmarPreparado);

        lblLblconfirmar = new JLabel("");
        lblLblconfirmar.setBounds(645, 433, 96, 93);
        iconoConfirmar = new ImageIcon(
                new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/check.png")).getImage().getScaledInstance(
                        lblLblconfirmar.getWidth(), lblLblconfirmar.getHeight(), Image.SCALE_DEFAULT));
        lblLblconfirmar.setIcon(iconoConfirmar);
        getContentPane().add(lblLblconfirmar);

        setLblLabelhome(new JLabel(""));
        getLblLabelhome().setBounds(600, 21, 126, 124);
        iconoHome = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/home-icon.png"))
                .getImage()
                .getScaledInstance(getLblLabelhome().getWidth(), getLblLabelhome().getHeight(), Image.SCALE_DEFAULT));
        getLblLabelhome().setIcon(iconoHome);
        getContentPane().add(getLblLabelhome());
    }

    public JButton getBtnConfirmarPreparado() {
        return btnConfirmarPreparado;
    }

    public void setBtnConfirmarPreparado(JButton btnConfirmarPreparado) {
        this.btnConfirmarPreparado = btnConfirmarPreparado;
    }

    public JRadioButton getRdbtnIngredienteExtra() {
        return rdbtnIngredienteExtra;
    }

    public void setRdbtnIngredienteExtra(JRadioButton rdbtnIngredienteExtra) {
        this.rdbtnIngredienteExtra = rdbtnIngredienteExtra;
    }

    public JComboBox<String> getCbPreparado() {
        return cbPreparado;
    }

    public void setCbPreparado(JComboBox<String> cbPreparado) {
        this.cbPreparado = cbPreparado;
    }

    public JComboBox<String> getCbIngredienteEs() {
        return cbIngredienteEs;
    }

    public void setCbIngredienteEs(JComboBox<String> cbIngredienteEs) {
        this.cbIngredienteEs = cbIngredienteEs;
    }

    public JButton getBtnConfirmarBebida() {
        return btnConfirmarBebida;
    }

    public void setBtnConfirmarBebida(JButton btnConfirmarBebida) {
        this.btnConfirmarBebida = btnConfirmarBebida;
    }

    public JComboBox<String> getCbBebida() {
        return cbBebida;
    }

    public void setCbBebida(JComboBox<String> cbBebida) {
        this.cbBebida = cbBebida;
    }

    public JButton getBtnConfirmarGolosina() {
        return btnConfirmarGolosina;
    }

    public void setBtnConfirmarGolosina(JButton btnConfirmarGolosina) {
        this.btnConfirmarGolosina = btnConfirmarGolosina;
    }

    public JComboBox<String> getCbGolosina() {
        return cbGolosina;
    }

    public void setCbGolosina(JComboBox<String> cbGolosina) {
        this.cbGolosina = cbGolosina;
    }

    public JButton getBtnConfirmarHelado() {
        return btnConfirmarHelado;
    }

    public void setBtnConfirmarHelado(JButton btnConfirmarHelado) {
        this.btnConfirmarHelado = btnConfirmarHelado;
    }

    public JComboBox<String> getCbHelado() {
        return cbHelado;
    }

    public void setCbHelado(JComboBox<String> cbHelado) {
        this.cbHelado = cbHelado;
    }

    public JButton getBtnConfirmarLacteo() {
        return btnConfirmarLacteo;
    }

    public void setBtnConfirmarLacteo(JButton btnConfirmarLacteo) {
        this.btnConfirmarLacteo = btnConfirmarLacteo;
    }

    public JComboBox<String> getCbLacteo() {
        return cbLacteo;
    }

    public void setCbLacteo(JComboBox<String> cbLacteo) {
        this.cbLacteo = cbLacteo;
    }

    public JRadioButton getCheckElegirBebida() {
        return checkElegirBebida;
    }

    public void setCheckElegirBebida(JRadioButton checkElegirBebida) {
        this.checkElegirBebida = checkElegirBebida;
    }

    public JComboBox<String> getCbPaqueteDelDia() {
        return cbPaqueteDelDia;
    }

    public void setCbPaqueteDelDia(JComboBox<String> cbPaqueteDelDia) {
        this.cbPaqueteDelDia = cbPaqueteDelDia;
    }

    public JButton getBtnConfirmarPaqueteDelDia() {
        return btnConfirmarPaqueteDelDia;
    }

    public void setBtnConfirmarPaqueteDelDia(JButton btnConfirmarPaqueteDelDia) {
        this.btnConfirmarPaqueteDelDia = btnConfirmarPaqueteDelDia;
    }

    public JLabel getLblLblconfirmar() {
        return lblLblconfirmar;
    }

    public void setLblLblconfirmar(JLabel lblLblconfirmar) {
        this.lblLblconfirmar = lblLblconfirmar;
    }

    public JLabel getLblLabelhome() {
        return lblLabelhome;
    }

    public void setLblLabelhome(JLabel lblLabelhome) {
        this.lblLabelhome = lblLabelhome;
    }

}
