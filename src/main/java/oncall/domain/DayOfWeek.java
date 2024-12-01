package oncall.domain;

public enum DayOfWeek {

    MON(0, "월"),
    TUE(1, "화"),
    WED(2, "수"),
    THU(3, "목"),
    FRI(4, "금"),
    SAT(5, "토"),
    SUN(6, "일");


    private final int day;
    private final String korDay;

    DayOfWeek(int day, String korDay) {
        this.day = day;
        this.korDay = korDay;
    }

    public static int getDay(String korDay) {
        for (DayOfWeek value : DayOfWeek.values()) {
            if (value.korDay.equals(korDay)) {
                return value.day;
            }
        }
        return -1;
    }

    public static String getKorDay(int day) {
        for (DayOfWeek value : DayOfWeek.values()) {
            if (value.day == day) {
                return value.korDay;
            }
        }
        return null;
    }
}
