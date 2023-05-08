package org.example;

import org.example.DB.DBFunctions;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DBFunctions db = new DBFunctions();

       Connection conn = db.connect_to_db("CRUD","postgres","Saidtoni");

        // db.createTable(conn,"employee");

        // db.insert(conn,"employee","hamza","hamwi","00045695");

        db.read(conn,"employee");

        //db.update(conn,"employee","tamer","chado","555695",4);


       // System.out.println("Hello world!");
        //db.search_by_name(conn,"employee","said");
       // db.search_by_id(conn,"employee",3);

        //System.out.println("...................");
        //db.delete_by_id(conn,"employee",2);

       // db.read(conn,"employee");


        System.out.println("...................");
        //delete_by_name(conn,"employee","hamza");

        db.read(conn,"employee");

    }
}