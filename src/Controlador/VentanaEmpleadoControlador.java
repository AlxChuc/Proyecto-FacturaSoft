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

    /**
     *Inicializa las variables, acomoda y ajusta la ventana
     * @param vEV tipo VentanaEmpleadoVista
     * @param empleado tipo EmpleadoModelo
     */
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
     * Selecciona que acción se realizo, en otras palabras, que fue lo que se
     * presiono, para invocar una accion.
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
