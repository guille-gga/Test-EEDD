package modelo;

public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void ingresar(double cantidad) {
        if(cantidad>0){
        saldo += cantidad;

        }
    }

    public void retirar(double cantidad) {
        if(cantidad>0 && cantidad<=saldo){
        
            saldo -= cantidad;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
