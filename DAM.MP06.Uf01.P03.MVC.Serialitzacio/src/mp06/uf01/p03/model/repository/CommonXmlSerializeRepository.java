package mp06.uf01.p03.model.repository;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CommonXmlSerializeRepository {

	
	private CommonXmlSerializeRepository()
	{
		
	}
	
	public static CommonXmlSerializeRepository getInstance()
	{
		if (instance == null)
		{
			instance = new CommonXmlSerializeRepository();
		}
		
		return instance;
	}
	
	private static CommonXmlSerializeRepository instance = null;
		
	public void serialitza(String nomFitxer, Object contingut) throws FileNotFoundException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(nomFitxer);
		XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
		xmlEncoder.writeObject(contingut);
		xmlEncoder.close();
		
	}
	
	public Object deserialitza(String nomFitxer) throws FileNotFoundException
	{
		Object contingut =  null;
		FileInputStream fileInputStream = new FileInputStream(nomFitxer);
		XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
		contingut = xmlDecoder.readObject();
		xmlDecoder.close();
		return contingut;
	}
	
}
