package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {


    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracacaoEmMinutos;

    //Se eu preciso do contrutor para título tanto em série como em filme, faz mais sentido criar um construtor em
    // título passando os valores que eu quero. Porém as classes filhas não herdam essa reescrita do construtor.
    // entao nas classes filhas é necessário passar o construtor com referência a classe mãe ou super.

    //Construtor sao usados para popular um objeto trazendo informações vitais para um objeto. O construtor é mais um
    // recurso para encapsular objetos.

    //Um construtor é um método especial para criar a inicializar um objeto. Uma classe pode ter mais de um
    // construtor, se nao for definida o java cria um default automatico, que não possui parametro e nao executa
    // nenhuma instrução.
    //Nas classes filhas é necessário chaar o construtor da classe mãe, através do super para não gerar erro de
    // compilação.


    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracacaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 3));
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracacaoEmMinutos() {
        return duracacaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracacaoEmMinutos(int duracacaoEmMinutos) {
        this.duracacaoEmMinutos = duracacaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Título: " + nome);
        System.out.println("Lançado em: " + anoDeLancamento);
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", duração=" + duracacaoEmMinutos +
                '}'
                ;
    }

    public void avalia (double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){

        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    //Aqui estou comparando esse titulo com outrotitulo, então pega esse nome e compare outro nome
    //Quero esse nome comparado com outro titulo
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}
