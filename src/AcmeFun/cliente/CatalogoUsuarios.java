package AcmeFun.cliente;

import AcmeFun.Arquivo;

import java.io.File;
import java.util.ArrayList;

public class CatalogoUsuarios {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean verificaUsuario(Usuario usuario){
        for (Usuario value : usuarios) {
            if (value.getEmail().equals(usuario.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public Usuario procuraUsuario(String email){
        for (Usuario value : usuarios) {
            if (value.getEmail().equals(email)) {
                return value;
            }
        }
        return null;
    }

    //todo
    public boolean validaSenhaUsuario(Usuario usuario){
        Usuario aux = procuraUsuario(usuario.getEmail());
        if(aux.getSenha().equals(usuario.getSenha())){
            return true;
        }else{
            return false;
        }
    }

    public boolean cadastraCliente(Usuario usuario, boolean isLoadingFromFile){
        if(!verificaUsuario(usuario)){
            usuarios.add(usuario);

            if(!isLoadingFromFile){
                Arquivo.writeFile(Arquivo.getArquivoClientes(),usuario.toString() + "\n");
            }

            return true;
        }
            return false;
        }

    public ArrayList<ClienteIndividual> clientesIndividuais(){
        ArrayList<ClienteIndividual> aux = new ArrayList<>();
        for (Usuario value : usuarios) {
            if (value.defineTipo()==3 || value.defineTipo()==1) {
                aux.add((ClienteIndividual) value);
            }
        }
        return aux;
    }
     public ArrayList<ClienteIndividual> clientesIndividuaisVinculados(){
         ArrayList<ClienteIndividual> aux = new ArrayList<>();
         for (Usuario value : usuarios) {
             if (value.defineTipo()==3) {
                 aux.add((ClienteIndividual) value);
             }
         }
         return aux;
     }

    public ArrayList<ClienteIndividual> clientesIndividuaisNaoVinculados(){
        ArrayList<ClienteIndividual> aux = new ArrayList<>();
        for (Usuario value : usuarios) {
            if (value.defineTipo()==1) {
                aux.add((ClienteIndividual) value);
            }
        }
        return aux;
    }

     public ArrayList<ClienteEmpresarial> clientesEmpresariais(){
         ArrayList<ClienteEmpresarial> aux = new ArrayList<>();
         for (Usuario value : usuarios) {
             if (value.defineTipo()==2) {
                 aux.add((ClienteEmpresarial) value);
             }
         }
         return aux;
     }

     //todo
     public boolean emailValido(String email){
         for (Usuario value : usuarios) {
             if (value.getEmail().equals(email)) {
                 return false;
             }
         }
         return true;
     }

    public String toString() {
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
}





