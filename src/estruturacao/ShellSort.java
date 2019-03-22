package estruturacao;

public class ShellSort
{
	private int comparacoes;
	private int trocas;

	public int getTrocas()
	{
		return trocas;
	}

	public void setTrocas(int trocas)
	{
		this.trocas = trocas;
	}

	public int getComparacoes()
	{
		return comparacoes;
	}

	public void setComparacoes(int comparacoes)
	{
		this.comparacoes = comparacoes;
	}

	public void shellSort(Ligacao concha[])
	{
		int inner, outer;
		int nElems = concha.length;
		int comp = 0, trocas = 0;

		Ligacao temp;

		int h = 1; // determina o valor inicial de h
		while (h <= nElems / 3)
			h = h * 3 + 1; // (1,4,13,40,121,...), atualizando o valor de h para o tamanho do vetor
		while (h > 0) // diminuindo h, até h=1
		{
			for (outer = h; outer < concha.length; outer++)
			{
				temp = concha[outer]; // pega o valor do indice
				inner = outer; // pega o indice
				while ((inner > h - 1)
						&& ((concha[inner - h].filme.getTitulo()).compareTo(temp.filme.getTitulo()) >= 0))
				{
					concha[inner] = concha[inner - h];
					inner -= h;
					this.setTrocas(trocas++);
				}
				this.setComparacoes(comp++);
				concha[inner] = temp;
			}
			h = (h - 1) / 3; // diminui h
		}
	}
}