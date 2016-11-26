package GUI.backend;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Player entity
 * @author Ronnie
 */
public class Player{
	private int number;
	private String name;
	private int balance;
	
	private Mover mover;
	public static final int ICON_WIDTH = 36;
	public static final int ICON_HEIGHT = 58;

	public Player(int number, String name, int balance, Mover mover){
		this.number = number;
		this.name = name;
		this.balance = balance;
		this.mover = mover;
		
	}
	public int getNumber(){
		return this.number;
	}
	public String getName(){
		return this.name;
	}
	public int getBalance(){
		return this.balance;
	}
	public void setBalance(int balance){
		this.balance = balance;
	}
	public Color getPrimaryColor(){
		return this.mover.getPrimaryColor();
	}
	public Color getSecondaryColor(){
		return this.mover.getSecondaryColor();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		if (this.name == null) {
			if(other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}
	public BufferedImage getImage() {
		return this.mover.getImage();
	}
}