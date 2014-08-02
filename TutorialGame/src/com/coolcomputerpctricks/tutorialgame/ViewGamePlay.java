package com.coolcomputerpctricks.tutorialgame;

import java.util.Random;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/** 
 *  www.coolcomputerpctricks.com
 *  Android Game development tutorial * 
 */

public class ViewGamePlay extends SurfaceView{

	
	MainThread thread;
	ItemImages bgImage,parachute;
	int max,min;
	
	public ViewGamePlay(Context context) {
		super(context);
		thread = new MainThread(getHolder(), this);
		getHolder().addCallback(new SurfaceHolder.Callback() {
			public void surfaceDestroyed(SurfaceHolder holder) {
				boolean retry = true;
				while (retry) {
					try {
						thread.setRunning(false);
						thread.join();
						retry = false;
					} catch (Exception e) {
						e.printStackTrace();						
					}
				}
			}
			public void surfaceCreated(SurfaceHolder holder) {
			   		   
					Canvas c = holder.lockCanvas(null);
					initializeGame(c);
					drawGame(c);
					holder.unlockCanvasAndPost(c); 
					thread.setRunning(true);
					try{
						thread.start();
					}catch(Exception e){
						e.printStackTrace();
					}
			}

			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
				//Surface changed
			}
		});		

	}



	public void initializeGame(Canvas canvas){
		
		bgImage =  new  ItemImages(BitmapFactory.decodeResource(getResources(), R.drawable.sky),0,0);
		parachute = new  ItemImages(BitmapFactory.decodeResource(getResources(), R.drawable.parachute),0,0);
		
		//Random left position for the parachute
		max=(int) (canvas.getWidth()-parachute.getWidth());
		min=0;
		Random rand = new Random();		
		int randomNum = rand.nextInt((max - min) + 1) + min;
		parachute.setLeft(randomNum);
	
	}
	
	protected void drawGame(Canvas canvas) {	
		
		bgImage.drawBMP(canvas);
		parachute.drawBMP(canvas);
			
	}	
	
	
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		if(parachute.isCollition(x, y))
			{
				// If player touched, reset the parachute location
				parachute.setTop(0);
				Random rand = new Random();		
				int randomNum = rand.nextInt((max - min) + 1) + min;
				parachute.setLeft(randomNum);
				
			}
		return true;
	}
	
	public void render(Canvas canvas) {
		
		parachute.setTop(parachute.getTop()+2);
		
		if(parachute.getTop()>canvas.getHeight()){
			parachute.setTop(0);
			// Reset the parachute location
			parachute.setTop(0);
			Random rand = new Random();		
			int randomNum = rand.nextInt((max - min) + 1) + min;
			parachute.setLeft(randomNum);
		}		
		drawGame(canvas);
	}
	
	
}

