
package com.hackandboss.pruebatecnicajpa.persistencia;

import com.hackandboss.pruebatecnicajpa.logica.Empleado;
import com.hackandboss.pruebatecnicajpa.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();


    public void crearEmpleado(Empleado empleado) {

        empleadoJPA.create(empleado);
    }


    public void eliminarEmpleado(int id) {

        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> listadoEmpleados() {

        return empleadoJPA.findEmpleadoEntities();
    }

    public Empleado mostrarEmpleado(int id) {

        return empleadoJPA.findEmpleado(id);
    }

    public void editarEmpleado(Empleado empleadoBuscado) {

        try {
            empleadoJPA.edit(empleadoBuscado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> listadoEmpleadosActivos() {

        return empleadoJPA.findEmpleadosActivos();
    }


    public List<Empleado> busquedaPorAtributo(String atributo, String valor) {

        return empleadoJPA.findEmpleadosByAttribute(atributo, valor);
    }
}
