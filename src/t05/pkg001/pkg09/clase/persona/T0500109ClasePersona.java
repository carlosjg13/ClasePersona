package t05.pkg001.pkg09.clase.persona;

import java.util.Scanner;

public class T0500109ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String apellidos = "";
        String fecha = "";
        String fechaNacimiento = "";
        int numFechas = 0;
        int numPersonas = 0;

        Persona miPersona1 = null;
        numPersonas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPersonas; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            numFechas = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < numFechas; j++) {

                fecha = sc.nextLine();

                try {
                    miPersona1 = new Persona(nombre, apellidos, fechaNacimiento);
                    fechaNacimiento = miPersona1.getFechaNacimiento();
                    try {
                        if (miPersona1.getEdadEnFecha(fecha) != -1) {
                            System.out.println(miPersona1.getNombre() + " " + miPersona1.getApellidos() + " tendra "
                                    + miPersona1.getEdadEnFecha(fecha) + " anyos en fecha " + fecha);
                        } else {
                            System.out.println(miPersona1.getNombre() + " "
                                    + miPersona1.getApellidos()
                                    + " aun no ha nacido a fecha " + fecha);
                        }

                    } catch (IllegalArgumentException ex1) {
                        System.out.println("ERROR. Procesando siguiente fecha");
                    }

                } catch (IllegalArgumentException ex2) {
                    System.out.println("ERROR. Procesando siguiente persona");
                }
            }

        }

    }
}
