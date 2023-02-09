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
        if (saldo > 0) {
            this.saldo = saldo;
        }
        movimientos = new ArrayList<>();
        movimientos.add(new Movimiento(LocalDate.now(), 'I', this.saldo, this.saldo));
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
        List<Movimiento> listado=new ArrayList<>();

        for (Movimiento m : movimientos) {
            if (m.getFecha().isAfter(desde) && m.getFecha().isBefore(hasta)) {
                listado.add(m);
            }
        }
        return listado;
    }

    /* METODOS */
    public void ingresar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            movimientos.add(new Movimiento(LocalDate.now(), 'I', cantidad, saldo));
        }
    }

    public void reintegrar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            movimientos.add(new Movimiento(LocalDate.now(), 'R', -cantidad, saldo));

        }
    }

    public void realizarTransferencia(Cuenta destino, float cantidad) {
        if (destino != null && this.equals(destino) && cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            movimientos.add(new Movimiento(LocalDate.now(), 'T', -cantidad, saldo));
            destino.saldo += cantidad;
            destino.movimientos.add(new Movimiento(LocalDate.now(), 'I', cantidad, destino.saldo));
        }
    }

    public String listarMovimientos() {
        StringBuilder sb = new StringBuilder();
        for (Movimiento m : movimientos) {
            sb.append(m);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return codigo + "," + titular + "," + saldo;
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
