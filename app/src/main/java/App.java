import javax.swing.*;
import model.*;
import ui.InterfazAgregarCliente;

public class App {
    public static void main(String[] args) {
        Global.automoviles.add(new Automovil("AB1234", 'D'));
        Global.automoviles.add(new Automovil("CD5678", 'D'));
        Global.automoviles.add(new Automovil("EF9012", 'D'));
        Global.automoviles.add(new Automovil("GH3456", 'D'));
        Global.automoviles.add(new Automovil("IJ7890", 'D'));


        // Instanciar la interfaz de agregar cliente
        JFrame frame = new InterfazAgregarCliente();
        
        // Mostrar la interfaz
        frame.setVisible(true);
    }
}

