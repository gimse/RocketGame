package no.gimse.game;
public class Rocket1booster {
	
	private Rocket1 rocket;
	private int posX,posY;
	private double lengdeX,lengdeY;
	private double l,torque,lengdeRealtiv2X,lengdeRealtiv2Y;
	private boolean on;
	private IDBooster Id;
	
	public Rocket1booster(Rocket1 rocket,int posX,int posY,double lengdeX,double lengdeY,IDBooster Id) {
		this.rocket=rocket;
		this.posX=posX;
		this.posY=posY;
		this.lengdeX=lengdeX;
		this.lengdeY=lengdeY;
		this.Id=Id;
		on=false;
		oppdater();
	}
	
	

	public void oppdater(){
		double rX=-(rocket.getMassCenterX()-posX);
		double rY=-(rocket.getMassCenterY()-posY);
		double theta2=Math.atan2(rY, rX);
		double theta3=Math.atan2(lengdeY, lengdeX)-theta2;
		double lengthF=Math.sqrt(lengdeX*lengdeX+lengdeY*lengdeY);
		l=lengthF*Math.sin(theta3);
		double lengthR=Math.sqrt(rX*rX+rY*rY);
		torque=lengthR*l;
		
		double lengthF2 = lengthF*Math.cos(theta3);
		lengdeRealtiv2X = lengthF2*Math.cos(rocket.getRRot()+theta2);
		lengdeRealtiv2Y = lengthF2*Math.sin(rocket.getRRot()+theta2);
		
	}
	
	
	public double getTorque(){
		if (on){
			return torque;
		}
		return 0;
	}
	public double getFX(){
		if (on){
			return lengdeRealtiv2X;
		}
		return 0;
	}
	public double getFY(){
		if (on){
			return lengdeRealtiv2Y;
		}
		return 0;
	}
	public void turnOn(){
		on=true;
	}
	public void turnOff(){
		on=false;
	}
	public IDBooster getId() {
		return Id;
	}

	public void setId(IDBooster id) {
		Id = id;
	}
}
