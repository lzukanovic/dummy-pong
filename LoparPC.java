/**
*
* Copyright 2018, Lan Zukanovic, All rights reserved.
* 
*
*/

import java.awt.*;
import java.awt.event.*;

class LoparPC{
	
	private Pong igra;
	private int tocke;

	public LoparPC(Pong p){
		this.igra=p;
		this.tocke=0;
	}

	int y=225;

	void move(){

		int kopija=(int)igra.z.vrniY()-25;
		if(kopija>=0 && kopija<igra.getHeight()-50){
			y=kopija;
		}
	}


	public void paint(Graphics2D g){
		g.fillRect(igra.getWidth()-20,y,10,50);
	}

	public Rectangle vrniPravokotnik(){
		return new Rectangle(igra.getWidth()-20,y,10,50);
	}
	public int vrniX(){
		return igra.getWidth()-20;
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