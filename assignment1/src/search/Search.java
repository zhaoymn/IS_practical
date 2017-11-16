package search;

public interface Search {
	Node findSolution(State initialConfiguration, GoalTest gt);
	int nodes_generated();
}
