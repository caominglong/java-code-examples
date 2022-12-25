package com.banmao.advanced_grammar.collections.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/26 上午11:20
 * @description
 */
public class HomeWork01 {

    public static void main(String[] args) {
        News news1 = new News("新闻一, wwasdassssafafagagaasddd");
        News news2 = new News("新闻二");

        List<News> news = new ArrayList<>();
        news.add(news1);
        news.add(news2);

        // 倒序遍历
        for (int i = news.size() - 1; i >= 0; i--) {
            System.out.println(processTitle(news.get(i).getTitle()));
        }
    }

    private static String processTitle(String title) {
        if (title == null) {
            return "";
        }

        if (title.length() > 15) {
            // substring是前闭后开
            return title.substring(0 ,15) + "...";
        }
        return title;
    }
}


class News {

    public News(String title) {
        this.title = title;
    }

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}