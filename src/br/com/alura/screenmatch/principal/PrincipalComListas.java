package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(5);
        Filme meuFilmeSegundo = new Filme("Barbie", 2023);
        meuFilmeSegundo.avalia(8);
        var filmeDaClara = new Filme("Dogville", 2003);
        filmeDaClara.avalia(9);
        Serie serie = new Serie("Lost", 2000);

        //O ArrayList costuma ser chamado de List
        //Interface List

//        ArrayList<Titulo> lista = new ArrayList<>();
        List<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(meuFilmeSegundo);
        lista.add(filmeDaClara);
        lista.add(serie);


        //As listas são parametrizadas, de qual tipo eu estou falando, as vezes pode ser um super tipo, que engloba
        // mais de um como por exemplo o tipo titulo
        //Para cada variável item do tipo Titulo que está na lista
        //Como esse for cria uma variável do tipo Titulo não é possivel usar os metodos de outras classes, como a
        // classe filme que é filha, somente se fizer um casting
        //A forma mais comum de percorrer uma lista no java é utilizando o laço foreach tradicional. Esse laço
        // permite que se percorra todos os elementos de uma lista, sem a necessidade de se preocupar com índices ou
        // o tamanho dela

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificiação " + filme.getClassificacao());
            }
        }

        Filme f1 = filmeDaClara;

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacke");

        System.out.println(buscaPorArtista);

        /*Ordena a lista por ordem alfabetica
        Collections é como o Arraylist ele é tipo um pacote no java.util
        Mas não funciona com outro tipo que não seja a Classe String que já implementa esse método Collections.sort

        No caso usei a lista de tipo Titulo, porém no tipo titulo pode ser varias coisas, varios tipos, e essa cçasse
         não reconhece e exige que seja implementado na classe Titulo o Comparable do tipo Titulo. E nele reescrever
         o método de comparação, que é necessário para implementar a interface Comparable, que é o método compareTo.

         Titulo tem mil campos, como ordenar, o comparable é exigindo um critério de comparação a esse mar de coisas.
         Collections.sort so aceita lista de objetos que obrigatoriamente saibam se comparar um com o outro, é um
         contrato tipo interface.

         A Classe String implementa o comparable. Então é possível comparar strings Mas a classe Titulo não implementa .

         Commparable é uma interface

         Assinei o contrato para usar a interface comparable então tem que implementar o metodo compareTo




        */

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação" + buscaPorArtista);


        System.out.println("Lista de títulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);

        /* Comparator é uma interface chamando um metodo estatico .comparing e passando uma sinalização para
         tudo em titulo usar o ano de lançamento como criterio de comparação. */




            //Dessa forma estou dizendo que esse item do tipo titulo da lista, na verdade é um filme do tipo filme
            //Aqui estou perguntando se realmente é um filme atraves do instanceof, nao é o melhor metodo, mas as
            // vezes em sistemas legados acha. O melhor é evitar
            //Já perguntando e já dou esse filme

//            if (item instanceof Filme filme && filme.getClassificacao() > 2){
//                System.out.println("Classificiação" + filme.getClassificacao());
//            }

//            Filme filme = (Filme) item;
//            System.out.println("Clasfficiação" + filme.getClassificacao());

            //Porém deu erro pois eu garanti que oq viria era filme mas tem uma serie no meio e gerou esse erro, pois
            // filme não é do tipo Serie


       // lista.forEach(item -> System.out.println(item));

        //No parametro do forEach da lista, recebe uma expressão lambda, que é uma forma compactada de definir uma
        // função qu recebe um parametro x, no caso item e realiza a operação que nesse caso é de impressão

        //A forma mais reduza seria o Method Reference que é uma forma reduzida da expressão lambda

        //lista.forEach(System.out::println);

        //A sintaze :: do method reference

        //Objetos de classe em java são referencias
        //Variável referÊncia É OQ A GENTE USA PRA CHEGAR ATÉ UM OBJETO

        /* Referências são ponteiros para objetos em memória, ou seja, elas apontam para um objeto e permitem que
        você trabalhe com ele. No Java, toda variável de objeto é na verdade uma referência a esse objeto que foia
        locado na memória.

        Quando você instancia um objeto, na verdade está criando um novo bloco de memória que armazena ass
        informações desse objeto. A maneira de chegar a esse bloco de memória, para armazenar e ler informações dele,
         ocorre por meio de uma referência, que é representada por uma variável.

         As referêmcoas a objetos em Java não são o próprio objeto em si, pois elas apenas apontam para o objeto.
         Quando você passa uma referência a um método ou atribui uma referência a outra variável, está apenas
         copiando o valor da referência e não do objeto em si.

         Quando você compara duas ref de objeto usando o operador de igualdade ==, está comparando as ref em si, não
         os objetos que elas apontam.





        */


    }
}
