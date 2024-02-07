package ejercicio7;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Constructor c1 = new Constructor("seat", "SEAT", "Spanish", "algo");
        Piloto insert = new Piloto("SAI", "Carlos", "Sainz", Date.valueOf("2003-05-06"), "Spanish", c1.getConstructorid());
        Piloto actualizar = new Piloto("LOP", "Sara", "Martinez", Date.valueOf("1999-05-06"), "Spanish", 12);
        OperacionesCRUDPilotos operaciones = new OperacionesCRUDPilotos();

        //operaciones.crearEscuderia(c1);
        //operaciones.crearPiloto(insert);

        operaciones.leerPilotos();
        operaciones.leerEscuderias();
        operaciones.crearPiloto(insert);
        System.out.println("------LEER PILOTO POR ID------");
        operaciones.leerPiloto(2);
        System.out.println("------LEER PILOTOS------");
        operaciones.leerPilotos();
        System.out.println("------ACTUALIZAR PILOTOS------");
        operaciones.actualizarPiloto(2, actualizar);
        operaciones.leerPilotos();
        System.out.println("------BORRAR PILOTO------");
        operaciones.borrarPiloto(39);
        operaciones.leerPilotos();
        System.out.println("------CLASIFICACIÓN POR PUNTOS (piloto)------");
        operaciones.mostrarClasificacionPiloto();
        System.out.println("------CLASIFICACIÓN POR PUNTOS (escuderia)------");
        operaciones.mostrarClasificacionConstructores();
    }
}
