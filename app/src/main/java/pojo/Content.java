package pojo;

import org.litepal.crud.DataSupport;

public class Content extends DataSupport {
    private String title;
    private String word;
    private String creatTime;

    public Content(String title, String word, String creatTime) {
        this.title = title;
        this.word = word;
        this.creatTime = creatTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }
}
