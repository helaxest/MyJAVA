package com.Generic;

/**
 * Description
 *
 * @author helaxest
 * @date 2020/10/17  19:54
 * @mail:
 * @since JDK 1.8
 */
public class News <T1,T2,T3>{
    T1 title;
    T2 author;
    T3 types;

    public News() {
    }

    public News(T1 title, T2 author, T3 types) {
        this.title = title;
        this.author = author;
        this.types = types;
    }

    public T1 getTitle() {
        return title;
    }

    public void setTitle(T1 title) {
        this.title = title;
    }

    public T2 getAuthor() {
        return author;
    }

    public void setAuthor(T2 author) {
        this.author = author;
    }

    public T3 getTypes() {
        return types;
    }

    public void setTypes(T3 types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return  title +";" + types +";" +author;
    }
}
