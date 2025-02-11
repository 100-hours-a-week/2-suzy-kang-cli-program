package manager;

public class SurveyTimeManager {
    private static final int MIN_SECONDS_PER_QUESTION = 5;
    private final int minRecommendedSeconds;

    private Thread timeCountThread;
    private volatile int elapsedSeconds;
    private volatile boolean isRunning;
    private volatile boolean hasError;

    public SurveyTimeManager(int questionCount) {
        this.minRecommendedSeconds = questionCount * MIN_SECONDS_PER_QUESTION;
    }

    private class TimeCountThread extends Thread {
        @Override
        public void run() {
            try {
                elapsedSeconds = 0;
                isRunning = true;
                hasError = false;

                while (isRunning) {
                    Thread.sleep(1000);
                    elapsedSeconds++;
                }

                hasError = false;
            } catch (InterruptedException e) {
                if (isRunning) {
                    hasError = true;
                }
            }
        }
    }

    public void startTimeCount() {
        timeCountThread = new TimeCountThread();
        timeCountThread.start();
    }

    public void stopTimeCount() {
        isRunning = false;
        if (timeCountThread != null && timeCountThread.isAlive()){
            timeCountThread.interrupt();
        }
    }

    public SurveyTimeResult getTimeResult() {
        return new SurveyTimeResult(
                isTimeAdequate(),
                getFormattedTime(),
                minRecommendedSeconds,
                hasError
        );
    }

    private boolean isTimeAdequate() {
        return elapsedSeconds >= minRecommendedSeconds;
    }

    private String getFormattedTime() {
        int minutes = elapsedSeconds / 60;
        int seconds = elapsedSeconds % 60;

        if (minutes > 0) {
            return String.format("%d분 %d초", minutes, seconds);
        }
        return String.format("%d초", seconds);
    }
}
