package baseball.model;

import java.util.List;

// 숫자야구 game을 진행하는 책임
public class Game {

    private final List<Integer> answerNums;
    private final Referee referee;

    public Game(List<Integer> answerNums, Referee referee) {
        this.answerNums = answerNums;
        this.referee = referee;
    }

    public String process(List<Integer> guessNumbers) {
        return referee.judge(answerNums, guessNumbers);
    }
}
