package GuessGame;

import javax.swing.*;
import java.util.Random;

public class GuessGame {
    int bestScore;

    public void play(int max){

        Random rand = new Random();
        int randNum = rand.nextInt(max);
        int count = 1;

        String answer = JOptionPane.showInputDialog("Pleas guess a number between 0 and " + max);
        int result = Integer.parseInt(answer);
        while (result != randNum){
            if(result < randNum){
                answer = JOptionPane.showInputDialog("Larger");
            }
            else {
                answer = JOptionPane.showInputDialog("Smaller");
            }
            result = Integer.parseInt(answer);
            count++;
        }
        int score = max/count;
        if(score > bestScore){
            bestScore = score;
        }
    }

    public void printBestScore() {
        System.out.println("The best score is: " + bestScore);
    }
}
