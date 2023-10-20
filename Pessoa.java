public class Pessoa {

    private static int counter = 1;

    private int numeroPessoa, senha, data;
    private String nome, email;
    private long telefone, cpf;
    private char sexo;

    public Pessoa(String nome, String email, long telefone, int data, char sexo, long cpf, int senha) {
        this.numeroPessoa = Pessoa.counter;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.data = data;
        this.sexo = sexo;
        this.senha = senha;
        Pessoa.counter += 1;
    }

    public boolean login(String username, int password) {
        return this.email.equals(username) && this.senha == password;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getNome() {
        return nome;
    }
    public void setName(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void set(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return email;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    public String getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }

}