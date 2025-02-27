import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String FITXER_INDIVIDUAL = "Fitxers/alumne.xml";
	private static final String FITXER_LLISTA = "Fitxers/alumnes.xml";
    public static void main(String[] args) {
        // Crear objectes Alumne
        Alumne alumne1 = new Alumne(1, "Joan", "Garcia", "Martí", 8.5);
        Alumne alumne2 = new Alumne(2, "Anna", "López", "González", 9.2);

        // Crear una llista d'Alumnes
        List<Alumne> alumnes = new ArrayList<>();
        alumnes.add(alumne1);
        alumnes.add(alumne2);

        // Instanciar la lògica
        AlumneLogic logic = new AlumneLogic();

        // 1. Serialitzar i gravar un Alumne a XML
        logic.serializeAlumne(alumne1, FITXER_INDIVIDUAL);

        // 2. Serialitzar i gravar una llista d'Alumnes a XML
        logic.serializeAlumnes(alumnes, FITXER_LLISTA);

        // 3. Llegir i deserialitzar un Alumne des d'XML
        Alumne deserializedAlumne = logic.deserializeAlumne(FITXER_INDIVIDUAL);
        System.out.println("\nAlumne deserialitzat des de fitxer XML:");
        System.out.println(deserializedAlumne);

        // 4. Llegir i deserialitzar una llista d'Alumnes des d'XML
        List<Alumne> deserializedAlumnes = logic.deserializeAlumnes(FITXER_LLISTA);
        System.out.println("\nLlista d'Alumnes deserialitzada des de fitxer XML:");
        for (Alumne alumne : deserializedAlumnes) {
            System.out.println(alumne);
        }
    }
}