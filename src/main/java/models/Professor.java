package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author joao_
 *
 * Class for the model Professor
 * Professors is an Entity class mapped in the database where it has identified its Scientific work
 * Only has setters and getters
 *
 */
@Entity
public class Professor {
	@Version
	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String nomerh;
	@NotNull
	private Boolean cadastradolattes;
	private String campus;
	private String centro;
	private String situacao;
	@Temporal(TemporalType.DATE)
	private Date dataadmissao;
	private String descricaocargo;
	private String departamento;
	private String colegio;
	private String programa;
	private String nivelpos;
	private String campuspos;
	private String descricaonivel;
	private String descricaohabilitacao;
	@ManyToMany
	private List<ProducaoCientifica> producao;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomerh() {
		return nomerh;
	}
	public void setNomerh(String nomerh) {
		this.nomerh = nomerh;
	}
	public boolean isCadastradolattes() {
		return cadastradolattes;
	}
	public void setCadastradolattes(boolean cadastradolattes) {
		this.cadastradolattes = cadastradolattes;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getDataadmissao() {
		return dataadmissao;
	}
	public void setDataadmissao(Date dataadmissao) {
		this.dataadmissao = dataadmissao;
	}
	public String getDescricaocargo() {
		return descricaocargo;
	}
	public void setDescricaocargo(String descricaocargo) {
		this.descricaocargo = descricaocargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getColegio() {
		return colegio;
	}
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getNivelpos() {
		return nivelpos;
	}
	public void setNivelpos(String nivelpos) {
		this.nivelpos = nivelpos;
	}
	public String getCampuspos() {
		return campuspos;
	}
	public void setCampuspos(String campuspos) {
		this.campuspos = campuspos;
	}
	public String getDescricaonivel() {
		return descricaonivel;
	}
	public void setDescricaonivel(String descricaonivel) {
		this.descricaonivel = descricaonivel;
	}
	public String getDescricaohabilitacao() {
		return descricaohabilitacao;
	}
	public void setDescricaohabilitacao(String descricaohabilitacao) {
		this.descricaohabilitacao = descricaohabilitacao;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Boolean getCadastradolattes() {
		return cadastradolattes;
	}
	public void setCadastradolattes(Boolean cadastradolattes) {
		this.cadastradolattes = cadastradolattes;
	}
	public List<ProducaoCientifica> getProducao() {
		return producao;
	}
	public void setProducao(List<ProducaoCientifica> producao) {
		this.producao = producao;
	}

}
