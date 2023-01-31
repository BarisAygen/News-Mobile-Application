package edu.sabanciuniv.barisaygen;

import java.util.ArrayList;

public class MainNews {

    private ArrayList<ModelClass> articles;
    private String status, results;

    public MainNews(String status, String totalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.results = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
