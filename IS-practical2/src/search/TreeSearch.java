package search;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSearch implements Search{
	int nodes_num = 0;
	public Frontier f;
	public TreeSearch(Frontier ft) {
		f = ft;
	}
	@Override
	public Node findSolution(State initialConfiguration, GoalTest gt) {
		// TODO Auto-generated method stub
//        f.clear();
		f.add(new Node(null, null, initialConfiguration));
		nodes_num = 0;
		while (!f.isEmpty()) {
			Node node = f.remove();
			if (gt.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					f.add(new Node(node, action, newState));
					nodes_num ++;
				}
			}
		}
		return null;
	}
	@Override
	public int nodes_generated() {
		// TODO Auto-generated method stub
		return nodes_num;
	}
}
