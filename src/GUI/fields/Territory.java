package GUI.fields;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.board.Center;
import GUI.backend.SwingComponentFactory;

public final class Territory extends Ownable {
    private static final int TOPHEIGHT = 51;
    private static final int TITLEHEIGHT = 30;
    private ImageIcon icon;
    private JLabel topLabel;
    private SwingComponentFactory factory = new SwingComponentFactory();
    
    public static class Builder extends Field.Builder<Territory.Builder> implements iBuilder {

        @Override
        @SuppressWarnings("synthetic-access")
        public Territory build() {
            return new Territory(this.picture, this.title,
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
    
    private Territory(String picture, String title,
                      String subText, String description, String rent, String price, Color bgColor, Color fgColor) {
        super(bgColor, fgColor, title, subText, description, rent, price);

        try {
            this.icon = new ImageIcon(picture);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Bad Resource: " + picture);
        }

        this.topLabel = makeTopLabel();
        this.titleLabel = makeTitleLabel(this.title);
        this.layered.add(this.topLabel, this.factory.createGridBagConstraints(0, 0));
        this.layered.add(this.titleLabel, this.factory.createGridBagConstraints(0, 2));
    }

    private JLabel makeTopLabel() {
        JLabel l = makeLabel(TOPHEIGHT);
        l.setIcon(this.icon);
        return l;
    }
    private JLabel makeTitleLabel(String title) {
        JLabel titleLabel = makeLabel(TITLEHEIGHT);
        titleLabel.setText(title);
        return titleLabel;
    }
    @Override
    public void displayOnCenter() {
        super.displayOnCenter();
        Center.label[1].setIcon(this.icon);
//        Center.label[3].setText("__________________________");
        Center.label[3].setText(this.description);
        Center.label[4].setText(this.subText);
        if (this.owner != null) {
            Center.label[5].setText(OWNABLELABEL + this.owner.getName());
            Center.label[6].setText(getRent());
        } else {
            Center.label[6].setText(getPrice());
        }
        super.displayMoverOnCenter();
    }
}
