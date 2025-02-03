package surveys.answer;
import surveys.Survey;

public abstract class ThreeLevelAnswer extends Survey {

    protected ThreeLevelAnswer(String surveyType) {
        super(surveyType);
    }

    @Override
    protected void displayAnswer() {
        System.out.println("각 문항에 1~3점으로 답해주세요.");
        System.out.println("(1: 아니다, 2: 보통이다, 3: 그렇다)");
    }

    @Override
    protected int getValidAnswer() {
        while (true) {
            try {
                String input = scanner.nextLine();
                int answer = Integer.parseInt(input);

                if (answer >= 1 && answer <= 3) return answer;
                else {
                    System.out.println("❌ 1부터 3 사이의 숫자를 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력하세요.");
            }
        }
    }
}
