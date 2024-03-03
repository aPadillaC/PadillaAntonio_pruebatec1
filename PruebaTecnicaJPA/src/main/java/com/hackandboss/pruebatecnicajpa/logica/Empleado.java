
package com.hackandboss.pruebatecnicajpa.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Empleado implements Serializable {
    
    // Atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
    private String name;
    private String apellido;
    private String cargo;
    private double salario;
    private LocalDate fechaInicio;
    private boolean activo;

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con atribujos
    public Empleado(String name, String apellido, String cargo, double salario, LocalDate fechaInicio) {
        this.name = name;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        this.activo = true;
    }
    
    // Métodos getters y setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    } 

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    
    // Método toString()

    @Override
    public String toString() {


        return "Empleado{" + "idEmpleado=" + idEmpleado + ", name=" + name + ", apellido=" + apellido + ", cargo=" + cargo + ", salario=" + salario + ", fechaInicio=" + fechaInicio + ", activo=" + activo + '}';
    }
    

       
    
}
