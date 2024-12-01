package oncall.domain;

import oncall.dto.StartDate;

public class WorkDate {

    private int month;
    private int day;
    private int dayOfWeek;
    private int endDay;

    private WorkDate(int month, int dayOfWeek, int endDay) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.endDay = endDay;
        this.day = 1;
    }

    public static WorkDate createFrom(StartDate startDate) {
        int month = startDate.startMonth();
        int dayOfWeek = DayOfWeek.getDay(startDate.dayOfWeek());
        int endDay = Month.getDays(startDate.startMonth());
        return new WorkDate(month, dayOfWeek, endDay);
    }

    public boolean isHoliday() {
        return dayOfWeek == 5 || dayOfWeek == 6 || Holidays.isHoliday(month, day);
    }

    public boolean hasNextDay() {
        return day <= endDay;
    }

    public void next() {
        day++;
        dayOfWeek = ++dayOfWeek % 7;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return DayOfWeek.getKorDay(dayOfWeek);
    }

    public int getMonth() {
        return month;
    }

    public int getEndDay() {
        return endDay;
    }

    @Override
    public String toString() {
        return month + "월 " + day + "일";
    }
}
