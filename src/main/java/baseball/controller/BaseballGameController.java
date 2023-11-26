package baseball.controller;

import baseball.Constant;
import baseball.Result;
import baseball.model.Computer;
import baseball.model.dto.UserInput;
import baseball.model.Referee;
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
        Referee referee = new Referee();

        processGame(referee, computer);
    }

    private void processGame(Referee referee, Computer computer) {
        String gameStatus = "";
        List<Integer> answerNumbers = computer.generate3Numbers();
        outputView.printStartMessage();
        while(!gameStatus.equals(Constant.END_NUM.get())) {
            List<Integer> validatedGuessNums = getValidatedGuessNums();
            String result = getResult(referee, answerNumbers, validatedGuessNums);
            outputView.pirntResult(result);
            if (result.equals(Result.STRIKE3.getString())) {
                outputView.printEndMessage();
                gameStatus = getGameStatus();
                answerNumbers = handleRestart(computer, gameStatus);
            }
        }
    }

    private List<Integer> getValidatedGuessNums() {
        outputView.printInputNumbersMessage();
        String input3Numbers = inputView.get3Numbers();
        UserInput.GuessNumbersDTO validatedInputNumbersDTO = new UserInput.GuessNumbersDTO(input3Numbers);
        return validatedInputNumbersDTO.toList();
    }

    private String getResult(Referee referee, List<Integer> answerNumbers, List<Integer> guessNumbers) {
        return referee.judge(answerNumbers, guessNumbers);
    }

    private String getGameStatus() {
        outputView.printRestartMessage();
        String isRestart = inputView.getIsRestart();
        UserInput.restartNumberDTO validatedRestartNumberDTO = new UserInput.restartNumberDTO(isRestart);
        return validatedRestartNumberDTO.getRestartNum();
    }

    private List<Integer> handleRestart(Computer computer, String gameStatus) {
        if (gameStatus.equals(Constant.RESTART_NUM.get())) {
            return computer.generate3Numbers();
        }
        return null;
    }
}
