package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.*;
import com.jme3.math.*;
import com.jme3.scene.*;
import java.util.ArrayList;



public class Main extends SimpleApplication {
 
     ArrayList<Spatial> allCubes = new ArrayList<Spatial>();
    private ActionListener actionListener = new ActionListener(){
        public void onAction(String name, boolean pressed, float tpf){
            System.out.println(name + " = " + pressed);
            
            if (pressed){
                rotateD(tpf, allCubes);
            }
        }
    };
    
    
    //Nodes
    Node bottomRow = new Node();
    Node frontFace = new Node();
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
        
       
  
        Spatial cube1 = createSpatial(rootNode, "Models/C-rwb/C-rwb.j3o", new Vector3f(0,0,0), 180,90,0);
        //rootNode.attachChild(cube1);
        allCubes.add(cube1);
        
        Spatial cube2 = createSpatial(rootNode, "Models/E-rw/E-rw.j3o", new Vector3f(-2,0,0), 180,90,0);
        //rootNode.attachChild(cube2);
        allCubes.add(cube2);
        
        Spatial cube3 = createSpatial(rootNode, "Models/C-rwg/C-rwg.j3o", new Vector3f(-4,0,0), 180,90,0);
        //rootNode.attachChild(cube3);
        allCubes.add(cube3);
        
       
        Spatial cube4 = createSpatial(rootNode, "Models/E-rb/E-rb.j3o", new Vector3f(0,-2,0), 180,90,0);
        //rootNode.attachChild(cube4);
        allCubes.add(cube4);
        
        Spatial cube5 = createSpatial(rootNode,"Models/S-r/S-r.j3o", new Vector3f(-2,-2,0), 180,90,0);
        //rootNode.attachChild(cube5);
        allCubes.add(cube5);
        
        Spatial cube6 = createSpatial(rootNode,"Models/E-rg/E-rg.j3o", new Vector3f(-4,-2,0), 180,90,0);
        //rootNode.attachChild(cube6);
        allCubes.add(cube6);
           
       
        Spatial cube7 = createSpatial(rootNode,"Models/C-ryb/C-ryb.j3o", new Vector3f(0,-4,0), 0,270,180);
        //bottomRow.attachChild(cube7);
        allCubes.add(cube7);
        
        Spatial cube8 = createSpatial(rootNode, "Models/E-ry/E-ry.j3o", new Vector3f(-2,-4,0), 0,270,180);
        //rootNode.attachChild(cube8);
        //bottomRow.attachChild(cube8);
        allCubes.add(cube8);
        
        cube9 = createSpatial(rootNode, "Models/C-ryg/C-ryg.j3o", new Vector3f(-4,-4
                ,0), 180,90,0);
        //rootNode.attachChild(cube9);
        //bottomRow.attachChild(cube9);
        allCubes.add(cube9);
        
        Spatial cube10
                = createSpatial(rootNode, "Models/E-bw/E-bw.j3o", new Vector3f(0,0,-2), 0,180,180);
        allCubes.add(cube10);
        
        Spatial cube11
                = createSpatial(rootNode, "Models/S-w/S-w.j3o", new Vector3f(-2,0,-2), 0,180,180);
        allCubes.add(cube11);
        
        
        Spatial cube12
                = createSpatial(rootNode, "Models/E-gw/E-gw.j3o", new Vector3f(-4,0,-2), 0,270,180);
        allCubes.add(cube12);
        
        Spatial cube13
                = createSpatial(rootNode, "Models/S-b/S-b.j3o", new Vector3f(0,-2,-2), 0,180,180);
        allCubes.add(cube13);
        
        Spatial cube14
                = createSpatial(rootNode, "Models/S-center/S-center.j3o", new Vector3f(-2,-2,-2), 0,180,180);
        allCubes.add(cube14);
        
        Spatial cube15
                = createSpatial(rootNode, "Models/S-g/S-g.j3o", new Vector3f(-4,-2,-2), 0,270,180);
        allCubes.add(cube15);
        
        Spatial cube16
                = createSpatial(rootNode, "Models/E-by/E-by.j3o", new Vector3f(0,-4,-2), 0,180,180);
        allCubes.add(cube16);
        
        Spatial cube17
                = createSpatial(rootNode, "Models/S-y/S-y.j3o", new Vector3f(-2,-4,-2), 0,180,180);
        allCubes.add(cube17);
        
