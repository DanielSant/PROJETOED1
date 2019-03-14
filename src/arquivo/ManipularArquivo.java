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
				Filmes movie = new Filmes();
				String filme = br.readLine(); // Não quebra por vírgulas entre aspas
				String auxFilme[] = filme.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				
//				for(int i = 0; i < auxFilme.length; i++)
				auxFilme[1] = auxFilme[1].replaceAll("\"\\]", "]");
				auxFilme[1] = auxFilme[1].replaceAll("\"\\[", "[");
				auxFilme[1] = auxFilme[1].replaceAll("\"\"", "\"");
							
				JSONArray json = new JSONArray(auxFilme[1]);
				JSONObject obj = json.getJSONObject(0);
				
				System.out.println(obj.getString("name"));
				
				System.out.println(auxFilme[1]);
			}
		}
		else
		{
			System.out.println("Arquivo não encontrado!!");
		}
	}
}
