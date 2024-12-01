package oncall.domain;

public enum Month {

    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    private final int month;
    private final int days;

    Month(int month, int days) {
        this.month = month;
        this.days = days;
    }


    public static int getDays(int month) {
        for (Month value : Month.values()) {
            if (value.month == month) {
                return value.days;
            }
        }
        return -1;
    }
}
