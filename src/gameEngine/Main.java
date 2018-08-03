/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameEngine;

import entities.Camera;
import entities.Entity;
import entities.Light;
import renderEngine.Loader;
import renderEngine.Renderer;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.OBJLoader;
import shaders.StaticShader;
import textures.ModelTexture;

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
        StaticShader shader = new StaticShader();
        Renderer renderer = new Renderer(shader);
        
        RawModel model = OBJLoader.loadObjModel("dragon", loader);
        TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("whiteTexture")));
        ModelTexture texture = staticModel.getTexture();
        texture.setShineDamper(10);
        texture.setReflectivity(5);
        
        Entity entity = new Entity(staticModel, new Vector3f(0,-5,-25),0, 0, 0, 1);
        Light light = new Light(new Vector3f(0,0,-17), new Vector3f(1, 1, 1));
        Camera camera = new Camera();
        
        while(!Display.isCloseRequested()){
            entity.increaseRotation(0, 0.5f, 0);
            camera.move();
            renderer.prepare();
            shader.start();
            shader.loadLight(light);
            shader.loadViewMatrix(camera);
            renderer.render(entity, shader);
            shader.stop();
            DisplayManager.updateDisplay();
        }
        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
    
}
