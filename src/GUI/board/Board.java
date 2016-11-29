package GUI.board;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import GUI.backend.*;
import GUI.backend.Mover;
import GUI.fields.Field;

/**
 * The board
 * @author Ronnie
 */
public final class Board extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	public static final String FONT = "Tahoma";
	public static final int FONTSIZE = 14;
	public static final Color BASECOLOR = new Color(46, 43, 46);
	public static final int MAX_PLAYER_COUNT = 6;
	
	private static Board instance;
	private SwingComponentFactory factory = new SwingComponentFactory();
	
	private JLayeredPane base;
	public static Player[] playerList = new Player[MAX_PLAYER_COUNT];
	private JLayeredPane[][] moverPanes = new JLayeredPane[11][11];
	private JLabelRotatable[][] diceLabels = new JLabelRotatable[11][11];
	private JLabel[] playerLabels = new JLabel[MAX_PLAYER_COUNT];
	private JLabel[] iconLabels = new JLabel[MAX_PLAYER_COUNT];
	private int die1x = 1, die1y = 1, die2x = 1, die2y = 1;
//	private JTextPane messageArea = new JTextPane();
	private JTextArea messageArea = new JTextArea();
	private JPanel inputPanel = new JPanel();
	private ImageIcon[] diceIcons = new ImageIcon[6];
	
	private Board() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		makeDice();
		makeBase();
		makeBackGroundPanels();
		makeDiceLabels();
		makePlayerAreas();
		makeCenter();
