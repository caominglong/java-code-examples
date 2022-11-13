package com.banmao.advanced_grammar.collections.list_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/11 下午7:33
 * @description
 */
public class CollectionIterator {

    public static void main(String[] args) {

        Collection col = new ArrayList();
        ((ArrayList) col).add(new Book("book1", "111", 100));
        ((ArrayList) col).add(new Book("book2", "222", 200));
        ((ArrayList) col).add(new Book("book3", "333", 300));
        ((ArrayList) col).add("100");
        // 1、先得到col的迭代器
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            // Book book = (Book) next;
            System.out.println("obj=" + obj);
        }

        // 重要：2、如果需要再次遍历，需要重置迭代器
        Iterator iterator1 = col.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println("obj2=" + next);
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}