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
public class Bricks {
    
    private int large;
    private int medium;
    private int small;
    
    public Bricks() {
        this.large = 0;
        this.medium = 0;
        this.small = 0;
    }
     public int getFour() {
        return large;   
    }

    public int getTwo() {
        return medium;
    }

    public int getOne() {
        return small;
    }
    
    public void addBricks(int four, int two, int one) {
        this.large += four; 
        this.medium += two; 
        this.small += one; 
    }
    
    
}
