package AcmeFun.entretenimento;

import AcmeFun.Arquivo;

import java.io.File;
import java.util.ArrayList;

public class CatalogoEntretenimento {

    private final static ArrayList<Entretenimento> entretenimentos = new ArrayList<>();
    private static Arquivo arquivo = new Arquivo();
    private static File persistenciaEntretenimento= new File(
            "src/main/resources/com/example/trabalhofinal2/arquivos/persistencia-entretenimento.dat");


    public ArrayList<Entretenimento> getCatalogo() { return entretenimentos; }

    public boolean verificaCodigo(Entretenimento entretenimento){
        for (Entretenimento ent : entretenimentos) {
            if (ent.getCodigo().equals(entretenimento.getCodigo())) {
                return false;
            }
        }
        return true;
    }

    public boolean addEntretenimentoValido(Entretenimento entretenimento){
        if(verificaCodigo(entretenimento)){
            entretenimentos.add(entretenimento);
            arquivo.writeFile(persistenciaEntretenimento,entretenimento.toString() + "\n");
            System.out.println("Adicionou e escreveu");
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

    public ArrayList<Entretenimento> pesquisaTitCompleto(String titulo){
        ArrayList<Entretenimento> list = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getTitulo().equals(titulo)){
                list.add(value);
            }
        }
        if(list.size()==0){ return null; }
        return list;
    }

    public ArrayList<Entretenimento> pesquisaTitIncompleto(String tituloIncompleto){
        ArrayList<Entretenimento> list = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getTitulo().contains(tituloIncompleto)){
                list.add(value);
            }
        }
        if(list.size()==0){ return null; }
        return list;
    }

    public ArrayList<Entretenimento> pesquisaAnoLanc(int anoLancamentoInicio, int anoLancamentoFinal){
        ArrayList<Entretenimento> list = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getAnoLancamento() > anoLancamentoInicio && value.getAnoLancamento() < anoLancamentoFinal){
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


