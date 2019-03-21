package estruturacao;

public class BubbleSort
{
	private int comparacoes;
	private int trocas;
	
	public int getComparacoes()
	{
		return this.comparacoes;
	}

	public void setComparacoes(int comparacoes)
	{
		this.comparacoes = comparacoes;
	}
	
	public int getTrocas()
	{
		return trocas;
	}

	public void setTrocas(int trocas)
	{
		this.trocas = trocas;
	}

	
	public void bubbleSort(Ligacao auxBolha[])
	{
		int out, in;
		int comp = 1, mov = 0;
		for (out = auxBolha.length-1; out > 0; out--)
		{
			for (in = 0; in < out; in++)
			{
				this.setComparacoes(comp++);
				if (auxBolha[in].filme.getTitulo().compareTo(auxBolha[in+1].filme.getTitulo()) > 0)
				{
					Ligacao temp = auxBolha[in];
					auxBolha[in] = auxBolha[in+1];
					auxBolha[in+1] = temp;
					this.setTrocas(mov++);
				}
			}
		}
	}
}
