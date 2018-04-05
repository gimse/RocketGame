package no.gimse.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rocket1 extends GameObject {
	
	private BufferedImage img;
	
	private double massCenterX;
	private double massCenterY;
	
	private double aRot;
	private double vRot;
	private double rRot;
	
	private double acsX;
	private double acsY;
	
	private double I;
	private double masse;
	
	Rocket1booster[] rockesboosters;
	

	public Rocket1(double x, double y, ID id) {
		super(x, y, id);
		//Laster bildet
		String bildeUrl = "resources" + File.separator + "rocket2.png";
		try {
		    img = ImageIO.read(new File(bildeUrl));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// A litle data about the rocket
		massCenterX=30;
		massCenterY=77;
		masse=2;
		I=masse*50*50;
		
		
		this.aRot=0;
		this.vRot=0;
		this.rRot=0;
		
		this.acsX=0;
		this.acsY=0;
		
		//Making a rocketboosters
		rockesboosters = new Rocket1booster[2];
		rockesboosters[0] = new Rocket1booster(this,14,143,0,-0.01,IDBooster.V);
		rockesboosters[1] = new Rocket1booster(this,46,143,0,-0.01,IDBooster.H);
		
	}

	@Override
	public void tick() {
		
		aRot=0;
		acsX=0;
		acsY=0;
		for (int i=0;i<rockesboosters.length;i++){
			rockesboosters[i].oppdater();
			aRot+=rockesboosters[i].getTorque()/I;
			acsX+=rockesboosters[i].getFX()/masse;
			acsY+=rockesboosters[i].getFY()/masse;
		}
		
		vRot+=aRot;
		rRot+=vRot;
		
		setVelX(getVelX()+acsX);
		setVelY(getVelY()+acsY);
		setX(getX()+getVelX());
		setY(getY()+getVelY());
		

	}

	@Override
	public void render(Graphics g) {
		
		AffineTransform at = new AffineTransform();
		at.translate(x, y);
		at.rotate(rRot);
		at.translate(-massCenterX, -massCenterY);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, at, null);

	}
	
	
	public double getMassCenterX() {
		return massCenterX;
	}

	public void setMassCenterX(double massCenterX) {
		this.massCenterX = massCenterX;
	}

	public double getMassCenterY() {
		return massCenterY;
	}

	public void setMassCenterY(double massCenterY) {
		this.massCenterY = massCenterY;
	}

	public double getARot() {
		return aRot;
	}

	public void setARot(double aRot) {
		this.aRot = aRot;
	}

	public double getVRot() {
		return vRot;
	}

	public void setVRot(double vRot) {
		this.vRot = vRot;
	}

	public double getRRot() {
		return rRot;
	}

	public void setRRot(double rRot) {
		this.rRot = rRot;
	}

	public double getAcsX() {
		return acsX;
	}

	public void setAcsX(double acsX) {
		this.acsX = acsX;
	}

	public double getAcsY() {
		return acsY;
	}

	public void setAcsY(double acsY) {
		this.acsY = acsY;
	}
	public Rocket1booster[] getRockesboosters() {
		return rockesboosters;
	}

	public void setRockesboosters(Rocket1booster[] rockesboosters) {
		this.rockesboosters = rockesboosters;
	}

}
