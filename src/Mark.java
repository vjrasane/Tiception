
public enum Mark {

    EMPTY('*'), CROSS('X'), CIRCLE('O');

    private char symbol;

    private Mark(char symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return Character.toString(symbol);
    }

}
