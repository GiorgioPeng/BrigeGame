


import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.GridLayout;
import javax.swing.JLabel;

public class OwnMap extends JPanel{
  private GridLayout gl;  // the layout of the JPanel
	static JLabel jlabel[][]; // every block
	static int[][] mapData = new int[9][13]; //the data of the map,
													 // 0 represent the people on the stump
													 // 1 represent the stump,
													 // 2 represent the border of the top
													 // 3 represent the border of the bottom
													 // 4 represent the river
													 // 5 represent the people on the horizontal plank
													 // 6 represent the horizontal plank
													 // 7 represent the people on the vertical plank
													 // 8 represent the vertical plank
													 // 9 represent the bottom border_stump
													 // 10 represent the people on the bottom border_stump
													 // 11 represent the top border_stump
													 // 12 represent the people on the top border_stump


  /**
   * @the construtor
   **/
  public OwnMap(){
    this.setBackground(Color.BLUE);
    jlabel = new JLabel[9][13];
    gl = new GridLayout(9, 13);
    this.setLayout(gl);
    for(int i = 0 ;i < 9;i++)
      for(int j = 0 ; j<13;j++)
      {
        switch (mapData[i][j]) {
          case 0:
            jlabel[i][j] = createLabel(new ImageIcon("img/stump1_man.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 1:
            jlabel[i][j] = createLabel(new ImageIcon("img/stump1.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 2:
            jlabel[i][j] = createLabel(new ImageIcon("img/bank2.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 3:
            jlabel[i][j] = createLabel(new ImageIcon("img/bank1.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 4:
            int rd = (int)(Math.random()*10);
            if(rd < 3)
            {
              jlabel[i][j] = createLabel(new ImageIcon("img/water2.jpg"));
              this.add(jlabel[i][j]);
            }
              else
            {
                jlabel[i][j] = createLabel(new ImageIcon("img/water1.jpg"));
                this.add(jlabel[i][j]);
            }
            break;
          case 5:
            jlabel[i][j] = createLabel(new ImageIcon("img/plank1_man.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 6:
            jlabel[i][j] = createLabel(new ImageIcon("img/plank1.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 7:
            jlabel[i][j] = createLabel(new ImageIcon("img/plank2_man.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 8:
            jlabel[i][j] = createLabel(new ImageIcon("img/plank2.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 9:
            jlabel[i][j] = createLabel(new ImageIcon("img/stump1_man.jpg"));
            this.add(createButton(new ImageIcon("img/stump2.jpg")));
            break;
          case 10:
            jlabel[i][j] = createLabel(new ImageIcon("img/stump2_man.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 11:
            jlabel[i][j] = createLabel(new ImageIcon("img/stump3.jpg"));
            this.add(jlabel[i][j]);
            break;
          case 12:
            jlabel[i][j] = createLabel(new ImageIcon("img/stump3_man.jpg"));
            this.add(jlabel[i][j]);
            break;

          default:
        }

      }
  }

  /**
	 * @create a JLabel to display some parts of the map
	 * @param i a ImageIcon
	 * @return jl return a JLabel
	 **/
	private JLabel createLabel(ImageIcon i) {
		JLabel jl = new JLabel();
		jl.setIcon(i);
		return jl;
	}

  /**
	 * @create a JButton, users can use it to do some operations
	 * @param i a ImageIcon
	 * @return JButton return a JButton
	 **/
	private JButton createButton(ImageIcon i){
		JButton jb = new JButton();
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
		jb.setBorder(null);
		jb.setIcon(i);
		return jb;
	}
}
