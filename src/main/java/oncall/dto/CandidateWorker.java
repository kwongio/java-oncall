package oncall.dto;

import oncall.domain.Worker;

public record CandidateWorker(Worker mainWorker, Worker subWorker) {
}
