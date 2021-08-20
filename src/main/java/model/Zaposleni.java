package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = Zaposleni.GET_ALL, query = "Select z from Zaposleni z"),
		@NamedQuery(name = Zaposleni.DELETE_ZAPOSLENI, query = "Delete from Zaposleni z where z.id = :id") })
public class Zaposleni implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public static final String GET_ALL = "Zaposleni.getAll";
	public static final String DELETE_ZAPOSLENI = "Zaposleni.delete";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String ime;
	private String prezime;
	private String adresa;
	private String brojTelefona;
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vozilo_id", referencedColumnName = "id")
	private Vozilo vozilo;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="zaposleni_kategorije")
	private Set<Kategorija> kategorije;
	
	
	public Zaposleni() {
		super();
	}

	public Zaposleni(Long id, String ime, String prezime, String adresa, String brojTelefona,Vozilo vozilo,Set<Kategorija>kategorije) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.vozilo = vozilo;
		this.kategorije = kategorije;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}

	public Set<Kategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(Set<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zaposleni other = (Zaposleni) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zaposleni [id=" + id + ", ime=" + ime + ", prezime=" + prezime
				+ ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", vozilo:" +vozilo;
	}

}
