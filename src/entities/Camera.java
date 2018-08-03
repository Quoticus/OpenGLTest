/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author noelc
 */
public class Camera {
    
    private Vector3f position = new Vector3f(25, 2, -15);
    private float pitch;
    private float yaw;
    private float roll;
    
    public Camera(){
        
    }
    
    public void move(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            position.z-=0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            position.z+=0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            position.x+=0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            position.x-=0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
            position.y+=0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_E)){
            position.y-=0.02f;
        }
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
    
    
}
