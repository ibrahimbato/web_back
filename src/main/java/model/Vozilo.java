package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery (name = Vozilo.GET_ALL, query = "Select v from Vozilo v"),
	@NamedQuery(name = Vozilo.DELETE_VOZILO,query ="Delete from Vozilo v where v.id = :id"),
@NamedQuery(name = Vozilo.SELECT_VOZILO, query = "Select v from Vozilo v where v.id = :id") })
public class Vozilo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String DELETE_VOZILO ="Vozilo.delete";
	public static final String GET_ALL = "Vozilo.getAll";
	public static final String SELECT_VOZILO = "Vozilo.get";
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marka;
	private String model;
	private String godinaProizvodnje;
	private String registracija;
	@OneToOne(mappedBy = "vozilo")
	private Zaposleni zaposleni;
	
	public Vozilo() {
		super();
	}

	public Vozilo(Long id,String marka,String model, String godinaProizvodnje, String registracija) {
		super();
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.godinaProizvodnje= godinaProizvodnje;
		this.registracija = registracija;
	}
	

	public Long getId() {
		return id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Vozilo other = (Vozilo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vozilo [id=" + id + ", model=" + model + ",registracija:" + registracija +"]"; 
	}

	public String getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(String godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	
	
}
