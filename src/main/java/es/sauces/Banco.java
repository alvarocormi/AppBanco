package es.sauces;

import java.util.*;


public class Banco {
    private String nombre;
    private Map<String, Cuenta> cuentas;

    /* CONSTRUCTOR */
    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas = new HashMap<>();
    }

    /**
     * @return String
     */

    /* GETTERS */
    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas() {
        return new ArrayList<>(cuentas.values());
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* METODOS */

    public boolean abrirCuenta(String codigo, String titular, float saldo) {
        return cuentas.putIfAbsent(codigo, new Cuenta(codigo, titular, saldo)) == null;
    }

    public boolean cancelarCuenta(String codigo) {
        return  cuentas.remove(codigo) != null;

    }

    public float getTotalDepositos() {
       float total;
       total =0; 

       for (Cuenta c:cuentas.values()) {
            total+=c.getSaldo();
       }

        return total;
    }

    public Cuenta getCuenta(String codigo) {
        return cuentas.get(codigo);
    }

    @Override
    public String toString() {
        return nombre;
    }

}
