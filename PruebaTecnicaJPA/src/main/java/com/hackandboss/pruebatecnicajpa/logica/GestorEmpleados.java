package com.hackandboss.pruebatecnicajpa.logica;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestorEmpleados {

    // Instancias necesarias
    InterfazVisual interfazVisual = new InterfazVisual();
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


    // 1. Validación de la opción seleccionada del menú principal
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





    // 2. Validaciones de los atributos tipo String y devuelvo del valor introducido
    public String validacionesString(String atributo) { // Le paso por parámetro el valor del atributo el cual concateno en los "print", lo que me permite reutilizar el código para diferentes momentos

        boolean atributoOk = false;
        System.out.print("Ingrese el " + atributo + " del empleado: ");
        String valorAtributo = scanner.nextLine().trim(); // con el método .trim() elimino los espacios a un lado y a otro de la cadena de caracteres

        while(!atributoOk) {

            if (!valorAtributo.isEmpty()) { // evalúo si he introducido algo o está vacía la variable
                atributoOk = true;
            } else {
                System.out.println("No has introducido ningún dato");
                System.out.print("Ingrese el " + atributo + " del empleado: ");
                valorAtributo = scanner.nextLine().trim();
            }
        }

        return valorAtributo;

    }



    // 3. Validaciones de los atributos tipo LocalDate y devuelvo del valor introducido
    public LocalDate validacionLocalDate() {

        boolean atributoOk = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Creo un formato que deseo que tenga mi atributo fecha
        LocalDate fechaInicio = null; // inicializo la variable que luego usaré para el atributo fechaInicial
        System.out.print("Ingrese fecha de inicio del empleado (YYYY-MM-DD): ");
        String fecha = scanner.nextLine().trim(); // con el método .trim() elimino los espacios a un lado y a otro de la cadena de caracteres

        while(!atributoOk) {

            if (!fecha.isEmpty()) { // evalúo si he introducido algo o está vacía la variable

                try {
                    fechaInicio = LocalDate.parse(fecha, formatter); // le doy formato deseado y paso el valor de String a LocalDate
                    atributoOk = true;
                }
                catch (DateTimeParseException e) { //Si hubiera algún error en el proceso de formateo capturo la Exceptión y vuelvo a solicitar un nuevo valor válido
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



    // 4. Validación del atributo tipo double y devuelvo del valor introducido
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





    // 5. Método para juntar todos los datos introducidos tras sus validaciones y creación de la instancia tipo Empleado
    public Empleado validacionesRegistro() throws InterruptedException {

        Empleado empleado;


        String nombre = validacionesString("nombre");

        String apellido = validacionesString("apellido");

        String cargo = validacionesString("cargo");

        LocalDate fechaInicio = validacionLocalDate();

        double salario = validacionSalario();

        System.out.println();
        interfazVisual.efectoGiro(); // Se muestra la animación

        return empleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio);
    }




    // 6. Mostrar gráficamente todos los usuarios ACTIVOS en la BBDD
    public void mostrarListaEmpleadosActivos(List<Empleado> listaEmpleadosActivos) {

        String salirOpcion;

        for( Empleado empleadoActivo : listaEmpleadosActivos) {
            String estiloEmpleado = interfazVisual.estiloVisualEmpleado(empleadoActivo);
            System.out.println(estiloEmpleado);
        }
        System.out.print("Pulsa (s) para salir: ");
        salirOpcion = scanner.nextLine();
        while (!salirOpcion.equalsIgnoreCase("s")){ // Mientras no se pulse "s" no se vuelve al menú principal
            salirOpcion = scanner.nextLine();
        }
    }




    // 7. Método para solicitar un id de un empleado al usuario
    public int introducirId() {

        boolean idValido = false;
        int id = 0;

        while (!idValido){

            System.out.print("Seleccione el número de id del empleado: ");

            if(scanner.hasNextInt()){ // Valido que el número introducido sea un número
                id = scanner.nextInt();
                scanner.nextLine();
                idValido = true;
            }
            else {
                System.out.println("No has introducido un número");
                scanner.nextLine();
            }

        }


        return id; // Retorno el id
    }




    // 8. Método para editar el empleado
    public Empleado editarEmpleado(Empleado editarEmpleado) throws InterruptedException {

        boolean atributoOk = false;
        interfazVisual.opcionElegidaMenu("Datos actuales"); // a) Muestro los datos actuales
        String estiloEmpleado = interfazVisual.estiloVisualEmpleado(editarEmpleado);
        System.out.println(estiloEmpleado);
        interfazVisual.renderizadoListaAtributos(false); // renderizo los atributos indicándole mediante "false" que me muestre el diseño correspondiente al apartado edición
        System.out.print("Indica el atributo que desea modificar (1 al 5) o pulsa 6 para volver al menú principal: ");
        int editarAtributo = scanner.nextInt();
        scanner.nextLine();

        while (editarAtributo < 0 || editarAtributo > 6) { // Verifico que el valor introducido corresponde a un atributo

            System.out.println("Opción seleccionada incorrecta!");
            System.out.print("Indica el atributo que desea modificar (pulsa del 1 al 6): ");
            editarAtributo = scanner.nextInt();
            scanner.nextLine();
        }


        switch (editarAtributo) { // Según el valor muestro y se edita un atributo o otro

            case 1:
                interfazVisual.opcionElegidaMenu("Editar nombre"); // Solo para mostrar mensaje por pantalla
                String nombre = validacionesString("nombre"); // Le paso el parámetro correspondiente al atributo a editar
                editarEmpleado.setNombre(nombre); // seteo el valor nuevo en la instancia empleado
                interfazVisual.efectoGiro(); // Se muestra la animación
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


        return editarEmpleado; // Devuelvo el empleado tras su edición
    }



    // 9. Método para realizar busqueda por: nombre, apellido o cargo
    public ArrayList busquedaPersonalizada() {

        boolean valorOK = false;
        String atributo = "";

        interfazVisual.renderizadoListaAtributos(true); // renderizo los atributos indicándole mediante "false" que me muestre el diseño correspondiente al apartado busqueda

        System.out.print("Indique el atributo por el que desea filtrar (pulsa del 1 al 3): ");
        int atributoNum = scanner.nextInt();
        scanner.nextLine();

        while (!valorOK) {

            if (atributoNum > 0 && atributoNum < 4) { // Según el atributo guardo en la variable "atributo" un valor o otro y muestro por pantalla un mensaje personalizado a cada uno

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
            } else { // valido que el número introducido corresponde a alguna de las opciones
                System.out.print("Valor introducido no válido, debe de ser entre 1 y 3: ");
                atributoNum = scanner.nextInt();
                scanner.nextLine();

            }
        }




        System.out.print("Indique el valor: "); // solicito el dato por el que se va a realizar la busqueda
        String valorAtributo = scanner.nextLine().trim();

        while(!valorOK) {

            if(!valorAtributo.isEmpty()){ // validación por si la cadena introducida está vacía
                valorOK = true;

            }
            else {
                System.out.print("Campo vacío, introduce un valor: ");
                valorAtributo = scanner.nextLine().trim();
            }
        }

        ArrayList<String> datosBusqueda = new ArrayList<>(); // Hago una instancia de la clase ArrayList

        datosBusqueda.add(atributo); // añado el atributo por el que vamos a realizar la busqueda
        datosBusqueda.add(valorAtributo); // añado el valor de dicho atributo


        return datosBusqueda; // lo devuelvo al main
    }
}
