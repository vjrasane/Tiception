import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

public class Tiception {

    private TicTacToe[][] small_games = new TicTacToe[3][3];
    private Mark winner = Mark.EMPTY;
    private AbstractMap.SimpleEntry<Coordinates, Coordinates> previous = null;
    private Coordinates next = null;

    public Tiception() {
        for (int i = 0; i < small_games.length; i++) {
            for (int j = 0; j < small_games[i].length; j++) {
                small_games[i][j] = new TicTacToe();
            }
        }
    }

    public Coordinates getNext() {
        return next;
    }

    public void setNext(Coordinates next) {
        this.next = next;
    }

    public boolean setMark(int xGame, int yGame, int x, int y, Mark m) {
        if(small_games[xGame][yGame].getMark(x, y) != Mark.EMPTY) {
            return false;
        }

        small_games[xGame][yGame].setMark(x, y, m);
        previous = new AbstractMap.SimpleEntry<Coordinates, Coordinates>(new Coordinates(xGame, yGame),
                new Coordinates(x, y));
        if(!small_games[xGame][yGame].isFull()) {
            next = new Coordinates(x, y);
        }
        return true;
    }

    public Mark getWinner() {
        if (this.winner == Mark.EMPTY) {
            this.winner = checkWinner();
        }
        return winner;
    }

    private Mark checkWinner() {
        for (int i = 0; i < small_games.length; i++) {
            Mark m = small_games[i][0].getWinner();
            if (m != Mark.EMPTY) {
                boolean win = true;
                for (int j = 1; j < small_games[i].length; j++) {
                    if (small_games[i][j].getWinner() != m) {
                        win = false;
                        break;
                    }
                }

                if (win) {
                    return m;
                }
            }
        }

        for (int j = 0; j < small_games.length; j++) {
            Mark m = small_games[0][j].getWinner();
            if (m != Mark.EMPTY) {
                boolean win = true;
                for (int i = 1; i < small_games[j].length; i++) {
                    if (small_games[i][j].getWinner() != m) {
                        win = false;
                        break;
                    }
                }

                if (win) {
                    return m;
                }
            }

        }

        Mark m = small_games[0][0].getWinner();
        if (m != Mark.EMPTY) {
            boolean win = true;
            for (int i = 1; i < small_games.length; i++) {
                if (small_games[i][i].getWinner() != m) {
                    win = false;
                    break;
                }
            }

            if (win) {
                return m;
            }
        }

        m = small_games[0][small_games.length - 1].getWinner();
        if (m != Mark.EMPTY) {
            boolean win = true;
            for (int i = 1; i < small_games.length; i++) {
                if (small_games[i][small_games.length - 1 - i].getWinner() != m) {
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
        for (int i = 0; i < small_games.length; i++) {
            for (int j = 0; j < small_games[i].length; j++) {
                if (small_games[i][j].getWinner() == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < small_games.length; i++) {
            for (int row = 0; row < 3; row++) {
                for (int j = 0; j < small_games[i].length; j++) {
                    b.append(small_games[i][j].toString(row));
                    if (j < (small_games[i].length - 1)) {
                        b.append("|");
                    } else {
                        b.append("\n");
                    }

                }
            }

            if (i < (small_games.length - 1)) {
                for (int j = 0; j < small_games[i].length; j++) {
                    b.append("--- ");
                }
                b.append("\n");
            } else {
                b.append("\n");
            }
        }
        return b.toString();
    }

    public boolean setMark(SimpleEntry<Coordinates, Coordinates> move, Mark m) {
        return this.setMark(move.getKey().getX(), move.getKey().getY(), move.getValue().getX(), move.getValue().getY(), m);
    }

}
