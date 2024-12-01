package oncall.service;

import oncall.domain.Holidays;
import oncall.domain.WorkDate;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.dto.Result;
import oncall.dto.StartDate;

import java.util.ArrayList;
import java.util.List;

public class OnCallService {


    public List<Result> calculate(Workers workers, StartDate startDate) {
        WorkDate workDate = WorkDate.createFrom(startDate);
        List<Result> results = new ArrayList<>();

        while (workDate.hasNextDay()) {
            Worker worker = workers.getNextWorker(workDate);
            Result result = new Result(startDate.startMonth(),
                    workDate.getDay(),
                    Holidays.isHoliday(workDate.getMonth(),
                    workDate.getDay()),
                    workDate.getDayOfWeek(),
                    worker.getName());
            results.add(result);
            worker.work();
            workDate.next();
        }

        return results;
    }
}
