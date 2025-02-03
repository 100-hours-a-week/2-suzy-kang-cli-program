import java.util.ArrayList;
import java.util.List;

import manager.FlowManager;
import surveys.Survey;
import surveys.types.LifeSatisfactionSurvey;
import surveys.types.LoveTypeSurvey;
import surveys.types.StressSurvey;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Survey> surveyList = new ArrayList<>();
        surveyList.add(new LifeSatisfactionSurvey());
        surveyList.add(new LoveTypeSurvey());
        surveyList.add(new StressSurvey());
        FlowManager flowManager = new FlowManager(surveyList);

        flowManager.displayOpening();

        while (flowManager.isRunning) {
            flowManager.displayMenu();
            flowManager.play();
            flowManager.displayEnding();
        }
    }
}