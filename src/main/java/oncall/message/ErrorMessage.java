package oncall.message;

public enum ErrorMessage {
    MONTH_RANGE("월은 1에서 12사이의 값으로 입력해야 합니다."),
    DAY_OF_WEEK_RANGE("요일은 월, 화, 수, 목, 금, 토, 일 중 하나로 입력해야 합니다."),
    NAME_DUPLICATED("근무자 순번에 같은 근무자가 두번 이상 포함될 수 없습니다.");


    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
