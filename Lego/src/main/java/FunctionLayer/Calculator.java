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
public class Calculator {

    public static Bricks build(int length, int height, int width) {

        Bricks calculate = new Bricks();
        int four, two, one;
        int len;
        int wid;
        for (int i = 1; i <= height; i++) {
            if (i % 2 == 1) {
                len = length;
                wid = width - 4;

            } else {
                len = length - 4;
                wid = width;
            }
            four = (len / 4) * 2 + (wid / 4) * 2;;
            two = ((len % 4) / 2) * 2 + ((wid % 4) / 2) * 2;
            one = ((len % 4) % 2) * 2 + ((wid % 4) % 2) * 2;

            calculate.addBricks(four, two, one);
        }
        return calculate;
    }

}
