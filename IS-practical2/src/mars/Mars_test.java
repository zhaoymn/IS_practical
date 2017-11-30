package mars;

import npuzzle.MisplacedTilesHeuristicFunction;
import search.AStarFunction;
import search.BestFirstFrontier;
import search.GraphSearch;
import search.Node;
import search.TreeSearch;

public class Mars_test {
	public static void main(String[] args) {
		int[][] initial_visit_state = new int[][] {
	        {0,0,0,0,0,0,0,0},
	        {0,0,0,0,0,0,0,0},
	        {0,0,0,0,0,0,0,0},
	        {0,0,0,0,0,0,0,0},
	        {0,0,0,0,1,0,0,0},
	        {0,0,0,0,0,0,0,0},
	        {0,0,0,0,0,0,0,0},
	        {0,0,0,0,0,0,0,0},
	     };
	 	TreeSearch at = new TreeSearch(new BestFirstFrontier(new AStarFunction(new Heuristic())));
	 	GraphSearch ag = new GraphSearch(new BestFirstFrontier(new AStarFunction(new Heuristic())));
		Explorer_State initial_es = new Explorer_State(4, 4, initial_visit_state, 0, 1);
		MarsGoalTest goalTest = new MarsGoalTest();
		MarsPrinting mp = new MarsPrinting();
		Node atsolution = at.findSolution(initial_es, goalTest);
		mp.printSolution(atsolution);
		System.out.println(at.f.get_maximum_stored());
		System.out.println(at.nodes_generated());
		
		Node agsolution = ag.findSolution(initial_es, goalTest);
		mp.printSolution(agsolution);
		System.out.println(ag.f.get_maximum_stored());
		System.out.println(ag.nodes_generated());
		
		
		GoalTest2 goalTest2 = new GoalTest2();

//		Node atsolution2 = at.findSolution(initial_es, goalTest2);
//		mp.printSolution(atsolution2);		
//		System.out.println(at.f.get_maximum_stored());
//		System.out.println(at.nodes_generated());

	 	GraphSearch ag2 = new GraphSearch(new BestFirstFrontier(new AStarFunction(new Heuristic())));
		Node agsolution2 = ag2.findSolution(initial_es, goalTest2);
		mp.printSolution(agsolution2);
		System.out.println(ag2.f.get_maximum_stored());
		System.out.println(ag2.nodes_generated());
	}
}
