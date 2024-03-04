
package com.hackandboss.pruebatecnicajpa;

import com.hackandboss.pruebatecnicajpa.logica.Controladora;
import com.hackandboss.pruebatecnicajpa.logica.Empleado;
import com.hackandboss.pruebatecnicajpa.logica.InterfazVisual;
import com.hackandboss.pruebatecnicajpa.logica.GestorEmpleados;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;




public class PruebaTecnicaJPA {

    public static void main(String[] args) throws InterruptedException {
        
        Controladora controladora = new Controladora();

        InterfazVisual interfazVisual = new InterfazVisual();

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        GestorEmpleados gestorEmpleados = new GestorEmpleados();

        boolean usoAplicacion = true;

        System.out.println();
        System.out.println("      BIENVENIDO A LA APLICACION DE GESTION        ");
        System.out.println("                  DE EMPLEADOS                     ");

        interfazVisual.renderizadoGeneralMenu();

        System.out.print("Seleccione una opción: ");
        int opcionElegida = scanner.nextInt();



        opcionElegida = gestorEmpleados.validacionMenuPrincial(opcionElegida);


        while (usoAplicacion) {

            int id;

            switch (opcionElegida) {

                case 1:
                    Empleado empleado = gestorEmpleados.validacionesRegistro();
                    controladora.crearEmpleado(empleado);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 2:
                    List<Empleado> listaEmpleadosActivos = controladora.listadoEmpleadosActivos();
                    gestorEmpleados.mostrarListaEmpleadosActivos(listaEmpleadosActivos);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 3:
                    id = gestorEmpleados.introducirId();
                    Empleado mostrarEmpleado = controladora.mostrarEmpleado(id);
                    Empleado empleadoEditado = gestorEmpleados.editarEmpleado(mostrarEmpleado);
                    controladora.editarEmpleado(empleadoEditado);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 4:
                    id = gestorEmpleados.introducirId();
                    Empleado borrarEmpleado = controladora.mostrarEmpleado(id);
                    borrarEmpleado.setActivo(false);
                    controladora.editarEmpleado(borrarEmpleado);
                    System.out.println();
                    interfazVisual.efectoGiro();
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 5:
                    ArrayList atributoValor = gestorEmpleados.busquedaPersonalizada();
                    List<Empleado> listaEmpleadosCargo = controladora.busquedaPorAtributo((String) atributoValor.get(0), (String) atributoValor.get(1));
                    gestorEmpleados.mostrarListaEmpleadosActivos(listaEmpleadosCargo);
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



            opcionElegida = gestorEmpleados.validacionMenuPrincial(opcionElegida);
        }

    }
}
