package npuzzle;

import search.AStarFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.BreadthFirstTreeSearch;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.Node;
import search.TreeSearch;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		GoalTest goalTest = new TilesGoalTest();
		DepthFirstFrontier dtf = new DepthFirstFrontier();
		DepthFirstFrontier dgf = new DepthFirstFrontier();
		BreadthFirstFrontier btf = new BreadthFirstFrontier();
		BreadthFirstFrontier bgf = new BreadthFirstFrontier();
		
		TreeSearch dts = new TreeSearch(dtf);
		GraphSearch dgs = new GraphSearch(dgf);
		TreeSearch bts = new TreeSearch(btf);
		GraphSearch bgs = new GraphSearch(bgf);
		
//		Node dgssolution = dgs.findSolution(initialConfiguration, goalTest);
//		//new NPuzzlePrinting().printSolution(dgssolution);
//
//		System.out.println("dgs");
//		System.out.println(dgs.f.get_maximum_stored());
//		System.out.println(dgs.nodes_generated());
//		
////		
////		Node dtssolution = dts.findSolution(initialConfiguration, goalTest);
////		new NPuzzlePrinting().printSolution(dtssolution);
////		System.out.println(dts.f.get_maximum_stored());
////		System.out.println(dts.nodes_generated());

//		System.out.println("bgs");
//
//		Node bgssolution = bgs.findSolution(initialConfiguration, goalTest);
//		new NPuzzlePrinting().printSolution(bgssolution);
//		System.out.println(bgs.f.get_maximum_stored());
//		System.out.println(bgs.nodes_generated());
//		Node btssolution = bts.findSolution(initialConfiguration, goalTest);
//		new NPuzzlePrinting().printSolution(btssolution);
//		System.out.println("bts");
//		System.out.println(bts.f.get_maximum_stored());
//		System.out.println(bts.nodes_generated());
//		
//		System.out.println("Iterative Deepening");
//		IterativeDeepeningTreeSearch idts = new IterativeDeepeningTreeSearch();
//		Node idtssolution = idts.findSolution(initialConfiguration, goalTest);
//		new NPuzzlePrinting().printSolution(idtssolution);
//		System.out.println(idts.f.get_maximum_stored());
//		System.out.println(idts.nodes_generated());
		
		System.out.println("A* Tree Search");
		TreeSearch at = new TreeSearch(new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction())));

		Node atsolution = at.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(atsolution);
		System.out.println(at.f.get_maximum_stored());
		System.out.println(at.nodes_generated());
		
		System.out.println("A* Graph Search");
		GraphSearch ag = new GraphSearch(new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction())));

		Node agsolution = ag.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(agsolution);
		System.out.println(ag.f.get_maximum_stored());
		System.out.println(ag.nodes_generated());
		
	}
}
