import java.awt.*;
import java.awt.event.KeyEvent;

public class UserInterface extends javax.swing.JFrame {

	private javax.swing.JPanel buttons;
	private javax.swing.JPanel header;
	private javax.swing.JButton newGameButton;
	private javax.swing.JButton solveButton;
	private javax.swing.JLabel title;
	public static javax.swing.JLabel infoBox;
	private GameField gameField;

	public UserInterface() {
		initComponents();
	}

	private void initComponents() {
		header = new javax.swing.JPanel();
		title = new javax.swing.JLabel();
		buttons = new javax.swing.JPanel();
		newGameButton = new javax.swing.JButton();
		solveButton = new javax.swing.JButton();
		infoBox = new javax.swing.JLabel();
		gameField = new GameField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sudoku-Solver by laura-jmr");
		setResizable(false);

		title.setText("Sudoku Solver");

		javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
		header.setLayout(headerLayout);
		headerLayout.setHorizontalGroup(
				headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(headerLayout.createSequentialGroup()
								.addGap(321, 321, 321)
								.addComponent(title)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		headerLayout.setVerticalGroup(
				headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(headerLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(title)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		newGameButton.setText("create new game");
		newGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				newGameButtonMouseClicked();
			}
		});

		solveButton.setText("solve");
		solveButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				solveButtonMouseClicked();
			}
		});

		javax.swing.GroupLayout buttonsLayout = new javax.swing.GroupLayout(buttons);
		buttons.setLayout(buttonsLayout);
		buttonsLayout.setHorizontalGroup(
				buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsLayout.createSequentialGroup()
								.addContainerGap(24, Short.MAX_VALUE)
								.addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(solveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(20, 20, 20))
		);
		buttonsLayout.setVerticalGroup(
				buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(buttonsLayout.createSequentialGroup()
								.addGap(90, 90, 90)
								.addComponent(solveButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
								.addComponent(newGameButton)
								.addGap(44, 44, 44))
		);

		infoBox.setBackground(new java.awt.Color(244, 244, 244));
		infoBox.setText("fill your field...");
		infoBox.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		infoBox.setMaximumSize(infoBox.getMinimumSize());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(gameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(infoBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(infoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(gameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);



		pack();


	}

	private void newGameButtonMouseClicked() {
		this.initComponents();
	}

	private void solveButtonMouseClicked() {

	}

	public void create() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UserInterface().setVisible(true);
			}
		});
	}

	public static void error () {
	    List<Field> temp = RulesChecker.errorFields;

	    temp.toFirst();

	    while (temp.hasAccess()) {

	        temp.getContent().setForeground(Color.red);
	        temp.next();

	    }

        RulesChecker.currentField.setText("");
        RulesChecker.errorInnerField = false;
        RulesChecker.rechecked = false;

        String infoBoxText = "";

        if (RulesChecker.errorInnerField) {
            infoBoxText += "Do not insert a number twice!";
        }

        infoBox.setText(infoBoxText);
	}

	public static void recheck () {
        List<Field> temp = RulesChecker.errorFields;

        if (temp.isEmpty()) {
            for (int i = 0; i < RulesChecker.currentField.getInnerField().fields.length; i++) {
                if (RulesChecker.currentField.getInnerField().fields[i].getForeground() == Color.red) {
                    RulesChecker.currentField.getInnerField().fields[i].setForeground(Color.black);
                }
            }
            RulesChecker.rechecked = true;
            infoBox.setText("fill your field...");
        }
        else {
            RulesChecker.currentField.setText("");
        }
    }
}
