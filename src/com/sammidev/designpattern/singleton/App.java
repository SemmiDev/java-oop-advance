package com.sammidev.designpattern.singleton;


import java.sql.ResultSet;

public class App {

    public static void main(String[] args) {
        DatabaseConnection satu   = DatabaseConnection.getDatabaseConnection("jdbc:mysql://localhost/demo", "root1", "test1");
        DatabaseConnection dua    = DatabaseConnection.getDatabaseConnection("jdbc:mysql://localhost/demo", "root2", "test2");
        DatabaseConnection tiga   = DatabaseConnection.getDatabaseConnection("jdbc:mysql://localhost/demo", "root3", "test3");
        DatabaseConnection empat = DatabaseConnection.getDatabaseConnection("jdbc:mysql://localhost/demo", "root4", "test4");

        System.out.println("satu == dua : "+ (satu == dua));
        System.out.println("dua == tiga : "+ (dua == tiga));
        System.out.println("tiga == empat : "+ (satu == empat));
        System.out.println("satu == empat : "+ (satu == dua));
    }
}

class DatabaseConnection {

    private String JDBCURL;
    private String USERNAME;
    private String PASSWORD;

    private static DatabaseConnection databaseConnectionAlone;


    public static DatabaseConnection getDatabaseConnection(
            String JDBCURL,
            String USERNAME,
            String PASSWORD){

        if (databaseConnectionAlone == null) {
            return databaseConnectionAlone = new DatabaseConnection(
                    JDBCURL, USERNAME, PASSWORD);
        }
        return databaseConnectionAlone;
    }

    private DatabaseConnection(
            String JDBCURL, String USERNAME, String PASSWORD) {

        this.JDBCURL = JDBCURL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;

        System.out.println("CREATE");
        System.out.println("JDBC : " + JDBCURL);
        System.out.println("USERNAME : " + USERNAME);
        System.out.println("PASSWORD : " + PASSWORD);
    }

    public void connect() {}
    public void disconnect() {}
    public ResultSet executeQuery(String sql) {return null;}
    public int executeUpdate(String sql) {return 0;}
}
