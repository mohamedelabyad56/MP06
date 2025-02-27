package mp06.uf01.p03.model.repository;

import java.io.FileNotFoundException;

import mp06.uf01.p03.model.domain.Alumne;

public class AlumneSerialitzacioRepository {

	private CommonXmlSerializeRepository csr = CommonXmlSerializeRepository.getInstance();

	public void serialitzaUnAlume(Alumne alumne, String nomFitxer) throws FileNotFoundException {
		csr.serialitza(nomFitxer, alumne);
	}

	public Alumne deserialitzaUnAlumne(String nomFitxer) throws FileNotFoundException {
		Alumne result = null;
		Object object = csr.deserialitza(nomFitxer);

		if (object != null && object instanceof Alumne) {
			result = (Alumne) object;
		}

		return result;

	}

}
