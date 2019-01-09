package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.EnumSet;

public class TestStudents {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    @BeforeAll
    public static void init(){
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
    }

    @AfterAll
    public static void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSchemaExport(){
        // 创建服务注册对象
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        // 生成Metadata
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        // 生成表结构
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
    }

    @Test
    public void addStudents(){
        Address address = new Address("700005", "北京", "13812345678");
        StudentsPK studentsPK = new StudentsPK("123123123123", "S0000001");
        Students students = new Students(studentsPK, "Miles", "man", new Date(), "Java", address);
        session.save(students);
    }
}
