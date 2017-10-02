# hibernate-tutorial2
Hibernate XML Mapping files *(Obsolete !!! We will see in Tutorial 3 the mode "Hibernate Annotations")*

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/nfriaa/hibernate-tutorial2/issues) [![Travis](https://img.shields.io/travis/rust-lang/rust.svg)](https://github.com/nfriaa/hibernate-tutorial2) [![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/nfriaa/hibernate-tutorial2/blob/master/LICENSE)

## Description
A sample code to execute Queries under Hibernate ORM (not directly to sql) 
* JavaSE 1.8
* Hibernate 5
* Maven 4
* MySQL 5 

## 1. Database and tables
We will use the same database and table structure in Tutorial 1

## 2. Create maven project and add dependencies
```
<!-- MySQL connector -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>6.0.6</version>
</dependency>

<!-- Hibernate -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.2.11.Final</version>
</dependency>
```

## 3. Create POJO (Plain Old Java Object) class
```
public class Product
{
    private int id;
    private String name;
    private int price;

    // getters and setters here...
}
```

## 4. Create the hibernate config file 'hibernate.cfg.xml'
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/persist_db</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>
        <property name="show_sql">true</property>**
        <mapping file="src/main/java/net/isetjb/hibernatetutorial2/Product.hbm.xml"/>
    </session-factory>
</hibernate-configuration>
```

## 5. Create HibernateUtil.java 
Hibernate Utility class with a convenient method to get Session Factory.

## 6. Create a main Application class
* a class whith main method to test connection
* implement CRUD operations
