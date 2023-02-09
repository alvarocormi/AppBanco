package es.sauces;

import java.util.*;

public class Banco {
    private String nombre;
    private Set<Cuenta> cuentas;

    /* CONSTRUCTOR */
    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas = new TreeSet<>();
    }

    /**
     * @return String
     */

    /* GETTERS */
    public String getNombre() {
        return nombre;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* METODOS */

    public boolean abrirCuenta(String codigo, String titular, float saldo) {
        return cuentas.add(new Cuenta(codigo, titular, saldo));
    }

    public boolean cancelarCuenta(String codigo) {
        boolean cuentaCancelada=false;
        Cuenta c;

        c=getCuenta(codigo);
        if (c!=null) {
            cuentaCancelada=cuentas.remove(c);
        }
        
        return cuentaCancelada;
        
    }

    public float getTotalDepositos() {
        float total;
        total = 0;

        for (Cuenta c : cuentas) {
            total += c.getSaldo();
        }

        return total;
    }

    public Cuenta getCuenta(String codigo) {

        for (Cuenta c : cuentas) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