        Spatial cube18
                = createSpatial(rootNode, "Models/E-gy/E-gy.j3o", new Vector3f(-4,-4,-2), 0,270,180);
        allCubes.add(cube18);
        
        
        Spatial cube19
                = createSpatial(rootNode, "Models/C-bow/C-bow.j3o", new Vector3f(0,0,-4), 0,180,180);
        allCubes.add(cube19);
        
        Spatial cube20
                = createSpatial(rootNode, "Models/E-ow/E-ow.j3o", new Vector3f(-2,0,-4), 0,180,180);
        allCubes.add(cube20);
        
        Spatial cube21
                = createSpatial(rootNode, "Models/C-gwo/C-gwo.j3o", new Vector3f(-4,0,-4), 0,270,180);
        allCubes.add(cube21);
        
        Spatial cube22
                = createSpatial(rootNode, "Models/E-bo/E-bo.j3o", new Vector3f(0,-2,-4), 0,180,180);
        allCubes.add(cube22);
        
        Spatial cube23
                = createSpatial(rootNode, "Models/S-o/S-o.j3o", new Vector3f(-2,-2,-4), 0,180,180);
        allCubes.add(cube23);
        
        Spatial cube24
                = createSpatial(rootNode, "Models/E-go/E-go.j3o", new Vector3f(-4,-2,-4), 0,270,180);
        allCubes.add(cube24);
        
        Spatial cube25
                = createSpatial(rootNode, "Models/C-boy/C-boy.j3o", new Vector3f(0,-4,-4), 0,180,180);
        allCubes.add(cube25);
        
        Spatial cube26
                = createSpatial(rootNode, "Models/E-oy/E-oy.j3o", new Vector3f(-2,-4,-4), 0,180,180);
        allCubes.add(cube26);
        
        
        Spatial cube27
                = createSpatial(rootNode, "Models/C-gyo/C-gyo.j3o", new Vector3f(-4,-4,-4), 0,270,180);
        allCubes.add(cube27);
        
        
        
        
        
        assignCubesToNode(allCubes);
        
        bottomRow.setLocalTranslation(new Vector3f(-2,-4, 0));
        
         inputManager.addMapping("RotateD",
                new KeyTrigger(KeyInput.KEY_R));

        // Test multiple listeners per mapping
        inputManager.addListener(actionListener, "RotateD");
 
    }
    
  public void assignCubesToNode(ArrayList<Spatial> allCubes){
      for (Spatial cube: allCubes ){
          rootNode.attachChild(cube);
      }
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
    
    Boolean added = false;
    float degree = FastMath.PI / 2;
    public void rotateD(float tpf, ArrayList<Spatial> allCubes){
   
       //for (int i = 0; i < 10; i ++){
        Node testRotate = new Node();
        
        for (int i = 0; i < 8; i++){
            
            if (!added){
                rootNode.detachChildAt(i);
                added = !added;
            }
            
            allCubes.get(i).setLocalTranslation(new Vector3f(-2,0,0));
            testRotate.attachChild(allCubes.get(i));
            
        }
        
        rootNode.attachChild(testRotate);
        
       
        
        Quaternion rotation=( new Quaternion()).fromAngleAxis(degree , new Vector3f(0,0,1));
        
        degree += FastMath.PI /2;
        if (degree > FastMath.PI * 2){
            degree = 0;
        }
       // Quaternion rotationVelocity=(new Quaternion()).fromAngles(0.0f,0.0f, 0f);
        
        Quaternion rotationVelocityFPS=new Quaternion();
        rotationVelocityFPS.slerp(Quaternion.IDENTITY, rotationVelocity, tpf);

        rotation.multLocal(rotationVelocityFPS);
        
        testRotate.setLocalRotation(rotation);
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
    
    public Spatial createSpatial(Node node, String modelPath, Vector3f translation, float rotX, float rotY, float rotZ ){
        
        Spatial object = assetManager.loadModel(modelPath);
        object.scale(1,1,1);   
        object.rotate(FastMath.DEG_TO_RAD * rotX, FastMath.DEG_TO_RAD * rotY, FastMath.DEG_TO_RAD*rotZ);
        object.setLocalTranslation(translation);
        node.attachChild(object);
        
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