package org.example.DB;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFunctions {

    public Connection connect_to_db(String dbname,String user,String pass){

        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);

            if (conn!=null){
                System.out.println("Connection successfully");
            }else{
                System.out.println("Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return conn;
    }

    public  void createTable (Connection conn, String table_name){

        Statement statement;

        try{

            String query = "create table "+table_name+"(empid SERIAL,firstname varchar(200), lastname varchar(200),phone varchar(200), primary key(empid));";
            statement = conn.createStatement();
            statement.execute(query);
            System.out.println("Table created");

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void insert(Connection conn,String table_name, String firstname, String lastname, String phone ){

        Statement statement;
        try{

            String query = String.format(" insert into %s(firstname,lastname,phone) values ('%s','%s','%s'); ",table_name, firstname,lastname,phone);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void read(Connection conn,String table_name ){

        Statement statement;
        ResultSet rs= null;
        try{

            String query = String.format(" select * from %s ",table_name);
            statement = conn.createStatement();
            rs=  statement.executeQuery(query);

            while (rs.next())
            {
                System.out.print(rs.getString("empid")+" " );
                System.out.print(rs.getString("firstname")+" " );
                System.out.print(rs.getString("lastname")+" " );
                System.out.println(rs.getString("phone")+" " );
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void update(Connection conn,String table_name, String new_firstname, String new_lastname, String new_phone , int empid){

        Statement statement;
        try{

            String query = String.format(" update  %s set firstname  = '%s' ,lastname = '%s',phone = '%s' where  empid='%d' ",table_name, new_firstname,new_lastname,new_phone,empid);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void search_by_name(Connection conn,String table_name, String name){

            Statement statement;
            ResultSet rs= null;
            try{

                String query = String.format(" select * from %s where firstname = '%s' ",table_name,name);
                statement = conn.createStatement();
                rs=  statement.executeQuery(query);

                while (rs.next())
                {
                    System.out.print(rs.getString("empid")+" " );
                    System.out.print(rs.getString("firstname")+" " );
                    System.out.print(rs.getString("lastname")+" " );
                    System.out.println(rs.getString("phone")+" " );
                }


            }catch (Exception e){
                System.out.println(e);
            }

    }

    public void search_by_id(Connection conn,String table_name, int id){

        Statement statement;
        ResultSet rs= null;
        try{

            String query = String.format(" select * from %s where empid = %d ",table_name,id);
            statement = conn.createStatement();
            rs=  statement.executeQuery(query);

            while (rs.next())
            {
                System.out.print(rs.getString("empid")+" " );
                System.out.print(rs.getString("firstname")+" " );
                System.out.print(rs.getString("lastname")+" " );
                System.out.println(rs.getString("phone")+" " );
            }


        }catch (Exception e){
            System.out.println(e);
        }

    }


    public void delete_by_id(Connection conn,String table_name, int id){

        Statement statement;
        try{

            String query = String.format(" delete from %s where empid = %d ",table_name,id);
            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Data deleted ") ;



        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void delete_by_name(Connection conn,String table_name, String name){

        Statement statement;
        try{

            String query = String.format(" delete from %s where firstname = '%s' ",table_name,name);
            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Data deleted ") ;



        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void drop_table(Connection conn,String table_name){

        Statement statement;
        try{

            String query = String.format(" drop table %s  ",table_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("table deleted ") ;



        }catch (Exception e){
            System.out.println(e);
        }

    }

}
