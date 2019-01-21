package tiception;

import java.util.AbstractMap.SimpleEntry;;

public interface Player {

	public SimpleEntry<Coordinates, Coordinates> getMove(Coordinates next);

	public Mark getMark();

}