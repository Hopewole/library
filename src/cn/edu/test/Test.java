package cn.edu.test;

import cn.edu.pojo.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zjk
 * @date 2023.1.8
 * @version 1.2.2
 * 新华书店-项目功能
 * 1.展示书籍
 * 2.上新书籍
 * 3.下架书籍
 * 4.退出应用
 */

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while (true){
            //打印菜单
            System.out.println("-----欢迎来到新华书店-----");
            System.out.println("1.展示书籍");
            System.out.println("2.上新书籍");
            System.out.println("3.下架书籍");
            System.out.println("4.退出应用");
            //借助Scanner类
            Scanner sc = new Scanner(System.in);
            //友好提示
            System.out.println("请输入对应功能的序号：");
            //利用键盘记录序号
            int choice = sc.nextInt();

            //根据choice录入功能
            if(choice == 1){
                System.out.println("新华书店>>>>>>展示书籍");
                //从文件中读取list
                File f = new File("d:\\Book.txt");

                //对f进行判断
                if (f.exists() == true){//文件存在   exists返回值为布尔值
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    //读取集合
                    ArrayList list = (ArrayList) ois.readObject();
                    //对集合进行遍历
                    for (int i = 0;i<list.size();i++){
                        Book b = (Book) list.get(i);
                        System.out.println(b.getNum()+"-----"+b.getName()+"-----"+b.getAuthor());
                    }
                }else {//文件不存在
                    System.out.println("当前没有上新书籍，请上新书籍再进行书籍展示");
                }

            }
            if(choice == 2){
                System.out.println("新华书店>>>>>>上新书籍");
                System.out.println("请录入书籍编号：");
                int num = sc.nextInt();
                System.out.println("请录入书籍名字：");
                String name = sc.next();
                System.out.println("请录入书籍作者：");
                String author = sc.next();
                //创建书籍对象
                Book book = new Book();
                book.setNum(num);
                book.setName(name);
                book.setAuthor(author);

                //从文件中读取list
                File f = new File("d:\\Book.txt");

                //对f进行判断
                if (f.exists() == true){//文件存在   exists返回值为布尔值
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    //读取集合
                    ArrayList list = (ArrayList) ois.readObject();
                    //从集合中读取出来再追加新的书籍
                    list.add(book);
                    //将集合写如硬盘 输出流
                    FileOutputStream fos = new FileOutputStream(f);//文件输出流
                    ObjectOutputStream oos = new ObjectOutputStream(fos);//对象输出流
                    //list写出
                    oos.writeObject(list);
                    //关闭流
                    oos.close();

                }else {//文件不存在
                    //创建一个空集合
                    ArrayList list = new ArrayList();
                    //集合存放相同的个体
                    list.add(book);
                    //将集合文件写入硬盘文件
                    //输出流
                    FileOutputStream fos = new FileOutputStream(f);//文件输出流
                    ObjectOutputStream oos = new ObjectOutputStream(fos);//对象输出流
                    //list写出
                    oos.writeObject(list);
                    //关闭流
                    oos.close();
                }
            }

            if(choice == 3){
                System.out.println("新华书店>>>>>>下架书籍");
                //录入要下架的书籍编号
                System.out.println("请录入要下架的书籍编号");
                int num = sc.nextInt();

                //从文件中读取list
                File f = new File("d:\\Book.txt");

                //对f进行判断
                if (f.exists() == true){//文件存在   exists返回值为布尔值
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    //读取集合
                    ArrayList list = (ArrayList) ois.readObject();

                    //下架对应的书籍
                    for (int i = 0;i<list.size();i++){
                        Book b = (Book)list.get(i);
                        int flag = 1;//标志1为下架成功
                        if(b.getNum() == num){
                            list.remove(b);
                            flag = 1;
                            System.out.println("找到这本书，书籍下架成功");
                            break;
                        }else if(flag == 0) {//标志0为下架失败
                            System.out.println("未找到这本书，书籍下架失败");
                        }
                    }
                    //将集合写如硬盘 输出流
                    FileOutputStream fos = new FileOutputStream(f);//文件输出流
                    ObjectOutputStream oos = new ObjectOutputStream(fos);//对象输出流
                    //list写出
                    oos.writeObject(list);
                    //关闭流
                    oos.close();

                }else {//文件不存在
                    System.out.println("当前没有上新书籍，请上新书籍再进行书籍展示");
                }
            }

            if(choice == 4){
                System.out.println("新华书店>>>>>>退出应用");
                break;
            }
        }
    }
}
