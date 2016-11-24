package GUI.fields;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import GUI.board.Center;
import GUI.backend.SwingComponentFactory;

public final class Tax extends NotOwnable {
    private static final int TOPHEIGHT = 51;
    private static final int TITLEHEIGHT = 30;
    private JLabel topLabel;
    private ImageIcon icon;
    private SwingComponentFactory factory = new SwingComponentFactory();
    
    public static class Builder extends Field.Builder<Tax.Builder> implements iBuilder {

        
        @Override
        @SuppressWarnings("synthetic-access")
        public Tax build() {
            return new Tax(this.picture, this.title, this.subText,
                    this.description, this.bonus, this.bgColor, this.fgColor);
        }

        public Builder setPicture(String picture) {
            this.picture = picture;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
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
        public Builder setTax(String tax) {
            this.bonus = tax;
            return this;
        }
    }

    private Tax(String picture, String title, String subText, String description,
                String tax, Color bgColor, Color fgColor) {
        super(bgColor, fgColor, title, subText, description, tax);

            try {
                this.icon = new ImageIcon(picture);
            } catch(Exception e) {
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
    private JLabel makeTitleLabel(String titleTax) {
        JLabel l = makeLabel(TITLEHEIGHT);
        l.setText(titleTax);
        return l;
    }
    @Override
    public void displayOnCenter() {
        super.displayOnCenter();
        Center.label[1].setIcon(this.icon);
//        Center.label[1].setText("__________________________");
        Center.label[2].setText(this.description);
        Center.label[4].setText(this.subText);
        Center.label[5].setText(getBonus());
        super.displayMoverOnCenter();
    }
}
