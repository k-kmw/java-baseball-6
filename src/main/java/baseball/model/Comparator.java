package baseball.model;

import java.util.List;

// 예측한 숫자와 정답을 비교하는 책임
public class Comparator {
    public Integer calculateBallCount(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        int ballCount = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            for (int j = 0; j < answerNumbers.size(); j++) {
                if (i == j) continue;
                if(inputNumbers.get(i).equals(answerNumbers.get(j))) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public Integer calculateStrikeCount(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        int strikeCount = 0;
        int idx = 0;
        while (idx < answerNumbers.size()) {
            if(answerNumbers.get(idx).equals(inputNumbers.get(idx))) {
                strikeCount++;
            }
            idx++;
        }
        return strikeCount;
    }
}
