package estruturacao;

import filmes.Filmes;

public class Ligacao
{
	// public int dado;
	public Filmes filme;
	public Ligacao proximo;
	public Ligacao anterior;

	public Ligacao(Filmes f)
	{
		filme = f;
	}

	public void linkExibicao()
	{
		System.out.print(filme.getTitulo());
		System.out.print(" - " + filme.getIdFilme());
		System.out.println();
	}
	
	public void swapNext() {
		if(this.proximo == null)
			return;
		Ligacao segundo = this.proximo;
		
		segundo.anterior = this.anterior;
		this.anterior = segundo;
		segundo.proximo = this;
		this.proximo = segundo.proximo;
	}
}