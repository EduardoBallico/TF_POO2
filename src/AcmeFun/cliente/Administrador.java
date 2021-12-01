package AcmeFun.cliente;

public class Administrador extends Usuario{
    public Administrador(String email, String senha) {
        super(email, senha);
    }

    @Override
    public String getTipo() {
        return null;
    }

}

