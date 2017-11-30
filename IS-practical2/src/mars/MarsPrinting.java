package mars;

import search.Action;
import search.Printing;
import search.State;

public class MarsPrinting extends Printing {

	@Override
	public void print(Action action) {
		// TODO Auto-generated method stub
		System.out.println(((Movement)action).name());

	}

	@Override
	public void print(State state) {
		// TODO Auto-generated method stub
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<8;j++) {
				System.out.print(((Explorer_State)state).map_status[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println(((Explorer_State)state).experiments_did);
	}

}
