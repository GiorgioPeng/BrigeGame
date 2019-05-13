

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateOwn extends JFrame{

	private JPanel contentPanel;//the left part
	private JPanel controlPanel;//the right part
	private JTextField jtext[][];// the black used to receive the value of each block
	private JLabel note[]; // the rules
	private JButton run;//the button of whether create new one
	private JFrame jf;//the Frame of the whole panel
	private Dialog dialog;//the dialog when you input some illegal value of some black
	private JButton ok;//the OK button of the dialog
	private JLabel attention;//the attention text of the dialog


  /**
   * @the contructor
   **/
	public CreateOwn() {

		//create the comment of the rules;
		note = new JLabel[13];
		note[0] = new JLabel("0 is people on the stump");
		note[1] = new JLabel("1 is the stump");
		note[2] = new JLabel("2 is the border of the top");
		note[3] = new JLabel("3 is the border of the bottom");
		note[4] = new JLabel("4 is the river of fish");
		note[5] = new JLabel("5 is the people on the horizontal plank");
		note[6] = new JLabel("6 is the horizontal plank");
		note[7] = new JLabel("7 is the people on the vertical plank");
		note[8] = new JLabel("8 is the vertical plank");
		note[9] = new JLabel("9 is the bottom border stump");
		note[10] = new JLabel("10 is the people on the bottom border stump");
		note[11] = new JLabel("11 is the top border stump");
		note[12] = new JLabel("12 is the people on the top border stump");

		//create the button
		run = new JButton("Run");
		run.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					for(int i = 0;i<jtext.length;i++)
						for(int j = 0 ;j<jtext[0].length;j++){
							//if all value is legal
								if(0<=Integer.parseInt(jtext[i][j].getText())&&12>=Integer.parseInt(jtext[i][j].getText())) {
									continue;
								}
								//if there are some illegal
								else{
									dialog.setVisible(true);
									return;
								}
						}

						//initial the value array of the map
						for(int i = 0 ;i<jtext.length;i++)
							for(int j = 0 ;j<jtext[0].length;j++)
								OwnMap.mapData[i][j] = Integer.parseInt(jtext[i][j].getText());
						remove(contentPanel);
						remove(controlPanel);
						add(new OwnMap());
						ControlOwn co = new ControlOwn(150,430);
						co.addKeyListener(co);
						add(co);
						repaint();
						setVisible(true);
						co.requestFocus();

				}
				catch(NumberFormatException a) {
					//if there are some illegal
					dialog.setVisible(true);
					return;
				}

			}
		});

		// the attention text of the dialog
		attention = new JLabel("There are some value which are illegal!Please check again.");

		//create the left part
		contentPanel = new JPanel(new GridLayout(9,13));

		//create the right part
		controlPanel = new JPanel(new GridLayout(14,1));

		//add some Component
		for(int i = 0 ; i<13;i++)
			controlPanel.add(note[i]);
		controlPanel.add(run);



		//create the button of the dialog
		ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }

        });

		//create the dialog
		dialog = new Dialog(jf, "Attention", true);
		dialog.setBounds(200, 200, 380, 150);
		dialog.setVisible(false);
		dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                dialog.setVisible(false);

            }

        });
		dialog.setLayout(new FlowLayout());
		dialog.add(attention);
		dialog.add(ok);

		//create the textfield;
		jtext = new JTextField[9][13];
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		for(int i = 0;i<9;i++)
			for(int j = 0;j<13;j++) {
				if(i==0){
					jtext[i][j] = new JTextField("2",JTextField.CENTER);
				}
				else{
					if(i==8){
						jtext[i][j] = new JTextField("3",JTextField.CENTER);
					}
					else{
						jtext[i][j] = new JTextField("4",JTextField.CENTER);
					}
				}
				jtext[i][j].setPreferredSize(new Dimension(30,30));
				contentPanel.add(jtext[i][j]);
			}
		this.add(contentPanel);
		this.add(controlPanel);
		this.setSize(700,500);
		this.setVisible(true);
		this.setResizable(false);
	}
}
