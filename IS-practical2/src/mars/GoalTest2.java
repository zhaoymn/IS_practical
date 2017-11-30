package mars;

import search.GoalTest;
import search.State;

public class GoalTest2 implements GoalTest{

	@Override
	public boolean isGoal(State state) {
		// TODO Auto-generated method stub
		if(((Explorer_State)state).experiments_did == 26)
			return true;
		return false;
	}

}
