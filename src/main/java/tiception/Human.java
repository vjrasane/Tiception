package tiception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap.SimpleEntry;

public class Human implements Player {

	private String playerName;
	private Mark mark;

	public Human(String playerName, Mark mark) {
		this.playerName = playerName;
		this.mark = mark;
	}

	public SimpleEntry<Coordinates, Coordinates> getMove(Coordinates next) {
		System.out.println("Player " + playerName + " turn.");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Coordinates board = null;
		if (next == null) {
			System.out.println("Enter the coordinates of the board you wish to play to (separated by a comma).");
			while (board == null) {
				try {
					String inBuffer = in.readLine();
					String[] split = inBuffer.split(",");
					if (split.length == 2) {
						int x = Integer.parseInt(split[0]);
						int y = Integer.parseInt(split[1]);
						if ((x < 3) && (x >= 0) && (y < 3) && (y >= 0)) {
							board = new Coordinates(x, y);
						} else {
							System.out.println("Coordinates out of bounds (range 0-2)!");
						}
					} else {
						System.out.println("Invalid input!");
					}
				} catch (IOException e2) {
					System.out.println("Invalid input!");
				}
			}
		} else {
			board = next;
		}

		Coordinates position = null;
		System.out.println("Enter the coordinates of the position on the board " + board + "(separated by a comma).");
		while (position == null) {
			try {
				String inBuffer = in.readLine();
				String[] split = inBuffer.split(",");
				int x = Integer.parseInt(split[0]);
				int y = Integer.parseInt(split[1]);
				if ((x < 3) && (x >= 0) && (y < 3) && (y >= 0)) {
					position = new Coordinates(x, y);
				}

			} catch (IOException e2) {
			}
		}

		return new SimpleEntry<Coordinates, Coordinates>(board, position);
	}
	
	public Mark getMark() {
		return this.mark;
	}

}
