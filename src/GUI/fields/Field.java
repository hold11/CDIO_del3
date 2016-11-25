package GUI.fields;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import GUI.board.Board;
import GUI.board.Center;
import GUI.backend.FieldMouseListener;
import GUI.backend.Player;
import GUI.backend.SwingComponentFactory;

public abstract class Field {
	public static final int FIELDWIDTH = 85;
	public static final int FIELDHEIGHT = 85;
	private static int nextNumber = 0;
	protected int number;
	private int x;
	private int y;
	protected JLayeredPane layered = new JLayeredPane();
	protected JLabel titleLabel;
	protected JLabel subTextLabel;
	protected Color bgColor;
	protected Color fgColor;
	protected String title;
	protected String subText;
	protected String description;
	private boolean[] hasMovers = new boolean[Board.MAX_PLAYER_COUNT];
	private SwingComponentFactory factory = new SwingComponentFactory();
	private JLabel[] Movers;
	private static Point[] points = new Point[40];
    private static int nextPoint = 0;
    
    static{
        int i = 0;
        for(int x=10; x > 0; x--){
            Field.points[i++] = new Point(x, 10);
        }
        for(int y=10; y > 0; y--){
            Field.points[i++] = new Point(0, y);
        }
        for(int x=0; x < 10; x++){
            Field.points[i++] = new Point(x, 0);
        }
        for(int y=0; y < 10; y++){
            Field.points[i++] = new Point(10, y);
        }
    }
    
    public static class Builder<E> {
        protected String title = "";
        protected String subText = "";
        protected String description = "";
        protected String picture = "";
        protected String rent = "";
        protected String price = "";
        protected String bonus = "";
        protected Color bgColor = new Color(24, 39, 51);
        protected Color fgColor = new Color(230, 230, 230);
        
        @SuppressWarnings("unchecked")
        public E setFgColor(Color fgColor) {
            this.fgColor = fgColor;
            return (E)this;
        }
        @SuppressWarnings("unchecked")
        public E setBgColor(Color bgColor) {
            this.bgColor = bgColor;
            return (E)this;
        }
    }

    protected Field(Color bgColor, Color fgColor, String title, String subText, String description) {
        this(bgColor, fgColor, title, subText, description, BorderFactory.createLineBorder(Color.BLACK));
    }
	protected Field(Color bgColor, Color fgColor, String title, String subText, String description , Border border) {
		nextNumber = (nextNumber % 40) + 1;
		this.number = nextNumber;
		Point p = Field.points[nextPoint];
        nextPoint = ++nextPoint % 40;
        this.x = p.x;
        this.y = p.y;
		this.bgColor = bgColor;
		this.fgColor = fgColor;
		this.makeLabels();
		this.setTitle(title);
		this.setSubText(subText);
		this.setDescription(description);
		this.layered.setBackground(bgColor);
		this.layered.setForeground(fgColor);
		this.layered.setOpaque(true);
		this.layered.setBorder(border);
		this.factory.setSize(this.layered, FIELDWIDTH, FIELDHEIGHT);
		this.layered.addMouseListener(new FieldMouseListener(this));
		this.layered.setLayout(new GridBagLayout());
	}
	private void makeLabels() {
		this.titleLabel = makeLabel(24);
		this.titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		this.titleLabel.setText(this.title);
		this.subTextLabel = makeLabel(10);
		this.subTextLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		this.subTextLabel.setText(this.subText);
	}
	public boolean hasMover(String name) {
		Player p = Board.getInstance().getPlayer(name);
		return this.hasMovers[p.getNumber()];
	}
	public void setMover(String name, boolean hasMover) {
		Board board = Board.getInstance();
		Player p = board.getPlayer(name);
		if(p != null) {
			this.hasMovers[p.getNumber()] = hasMover;
			this.Movers[p.getNumber()].setIcon(new ImageIcon(p.getImage()));
			this.Movers[p.getNumber()].setVisible(hasMover);
		}
	}
	/**
	 * Makes a standard label
	 * @param height - in px
	 * @return a JLabel object
	 */
	public JLabel makeLabel(int height) {
		JLabel label = new JLabel();
		this.factory.setSize(label, 1 * FIELDWIDTH - 2, height);
		label.setFont(new java.awt.Font(Board.FONT, 0, Board.FONTSIZE));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(this.bgColor);
		label.setForeground(this.fgColor);
		return label;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public JLayeredPane getPanel() {
		return this.layered;
	}
	public void setTitle(String title) {
		this.title = "<html><center>" + title.replace("\\n", "<br>");
		this.titleLabel.setText(this.title);
	}
	public void setSubText(String subText) {
		this.subText = subText;
		this.subTextLabel.setText(subText);
	}
	public void setDescription(String description) {
		if(description.length() > 20) {
			this.description = "<html><table><tr><td>"
				+ description.replace("\\n", "<br>");
		} else {
			this.description = description;
		}
	}
	public void setMoverIcons(JLabel[] Movers) {
		this.Movers = Movers;
	}
	/**
	 * Each type of field displays information on the center
	 */
	public void displayOnCenter(){
		Center.getInstance().clearLabels();
		Center.getInstance().setBGColor(this.bgColor);
		Center.getInstance().setFGColor(this.fgColor);
		for(JLabel l : Center.label){
			l.setBackground(this.bgColor);
			l.setForeground(this.fgColor);
		}
		Center.label[0].setText("" + this.number);
	}
	protected void displayMoverOnCenter() {
		for(int i = 0; i < Board.MAX_PLAYER_COUNT; i++) {
			Player p = Board.playerList[i];
			if(p != null && hasMover(p.getName())) {
				Center.Movers[i].setIcon(new ImageIcon(p.getImage()));
				Center.Movers[i].setVisible(true);
			} else {
				Center.Movers[i].setIcon(null);
				Center.Movers[i].setVisible(false);
			}
		}
	}
}