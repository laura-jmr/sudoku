import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserInterface extends javax.swing.JFrame {

	private javax.swing.JPanel buttons;
	private javax.swing.JPanel header;
	private javax.swing.JButton solveButton;
	private javax.swing.JLabel title;
	public static javax.swing.JTextArea infoBox;
	public static GameField gameField;

	public UserInterface() {
		initComponents();
	}

	private void initComponents() {
		header = new javax.swing.JPanel();
		title = new javax.swing.JLabel();
		buttons = new javax.swing.JPanel();
		solveButton = new javax.swing.JButton();
		infoBox = new javax.swing.JTextArea();
		gameField = new GameField();
		JMenuBar menuBar = new JMenuBar();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sudoku-Solver by laura-jmr");
		setResizable(false);
		title.setText("Sudoku Solver");

		JMenu menu1 = new JMenu("File");
		JMenuItem saveFile = new JMenuItem("save file");
		saveFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("saving");
			}
		});
		menu1.add(saveFile);

		JMenuItem newProject = new JMenuItem("new project");
		newProject.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.print("clearing");
				gameField.clearAllFields();
			}
		});
		menu1.add(newProject);
		menuBar.add(menu1);

		setJMenuBar(menuBar);
		System.setProperty("apple.laf.useScreenMenuBar", "true");

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
						.addComponent(solveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(20, 20, 20))
		);
		buttonsLayout.setVerticalGroup(
			buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(buttonsLayout.createSequentialGroup()
					.addGap(90, 90, 90)
					.addComponent(solveButton)
					.addGap(44, 44, 44))
		);

		infoBox.setBackground(new java.awt.Color(244, 244, 244));
		infoBox.setText("fill your field...");
		infoBox.setLineWrap(true);
		infoBox.setWrapStyleWord(true);
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

        String infoBoxText = "error found:";

        if (RulesChecker.errorInnerField) {
            infoBoxText += "\nA number can't be twice in a field!";
        }
        if (RulesChecker.errorRows) {
        	infoBoxText += "\nA number can't be twice in a row!";
		}
        if (RulesChecker.errorColumns) {
        	infoBoxText += "\nA number can't be twice in a column!";
		}

        infoBox.setText(infoBoxText);
	}

	public static void resetInfoBox () {
		infoBox.setText("fill your field...");
	}

	private static void safeFilePopUp () {

	}
}
