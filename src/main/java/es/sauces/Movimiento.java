package es.sauces;

import java.time.LocalDate;

public class Movimiento {
    private LocalDate fecha;
    private char tipo;
    private float cantidad;
    private float saldo;

    /* CONSTRUCTOR */
    public Movimiento(LocalDate fecha, char tipo, float cantidad, float saldo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.saldo = saldo;
    }

    
    /** 
     * @return LocalDate
     */
    
    /* GETTERS */
    public LocalDate getFecha() {
        return fecha;
    }

    public char getTipo() {
        return tipo;
    }

    public float getCantidad() {
        return cantidad;
    }

    /* SETTERS */
    public float getSaldo() {
        return saldo;
    }

    /* METODOS */
    @Override
    public String toString() {
        return fecha + "," + cantidad + ","+ saldo;
    }

    

    
}
