public class Conta {
  private String numero;
  private String agencia;
  private double saldo;
  private String cpf;
  private String nome;
  private String endereco;

  public Conta(String cpf, String nome, String endereco, String numero, String agencia, Double saldo) {
    this.numero = numero;
    this.agencia = agencia;
    this.cpf = cpf;
    this.nome = nome;
    this.endereco = endereco;

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
    this.saldo = saldo;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getEndereco() {
    return endereco;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  
}