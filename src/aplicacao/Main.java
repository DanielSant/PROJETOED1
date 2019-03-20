package aplicacao;

import java.io.File;
import java.io.IOException;

import arquivo.ManipularArquivo;
import estruturacao.Ligacao;
import estruturacao.ListaDupEncad;
import filmes.Filmes;

public class Main
{

	private static File file = new File("D-IMDB delimitador barra t.txt");
	
	public static void main(String[] args) 
	{
		ManipularArquivo arq = new ManipularArquivo();
		ListaDupEncad listaDesordenada = new ListaDupEncad();
		Filmes chave = new Filmes();
		chave.setTitulo("Primer");
		Ligacao equal = new Ligacao(chave);
		try {
			listaDesordenada = arq.carregarFilmes(file);		
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		
		//ListaDupEncad listaOrdenada = 
		listaDesordenada.imprimeOrdem();
		listaDesordenada.pesquisa(equal);
		System.out.println(listaDesordenada.getTotalFilmes());
	}
}
