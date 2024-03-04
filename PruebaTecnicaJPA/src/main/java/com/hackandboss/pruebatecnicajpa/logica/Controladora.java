
package com.hackandboss.pruebatecnicajpa.logica;

import com.hackandboss.pruebatecnicajpa.persistencia.ControladoraPersistencia;

import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();


    public void crearEmpleado(Empleado empleado) {

        controlPersistencia.crearEmpleado(empleado);
    }


    public void eliminarEmpleado(int id) {

        controlPersistencia.eliminarEmpleado(id);
    }


    public List<Empleado> listadoEmpleados() {

        return controlPersistencia.listadoEmpleados();
    }

    public Empleado mostrarEmpleado(int id) {

        return controlPersistencia.mostrarEmpleado(id);
    }

    public void editarEmpleado(Empleado empleadoBuscado) {

        controlPersistencia.editarEmpleado(empleadoBuscado);
    }

    public List<Empleado> listadoEmpleadosActivos() {

        return controlPersistencia.listadoEmpleadosActivos();
    }


    public List<Empleado> busquedaPorAtributo(String atributo, String valor) {


        return controlPersistencia.busquedaPorAtributo(atributo, valor);
    }
}
