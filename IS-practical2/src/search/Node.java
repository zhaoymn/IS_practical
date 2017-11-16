package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int dep;
	public int value;
	public int fn;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		if(parent==null)
			dep=1;
		else
			this.dep = parent.dep+1;
		if(parent == null) {
			value = 0;
		} else {
			value = parent.value + action.get_cost();
		}
	}
}
