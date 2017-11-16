package search;

public class IterativeDeepeningTreeSearch implements Search{
	public DepthFirstFrontier f;
	int depth;
	int nodes_num;
	
	public IterativeDeepeningTreeSearch() {
		f = new DepthFirstFrontier();
		depth = 1;
		nodes_num = 0;
	}
	
	@Override
	public Node findSolution(State initialConfiguration, GoalTest gt) {
		// TODO Auto-generated method stub

		while(true) {
			System.out.println("depth"+String.valueOf(depth));
			Node node = new Node(null, null, initialConfiguration);
			nodes_num = 1;
			boolean have_son = false;
			while (!gt.isGoal(node.state)) {
				for (Action action : node.state.getApplicableActions()) {
					have_son = true;
					State newState = node.state.getActionResult(action);
					if(node.dep < depth) {
						f.add(new Node(node, action, newState));
						nodes_num ++;
					} else {
						have_son = true;
					}
				}

				if(f.isEmpty()&&!have_son)
					return null;
				
				if(f.isEmpty())
					break;
				node = f.remove();
			}
			if(gt.isGoal(node.state)) {
				return node;
			}
			depth++;
		}
		
	}

	@Override
	public int nodes_generated() {
		// TODO Auto-generated method stub
		return nodes_num;
	}
	

}
