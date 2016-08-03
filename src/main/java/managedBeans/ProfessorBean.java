package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import charts.Chart;
import charts.Data;
import models.Professor;


/**
 * 
 * @author joao_
 *
 * Class ProfessorBean
 * 
 * Class to make connections to the database. SELECTs only.
 * It also creates the graphs, based on the SELECT used in method "consulta";
 *
 */
@ManagedBean
@ViewScoped
public class ProfessorBean {

	@PersistenceContext
	private EntityManager em;

	private Chart chart;
	
	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	private String consulta(int type) {
		switch (type) {
			default :
			case 0 : // TODOS PROFESSORES
				return "SELECT p FROM Professor p";
			case 1 : // TODOS ATIVOS
				return "SELECT p FROM Professor p WHERE p.situacao LIKE '%ATIVO%'";
			case 2 : // TODOS NAO ATIVOS
				return "SELECT p FROM Professor p WHERE p.situacao LIKE '%INATIVO%'";
			case 3 : // TODOS CADASTRADOS LATTES
				return "SELECT p FROM Professor p WHERE p.cadastradolattes = 1";
			case 4 : // TODOS DEPARTAMENTO X
				return "SELECT p FROM Professor p WHERE p.departamento = :valor";
			case 5 : // TODOS CAMPUS X
				return "SELECT p FROM Professor p WHERE p.campus = :valor";
			case 6 : // TODOS CENTRO X
				return "SELECT p FROM Professor p WHERE p.centro = :valor";
			case 7 : // TODOS NIVEL POS X
				return "SELECT p FROM Professor p WHERE p.campus = :valor";
			case 8 : // TODOS NAO CADASTRADOS LATTES
				return "SELECT p FROM Professor p WHERE p.cadastradolattes = 0";
		}
	}

	public List<Professor> todosProfessores() {
		TypedQuery<Professor> pQry = em.createQuery(consulta(0),
				Professor.class);
		return pQry.getResultList();
	}
	
	public void chartTodosProfessores() {
		TypedQuery<Professor> pQry = em.createQuery(consulta(0),
				Professor.class);
		List<Data> data = new ArrayList<Data>();
		for(Professor p: pQry.getResultList()){
			data.add(new Data(p.getNomerh(), new Double(p.getId()), 0.0));
		}
		chart = new Chart("Todos Professores", "Professor", data);
	}

	public List<Professor> todosAtivos() {
		TypedQuery<Professor> pQry = em.createQuery(consulta(1),
				Professor.class);
		return pQry.getResultList();
	}
	
	public void chartTodosLattes() {
		TypedQuery<Professor> pQry = em.createQuery(consulta(3),
				Professor.class);
		List<Data> data = new ArrayList<Data>();
		for(Professor p: pQry.getResultList()){
			data.add(new Data(p.getNomerh(), new Double(p.getId()), 0.0));
		}
		chart = new Chart("Todos Professores", "Professor", data);
	}

	public List<Professor> cadastradoLattes() {
		TypedQuery<Professor> pQry = em.createQuery(consulta(3),
				Professor.class);
		return pQry.getResultList();
	}
	public List<Professor> naoCadastradoLattes() {
		TypedQuery<Professor> pQry = em.createQuery(consulta(8),
				Professor.class);
		return pQry.getResultList();
	}

	public void chartTodosCampus(String nome) {
		TypedQuery<Professor> pQry = em.createQuery(consulta(5),
				Professor.class);
		pQry.setParameter("valor", "TERESINA");
		List<Data> data = new ArrayList<Data>();
		for(Professor p: pQry.getResultList()){
			data.add(new Data(p.getNomerh(), new Double(p.getId()), 0.0));
		}
		chart = new Chart("Todos Professores", "Professor", data);
	}
	public void index() {

	}
}
