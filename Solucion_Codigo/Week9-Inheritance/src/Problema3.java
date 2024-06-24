/**
 *
 * @author MRodzDirect 😉 <Organico>
 */
public class Problema3 {

    public static void main(String[] args) {
        SMS sms = new SMS("1234567890", "09876543210", "Hola!");
        MMS mms = new MMS("1234567890", "09876543210", "imagen.jpg");

        SMS sms2 = new SMS("0987654321", "1357924680", "Adios!");
        MMS mms2 = new MMS("0987654321", "1357924680", "video.mp4");

        sms.enviarMensaje();
        mms.enviarMensaje();
        sms.visualizarMensaje();
        mms.visualizarMensaje();

        sms2.enviarMensaje();
        mms2.enviarMensaje();
        sms2.visualizarMensaje();
        mms2.visualizarMensaje();

    }
}

abstract class Mensaje {

    private String numeroRemitente;
    private String numeroDestinatario;

    public Mensaje(String numeroRemitente, String numeroDestinatario) {
        this.numeroRemitente = numeroRemitente;
        this.numeroDestinatario = numeroDestinatario;
    }

    public String getNumeroRemitente() {
        return numeroRemitente;
    }

    public String getNumeroDestinatario() {
        return numeroDestinatario;
    }

    public abstract void enviarMensaje();

    public void visualizarMensaje() {
        System.out.println("Remitente: " + this.numeroRemitente);
        System.out.println("Destinatario: " + this.numeroDestinatario);
    }
}

class SMS extends Mensaje {

    private String texto;

    public SMS(String numeroRemitente, String numeroDestinatario, String texto) {
        super(numeroRemitente, numeroDestinatario);
        this.texto = texto;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando SMS: " + texto);
    }

    @Override
    public void visualizarMensaje() {
        super.visualizarMensaje();
        System.out.println("Texto: " + this.texto);
    }
}

class MMS extends Mensaje {

    private String archivo;

    public MMS(String numeroRemitente, String numeroDestinatario, String archivo) {
        super(numeroRemitente, numeroDestinatario);
        this.archivo = archivo;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando MMS: " + archivo);
    }

    @Override
    public void visualizarMensaje() {
        super.visualizarMensaje();
        System.out.println("Archivo: " + this.archivo);
    }
}
