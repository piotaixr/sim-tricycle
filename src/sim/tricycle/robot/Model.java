/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.awt.Image;

/**
 *
 * @author morgan
 */
public class Model {
    private Robot rob;
    private String img;
    
    public Model(Robot r, String s){
        this.rob = r;
        this.img = s;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Robot getRob() {
        return rob;
    }

    public void setRob(Robot rob) {
        this.rob = rob;
    }
}
