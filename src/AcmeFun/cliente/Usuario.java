package AcmeFun.cliente;

public abstract class Usuario {
    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public abstract String getTipo();

    @Override
    public abstract String toString();
}

