package br.com.plinio.onivehicle.onivehicle;

import br.com.plinio.onivehicle.onivehicle.model.Vehicle;
import br.com.plinio.onivehicle.onivehicle.service.AccentsRemover;
import br.com.plinio.onivehicle.onivehicle.service.Deserializer;
import br.com.plinio.onivehicle.onivehicle.service.HttpGetRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;
import java.util.*;

@SpringBootApplication
public class OnivehicleApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(OnivehicleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner userInput = new Scanner(System.in);
		AccentsRemover textCleaner = new AccentsRemover();
		HttpGetRequest getVehicleData = new HttpGetRequest();
		Deserializer deserializer = new Deserializer();
		Gson gson = new Gson();
		Type listMap = new TypeToken<List<Map<String, String>>>() {}.getType();

		String json;
		Map<String, Object> map;

		System.out.println("""
			\t
			OPÇÕES:
			1. CARROS
			2. MOTOS
			3. CAMINHÕES
			\t
			Por favor, digite a opção desejada:\s""");

		String chosenOption = userInput.nextLine().toLowerCase();
		String chosenOptionFormated = textCleaner.RemoveAccents((chosenOption));

		System.out.println("Escolha do usuário: " + chosenOptionFormated);

		if(Objects.equals(chosenOptionFormated, "carros") || Objects.equals(chosenOptionFormated, "motos")
				|| Objects.equals(chosenOptionFormated, "caminhoes")){

			//agora é necessário primeiro passar as informações através de setters e depois chamar a função pois a função
			//irá utilizar as informações guardadas nas variáveis;
			json = getVehicleData.getVehicleData(chosenOptionFormated);
			try{
				System.out.println(json);
				System.out.println("Teste Gson deserializer");
				System.out.println(gson.fromJson(json, Collection.class));
				List<Map<String, String>> listOfMapJson = (gson.fromJson(json, listMap));
				System.out.println(listOfMapJson);
				listOfMapJson.stream()
						.forEach(e -> System.out.println(e.get("nome") + " " + "( " + e.get("codigo") + " )"));
			} catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
	}
}
