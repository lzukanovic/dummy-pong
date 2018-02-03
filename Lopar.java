/**
*
* Copyright 2018, Lan Zukanovic, All rights reserved.
* 
*
*/

import java.awt.*;
import java.awt.event.*;

class Lopar{
	
	private Pong igra;
	private int tocke;

	public Lopar(Pong p){
		this.igra=p;
		this.tocke=0;
	}

	int y=225;
	int yPlus=0;

	void move(){
		if(y+yPlus>=0 && y+yPlus<igra.getHeight()-50) y+=yPlus;
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP) yPlus=-5;
		if(e.getKeyCode() == KeyEvent.VK_DOWN) yPlus=5;
	}

	public void keyReleased(KeyEvent e){
		yPlus=0;
	}

	public void paint(Graphics2D g){
		g.fillRect(10,y,10,50);
	}

	public Rectangle vrniPravokotnik(){
		return new Rectangle(10,y,10,50);
	}
	public int vrniX(){
		return 10;
	}
	public int vrniY(){
		return y;
	}
	public int vrniTocke(){
		return this.tocke;
	}
	public void setTocke(){
		this.tocke++;
	}
	public void reset(){
		y=igra.getHeight()/2-25;
	}
}