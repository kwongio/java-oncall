package oncall;

import oncall.controller.OnCallController;
import oncall.service.OnCallService;

public class Application {
    public static void main(String[] args) {
        OnCallController onCallController = new OnCallController(new OnCallService());
        onCallController.run();
    }
}
