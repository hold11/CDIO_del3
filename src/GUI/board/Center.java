package GUI.board;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import GUI.backend.CenterMouseListener;
import GUI.backend.Player;
import GUI.backend.SwingComponentFactory;
import GUI.fields.Field;

public final class Center{
	private static Center center;
	private static JPanel centerPanel;
	public static JLabel[] label = new JLabel[7];
	public static JLabel[] Movers = new JLabel[Board.MAX_PLAYER_COUNT];
	public static String chanceCardText = "";
	private JLayeredPane playersPane = new JLayeredPane();
	
	private SwingComponentFactory factory = new SwingComponentFactory();

	private Center(){
		centerPanel = new javax.swing.JPanel();
		this.factory.setSize(centerPanel, 3*Field.FIELDWIDTH, 3*Field.FIELDHEIGHT);
		centerPanel.addMouseListener(new CenterMouseListener(this));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		 
		for(int i=0; i<label.length; i++){
			label[i] = new javax.swing.JLabel();
			label[i].setOpaque(false);
			label[i].setVerticalAlignment(javax.swing.SwingConstants.CENTER);
			label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			centerPanel.add(label[i]);
		}
		for(int i = 0; i < Movers.length; i++){
			JLabel l = new JLabel();
			Movers[i] = l;
			l.setOpaque(false);
			l.setBounds(25*i+3, 0, Player.ICON_WIDTH, Player.ICON_HEIGHT);
			this.playersPane.setLayer(l, i+6);
			l.setVisible(false);
			this.playersPane.add(l);
		}
		centerPanel.add(this.playersPane);
		displayDefault();
	}
	/**
	 * Retrieves the singleton instance
	 * @return the Center instance
	 */
	public static Center getInstance(){
		if(center == null){
			center = new Center();
		}
		return center;
	}
	/**
	 * Clears all center labels;
	 * (icon label is handled seperatly)
	 */
	public void clearLabels(){
		for(JLabel l : label){
			l.setText("");
			l.setIcon(null);
		}
	}
	/**
	 * Sets the backgroundcolor of the center
	 * @param bgColor The background color
	 */
	public void setBGColor(Color bgColor){
		centerPanel.setBackground(bgColor);
	}
	/**
	 * Sets the foregroundcolor of the center
	 * @param fgColor The foreground color
	 */
	public void setFGColor(Color fgColor){
		centerPanel.setForeground(fgColor);
	}
	/**
	 * Display standard version of the center
	 */
	public void displayDefault(){
		centerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
		clearLabels();
		label[1].setIcon(new ImageIcon(getClass().getResource("/GUI/art/Misc/The_Werewall_Background.png")));
		label[0].setText("LANDLORDOPOLY");
		label[0].setFont(new Font(label[0].getFont().getName(), Font.BOLD, 24));
		label[0].setVerticalTextPosition(SwingConstants.TOP);
		label[0].setHorizontalTextPosition(SwingConstants.CENTER);
		centerPanel.setBackground(Board.BASECOLOR);
		for(JLabel l : Center.label){
			l.setBackground(Board.BASECOLOR);
			l.setForeground(Color.BLACK);
		}
		for(int i=0; i<Board.MAX_PLAYER_COUNT; i++){
			Center.Movers[i].setVisible(false);
		}
	}
    /**
     * Displays the next chance card
     */
	public void displayChanceCard() {
        clearLabels();

		label[0].setText("<html><table><tr><td>" + chanceCardText);
		label[0].setFont(new Font(label[0].getFont().getName(), Font.BOLD, 14));
		label[0].setVerticalTextPosition(SwingConstants.CENTER);
		label[0].setHorizontalTextPosition(SwingConstants.CENTER);
	}
    /**
     * Set the next chance card
     * @param txt the text to display on the center.
     */
    public void setChanceCard(String txt) {
        Center.chanceCardText = txt;
    }
	public JPanel getCenterPanel(){
		return centerPanel;
	}
}