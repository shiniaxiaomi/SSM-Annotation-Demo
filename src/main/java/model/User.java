package model;

public class User{
    int id;
    String name;
    int age;

    //生成get和set方法才能在Controller中直接返回model序列化的结果
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}