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
import models.ProducaoCientifica;
/**
 * 
 * @author joao_
 *
 * Class ProducaoBean
 * 
 * Class to make connections to the database. SELECTs only.
 * It also creates the graphs, based on the SELECT used in method "consulta";
 * 
 */
@ManagedBean
@ViewScoped
public class ProducaoBean {
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
			case 0 : // TODA PRODUCAO
				return "SELECT p FROM ProducaoCientifica p WHERE p.jcr > 2";
		}
	}
	
	public void chartTodaProducao() {
		TypedQuery<ProducaoCientifica> pQry = em.createQuery(consulta(0),
				ProducaoCientifica.class);
		List<Data> data = new ArrayList<Data>();
		for(ProducaoCientifica p: pQry.getResultList()){
			data.add(new Data(p.getPeriodico(), new Double(p.getN_autores()), 0.0));
		}
		chart = new Chart("Todas Publicações", "Periódico", data);
	}

}
