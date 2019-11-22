package com.mycompany.news.ui;

import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;

import java.util.List;

public class NewsListItemViewModel {
    private String author, title, description, url, urlToImage, publishedAt, content, name;

    public NewsListItemViewModel(Article item) {
        author = item.getAuthor();
        title = item.getTitle();
        description = item.getDescription();
        urlToImage = item.getUrlToImage();

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

}
