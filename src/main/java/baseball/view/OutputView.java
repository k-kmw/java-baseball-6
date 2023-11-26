package baseball.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputNumbersMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void print(String s) {
        System.out.println(s);
    }

    public void pirntResult(String result) {
        System.out.println(result);
    }
}
