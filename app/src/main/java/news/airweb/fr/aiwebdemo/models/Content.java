package news.airweb.fr.aiwebdemo.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("news")
    @Expose
    private List<News> news = null;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

}
