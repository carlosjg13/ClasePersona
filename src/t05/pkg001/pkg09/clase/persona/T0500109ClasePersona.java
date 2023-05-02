package t05.pkg001.pkg09.clase.persona;

import java.util.Scanner;

public class T0500109ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String apellidos = "";
        String fecha = "";
        String fechaNacimiento = "";
        int formatoEntero = 0;
        int formatoSinFecha = 0;
        boolean fechaCorrecta ;
        String fechaNueva = "";

        Persona miPersona1 = null;
        formatoEntero = sc.nextInt();
        formatoSinFecha = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < formatoEntero; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fecha = sc.nextLine();

            try {
                miPersona1 = new Persona(nombre, apellidos, fecha);
                fechaNacimiento = miPersona1.getFechaNacimiento();
                System.out.println("Procesado: " + miPersona1.getNombre() + " "
                        + miPersona1.getApellidos()
                        + ", nacido el " + fechaNacimiento.substring(0, 2) + " del "
                        + fechaNacimiento.substring(3, 5) + " de " + fechaNacimiento.substring(6, fechaNacimiento.length()));
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }

        for (int i = 1; i <= formatoSinFecha; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();

            try {
                miPersona1 = new Persona(nombre, apellidos);
                fecha = miPersona1.getFechaNacimiento();
                System.out.println("Procesado: " + miPersona1.getNombre() + " "
                        + miPersona1.getApellidos()
                        + ", nacido el " + fecha);

                if (i == formatoSinFecha) {
                    fechaNueva = sc.nextLine();
                    fechaCorrecta = false;
                    while (!fechaCorrecta) {

                        try {
                            miPersona1.setFechaNacimiento(fechaNueva);
                            fechaNacimiento = miPersona1.getFechaNacimiento();
                            fechaCorrecta = true;
                            System.out.println("Procesado: " + miPersona1.getNombre() + " "
                                    + miPersona1.getApellidos()
                                    + ", nacido el " + fechaNacimiento.substring(0, 2) + " del "
                                    + fechaNacimiento.substring(3, 5) + " de " + fechaNacimiento.substring(6, fechaNacimiento.length()));

                        } catch (IllegalArgumentException e) {
                            System.out.println("Fecha Incorrecta");
                            fechaNueva = sc.nextLine();
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }

    }
}


