package GUI.fields;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import GUI.board.Center;
import GUI.backend.Player;
import GUI.backend.SwingComponentFactory;

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