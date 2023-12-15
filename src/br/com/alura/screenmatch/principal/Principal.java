package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacoes;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.setDuracacaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracacaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie serie = new Serie("Lost", 2000);
        serie.exibeFichaTecnica();
        serie.setTemporadas(10);
        serie.setEpisodiosPorTemporadas(10);
        serie.setMinutosPorEpisodio(50);
        System.out.println("Duração total da série: " + serie.getDuracacaoEmMinutos());

        Filme meuFilmeSegundo = new Filme("Barbie", 2023);
        meuFilmeSegundo.setDuracacaoEmMinutos(132);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(meuFilmeSegundo);
        calculadora.inclui(serie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacoes filtro = new FiltroRecomendacoes();
        filtro.filtrar(meuFilmeSegundo);

        Episodio episodio = new Episodio();
        episodio.setSerie(serie);
        episodio.setNumero(5);
        episodio.setTotalVisualizacoes(300);
        filtro.filtrar(episodio);

        //Contrutor: método que tem como função a criação de um objeto em memória

        //o new cria um objeto na memória e invoca um construtor, que não faz nada mas pode ser reescrito

        var filmeDaClara = new Filme("Dogville", 2003);
        filmeDaClara.setDuracacaoEmMinutos(200);
        filmeDaClara.setAnoDeLancamento(2003);
        filmeDaClara.avalia(10);

        //Arraylist

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDaClara);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(meuFilmeSegundo);
        System.out.println("Tamnho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do " + listaDeFilmes.get(0).toString());

        //Mostrar um objeto em texto com toString












    }
}