package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.scene.Geometry;
import com.jme3.scene.*;
import com.jme3.scene.shape.*;
import java.util.Vector;
 
/** Sample 2 - How to use nodes as handles to manipulate objects in the scene.
 * You can rotate, translate, and scale objects by manipulating their parent nodes.
 * The Root Node is special: Only what is attached to the Root Node appears in the scene. */
public class Main extends SimpleApplication {
 
    public static void main(String[] args){
        Main app = new Main();
        app.start();
    }
 
    @Override
    public void simpleInitApp() {
 
      
        /** Create a pivot node at (0,0,0) and attach it to the root node */
        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot); // put this node in the scene
 
        /** Attach the two boxes to the *pivot* node. (And transitively to the root node.) */
        /** Rotate the pivot node: Note that both boxes have rotated! */
        pivot.rotate(2f,2f,2f);
        

        /*for (int x = -1; x < 2; x++){
        	for (int y = 0; y < 3; y++){
        		for(int z = -1; z < 2; z++){
        			Box box = new Box(1,1,1);
                	Geometry boxGeo = new Geometry("Box", box);
                	boxGeo.setLocalTranslation(new Vector3f(2*x,2*y,2*z));
                	Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                	mat2.setColor("Color", ColorRGBA.randomColor());
                	boxGeo.setMaterial(mat2);
                	rootNode.attachChild(boxGeo);
        		}
        	}  	
        }*/
        
        Spatial cube1 = createSpatial("Models/C-rwb/C-rwb.j3o", new Vector3f(0,0,0), 180,90,0);
        rootNode.attachChild(cube1);
        
        Spatial cube2 = createSpatial("Models/E-rw/E-rw.j3o", new Vector3f(-2,0,0), 180,90,0);
        rootNode.attachChild(cube2);
        
        Spatial cube3 = createSpatial("Models/C-rwg/C-rwg.j3o", new Vector3f(-4,0,0), 180,90,0);
        rootNode.attachChild(cube3);
        
        
        flyCam.setMoveSpeed(5);
       
        
        // make model visible from all sides

        addDirectionalLight(rootNode, new Vector3f(0f,0f,0f));
        addDirectionalLight(rootNode, new Vector3f(1f,0f,0f));
        addDirectionalLight(rootNode, new Vector3f(1f,1f,0f));
        addDirectionalLight(rootNode, new Vector3f(1f,1f,1f));
        addDirectionalLight(rootNode, new Vector3f(-1f,0f,0f));
        addDirectionalLight(rootNode, new Vector3f(-1f,-1f,-1f));
        
        
        //addDirectionalLight(rootNode, new Vector3f(-3f,-1f,-1f));
        //addDirectionalLight(rootNode, new Vector3f(-1f,-1f,-1f));
        
   
        flyCam.setMoveSpeed(5);
     
    }
    
    public void addDirectionalLight(Node rootNode, Vector3f direction){
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(direction);
        rootNode.addLight(sun);
        
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