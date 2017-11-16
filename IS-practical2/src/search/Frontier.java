package search;
import java.util.LinkedList;
import java.util.Deque;



public interface Frontier {
	boolean isEmpty();
	void add(Node node);
	void clear();
	Node remove();
	int get_maximum_stored();
}
