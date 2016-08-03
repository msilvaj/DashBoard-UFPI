package charts;

/**
 * 
 * @author joao_
 *
 * Class Data
 * Auxiliary Class to represent data used in Charts
 * Setters and Getters only
 * ToString: to print according to vision layer and HighCharts expect
 */
public class Data {
	private String name;
	private Double y;
	private Double percent;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
	public String toString(){
		return "{name: '" + name + "', y : "+ y + "}";
	}

	public Data(String name, Double y, Double percent){
		this.name = name;
		this.y = y;
		this.percent = percent;
	}
}
