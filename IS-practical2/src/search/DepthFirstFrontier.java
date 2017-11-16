package search;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstFrontier implements Frontier{

	Deque<Node> queue = new LinkedList<Node>();
	int maximum_stored = 0;
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(queue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void add(Node node) {
		// TODO Auto-generated method stub
		queue.addLast(node);
		if(queue.size()>this.maximum_stored) {
			this.maximum_stored = queue.size();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		queue.clear();
		maximum_stored = 0;
	}

	@Override
	public Node remove() {
		// TODO Auto-generated method stub
		return queue.removeLast();
	}

	@Override
	public int get_maximum_stored() {
		// TODO Auto-generated method stub
		return this.maximum_stored;
	}

}
