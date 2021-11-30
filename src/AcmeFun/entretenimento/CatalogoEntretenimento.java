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

    public boolean codigoUnico(Entretenimento entretenimento){
        for (Entretenimento value : entretenimentos) {
            if (value.getCodigo().equals(entretenimento.getCodigo())) {
                return false;
            }
        }
        return true;
    }

    public boolean addEntretenimentoValido(Entretenimento entretenimento){
        if(codigoUnico(entretenimento)){
            entretenimentos.add(entretenimento);
            arquivo.writeFile(persistenciaEntretenimento,entretenimento.toString() + "\n");
            System.out.println("Adicionou e escreveu");
            return true;
        }
        return false;
    }

    public Serie buscaSerie(String nome){
        ArrayList<Serie> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if (value.getTipo()==3) {
                if(value.getTitulo().equals(nome))
                    return (Serie) value;
            }
        }
        return null;
    }

    public ArrayList<String> listaNomeSeries(){
        ArrayList<String> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if (value.getTipo()==3) {
                aux.add(value.getTitulo());
            }
        }
        return aux;
    }

    public ArrayList<Entretenimento> buscaPorTituloCompleto(String titulo){
        ArrayList<Entretenimento> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getTitulo().equals(titulo)){
                aux.add(value);
            }
        }
        if(aux.size()==0){
            return null;
        }
        return aux;
    }

    public ArrayList<Entretenimento> buscaPorTituloIncompleto(String tituloIncompleto){
        ArrayList<Entretenimento> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getTitulo().contains(tituloIncompleto)){
                aux.add(value);
            }
        }
        if(aux.size()==0){
            return null;
        }

        return aux;
    }

    public ArrayList<Entretenimento> buscaPorAnoLancamento(int anoLancamentoInicio, int anoLancamentoFinal){
        ArrayList<Entretenimento> aux = new ArrayList<>();
        for (Entretenimento value : entretenimentos) {
            if(value.getAnoLancamento() > anoLancamentoInicio && value.getAnoLancamento() < anoLancamentoFinal){
                aux.add(value);
            }
        }

        if(aux.size()==0){
            return null;
        }
        return aux;
    }

    public Entretenimento buscaPorCodigo(String codigo){
        Entretenimento aux = null;
        for (Entretenimento value : entretenimentos) {
            if(value.getCodigo().equals(codigo)){
                aux = value;
                return aux;
            }
        }
        return null;
    }

    public String relatorioFinalEntretenimento(){
        String aux = "";
        for (Entretenimento value : entretenimentos) {
                aux+= "Cadastrado Entretenimento: " + value.toString() + "\n";
            }
        if(!aux.equals("")){
            return aux;
        } else{
            return null;
        }


    }

}


