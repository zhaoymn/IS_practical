package search;
import java.util.*;

public class BestFirstFrontier implements Frontier{

	PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>(){
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.fn-o2.fn;
		}
	});
	NodeFunction nf;
	int maximum_stored = 0;
	
	public BestFirstFrontier(NodeFunction nodefunction) {
		this.nf = nodefunction;
		maximum_stored = 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public void add(Node node) {
		// TODO Auto-generated method stub
		node.fn = nf.get_value(node);
		queue.add(node);
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
		Node temp = queue.remove();
		return temp;
	}

	@Override
	public int get_maximum_stored() {
		// TODO Auto-generated method stub
		return maximum_stored;
	}

}
