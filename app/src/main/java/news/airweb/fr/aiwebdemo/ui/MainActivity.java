package news.airweb.fr.aiwebdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.airweb.fr.aiwebdemo.R;
import news.airweb.fr.aiwebdemo.adapters.NewsAdapter;
import news.airweb.fr.aiwebdemo.models.Content;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().hide();

        mainPresenter = new MainPresenter(this);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter.getNews();

    }

    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayNews(Content contentResponse) {
        if (contentResponse != null) {
            adapter = new NewsAdapter(contentResponse.getNews(), MainActivity.this);
            rvNews.setAdapter(adapter);
        } else {
            Log.d(TAG, "Movies response null");
        }
    }

    @Override
    public void displayError(String e) {
        showToast(e);
    }
}
