package pojo;

public class MainContent {
    private String mainContentTitle;
    private String mainDate;

    public MainContent(String mainContentTitle, String mainDate) {
        this.mainContentTitle = mainContentTitle;
        this.mainDate = mainDate;
    }

    public String getMainContentTitle() {
        return mainContentTitle;
    }

    public void setMainContentTitle(String mainContentTitle) {
        this.mainContentTitle = mainContentTitle;
    }

    public String getMainDate() {
        return mainDate;
    }

    public void setMainDate(String mainDate) {
        this.mainDate = mainDate;
    }
}
