package model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery (name = Kategorija.GET_ALL, query = "Select k from Kategorija k")})
public class Kategorija {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String naziv;
	private String opis;
	@ManyToMany(mappedBy = "kategorije")
	private Set<Zaposleni> zaposleni;
	
	public static final String GET_ALL = "Kategorija.getAll";
	
	
	public Kategorija() {
		super();
	}

	public Kategorija(Long id, String naziv, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", naziv=" + naziv + ", opis=" + opis + "]";
	}
	
	
	
	
}
