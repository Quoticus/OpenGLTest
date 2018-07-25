/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

/**
 *
 * @author noelc
 */
public class DisplayManager {
    
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 120;
    
    public static void createDisplay(){
        
        ContextAttribs attribs = new ContextAttribs(3,2);
        attribs.withForwardCompatible(true);
        attribs.withProfileCore(true);
        
        try{
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("Test Title");
        } catch(LWJGLException e){
            e.printStackTrace();
        }
        
        GL11.glViewport(0, 0, WIDTH, HEIGHT);
        
    }
    
    public static void updateDisplay(){
        Display.sync(FPS_CAP);
        Display.update();
    }
    
    public static void closeDisplay(){
        Display.destroy();
    }
}
