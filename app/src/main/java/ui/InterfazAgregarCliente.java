package ui;

import javax.swing.*;
import java.awt.*;
import model.*;



public class InterfazAgregarCliente extends JFrame {
    public InterfazAgregarCliente() {
        // Configurar el marco
        setTitle("CLIENTES");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etiqueta "CLIENTES"
        JLabel titleLabel = new JLabel("CLIENTES");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(150, 10, 100, 30);
        panel.add(titleLabel);

        // Etiqueta y campo de texto para "Cédula"
        JLabel cedulaLabel = new JLabel("Cédula:");
        cedulaLabel.setBounds(50, 60, 100, 25);
        panel.add(cedulaLabel);

        JTextField cedulaField = new JTextField();
        cedulaField.setBounds(150, 60, 180, 25);
        panel.add(cedulaField);

        // Etiqueta y campo de texto para "Nombre"
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(50, 100, 100, 25);
        panel.add(nombreLabel);

        JTextField nombreField = new JTextField();
        nombreField.setBounds(150, 100, 180, 25);
        panel.add(nombreField);
        // Etiqueta y cuadro de texto para "¿Vigente?"
        JLabel vigenteLabel = new JLabel("¿Vigente ?: ");
        vigenteLabel.setBounds(50, 140, 100, 25);
        panel.add(vigenteLabel);

        JCheckBox vigenteCheckbox = new JCheckBox();
        vigenteCheckbox.setBounds(150, 140, 50, 25);
        vigenteCheckbox.setSelected(true);
        panel.add(vigenteCheckbox);

        // Botón "Agregar"
        JButton agregarButton = new JButton("Agregar");
        agregarButton.setBounds(150, 190, 100, 30);
        panel.add(agregarButton);

        // agregar listener al botón "Agregar"
        agregarButton.addActionListener(e -> {
            agregarClienteHandler(cedulaField, nombreField,  vigenteCheckbox, this);
        });

        // Agregar el panel al marco
        add(panel);
}

private void agregarClienteHandler(
    JTextField cedulaField, 
    JTextField nombreField, 
    JCheckBox vigenteCheckbox, 
    JFrame frame) { 
        String cedula = cedulaField.getText();
        String nombre = nombreField.getText();
        boolean vigente = vigenteCheckbox.isSelected();
        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por   favorcomplete todos los campos");
            return;
        }
        if (!isCedulaValid(cedula)) {
            JOptionPane.showMessageDialog(this, "La cédula   ingresada no es válida");
            return;
        }

        //Crear un nuevo cliente
        Cliente cliente = new Cliente(cedula, nombre, vigente);

        // Agregar el cliente a la lista
        Global.clientes.add(cliente);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente");

        // instanciar la interfaz de arriendo
        JFrame interfazArriendo = new InterfazArriendo();
        
        // mostrar la interfaz
        interfazArriendo.setVisible(true);

        // Cerrar la interfaz actual
        frame.dispose();
    }

    private boolean isCedulaValid(String cedula) {
    //quitar espacios en blanco,puntos y guiones
    cedula = cedula.trim().replace(".", "").replace("-", "");
    //separar número y digito verificador
    String numero = cedula.substring(0, cedula.length() - 1);
    char dvIngresado = cedula.charAt(cedula.length() - 1);

    char[] digitos = numero.toCharArray();
    int[] secuencia = {2,3,4,5,6,7};

    int suma = 0;
    int j = 0;
    for (int i = digitos.length - 1; i >= 0; i--) {
        suma += Character.getNumericValue(digitos[i]) * secuencia[j];
        j = (j + 1) % secuencia.length;
    }

    int resto = suma % 11;
    int dvCalculado = 11 - resto;

    char dvEsperado;
    if (dvCalculado == 10) {
        dvEsperado = 'K';
    } else if (dvCalculado == 11) {
        dvEsperado = '0';
    } else {
        dvEsperado = (char) (dvCalculado + '0');
    }

    return dvIngresado == dvEsperado;
    }

}
