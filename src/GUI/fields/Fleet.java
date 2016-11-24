package GUI.fields;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.board.Center;
import GUI.backend.SwingComponentFactory;

public final class Fleet extends Ownable {
	private static final int TOPHEIGHT = 31;
	private static final int TITLEHEIGHT = 16;
	private static final int SUBTEXTHEIGHT = 14;
	private JLabel topLabel;
	private ImageIcon icon;
	private SwingComponentFactory factory = new SwingComponentFactory();
	
	public static class Builder extends Field.Builder<Fleet.Builder> implements iBuilder{

        
        @Override
        @SuppressWarnings("synthetic-access")
        public Fleet build() {
            return new Fleet(this.picture, this.title,
                this.subText, this.description, this.rent, this.price, this.bgColor, this.fgColor);
        }
        
        public Builder setPicture(String picture) {
            this.picture = picture;
            return this;
        }
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        public Builder setSubText(String subText) {
            this.subText = subText;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setRent(String rent) {
            this.rent = rent;
            return this;
        }
		public Builder setPrice(String price) {
			this.price = price;
			return this;
		}
    }
	
	private Fleet(String picture, String title, String subText,
                  String description, String rent, String price, Color bgColor, Color fgColor) {
		super(bgColor, fgColor, title, subText, description, rent, price);

			try {
				this.icon = new ImageIcon(picture);
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Bad Resource: " + picture);
			}
		
		this.topLabel = makeTopLabel();
		super.titleLabel = makeRoadNameLabel(this.title);
		super.subTextLabel = makeBottomLabel(this.subText);
		this.layered.add(this.topLabel, this.factory.createGridBagConstraints(0, 0));
		this.layered.add(this.titleLabel, this.factory.createGridBagConstraints(0, 1));
		this.layered.add(this.subTextLabel, this.factory.createGridBagConstraints(0, 2));
	}
	private JLabel makeTopLabel() {
		JLabel l = makeLabel(TOPHEIGHT);
		l.setIcon(this.icon);
		return l;
	}
	private JLabel makeRoadNameLabel(String titleShipping) {
		JLabel roadnameLabel = makeLabel(TITLEHEIGHT);
		roadnameLabel.setText(titleShipping);
		return roadnameLabel;
	}
	private JLabel makeBottomLabel(String subTextShipping) {
		JLabel bottomLabel = makeLabel(SUBTEXTHEIGHT);
		bottomLabel.setText(subTextShipping);
		return bottomLabel;
	}
	public String getRoadname() {
		return this.title;
	}
	public String getBottomText() {
		return this.subText;
	}
	@Override
	public void displayOnCenter() {
		super.displayOnCenter();
		Center.label[1].setIcon(this.icon);
		Center.label[2].setText("__________________________");
		Center.label[3].setText(this.description);
		Center.label[4].setText(this.subText);
		if(this.owner != null) {
			Center.label[5].setText(OWNABLELABEL + this.owner.getName());
			Center.label[6].setText(getRent());
		} else {
			Center.label[5].setText(getPrice());
		}
		super.displayMoverOnCenter();
	}
}
