package aplicacao;

import java.io.File;
import java.io.IOException;

import arquivo.ManipularArquivo;

public class Main
{

//	private static File file = new File("C:/Users/Daniel Santos/Desktop/tmdb_5000_movies.txt");
	private static File file = new File("C:/Users/Daniel Santos/Desktop/1filme.txt");
	
	public static void main(String[] args) 
	{
		ManipularArquivo arq = new ManipularArquivo();
		try {
			arq.carregarFilmes(file);		
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
	}
}
