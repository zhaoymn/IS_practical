package mars;

import java.util.LinkedHashSet;
import java.util.Set;

import npuzzle.Tiles;
import search.Action;
import search.State;

public class Explorer_State implements State{
	public final int x,y;
	public final int[][] map_status;
	public final int step_taken;
	public final int experiments_did;
	Planet planet = new Planet();
	
	public Explorer_State(int xpos, int ypos, int[][] visit_status, int step, int squares_explored) {
		x = xpos;
		y = ypos;
		map_status = new int[8][8];
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<8;j++) {
				map_status[i][j] = visit_status[i][j];
			}
		}
		step_taken = step;
		experiments_did = squares_explored;
	}
	
	@Override
	public Set<? extends Action> getApplicableActions() {

		Set<Action> actions = new LinkedHashSet<Action>();

		for (Movement movement : Movement.values()) {
			int newx = x + movement.deltax;
			int newy = y + movement.deltay;
			if(planet.isAccessible(newx, newy)) {
				actions.add(movement);
			}
		}
		// TODO Auto-generated method stub
		return actions;
	}

	@Override
	public State getActionResult(Action action) {
		// TODO Auto-generated method stub
		Movement m = (Movement)action;
		int newx = x+m.deltax;
		int newy = y+m.deltay;
		int new_step_taken = step_taken+1;
		int squares_explored = experiments_did;
		int[][] new_map_status = new int[8][8];
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<8;j++) {
				new_map_status[i][j] = map_status[i][j];
			}
		}
		if(new_map_status[newx][newy]==0) {
			new_map_status[newx][newy] = 1;
			squares_explored++;
		}
		
		return new Explorer_State(newx, newy, new_map_status, new_step_taken, squares_explored);
	}
	@Override
	public boolean equals(Object that) {
		Explorer_State es = (Explorer_State)that;
		if(this.x!=es.x)return false;
		if(this.y!=es.y)return false;
		if(this.step_taken!=es.step_taken) return false;
		if(this.experiments_did!=es.experiments_did)return false;
		for(int i = 0;i<8;i++) {
			for(int j =0;j<8;j++) {
				if(this.map_status[i][j]!=es.map_status[i][j]) return false;
			}
		}
		return true;
	}
}
