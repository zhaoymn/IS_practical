package mars;

import search.GoalTest;
import search.State;

public class MarsGoalTest implements GoalTest {

	@Override
	public boolean isGoal(State state) {
		// TODO Auto-generated method stub
		if(((Explorer_State)state).step_taken==20)
			return true;
		return false;
	}

}
