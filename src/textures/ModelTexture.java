/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textures;

/**
 *
 * @author noelc
 */
public class ModelTexture {
    
    private int textureID;
    
    private float shineDamper = 1;
    private float reflectivity = 0;
    
    public ModelTexture(int id){
        this.textureID = id;
    }
    
    public int getID(){
        return this.textureID;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public void setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public void setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
    }
    
    
    
}
