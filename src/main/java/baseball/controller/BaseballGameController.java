package baseball.controller;

import baseball.Constant;
import baseball.Result;
import baseball.model.Comparator;
import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.Referee;
import baseball.model.dto.UserInput;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Computer computer = new Computer();
        Game game = createGame(computer);
        String gameStatus = "";
        outputView.printStartMessage();
        while (!gameStatus.equals(Constant.END_NUM.get())) {
            List<Integer> validatedGuessNums = getValidatedGuessNums();
            String result = game.process(validatedGuessNums);
            outputView.pirntResult(result);
            if (result.equals(Result.STRIKE3.getString())) {
                outputView.printEndMessage();
                gameStatus = getGameStatus();
                game = handleRestartGame(computer, game, gameStatus);
            }
        }
    }

    private Game createGame(Computer computer) {
        Referee referee = new Referee(new Comparator());
        List<Integer> answerNums = computer.generate3Numbers();
        return new Game(answerNums, referee);
    }

    private List<Integer> getValidatedGuessNums() {
        outputView.printInputNumbersMessage();
        String input3Numbers = inputView.get3Numbers();
        UserInput.GuessNumbersDTO validatedInputNumbersDTO = new UserInput.GuessNumbersDTO(input3Numbers);
        return validatedInputNumbersDTO.toList();
    }

    private String getGameStatus() {
        outputView.printRestartMessage();
        String restartOrQuit = inputView.getIsRestart();
        UserInput.restartNumberDTO validatedRestartNumberDTO = new UserInput.restartNumberDTO(restartOrQuit);
        return validatedRestartNumberDTO.getRestartNum();
    }

    private Game handleRestartGame(Computer computer, Game game, String gameStatus) {
        List<Integer> answerNums;
        if (gameStatus.equals(Constant.RESTART_NUM.get())) {
            answerNums = computer.generate3Numbers();
            game = new Game(answerNums, new Referee(new Comparator()));
        }
        return game;
    }
}
