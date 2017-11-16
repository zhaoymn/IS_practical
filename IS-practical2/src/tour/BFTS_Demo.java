package tour;

import npuzzle.MisplacedTilesHeuristicFunction;
import npuzzle.NPuzzlePrinting;
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
	public static Cities romania = SetUpRomania.getRomaniaMap();
	public static City endCity = romania.getState("Bucharest");
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		System.out.println();
		
		
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), endCity);
		
		
		TreeSearch dts = new TreeSearch(new DepthFirstFrontier());
		GraphSearch dgs = new GraphSearch(new DepthFirstFrontier());
		TreeSearch bts = new TreeSearch(new BreadthFirstFrontier());
		GraphSearch bgs = new GraphSearch(new BreadthFirstFrontier());

//		Node dtssolution = dts.findSolution(new TourState(startCity), goalTest);
//		new TourPrinting().printSolution(dtssolution);
//		System.out.println(dts.f.get_maximum_stored());
//		System.out.println(dts.nodes_generated());
		
//		System.out.println("dgs");
//
//		Node dgssolution = dgs.findSolution(new TourState(startCity), goalTest);
////		new TourPrinting().printSolution(dgssolution);
//		System.out.println(dgs.f.get_maximum_stored());
//		System.out.println(dgs.nodes_generated());
//
//		System.out.println("bts");
//
//		Node btssolution = bts.findSolution(new TourState(startCity), goalTest);
////		new TourPrinting().printSolution(btssolution);
//		System.out.println(bts.f.get_maximum_stored());
//		System.out.println(bts.nodes_generated());
//
//		System.out.println("bgs");
//
//		Node bgssolution = bgs.findSolution(new TourState(startCity), goalTest);
////		new TourPrinting().printSolution(bgssolution);
//		System.out.println(bgs.f.get_maximum_stored());
//		System.out.println(bgs.nodes_generated());
//		
//		
//		System.out.println("Iterative Deepening");
//		
//
//		IterativeDeepeningTreeSearch idts = new IterativeDeepeningTreeSearch();
//		Node idtssolution = idts.findSolution(new TourState(startCity), goalTest);
////		new TourPrinting().printSolution(idtssolution);
//		System.out.println(idts.f.get_maximum_stored());
//		System.out.println(idts.nodes_generated());
		
		
//		System.out.println("A* Tree Search");
//		TreeSearch at = new TreeSearch(new BestFirstFrontier(new AStarFunction(new RomaniaHeuristic())));
//
//		Node atsolution = at.findSolution(new TourState(startCity), goalTest);
//		new TourPrinting().printSolution(atsolution);
//		System.out.println(at.f.get_maximum_stored());
//		System.out.println(at.nodes_generated());
		
		System.out.println("A* Graph Search");
		GraphSearch ag = new GraphSearch(new BestFirstFrontier(new AStarFunction(new RomaniaHeuristic())));

		Node agsolution = ag.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(agsolution);
		System.out.println(ag.f.get_maximum_stored());
		System.out.println(ag.nodes_generated());
		
	}
}
