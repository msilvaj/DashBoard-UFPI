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
import models.Projeto;

/**
 * 
 * @author joao_
 *
 * Class ProjetoBean
 *
 * Class to make connections to the database. SELECTs only.
 * It also creates the graphs, based on the SELECT used in method "consulta";
 * 
 */
@ManagedBean
@ViewScoped
public class ProjetoBean {

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
			case 0 : // TODOS PROJETOS CONCLUIDOS
				return "SELECT p FROM Projeto p WHERE p.situacao LIKE '%Concluido%'";
			case 1 : // TODOS PROJETOS DE NATUREZA DIFERENTE
				return "SELECT p FROM Projeto p WHERE p.natureza LIKE '%Outra%'";
		}
	}

	public void chartConcluidos() {
		TypedQuery<Projeto> pQry = em.createQuery(consulta(0), Projeto.class);
		List<Data> data = new ArrayList<Data>();
		for (Projeto p : pQry.getResultList()) {
			data.add(new Data(p.getSituacao(), new Double(p.getID()), 0.0));
		}
		chart = new Chart("Projetos Concluídos", "Projeto", data);
	}

	public void chartNaturezaDiferente() {
		TypedQuery<Projeto> pQry = em.createQuery(consulta(1), Projeto.class);
		List<Data> data = new ArrayList<Data>();
		for (Projeto p : pQry.getResultList()) {
			data.add(new Data(p.getSituacao(), new Double(p.getID()), 0.0));
		}
		chart = new Chart("Projetos Natureza Outras", "", data);
	}

}
