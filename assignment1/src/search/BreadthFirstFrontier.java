package search;

import java.util.Deque;
import java.util.LinkedList;

public class BreadthFirstFrontier implements Frontier{

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
		int num = queue.size();
		if (num>this.maximum_stored) {
			this.maximum_stored = num;
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
		return queue.removeFirst();
	}

	@Override
	public int get_maximum_stored() {
		// TODO Auto-generated method stub
		return maximum_stored;
	}

}
