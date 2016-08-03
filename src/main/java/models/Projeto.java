package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
/**
 * 
 * @author joao_
 *
 * Class Projeto
 * 
 * Entity mapped by the database, where it has a reference to the Professor responsible for it.
 * Only has setters and getters mehtods. 
 */
@Entity
public class Projeto {
	@Version
	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor orientacao;
	private String situacao;
	private String natureza;
	private String naturezafinanciadora;

	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public Professor getOrientacao() {
		return orientacao;
	}
	public void setOrientacao(Professor orientacao) {
		this.orientacao = orientacao;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getNatureza() {
		return natureza;
	}
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	public String getNaturezafinanciadora() {
		return naturezafinanciadora;
	}
	public void setNaturezafinanciadora(String naturezafinanciadora) {
		this.naturezafinanciadora = naturezafinanciadora;
	}
}
