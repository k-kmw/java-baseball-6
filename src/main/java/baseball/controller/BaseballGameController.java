package baseball.controller;

import baseball.model.Computer;
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
        // 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
        Computer computer = new Computer();
        List<Integer> answerNumbers = computer.generate3Numbers();

        outputView.printStartMessage();

        while(true) {

            outputView.printInputNumbersMessage();
            List<Integer> inputNumbers = inputView.get3Numbers();

            Referee referee = new Referee();
            String result = referee.judge(answerNumbers, inputNumbers);

            System.out.println(answerNumbers);
            outputView.pirntResult(result);

            if (result.equals("3스트라이크")) {
                outputView.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                outputView.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String isRestart = inputView.getIsRestart();
                if (isRestart.equals("1")) {
                    answerNumbers = computer.generate3Numbers();
                    continue;
                }
                break;
            }
        }
    }
}
