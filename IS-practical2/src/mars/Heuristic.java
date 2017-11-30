package mars;

import search.Node;
import search.NodeFunction;

public class Heuristic implements NodeFunction{

	@Override
	public int get_value(Node n) {
		// TODO Auto-generated method stub
		Explorer_State es = (Explorer_State) n.state;
		return 64-es.experiments_did;
	}

}
