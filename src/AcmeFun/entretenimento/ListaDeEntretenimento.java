package AcmeFun.entretenimento;

import AcmeFun.Arquivo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ListaDeEntretenimento {

    private ArrayList<Entretenimento> entretenimentos = new ArrayList<>();
    private ArrayList<Entretenimento> ultimaConsulta = null;

    public ArrayList<Entretenimento> getUltimaConsulta() throws NullPointerException {
        if (ultimaConsulta == null){
            throw new NullPointerException();
        }
        return ultimaConsulta;
    }

    public boolean verificaCodigo(Entretenimento entretenimento){
        for (Entretenimento ent : entretenimentos) {
            if (ent.getCodigo().equals(entretenimento.getCodigo())) {
                return false;
            }
        }
        return true;
    }

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
        ultimaConsulta = new ArrayList<>();
        for (Entretenimento ent : entretenimentos) {
            if(ent.getAnoLancamento() == anoLancamento){
                ultimaConsulta.add(ent);
            }
        }
        if(ultimaConsulta.isEmpty()){ return null; }
        return ultimaConsulta;
    }

    public Entretenimento pesquisaCodigo(String codigo){
        ultimaConsulta = new ArrayList<>();
        for (Entretenimento ent : entretenimentos) {
            if(ent.getCodigo().equals(codigo)){
                ultimaConsulta.add(ent);
                return ultimaConsulta.get(0);
            }
        }
        return null;
    }

    public ArrayList<Entretenimento> ordenaTitulo(){

        ArrayList<String> array = new ArrayList<>();
        for(Entretenimento ent : ultimaConsulta){
            array.add(ent.getTitulo());
        }

        Collections.sort(array);

        ArrayList<Entretenimento> aux = new ArrayList<>();
        for (String s : array){
            for (Entretenimento e : entretenimentos){
                if (e.getTitulo().equals(s)){
                    aux.add(e);
                    ultimaConsulta.remove(e);
                }
            }
        }

        ultimaConsulta = new ArrayList<>();
        ultimaConsulta.addAll(aux);

        if(ultimaConsulta.isEmpty()){ return null; }
        return ultimaConsulta;
    }

    public ArrayList<Entretenimento> ordenaAno() {
        ArrayList<Integer> array = new ArrayList<>();
        for (Entretenimento ent : ultimaConsulta) {
            array.add(ent.getAnoLancamento());
        }

        Collections.sort(array);

        ArrayList<Entretenimento> aux = new ArrayList<>();
        for (Integer i : array) {
            for (Entretenimento e : ultimaConsulta) {
                if (e.getAnoLancamento() == i) {
                    aux.add(e);
                    ultimaConsulta.remove(e);
                }
            }
        }

        ultimaConsulta = new ArrayList<>();
        ultimaConsulta.addAll(aux);

        if (ultimaConsulta.isEmpty()) { return null; }
        return ultimaConsulta;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Entretenimento value : entretenimentos) {
            s.append("Cadastrado Entretenimento: ").append(value.toString()).append("\n");
        }
        if(!s.toString().equals("")){
            return s.toString();
        }
        else{
            return null;
        }
    }
}

