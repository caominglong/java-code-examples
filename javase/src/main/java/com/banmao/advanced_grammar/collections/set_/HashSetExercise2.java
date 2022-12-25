package com.banmao.advanced_grammar.collections.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/20 下午1:58
 * @description
 */
public class HashSetExercise2 {

        public static void main(String[] args) {
            // 定义Employee放入HashSet中，当name和age的值相同时，认为是相同员工，不能添加到HashSet集合中
            HashSet hashSet = new HashSet();
            Employee2.MyDate myDate = new Employee2.MyDate(2022, 10, 28);
            Employee2 zhansan1 = new Employee2("张三", 10000.0, myDate);
            hashSet.add(zhansan1);
            System.out.println(zhansan1.hashCode());
            System.out.println("myDate：" + myDate.hashCode());
            hashSet.add(new Employee2("李四", 2000.0, new Employee2.MyDate(2019, 10, 28)));
            Employee2.MyDate myDate1 = new Employee2.MyDate(2022, 10, 28);
            Employee2 zhansan2 = new Employee2("张三", 20000.0, myDate1);
            hashSet.add(zhansan2);
            System.out.println(zhansan2.hashCode());
            System.out.println("myDate1：" + myDate1.hashCode());

            hashSet.add(new Employee2("李四", 100, new Employee2.MyDate(2019, 10, 28)));
            hashSet.add(new Employee2("王五", 100, new Employee2.MyDate(2019, 10, 28)));

            Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                Object next =  iterator.next();
                Employee2 employee2 = (Employee2) next;
                System.out.println("名字为：" + employee2.getName() + ",薪水为：" + employee2.getSal());
            }

        }
}

class Employee2 {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee2(String name, double sal, MyDate birthday) {
        this.sal = sal;
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        // 让相同名字与相同出身日期的hashcode值相同
        return Objects.hash(name, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        // 让相同名字与出身日期的对象相同
        if(obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Employee2)) {
            return false;
        }
        return this.name.equals(((Employee2) obj).name) && this.birthday.equals(((Employee2) obj).birthday);
    }

    public static class MyDate {
        private int year;
        private int month;
        private int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof MyDate)) {
                return false;
            }
            return year == ((MyDate) obj).year && month == ((MyDate) obj).month && day == ((MyDate) obj).day;
        }
    }
}