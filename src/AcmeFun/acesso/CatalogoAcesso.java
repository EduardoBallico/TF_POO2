package AcmeFun.acesso;

import AcmeFun.Arquivo;
import AcmeFun.cliente.*;

import java.io.File;
import java.util.ArrayList;

public class CatalogoAcesso {

    private final static ArrayList<Acesso> acessos = new ArrayList<>();
    private final static Arquivo arqv = new Arquivo();
    private static File fileAcessos = new File(
            "src/main/resources/com/example/trabalhofinal2/arquivos/persistencia-acessos.dat");

    public ArrayList<Acesso> getCatalogo() { return acessos; }

    public boolean adicionaAcesso(Acesso acesso){
        if(acesso.getCliente().defineTipo() == 3){
            acesso.setCobranca(acesso.getCobranca() / 2);

            CatalogoUsuarios listaUsuarios = new CatalogoUsuarios();
            ArrayList<ClienteIndividual> aux = new ArrayList<>();
            for (Usuario value : listaUsuarios.getUsuarios()) {
                if (value.defineTipo()==3) {
                    aux.add((ClienteIndividual) value);
                }
            }
            ClienteEmpresarial empresanova = null;
            for(ClienteIndividual clienteEspecifico : aux){
                if(clienteEspecifico.getEmail().equalsIgnoreCase(acesso.getCliente().getEmail())){
                    empresanova = clienteEspecifico.getEmpresa();
                }
            }

            Acesso acessoEmpresa = new Acesso(empresanova,acesso.getEntretenimento());
            acessoEmpresa.setCobranca(acessoEmpresa.getCobranca() / 2);
            acessos.add(acesso);
            acessos.add(acessoEmpresa);
            arqv.writeFile(fileAcessos,acesso.toString()+ "\n");
            arqv.writeFile(fileAcessos,acessoEmpresa.toString()+ "\n");
            return true;
        } else if (acesso.getCliente().defineTipo() == 2 || acesso.getCliente().defineTipo() == 1){
            acessos.add(acesso);
            arqv.writeFile(fileAcessos,acesso.toString()+ "\n");
            return true;
        }
        return false;
    }

    public ArrayList<Acesso> getAcessosDaqueleMesGeral(int ano, int mes){
        ArrayList<Acesso> resultadoGeral = new ArrayList<>();
        for (Acesso acesso : acessos) {
            if(acesso.getDataHora().getYear() == ano && acesso.getDataHora().getMonth().getValue() == mes){
                resultadoGeral.add(acesso);
            }
        }

        if(resultadoGeral.size()==0){
            return null;
        }else{
            return resultadoGeral;
        }
    }

    public ArrayList<Acesso> getAcessosDaqueleMesCliente(ArrayList<Acesso> resultadoGeral, Cliente cliente){
        ArrayList<Acesso> resultadoCliente = new ArrayList<>();
        if(resultadoGeral!=null && cliente!=null){
            for (Acesso acesso : resultadoGeral) {
                if(acesso.getCliente().equals(cliente)){
                    resultadoCliente.add(acesso);
                }
            }
        }

        if(resultadoCliente.size()==0){
            return null;
        }else{
            return resultadoCliente;
        }
    }

    public String getRelatório(ArrayList<Acesso> acessos){
        String relatorio = "";
        for (Acesso acesso : acessos) {
            relatorio += acesso.toString() + "\n";
        }
        return relatorio;

    }
    public double cobrancaMensalGeral(int ano, int mes){
        double valorFinal = 0;
        for (Acesso acesso : getAcessosDaqueleMesGeral(ano, mes)) {
            valorFinal = valorFinal + acesso.getCobranca();
        }
        return valorFinal;
    }

    public double cobrancaMensalCliente(int ano, int mes, ArrayList<Acesso> acessosCliente, Cliente cliente){
        double valorFinal = 0;
        for (Acesso acesso : getAcessosDaqueleMesCliente(acessosCliente,cliente)) {
            valorFinal = valorFinal + acesso.getCobranca();
        }
        return valorFinal;
    }

    public String relatorioFinalAcessos(File file){

        String aux = "";
        for (Acesso value : acessos) {
            aux+= "Cadastrado Acesso: " + value.toString() + "\n";
        }
        if(!aux.equals("")){
            return aux;
        } else{
            return null;
        }
    }

    public  File getFileAcessos() {
        return fileAcessos;
    }
}

