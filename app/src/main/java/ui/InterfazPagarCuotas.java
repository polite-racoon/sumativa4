package ui;

import javax.swing.*;
import java.awt.*;

public class InterfazPagarCuotas extends JFrame {

    public InterfazPagarCuotas() {
        // Crear el marco principal
        setTitle("Pagar Cuotas Arriendos");
        setSize(800, 400);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etiqueta "PAGAR CUOTAS ARRIENDOS"
        JLabel titleLabel = new JLabel("PAGAR CUOTAS ARRIENDOS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(200, 10, 250, 30);
        panel.add(titleLabel);

        // ComboBox para seleccionar cliente
        JLabel clienteLabel = new JLabel("Seleccione cliente");
        clienteLabel.setBounds(50, 50, 150, 25);
        panel.add(clienteLabel);

        JComboBox<String> clienteComboBox = new JComboBox<>();
        clienteComboBox.setBounds(200, 50, 250, 25);
        panel.add(clienteComboBox);

        // Lista para seleccionar arriendo
        JLabel arriendoLabel = new JLabel("Seleccione arriendo:");
        arriendoLabel.setBounds(50, 100, 150, 25);
        panel.add(arriendoLabel);

        JList<String> arriendoList = new JList<>();
        JScrollPane arriendoScrollPane = new JScrollPane(arriendoList);
        arriendoScrollPane.setBounds(50, 130, 150, 150);
        panel.add(arriendoScrollPane);

        // Botón para mostrar pagos
        JButton mostrarPagosButton = new JButton("Mostrar pagos arriendo seleccionado >>>");
        mostrarPagosButton.setBounds(220, 180, 300, 30);
        panel.add(mostrarPagosButton);

        // Tabla para mostrar pagos
        JLabel pagosLabel = new JLabel("PAGOS");
        pagosLabel.setFont(new Font("Arial", Font.BOLD, 14));
        pagosLabel.setBounds(610, 100, 100, 25);
        panel.add(pagosLabel);

        String[] columnNames = {"Número", "Valor", "¿Pagada?"};
        Object[][] data = new Object[5][3]; // Ejemplo con 5 filas
        JTable pagosTable = new JTable(data, columnNames);
        JScrollPane pagosScrollPane = new JScrollPane(pagosTable);
        pagosScrollPane.setBounds(540, 130, 200, 150);
        panel.add(pagosScrollPane);

        // Botón para realizar pago
        JButton realizarPagoButton = new JButton("Realizar Pago");
        realizarPagoButton.setBounds(300, 300, 150, 30);
        panel.add(realizarPagoButton);

        // listener boton realizar pago
        realizarPagoButton.addActionListener(e -> {
            realizarPagoHandler(pagosTable);
        });

        // Agregar el panel al marco
        add(panel);
    }

    private void realizarPagoHandler(JTable pagosTable) {
        // Obtener fila seleccionada
        int row = pagosTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un pago para realizar el pago");
            return;
        }

        // Obtener valor de la celda "¿Pagada?"
        boolean pagada = (boolean) pagosTable.getValueAt(row, 2);
        if (pagada) {
            JOptionPane.showMessageDialog(this, "El pago seleccionado ya está pagado");
            return;
        }

        // Cambiar valor de la celda "¿Pagada?" a true
        pagosTable.setValueAt(true, row, 2);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Pago realizado exitosamente");

        // cerrar la ventana
        this.dispose();
    }
}

