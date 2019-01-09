package com.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

/**
 * 　　@Column 可将属性映射到列，使用该注解来覆盖默认值。
 * 　　常用属性：
 * 　　name: 可选，表示数据库表中该字段的名称，默认和属性名称一致。
 * 　　nullable: 可选，一波啊是该字段是否允许为null，默认为true。
 * 　　unique: 可选，表示该字段是否是唯一标识，默认为false。
 * 　　length: 可选，表示该字段大小，仅对String类型的字段有效。
 *
 *
 * 　　@GeneratedValue(strategy = GenerationType.IDENTITY) // 表示将主键设置为auto_increment
 * 　　@GeneratedValue(strategy = GenerationType.AUTO) // 表示将主键设置为auto_increment
 *
 *    生成嵌入式的类
 *      @EmbeddedId
 *      @Embedded
 *      @Embeddable
 *
 */


@Entity(name = "t_students")
public class Students {

    @Id // 表示为PrimaryKey, 可以使用多个表示联合住建。
    //@GeneratedValue(strategy = GenerationType.IDENTITY)  // 表示将主键设置为auto_increment
    @GeneratedValue(generator = "sid")
    @GenericGenerator(name="sid", strategy = "assigned")
    @Column(length = 8)
    @EmbeddedId
    private StudentsPK pk; // 学号
    private String name;    // 姓名
    private String gender;  // 性别
    private Date birthday;  // 出生日期
    private String major;   // 专业

    @Transient // 表示不会被ORM映射到表字段
    private double salary; // 薪水
    // private String address; // 地址

    @Embedded
    private Address address;

    public Students(){

    }

    public Students(StudentsPK pk, String name, String gender, Date birthday, String major, Address address) {
        this.pk = pk;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public StudentsPK getPk() {
        return pk;
    }

    public void setPk(StudentsPK pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", major='" + major + '\'' +
                '}';
    }
}
