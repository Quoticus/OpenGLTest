/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameEngine;

import renderEngine.Loader;
import renderEngine.Renderer;
import renderEngine.RawModel;
import renderEngine.DisplayManager;
import org.lwjgl.opengl.Display;
import shaders.StaticShader;

/**
 *
 * @author noelc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();
        
        float[] vertices = {
            -0.5f, 0.5f, 0f, //V0
            -0.5f, -0.5f, 0f, //V1
            0.5f, -0.5f, 0f, //V2
            0.5f, 0.5f, 0f //V3
        };
        
        int[] indices = {
                0, 1, 3, //Top left triangle (V0, V1, V3)
                3, 1, 2  //Bottom right triangle (V3, V1, V2)
        };
        
        RawModel model = loader.loadToVAO(vertices, indices);
        
        while(!Display.isCloseRequested()){
            //game logic
            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();
            DisplayManager.updateDisplay();
        }
        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
    
}
