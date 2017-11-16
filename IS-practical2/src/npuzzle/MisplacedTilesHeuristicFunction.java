package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction{
	@Override
	public int get_value(Node n) {
		Tiles s = (Tiles) n.state;
		int mis = 0;
		for(int i = 0;i<s.width*s.width;i++) {
			if(s.tiles[i]!=0 && s.tiles[i] != i+1) {
				mis++;
			}
		}
		return mis;
	}

}
