package mp06.uf01.p03.model.domain;

import java.io.Serializable;

public class Alumne implements Serializable {
	private int id;
	private String nom;
	private String cognom1;
	private String cognom2;
	private transient double notaAcces; // Exclòs de la serialització

	// Constructor per defecte
	public Alumne() {
	}

	// Constructor
	public Alumne(int id, String nom, String cognom1, String cognom2, double notaAcces) {
		this.id = id;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.notaAcces = notaAcces;
	}

	// Getters i setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public double getNotaAcces() {
		return notaAcces;
	}

	public void setNotaAcces(double notaAcces) {
		this.notaAcces = notaAcces;
	}

	@Override
	public String toString() {
		return "Alumne [id=" + id + ", nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2 + "]";
	}

}