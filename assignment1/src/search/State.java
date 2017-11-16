package search;

import java.util.Set;

import npuzzle.Tiles;

public interface State {
	Set<? extends Action> getApplicableActions();
	State getActionResult(Action action);
	boolean equals(Object that);
	int hashCode();
}
