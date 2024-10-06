package br.com.plinio.onivehicle.onivehicle;

import br.com.plinio.onivehicle.onivehicle.model.Vehicle;
import br.com.plinio.onivehicle.onivehicle.service.AccentsRemover;
import br.com.plinio.onivehicle.onivehicle.service.Deserializer;
import br.com.plinio.onivehicle.onivehicle.service.HttpGetRequest;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		String json;
		Map<String, Object> map;

		System.out.println("""
				
				OPÇÕES:
				1. CARROS
				2. MOTOS
				3. CAMINHÕES""");

		String chosenOption = userInput.nextLine().toLowerCase();
		String chosenOptionFormated = textCleaner.RemoveAccents((chosenOption));

		System.out.println("Escolha do usuário: " + chosenOptionFormated);

		if(Objects.equals(chosenOptionFormated, "carros") || Objects.equals(chosenOptionFormated, "motos")
				|| Objects.equals(chosenOptionFormated, "caminhoes")){

			json = getVehicleData.getData(chosenOptionFormated);
			try{
				System.out.println(json);
				System.out.println("Teste Gson deserializer");
				System.out.println(gson.fromJson(json, Collection.class));
				gson.fromJson(json, Collection.class);
						//.stream()
						//.forEach(e -> System.out.println(e.toString()));

			} catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
	}
}
