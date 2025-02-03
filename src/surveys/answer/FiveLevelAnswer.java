package surveys.answer;

import surveys.Survey;

public abstract class FiveLevelAnswer extends Survey {

    protected FiveLevelAnswer(String surveyType) {
        super(surveyType);
    }

    @Override
    protected void displayAnswer() {
        System.out.println("각 문항에 1~5점으로 답해주세요.");
        System.out.println("(1: 전혀 아니다, 2: 아니다, 3: 보통이다, 4: 그렇다, 5: 매우 그렇다)");
    }

    @Override
    protected int getValidAnswer() {
        while (true) {
            try {
                String input = scanner.nextLine();
                int answer = Integer.parseInt(input);

                if (answer >= 1 && answer <= 5) return answer;
                else {
                    System.out.println("❌ 1부터 5 사이의 숫자를 다시 입력해주세요.");
                }
            } catch (NumberFormatException e){
                System.out.println("❌ 올바른 숫자를 입력하세요.");
            }
        }
    }
}
