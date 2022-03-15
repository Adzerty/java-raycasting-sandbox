package sandbox.raycasting;

public class Renderer implements Runnable{
	
	private Frame frame;
	
	public final int FRAME_RATE = 60;
	
	@Override
	public void run() {
		double deltaT;
	    double savedTime = 0.0;
	    boolean canRender = true;
	    
		while(true) {
			
			double actualTime = System.currentTimeMillis();
			
			//Si on est dans une nouvelle seconde 
			//System.out.println(actualTime - savedTime);
			if(actualTime - savedTime > (1000.0/FRAME_RATE) ) {
				canRender = true;
				savedTime = actualTime;
			}
			
			//System.out.println(frameInThisSecond);
			
			if(canRender){
				if(frame == null) {
					frame = Frame.getInstance();
				}
				
				frame.draw();
			}
			
			canRender = false;

		}
	}
	
	
}

