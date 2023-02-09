package es.sauces;
import java.util.Scanner;
/**
 * @author Alvaro Cordero
 *
 */
public class AppBanco {
    /**
     * @param args
     * @return int
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion, operacion;
        Banco banco;
        String codigo, titular;
        float saldo, cantidad;
        Cuenta cuenta;
        Cuenta cuentaDestino;

        banco = new Banco("Sauces");

        do {
            System.out.println("1. Abrir cuenta");
            System.out.println("2. Operar con cuenta");
            System.out.println("3. Cancelar cuenta");
            System.out.println("4. Listar cuentas");
            System.out.println("5. Consultar total depositos");
            System.out.println("0. Salir");
            System.out.println("Introduzca opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el codigo de la cuenta: ");
                    codigo = teclado.nextLine();
                    System.out.println("Introduzca el titular de la cuenta: ");
                    titular = teclado.nextLine();
                    System.out.println("Introduzca el saldo inicial: ");
                    saldo = teclado.nextFloat();

                    if (banco.abrirCuenta(codigo, titular, saldo)) {
                        System.out.println("Cuenta creada");
                    } else {
                        System.out.println("No se ha podido crear la cuenta");
                    }
                    break;
                case 2:
                    System.out.println("Introduce el codigo de tu cuenta: ");
                    codigo = teclado.nextLine();
                    cuenta = banco.getCuenta(codigo);
                    if (cuenta != null) {
                        operacion = getOperacion();
                        switch (operacion) {
                            case 1:
                                do {
                                    System.out.println("Introduzca cantidad a ingresar: ");
                                    cantidad = teclado.nextFloat();
                                } while (cantidad <= 0);
                                teclado.nextLine();
                                cuenta.ingresar(cantidad);
                                System.out.println("Ingreso realizado. Saldo: " + cuenta.getSaldo());
                                break;
                            case 2:
                                System.out.println("Introduzca la cantidad a reintegrar: ");
                                cantidad = teclado.nextFloat();
                                while (cantidad <= 0 || cantidad > cuenta.getSaldo()) {
                                    System.out.println("La cantidad o es correcta");
                                    System.out.println("Introduzca la cantidad a reintegrar: ");
                                    cantidad = teclado.nextFloat();
                                }
                                teclado.nextLine();
                                cuenta.reintegrar(cantidad);
                                System.out.println("Cantidad retirada. Saldo: " + cuenta.getSaldo());
                                break;
                            case 3:
                                System.out.println("Tu saldo actual es: " + cuenta.getSaldo());
                                break;
                            case 4:
                                System.out.println("A que cuenta quieres realizar la transferencia: ");
                                codigo = teclado.nextLine();
                                cuentaDestino = banco.getCuenta(codigo);
                                if (cuentaDestino != null) {
                                    System.out.println("Introduce la cantidad a transferir: ");
                                    cantidad = teclado.nextFloat();
                                    cuenta.realizarTransferencia(cuentaDestino, cantidad);
                                    System.out.println("Su transferencia ha sido realizada con exito");
                                    System.out.println("Su saldo actual es: "+cuenta.getSaldo());
                                } else {
                                    System.out.println("Esa cuenta no existe");
                                }
                                break;
                            case 5:
                                System.out.println("Tus movimientos son: " + cuenta.listarMovimientos());
                                break;
                            case 0:
                                System.out.println("Salir");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                    } else {
                        System.out.println("No existe una cuenta con ese codigo");
                    }
                    break;
                case 3:
                    System.out.println("Introduzca el codigo de la cuenta: ");
                    codigo = teclado.nextLine();
                    banco.cancelarCuenta(codigo);
                    System.out.println("Tu cuenta ha sido cancelada con exito!!");
                    break;
                case 4:
                    for (Cuenta c : banco.getCuentas()) {
                        System.out.println(c.toString());
                    }
                    break;
                case 5:
                    System.out.println("Tu total de deposito es: " + banco.getTotalDepositos());
                    break;
                case 0:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 0);

    }

    private static int getOperacion() {
        int operacion;
        Scanner teclado2 = new Scanner(System.in);
        System.out.println("1.-Ingresar dinero");
        System.out.println("2.-Retirar dinero");
        System.out.println("3.-Consultar saldo");
        System.out.println("4.-Realizar transferencia");
        System.out.println("5.-Consultar movimientos");
        System.out.println("0.-Salir");
        System.out.println("Introduzca una opcion");
        operacion = teclado2.nextInt();
        teclado2.nextLine();
        return operacion;
    }
}
