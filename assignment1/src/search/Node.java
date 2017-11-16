package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int dep;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		if(parent==null)
			dep=1;
		else
			this.dep = parent.dep+1;
	}
}
