
/**
 *
 * @author MRodzDirect 😉 <Organico>
 */
public class Problema4 {

    public static void main(String[] args) {

        Gerente gerenteAna = new Gerente("Ana Lopez", "Calle 4", "44455566", 7000.0);
        EmpleadoFijo empleadoFijo = new EmpleadoFijo("Juan Perez", "Calle 1", "12345678", 5000.0, gerenteAna);
        EmpleadoComision empleadoComision = new EmpleadoComision("Maria Rodriguez", "Calle 2", "98765432", 0.1, 1500, gerenteAna);
        EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora("Pedro Sanchez", "Calle 3", "11122233", 20.0, 42, gerenteAna);

        System.out.println("Salario Empleado Fijo: " + empleadoFijo.getSalario());
        System.out.println("Salario Empleado Comision: " + empleadoComision.getSalario());
        System.out.println("Salario Empleado Por Hora: " + empleadoPorHora.getSalario());
        System.out.println("Salario Gerente: " + gerenteAna.getSalario());
    }
}

abstract class Empleado {

    private String nombre;
    private String direccion;
    private String dni;

    public Empleado(String nombre, String direccion, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public abstract double getSalario();
}

class EmpleadoFijo extends Empleado {

    private double salario;
    private Gerente jefe;

    public EmpleadoFijo(String nombre, String direccion, String dni, double salario, Gerente jefe) {
        super(nombre, direccion, dni);
        this.salario = salario;
        this.jefe = jefe;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    public Gerente getJefe() {
        return jefe;
    }

    public void setJefe(Gerente jefe) {
        this.jefe = jefe;
    }
}

class EmpleadoComision extends Empleado {

    private double comision;
    private double ventas;
    private Gerente jefe;

    public EmpleadoComision(String nombre, String direccion, String dni, double comision, double ventas, Gerente jefe) {
        super(nombre, direccion, dni);
        this.comision = comision;
        this.jefe = jefe;
    }

    @Override
    public double getSalario() {
        return comision * getVentas();
    }

    public Gerente getJefe() {
        return jefe;
    }

    public void setJefe(Gerente jefe) {
        this.jefe = jefe;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getVentas() {
        return ventas;
    }

}

class EmpleadoPorHora extends Empleado {

    private double tarifa;
    private int horasTrabajadas;
    private Gerente jefe;

    public EmpleadoPorHora(String nombre, String direccion, String dni, double tarifa, int horasTrabajadas, Gerente jefe) {
        super(nombre, direccion, dni);
        this.tarifa = tarifa;
        this.horasTrabajadas = horasTrabajadas;
        this.jefe = jefe;
    }

    @Override
    public double getSalario() {
        double salario = 0;
        if (horasTrabajadas <= 40) {
            salario = tarifa * horasTrabajadas;
        } else {
            salario = 40 * tarifa + (horasTrabajadas - 40) * tarifa * 1.5; // 50% mas depago por cada hora extra
        }
        return salario;
    }

    public Gerente getJefe() {
        return jefe;
    }

    public void setJefe(Gerente jefe) {
        this.jefe = jefe;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}

class Gerente extends Empleado {

    private double salario;

    public Gerente(String nombre, String direccion, String dni, double salario) {
        super(nombre, direccion, dni);
        this.salario = salario;
    }

    @Override
    public double getSalario() {
        return salario;
    }
}
