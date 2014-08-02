package com.coolcomputerpctricks.tutorialgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;


/** 
 *  www.coolcomputerpctricks.com
 *  Android Game development tutorial * 
 */

public class ItemImages {
	private float width;
    private float height;
    private float left;
    private float top;
    private Bitmap bmp;
    private boolean visible; 
    
    public ItemImages(Bitmap bmp,float left, float top)
    {
    	this.width = bmp.getWidth();  
        this.height = bmp.getHeight();
        this.bmp=bmp;
		this.left=left;
		this.top=top;
		this.setVisible(true);
    }
    public void setBmp(Bitmap bmp) {
		this.bmp = bmp;
	}
	public void drawBMP(Canvas canvas) {
		if(canvas!=null && bmp!=null)
			canvas.drawBitmap(bmp, left, top, null);
    }
    public void drawBMP(Canvas canvas,Rect src,Rect dst) {
		if(canvas!=null && bmp!=null)
			canvas.drawBitmap(bmp, src, dst, null);
    }
    public boolean isCollition(float x2, float y2) {
        return x2 > left && x2 < left + width && y2 > top && y2 < top + height;
    }
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getTop() {
		return top;
	}
	public void setTop(float top) {
		this.top = top;
	}
	public float getLeft() {
		return left;
	}
	public void setLeft(float left) {
		this.left = left;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}	
}
