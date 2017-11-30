package mars;

import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;

public enum Movement implements Action {
	UP(-1, 0), LEFT(0, -1), DOWN(1, 0), RIGHT(0, 1);

	public final int deltax;
	public final int deltay;
	
	private Movement(int deltaRow, int deltaColumn) {
		this.deltax = deltaRow;
		this.deltay = deltaColumn;
	}

	@Override
	public int get_cost() {
		// TODO Auto-generated method stub
		return 2;
	}

}