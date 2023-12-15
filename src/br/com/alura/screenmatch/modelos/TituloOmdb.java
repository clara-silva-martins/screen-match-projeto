package br.com.alura.screenmatch.modelos;

public record TituloOmdb(String title, String year, String runtime) {
}

/*O Record usado aqui é um recurso que permite respresentar uma classe imutável, contendo apenas atributos,
construtor e métodos de leitura, de uma maneira muito simples e enxuta.
Esse recurso se encaixa perfeitamente quando precisamos criar um objeto apenas para representar dados , sem nenhum
tipo de comportamente.
*/