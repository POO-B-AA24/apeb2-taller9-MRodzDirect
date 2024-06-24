
/**
 *
 * @author MRodzDirect 😉 <Organico>
 */
import java.util.ArrayList;
import java.util.List;

public class Problema1 {

    public static void main(String[] args) {
        // Instancio todos los objetos
// Crea un nuevo libro
        Libro libro = new Libro();

// Crea un nuevo capitulo
        Capitulo capitulo = new Capitulo("Capitulo 1", 1);

// Crea una nueva seccion
        Seccion seccion = new Seccion("Seccion 1", 1);

// Crea un nuevo parrafo
        Parrafo parrafo = new Parrafo("Este es un parrafo de prueba.");

// Agrega una sentencia al parrafo
        Sentencia sentencia = new Sentencia("Esta es una frase de prueba.");

// Agrega una palabra a la sentencia
        Palabra palabra = new Palabra("prueba");
        sentencia.addPalabra(palabra);

// Agrega la sentencia al parrafo
        parrafo.addSentencia(sentencia);

// Crea una nueva figura
        Figura figura = new Figura("Figura 1", "imagen.png", "Esta es una descripcion de prueba.");

// Agrega el parrafo y la figura a la seccion
        seccion.addComponente(parrafo);
        seccion.addComponente(figura);

// Agrega la seccion al capitulo
        capitulo.secciones.add(seccion);

// Agrega el capitulo al libro
        libro.capitulos.add(capitulo);
        //
    // FIN DE INSTANCIACION, Aqui pruebo el sistemaso:
    //
// Imprimir la estructura del libro
        System.out.println("Libro:");
        for (Capitulo c : libro.capitulos) {
            System.out.println("Capitulo " + c.numero + ": " + c.titulo);
            for (Seccion s : c.secciones) {
                System.out.println("\tSeccion " + s.numero + ": " + s.titulo);
                for (ComponentesSeccion cs : s.componentes) {
                    if (cs instanceof Parrafo) { // Verifico si pertenece a la clase parrafo para hacer el siguiente procesamiento:
                        Parrafo p = (Parrafo) cs;
                        System.out.println("\t\tParrafo: " + p.texto);
                        for (Sentencia st : p.sentencias) {
                            System.out.println("\t\t\tSentencia: " + st.texto);
                            for (Palabra w : st.palabras) {
                                System.out.println("\t\t\t\tPalabra: " + w.texto);
                            }
                        }
                    } else if (cs instanceof Figura) { // De lo contrario verifico si pertenece a la clase Figura para hacer el siguiente procesamiento:
                        Figura f = (Figura) cs;
                        System.out.println("\t\tFigura: " + f.imagen + " - " + f.descripcion);
                    }
                }
            }
        }
    }
}





class Libro {

    List<Capitulo> capitulos;

    public Libro() {
        capitulos = new ArrayList<>();
    }
}

class Capitulo {

    String titulo;
    int numero;
    List<Seccion> secciones;

    public Capitulo(String titulo, int numero) {
        this.titulo = titulo;
        this.numero = numero;
        this.secciones = new ArrayList<>();
    }
}

class Seccion {

    String titulo;
    int numero;
    List<ComponentesSeccion> componentes;

    public Seccion(String titulo, int numero) {
        this.titulo = titulo;
        this.numero = numero;
        this.componentes = new ArrayList<>();
    }

    public void addComponente(ComponentesSeccion componente) {
        this.componentes.add(componente);
    }
}

abstract class ComponentesSeccion {

    String texto;

    public ComponentesSeccion(String texto) {
        this.texto = texto;
    }
}

class Figura extends ComponentesSeccion {

    String imagen;
    String descripcion;

    public Figura(String texto, String imagen, String descripcion) {
        super(texto);
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
}

class Parrafo extends ComponentesSeccion {

    List<Sentencia> sentencias;

    public Parrafo(String texto) {
        super(texto);
        this.sentencias = new ArrayList<>();
    }

    public void addSentencia(Sentencia sentencia) {
        this.sentencias.add(sentencia);
    }
}

class Sentencia {

    String texto;
    List<Palabra> palabras;

    public Sentencia(String texto) {
        this.texto = texto;
        this.palabras = new ArrayList<>();
    }

    public void addPalabra(Palabra palabra) {
        this.palabras.add(palabra);
    }
}

class Palabra {

    String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }
}
