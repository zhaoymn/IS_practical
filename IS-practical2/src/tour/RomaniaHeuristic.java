package tour;

import java.util.HashSet;
import java.util.Set;

import search.Node;
import search.NodeFunction;

public class RomaniaHeuristic implements NodeFunction{
	@Override
	public int get_value(Node n) {
		// TODO Auto-generated method stub
		TourState current_state = (TourState)n.state;
		City current_city = current_state.currentCity;
		City far_city = null;
		int fardist = 0;
		for(City c : BFTS_Demo.romania.getAllCities()) {
			if(!current_state.visitedCities.contains(c)) {
				if(!current_state.currentCity.equals(c))
				if(current_city.shortestDistanceByCity.get(c)+c.shortestDistanceByCity.get(BFTS_Demo.endCity)>fardist) {
					fardist = current_city.shortestDistanceByCity.get(c)+ c.shortestDistanceByCity.get(BFTS_Demo.endCity);
					far_city = c;
				}
			}
		}
		if(far_city != null) {
			return fardist;
		}
		return 0;
	}

}
