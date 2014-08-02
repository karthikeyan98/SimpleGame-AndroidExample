package com.coolcomputerpctricks.tutorialgame;
/**
 * 
 */


import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/** 
 *  www.coolcomputerpctricks.com
 *  Android Game development tutorial * 
 */

public class MainThread extends Thread {
	
	private static final String TAG = MainThread.class.getSimpleName();
	
	// Frames Per seconds
	public  int MAX_FPS = 150;	
	private  int	FRAME_PERIOD = 1000 / MAX_FPS;	
	private SurfaceHolder surfaceHolder;
	private ViewGamePlay gamePanel;
	private boolean running;
	
	public void setRunning(boolean running) {
		this.running = running;
	}

	public MainThread(SurfaceHolder surfaceHolder, ViewGamePlay gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		Canvas canvas;
		long beginTime;		
		long timeDiff;		
		int sleepTime;		
		sleepTime = 0;
		while (running) {			
			canvas = null;
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					beginTime = System.currentTimeMillis();
					this.gamePanel.render(canvas);				
					timeDiff = System.currentTimeMillis() - beginTime;
					sleepTime = (int)(FRAME_PERIOD - timeDiff);
					if (sleepTime > 0) { 
						try {
							Thread.sleep(sleepTime);	
						} catch (InterruptedException e) {}
					}
					
				}
			} finally {
				if (canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}	
		}
	}	
}
