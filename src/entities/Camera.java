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
    private float moveSpeed = 0.2f;
    
    public Camera(){
        
    }
    
    public void move(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            position.z-=moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            position.z+=moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            position.x+=moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            position.x-=moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
            position.y+=moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_E)){
            position.y-=moveSpeed;
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
