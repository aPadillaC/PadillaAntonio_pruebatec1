
package com.hackandboss.pruebatecnicajpa;

import com.hackandboss.pruebatecnicajpa.logica.Controladora;
import com.hackandboss.pruebatecnicajpa.logica.Empleado;
import com.hackandboss.pruebatecnicajpa.logica.InterfazVisual;
import com.hackandboss.pruebatecnicajpa.logica.ControladorEmpleados;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;




public class PruebaTecnicaJPA {

    public static void main(String[] args) throws InterruptedException {
       
        Controladora controladora = new Controladora();

        InterfazVisual interfazVisual = new InterfazVisual();

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        ControladorEmpleados controladorEmpleados = new ControladorEmpleados();

        boolean usoAplicacion = true;

        System.out.println();
        System.out.println("      BIENVENIDO A LA APLICACION DE GESTION        ");
        System.out.println("                  DE EMPLEADOS                     ");

        interfazVisual.renderizadoGeneralMenu();

        System.out.print("Seleccione una opción: ");
        int opcionElegida = scanner.nextInt();


        String opElegidaString = controladorEmpleados.validacionMenuPrincial(opcionElegida);

        while (usoAplicacion) {

            int id;
            interfazVisual.opcionElegidaMenu(opElegidaString);

            switch (opcionElegida) {

                case 1:
                    Empleado empleado = controladorEmpleados.validacionesRegistro();
                    controladora.crearEmpleado(empleado);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 2:
                    List<Empleado> listaEmpleadosActivos = controladora.listadoEmpleadosActivos();
                    controladorEmpleados.mostrarListaEmpleadosActivos(listaEmpleadosActivos);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 3:
                    id = controladorEmpleados.introducirId();
                    Empleado mostrarEmpleado = controladora.mostrarEmpleado(id);
                    Empleado empleadoEditado = controladorEmpleados.editarEmpleado(mostrarEmpleado);
                    controladora.editarEmpleado(empleadoEditado);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 4:
                    id = controladorEmpleados.introducirId();
                    Empleado borrarEmpleado = controladora.mostrarEmpleado(id);
                    borrarEmpleado.setActivo(false);
                    controladora.editarEmpleado(borrarEmpleado);
                    System.out.println();
                    interfazVisual.efectoGiro();
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 5:
                    String atributoValor = controladorEmpleados.busquedaPorCargo();
                    List<Empleado> listaEmpleadosCargo = controladora.busquedaPorAtributo("cargo", atributoValor);
                    interfazVisual.opcionElegidaMenu("Cargo: " + atributoValor);
                    controladorEmpleados.mostrarListaEmpleadosActivos(listaEmpleadosCargo);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 6:
                    usoAplicacion = false;
                    break;
            }


            if(usoAplicacion){
                System.out.print("Seleccione una opción: ");
                opcionElegida = scanner.nextInt();
                scanner.nextLine();
            }



            opElegidaString = controladorEmpleados.validacionMenuPrincial(opcionElegida);
        }




















        
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        LocalDate fechaInicio = null;
        
        //String fecha = "2021-09-01";

//        try {
//            fechaInicio = LocalDate.parse(fecha, formatter);
//        } catch (DateTimeParseException e) {
//            System.out.println("Formato de fecha incorrecto. Debe ser yyyy-MM-dd");
//        }
//
//        Empleado empleado = new Empleado("Antonio", "Padilla", "Encargado", 1500, fechaInicio);
        
        //controladora.crearEmpleado(empleado);
        
        // Eliminar un empleado
        //controladora.eliminarEmpleado(2);
        
        
        //Listar a todos los empleados
        //List<Empleado> listaEmpleados = controladora.listadoEmpleados();
        
        // Muestro por pantalla a los empleados a traves de un for each
        //for( Empleado emp : listaEmpleados) {
            
          //  System.out.println("\n" + emp.toString());
        //}
        
        
        
        // Actualizar empleado
        //Empleado empleadoBuscado = controladora.mostrarEmpleado(3);
        
        //LocalDate fechaInicioEditada = null;
        
        //String fechaEditada = "2016-02-12";
        
        //fechaInicioEditada = LocalDate.parse(fechaEditada, formatter);
        //empleadoBuscado.setFechaInicio(fechaInicioEditada);
        
        
        //empleadoBuscado.setApellido("Padilla Carrillo");
        
        //controladora.editarEmpleado(empleadoBuscado);
        
        
        
        // Borrado logico
//        Empleado borradoLogicoEmpleado = controladora.mostrarEmpleado(5);
//        borradoLogicoEmpleado.setActivo(false);
//        controladora.editarEmpleado(borradoLogicoEmpleado);
        
        
        
        // Listado empleados activos
//        List<Empleado> empleadosActivos = controladora.listadoEmpleadosActivos();
//
//        for( Empleado empleadoActivo : empleadosActivos) {
//
//            System.out.println(empleadoActivo.toString());
//        }




        // Listado de empleados por atributo
//        List<Empleado> busquedaEmpleados = controladora.busquedaPorAtributo("cargo", "Responsable compras");
//
//        for( Empleado busEmpleado : busquedaEmpleados ) {
//
//            System.out.println(busEmpleado.toString());
//        }
    }
}
