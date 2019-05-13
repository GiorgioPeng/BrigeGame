
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CreateMap extends JPanel {
	private GridLayout gl;  // the layout of the JPanel
	static JLabel jlabel[][]; // every block
	static int[][] mapData; //the data of the map,
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
   * @the constructor
   * @param width the width of the game map
   * @param height the height of the game map
   **/
	public CreateMap(int width,int height,int level) {
			jlabel = new JLabel[9][13];
			gl = new GridLayout(9, 13);
			this.setLayout(gl);
			this.setBackground(Color.BLUE);
			mapData = new int[9][13];
			initialArray(level);
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
	 * @to initial the mapdata, such as where is water, where is people and so on
	 * @param level to ensure the level of current map
	 **/
	private void initialArray(int level){
		//_______________________________________________________________________
				if(level == 1){
					for (int i = 0; i < 9; i++)				// i is the index of the rows
						for(int j = 0 ; j < 13 ; j++)		// j is the index of the columns
						{

							if(i==0)								// the position of the top border
							{
								if(j == 3)
									mapData[i][j] = 11;
								else
									mapData[i][j] = 2;
								continue;
							}

							if(i == 8)							// the position of the bottom border
							{
								if(j == 3)
									mapData[i][j] = 10;
								else
									mapData[i][j] = 3;
								continue;
							}

							if(j == 3 && i % 2 == 0)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 3 && i%2 == 1)							//the position initial vertical plank
							{
								mapData[i][j] = 8;
								continue;
							}

							mapData[i][j] = 4;
						}

				}
		//_______________________________________________________________________
				if(level == 2) {
					for (int i = 0; i < 9; i++)				// i is the index of the rows
						for(int j = 0 ; j < 13 ; j++)		// j is the index of the columns
						{

							if(i==0)								// the position of the top border
							{
								if(j == 7)
									mapData[i][j] = 11;
								else
									mapData[i][j] = 2;
								continue;
							}

							if(i == 8)							// the position of the bottom border
							{
								if(j == 3)
									mapData[i][j] = 10;
								else
									mapData[i][j] = 3;
								continue;
							}

							if(j == 3 && i == 4)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 3 && i == 2)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 2 && j == 7){
								mapData[i][j] = 1;
								continue;
							}

							if(j == 3 && (i == 7||i == 6||i == 5))							//the position initial vertical plank
							{
								mapData[i][j] = 8;
								continue;
							}
							if(j == 3 && i == 3)							//the position initial vertical plank
							{
								mapData[i][j] = 8;
								continue;
							}

							mapData[i][j] = 4;
						}
				}
		//_______________________________________________________________________
				if(level == 3){
					for (int i = 0; i < 9; i++)				// i is the index of the rows
						for(int j = 0 ; j < 13 ; j++)		// j is the index of the columns
						{

							if(i==0)								// the position of the top border
							{
								if(j == 6)
									mapData[i][j] = 11;
								else
									mapData[i][j] = 2;
								continue;
							}

							if(i == 8)							// the position of the bottom border
							{
								if(j == 3)
									mapData[i][j] = 10;
								else
									mapData[i][j] = 3;
								continue;
							}

							if(j == 1 && i == 2)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 3 && i == 2)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 6 && i == 2)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 9 && i == 2)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 9 && i == 4)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 1 && i == 6)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 3 && i == 6)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 5 && i == 6)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(j == 9 && i == 6)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}

							if(i == 2 && (j == 7||j == 8))		//the position initial horizontal plank
							{
								mapData[i][j] = 6;
								continue;
							}

							if(j == 1 && (i == 3||i == 4||i == 5))							//the position initial vertical plank
							{
								mapData[i][j] = 8;
								continue;
							}

							if(j == 3 && i == 7)							//the position initial vertical plank
							{
								mapData[i][j] = 8;
								continue;
							}

							mapData[i][j] = 4;
						}
				}
		//_______________________________________________________________________
				if(level == 4){
					for (int i = 0; i < 9; i++)				// i is the index of the rows
						for(int j = 0 ; j < 13 ; j++){		// j is the index of the columns
							if(i==0)								// the position of the top border
							{
								if(j == 3 || j == 5 || j == 9)
									mapData[i][j] = 11;
								else
									mapData[i][j] = 2;
								continue;
							}

							if(i == 8)							// the position of the bottom border
							{
								if(j == 3)
									mapData[i][j] = 10;
								else
									mapData[i][j] = 3;
								continue;
							}
							if(i == 1 && j == 6)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 1 && j == 10)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 3 && j == 3)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 3 && j == 7)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 3 && j == 10)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 5 && j == 3)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 5 && j == 6)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(i == 5 && j == 10)					 // the position of stumps
							{
								mapData[i][j] = 1;
								continue;
							}
							if(j == 3 && (i == 6||i == 7)){ // the position of the vertical plank
								mapData[i][j] = 8;
								continue;
							}
							if(i == 5 &&(j == 7||j == 8||j == 9)){ // the position of the horizontal plank
								mapData[i][j] = 6;
								continue;
							}
							if(i == 2 && j == 10){ // the position of the horizontal plank
								mapData[i][j] = 8;
								continue;
							}
							mapData[i][j] = 4;
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
