package GUI.fields;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.board.Center;
import GUI.backend.SwingComponentFactory;

public final class Refuge extends NotOwnable {
    private static final int TOPHEIGHT = 51;
    private static final int TITLEHEIGHT = 30;
    private JLabel topLabel;
    private ImageIcon icon;
    private SwingComponentFactory factory = new SwingComponentFactory();
    
    public static class Builder extends Field.Builder<Refuge.Builder> implements iBuilder {

        @Override
        @SuppressWarnings("synthetic-access")
        public Refuge build() {
            return new Refuge(this.picture, this.title, this.subText,
                    this.description, this.bonus, this.bgColor, this.fgColor);
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
        public Builder setBonus(String bonus) {
            this.bonus = bonus;
            return this;
        }
    }
    
    private Refuge(String picture, String title, String subText, String description,
                   String bonus, Color bgColor, Color fgColor) {
        super(bgColor, fgColor, title, subText, description, bonus);

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
    private JLabel makeTitleLabel(String titleRefuge) {
        JLabel l = makeLabel(TITLEHEIGHT);
        l.setText(titleRefuge);
        return l;
    }
    @Override
    public void displayOnCenter() {
        super.displayOnCenter();
        Center.label[1].setIcon(this.icon);
//        Center.label[2].setText(this.title);
//        Center.label[1].setText(this.title.replace("<html><center>", ""));

//        Center.label[3].setText("__________________________");
        Center.label[2].setText(this.description);
        Center.label[3].setText(this.subText);
        Center.label[4].setText(getBonus());
        super.displayMoverOnCenter();
    }
}
