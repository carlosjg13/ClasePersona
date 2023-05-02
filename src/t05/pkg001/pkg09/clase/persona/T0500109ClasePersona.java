package t05.pkg001.pkg09.clase.persona;

import java.time.DateTimeException;
import java.time.LocalDate;

public class T0500109ClasePersona {

    public static void main(String[] args) {

    }

}

class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

    }

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos) || "".equals(fechaNacimiento)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }

    }

    private LocalDate generarFecha(String fecha) {
        int dia = 0;
        int mes = 0;
        int anio = 0;

        if (!fecha.matches("[0-9](2)[-][0-9](2)[-][0-9](4)")
                && !fecha.matches("[0-9](2)[/][0-9](2)[/][0-9](4)")) {
        } else {
            try {
                dia = Integer.parseInt(fecha.substring(0, 2));
                mes = Integer.parseInt(fecha.substring(3, 5));
                anio = Integer.parseInt(fecha.substring(6, fecha.length()));

                return LocalDate.of(anio, mes, dia);

            } catch (NumberFormatException | DateTimeException ex1) {
                throw new IllegalArgumentException();
            }
        }

    }

    private String getFechaNacimiento(char separador) throws IllegalArgumentException {
        String fecha = null;

        if (separador != '-' || separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%02d%04d%", this.fechaNacimiento.getDayOfMonth(), separador, this.fechaNacimiento.getDayOfMonth(),
                        separador, this.fechaNacimiento.getYear());
            }
            return fecha;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

}
