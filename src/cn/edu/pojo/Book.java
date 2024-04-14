package cn.edu.pojo;

import java.io.Serializable;

//书籍对象序列化
public class Book implements Serializable {
    //属性
    private int num;
    private String name;
    private String author;

    //构造器
    public Book() {
    }

    public Book(int num, String name, String author) {
        this.num = num;
        this.name = name;
        this.author = author;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

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
}
