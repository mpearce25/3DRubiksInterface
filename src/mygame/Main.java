package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.*;
import com.jme3.math.*;
import com.jme3.scene.*;

public class Main extends SimpleApplication {
 
    
    Quaternion rotation=(new Quaternion()).fromAngles(0,0, 0);
Quaternion rotationVelocity=(new Quaternion()).fromAngles(0.25f,0.5f, 0.25f);

Spatial cube9;
    public static void main(String[] args){
        Main app = new Main();
        app.start();
    }
 
    @Override
    public void simpleInitApp() {
 
      //set lighting
        initLighting();
      
        //rotation & pan
        Node pivot = new Node("pivot");
        pivot.rotate(2f,2f,2f);
        rootNode.attachChild(pivot); // put this node in the scene
        flyCam.setMoveSpeed(10);
  
        Spatial cube1 = createSpatial("Models/C-rwb/C-rwb.j3o", new Vector3f(0,0,0), 180,90,0);
        rootNode.attachChild(cube1);
        
        Spatial cube2 = createSpatial("Models/E-rw/E-rw.j3o", new Vector3f(-2,0,0), 180,90,0);
        rootNode.attachChild(cube2);
        
        Spatial cube3 = createSpatial("Models/C-rwg/C-rwg.j3o", new Vector3f(-4,0,0), 180,90,0);
        rootNode.attachChild(cube3);
        
        Spatial cube7 = createSpatial("Models/C-ryb/C-ryb.j3o", new Vector3f(0,-4,0), 180,0,0);
        rootNode.attachChild(cube7);
        
        Spatial cube8 = createSpatial("Models/E-ry/E-ry.j3o", new Vector3f(-2,-4,0), 0,270,180);
        rootNode.attachChild(cube8);
        
        cube9 = createSpatial("Models/C-ryg/C-ryg.j3o", new Vector3f(-4,-4,0), 180,270,0);
        rootNode.attachChild(cube9);
     
        
    }
    
    public void initLighting(){
        addDirectionalLight(rootNode, new Vector3f(0f,0f,0f));
        addDirectionalLight(rootNode, new Vector3f(1f,0f,0f));
        addDirectionalLight(rootNode, new Vector3f(1f,1f,0f));
        addDirectionalLight(rootNode, new Vector3f(1f,1f,1f));
        addDirectionalLight(rootNode, new Vector3f(-1f,0f,0f));
        addDirectionalLight(rootNode, new Vector3f(-1f,-1f,-1f));
        
    }
    public void addDirectionalLight(Node rootNode, Vector3f direction){
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(direction);
        rootNode.addLight(sun);
        
    }
    
    @Override
public void simpleUpdate(float tpf) {

    Quaternion rotationVelocityFPS=new Quaternion();
    rotationVelocityFPS.slerp(Quaternion.IDENTITY, rotationVelocity, tpf);

    rotation.multLocal(rotationVelocityFPS);

    cube9.setLocalRotation(rotation);
}
    
    public Spatial createSpatial(String modelPath, Vector3f translation, float rotX, float rotY, float rotZ ){
        
        Spatial object = assetManager.loadModel(modelPath);
        object.scale(1,1,1);   
        object.rotate(FastMath.DEG_TO_RAD * rotX, FastMath.DEG_TO_RAD * rotY, FastMath.DEG_TO_RAD*rotZ);
        object.setLocalTranslation(translation);
        
        return object;
    }
   
    
    public static void delay(int time)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < time)
			endDelay = System.currentTimeMillis();
	}
}