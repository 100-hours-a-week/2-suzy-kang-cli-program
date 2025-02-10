package surveys.types;

import surveys.answer.FiveLevelAnswer;

public class LifeSatisfactionSurvey extends FiveLevelAnswer {

    private static final int SATISFACTION_SCORE_VERY_LOW = 20;
    private static final int SATISFACTION_SCORE_LOW = 30;
    private static final int SATISFACTION_SCORE_MODERATE = 40;
    private static final int SATISFACTION_SCORE_HIGH = 45;

    public LifeSatisfactionSurvey(){
        super("LifeSatisfaction");
    }

    @Override
    public void displayMenu(int menuNumber) {
        System.out.println(menuNumber+". 라이프 만족도 검사 (" + questionLength + "문항)");
    }

    @Override
    protected void displayTitle() {
        System.out.println("\uD83D\uDCCA 나의 삶의 만족도는 어느 정도일까요?");
    }

    @Override
    protected void displayResult() {
        System.out.println("📊 삶의 만족도 검사 결과");
        System.out.println();

        int score = totalAnswerScore();

        if (score <= SATISFACTION_SCORE_VERY_LOW) {
            displayVeryLowSatisfaction();
        } else if (score <= SATISFACTION_SCORE_LOW) {
            displayLowSatisfaction();
        } else if (score <= SATISFACTION_SCORE_MODERATE) {
            displayModerateSatisfaction();
        } else if (score <= SATISFACTION_SCORE_HIGH) {
            displayHighSatisfaction();
        } else {
            displayVeryHighSatisfaction();
        }
    }

    private void displayVeryLowSatisfaction() {
        System.out.println("\uD83D\uDD34 매우 낮은 만족도");
        System.out.println("- 현재 삶에서 큰 변화가 필요해 보여요. ✨");
        System.out.println("- 전문가와 상담을 고려해보는 것은 어떨까요? 🤝");
    }

    private void displayLowSatisfaction() {
        System.out.println("\uD83D\uDFE1 낮은 만족도");
        System.out.println("- 일상에서 작은 즐거움을 찾아보세요. ✨");
        System.out.println("- 당신의 강점을 발견하고 발전시켜보세요. 💪");
    }

    private void displayModerateSatisfaction() {
        System.out.println("⚪ 보통 만족도");
        System.out.println("- 대체로 안정적인 삶을 살고 있네요. 👍");
        System.out.println("- 더 높은 만족감을 위한 작은 도전을 시작해보세요. 🌱");
    }

    private void displayHighSatisfaction() {
        System.out.println("\uD83D\uDD35 높은 만족도");
        System.out.println("- 매우 긍정적인 삶을 살고 계시네요! ⭐");
        System.out.println("- 현재의 생활 패턴을 잘 유지해보세요. 🌈");
    }

    private void displayVeryHighSatisfaction() {
        System.out.println("💚 매우 높은 만족도");
        System.out.println("- 최상의 삶의 만족도를 보이고 있어요! 🎉");
        System.out.println("- 주변 사람들과 행복을 나누어보세요. 🤗");
    }

}
