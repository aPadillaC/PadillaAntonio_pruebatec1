
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

        // Hago la instancia a las clases que voy a necesitar
        Controladora controladora = new Controladora(); // controladora del paquete de lógica
        InterfazVisual interfazVisual = new InterfazVisual(); // clase para darle estilo a los datos
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US); // clase que nos permite introducir valores por el teclado
        GestorEmpleados gestorEmpleados = new GestorEmpleados(); // clase que gestiona los valores y opciones introducidas por el usuario

        // Declaro esta variable que será la que me permita correr mi aplicación indefinidamente.
        boolean usoAplicacion = true;

        System.out.println();
        System.out.println("      BIENVENIDO A LA APLICACION DE GESTION        ");
        System.out.println("                  DE EMPLEADOS                     ");

        // Llamo al método que me muestra el menú
        interfazVisual.renderizadoGeneralMenu();

        System.out.print("Seleccione una opción del 1 al 6: ");
        int opcionElegida = scanner.nextInt(); // Variable con valor al número introducido por el usuario según el menú


        // Verifico que la opción introducida es válida
        opcionElegida = gestorEmpleados.validacionMenuPrincial(opcionElegida);


        // Entro en el bucle while para que mi aplicación esté corriendo hasta que el usuario decida mediante la
        // variable "useAplicacion"
        while (usoAplicacion) {

            int id;

            switch (opcionElegida) {

                case 1: //creo un empleado
                    Empleado empleado = gestorEmpleados.validacionesRegistro();
                    controladora.crearEmpleado(empleado);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 2: //muestro todos los empleados ACTIVOS
                    List<Empleado> listaEmpleadosActivos = controladora.listadoEmpleadosActivos();
                    gestorEmpleados.mostrarListaEmpleadosActivos(listaEmpleadosActivos);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 3: //actualizo/edito a los empleados
                    id = gestorEmpleados.introducirId();
                    Empleado mostrarEmpleado = controladora.mostrarEmpleado(id);
                    Empleado empleadoEditado = gestorEmpleados.editarEmpleado(mostrarEmpleado);
                    controladora.editarEmpleado(empleadoEditado);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 4: //borro lógicamente a un empleado mediante su id
                    id = gestorEmpleados.introducirId();
                    Empleado borrarEmpleado = controladora.mostrarEmpleado(id);
                    borrarEmpleado.setActivo(false);
                    controladora.editarEmpleado(borrarEmpleado);
                    System.out.println();
                    interfazVisual.efectoGiro();
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 5: //filtro personalizado para buscar empleados por: nombre, apellido, cargo
                    ArrayList atributoValor = gestorEmpleados.busquedaPersonalizada();
                    List<Empleado> listaEmpleadosCargo = controladora.busquedaPorAtributo((String) atributoValor.get(0), (String) atributoValor.get(1));
                    gestorEmpleados.mostrarListaEmpleadosActivos(listaEmpleadosCargo);
                    interfazVisual.renderizadoGeneralMenu();
                    break;

                case 6: //salir de la aplicación
                    usoAplicacion = false;
                    break;
            }


            // Me solicita de nuevo la opción a elegir después de terminar cada proceso anterior
            if(usoAplicacion){
                System.out.print("Seleccione una opción del 1 al 6: ");
                opcionElegida = scanner.nextInt();
                scanner.nextLine();
            }


            // Vuelvo a validar la opción elegida
            opcionElegida = gestorEmpleados.validacionMenuPrincial(opcionElegida);
        }

    }
}
