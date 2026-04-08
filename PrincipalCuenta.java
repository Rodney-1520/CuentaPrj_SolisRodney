import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalCuenta {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Cuenta> cuentas = new ArrayList<>();
    int indiceActual = -1;
    boolean salir = false;

    while (!salir) {
      System.out.println("\n===== MENÚ =====");
      System.out.println("1) Crear cuenta");
      System.out.println("2) Cantidad de cuentas");
      System.out.println("3) Listar cuentas");
      System.out.println("4) Seleccionar cuenta");
      System.out.println("5) Asignar nombre");
      System.out.println("6) Depositar");
      System.out.println("7) Retirar");
      System.out.println("8) Consultar saldo");
      System.out.println("9) Ver estado");
      System.out.println("0) Salir");
      System.out.print("Opción: ");

      String opcion = scanner.nextLine();

      switch (opcion) {
        case "1":
          System.out.print("Saldo inicial: ");
          double saldo = Double.parseDouble(scanner.nextLine());

          System.out.print("¿Desea ingresar nombre? (s/n): ");
          String respuesta = scanner.nextLine();

          Cuenta cuenta;

          if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            cuenta = new Cuenta(nombre, saldo);
          } else {
            cuenta = new Cuenta(saldo);
          }

          cuentas.add(cuenta);
          indiceActual = cuentas.size() - 1;

          System.out.println("Cuenta creada y seleccionada.");
          break;

        case "2":
          System.out.println(
              "Total cuentas: " + Cuenta.getCantCuentasCreadas());
          break;

        case "3":
          if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas.");
          } else {
            for (int i = 0; i < cuentas.size(); i++) {
              System.out.println("Índice " + i);
              System.out.println(cuentas.get(i));
            }
          }
          break;

        case "4":
          if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas.");
            break;
          }

          System.out.print("Índice: ");
          int indice = Integer.parseInt(scanner.nextLine());

          if (indice >= 0 && indice < cuentas.size()) {
            indiceActual = indice;
            System.out.println("Cuenta seleccionada.");
          } else {
            System.out.println("Índice inválido.");
          }
          break;

        case "5":
          if (indiceActual < 0) {
            System.out.println("Seleccione una cuenta primero.");
            break;
          }

          System.out.print("Nombre: ");
          String nombre = scanner.nextLine();
          cuentas.get(indiceActual).setNombreCuentaHabiente(nombre);
          break;

        case "6":
          if (indiceActual < 0) {
            System.out.println("Seleccione una cuenta primero.");
            break;
          }

          System.out.print("Monto: ");
          double montoDeposito = Double.parseDouble(scanner.nextLine());
          cuentas.get(indiceActual).depositar(montoDeposito);
          break;

        case "7":
          if (indiceActual < 0) {
            System.out.println("Seleccione una cuenta primero.");
            break;
          }

          System.out.print("Monto: ");
          double montoRetiro = Double.parseDouble(scanner.nextLine());
          cuentas.get(indiceActual).retirar(montoRetiro);
          break;

        case "8":
          if (indiceActual < 0) {
            System.out.println("Seleccione una cuenta primero.");
            break;
          }

          System.out.println(
              "Saldo: " + cuentas.get(indiceActual).getSaldo());
          break;

        case "9":
          if (indiceActual < 0) {
            System.out.println("Seleccione una cuenta primero.");
            break;
          }

          System.out.println(cuentas.get(indiceActual));
          break;

        case "0":
          salir = true;
          System.out.println("Adiós.");
          break;

        default:
          System.out.println("Opción inválida.");
      }
    }

    scanner.close();
  }
}