import java.util.AbstractMap;



public interface Player{

    public AbstractMap.SimpleEntry<Coordinates, Coordinates> getMove(Coordinates next);

    public Mark getMark();

}