package GUI.fields;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import GUI.board.Center;
import GUI.backend.Player;
import GUI.backend.SwingComponentFactory;

public abstract class Ownable extends Field{
	public static final String OWNABLELABEL = "Owned by: ";
	protected Player owner;
	private String rent;
	private String price;
	public Ownable(Color bgColor, Color fgColor, String title,
		String subText, String description, String rent, String price){
		super(bgColor, fgColor, title, subText, description);
		this.rent = rent;
		this.price = price;
	}
	
	public Player getOwner(){return this.owner; }
	public void setOwner(Player owner){
		this.owner = owner;
		Border border;
		if(owner == null){
			border = BorderFactory.createLineBorder(Color.BLACK, 1);
			this.subTextLabel.setText(this.subText);
		}else{
			SwingComponentFactory factory = new SwingComponentFactory();
			Color c1 = this.owner.getPrimaryColor();
			Color c2 = this.owner.getSecondaryColor();
			border = factory.createDashedBorder(2, 5, c1, c2);
			String nameToUse = owner.getName();
			nameToUse = (nameToUse.length() > 11) ? nameToUse.substring(0, 8)+"..." : nameToUse;
			this.subTextLabel.setText(nameToUse);
		}
		this.layered.setBorder(border);
		
	}
	public String getRent(){
		return this.rent;
	}

	public String getPrice() { return this.price; }
	
	@Override
	public void displayOnCenter(){
		super.displayOnCenter();
		Border border;
		if(this.owner != null){
			SwingComponentFactory factory = new SwingComponentFactory();
			Color c1 = this.owner.getPrimaryColor();
			Color c2 = this.owner.getSecondaryColor();
			border = factory.createDashedBorder(3, 10, c1, c2);
			Center.getInstance().getCenterPanel().setBorder(border);
		}else{
			border = javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3);
		}
		Center.getInstance().getCenterPanel().setBorder(border);
	}
}