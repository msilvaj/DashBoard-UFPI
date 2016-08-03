package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
/**
 * 
 * @author joao_
 *
 *
 * Class ProducaoCientifica
 * 
 * An Entity class for the model designed for a Scientific Paper, journal, book or similar
 * It is mapped in the Database and it has a reference to a "Professor" list, since one or more professors can contribute with the work
 * Its methods are only setters and getters
 */
@Entity
public class ProducaoCientifica {
	@Version
	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	@Column (unique = true)
	private String titulo;
	private String periodico;
	@Temporal(TemporalType.DATE)
	private Date ano;
	private String idioma;
	private String curso;
	private Double jcr;
	private String qualis;
	private String circulacao;
	private Integer n_autores;
	private String tipoproducao;
	private String editora;
	private Integer n_paginas;
	private String evento;
	private String producaodentrouf;
	private String instituicao;
	@ManyToMany (mappedBy = "producao")
	private List<Professor> professores;

	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getPeriodico() {
		return periodico;
	}
	public void setPeriodico(String periodico) {
		this.periodico = periodico;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Double getJcr() {
		return jcr;
	}
	public void setJcr(Double jcr) {
		this.jcr = jcr;
	}
	public String getQualis() {
		return qualis;
	}
	public void setQualis(String qualis) {
		this.qualis = qualis;
	}
	public String getCirculacao() {
		return circulacao;
	}
	public void setCirculacao(String circulacao) {
		this.circulacao = circulacao;
	}
	public Integer getN_autores() {
		return n_autores;
	}
	public void setN_autores(Integer n_autores) {
		this.n_autores = n_autores;
	}
	public String getTipoproducao() {
		return tipoproducao;
	}
	public void setTipoproducao(String tipoproducao) {
		this.tipoproducao = tipoproducao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Integer getN_paginas() {
		return n_paginas;
	}
	public void setN_paginas(Integer n_paginas) {
		this.n_paginas = n_paginas;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getProducaodentrouf() {
		return producaodentrouf;
	}
	public void setProducaodentrouf(String producaodentrouf) {
		this.producaodentrouf = producaodentrouf;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public List<Professor> getProfessores() {
		return professores;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
