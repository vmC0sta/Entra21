package util;

import product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageDB {
    public ArrayList<Product> fetchData() {
        Connection connection = ConnectionDB.getConnection();
        ArrayList<Product> listProducts = new ArrayList<>();
        String sql = "SELECT * FROM PO_PRODUTO";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("id"), rs.getString("description"), rs.getDouble("quantity"), rs.getDouble("value")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return listProducts;
        }
    }
    public void insert(String description, double quantity, double value) {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO PO_PRODUTO(description,quantity,value)values(?,?,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, description);
            stm.setDouble(2, quantity);
            stm.setDouble(3, value);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection();
        }
    }
    public void update(int id, String description, double quantity, double value){
        Connection connection = ConnectionDB.getConnection();
        String sql = "UPDATE PO_PRODUTO SET DESCRIPTION = ?, QUANTITY = ?, VALUE = ? WHERE ID = ?";
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setString(1,description);
            smt.setDouble(2,quantity);
            smt.setDouble(3,value);
            smt.setInt(4,id);
            smt.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection();
        }

    }
    public void delete(int id){
        Connection connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM PO_PRODUTO WHERE ID = ?";
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1,id);
            smt.execute();
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection();
        }

    }
    public void queryAll(ArrayList<Product> listProduct){
        for(Product product : listProduct){
            System.out.println(product.toString());
        }
    }
    public void query(ArrayList<Product> listProduct, int id){
            for(Product product : listProduct){
                if(product.getId() == id){
                    System.out.println(product.toString());
                }
        }
    }

}
