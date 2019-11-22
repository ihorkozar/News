package com.mycompany.news.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.mycompany.news.utils.CustomTypeConverter;

import java.io.Serializable;
import java.util.List;

@Entity
public class News implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "newsId")
    private int newsId;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    private String status;

    @ColumnInfo(name = "totalResults")
    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("articles")
    @TypeConverters({CustomTypeConverter.class})
    private List<Article> articles;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public News(int newsId, String status, String totalResults, List<Article> articles) {
        this.newsId = newsId;
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
