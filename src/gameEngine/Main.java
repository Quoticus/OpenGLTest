/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameEngine;

import entities.Camera;
import entities.Entity;
import entities.Light;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import renderEngine.Loader;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import shaders.StaticShader;
import terrains.Terrain;
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
        RawModel model = OBJLoader.loadObjModel("tree", loader);
        TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("tree")));
        TexturedModel grass = new TexturedModel(OBJLoader.loadObjModel("grassModel", loader), new ModelTexture(loader.loadTexture("grass")));
        TexturedModel fern = new TexturedModel(OBJLoader.loadObjModel("fern", loader), new ModelTexture(loader.loadTexture("fern")));
        
        List<Entity> entities = new ArrayList<Entity>();
        Random random = new Random();
        
        
        /*Implement adding a random generation of a bunch of entities across the map - Time index 5:06*/
        
        
        ModelTexture texture = staticModel.getTexture();
        texture.setShineDamper(10);
        texture.setReflectivity(5);
        
        Entity entity = new Entity(staticModel, new Vector3f(25,0,-25),0, 0, 0, 1);
        Light light = new Light(new Vector3f(0,0,-20), new Vector3f(1, 1, 1));
        
        Terrain terrain = new Terrain(0, -1, loader, new ModelTexture(loader.loadTexture("grass")));
        Terrain terrain2 = new Terrain(1, -1, loader, new ModelTexture(loader.loadTexture("grass")));
        
        Camera camera = new Camera();
        
        MasterRenderer renderer = new MasterRenderer();
        
        while(!Display.isCloseRequested()){
            //entity.increaseRotation(0, 0.5f, 0);
            camera.move();
            renderer.processTerrain(terrain);
            renderer.processTerrain(terrain2);
            renderer.processEntity(entity);
            renderer.render(light,camera);
            DisplayManager.updateDisplay();
        }
        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
    
}
