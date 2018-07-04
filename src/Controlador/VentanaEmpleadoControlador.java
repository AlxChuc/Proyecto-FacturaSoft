package Controlador;

import Vista.VentanaEmpleadoVista;
import Modelo.EmpleadoModelo;
import Vista.ComisionesEmpleadoVista;
import Vista.VentaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.event.MenuListener;

public class VentanaEmpleadoControlador implements ActionListener {

    /**
     *VentanaEmpleadoVista
     */
    private VentanaEmpleadoVista vEV;

    /**
     *EmpleadoModelo
     */
    private EmpleadoModelo eM;

    public VentanaEmpleadoControlador(VentanaEmpleadoVista vEV, EmpleadoModelo empleado) {
        this.vEV = vEV;
        this.eM = empleado;
        vEV.setLocationRelativeTo(null);

        vEV.getBtnSalir().addActionListener(this);
        vEV.getItemVenta().addActionListener(this);
        vEV.getItemComision().addActionListener(this);

        vEV.setTitle("Welcome!");
        vEV.getjLabel1().setText("Bienvenido " + empleado.getNombre().split(" ")[0]);
        vEV.getjLabel1().setHorizontalAlignment(vEV.getjLabel1().CENTER);
        vEV.setVisible(true);
    }

    /**
     * Selecciona qué acctión se realizó, en otras palabras, qué fue lo que se
     * presionó, para invocar una acción.
     *
     * @param aE ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent aE) {
        if (vEV.getBtnSalir() == aE.getSource()) {
            /**/
            vEV.dispose();
        } else {
            if (vEV.getItemVenta() == aE.getSource()) {
                /*Activa la ventana de venta*/
                new VentaControlador(new VentaVista(), eM);
            } else {
                if (vEV.getItemComision() == aE.getSource()) {
                    new ComisionesEmpleadoControlador(new ComisionesEmpleadoVista(),eM);
                }
            }

        }
    }

}
