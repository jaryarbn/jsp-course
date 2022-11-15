package com.github.jaryarbn;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;

public class BookShopBean {
    private String submit;
    private String item;
    ArrayList<String> arrayList = new ArrayList<>();

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    private void addItem(String item) {
        arrayList.add(item);
    }

    public ArrayList<String> getItems() {
        return arrayList;
    }

    public void processRequest(HttpServletRequest request) {
        if (submit == null) {
            reset();
        } else {
            addItem(item);
        }
    }

    private void reset() {
        setSubmit(null);
        setItem(null);
    }
}
