/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Hamad
 */
public class OrderHouse {
    
    int idOrder;
    int user_id; 
    
    int length; 
    int height;
    int width;

    public OrderHouse(int idOrder, int length, int height, int width) {
        this.idOrder = idOrder;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "OrderHouse{" + "idOrder=" + idOrder + ", user_id=" + user_id + ", length=" + length + ", height=" + height + '}';
    }
    
    
    
}
