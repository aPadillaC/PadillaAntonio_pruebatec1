
package com.hackandboss.pruebatecnicajpa.persistencia;

import com.hackandboss.pruebatecnicajpa.logica.Empleado;
import com.hackandboss.pruebatecnicajpa.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    // Instancia de la clase EmpleadoJpaController
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();


    // 1. Método para crear un empleado
    public void crearEmpleado(Empleado empleado) {

        empleadoJPA.create(empleado);
    }


    // 2. Método para eliminar permanentemente un empleado (no se ha utilizado finalmente)
    public void eliminarEmpleado(int id) {

        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }


    // 3. Método para listar todos los empleados (ACTIVOS o NO, no se ha utilizado finalmente)
    public List<Empleado> listadoEmpleados() {

        return empleadoJPA.findEmpleadoEntities();
    }


    // 4. Método para mostrar un empleado a través de su id
    public Empleado mostrarEmpleado(int id) {

        return empleadoJPA.findEmpleado(id);
    }


    // 5. Método para actualizar el valor de un empleado tras su edición
    public void editarEmpleado(Empleado empleadoBuscado) {

        try {
            empleadoJPA.edit(empleadoBuscado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }


    // 6. Muestra todos los usuarios ACTIVOS
    public List<Empleado> listadoEmpleadosActivos() {

        return empleadoJPA.findEmpleadosActivos();
    }


    // 7. Muestra la lista de empleados por búsqueda personalizada
    public List<Empleado> busquedaPorAtributo(String atributo, String valor) {

        return empleadoJPA.findEmpleadosByAttribute(atributo, valor);
    }
}
