package com.hackandboss.pruebatecnicajpa.logica;

public class InterfazVisual {

    // Renderización del menú principal de la aplicación
    public void renderizadoGeneralMenu() {

        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║                  MENÚ PRINCIPAL                 ║");
        System.out.println("╠═════════════════════════════════════════════════╣");
        System.out.println("║                                                 ║");
        System.out.println("║  1. Insertar nuevo empleado                     ║");
        System.out.println("║  2. Listado de empleados                        ║");
        System.out.println("║  3. Actualizar datos de empleado                ║");
        System.out.println("║  4. Eliminar empleado                           ║");
        System.out.println("║  5. Búsqueda empleados personalizada            ║");
        System.out.println("║  6. Salir                                       ║");
        System.out.println("║                                                 ║");
        System.out.println("╚═════════════════════════════════════════════════╝");

    }

    // Según la opción elegida uso la variable título para guardar un mensaje y mostrarlo por pantalla
    public void opcionElegidaString(int opcionElegida) {

        String titulo = "";

        switch (opcionElegida) {

            case 1:
                titulo = "Insertar nuevo empleado";
                break;

            case 2:
                titulo = "Listado de empleados";
                break;

            case 3:
                titulo = "Editar datos empleado";
                break;

            case 4:
                titulo = "Eliminar un empleado";
                break;

            case 5:
                titulo = "Búsqueda personalizada";
                break;

            case 6:
                titulo = "Adios. Hasta Pronto";
                break;

            default:
                break;
        }



    opcionElegidaMenu(titulo);

    }


    // Método para mostrar el mensaje de la opción elegida con un diseño predefinido
    public void opcionElegidaMenu(String opElegidaString) {

        System.out.println("\n═════════════════════════════════════════════════");
        System.out.println("              " + opElegidaString + "            ");
        System.out.println("═════════════════════════════════════════════════");
    }



    // Renderizo los todos atributos o parte del empleado según el caso (a través de una variable booleana)
    public void renderizadoListaAtributos(boolean filtroBusqueda) {

        if(filtroBusqueda){
            System.out.println("╔═════════════════════════════════════════════════╗");
            System.out.println("║                ATRIBUTOS EMPLEADO               ║");
            System.out.println("╠═════════════════════════════════════════════════╣");
            System.out.println("║                                                 ║");
            System.out.println("║  1. Nombre empleado                             ║");
            System.out.println("║  2. Apellido empleado                           ║");
            System.out.println("║  3. Cargo empleado                              ║");
            System.out.println("║                                                 ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
        }
        else{
            System.out.println("╔═════════════════════════════════════════════════╗");
            System.out.println("║                ATRIBUTOS EMPLEADO               ║");
            System.out.println("╠═════════════════════════════════════════════════╣");
            System.out.println("║                                                 ║");
            System.out.println("║  1. Nombre empleado                             ║");
            System.out.println("║  2. Apellido empleado                           ║");
            System.out.println("║  3. Cargo empleado                              ║");
            System.out.println("║  4. Salario empleado                            ║");
            System.out.println("║  5. Fecha de inicio empleado                    ║");
            System.out.println("║  6. Salir                                       ║");
            System.out.println("║                                                 ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
        }

    }



    // Muestro los atributos del empleado con un estilo prediseñado
    public String estiloVisualEmpleado (Empleado empleado) {

        StringBuilder sb = new StringBuilder();
        sb.append("╔═════════════════════════════════════════════════════╗\n");
        sb.append(String.format("║ Nombre: %-20s Apellido: %-20s \n", empleado.getNombre(), empleado.getApellido()));
        sb.append(String.format("║ Cargo: %-21s Salario: %-10.2f€ \n", empleado.getCargo(), empleado.getSalario()));
        sb.append(String.format("║ Fecha de Inicio: %-14s                         \n", empleado.getFechaInicio()));
        sb.append("╚═════════════════════════════════════════════════════╝");

        return sb.toString();
    }



    // Método para mostrar de una manera gráfica la interacción con la BBDD
    public void efectoGiro () {

        int iterations = 20; // Número de iteraciones del efecto de giro
        int delay = 100; // Retraso en milisegundos entre iteraciones

        // Caracteres a usar en el efecto de giro
        char[] characters = {'/', '-', '\\', '|'};

        for (int i = 0; i < iterations; i++) {
            System.out.print("\r" + characters[i % characters.length] + " Operación en proceso... ");

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("\rOperación completada!\n");

    }
}
