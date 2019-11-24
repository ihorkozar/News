package com.mycompany.news.ui;

import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;
import com.mycompany.news.utils.DateFormat;

import java.util.List;

public class NewsListItemViewModel {
    private String author, title, description, url, urlToImage, publishedAt, content;
    private String name, id;
    private int article_id;


    public NewsListItemViewModel(Article item) {
        author = item.getAuthor();
        title = item.getTitle();
        description = item.getDescription();
        urlToImage = item.getUrlToImage();
        url = item.getUrl();
        publishedAt = DateFormat.DateFormat(item.getPublishedAt());
        content = item.getContent();
        name = item.getSource().getName();
        id = item.getSource().getId();
        article_id = item.getArticle_id();
    }


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getArticle_id() {
        return article_id;
    }
}
