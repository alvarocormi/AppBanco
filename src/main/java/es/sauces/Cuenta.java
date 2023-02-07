package es.sauces;

import java.time.LocalDate;
import java.util.*;

public class Cuenta {
    private String codigo;
    private String titular;
    private float saldo;
    private List<Movimiento> movimientos;

    /* CONSTRUCTOR */
    public Cuenta(String codigo, String titular, float saldo) {
        this.codigo = codigo;
        this.titular = titular;
        this.saldo = saldo;
        movimientos = new ArrayList<>(); 
    }

    /* GETTER */
    public String getCodigo() {
        return codigo;
    }

    public String getTitular() {
        return titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /* SETTER */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public List<Movimiento> getMovimientos(LocalDate desde, LocalDate hasta) {
        return movimientos;
    }

    /* METODOS */

    public void ingresar(float cantidad) {

    }

    public void reintegrar(float reintegrar) {

    }

    public void realizarTransferencia(Cuenta destino, float cantidad) {

    }

    public String listarMovimientos() {
        return null;
    }

    @Override
    public String toString() {
        return codigo + ","+ titular + "," + saldo;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cuenta other = (Cuenta) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
