package surveys;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import static java.lang.System.exit;


public abstract class Survey {
    public static class SurveyException extends RuntimeException {
        public SurveyException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    protected final Scanner scanner = new Scanner(System.in);
    protected String type;
    protected String[] questions;
    protected int questionLength;
    protected int[] answers;

    protected Survey(String surveyType) {
        type = surveyType;
        try {
            questions = parseQuestion();
            questionLength = questions.length;
            answers = new int[questionLength];
        } catch (FileNotFoundException e) {
            throw new SurveyException("설문지 초기화 실패", e);
        }
    }

    public void playSurvey() {
        displayTitle();
        displayAnswer();
        System.out.println();
        selectSurvey();
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        displayResult();
    }

    public abstract void displayMenu(int menuNumber);

    protected abstract void displayTitle();

    protected abstract void displayAnswer();

    protected abstract void displayResult();

    protected  abstract int getValidAnswer();

    protected void saveAnswer(int questionIndex,int answer) {
        answers[questionIndex] = answer;
    }

    protected int totalAnswerScore() {
        int score = 0;
        for (int answer: answers){
            score += answer;
        }

        return score;
    }

    protected void selectSurvey() {
        for (int i = 0; i < questionLength; i++) {
            System.out.println(i + 1 + "." + questions[i]);
            int answer = getValidAnswer();

            saveAnswer(i, answer);
        }
    }

    protected String[] parseQuestion() throws FileNotFoundException {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("src/surveys/types/surveys.json");
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            JsonArray questions = jsonObject
                    .getAsJsonObject("surveys")
                    .getAsJsonObject(type)
                    .getAsJsonArray("questions");

            String[] questionArray = new String[questions.size()];

            for(int i =0; i < questions.size(); i++) {
                questionArray[i] = questions.get(i).getAsJsonObject().get("question").getAsString();
            }

            return questionArray;

        } catch (FileNotFoundException e) {
            throw new SurveyException("설문 데이터 읽기 실패", e);
        }

    }

}
