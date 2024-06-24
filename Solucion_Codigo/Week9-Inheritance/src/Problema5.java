
/**
 *
 * @author MRodzDirect 😉 <Organico>
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects; // usado para buscar la zona de forma mas eficiente, pero compleja :(.

 public class Problema5 { // ejecutor, orquesta todas las clases

    private List<Entrada> entradas;
    private List<Zona> zonas;

    public Problema5() {
        this.entradas = new ArrayList<>();
        this.zonas = new ArrayList<>();

        // Initialize zonas
        zonas.add(new Zona("Principal", 200, 25, 17.5));
        zonas.add(new Zona("PalcoB", 40, 70, 40));
        zonas.add(new Zona("Central", 400, 20, 14));
        zonas.add(new Zona("Lateral", 100, 15.5, 10));
    }

    public void venderEntrada(String zona, String nombreComprador, String tipo) {
        if (!zonas.contains(new Zona(zona, 0, 0, 0))) {
            System.out.println("No existe ninguna zona con ese nombre");
            return;
        }
        int zonaIndex = zonas.indexOf(new Zona(zona, 0, 0, 0));
        Zona zonaObj = zonas.get(zonaIndex);
        if (zonaObj.isCompleta()) {
            System.out.println("La zona elegida esta completa");
            return;
        }

        Entrada entrada;
        switch (tipo) {
            case "normal":
                entrada = new EntradaNormal(zonaObj, nombreComprador);
                break;
            case "reducida":
                entrada = new EntradaReducida(zonaObj, nombreComprador);
                break;
            case "abonado":
                entrada = new EntradaAbono(zonaObj, nombreComprador);
                break;
            default:
                System.out.println("Tipo de entrada no valido");
                return;
        }

        entradas.add(entrada);
        zonaObj.venderEntrada();
        System.out.println("Entrada vendida con id " + entrada.getId() + " y precio " + entrada.getPrecio());
    }

    public void consultarEntrada(int id) {
        for (Entrada entrada : entradas) {
            if (entrada.getId() == id) {
                System.out.println("Nombre del espectador: " + entrada.getNombreComprador());
                System.out.println("Precio: " + entrada.getPrecio());
                System.out.println("Nombre de la zona: " + entrada.getZona().getNombre());
                return;
            }
        }
        System.out.println("No existe ninguna entrada con ese identificador");
    }

    public static void main(String[] args) {
        Problema5 ejecutor = new Problema5();
        ejecutor.venderEntrada("Principal", "Juan", "normal");
        ejecutor.venderEntrada("Central", "Maria", "reducida");
        ejecutor.consultarEntrada(1);
    }
}

abstract class Entrada {

    private static int idCounter = 1;
    private int id;
    private Zona zona;
    private String nombreComprador;
    private double precio;

    public Entrada(Zona zona, String nombreComprador, double precio) {
        this.id = idCounter++;
        this.zona = zona;
        this.nombreComprador = nombreComprador;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public Zona getZona() {
        return zona;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract void calcularPrecio();
}

class EntradaNormal extends Entrada {

    public EntradaNormal(Zona zona, String nombreComprador) {
        super(zona, nombreComprador, zona.getPrecioNormal());
    }

    public void calcularPrecio() {
        // Ya lo calcule en el constructor
    }
}

class EntradaReducida extends Entrada {

    public EntradaReducida(Zona zona, String nombreComprador) {
        super(zona, nombreComprador, zona.getPrecioNormal() * 0.85);
    }

    public void calcularPrecio() {
// Ya lo calcule en el constructor
    }
}

class EntradaAbono extends Entrada {

    public EntradaAbono(Zona zona, String nombreComprador) {
        super(zona, nombreComprador, zona.getPrecioAbono());
    }

    public void calcularPrecio() {
// Ya lo calcule en el constructor
    }
}

class Zona {

    private String nombre;
    private int capacidad;
    private double precioNormal;
    private double precioAbono;
    private int entradasVendidas;

    public Zona(String nombre, int capacidad, double precioNormal, double precioAbono) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioNormal = precioNormal;
        this.precioAbono = precioAbono;
        this.entradasVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioAbono() {
        return precioAbono;
    }

    public boolean isCompleta() {
        return entradasVendidas >= capacidad;
    }

    public void venderEntrada() {
        entradasVendidas++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Zona)) {
            return false;
        }
        Zona zona = (Zona) o;
        return Objects.equals(getNombre(), zona.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }

}
