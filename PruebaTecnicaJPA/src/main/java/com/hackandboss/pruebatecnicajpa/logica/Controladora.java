
package com.hackandboss.pruebatecnicajpa.logica;

import com.hackandboss.pruebatecnicajpa.persistencia.ControladoraPersistencia;

import java.util.List;

public class Controladora {

    // Instancia de la clase Controladora Persistencia
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();


    // 1. Método para crear un empleado
    public void crearEmpleado(Empleado empleado) {

        controlPersistencia.crearEmpleado(empleado);
    }


    // 2. Método para eliminar permanentemente un empleado (no se ha utilizado finalmente)
    public void eliminarEmpleado(int id) {

        controlPersistencia.eliminarEmpleado(id);
    }


    // 3. Método para listar todos los empleados (ACTIVOS o NO, no se ha utilizado finalmente)
    public List<Empleado> listadoEmpleados() {

        return controlPersistencia.listadoEmpleados();
    }


    // 4. Método para mostrar un empleado a través de su id
    public Empleado mostrarEmpleado(int id) {

        return controlPersistencia.mostrarEmpleado(id);
    }


    // 5. Método para actualizar el valor de un empleado tras su edición
    public void editarEmpleado(Empleado empleadoBuscado) {

        controlPersistencia.editarEmpleado(empleadoBuscado);
    }


    // 6. Muestra todos los usuarios ACTIVOS
    public List<Empleado> listadoEmpleadosActivos() {

        return controlPersistencia.listadoEmpleadosActivos();
    }


    // 7. Muestra la lista de empleados por búsqueda personalizada
    public List<Empleado> busquedaPorAtributo(String atributo, String valor) {


        return controlPersistencia.busquedaPorAtributo(atributo, valor);
    }
}
