package GuessGame;

public class Main {
    public static void main(String[] args) {

        int max = 100;

        GuessGame game = new GuessGame();
        for (int i = 0; i < 3; i++) {
            game.play(max);
        }
        game.printBestScore();
    }
}
