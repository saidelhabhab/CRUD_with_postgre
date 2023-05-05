package org.example;

import org.example.DB.DBFunctions;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DBFunctions db = new DBFunctions();

       Connection conn = db.connect_to_db("CRUD","postgres","Saidtoni");

        // db.createTable(conn,"employee");

         // db.insert(conn,"employee","rachid","hamwi","00045695");

        db.read(conn,"employee");

        db.update(conn,"employee","hamza","chado","555695",2);
        // System.out.println("Hello world!");
    }
}