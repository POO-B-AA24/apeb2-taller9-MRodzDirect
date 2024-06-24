/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MRodzDirect 😉 <Organico>
 */
public class Problema6 {

    public static void main(String[] args) {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(1234, "Juan Perez", 1000.0);
        CuentaAhorro cuentaAhorro = new CuentaAhorro(5678, "Maria Perez", 500.0, 0.05);
        CuentaPlatino cuentaPlatino = new CuentaPlatino(9012, "Carlos Sanchez", 2000.0);

        cuentaCorriente.depositar(500.0);
        cuentaAhorro.depositar(200.0);
        cuentaPlatino.depositar(1000.0);

        cuentaAhorro.calcularInteres();
        cuentaPlatino.calcularInteres();

        System.out.println("Saldo de la Cuenta Corriente: " + cuentaCorriente.getSaldo());
        System.out.println("Saldo de la Cuenta Ahorro: " + cuentaAhorro.getSaldo());
        System.out.println("Saldo de la Cuenta Platino: " + cuentaPlatino.getSaldo());
        
    }
}

abstract class Cuenta {

    private int numeroCuenta;
    private String nombrePropietario;
    private double saldo;
    private String tipoCuenta;

    public Cuenta(int numeroCuenta, String nombrePropietario, double saldo, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.nombrePropietario = nombrePropietario;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void depositar(double cantidad);

    public abstract void retirar(double cantidad);

    public void calcularInteres() {
        if (tipoCuenta.equals("Ahorro") || tipoCuenta.equals("Platino")) {
            double interes = 0;
            if (tipoCuenta.equals("Ahorro")) {
                interes = saldo * 0.05; // 5% interest rate
            } else if (tipoCuenta.equals("Platino")) {
                interes = saldo * 0.10; // 10% interest rate
            }
            saldo += interes;
        }
    }
}

class CuentaCorriente extends Cuenta {

    private double saldo;

    public CuentaCorriente(int numeroCuenta, String nombrePropietario, double saldo) {
        super(numeroCuenta, nombrePropietario, saldo, "Cheques");
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        saldo -= cantidad;
    }
}

class CuentaAhorro extends Cuenta {

    private double saldo;
    private double tasaInteres;

    public CuentaAhorro(int numeroCuenta, String nombrePropietario, double saldo, double tasaInteres) {
        super(numeroCuenta, nombrePropietario, saldo, "Ahorro");
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        if (saldo - cantidad >= 0) {
            saldo -= cantidad;
        } else {
            System.out.println("Error: No hay fondos suficientes.");
        }
    }

    public void calcularInteres() {
        double interes = saldo * tasaInteres;
        saldo += interes;
    }
}

class CuentaPlatino extends CuentaAhorro {

    private double saldo;

    public CuentaPlatino(int numeroCuenta, String nombrePropietario, double saldo) {
        super(numeroCuenta, nombrePropietario, saldo, 0.10);
    }

    @Override
    public void calcularInteres() {
        double interes = saldo * 0.10;
        saldo += interes;
    }
}
