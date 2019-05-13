

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;
public class Start extends JFrame{
	private JButton start;// the start button
	private JButton quit;// the quit button
	private static JPanel jp; // the JPanel include the following two JPanel
	private static JPanel logoJp; // the JPanel include of the fish logo
	private static JPanel buttonJp; // the Jpanel include the start button and the quit button
	private static JLabel[][] jl; // the fish logo
	private static JLabel title; // the title or the name of the game

  /**
   * @the constructor
   * @param ba to switch the interface of the level 1
   **/
	public Start(BuildAll ba) {
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		title = new JLabel("Brige     Game",JLabel.CENTER);
		title.setFont(new java.awt.Font("Dialog",1,80));
		title.setMinimumSize(new Dimension(600,100));
		title.setPreferredSize(new Dimension(600,100));
		title.setForeground(Color.white);
		buttonJp = new JPanel(new FlowLayout(FlowLayout.RIGHT)) {
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				ImageIcon i = new ImageIcon("img/water1.jpg");
				g.drawImage(i.getImage(),0,0,this.getWidth(),this.getHeight(),i.getImageObserver());
			}
		};
		start = new JButton(new ImageIcon("img/start.png"));
		start.setBorder(null);
		start.setBorderPainted(false);
		start.setContentAreaFilled(false);
		start.addMouseListener(new MouseListener(){

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisi();
				ba.setVisi();
				// runTimeStop(ba.getPp());
			}
		});
		quit = new JButton(new ImageIcon("img/quit.png"));
		quit.setBorder(null);
		quit.setBorderPainted(false);
		quit.setContentAreaFilled(false);
		quit.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		buttonJp.add(start);
		buttonJp.add(quit);

		jl = new JLabel[7][41];
		logoJp = new JPanel(new GridLayout(7,41));
		logoJp.setBackground(new Color(51, 103, 153));
		for(int i=0;i<7;i++)
			for(int j = 0 ; j<41;j++) {
				if(j == 2) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
				}
				if(j == 3 && (i == 0||i==2||i==4||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 4 && i!=3) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//B
				if(j == 6 && i == 1) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 7 && (i!=0&&i!=1)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 8 && i == 1) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//r
				if(j == 10 && (i!=0&&i!=2)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//i
				if(j == 12&&(i!=0&&i!=4)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 13&&(i!=0&&i!=2&&i!=4&&i!=5)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 14&&i!=0) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
				}
				//g
				if(j == 16 &&(i!=0&&i!=1&&i!=6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 17&&(i==1||i==3||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 18 &&(i==2||i==3||i==5)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//e

				if(j == 21) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 22 && (i==0||i==2||i==3||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 23 && i != 1) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//G

				if(j == 25 && (i==3||i==4||i==5)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 26 && (i==2||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 27 && (i==3||i==4||i==5)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 28 && i == 6) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//a

				if(j == 30 && (i==4||i==5||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 31 && i==4) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 32 && (i==4||i==5||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 33 && i==4) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 34 && (i == 4||i==5||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//m

				if(j == 36&&(i!=0&&i!=1&&i!=6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 37&&(i==1||i==3||i==6)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				if(j == 38&&(i==2||i==3||i==5)) {
					jl[i][j] = new JLabel(new ImageIcon("img/bgWater2.png"));
					logoJp.add(jl[i][j]);
					continue;
					}
				//e
					jl[i][j] = new JLabel(new ImageIcon("img/water1.jpg"));
					logoJp.add(jl[i][j]);




			}
		for(int i =0;i<7;i++){
			for(int j = 0;j<41;j++) {
				if(jl[i][j].getIcon().toString().equals("img/bgWater2.png"))
					jl[i][j].addMouseListener(new MouseListener(){

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							new Thread(new Runnable(){
								@Override
								public void run(){
									for(int i = 0 ;i<7;i++) {
										for(int j = 0;j<41;j++)
										if(jl[i][j] == e.getSource()){
											try {
												Thread.sleep(200);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											jl[i][j].setIcon(new ImageIcon("img/bgWater3.png"));
											try {
												Thread.sleep(200);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											jl[i][j].setIcon(new ImageIcon("img/bgWater4.png"));
											try {
												Thread.sleep(200);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											jl[i][j].setIcon(new ImageIcon("img/bgWater2.png"));

											return;
										}
									}
								}
							}).start();

						}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

				});
			}
		}
		jp = new JPanel(new BorderLayout()){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				ImageIcon i = new ImageIcon("img/water1.jpg");
				g.drawImage(i.getImage(),0,0,getWidth(),getHeight(),i.getImageObserver());
			}
		};


		// logoJp.setPreferredSize(new Dimension(1200,168));
		// logoJp.setMinimumSize(new Dimension(1008,168));
		jp.add("North",title);
		jp.add("Center",logoJp);
		jp.add("South",buttonJp);
		add(jp);
		this.setSize(600,500);
		this.setVisible(true);

	}

  /**
   * @to set the visible is false to hide the JFrame
   **/
	public void setVisi() {
		this.setVisible(false);
	}

}
