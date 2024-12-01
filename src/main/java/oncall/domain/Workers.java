package oncall.domain;

import oncall.dto.CandidateWorker;

import java.util.ArrayList;
import java.util.List;

public class Workers {

    private final List<Worker> weekdayWorkers;
    private final List<Worker> holidayWorkers;
    private Worker preWorker;

    public Workers(List<Worker> weekdayWorkers, List<Worker> holidayWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.holidayWorkers = holidayWorkers;
    }

    public static Workers createWorkers(List<String> weekdayNames, List<String> holidayNames) {
        List<Worker> weekdayWorkers = makeCycle(weekdayNames).stream()
                .map(Worker::new)
                .toList();

        List<Worker> holidayWorkers = makeCycle(holidayNames).stream()
                .map(Worker::new)
                .toList();
        return new Workers(weekdayWorkers, holidayWorkers);
    }

    private static List<String> makeCycle(List<String> names) {
        List<String> resultNames = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            resultNames.add(names.get(i % names.size()));
        }
        return resultNames;
    }
    public Worker getNextWorker(WorkDate workDate) {
        CandidateWorker candidateWorker = getNextCandidateWorkers(workDate);
        if (candidateWorker.mainWorker().equals(preWorker)) {
            preWorker = candidateWorker.subWorker();
            return candidateWorker.subWorker();
        }
        preWorker = candidateWorker.mainWorker();
        return candidateWorker.mainWorker();
    }

    private CandidateWorker getNextCandidateWorkers(WorkDate workDate) {
        if (workDate.isHoliday()) {
            List<Worker> holidayWorkers = pickNextHolidayCandidate();
            return new CandidateWorker(holidayWorkers.get(0), holidayWorkers.get(1));
        }

        List<Worker> weekdayWorkers = pickNextWeekdayCandidate();
        return new CandidateWorker(weekdayWorkers.get(0), weekdayWorkers.get(1));
    }

    private List<Worker> pickNextHolidayCandidate() {
        return holidayWorkers.stream().filter(worker -> !worker.isWorked()).limit(2).toList();
    }

    private List<Worker> pickNextWeekdayCandidate() {
        return weekdayWorkers.stream().filter(worker -> !worker.isWorked()).limit(2).toList();
    }
}
