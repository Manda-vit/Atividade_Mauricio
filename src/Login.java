public class Login extends Pessoa {
  private String senha;

  public Login(String cpf, String nome, String endereco, String senha) {
    super(cpf, nome, endereco);
    this.senha = senha;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

}
