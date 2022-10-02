public class Conta extends Pessoa {
  private String numero;
  private String agencia;
  private double saldo;

  public Conta(String cpf, String nome, String endereco, String numero, String agencia, double saldo) {
    super(cpf, nome, endereco);
    this.numero = numero;
    this.agencia = agencia;
   
    if (saldo < 0) {
      System.out.println("O saldo não pode ser negativo, então ele foi setado como ZERO");
      this.saldo = 0;
    } else {
      this.saldo = saldo;
    }
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    if (saldo >= 0) {
      this.saldo = saldo;
    } else {
      System.out.println("valor não pode ser negativo.");
    }
  }
}