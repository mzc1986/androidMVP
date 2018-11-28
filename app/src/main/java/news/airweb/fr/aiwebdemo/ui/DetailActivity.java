package news.airweb.fr.aiwebdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.airweb.fr.aiwebdemo.R;

public class DetailActivity extends AppCompatActivity {


    @BindView(R.id.title)
    TextView tvTitle;

    @BindView(R.id.description)
    TextView tvDescription;

    @BindView(R.id.ivContent)
    ImageView imageView;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        String title = getIntent().getExtras().getString("title");
        String content = getIntent().getExtras().getString("content");
        String imageUrl = getIntent().getExtras().getString("image_url");

        Glide.with(this).load(imageUrl).into(imageView);
        tvTitle.setText(title);
        tvDescription.setText(content);
    }

}