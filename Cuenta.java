import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuenta {

  private String codCuenta = "cta-";
  private double saldo;
  private String nombreCuentaHabiente;
  private String fechaCreacion;
  private int cantDepositosRealizados;
  private int cantRetirosExitososRealizados;

  private static int cantCuentasCreadas = 0;

  public Cuenta(String nombreCuentaHabiente, double pSaldo) {
    this.nombreCuentaHabiente = nombreCuentaHabiente;
    this.saldo = pSaldo;

    cantCuentasCreadas++;
    this.codCuenta += cantCuentasCreadas;

    this.fechaCreacion = obtenerFechaActual();
    this.cantDepositosRealizados = 0;
    this.cantRetirosExitososRealizados = 0;
  }

  public Cuenta(double pSaldo) {
    this.saldo = pSaldo;

    cantCuentasCreadas++;
    this.codCuenta += cantCuentasCreadas;

    this.fechaCreacion = obtenerFechaActual();
    this.cantDepositosRealizados = 0;
    this.cantRetirosExitososRealizados = 0;
  }

  private String obtenerFechaActual() {
    Date fecha = new Date(System.currentTimeMillis());
    DateFormat formato = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    return formato.format(fecha);
  }

  public void setNombreCuentaHabiente(String nombreCuentaHabiente) {
    this.nombreCuentaHabiente = nombreCuentaHabiente;
  }

  public String getCodCuenta() {
    return codCuenta;
  }

  public double getSaldo() {
    return saldo;
  }

  public double depositar(double monto) {
    saldo += monto;
    cantDepositosRealizados++;
    return saldo;
  }

  public double retirar(double monto) {
    if (validarRetiro(monto)) {
      saldo -= monto;
      cantRetirosExitososRealizados++;
    }
    return saldo;
  }

  private boolean validarRetiro(double monto) {
    return monto <= saldo;
  }

  public static int getCantCuentasCreadas() {
    return cantCuentasCreadas;
  }

  public String toString() {
    return "===== Cuenta =====\n"
        + "Código: " + codCuenta + "\n"
        + "Nombre: " + nombreCuentaHabiente + "\n"
        + "Saldo: " + saldo + "\n"
        + "Fecha creación: " + fechaCreacion + "\n"
        + "Depósitos realizados: " + cantDepositosRealizados + "\n"
        + "Retiros exitosos: " + cantRetirosExitososRealizados + "\n";
  }
}