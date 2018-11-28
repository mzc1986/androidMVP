package news.airweb.fr.aiwebdemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import news.airweb.fr.aiwebdemo.R;
import news.airweb.fr.aiwebdemo.models.News;
import news.airweb.fr.aiwebdemo.ui.DetailActivity;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    List<News> newsList;
    Context context;

    public NewsAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_news, parent, false);
        NewsHolder mh = new NewsHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(final NewsHolder holder, final int position) {

        holder.tvTitle.setText(newsList.get(position).getTitle());
        holder.tvContent.setText(newsList.get(position).getContent());
        Glide.with(context).load(newsList.get(position).getPicture()).into(holder.ivNews);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", newsList.get(position).getTitle());
                intent.putExtra("content", newsList.get(position).getContent());
                intent.putExtra("image_url", newsList.get(position).getPicture());

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvContent;
        ImageView ivNews;

        public NewsHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvContent = (TextView) v.findViewById(R.id.tvOverView);
            ivNews = (ImageView) v.findViewById(R.id.ivNews);
        }
    }
}
