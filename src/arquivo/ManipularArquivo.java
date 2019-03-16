package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

import filmes.Filmes;

public class ManipularArquivo
{
	private BufferedReader br;

	public void carregarFilmes(File file) throws IOException
	{
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);

		if (file.exists())
		{
			while(br.ready())
			{
				String filme = br.readLine(); // Não quebra por vírgulas entre aspas
			//	if(filme.matches(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
			//	{
					Filmes movie = new Filmes();
					String auxFilme[] = filme.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

					for (int i = 0; i < auxFilme.length; i++)
					{
						System.out.println(i + " " + auxFilme[i]);
					}

					// Para o campo de generos
					auxFilme[1] = auxFilme[1].replaceAll("\"\\]", "]");
					auxFilme[1] = auxFilme[1].replaceAll("\"\\[", "[");
					auxFilme[1] = auxFilme[1].replaceAll("\"\"", "\"");
					JSONArray json = new JSONArray(auxFilme[1]); // JSon para generos do filme
					for(int i = 0; i < json.length(); i++)
					{
						JSONObject obj = json.getJSONObject(i);
						movie.setGeneros(movie.getGeneros() + obj.getString("name") + "; "); // auxFilme[1]
					}

					// Para as palavras-chave
					auxFilme[4] = auxFilme[4].replaceAll("\"\\]", "]");
					auxFilme[4] = auxFilme[4].replaceAll("\"\\[", "[");
					auxFilme[4] = auxFilme[4].replaceAll("\"\"", "\"");
					JSONArray json1 = new JSONArray(auxFilme[4]); // Json para as palavras-chave
					for(int i = 0; i < json1.length(); i++)
					{
						JSONObject obj = json1.getJSONObject(i);
						movie.setPalavrasChave(movie.getPalavrasChave() + obj.getString("name") + "; "); // auxFilme[4]
					}

					// Para as empresas de produção
					auxFilme[9] = auxFilme[9].replaceAll("\"\\]", "]");
					auxFilme[9] = auxFilme[9].replaceAll("\"\\[", "[");
					auxFilme[9] = auxFilme[9].replaceAll("\"\"", "\"");
					JSONArray json2 = new JSONArray(auxFilme[9]); // Json para as empresas
					for(int i = 0; i < json2.length(); i++)
					{
						JSONObject obj = json2.getJSONObject(i);
						movie.setProdutora(movie.getProdutora() + obj.getString("name") + "; "); // auxFilme[9]
					}

					// Para os países de produção
					auxFilme[10] = auxFilme[10].replaceAll("\"\\]", "]");
					auxFilme[10] = auxFilme[10].replaceAll("\"\\[", "[");
					auxFilme[10] = auxFilme[10].replaceAll("\"\"", "\"");
					JSONArray json3 = new JSONArray(auxFilme[10]); // Json para as empresas
					for(int i = 0; i < json3.length(); i++)
					{
						JSONObject obj = json3.getJSONObject(i);
						movie.setPaisProducao(movie.getPaisProducao() + obj.getString("name") + "; "); // auxFilme[10]
					}

					// Para os idiomas falados
					auxFilme[14] = auxFilme[14].replaceAll("\"\\]", "]");
					auxFilme[14] = auxFilme[14].replaceAll("\"\\[", "[");
					auxFilme[14] = auxFilme[14].replaceAll("\"\"", "\"");
					JSONArray json4 = new JSONArray(auxFilme[14]); // Json para as empresas
					for(int i = 0; i < json4.length(); i++)
					{
						JSONObject obj = json4.getJSONObject(i);
						movie.setIdiomaFalado(movie.getIdiomaFalado() + obj.getString("name") + "; "); // auxFilme[14]
					}

					System.out.println("-------------------");

					movie.setOrcamento(auxFilme[0]);
					//movie.setGeneros(auxFilme[1]);
					movie.setPaginaSite(auxFilme[2]);
					movie.setIdFilme(auxFilme[3]);
					//movie.setGeneros(auxFilme[4]);
					movie.setLinguaOrigianl(auxFilme[5]);
					movie.setTituloOriginal(auxFilme[6]);
					movie.setSinopse(auxFilme[7]);
					movie.setPopularidade(auxFilme[8]);
					//movie.setProdutora(auxFilme[9]);
					//movie.setPaisProducao(auxFilme[10]);
					movie.setDataLancamento(auxFilme[11]);
					movie.setReceita(auxFilme[12]);
					movie.setTempoFilme(auxFilme[13] + " min");
					//movie.setIdiomaFalado(auxFilme[14]);
					movie.setStatus(auxFilme[15]);
					movie.setSloganFilme(auxFilme[16]);
					movie.setTitulo(auxFilme[17]);
					movie.setMediaVotos(auxFilme[18]);
					movie.setContagemVotos(auxFilme[19]);

					System.out.println(movie.getOrcamento());
					System.out.println(movie.getGeneros());
					System.out.println(movie.getPaginaSite());
					System.out.println(movie.getIdFilme());
					System.out.println(movie.getPalavrasChave());
					System.out.println(movie.getLinguaOrigianl());
					System.out.println(movie.getTituloOriginal());
					System.out.println(movie.getSinopse());
					System.out.println(movie.getPopularidade());
					System.out.println(movie.getProdutora());
					System.out.println(movie.getPaisProducao());
					System.out.println(movie.getDataLancamento());
					System.out.println(movie.getReceita());
					System.out.println(movie.getTempoFilme());
					System.out.println(movie.getIdiomaFalado());
					System.out.println(movie.getStatus());
					System.out.println(movie.getSloganFilme());
					System.out.println(movie.getTitulo());
					System.out.println(movie.getMediaVotos());
					System.out.println(movie.getContagemVotos());
			//	}
			//	else
				//{
				//	System.out.println("Não encontrei o padrão");
				//	break;
				//}
			}
		}
		else
		{
			System.out.println("Arquivo não encontrado!!");
		}
	}
}
