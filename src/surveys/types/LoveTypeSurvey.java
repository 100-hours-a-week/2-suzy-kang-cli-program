package surveys.types;

import java.util.ArrayList;
import java.util.List;

import surveys.answer.FiveLevelAnswer;

public class LoveTypeSurvey extends FiveLevelAnswer {
    public LoveTypeSurvey(){
        super("LoveType");
    }

    @Override
    public void displayMenu(int menuNumber) {
        System.out.println(menuNumber+". 연애 성향 분석 (" + questionLength + "문항)");
    }

    @Override
    protected void displayTitle() {
        System.out.println("\uD83D\uDC98 나의 연애 유형은 무엇일까요?");
    }

    @Override
    protected void displayResult() {
        System.out.println("📊 연애 성향 분석 결과");
        System.out.println();

        int anxious = calculateAnxiousScore();    // 불안형
        int avoidant = calculateAvoidantScore();  // 회피형
        int disorganized = calculateDisorganizedScore(); // 혼란형

        List<String> mainTypes = determineMainTypes(anxious, avoidant, disorganized);

        if (isSecureType(anxious, avoidant, disorganized)) {
            displaySecureType();
        } else {
            if(mainTypes.size() > 1) {
                displayDisorganizedType();
            } else {
                switch (mainTypes.getFirst()) {
                    case "anxious" -> displayAnxiousType();
                    case "avoidant" -> displayAvoidantType();
                    case "disorganized" -> displayDisorganizedType();
                }
            }
        }
    }

    private int calculateAnxiousScore() {
        return answers[0] + answers[4] + answers[5] + answers[6];
    }

    private int calculateAvoidantScore() {
        return answers[2] + answers[7] + answers[8];
    }

    private int calculateDisorganizedScore() {
        return answers[1] + answers[3] + answers[9];
    }

    private List<String> determineMainTypes(int anxious, int avoidant, int disorganized) {
        List<String> mainTypes = new ArrayList<>();
        int maxScore = Math.max(Math.max(anxious, avoidant), disorganized);

        if (anxious == maxScore) mainTypes.add("anxious");
        if (avoidant == maxScore) mainTypes.add("avoidant");
        if (disorganized == maxScore) mainTypes.add("disorganized");

        return mainTypes;
    }

    private boolean isSecureType(int anxious, int avoidant, int disorganized) {
        return anxious <= 15 && avoidant <= 15 && disorganized <= 15;
    }

    private void displaySecureType() {
        System.out.println("💖 안정형");
        System.out.println("- 건강한 자존감과 신뢰를 바탕으로 한 관계 형성");
        System.out.println("- 균형 잡힌 친밀감과 독립성 유지");
        System.out.println("- 솔직한 감정 표현과 효과적인 의사소통");
        System.out.println("- 갈등 상황에서 합리적 해결 추구");
        System.out.println("추천 TIP: 현재의 건강한 패턴을 유지하세요!");
    }

    private void displayAnxiousType() {
        System.out.println("😰 불안형");
        System.out.println("- 상대방의 사랑을 확인받고 싶어함");
        System.out.println("- 버림받는 것에 대한 두려움");
        System.out.println("- 과도한 집착과 소유욕");
        System.out.println("- 관계에 대한 불안감이 높음");
        System.out.println("추천 TIP: 자신의 가치를 인정하고 자존감을 높이세요.");
    }

    private void displayAvoidantType() {
        System.out.println("🏃 회피형");
        System.out.println("- 친밀한 관계 형성을 어려워함");
        System.out.println("- 정서적 거리두기를 선호");
        System.out.println("- 독립성과 자유를 중시");
        System.out.println("- 감정 표현에 서툼");
        System.out.println("추천 TIP: 조금씩 마음을 열어보는 연습을 해보세요.");
    }

    private void displayDisorganizedType() {
        System.out.println("😵 혼란형");
        System.out.println("- 감정 기복이 심함");
        System.out.println("- 관계에 대한 양가감정");
        System.out.println("- 일관성 없는 행동 패턴");
        System.out.println("- 과거 경험에 영향을 많이 받음");
        System.out.println("추천 TIP: 현재에 집중하고 안정적인 패턴을 만들어보세요.");
    }
}
