package baseball;

public enum Constant {
    RESTART_NUM("1"), END_NUM("2");

    private final String constant;

    Constant(String constant) {
        this.constant = constant;
    }

    public String get() {
        return constant;
    }
}
