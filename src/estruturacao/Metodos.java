package estruturacao;

import filmes.Filmes;

public class Metodos
{
	private Ligacao primeiro;
	private Ligacao ultimo;

	public Metodos()
	{
		primeiro = null;
		ultimo = null;
	}

	public boolean vazia()
	{
		return primeiro == null;
	}

	public void insereInicio(Filmes chave)
	{
		Ligacao novaLigacao = new Ligacao(chave);

		if (vazia())
			ultimo = novaLigacao;
		else
			primeiro.anterior = novaLigacao;
		novaLigacao.proximo = primeiro;
		primeiro = novaLigacao;
	}

	public void insereFinal(Filmes chave)
	{
		Ligacao novaLigacao = new Ligacao(chave);
		if (vazia())
		{
			primeiro = novaLigacao;
		} else
		{
			ultimo.proximo = novaLigacao;
			novaLigacao.anterior = ultimo;
		}
		ultimo = novaLigacao;
	}

	public Ligacao removeInicio()
	{
		Ligacao temp = primeiro;
		if (primeiro.proximo == null)
			ultimo = null;
		else
			primeiro.proximo.anterior = null;
		primeiro = primeiro.proximo;
		return temp;
	}

	public Ligacao removeFinal()
	{
		Ligacao temp = ultimo;
		if (primeiro.proximo == null)
			primeiro = null;
		else
			ultimo.anterior.proximo = null;
		ultimo = ultimo.anterior;
		return temp;

	}

	public boolean inserePosicao(Filmes chave, Filmes dd)
	{
		Ligacao atual = primeiro;
		while (atual.filme != chave)
		{
			atual = atual.proximo;
			if (atual == null)
				return false;
		}
		Ligacao newLigacao = new Ligacao(dd);
		if (atual == ultimo)
		{
			newLigacao.proximo = null;
			ultimo = newLigacao;
		} else
		{
			newLigacao.proximo = null;
			atual.proximo.anterior = newLigacao;
		}
		newLigacao.anterior = atual;
		atual.proximo = newLigacao;
		return true;
	}

	public void pesquisa(Ligacao chave)
	{
		Ligacao atual = primeiro;
		while (atual != null)
		{
			if (atual.filme.getTitulo().equals(chave.filme.getTitulo()))
				System.out.println(atual.filme.getIdFilme());
				//return null;
			atual = atual.proximo;
		}
		/*if (atual == primeiro)
			primeiro = atual.proximo;
		else
			atual.proximo.anterior = atual.anterior;*/
		//return atual;
	}

	public void imprimeContrario()
	{ // imprime de tras pra frente
		System.out.print("List (ultimo->primeiro): ");
		Ligacao atual = ultimo;
		while (atual != null)
		{
			atual.linkExibicao();
			atual = atual.anterior;
		}
		System.out.println("");
	}

	public void imprimeOrdem()
	{ // imprime do primeiro ao ultimo
		System.out.print("List (primeiro->ultimo): ");
		int i = 1;
		Ligacao atual = primeiro;
		while (atual != null)
		{
			System.out.print(i + " - ");
			atual.linkExibicao();
			atual = atual.proximo;
			i++;
		}
		System.out.println("");
	}
}
