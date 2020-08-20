package com.minghui.util.utils;

import lombok.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Java对象转化为xml和将xml转化为Java对象工具类
 *
 * 参考 https://blog.csdn.net/jiangchao858/article/details/84668004
 * 参考 https://zhuchengzzcc.iteye.com/blog/1838702
 * @author mh
 * @create 2019-07-04 10:04
 */
public class XmlUtils {

    public static <T> String javaBean2Xml(Class<T> clazz,T t){
        try {
            //创建JAXBContext对象
            JAXBContext context = JAXBContext.newInstance(clazz);
            //创建Marshaller对象,编排(将Java对象转化为xml)
            Marshaller marshaller = context.createMarshaller();
            StringWriter str = new StringWriter();
            marshaller.marshal(t,str);
            return str.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> Object xml2JavaBean(Class<T> clazz,String xml){
        try {
            //创建JAXBContext对象
            JAXBContext context = JAXBContext.newInstance(clazz);
            //创建Marshaller对象,编排(将Java对象转化为xml)
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @XmlRootElement
    static class Student{

        private int id;

        private String name;

        private int age;
        public Student(int id, String name, int age) {
            super();
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @XmlAttribute(name = "name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute(name = "age")
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
//            Student stu = new Student(1,"张三",12);
//            System.out.println(XmlUtils.javaBean2Xml(Student.class,stu));

//            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>12</age><classRom><grade>4</grade><id>1</id><name>12级Java2班</name></classRom><id>1</id><name>张三</name></student>";
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student age=\"12\" name=\"aaa\"></student>";
            Student stu1 = (Student) XmlUtils.xml2JavaBean(Student.class,xml);
            System.out.println(stu1.getName());
    }
}