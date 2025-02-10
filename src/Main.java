import java.util.ArrayList;
import java.util.List;

import manager.FlowManager;
import surveys.Survey;
import surveys.types.LifeSatisfactionSurvey;
import surveys.types.LoveTypeSurvey;
import surveys.types.StressSurvey;

public class Main {
    public static void main(String[] args) {
        try {
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
        } catch (Survey.SurveyException e){
            System.err.println("설문지 불러오는데 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            System.exit(1);
        }
    }
}