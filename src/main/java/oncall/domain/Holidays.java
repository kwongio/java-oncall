package oncall.domain;

public enum Holidays {
    NEW_YEAR(1, 1),
    INDEPENDENCE_MOVEMENT_DAY(3, 1),
    CHILDRENS_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    INDEPENDENCE_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    CHRISTMAS(12, 25);

    private final int month;
    private final int day;

    Holidays(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        for (Holidays value : Holidays.values()) {
            if (value.month == month && value.day == day) {
                return true;
            }
        }
        return false;
    }

}
