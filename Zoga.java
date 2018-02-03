/**
*
* Copyright 2018, Lan Zukanovic, All rights reserved.
* 
*
*/

import java.awt.*;

class Zoga{
	
	private Pong igra;
	private double xZdaj,yZdaj;
	private double xPlus,yPlus;

	public Zoga(Pong p){
		this.igra=p;
		xZdaj=250.0;
		yZdaj=250.0;
		xPlus=randomHitrost() * randomSmer();
		yPlus=randomHitrost() * randomSmer();
	}

	boolean konec=false;

	private static final int PREMER=9;

	void move(){
		// udarec leve stene
		if(xZdaj+xPlus<0){
			igra.pc.setTocke();
			reset();
		}
		// udarec desne stene
		if(xZdaj+xPlus>igra.getWidth()-PREMER){
			igra.l.setTocke();
			reset();
		}
		// udarec zgornje stene
		if(yZdaj+yPlus<0){
			yPlus=-1*yPlus;
		}
		// udarec spodnje stene
		if(yZdaj+yPlus>igra.getHeight()-PREMER){
			yPlus=-1*yPlus;
		}
		if(udar()){
			xPlus=-1*xPlus;
		}
		if(udarPC()){
			xPlus=-1*xPlus;
		}
		if(igra.l.vrniTocke()>=5 || igra.pc.vrniTocke()>=5){
			konec=true;
		}
		xZdaj+=xPlus;
		yZdaj+=yPlus;
	}

	public void paint(Graphics2D g){
		g.setColor(Color.WHITE);
		g.fillRect((int)xZdaj,(int)yZdaj,PREMER,PREMER);
	}

	public Rectangle vrniPravokotnik(){
		return new Rectangle((int)xZdaj,(int)yZdaj,PREMER,PREMER);
	}
	public boolean udar(){
		return igra.l.vrniPravokotnik().intersects(vrniPravokotnik());
	}
	public boolean udarPC(){
		return igra.pc.vrniPravokotnik().intersects(vrniPravokotnik());
	}
	public void reset(){

		xZdaj=250;
		yZdaj=250;

		igra.l.reset();
		igra.pc.reset();
	}
	public double vrniX(){
		return xZdaj;
	}
	public double vrniY(){
		return yZdaj;
	}
	public boolean aliKonec(){
		return konec;
	}
	public double randomHitrost(){
		return Math.random()*1+2;
	}
	public int randomSmer(){
		int rand=(int)Math.random()*2;
		if(rand==1) return 1;
		else return -1;
	}
}