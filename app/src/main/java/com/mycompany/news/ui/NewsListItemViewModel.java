package com.mycompany.news.ui;

import com.mycompany.news.data.model.News;

public class NewsListItemViewModel {
    private String status, author, title, description, url, urlToImage, publishedAt, content, name;

    public NewsListItemViewModel(News item) {
        status = item.getStatus();
    }

    public String getStatus() {
        return status;
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
