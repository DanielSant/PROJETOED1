package aplicacao;

import java.io.File;
import java.io.IOException;

import arquivo.ManipularArquivo;
import estruturacao.Ligacao;
import estruturacao.Metodos;
import filmes.Filmes;

public class Main
{

	private static File file = new File("D-IMDB delimitador barra t.txt");
	
	public static void main(String[] args) 
	{
		ManipularArquivo arq = new ManipularArquivo();
		Metodos listaDupEncad = new Metodos();
		Filmes chave = new Filmes();
		chave.setTitulo("Primer");
		Ligacao equal = new Ligacao(chave);
		try {
			listaDupEncad = arq.carregarFilmes(file);		
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		listaDupEncad.imprimeOrdem();
		listaDupEncad.pesquisa(equal);
	}
}
