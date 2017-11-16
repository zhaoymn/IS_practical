package tour;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	static Map<String, Integer> hmap = new HashMap<String, Integer>();
	static {
		hmap.put("Arad", 2);
		hmap.put("Bucharest", 3);
		hmap.put("Craiova", 5);
		hmap.put("Drobeta", 7);
		hmap.put("Eforie", 11);
		hmap.put("Fagaras", 13);
		hmap.put("Hirsova", 17);
		hmap.put("Iasi", 19);
		hmap.put("Lugoj", 23);
		hmap.put("Oradea", 29);
		hmap.put("Rimnicu Vilcea", 31);
		hmap.put("Urziceni", 37);
		hmap.put("Pitesti", 41);
		hmap.put("Sibiu", 43);
		hmap.put("Zerind", 47);
		hmap.put("Giurgui", 51);
	}
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	@Override
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	@Override
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}
	@Override
	public boolean equals(Object that) {
		if(!this.currentCity.getName().equals(((TourState)that).currentCity.getName())) return false;
		//if(!this.visitedCities.containsAll(((TourState)that).visitedCities)) return false;
		if(this.visitedCities.size()!=((TourState)that).visitedCities.size()) return false;
		if(!((TourState)that).visitedCities.containsAll(this.visitedCities)) return false;
		return true;
	}
	@Override
	public int hashCode() {
		return this.currentCity.hashCode()+this.visitedCities.hashCode();
//		return 0;
		// TODO Auto-generated method stub
//		int base = 1;
//		for(City c:this.visitedCities) {
//			base*=hmap.get(c.getName());
//		}
//		base = base + hmap.get(this.currentCity.getName());
//		
//		return base;
//		return 0;
	}
}
