package mp06.uf01.p03.model.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CommonTextFileRepository {

	private CommonTextFileRepository() {

	}

	public static CommonTextFileRepository getInstance() {
		if (instance == null) {
			instance = new CommonTextFileRepository();
		}

		return instance;

	}

	private static CommonTextFileRepository instance = null;

	public void writeToFile(String filename, String contingut) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write(contingut);
			System.out.println("S'ha gravat correctament al fitxer: " + filename);
		} catch (IOException e) {
			System.err.println("Error en escriure al fitxer: " + e.getMessage());
		}
	}

	public String readFromFile(String filename) {
		StringBuilder contingut = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				contingut.append(line);
			}
		} catch (IOException e) {
			System.err.println("Error en llegir el fitxer: " + e.getMessage());
		}
		return contingut.toString();
	}
}
