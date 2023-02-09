package es.sauces;

import java.util.*;

public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;

    /* CONSTRUCTOR */
    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas = new LinkedList<>();
    }
    
    /** 
     * @return String
     */
    
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
        boolean cuentaCreada=false;
        Cuenta c;
        c=new Cuenta(codigo, titular, saldo);

        if (!cuentas.contains(c)) {
            cuentas.add(c);
            cuentaCreada=true;
        }

        return cuentaCreada;
    }    

    public boolean cancelarCuenta(String codigo) {
        boolean cuentaCancelada=false;
        int posicion;
        posicion=buscarCuenta(codigo);

        if (posicion>=0) {
            cuentas.remove(posicion);
            cuentaCancelada=true;
        }

        return cuentaCancelada;
    }

    public float getTotalDepositos() {
        float total;
        total=0;

        for (Cuenta c : cuentas) {
            total+=c.getSaldo();
        }

        return total;
    }

    public Cuenta getCuenta(String codigo) {
        Cuenta c=null;
        int posicion;
        posicion=buscarCuenta(codigo);
        
        if (posicion >= 0) {
            c=cuentas.get(posicion);
        }

        return c;
    }

    @Override
    public String toString() {
        return nombre;
    }


    private int buscarCuenta(String codigo) {
        int posicion=-1;
        for (int i = 0; i < cuentas.size() && posicion==-1; i++) {
            if (cuentas.get(i).getCodigo().equals(codigo)) {
                posicion=i;
            }
        }

        return posicion;
    }
    
    
}
