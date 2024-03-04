package com.hackandboss.pruebatecnicajpa.logica;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestorEmpleados {

    InterfazVisual interfazVisual = new InterfazVisual();
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


    public int validacionMenuPrincial(int opcionElegida) {

        boolean opcionOk = false;

        while (!opcionOk){

            if( opcionElegida > 0 && opcionElegida < 7){
                opcionOk = true;
                interfazVisual.opcionElegidaString(opcionElegida);
            }
            else {
                System.out.println("ERROR!!!!!!");
                System.out.println("Opción seleccionada no es válida, por favor introduzca valores del 1 al 6");
                interfazVisual.renderizadoGeneralMenu();
                System.out.print("Seleccione una opción correcta: ");
                opcionElegida = scanner.nextInt();
                scanner.nextLine();
            }
        }

        return opcionElegida;
    }






    public String validacionesString(String atributo) {

        boolean atributoOk = false;
        System.out.print("Ingrese el " + atributo + " del empleado: ");
        String valorAtributo = scanner.nextLine().trim();

        while(!atributoOk) {

            if (!valorAtributo.isEmpty()) {
                atributoOk = true;
            } else {
                System.out.println("No has introducido ningún dato");
                System.out.print("Ingrese el " + atributo + " del empleado: ");
                valorAtributo = scanner.nextLine().trim();
            }
        }

        return valorAtributo;

    }




    public LocalDate validacionLocalDate() {

        boolean atributoOk = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio = null;
        System.out.print("Ingrese fecha de inicio del empleado (YYYY-MM-DD): ");
        String fecha = scanner.nextLine().trim();

        while(!atributoOk) {

            if (!fecha.isEmpty()) {

                try {
                    fechaInicio = LocalDate.parse(fecha, formatter);
                    atributoOk = true;
                }
                catch (DateTimeParseException e) {
                    System.out.println("Formato de fecha incorrecto. Debe ser yyyy-MM-dd");
                    System.out.print("Ingrese fecha de inicio del empleado (YYYY-MM-DD): ");
                    fecha = scanner.nextLine().trim();
                }

            } else {
                System.out.println("No has introducido ningún dato");
                System.out.print("Ingrese fecha de inicio del empleado (YYYY-MM-DD): ");
                fecha = scanner.nextLine().trim();
            }
        }

        return fechaInicio;
    }



    public double validacionSalario() {

        boolean atributoOk = false;
        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();

        while(!atributoOk) {

            if (salario > 0) {
                atributoOk = true;
                scanner.nextLine();
            } else {
                System.out.println("El dato introducido no es válido");
                System.out.print("Ingrese el salario del empleado: ");
                salario = scanner.nextDouble();
            }
        }

        return salario;
    }





    public Empleado validacionesRegistro() throws InterruptedException {

        Empleado empleado;


        String nombre = validacionesString("nombre");

        String apellido = validacionesString("apellido");

        String cargo = validacionesString("cargo");

        LocalDate fechaInicio = validacionLocalDate();

        double salario = validacionSalario();

        System.out.println();
        interfazVisual.efectoGiro();

        return empleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio);
    }




    public void mostrarListaEmpleadosActivos(List<Empleado> listaEmpleadosActivos) {

        String salirOpcion;

        for( Empleado empleadoActivo : listaEmpleadosActivos) {
            String estiloEmpleado = interfazVisual.estiloVisualEmpleado(empleadoActivo);
            System.out.println(estiloEmpleado);
        }
        System.out.print("Pulsa (s) para salir: ");
        salirOpcion = scanner.nextLine();
        while (!salirOpcion.equalsIgnoreCase("s")){
            salirOpcion = scanner.nextLine();
        }
    }

    public int introducirId() {

        boolean idValido = false;
        int id = 0;

        while (!idValido){

            System.out.print("Seleccione el número de id del empleado: ");

            if(scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                idValido = true;
            }
            else {
                System.out.println("No has introducido un número");
                scanner.nextLine();
            }

        }


        return id;
    }



    public Empleado editarEmpleado(Empleado editarEmpleado) throws InterruptedException {

        boolean atributoOk = false;
        interfazVisual.opcionElegidaMenu("Datos actuales");
        String estiloEmpleado = interfazVisual.estiloVisualEmpleado(editarEmpleado);
        System.out.println(estiloEmpleado);
        interfazVisual.renderizadoListaAtributos(false);
        System.out.print("Indica el atributo que desea modificar o pulsa 6 para volver al menú principal: ");
        int editarAtributo = scanner.nextInt();
        scanner.nextLine();

        while (editarAtributo < 0 || editarAtributo > 6) {

            System.out.println("Opción seleccionada incorrecta!");
            System.out.print("Indica el atributo que desea modificar (pulsa del 1 al 6): ");
            editarAtributo = scanner.nextInt();
            scanner.nextLine();
        }

        switch (editarAtributo) {



            case 1:
                interfazVisual.opcionElegidaMenu("Editar nombre");
                String nombre = validacionesString("nombre");
                editarEmpleado.setNombre(nombre);
                interfazVisual.efectoGiro();
                break;

            case 2:
                interfazVisual.opcionElegidaMenu("Editar apellido");
                String apellido = validacionesString("apellido");
                editarEmpleado.setApellido(apellido);
                interfazVisual.efectoGiro();
                break;

            case 3:
                interfazVisual.opcionElegidaMenu("Editar cargo");
                String cargo = validacionesString("cargo");
                editarEmpleado.setCargo(cargo);
                interfazVisual.efectoGiro();
                break;

            case 4:
                interfazVisual.opcionElegidaMenu("Editar salario");
                double salario = validacionSalario();
                editarEmpleado.setSalario(salario);
                interfazVisual.efectoGiro();
                break;

            case 5:
                interfazVisual.opcionElegidaMenu("Editar fecha inicio");
                LocalDate fechaInicio = validacionLocalDate();
                editarEmpleado.setFechaInicio(fechaInicio);
                interfazVisual.efectoGiro();
                break;

            default:
                break;

        }


        return editarEmpleado;
    }



    public ArrayList busquedaPersonalizada() {

        boolean valorOK = false;
        String atributo = "";

        interfazVisual.renderizadoListaAtributos(true);

        System.out.print("Indique el atributo por el que desea filtrar: ");
        int atributoNum = scanner.nextInt();
        scanner.nextLine();

        while (!valorOK) {

            if (atributoNum > 0 && atributoNum < 4) {

                switch (atributoNum) {
                    case 1:
                        atributo = "nombre";
                        valorOK = true;
                        interfazVisual.opcionElegidaMenu("Buscar por nombre");
                        break;

                    case 2:
                        atributo = "apellido";
                        valorOK = true;
                        interfazVisual.opcionElegidaMenu("Buscar por apellido");
                        break;

                    case 3:
                        atributo = "cargo";
                        valorOK = true;
                        interfazVisual.opcionElegidaMenu("Buscar por cargo");
                        break;

                    default:
                        break;
                }
            } else {
                System.out.print("Valor introducido no válido, debe de ser entre 1 y 3: ");
                atributoNum = scanner.nextInt();
                scanner.nextLine();

            }
        }




        System.out.print("Indique el valor: ");
        String valorAtributo = scanner.nextLine().trim();

        while(!valorOK) {

            if(!valorAtributo.isEmpty()){
                valorOK = true;

            }
            else {
                System.out.print("Campo vacío, introduce un valor: ");
                valorAtributo = scanner.nextLine().trim();
            }
        }

        ArrayList<String> datosBusqueda = new ArrayList<>();

        datosBusqueda.add(atributo);
        datosBusqueda.add(valorAtributo);


        return datosBusqueda;
    }
}
