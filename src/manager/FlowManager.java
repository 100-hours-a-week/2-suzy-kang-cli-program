package manager;

import java.util.List;
import java.util.Scanner;

import surveys.Survey;

public class FlowManager {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Survey> surveyList;
    private final int surveyLength;
    
    public boolean isRunning = true;

    public FlowManager(List<Survey> surveyList) {
        this.surveyList = surveyList;
        this.surveyLength = surveyList.size();
    }

    public void displayOpening(){
        displayLine();
        displayLine();
        System.out.println("          🧭 수지네 심리 탐험소       ");
        System.out.println();
        System.out.println("   나를 더 깊이 이해하는 시간을 가져보세요!");
        System.out.println();
        displayLine();
    }

    public void displayMenu(){
        displayLine();
        System.out.print("⭐심리 탐험 메뉴⭐\n\n");

        for (int i = 0; i <= surveyLength; i++) {
            int menuOption = i+1;
            if (surveyLength == i) {
                System.out.println(menuOption +". 종료");
                break;
            }

            surveyList.get(i).displayMenu(menuOption);
        }

        displayLine();
        System.out.println("\uD83D\uDCA1 Tip: 정직한 답변이 정확한 결과로 이어집니다!");
        displayLine();
    }

    public void play() {
        final int MENU_EXIT_OPTION = 1;
        final int TOTAL_MENU_OPTIONS = surveyLength + MENU_EXIT_OPTION;
        int selectedOption = getValidAnswer(TOTAL_MENU_OPTIONS);

        if(isExitSelectedMenu(selectedOption)) {
            displayExit();
            return;
        }

        surveyList.get(selectedOption-1).playSurvey();
    }

    public void displayEnding(){
        displayLine();
        System.out.println("오늘의 자기 이해 여정이 도움이 되셨길 바랍니다. 💝");
        displayLine();
        System.out.println("더 알고 싶은 이야기가 있나요?");
        System.out.println();
        System.out.println("1. 새로운 심리 탐험하기 🧭");
        System.out.println("2. 오늘의 여정 마치기 \uD83D\uDC4B\uD83C\uDFFB");
        displayLine();

        int selectedOption = getValidAnswer(2);

        if(selectedOption ==2) {
            displayExit();
        }
    }

    private void displayLine(){
        System.out.println("---------------------------------------");
    }

    private void displayExit() {
        System.out.println("\uD83D\uDC4B\uD83C\uDFFB 프로그램을 종료합니다.");
        isRunning = false;
        System.exit(0);
    }

    private int getValidAnswer(int maxAnswer) {
        while (true) {
            try {
                String input = scanner.nextLine();
                int answer = Integer.parseInt(input);

                if (answer >= 1 && answer <= maxAnswer) return answer;
                else {
                    System.out.println("❌ 1부터 "+maxAnswer+" 사이의 숫자를 다시 입력해주세요.");
                }
            } catch (NumberFormatException e){
                System.out.println("❌ 올바른 숫자를 입력하세요.");
            }
        }
    }

    private boolean isExitSelectedMenu(int selectedOption) {
        return selectedOption - 1 == surveyLength;
    }

}
