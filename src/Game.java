import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Game{

    private static Player playerOne;
    private static Player playerTwo;

    public static void main(String[] args) throws IOException{
        playerOne = new Human("1", Mark.CROSS);

        System.out.println("== T I C E P T I O N ==");
        System.out.println("Choose game mode: ");
        System.out.println("1 Human vs Human");
        System.out.println("2 Human vs AI");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int select = 0;
        while ((select != 1) && (select != 2)) {
            try {
                String inBuffer = in.readLine();

                select = Integer.parseInt(inBuffer);

            } catch (IOException e2) {
            }
        }

        if(select == 1){
            playerTwo = new Human("2", Mark.CIRCLE);
        } else {
            System.exit(0);
        }

        Tiception game = new Tiception();
        Player inTurn = playerOne;
        while(game.getWinner() == Mark.EMPTY){
            System.out.println(game.toString());
            while(!game.setMark(inTurn.getMove(game.getNext()), inTurn.getMark())){
                System.out.println("That position is taken!");
            }

            if(inTurn == playerOne) {
                inTurn = playerTwo;
            } else {
                inTurn = playerOne;
            }
        }

        System.out.println(game.toString());
        System.out.println("-- Game Over --");
        System.out.println("Winner is: " + game.getWinner());

    }
}