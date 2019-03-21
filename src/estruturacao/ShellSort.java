package estruturacao;

public class ShellSort {
	
	public void shellSort(Ligacao concha[]) {
		int inner, outer;
		int nElems = concha.length;
		Ligacao temp;
		
		int h = 1; //determina o valor inicial de h
		while(h <= nElems/3)
			h = h*3 + 1; //(1,4,13,40,121,...), atualizando o valor de h para o tamanho do vetor
		while(h>0)	//diminuindo h, até h=1
		{
			
			for(outer=h; outer<concha.length; outer++) 
			{
				temp = concha[outer]; //pega o valor do indice
				inner = outer; //pega o indice
				while((inner > h-1) && ((concha[inner-h].filme.getTitulo()).compareTo(temp.filme.getTitulo()) >= 0)) 
				{
					concha[inner] = concha[inner-h];
					inner -= h;
					
				}
				concha[inner] = temp;
		    
			}
		h=(h-1)/3; //diminui h
		}
	}
}