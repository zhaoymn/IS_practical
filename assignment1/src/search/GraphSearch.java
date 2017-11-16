package search;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GraphSearch implements Search{
	int nodes_num = 0;
	public Frontier f;
	private Set<State> visited_states;
	public GraphSearch(Frontier ft) {
		f = ft;
		f.clear();
	}
	@Override
	public Node findSolution(State initialConfiguration, GoalTest gt) {
		// TODO Auto-generated method stub
//		f.clear();
		visited_states=new HashSet<State>();
		nodes_num = 1;
		Node node = new Node(null, null, initialConfiguration);
		while (!gt.isGoal(node.state)) {
			visited_states.add(node.state);
			//visited_states.add(node.state);
			for (Action action : node.state.getApplicableActions()) {
				State newState = node.state.getActionResult(action);
				int flag = 0;
				for(State s:visited_states) {
					if(s.equals(newState)){
						flag = 1;
						break;
					}
				}
				if(flag == 1)
					continue;
				f.add(new Node(node, action, newState));
				nodes_num ++;
			}
			if(f.isEmpty()) return null;
			node = f.remove();
		}
		return node;
	}
	@Override
	public int nodes_generated() {
		// TODO Auto-generated method stub
		return nodes_num;
	}

}
