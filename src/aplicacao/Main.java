package aplicacao;

import java.io.File;
import java.io.IOException;
import arquivo.ManipularArquivo;
import estruturacao.BubbleSort;
import estruturacao.Ligacao;
import estruturacao.ListaDupEncad;
import estruturacao.ShellSort;
//import filmes.Filmes;

public class Main
{

	private static File file = new File("D-IMDB delimitador barra t.txt");
	
	public static void main(String[] args) 
	{
		ManipularArquivo arq = new ManipularArquivo();
		ListaDupEncad listaDesordenada = new ListaDupEncad();
		BubbleSort bubbleordena = new BubbleSort();
		ShellSort shellOrdena = new ShellSort();

		try {
			listaDesordenada = arq.carregarFilmes(file);		
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		
		Ligacao auxConcha[] = new Ligacao[listaDesordenada.getTotalFilmes()];
		Ligacao atual = listaDesordenada.getPrimeiro();
		int i = 0;
		while (atual != null && i < listaDesordenada.getTotalFilmes())
		{
			auxConcha[i] = atual;
			atual = atual.proximo;
			i++;
		}
		shellOrdena.shellSort(auxConcha);
		
		System.out.println("Concha-------------------");
		for (int j = 0; j < auxConcha.length; j++)
		{
			System.out.println(auxConcha[j].filme.getTitulo());
		}
		System.out.println("----------------------------------");
		
		Ligacao auxBolha[] = new Ligacao[listaDesordenada.getTotalFilmes()];
		Ligacao atual2 = listaDesordenada.getPrimeiro();
		int i2 = 0;
		while (atual2 != null && i2 < listaDesordenada.getTotalFilmes())
		{
			auxBolha[i2] = atual2;
			atual2 = atual2.proximo;
			i2++;
		}
		bubbleordena.bubbleSort(auxBolha);
		System.out.println("Bolha-------------");
		for (int j = 0; j < auxBolha.length; j++)
		{
			System.out.println(auxBolha[j].filme.getTitulo());
		}
		System.out.println("Comparacoes------------");
		System.out.println(bubbleordena.getComparacoes());
		System.out.println("Movimentacoes------------");
		System.out.println(bubbleordena.getTrocas());
	}
}
