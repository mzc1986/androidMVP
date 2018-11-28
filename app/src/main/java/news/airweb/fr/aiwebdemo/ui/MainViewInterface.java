package news.airweb.fr.aiwebdemo.ui;

import news.airweb.fr.aiwebdemo.models.Content;

public interface MainViewInterface {

    void showToast(String s);
    void showProgressBar();
    void hideProgressBar();
    void displayNews(Content newsResponse);
    void displayError(String s);
}
