package es.sauces;

import java.util.*;

public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;

    /* CONSTRUCTOR */
    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas = new ArrayList<>();
    }

    /* GETTERS */
    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* METODOS */

    public boolean abrirCuenta(String codigo, String titular, float saldo) {
        return true;
    }    

    public boolean cancelarCuenta(String codigo) {
        return true;
    }

    public float getTotalDepositos() {
        return 0;
    }

    public Cuenta getCuenta(String codigo) {
        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }


    private int buscarCuenta(String codigo) {
        return -1;
    }
    
    
}
