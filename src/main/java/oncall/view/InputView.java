package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.StartDate;
import oncall.message.ErrorMessage;

import java.util.List;

public class InputView {

    public static StartDate inputStartDate() {
        return RetryInput.retry(InputView::getStartDate);
    }

    private static StartDate getStartDate() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
        String input = Console.readLine();
        List<String> list = List.of(input.split(","));
        try {
            int startMonth = Integer.parseInt(list.get(0));
            String dayOfWeek = list.get(1);
            if (!(startMonth >= 1 && startMonth <= 12)) {
                throw new IllegalArgumentException(ErrorMessage.MONTH_RANGE.getMessage());
            }

            return new StartDate(startMonth, dayOfWeek);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.MONTH_RANGE.getMessage());
        }
    }

    public static List<String> inputWeekDayNames() {
        return RetryInput.retry(InputView::getWeekdayNames);
    }

    public static List<String> inputHolidayNames() {
        return RetryInput.retry(InputView::getHolidayNames);
    }

    private static List<String> getWeekdayNames() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        return getNames();
    }

    private static List<String> getHolidayNames() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        return getNames();
    }

    private static List<String> getNames() {
        String input = Console.readLine();
        List<String> names = List.of(input.split(","));

        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATED.getMessage());
        }
        return names;
    }
}
