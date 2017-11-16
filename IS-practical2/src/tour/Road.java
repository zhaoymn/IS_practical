package tour;

import search.Action;
import search.Node;

public class Road implements Action {
	public final City sourceCity;
	public final City targetCity;
	public final int length;
	
	public Road(City sourceCity, City targetCity, int length) {
		this.sourceCity = sourceCity;
		this.targetCity = targetCity;
		this.length = length;
	}
	public int cost() {
		return length;
	}
	
	@Override
	public int get_cost() {
		// TODO Auto-generated method stub
		return this.length;
	}
}
