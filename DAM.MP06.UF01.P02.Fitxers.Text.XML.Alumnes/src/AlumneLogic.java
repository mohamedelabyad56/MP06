import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

public class AlumneLogic {

    // 1. Serialitzar un Alumne a XML
    public void serializeAlumne(Alumne alumne, String filename) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(alumne);
            System.out.println("Alumne serialitzat a XML: " + filename);
        } catch (IOException e) {
            System.err.println("Error en serialitzar Alumne: " + e.getMessage());
        }
    }

    // 2. Deserialitzar un Alumne des d'XML
    public Alumne deserializeAlumne(String filename) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            return (Alumne) decoder.readObject();
        } catch (IOException e) {
            System.err.println("Error en deserialitzar Alumne: " + e.getMessage());
            return null;
        }
    }

    // 3. Serialitzar una llista d'Alumnes a XML
    public void serializeAlumnes(List<Alumne> alumnes, String filename) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(alumnes);
            System.out.println("Llista d'Alumnes serialitzada a XML: " + filename);
        } catch (IOException e) {
            System.err.println("Error en serialitzar llista d'Alumnes: " + e.getMessage());
        }
    }

    // 4. Deserialitzar una llista d'Alumnes des d'XML
    public List<Alumne> deserializeAlumnes(String filename) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            return (List<Alumne>) decoder.readObject();
        } catch (IOException e) {
            System.err.println("Error en deserialitzar llista d'Alumnes: " + e.getMessage());
            return null;
        }
    }
}
