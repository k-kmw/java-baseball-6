package baseball;

public enum Result {
    ZERO("낫씽"), STRIKE3("3스트라이크");

    private final String result;

    Result(String result) {
        this.result = result;
    }

    public String getString() {
        return result;
    }
}
