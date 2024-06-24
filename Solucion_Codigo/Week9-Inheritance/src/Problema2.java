
/**
 *
 *
 * @author MRodzDirect 😉 <Organico>
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Problema2 {

    public static void main(String[] args) { // Polimorfismo =3
// primero necesita soportes
        DVD soporteDeDVD = new DVD(4.5, 15.0);
        VHS soporteDeVHS = new VHS("Cinta estandar", 10.0);

        ArrayList<Pelicula> listPeliculas = new ArrayList<>(Arrays.asList(new Pelicula(soporteDeDVD, "Intensamente 2", "Tu papi", 2024, "Spanenglish"),
                new Pelicula(soporteDeVHS, "Matrix", "Tu hermana", 2023, "English"),
                new Pelicula(soporteDeDVD, "Juego tronitos", "Tu mami", 2020, "Spanish")));

        for (Pelicula pelicula : listPeliculas) {
            System.out.println(pelicula);
        }

    }
}

class DVD extends Soporte {

    private double capacidad;
    private double precioBase;

    public DVD(double capacidad, double precioBase) {
        super(null);
        this.capacidad = capacidad;
        this.precioBase = precioBase;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public double getPrecioAlquiler() {
        return getPrecio() * 1.1; // 10% more expensive than VHS
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVD{");
        sb.append("capacidad=").append(capacidad);
        sb.append(", precioBase=").append(precioBase);
        sb.append('}');
        return sb.toString();
    }
}

class Pelicula {

    private Soporte soportito;
    private String titulo;
    private String autor;
    private int anio;
    private String idioma;
    private double precioAlquiler;

    public Pelicula(Soporte soportito, String titulo, String autor, int anio, String idioma) {
        this.soportito = soportito;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.idioma = idioma;
        this.precioAlquiler = calcularPrecioAlquiler();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getIdioma() {
        return idioma;
    }

    public double calcularPrecioAlquiler() {
        return soportito.getPrecioAlquiler();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("soportito=").append(soportito);
        sb.append(", titulo=").append(titulo);
        sb.append(", autor=").append(autor);
        sb.append(", anio=").append(anio);
        sb.append(", idioma=").append(idioma);
        sb.append(", precioAlquiler=").append(precioAlquiler);
        sb.append('}');
        return sb.toString();
    }

}

class Soporte {

    private Pelicula pelicula;

    public Soporte(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecio() {
// TODO implement here
        return 0.0d;
    }

    public double getPrecioAlquiler() {
// TODO implement here
        return 0.0d;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Soporte{");
        sb.append("pelicula=").append(pelicula);
        sb.append('}');
        return sb.toString();
    }
}

class VHS extends Soporte {

    private String tipoCintaMagnetica;
    private double precioBase;
    public VHS(String tipoCintaMagnetica, double precioBase) {
        super(null);
        this.tipoCintaMagnetica = tipoCintaMagnetica;
        this.precioBase = precioBase;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public double getPrecioAlquiler() {
        return getPrecio();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VHS{");
        sb.append("tipoCintaMagnetica=").append(tipoCintaMagnetica);
        sb.append('}');
        return sb.toString();
    }
}