//		FieldFactory.makeFields();
		makeFieldPanels();
		makeMoverPanes();
		makeInputPanel();
		
		makeAutogeneratedCrap();
	}
	
	/**
	 * Retrieves the singleton instance
	 * @return the Board instance
	 */
	public static Board getInstance() {
		if(instance == null) {
			instance = new Board();
			instance.setVisible(true);
		}
		return instance;
	}
	
	public static void destroy() {
		Board.getInstance().dispose();
		instance = null;
	}
	/**
	 * Makes images of the dice
	 */
	private void makeDice() {
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/GUI/art/Misc/Dice.png"));
			for(int value = 0; value < 6; value++) {
				int x = 0;
				int y = 55 * value;
				this.diceIcons[value] = new ImageIcon(image.getSubimage(x, y, 54, 54));
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Makes a graphical representation of all the fields
	 */
	private void makeFieldPanels() {
		for(int i = 0; i < FieldFactory.fields.size(); i++) {
			Field f = FieldFactory.fields.get(i);
			JLayeredPane panel = f.getPanel();
			this.base.add(panel, this.factory.createGridBagConstraints(f.getX(), f.getY()));
		}
	}
	/**
	 * Makes room for input fields
	 */
	private void makeInputPanel() {
		this.inputPanel.setBackground(new Color(0, 128, 0));
		this.inputPanel.setOpaque(false);
		this.inputPanel = (JPanel) this.factory.setSize(this.inputPanel, 557, 179);
		this.inputPanel.setLayout(new FlowLayout());
		
		this.messageArea.setWrapStyleWord(true);
		this.messageArea.setLineWrap(true);
		this.messageArea.setSize(557, 10);
		this.messageArea.setLayout(new FlowLayout());
		this.messageArea.setOpaque(false);
		this.messageArea.setEditable(false);
		this.messageArea.setFocusable(false);
		
		this.inputPanel.add(this.messageArea);
		this.base.setLayer(this.inputPanel, 4);
		this.base.add(this.inputPanel, this.factory.createGridBagConstraints(1, 1, 9, 3));
	}
	/**
	 * Adds Input components to the board
	 * @param message The message for the user
	 * @param components : input components (buttons, textfields, drop-down, etc.)
	 */
	public void getUserInput(String message, Component... components) {
//		SimpleAttributeSet attribs = new SimpleAttributeSet();
//		StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);
//		this.messageArea.setParagraphAttributes(attribs,true);
		this.messageArea.setText(message);
		this.messageArea.setForeground(Color.WHITE);
		this.messageArea.setFont(new Font(this.messageArea.getFont().getName(), Font.BOLD, 14));
		for(Component c : components) {
			this.inputPanel.add(c);
		}
		this.inputPanel.validate();
		this.inputPanel.repaint();
	}
	/**
	 * Resets input panel
	 */
	public void clearInputPanel() {
		this.messageArea.setText("");
		this.inputPanel.removeAll();
		this.inputPanel.add(this.messageArea);
		this.inputPanel.validate();
		this.inputPanel.repaint();
	}
	/**
	 * Makes the components on which Movers can be placed
	 */
	private void makeMoverPanes() {
		for(Field f : FieldFactory.fields) {
			int x = f.getX();
			int y = f.getY();
			
			JLayeredPane layered = new JLayeredPane();
			this.factory.setSize(layered, Field.FIELDWIDTH, Field.FIELDHEIGHT);
			this.moverPanes[x][y] = layered;
			layered.setOpaque(false);
			
			JLabel[] movers = new JLabel[MAX_PLAYER_COUNT];
			for(int i = 0; i < MAX_PLAYER_COUNT; i++) {
				JLabel label = new JLabel();
				movers[i] = label;
				label.setOpaque(false);
				this.factory.setSize(label, Field.FIELDWIDTH, Field.FIELDHEIGHT);
				label.setBounds(3 * i + 3, 6 * i + 1, Player.ICON_WIDTH, Player.ICON_HEIGHT);
				layered.setLayer(label, i + 5);
				label.setVisible(false);
				layered.add(label);
			}
			
			f.setMoverIcons(movers);
			// fields are on layer 0.
			this.base.setLayer(layered, 1);
			this.base.add(layered, this.factory.createGridBagConstraints(x, y));
			
		}
	}
	/**
	 * Makes the center
	 */
	private void makeCenter() {
		this.base.setLayer(Center.getInstance().getCenterPanel(), 1);
		this.base.add(Center.getInstance().getCenterPanel(),
			this.factory.createGridBagConstraints(4, 4, 3, 3));
	}
	/**
	 * Makes the base
	 */
	private void makeBase() {
		this.base = new javax.swing.JLayeredPane();
		this.factory.setSize(this.base, 11 * Field.FIELDWIDTH, 11 * Field.FIELDWIDTH);
		this.base.setLayout(new GridBagLayout());
		this.base.setBackground(BASECOLOR);
        this.base.setOpaque(true);
	}
	/**
	 * Makes the background
	 */
	private void makeBackGroundPanels() {
		for(int x = 1; x < 10; x++) {
			for(int y = 1; y < 10; y++) {
				JPanel panel = new javax.swing.JPanel();
				panel.setBackground(Board.BASECOLOR);
				this.factory.setSize(panel, Field.FIELDWIDTH, Field.FIELDHEIGHT);
				this.base.setLayer(panel, 0);
				this.base.add(panel, this.factory.createGridBagConstraints(x, y));
			}
		}
	}
	/**
	 * Makes the components on which dice can be placed
	 */
	private void makeDiceLabels() {
		for(int x = 0; x < 11; x++) {
			for(int y = 0; y < 11; y++) {
				JLabelRotatable label = new JLabelRotatable();
				this.diceLabels[x][y] = label;
				label.setOpaque(false);
				this.factory.setSize(label, Field.FIELDWIDTH, Field.FIELDHEIGHT);
				this.base.setLayer(label, 3);
				this.base.add(label, this.factory.createGridBagConstraints(x, y), 0);
			}
		}
	}
	/**
	 * Makes the components on which to show players
	 */
	private void makePlayerAreas() {
		int x = 9;
		for(int i = 0; i < MAX_PLAYER_COUNT; i++) {
			int y = 5 - i;
			
			JLabel iconLabel = new JLabel();
			this.factory.setSize(iconLabel, 1 * Field.FIELDWIDTH, 1 * Field.FIELDWIDTH);
			this.base.setLayer(iconLabel, 1);
			this.base.add(iconLabel, this.factory.createGridBagConstraints(x, y));
			this.iconLabels[i] = iconLabel;
			
			JLabel playerLabel = new JLabel();
			this.factory.setSize(playerLabel, 1 * Field.FIELDWIDTH, 1 * Field.FIELDWIDTH);
			this.base.setLayer(playerLabel, 1);
			this.base.add(playerLabel, this.factory.createGridBagConstraints(x + 1, y, 2, 1));
			this.playerLabels[i] = playerLabel;
		}
	}
	/**
	 * Places dice on the board
	 * @param x1 x-coordinate for die 1
	 * @param y1 y-coordinate for die 1
	 * @param facevalue1 value of die 1
	 * @param rotation1 the angle [0:359] of die 1
	 * @param x2 x-coordinate for die 2
	 * @param y2 y-coordinate for die 2
	 * @param facevalue2 value of die 2
	 * @param rotation2 the angle [0:359] of die 2
	 */
	public void setDice(int x1, int y1, int facevalue1, int rotation1, int x2, int y2, int facevalue2, int rotation2) {
		this.diceLabels[this.die1x][this.die1y].setIcon(null);
		this.diceLabels[this.die2x][this.die2y].setIcon(null);
		this.die1x = x1;
		this.die1y = y1;
		this.die2x = x2;
		this.die2y = y2;

		this.diceLabels[x1][y1].setRotation(rotation1);
		this.diceLabels[x1][y1].setHorizontalAlignment(SwingConstants.CENTER);
		this.diceLabels[x1][y1].setVerticalAlignment(SwingConstants.CENTER);
		this.diceLabels[x1][y1].setIcon(this.diceIcons[facevalue1 - 1]);
		this.diceLabels[x2][y2].setRotation(rotation2);
		this.diceLabels[x2][y2].setHorizontalAlignment(SwingConstants.CENTER);
		this.diceLabels[x2][y2].setVerticalAlignment(SwingConstants.CENTER);
		this.diceLabels[x2][y2].setIcon(this.diceIcons[facevalue2 - 1]);
	}
	/**
	 * Add a player to the board
	 * @param name The name of the player
	 * @param balance The initial balance
	 * @param playerColor : Color
	 */
	public void addPlayer(String name, int balance, Color playerColor) {
		Mover car = new Mover.Builder().primaryColor(playerColor).build();
		if(playerColor != null) {
			addPlayer(name, balance, car);
		}
	}
	/**
	 * Add a player to the board
	 * @param name The name of the player
	 * @param balance The initial balance
	 * @param mover : Type Mover
	 */
	public void addPlayer(String name, int balance, Mover mover) {
		if(Board.playerList[MAX_PLAYER_COUNT - 1] != null) {
			return;
		}
		int i = 0;
		for(; i < MAX_PLAYER_COUNT; i++) {
			if(Board.playerList[i] != null) {
				// No duplicate player names
				if(Board.playerList[i].getName().equals(name)) {
					return;
				}
			} else {
				break;
			}
		}
		Board.playerList[i] = new Player(i, name, balance, mover);
		updatePlayers();
	}
	/**
	 * Add a player to the board
	 * @param name The name of the player
	 * @param balance The initial balance<br>
	 *        Automatic playerColor
	 */
	public void addPlayer(String name, int balance) {
		Mover car = new Mover.Builder().build();
		addPlayer(name, balance, car);
	}
	/**
	 * Updates the board in order to correct player balances
	 */
	public void updatePlayers() {
		int position = 0;
		for(Player p : Board.playerList) {
			if(p != null) {
				Icon icon = new ImageIcon(p.getImage());
				
				this.iconLabels[position].setIcon(icon);
				this.playerLabels[position].setText("<html>" + "<font size=3 color=#949494>" + p.getName() + "<br>"
					+ p.getBalance());
				position++;
			} else {
				break;
			}
		}
	}
	/**
	 * Retrieves a player
	 * @param name The name of the player
	 * @return a Player object
	 */
	public Player getPlayer(String name) {
		for(Player p : Board.playerList) {
			if(p != null && name.equalsIgnoreCase(p.getName())) {
				return p;
			}
		}
		return null;
	}
	/**
	 * Counts how many players are in the game
	 * @return number of players
	 */
	public int getPlayerCount() {
		int count = 0;
		for(Player p : Board.playerList) {
			if(p != null) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	/**
	 * Autogenerated DON'T CHANGE!
	 */
	private void makeAutogeneratedCrap() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
			javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.base,
			javax.swing.GroupLayout.PREFERRED_SIZE,
			javax.swing.GroupLayout.DEFAULT_SIZE,
			javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
			javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.base,
			javax.swing.GroupLayout.PREFERRED_SIZE,
			javax.swing.GroupLayout.DEFAULT_SIZE,
			javax.swing.GroupLayout.PREFERRED_SIZE));
		pack();
	}
}