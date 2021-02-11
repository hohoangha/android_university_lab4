package com.codepath.recyclerviewlab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.recyclerviewlab.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleResultsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Article> articleList = new ArrayList<>();;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_article_result, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);
        ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
        articleViewHolder.bind(article);
    }

    // This method clears the existing dataset and adds new articles
    void setNewArticles(List<Article> articles) {
        articleList.clear();
        articleList.addAll(articles);
    }

    // This method adds all articles to the existing dataset
    void addArticles(List<Article> articles) {
        articleList.addAll(articles);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView tvArticlePubDate;
        TextView tvArticleHeadline;
        TextView tvArticleSnippet;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvArticlePubDate = itemView.findViewById(R.id.article_pub_date);
            tvArticleHeadline = itemView.findViewById(R.id.article_headline);
            tvArticleSnippet = itemView.findViewById(R.id.article_snippet);
        }

        public void bind(Article article) {
            tvArticlePubDate.setText(article.publishDate);
            tvArticleHeadline.setText(article.headline.main);
            tvArticleSnippet.setText(article.snippet);
        }
    }
}
