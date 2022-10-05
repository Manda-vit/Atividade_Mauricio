public class Login {
  private String senha;
  private String cpf;
  private String nome;
  private String endereco;

  public Login(String nome, String cpf, String endereco, String senha) {
    this.senha = senha;
    this.cpf = cpf;
    this.nome = nome;
    this.endereco = endereco;
  }

  public String getSenha() {
    return senha;
  }
  public void setSenha(String senha) {
    this.senha = senha;
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
