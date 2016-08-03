package charts;

import java.util.List;

/**
 * 
 * @author joao_
 *
 * Class Chart
 * 
 * Auxiliary Class to represent Charts for Highcharts
 * Setters and Getters only, accessible by the vision layer
 */
public class Chart {
	private String title;
	private String name;
	private List<Data> data;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	
	public Chart(String title, String name, List<Data> data){
		this.title = title;
		this.name = name;
		this.data = data;
	}
}
