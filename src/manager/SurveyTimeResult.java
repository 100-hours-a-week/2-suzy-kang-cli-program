package manager;

public class SurveyTimeResult {
    private final boolean isTimeAdequate;
    private final String formattedTime;
    private final int recommendedSeconds;
    private final boolean hasError;

    public SurveyTimeResult(boolean isTimeAdequate,
                            String formattedTime, int recommendedSeconds, boolean hasError) {
        this.isTimeAdequate = isTimeAdequate;
        this.formattedTime = formattedTime;
        this.recommendedSeconds = recommendedSeconds;
        this.hasError = hasError;
    }

    public boolean isTimeAdequate() {
        return isTimeAdequate;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public int getRecommendedSeconds() {
        return recommendedSeconds;
    }

    public boolean hasError() {
        return hasError;
    }
}