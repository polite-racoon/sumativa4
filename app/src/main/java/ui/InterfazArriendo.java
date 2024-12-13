package ui;

import javax.swing.*;
import java.awt.*;
import model.*;

public class InterfazArriendo extends JFrame{

    private int montoPagar = 0;

    public InterfazArriendo() {
        // Crear el marco principal
        setTitle("ARRIENDOS CON CUOTAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etiqueta principal
        JLabel lblTitle = new JLabel("ARRIENDOS CON CUOTAS", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(180, 10, 240, 30);
        panel.add(lblTitle);

        // Combobox de cliente
        JLabel lblCliente = new JLabel("Seleccione CLIENTE:");
        lblCliente.setBounds(20, 50, 150, 20);
        panel.add(lblCliente);

        JComboBox<String> comboCliente = new JComboBox<>();
        comboCliente.setBounds(170, 50, 150, 25);
        // Agregar clientes al combobox
        for (Cliente cliente : Global.clientes) {
            comboCliente.addItem(cliente.getNombre());
        }
        panel.add(comboCliente);

        JButton btnNuevoCliente = new JButton("Ingresar nuevo Cliente");
        btnNuevoCliente.setBounds(330, 50, 200, 25);
        panel.add(btnNuevoCliente);

        // Combobox de automóvil
        JLabel lblAutomovil = new JLabel("Seleccione AUTOMOVIL:");
        lblAutomovil.setBounds(20, 90, 150, 20);
        panel.add(lblAutomovil);

        JComboBox<String> comboAutomovil = new JComboBox<>();
        comboAutomovil.setBounds(170, 90, 150, 25);
        // Agregar automóviles al combobox
        for (Automovil automovil : Global.automoviles) {
            comboAutomovil.addItem(automovil.getPatente() + " " + automovil.getCondicion());
        }
        panel.add(comboAutomovil);

        // Panel de información de arriendo
        JLabel lblFechaArriendo = new JLabel("Fecha Arriendo:");
        lblFechaArriendo.setBounds(20, 140, 100, 20);
        panel.add(lblFechaArriendo);

        JTextField txtFechaArriendo = new JTextField();
        txtFechaArriendo.setBounds(130, 140, 100, 25);
        panel.add(txtFechaArriendo);

        JLabel lblDias = new JLabel("Días:");
        lblDias.setBounds(20, 180, 50, 20);
        panel.add(lblDias);

        JTextField txtDias = new JTextField();
        txtDias.setBounds(130, 180, 100, 25);
        panel.add(txtDias);

        JLabel lblPrecioDia = new JLabel("Precio por día:");
        lblPrecioDia.setBounds(20, 220, 100, 20);
        panel.add(lblPrecioDia);

        JTextField txtPrecioDia = new JTextField();
        txtPrecioDia.setBounds(130, 220, 100, 25);
        panel.add(txtPrecioDia);

        JLabel lblCantidadCuotas = new JLabel("Cantidad de cuotas:");
        lblCantidadCuotas.setBounds(250, 140, 150, 20);
        lblCantidadCuotas.setText("0");
        panel.add(lblCantidadCuotas);

        JTextField txtCantidadCuotas = new JTextField();
        txtCantidadCuotas.setBounds(400, 140, 100, 25);
        panel.add(txtCantidadCuotas);

        JButton btnGuardar = new JButton("Guardar arriendo y mostrar cuotas >>");
        btnGuardar.setBounds(250, 180, 250, 25);
        panel.add(btnGuardar);

        JLabel lblMontoPagar = new JLabel("MONTO A PAGAR:");
        lblMontoPagar.setBounds(20, 260, 150, 20);
        panel.add(lblMontoPagar);

        JTextField txtMontoPagar = new JTextField();
        txtMontoPagar.setBounds(130, 260, 100, 25);
        txtMontoPagar.setEditable(false);
        txtMontoPagar.setText(String.valueOf(montoPagar));
        panel.add(txtMontoPagar);

        // Panel de cuotas a pagar
        JLabel lblCuotas = new JLabel("CUOTAS A PAGAR:");
        lblCuotas.setBounds(400, 220, 150, 20);
        panel.add(lblCuotas);

        JTextArea txtCuotas = new JTextArea();
        txtCuotas.setBounds(400, 250, 150, 70);
        txtCuotas.setEditable(false);
        panel.add(txtCuotas);

        JButton btnPagarCuota = new JButton("Pagar Primera Cuota");
        btnPagarCuota.setBounds(400, 330, 150, 25);
        panel.add(btnPagarCuota);

        // agregar listener al botón "Ingresar nuevo Cliente"
        btnNuevoCliente.addActionListener(e -> {
            JFrame interfazAgregarCliente = new InterfazAgregarCliente();
            interfazAgregarCliente.setVisible(true);
            // Cerrar la ventana actual
            this.dispose();
        });

        // agregar listener al botón "Pagar cuotas
        btnPagarCuota.addActionListener(e -> {
            JFrame interfazPagarCuotas = new InterfazPagarCuotas();
            interfazPagarCuotas.setVisible(true);
            // Cerrar la ventana actual
        });
        add(panel);
    }
}
