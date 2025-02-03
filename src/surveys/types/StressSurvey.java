package surveys.types;

import surveys.answer.ThreeLevelAnswer;

public class StressSurvey extends ThreeLevelAnswer {

    public StressSurvey(){
        super("Stress");
    }

    @Override
    public void displayMenu(int menuNumber) {
        System.out.println(menuNumber+". 스트레스 검사 (" + questionLength + "문항)");
    }

    @Override
    protected void displayTitle() {
        System.out.println("\uD83C\uDF0A 당신의 스트레스 수준을 체크해보세요!");
    }

    @Override
    protected void displayResult() {
        System.out.println("📊 스트레스 진단 결과");
        System.out.println();

        int score = totalAnswerScore();

        if (score <= 7) {
            displayHealthyState();
        } else if (score <= 11) {
            displayCautionState();
        } else {
            displayDangerState();
        }
    }

    private void displayHealthyState() {
        System.out.println("\uD83D\uDE0A 건강한 상태");
        System.out.println("- 스트레스가 잘 관리되고 있어요.");
        System.out.println("- 현재의 컨디션을 유지해보세요.");
    }

    private void displayCautionState() {
        System.out.println("\uD83D\uDE2F 주의 단계");
        System.out.println("- 약간의 스트레스가 쌓여있어요.");
        System.out.println("- 간단한 스트레스 해소가 필요해요.");
    }

    private void displayDangerState() {
        System.out.println("\uD83D\uDE28 위험 단계");
        System.out.println("- 스트레스가 높은 상태에요.");
        System.out.println("- 적극적인 관리가 필요해요 🌱");
    }
}
