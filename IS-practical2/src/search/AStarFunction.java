package search;

public class AStarFunction implements NodeFunction{
	NodeFunction nf;
	public AStarFunction(NodeFunction heuristicFunction){
		this.nf = heuristicFunction;
	}
	@Override
	public int get_value(Node n) {
		// TODO Auto-generated method stub
		return n.value + nf.get_value(n);
	}

}
