package AcmeFun.cliente;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class CatalogoUsuarios {

    private final static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Arquivo arquivo = new Arquivo();
    private static File persistenciaClientes = new File(
            "src/main/resources/com/example/trabalhofinal2/arquivos/persistencia-clientes.dat");

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean encontraEmailUsuario(Usuario usuario){
        for (Usuario value : usuarios) {
            if (value.getEmail().equals(usuario.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public Usuario buscaUsuarioPorEmail(String email){
        for (Usuario value : usuarios) {
            if (value.getEmail().equals(email)) {
                return value;
            }
        }
        return null;
    }

    public boolean validaSenhaUsuario(Usuario usuario){
        Usuario aux = buscaUsuarioPorEmail(usuario.getEmail());
        if(aux.getSenha().equals(usuario.getSenha())){
            return true;
        }else{
            return false;
        }
    }

    public boolean usuarioDisponivel(Usuario usuario){
        if(encontraEmailUsuario(usuario)) {
            return false;
        }else{
            return true;
        }
    }

    public boolean addClienteValido(Usuario usuario){
        if(usuarioDisponivel(usuario)){
            usuarios.add(usuario);
            arquivo.writeFile(persistenciaClientes,usuario.toString() + "\n");
            return true;
        }
            return false;
        }

    public ArrayList<ClienteIndividual> listaClientesIndividuais(){
        ArrayList<ClienteIndividual> aux = new ArrayList<>();
        for (Usuario value : usuarios) {
            if (value.defineTipo()==3 || value.defineTipo()==1) {
                aux.add((ClienteIndividual) value);
            }
        }
        return aux;
    }
     public ArrayList<ClienteIndividual> listaClientesIndividuaisComEmpresa(){
         ArrayList<ClienteIndividual> aux = new ArrayList<>();
         for (Usuario value : usuarios) {
             if (value.defineTipo()==3) {
                 aux.add((ClienteIndividual) value);
             }
         }
         return aux;
     }

    public ArrayList<ClienteIndividual> listaClientesIndividuaisSemEmpresa(){
        ArrayList<ClienteIndividual> aux = new ArrayList<>();
        for (Usuario value : usuarios) {
            if (value.defineTipo()==1) {
                aux.add((ClienteIndividual) value);
            }
        }
        return aux;
    }

     public ArrayList<ClienteEmpresarial> listaClientesEmpresariais(){
         ArrayList<ClienteEmpresarial> aux = new ArrayList<>();
         for (Usuario value : usuarios) {
             if (value.defineTipo()==2) {
                 aux.add((ClienteEmpresarial) value);
             }
         }
         return aux;
     }

     public boolean emailValido(String email){
         for (Usuario value : usuarios) {
             if (value.getEmail().equals(email)) {
                 return false;
             }
         }
         return true;
     }

     public boolean cpfValido(String cpf){
        ArrayList<ClienteIndividual> clientes = listaClientesIndividuais();
        for(ClienteIndividual value : clientes){
            if(value.getCpf().equals(cpf)){
                return false;
            }
        }
        return true;
     }

     public boolean cnpjInvalido(String cnpj){
        ArrayList<ClienteEmpresarial> clientes = listaClientesEmpresariais();
        for(ClienteEmpresarial value : clientes){
            if(value.getCnpj().equals(cnpj)){
                return false;
            }
        }
        return true;
     }

    public String relatorioFinalClientes(){
        String aux = "";
        for (Usuario value : usuarios) {
            aux+= "Cadastrado Cliente: " + value.toString() + "\n";
        }
        if(!aux.equals("")){
            return aux;
        } else{
            return null;
        }
    }

    public File getPersistenciaClientes() {
        return persistenciaClientes;
    }

    public String toString() {
        return "\n";
    }
}





