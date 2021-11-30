package AcmeFun.entretenimento;

import AcmeFun.Arquivo;

import java.io.File;
import java.util.ArrayList;

public class CatalogoEntretenimento {

    private final static ArrayList<Entretenimento> entretenimentos = new ArrayList<>();

    private ArrayList<Entretenimento> ultimaConsulta;
    public ArrayList<Entretenimento> getEntretenimentos() { return entretenimentos; }

    public boolean verificaCodigo(Entretenimento entretenimento){
        for (Entretenimento ent : entretenimentos) {
            if (ent.getCodigo().equals(entretenimento.getCodigo())) {
                return false;
            }
        }
        return true;
    }

    // Feshow
    public boolean addEntretenimento(Entretenimento entretenimento, boolean isLoadingFromFile){
        if(verificaCodigo(entretenimento)){
            entretenimentos.add(entretenimento);

            if(!isLoadingFromFile){
                Arquivo.writeFile(Arquivo.getArquivoEntretenimentos(),entretenimento.toString() + "\n");
            }

            return true;
        }
        return false;
    }

    public Serie pesquisaSerie(String nome){
        ArrayList<Serie> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if (value.getTipo()==3) {
                if(value.getTitulo().equals(nome))
                    return (Serie) value;
            }
        }
        return null;
    }

    public ArrayList<String> escreveNomeSerie(){
        ArrayList<String> list = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if (value.getTipo()==3) {
                list.add(value.getTitulo());
            }
        }
        return list;
    }

    public ArrayList<Entretenimento> pesquisaTitulo(String titulo){

        ultimaConsulta = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getTitulo().equals(titulo)
                    || value.getTitulo().contains(titulo)){
                ultimaConsulta.add(value);
            }
        }
        if(ultimaConsulta.isEmpty()){ return null; }
        return ultimaConsulta;
    }

    public ArrayList<Entretenimento> pesquisaAnoLanc(int anoLancamento){
        ArrayList<Entretenimento> list = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getAnoLancamento() > anoLancamento && value.getAnoLancamento() < anoLancamento){
                list.add(value);
            }
        }
        if(list.size()==0){ return null; }
        return list;
    }

    public Entretenimento pesquisaCodigo(String codigo){
        Entretenimento entC = null;
        for (Entretenimento ent : entretenimentos) {
            if(ent.getCodigo().equals(codigo)){
                entC = ent;
                return entC;
            }
        }
        return null;
    }

    //todo
    public String relatorioFinalEntretenimento(){
        String s = "";
        for (Entretenimento value : entretenimentos) {
                s+= "Cadastrado Entretenimento: " + value.toString() + "\n";
            }
        if(!s.equals("")){
            return s;
        } else{
            return null;
        }


    }

}


