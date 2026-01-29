package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    @Test
    public void testSaldoInicial() {
        CuentaBancaria cuenta = new CuentaBancaria(0);
        assertEquals(0, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testIngresarM() {//mucho
        CuentaBancaria cuenta = new CuentaBancaria(0);
        cuenta.ingresar(20);
        cuenta.ingresar(30);

        assertEquals(50, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirarM() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(10);
        cuenta.retirar(15);

        assertEquals(75, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testIngresarP() { //poco
        CuentaBancaria cuenta = new CuentaBancaria(0);
        cuenta.ingresar(0.01);
        assertEquals(0.01, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testIngresarNo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.ingresar(-20);
        assertEquals(100, cuenta.getSaldo(), 0.01);
    }

    //Límite
    @Test
    public void testIngresarCero() {
        CuentaBancaria cuenta = new CuentaBancaria(500);
        cuenta.ingresar(0);
        assertEquals(500, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetiroTotal() {
        CuentaBancaria cuenta = new CuentaBancaria(250);
        cuenta.retirar(250);
        assertEquals(0, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRtrarCero() {
        CuentaBancaria cuenta = new CuentaBancaria(400);
        cuenta.retirar(0);
        assertEquals(400, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testIngresarMM() {//Mucho mucho
        CuentaBancaria cuenta = new CuentaBancaria(0);
        cuenta.ingresar(2147483648.0);
        assertEquals(2147483648.0, cuenta.getSaldo(), 0.01);
    }

    //robustez 
    @Test
    public void testIngresarNoSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.ingresar(-5);
        cuenta.ingresar(-10);
        cuenta.ingresar(-1.5);
        assertEquals(1000, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirarNoSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(750);
        cuenta.retirar(-20);
        assertEquals(750, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testOperaciones() {
        CuentaBancaria cuenta = new CuentaBancaria(500);
        cuenta.ingresar(-10);
        cuenta.retirar(-20);
        assertEquals(500, cuenta.getSaldo(), 0.01);
    }
}
