package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.*;
import com.jme3.math.*;
import com.jme3.scene.*;



public class Main extends SimpleApplication {
 
    
    private ActionListener actionListener = new ActionListener(){
        public void onAction(String name, boolean pressed, float tpf){
            System.out.println(name + " = " + pressed);
            
            if (pressed){
                rotateD(tpf);
            }
        }
    };
    
    
    //Nodes
    Node bottomRow = new Node();
    Node testRow = new Node();
    Node lightingNode = new Node();
    //Quaternion rotation=(new Quaternion()).fromAngles(145 ,78, 19);
    //Quaternion rotation=(new Quaternion()).fromAngles(0, 0,0);
    Quaternion rotation=( new Quaternion()).fromAngleAxis(FastMath.PI/2, new Vector3f(1,0,0));
Quaternion rotationVelocity=(new Quaternion()).fromAngles(0.1f,.1f, .1f);

Spatial cube9;
    public static void main(String[] args){
        Main app = new Main();
        app.start();
    }
 
    @Override
    public void simpleInitApp() {
 rootNode.attachChild(bottomRow);
        rootNode.attachChild(lightingNode);
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
        
        Spatial cube4 = createSpatial("Models/E-rb/E-rb.j3o", new Vector3f(0,-2,0), 180,90,0);
        rootNode.attachChild(cube4);
        
        Spatial cube5 = createSpatial("Models/S-r/S-r.j3o", new Vector3f(-2,-2,0), 180,90,0);
        rootNode.attachChild(cube5);
        
        Spatial cube6 = createSpatial("Models/E-rg/E-rg.j3o", new Vector3f(-4,-2,0), 180,90,0);
        rootNode.attachChild(cube6);
        
        
        
        Spatial cube7 = createSpatial("Models/C-ryb/C-ryb.j3o", new Vector3f(2,0,0), 0,270,180);
        bottomRow.attachChild(cube7);
        
        
        
        Spatial cube8 = createSpatial("Models/E-ry/E-ry.j3o", new Vector3f(0,0,0), 0,270,180);
        //rootNode.attachChild(cube8);
        bottomRow.attachChild(cube8);
        
        cube9 = createSpatial("Models/C-ryg/C-ryg.j3o", new Vector3f(-2,0,0), 180,90,0);
        //rootNode.attachChild(cube9);
        bottomRow.attachChild(cube9);
        
        bottomRow.setLocalTranslation(new Vector3f(-2,-4, 0));
        
         inputManager.addMapping("RotateD",
                new KeyTrigger(KeyInput.KEY_R));

        // Test multiple listeners per mapping
        inputManager.addListener(actionListener, "RotateD");
 
    }
    
  
    
    public void initLighting(){
        addDirectionalLight(lightingNode, new Vector3f(0f,0f,0f));
        addDirectionalLight(lightingNode, new Vector3f(1f,0f,0f));
        addDirectionalLight(lightingNode, new Vector3f(1f,1f,0f));
        addDirectionalLight(lightingNode, new Vector3f(1f,1f,1f));
        addDirectionalLight(lightingNode, new Vector3f(-1f,0f,0f));
        addDirectionalLight(lightingNode, new Vector3f(-1f,-1f,-1f));
        
        rootNode.attachChild(lightingNode);
        
    }
    public void addDirectionalLight(Node node, Vector3f direction){
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(direction);
        sun.setColor(ColorRGBA.White.mult(2));
        rootNode.addLight(sun);     
    }
    
    float degree = FastMath.PI / 2;
    public void rotateD(float tpf){
   
       //for (int i = 0; i < 10; i ++){
        Quaternion rotation=( new Quaternion()).fromAngleAxis(degree , new Vector3f(0,1,0));
        
        degree += FastMath.PI /2;
        if (degree > FastMath.PI * 2){
            degree = 0;
        }
       // Quaternion rotationVelocity=(new Quaternion()).fromAngles(0.0f,0.0f, 0f);
        
        Quaternion rotationVelocityFPS=new Quaternion();
        rotationVelocityFPS.slerp(Quaternion.IDENTITY, rotationVelocity, tpf);

        rotation.multLocal(rotationVelocityFPS);
        
        bottomRow.setLocalRotation(rotation);
        //}
      //  
    
    
    //delay(2000);
    }
    
    @Override
public void simpleUpdate(float tpf) {

    //rotateD(tpf);
    //bottomRow.rotate(FastMath.DEG_TO_RAD * 180f, 0f, 0f);
    //testRow.rotate(rotation);
    
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