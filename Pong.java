/**
*
* Copyright 2018, Lan Zukanovic, All rights reserved.
* 
*
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JPanel {

	Zoga z=new Zoga(this);
	Lopar l=new Lopar(this);
	LoparPC pc=new LoparPC(this);
	private boolean zacetekIgre;

	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2=(Graphics2D) g;
		FontMetrics fm=g.getFontMetrics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		//if(vrniZacetek()){
			if(z.aliKonec()){
				g.setColor(Color.RED);
				g.drawString("Konec igre!",Math.round(getWidth()/2-fm.stringWidth("Konec igre!")/2),getHeight()/2-5);
			}
			else{
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect((int)Math.round(getWidth()/2-1),0,2,getHeight());

				g.drawString(""+pc.vrniTocke(),Math.round(getWidth()/2+5),15);
				g.drawString(""+l.vrniTocke(),Math.round(getWidth()/2-5-fm.stringWidth(""+l.vrniTocke())),15);

				z.paint(g2);
				l.paint(g2);
				pc.paint(g2);
			}
		//}else{
		//	g.setColor(Color.WHITE);
		//	g.drawString("Pritisni tipko ENTER",Math.round(getWidth()/2-fm.stringWidth("Pritisni tipko ENTER")/2),getHeight()/2-5);
		//}
	}

	public Pong(){
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e){
				l.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					setZacetek();
				}
			}
			@Override
			public void keyReleased(KeyEvent e){
				l.keyReleased(e);
			}
			@Override
			public void keyTyped(KeyEvent e){}
		});
		setFocusable(true);
	}
 
	public void konec(){
		System.exit(ABORT);
	}
	public boolean vrniZacetek(){
		return this.zacetekIgre;
	}
	public void setZacetek(){
		this.zacetekIgre=true;
	}
	

	public static void main(String[] args) throws InterruptedException{
		JFrame okvir=new JFrame("Pong");
		Pong p=new Pong();
		okvir.add(p);
		okvir.setSize(500,500);
		okvir.setVisible(true);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setLocationRelativeTo(null);

		while(true){
			//if(vrniZacetek()){
				p.move();
				p.repaint();
				Thread.sleep(10);
			//}
		}
	}

	private void move(){
		z.move();
		l.move();
		pc.move();
	}
}