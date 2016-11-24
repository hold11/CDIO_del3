package GUI.fields;

import java.awt.Color;

public abstract class NotOwnable extends Field{
    private String bonus;

    public NotOwnable(Color bgColor, Color fgColor, String title,
                   String subText, String description, String bonus){
        super(bgColor, fgColor, title, subText, description);
        this.bonus = bonus;
    }

    public String getBonus(){
        return this.bonus;
    }
}