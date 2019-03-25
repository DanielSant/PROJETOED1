package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import estruturacao.ListaDupEncad;
import filmes.Filmes;

public class ManipularArquivo
{
	private BufferedReader br;

	public ListaDupEncad carregarFilmes(File file) throws IOException
	{
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);
		String filme = null;
		ListaDupEncad lista = new ListaDupEncad();

		if (file.exists()) 
		{
			int tot = 1;
			while ((filme = br.readLine()) != null && tot < 4801)
			{
				Filmes movie = new Filmes();
				String auxFilme[] = filme.split("\t");

				try
				{
					JSONArray json = new JSONArray(auxFilme[1]); // JSon para generos do filme
					for (int i = 0; i < json.length(); i++)
					{
						JSONObject obj = json.getJSONObject(i);
						movie.setGeneros(movie.getGeneros() + obj.getString("name") + "; "); // auxFilme[1]
					}
				} catch (JSONException e)
				{
					movie.setGeneros("default");
				} catch (ArrayIndexOutOfBoundsException e)
				{
					movie.setGeneros("default");
				}

				try
				{
					JSONArray json1 = new JSONArray(auxFilme[4]); // Json para as palavras-chave
					for (int i = 0; i < json1.length(); i++)
					{
						JSONObject obj = json1.getJSONObject(i);
						movie.setPalavrasChave(movie.getPalavrasChave() + obj.getString("name") + "; "); // auxFilme[4]
					}
				} catch (JSONException e)
				{
					movie.setPalavrasChave("default");
				} catch (ArrayIndexOutOfBoundsException e)
				{
					movie.setPalavrasChave("default");
				}

				// Para as empresas de produção
				try
				{
					JSONArray json2 = new JSONArray(auxFilme[9]); // Json para as empresas
					for (int i = 0; i < json2.length(); i++)
					{
						JSONObject obj = json2.getJSONObject(i);
						movie.setProdutora(movie.getProdutora() + obj.getString("name") + "; "); // auxFilme[9]
					}
				} catch (JSONException e)
				{
					movie.setProdutora("default");
				} catch (ArrayIndexOutOfBoundsException f)
				{
					movie.setProdutora("default");
				}

				try
				{
					JSONArray json3 = new JSONArray(auxFilme[10]); // Json para as empresas
					for (int i = 0; i < json3.length(); i++)
					{
						JSONObject obj = json3.getJSONObject(i);
						movie.setPaisProducao(movie.getPaisProducao() + obj.getString("name") + "; "); // auxFilme[10]
					}
				} catch (ArrayIndexOutOfBoundsException e)
				{
					movie.setPaisProducao("default");
				} catch (JSONException e)
				{
					movie.setPaisProducao("default");
				}

				try
				{
					JSONArray json4 = new JSONArray(auxFilme[14]); // Json para as empresas
					for (int i = 0; i < json4.length(); i++)
					{
						JSONObject obj = json4.getJSONObject(i);
						movie.setIdiomaFalado(movie.getIdiomaFalado() + obj.getString("name") + "; "); // auxFilme[14]
					}
				} catch (JSONException e)
				{
					movie.setIdiomaFalado("default");
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					movie.setIdiomaFalado("default");
				}

				try
				{
					movie.setOrcamento(auxFilme[0]);
					movie.setPaginaSite(auxFilme[2]);
					movie.setIdFilme(auxFilme[3]);
					movie.setLinguaOrigianl(auxFilme[5]);
					movie.setTituloOriginal(auxFilme[6]);
					movie.setSinopse(auxFilme[7]);
					movie.setPopularidade(auxFilme[8]);
					movie.setDataLancamento(auxFilme[11]);
					movie.setReceita(auxFilme[12]);
					movie.setTempoFilme(auxFilme[13] + " min");
					movie.setStatus(auxFilme[15]);
					movie.setSloganFilme(auxFilme[16]);
					movie.setTitulo(auxFilme[17]);
					movie.setMediaVotos(auxFilme[18]);
					movie.setContagemVotos(auxFilme[19]);
					lista.insereFinal(movie);
					lista.setTotalFilmes(tot);
					tot++;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					lista.insereFinal(movie);
					continue;
				}
			}
		} else
		{
			System.out.println("Arquivo não encontrado!!");
		}
		return lista;
	}
	
	public void carregarFilmes(File file, Filmes vetor[]) throws IOException
	{
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);
		String filme = null;

		if (file.exists()) 
		{
			int tot = 1;
			while ((filme = br.readLine()) != null && tot < 4801)
			{
				Filmes movie = new Filmes();
				String auxFilme[] = filme.split("\t");

				try
				{
					JSONArray json = new JSONArray(auxFilme[1]); // JSon para generos do filme
					for (int i = 0; i < json.length(); i++)
					{
						JSONObject obj = json.getJSONObject(i);
						movie.setGeneros(movie.getGeneros() + obj.getString("name") + "; "); // auxFilme[1]
					}
				} catch (JSONException e)
				{
					movie.setGeneros("default");
				} catch (ArrayIndexOutOfBoundsException e)
				{
					movie.setGeneros("default");
				}

				try
				{
					JSONArray json1 = new JSONArray(auxFilme[4]); // Json para as palavras-chave
					for (int i = 0; i < json1.length(); i++)
					{
						JSONObject obj = json1.getJSONObject(i);
						movie.setPalavrasChave(movie.getPalavrasChave() + obj.getString("name") + "; "); // auxFilme[4]
					}
				} catch (JSONException e)
				{
					movie.setPalavrasChave("default");
				} catch (ArrayIndexOutOfBoundsException e)
				{
					movie.setPalavrasChave("default");
				}

				// Para as empresas de produção
				try
				{
					JSONArray json2 = new JSONArray(auxFilme[9]); // Json para as empresas
					for (int i = 0; i < json2.length(); i++)
					{
						JSONObject obj = json2.getJSONObject(i);
						movie.setProdutora(movie.getProdutora() + obj.getString("name") + "; "); // auxFilme[9]
					}
				} catch (JSONException e)
				{
					movie.setProdutora("default");
				} catch (ArrayIndexOutOfBoundsException f)
				{
					movie.setProdutora("default");
				}

				try
				{
					JSONArray json3 = new JSONArray(auxFilme[10]); // Json para as empresas
					for (int i = 0; i < json3.length(); i++)
					{
						JSONObject obj = json3.getJSONObject(i);
						movie.setPaisProducao(movie.getPaisProducao() + obj.getString("name") + "; "); // auxFilme[10]
					}
				} catch (ArrayIndexOutOfBoundsException e)
				{
					movie.setPaisProducao("default");
				} catch (JSONException e)
				{
					movie.setPaisProducao("default");
				}

				try
				{
					JSONArray json4 = new JSONArray(auxFilme[14]); // Json para as empresas
					for (int i = 0; i < json4.length(); i++)
					{
						JSONObject obj = json4.getJSONObject(i);
						movie.setIdiomaFalado(movie.getIdiomaFalado() + obj.getString("name") + "; "); // auxFilme[14]
					}
				} catch (JSONException e)
				{
					movie.setIdiomaFalado("default");
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					movie.setIdiomaFalado("default");
				}

				try
				{
					movie.setOrcamento(auxFilme[0]);
					movie.setPaginaSite(auxFilme[2]);
					movie.setIdFilme(auxFilme[3]);
					movie.setLinguaOrigianl(auxFilme[5]);
					movie.setTituloOriginal(auxFilme[6]);
					movie.setSinopse(auxFilme[7]);
					movie.setPopularidade(auxFilme[8]);
					movie.setDataLancamento(auxFilme[11]);
					movie.setReceita(auxFilme[12]);
					movie.setTempoFilme(auxFilme[13] + " min");
					movie.setStatus(auxFilme[15]);
					movie.setSloganFilme(auxFilme[16]);
					movie.setTitulo(auxFilme[17]);
					movie.setMediaVotos(auxFilme[18]);
					movie.setContagemVotos(auxFilme[19]);
					movie.setTotalFilmes(tot);
					vetor[tot-1] = movie;
					tot++;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					vetor[tot-1] = movie;
					continue;
				}
			}
		} else
		{
			System.out.println("Arquivo não encontrado!!");
		}
	}
}
