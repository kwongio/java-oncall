package oncall.view;

import oncall.dto.Result;

import java.util.List;

public class OutputView {


    public static void printResult(List<Result> results) {
        for (Result result : results) {
            printDate(result);
            printName(" " + result.name());
        }
    }

    private static void printDate(Result result) {
        System.out.printf("%d월 %d일 %s", result.month(), result.day(), result.dayOfWeek());
        if (result.isHoliday()) {
            System.out.print("(휴일)");
        }
    }

    private static void printName(String name) {
        System.out.println(name);
    }
}
