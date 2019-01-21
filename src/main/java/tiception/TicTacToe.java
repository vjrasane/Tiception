package tiception;

import java.util.Random;

public class TicTacToe {

	private Mark[][] board = new Mark[3][3];
	private Mark winner = Mark.EMPTY;

	public TicTacToe() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Mark.EMPTY;
			}
		}
	}

	public Mark getMark(int width, int height) {
		return board[width][height];
	}

	public void setMark(int x, int y, Mark mark) {
		board[x][y] = mark;
	}

	public Mark getWinner() {
		if (this.winner == Mark.EMPTY) {
			this.winner = checkWinner();
		}
		return winner;
	}

	private Mark checkWinner() {
		for (int i = 0; i < board.length; i++) {
			Mark m = board[i][0];
			if (m != Mark.EMPTY) {
				boolean win = true;
				for (int j = 1; j < board[i].length; j++) {
					if (board[i][j] != m) {
						win = false;
						break;
					}
				}

				if (win) {
					return m;
				}
			}
		}

		for (int j = 0; j < board.length; j++) {
			Mark m = board[0][j];
			if (m != Mark.EMPTY) {
				boolean win = true;
				for (int i = 1; i < board[j].length; i++) {
					if (board[i][j] != m) {
						win = false;
						break;
					}
				}

				if (win) {
					return m;
				}
			}

		}

		Mark m = board[0][0];
		if (m != Mark.EMPTY) {
			boolean win = true;
			for (int i = 1; i < board.length; i++) {
				if (board[i][i] != m) {
					win = false;
					break;
				}
			}

			if (win) {
				return m;
			}
		}

		m = board[0][board.length - 1];
		if (m != Mark.EMPTY) {
			boolean win = true;
			for (int i = 1; i < board.length; i++) {
				if (board[i][board.length - 1 - i] != m) {
					win = false;
					break;
				}
			}

			if (win) {
				return m;
			}
		}
		return Mark.EMPTY;
	}

	public boolean isFull() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == Mark.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public void randomize(Random gen) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int rand = gen.nextInt(3);
				if (rand == 0) {
					board[i][j] = Mark.CIRCLE;
				} else if (rand == 1) {
					board[i][j] = Mark.CROSS;
				} else {
					board[i][j] = Mark.EMPTY;
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			b.append(toString(i));
			b.append("\n");
		}
		return b.toString();
	}

	public String toString(int row) {
		StringBuilder b = new StringBuilder();
		for (int j = 0; j < board[row].length; j++) {
			b.append(board[row][j].toString());
		}
		return b.toString();
	}

}
