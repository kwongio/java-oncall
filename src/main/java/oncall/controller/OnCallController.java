package oncall.controller;

import oncall.domain.Workers;
import oncall.dto.Result;
import oncall.dto.StartDate;
import oncall.service.OnCallService;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;

public class OnCallController {
    private final OnCallService onCallService;

    public OnCallController(OnCallService onCallService) {
        this.onCallService = onCallService;
    }

    public void run() {
        StartDate startDate = InputView.inputStartDate();
        List<String> weekdayNames = InputView.inputWeekDayNames();
        List<String> holidayNames = InputView.inputHolidayNames();

        Workers workers = Workers.createWorkers(weekdayNames, holidayNames);
        List<Result> results = onCallService.calculate(workers, startDate);
        OutputView.printResult(results);
    }
}
