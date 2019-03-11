package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author micha
 */
public class Medium {

    public Menu menu = new Menu();
    public SelectWin selecter = new SelectWin();
    public AddWin adder = new AddWin();
    public DeleteWin deleter = new DeleteWin();
    
    private String user = "ziibd1";
    private String password = "haslo2018";
    private String url = "jdbc:oracle:thin:@155.158.112.45:1521:oltpstud";
    public Connection connection = null;

    public Medium() {

    }

    public void showData(String table) {
        try {

            connection = DriverManager.getConnection(url, user, password);

            String selectSql = "SELECT * FROM " + table;

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSql); 
                ResultSetMetaData rsmd = resultSet.getMetaData();

                while (resultSet.next()) {

                    String temp = "";
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        temp = temp + resultSet.getString(i) + "\t";
                    }
                    selecter.FillData(temp);
                }
                connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String condition) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            String selectSql = "DELETE FROM " + menu.boxItem() + " WHERE " + condition;

            try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql)) {
            connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addData(String values) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            String selectSql = "INSERT INTO " + menu.boxItem() + " VALUES (" + values + ")";

            try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql)) {
            connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public void showMenu() {
        menu.setVisible(true);
    }

    public void showAdd() {
        adder.setVisible(true);
    }

    public void showDelete() {
        deleter.setVisible(true);
    }

    public void showSelect() {
        selecter.setVisible(true);
    }

}
