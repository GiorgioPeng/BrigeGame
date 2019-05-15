
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.*;

public class ControlOwn  extends JPanel implements MouseListener,KeyListener{
  private GridLayout gl; // the layout
  public static JLabel jtext[]; // the hints
  private JButton quitButton1; // the quit button
  private MouseListener mouseL; // the mouse event listener

  /**
   * @description your_method_description
   * @param width the width of this control jpanel
   * @param height the height of this control jpanel
   **/
  public ControlOwn(int width,int height){
    this.setBackground(new Color(61,113,163));
    jtext = new JLabel[8];
    gl = new GridLayout(9,1);
    this.setLayout(gl);
    this.setPreferredSize(new Dimension(width,height)); // set the size of JPanel
    jtext[0] = new JLabel("Level Null",JLabel.CENTER);
    jtext[0].setFont(new java.awt.Font("Dialog",1,20));
    jtext[0].setForeground(Color.red);
    this.add(jtext[0]);
    jtext[1] = new JLabel("Remaining time:",JLabel.CENTER);
    jtext[1].setFont(new java.awt.Font("Dialog",1,10));
    this.add(jtext[1]);
    jtext[2] = new JLabel("unlimited",JLabel.CENTER);
    jtext[2].setFont(new java.awt.Font("Dialog",1,10));
    jtext[2].setForeground(Color.white);
    this.add(jtext[2]);
    jtext[3] = new JLabel("Catching: ",JLabel.CENTER);
    jtext[3].setFont(new java.awt.Font("Dialog",1,10));
    this.add(jtext[3]);
    jtext[4] = new JLabel("",JLabel.CENTER);
    jtext[4].setFont(new java.awt.Font("Dialog",1,10));
    this.add(jtext[4]);
    quitButton1 = new JButton(new ImageIcon("img/quit.png"));
    quitButton1.addMouseListener(new MouseListener(){

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {
        System.exit(0);
      }

      @Override
      public void mouseExited(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseClicked(MouseEvent e) {

      }
    });
    quitButton1.setOpaque(false);
    quitButton1.setFocusPainted(false);
    this.add(quitButton1);
    jtext[5] = new JLabel("Rules:",JLabel.CENTER);
    jtext[5].setFont(new java.awt.Font("Dialog",1,10));
    this.add(jtext[5]);
    jtext[6] = new JLabel("Using planks go to",JLabel.CENTER);
    jtext[6].setFont(new java.awt.Font("Dialog",1,10));
    this.add(jtext[6]);
    jtext[7] = new JLabel("the other side",JLabel.CENTER);
    jtext[7].setFont(new java.awt.Font("Dialog",1,10));
    this.add(jtext[7]);
    this.setFocusable(true);
    this.requestFocus();
    mouseL = new MouseListener(){
                @Override
                public void mouseEntered(MouseEvent e) {
                  new Thread(new Runnable(){
                    @Override
                    public void run(){
                      for(int i = 0 ;i<9;i++) {
                        for(int j = 0;j<13;j++)
                        if(OwnMap.mapData[i][j] == 4&&OwnMap.jlabel[i][j] == e.getSource()&&OwnMap.jlabel[i][j].getIcon().toString().equals("img/water2.jpg")){
                          try {
                            Thread.sleep(80);
                          } catch (InterruptedException e1) {
                            e1.printStackTrace();
                          }
                          OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/water3.jpg"));
                          try {
                            Thread.sleep(80);
                          } catch (InterruptedException e1) {
                            e1.printStackTrace();
                          }
                          OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/water4.jpg"));
                          try {
                            Thread.sleep(80);
                          } catch (InterruptedException e1) {
                            e1.printStackTrace();
                          }
                          OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/water2.jpg"));

                          return;
                        }
                      }
                    }
                  }).start();

                }

                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

    };
    for(int i = 0 ;i<OwnMap.jlabel.length;i++)
      for(int j = 0 ; j<OwnMap.jlabel[0].length;j++)
      {
        OwnMap.jlabel[i][j].addMouseListener(this);
        if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/water2.jpg"))
          OwnMap.jlabel[i][j].addMouseListener(mouseL);
      }
  }

  /**
   * @to put the planks or move the person
   * @param e the mouse event
   **/
  @Override
  public void mousePressed(MouseEvent e){
    if (!isFocusable()){
      setFocusable(true);
      requestFocus();
    }
    if("img/stump2.jpg".equals(((JLabel) e.getSource()).getIcon().toString())){//move to bottom
      try {
        f:for(int i = 0 ;i<OwnMap.jlabel.length;i++)
          for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
            if(OwnMap.jlabel[i][j] == e.getSource()){
              if(i-1>=0&&OwnMap.mapData[i-1][j]==8){
                if(i-2>=0&&OwnMap.mapData[i-2][j]==8){ // length = 1
                  if(i-3>=0&&OwnMap.mapData[i-3][j]==8){//length = 2
                    if(i-4>=0&&OwnMap.mapData[i-4][j]==0){
                      new Thread(new Runnable(){
                        @Override
                        public void run(){
                          for(int i = 0 ;i<9;i++)
                            for(int j = 0;j<13;j++){
                              if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                try {
                                  Thread.sleep(100);
                                } catch (InterruptedException e1) {
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                try {
                                  Thread.sleep(100);
                                } catch (InterruptedException e1) {
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                try {
                                  Thread.sleep(100);
                                } catch (InterruptedException e1) {
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                OwnMap.jlabel[i+4][j].setIcon(new ImageIcon("img/stump2_man.jpg"));
                              }
                            }

                        }
                      }).start();
                      OwnMap.mapData[i-4][j] = 1;
                      OwnMap.mapData[i][j] = 10;
                      return;
                    }
                  }
                  else{//length = 2
                    if(i-3>=0&&OwnMap.mapData[i-3][j]==0){
                      new Thread(new Runnable(){
                        @Override
                        public void run(){
                          for(int i = 0 ;i<9;i++)
                            for(int j = 0;j<13;j++){
                              if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                try {
                                  Thread.sleep(100);
                                } catch (InterruptedException e1) {
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                try {
                                  Thread.sleep(100);
                                } catch (InterruptedException e1) {
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/stump2_man.jpg"));
                              }


                            }

                        }
                      }).start();
                      OwnMap.mapData[i-3][j] = 1;
                      OwnMap.mapData[i][j] = 10;
                    }
                    return;
                  }
                }
                else{// length = 1
                  if(i-2>=0&&OwnMap.mapData[i-2][j]==0){
                    new Thread(new Runnable(){
                      @Override
                      public void run(){
                        for(int i = 0 ;i<9;i++)
                          for(int j = 0;j<13;j++){
                            if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                              OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                              OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                              try {
                                Thread.sleep(100);
                              } catch (InterruptedException e1) {
                                e1.printStackTrace();
                              }
                              OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                              OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/stump2_man.jpg"));
                            }
                          }

                      }
                    }).start();
                    OwnMap.mapData[i-2][j] = 1;
                    OwnMap.mapData[i][j] = 10;
                  }
                  return;
                }
              }
            }
          }
          if("img/plank2.jpg".equals(jtext[4].getIcon().toString())){
            int wantX = 0;
            int wantY = 0;
            int realX = 0;
            int realY = 0;
            for(int i = 0 ;i<OwnMap.jlabel.length;i++)
              for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
                if(OwnMap.jlabel[i][j] == e.getSource()){
                  wantY = i;
                  wantX = j;
                }
                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")||OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump2_man.jpg")||OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump3_man.jpg")){
                  realY = i;
                  realX = j;
                }
              }
              if(wantY == realY&&Math.abs(realX-wantX)-1==Integer.parseInt(jtext[4].getText())){
                if(realX>wantX)
                  for(int l = wantX+1;l<realX;l++){
                    OwnMap.jlabel[wantY][l].setIcon(new ImageIcon("img/plank1.jpg"));
                    OwnMap.mapData[wantY][l] = 6;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
                else
                  for(int l = realX+1;l<wantX;l++){
                    OwnMap.jlabel[wantY][l].setIcon(new ImageIcon("img/plank1.jpg"));
                    OwnMap.mapData[wantY][l] = 6;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
              }
              if(wantX == realX&&Math.abs(realY-wantY)-1==Integer.parseInt(jtext[4].getText())){
                if(realY>wantY)
                  for(int l = wantY+1;l<realY;l++){
                    OwnMap.jlabel[l][wantX].setIcon(new ImageIcon("img/plank2.jpg"));
                    OwnMap.mapData[l][wantX] = 8;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
                else
                  for(int l = realY+1;l<wantY;l++){
                    OwnMap.jlabel[l][wantX].setIcon(new ImageIcon("img/plank2.jpg"));
                    OwnMap.mapData[l][wantX] = 8;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
              }
          }
        return;
      } catch(Exception a) {
        // System.out.println("move to bottom error");
        return;
      }
    }
    if("img/stump3.jpg".equals(((JLabel) e.getSource()).getIcon().toString())){//move to top
      try {
        f:for(int i = 0 ;i<OwnMap.jlabel.length;i++)
          for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
            if(OwnMap.jlabel[i][j] == e.getSource()){
              if(i+1<=8&&OwnMap.mapData[i+1][j]==8){
                if(i+2<=8&&OwnMap.mapData[i+2][j]==8){ // length = 1
                  if(i+3<=8&&OwnMap.mapData[i+3][j]==8){//length = 2
                    if(i+4<=8&&OwnMap.mapData[i+4][j]==0){
                      OwnMap.mapData[i+4][j] = 1;
                      OwnMap.mapData[i][j] = 12;
                      OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump3_man.jpg"));
                      OwnMap.jlabel[i+4][j].setIcon(new ImageIcon("img/stump1.jpg"));
                      new End(1){
           						 public void paintComponent(Graphics g){
           							 super.paintComponent(g);
           							 ImageIcon i = new ImageIcon("img/congratulation.png");
           							 g.drawImage(i.getImage(),0,0,this.getWidth(),this.getHeight(),i.getImageObserver());
           						 }
           				 		};
                      return;
                    }
                  }
                  else{//length = 2
                    if(i+3<=8&&OwnMap.mapData[i+3][j]==0){
                      OwnMap.mapData[i+3][j] = 1;
                      OwnMap.mapData[i][j] = 12;
                      OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump3_man.jpg"));
                      OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/stump1.jpg"));
                      new End(1){
           						 public void paintComponent(Graphics g){
           							 super.paintComponent(g);
           							 ImageIcon i = new ImageIcon("img/congratulation.png");
           							 g.drawImage(i.getImage(),0,0,this.getWidth(),this.getHeight(),i.getImageObserver());
           						 }
           				 		};
                      return;
                    }
                  }
                }
                else{// length = 1
                  if(i+2<=8&&OwnMap.mapData[i+2][j]==0){
                    OwnMap.mapData[i+2][j] = 1;
                    OwnMap.mapData[i][j] = 12;
                    OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/stump1.jpg"));
                    OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump3_man.jpg"));
                    new End(1){
         						 public void paintComponent(Graphics g){
         							 super.paintComponent(g);
         							 ImageIcon i = new ImageIcon("img/congratulation.png");
         							 g.drawImage(i.getImage(),0,0,this.getWidth(),this.getHeight(),i.getImageObserver());
         						 }
         				 		};
                    return;
                  }
                }
              }
            }
          }
          if("img/plank2.jpg".equals(jtext[4].getIcon().toString())){
            int wantX = 0;
            int wantY = 0;
            int realX = 0;
            int realY = 0;
            for(int i = 0 ;i<OwnMap.jlabel.length;i++)
              for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
                if(OwnMap.jlabel[i][j] == e.getSource()){
                  wantY = i;
                  wantX = j;
                }
                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")||OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump2_man.jpg")||OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump3_man.jpg")){
                  realY = i;
                  realX = j;
                }
              }
              if(wantY == realY&&Math.abs(realX-wantX)-1==Integer.parseInt(jtext[4].getText())){
                if(realX>wantX)
                  for(int l = wantX+1;l<realX;l++){
                    OwnMap.jlabel[wantY][l].setIcon(new ImageIcon("img/plank1.jpg"));
                    OwnMap.mapData[wantY][l] = 6;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
                else
                  for(int l = realX+1;l<wantX;l++){
                    OwnMap.jlabel[wantY][l].setIcon(new ImageIcon("img/plank1.jpg"));
                    OwnMap.mapData[wantY][l] = 6;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
              }
              if(wantX == realX&&Math.abs(realY-wantY)-1==Integer.parseInt(jtext[4].getText())){
                if(realY>wantY)
                  for(int l = wantY+1;l<realY;l++){
                    OwnMap.jlabel[l][wantX].setIcon(new ImageIcon("img/plank2.jpg"));
                    OwnMap.mapData[l][wantX] = 8;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
                else
                  for(int l = realY+1;l<wantY;l++){
                    OwnMap.jlabel[l][wantX].setIcon(new ImageIcon("img/plank2.jpg"));
                    OwnMap.mapData[l][wantX] = 8;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                  }
              }
          }
      } catch(Exception a) {
        // System.out.println("move to top error");
      }
      return;
    }
    if("img/stump1.jpg".equals(((JLabel) e.getSource()).getIcon().toString())){// get the path of the Icon of the JLabel
      //first check whether person can go, then test whether there need to put the plank
      f:for(int i = 0 ;i<OwnMap.jlabel.length;i++)
        for(int j = 0 ; j<OwnMap.jlabel[0].length;j++)
        {
          if(OwnMap.jlabel[i][j] == e.getSource()) //ensure which JLabel is clicked
            {
              if(i+1<=8&&OwnMap.mapData[i+1][j]==8)								//find whether bottom have plank(s), from bottom to top
                  {
                    if(i+2<=8&&OwnMap.mapData[i+2][j]==8){						//whether the long of the plank is 2
                      if(i+3<=8&&OwnMap.mapData[i+3][j]==8){
                        if(i+4<=8&&OwnMap.mapData[i+4][j]==0){			//if people stand on the stump
                          new Thread(new Runnable(){
                            @Override
                            public void run(){
                              for(int i = 0 ; i<9;i++)
                                for(int j = 0 ; j<13;j++)
                                  if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                    OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-4][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                    return;
                                  }
                            }
                          }).start();
                          OwnMap.mapData[i+4][j] = 1;
                          OwnMap.mapData[i][j] = 0;
                          return;
                        }
                        if(i+4<=8&&OwnMap.mapData[i+4][j]==10){	//if people stand on the bottom plank
                          new Thread(new Runnable(){
                            @Override
                            public void run(){
                              for(int i = 0 ; i<9;i++)
                                for(int j = 0 ; j<13;j++)
                                  if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump2_man.jpg")){
                                    OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump2.jpg"));
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-4][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                    return;
                                  }
                            }
                          }).start();
                          OwnMap.mapData[i+4][j] = 9;
                          OwnMap.mapData[i][j] = 0;
                          return;
                        }
                      }
                      else{
                        if(i+3<=8&&OwnMap.mapData[i+3][j]==0){
                          new Thread(new Runnable(){
                            @Override
                            public void run(){
                              for(int i = 0 ; i<9;i++)
                                for(int j = 0 ; j<13;j++)
                                  if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                    OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                    return;
                                  }
                            }
                          }).start();
                          OwnMap.mapData[i+3][j] = 1;
                          OwnMap.mapData[i][j] = 0;
                          return;
                        }
                        if(i+3<=8&&OwnMap.mapData[i+3][j]==10){
                          new Thread(new Runnable(){
                            @Override
                            public void run(){
                              for(int i = 0 ; i<9;i++)
                                for(int j = 0 ; j<13;j++)
                                  if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump2_man.jpg")){
                                    OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump2.jpg"));
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                    try{
                                      Thread.sleep(100);
                                    }
                                    catch(InterruptedException e1){
                                      e1.printStackTrace();
                                    }
                                    OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                    OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                    return;
                                  }
                            }
                          }).start();
                          OwnMap.mapData[i+3][j] = 9;
                          OwnMap.mapData[i][j] = 0;
                          return;
                        }
                      }
                    }
                    else{
                      if(i+2<=8&&OwnMap.mapData[i+2][j]==0){
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                  OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                  OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i+2][j] = 1;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }
                      if(i+2<=8&&OwnMap.mapData[i+2][j]==10){
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump2_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump2.jpg"));
                                  OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                  OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i+2][j] = 9;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }
                    }

                }
              if(i-1>=0&&OwnMap.mapData[i-1][j]==8){	//from top to bottom
                  if(i-2>=0&&OwnMap.mapData[i-2][j]==8){						//whether the long of the plank is 2
                    if(i-3>=0&&OwnMap.mapData[i-3][j]==8){
                      if(i-4>=0&&OwnMap.mapData[i-4][j]==0){			//if people stand on the plank
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                  OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                  OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                  OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                  OwnMap.jlabel[i+4][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i-4][j] = 1;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }

                    }
                    else{
                      if(i-3>=0&&OwnMap.mapData[i-3][j]==0){//if the person is on the top of where user clicked
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                  OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                  OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                  OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i-3][j] = 1;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }
                    }
                  }
                  else{
                    if(i-2>=0&&OwnMap.mapData[i-2][j]==0){
                      new Thread(new Runnable(){
                        @Override
                        public void run(){
                          for(int i = 0 ; i<9;i++)
                            for(int j = 0 ; j<13;j++)
                              if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2_man.jpg"));
                                try{
                                  Thread.sleep(100);
                                }
                                catch(InterruptedException e1){
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
                                OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                return;
                              }
                        }
                      }).start();
                      OwnMap.mapData[i-2][j] = 1;
                      OwnMap.mapData[i][j] = 0;
                      return;
                    }
                  }

                }
              if(j+1<=12&&OwnMap.mapData[i][j+1]==6){	//from right to left
                  if(j+2<=12 && OwnMap.mapData[i][j+2]==6){						//whether the long of the plank is 2
                    if(j+3<=12 && OwnMap.mapData[i][j+3]==6){
                      if(j+4<=12 && OwnMap.mapData[i][j+4]==0){			//if people stand on the plank
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                  OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j-4].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i][j+4] = 1;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }
                    }
                    else{
                      if(j+3<=12 && OwnMap.mapData[i][j+3]==0){
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                  OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i][j+3] = 1;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }
                    }
                  }
                  else{
                    if(j+2<=12 && OwnMap.mapData[i][j+2]==0){
                      // OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/stump1.jpg"));
                      // OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                      new Thread(new Runnable(){
                        @Override
                        public void run(){
                          for(int i = 0 ; i<9;i++)
                            for(int j = 0 ; j<13;j++)
                              if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                try{
                                  Thread.sleep(100);
                                }
                                catch(InterruptedException e1){
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
                                OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                return;
                              }
                        }
                      }).start();
                      OwnMap.mapData[i][j+2] = 1;
                      OwnMap.mapData[i][j] = 0;
                      return;
                    }
                  }

                }
              if(j-1>=0&&OwnMap.mapData[i][j-1]==6){	//from left to right
                  if(j-2>=0 && OwnMap.mapData[i][j-2]==6){						//whether the long of the plank is 2
                    if(j-3>=0 && OwnMap.mapData[i][j-3]==6){
                      if(j-4>=0 && OwnMap.mapData[i][j-4]==0){			//if people stand on the plank
                        // OwnMap.jlabel[i][j-4].setIcon(new ImageIcon("img/stump1.jpg"));
                        // OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                  OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j+4].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i][j-4] = 1;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }
                    }
                    else{
                      if(OwnMap.mapData[i][j-3]==0){
                        // OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/stump1.jpg"));
                        // OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                        new Thread(new Runnable(){
                          @Override
                          public void run(){
                            for(int i = 0 ; i<9;i++)
                              for(int j = 0 ; j<13;j++)
                                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                  OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                  OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                  try{
                                    Thread.sleep(100);
                                  }
                                  catch(InterruptedException e1){
                                    e1.printStackTrace();
                                  }
                                  OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));
                                  OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                  return;
                                }
                          }
                        }).start();
                        OwnMap.mapData[i][j-3] = 1;
                        OwnMap.mapData[i][j] = 0;
                        return;
                      }
                    }
                  }
                  else{
                    if(j-2>=0 && OwnMap.mapData[i][j-2]==0){
                      // OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/stump1.jpg"));
                      // OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1_man.jpg"));
                      new Thread(new Runnable(){
                        @Override
                        public void run(){
                          for(int i = 0 ; i<9;i++)
                            for(int j = 0 ; j<13;j++)
                              if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")){
                                OwnMap.jlabel[i][j].setIcon(new ImageIcon("img/stump1.jpg"));
                                OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1_man.jpg"));
                                try{
                                  Thread.sleep(100);
                                }
                                catch(InterruptedException e1){
                                  e1.printStackTrace();
                                }
                                OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
                                OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/stump1_man.jpg"));
                                return;
                              }
                        }
                      }).start();
                      OwnMap.mapData[i][j-2] = 1;
                      OwnMap.mapData[i][j] = 0;
                      return;
                    }
                  }

                }
              break f;
            }
        }
      try{
          if("img/plank2.jpg".equals(jtext[4].getIcon().toString())||"img/plank1.jpg".equals(jtext[4].getIcon().toString())){
            //the position of where you want to put the plank
            int wantX = 0;
            int wantY = 0;

            //the current position of the person
            int realX = 0;
            int realY = 0;

            //find the two positions
            for(int i = 0 ;i<OwnMap.jlabel.length;i++)
              for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
                if(OwnMap.jlabel[i][j] == e.getSource()){
                  wantY = i;
                  wantX = j;
                }
                if(OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump1_man.jpg")||OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump2_man.jpg")||OwnMap.jlabel[i][j].getIcon().toString().equals("img/stump3_man.jpg")){
                  realY = i;
                  realX = j;
                }
              }

              //calculate where we can put the plank
              if(wantY == realY&&Math.abs(realX-wantX)-1==Integer.parseInt(jtext[4].getText())){
                if(realX>wantX)
                  for(int l = wantX+1;l<realX;l++){
                    OwnMap.jlabel[wantY][l].setIcon(new ImageIcon("img/plank1.jpg"));
                    OwnMap.mapData[wantY][l] = 6;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                    this.repaint();
                  }
                else
                  for(int l = realX+1;l<wantX;l++){
                    OwnMap.jlabel[wantY][l].setIcon(new ImageIcon("img/plank1.jpg"));
                    OwnMap.mapData[wantY][l] = 6;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                    this.repaint();
                  }
              }
              if(wantX == realX&&Math.abs(realY-wantY)-1==Integer.parseInt(jtext[4].getText())){
                if(realY>wantY)
                  for(int l = wantY+1;l<realY;l++){
                    OwnMap.jlabel[l][wantX].setIcon(new ImageIcon("img/plank2.jpg"));
                    OwnMap.mapData[l][wantX] = 8;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                    this.repaint();
                  }
                else
                  for(int l = realY+1;l<wantY;l++){
                    OwnMap.jlabel[l][wantX].setIcon(new ImageIcon("img/plank2.jpg"));
                    OwnMap.mapData[l][wantX] = 8;
                    jtext[4].setIcon(null);
                    jtext[4].setText("");
                    this.repaint();
                  }
              }
          }
      }
      catch(Exception a){
          // System.out.println("move error");
      }
      return;
    }

  }

  /**
   * @to ensure the jpanel get focus
   * @param e the mouse event
   **/
	@Override
	public void mouseClicked(MouseEvent e) {
    if (!this.isFocusable())
      this.setFocusable(true);
	}


  /**
   * @the necessary abstract function
   * @param e the mouse event
   **/
	@Override
	public void mouseReleased(MouseEvent e) {

	}


  /**
   * @to display the border of each JLabel to help the player of ensure the position of the mouse
   * @param e the mouse event
   **/
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = 0 ;i<OwnMap.jlabel.length;i++)
			for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
				if(OwnMap.jlabel[i][j] == e.getSource())
					OwnMap.jlabel[i][j].setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			}
	}


  /**
   * @to hide the border to keep the interface is beautiful
   * @param e the mouse event
   **/
	@Override
	public void mouseExited(MouseEvent e) {
		for(int i = 0 ;i<OwnMap.jlabel.length;i++)
			for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
				if(OwnMap.jlabel[i][j] == e.getSource())
					OwnMap.jlabel[i][j].setBorder(null);
			}
	}


  /**
   * @to catch the planks
   * @param e the key event
   **/
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W && jtext[4].getText().equals("")){//catch the top plank
			for(int i = 0 ;i<OwnMap.jlabel.length;i++)
				for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
					if(OwnMap.mapData[i][j] ==	0){//ensure where is the person
						if(OwnMap.mapData[i-1][j] == 8){//the length of the plank equal 1
							if(OwnMap.mapData[i-2][j] == 8){//the length of the plank equal 2
								if(OwnMap.mapData[i-3][j] == 8){//the length of the plank equal 3
									OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i-1][j] = 4;
									OwnMap.mapData[i-2][j] = 4;
									OwnMap.mapData[i-3][j] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("3");
								}
								else{
									OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i-1][j] = 4;
									OwnMap.mapData[i-2][j] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("2");
								}
							}
							else {
								OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
								OwnMap.mapData[i-1][j] = 4;
								jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
								jtext[4].setText("1");
							}
						}
						else;//there is no plank which is on the top of the people
						return;
					}

				}
		}
		if(e.getKeyCode() == KeyEvent.VK_S && jtext[4].getText().equals("")){//catch the bottom plank
			for(int i = 0 ;i<OwnMap.jlabel.length;i++)
				for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
					if(OwnMap.mapData[i][j] ==	0){//ensure where is the person
						if(OwnMap.mapData[i+1][j] == 8){//the length of the plank equal 1
							if(OwnMap.mapData[i+2][j] == 8){//the length of the plank equal 2
								if(OwnMap.mapData[i+3][j] == 8){//the length of the plank equal 3
									OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i+1][j] = 4;
									OwnMap.mapData[i+2][j] = 4;
									OwnMap.mapData[i+3][j] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("3");
								}
								else{
									OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i+1][j] = 4;
									OwnMap.mapData[i+2][j] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("2");
								}
							}
							else {
								OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
								OwnMap.mapData[i+1][j] = 4;
								jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
								jtext[4].setText("1");
							}
						}
						else;//there is no plank which is on the top of the people
						return;
					}

				}
		}
		if(e.getKeyCode() == KeyEvent.VK_A && jtext[4].getText().equals("")){//catch the left plank
			for(int i = 0 ;i<OwnMap.jlabel.length;i++)
				for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
					if(OwnMap.mapData[i][j] ==	0){//ensure where is the person
						if(OwnMap.mapData[i][j-1] == 6){//the length of the plank equal 1
							if(OwnMap.mapData[i][j-2] == 6){//the length of the plank equal 2
								if(OwnMap.mapData[i][j-3] == 6){//the length of the plank equal 3
									OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i][j-1] = 4;
									OwnMap.mapData[i][j-2] = 4;
									OwnMap.mapData[i][j-3] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("3");
								}
								else{
									OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i][j-1] = 4;
									OwnMap.mapData[i][j-2] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("2");
								}
							}
							else {
								OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
								OwnMap.mapData[i][j-1] = 4;
								jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
								jtext[4].setText("1");
							}
						}
						else;//there is no plank which is on the top of the people
						return;
					}

				}
		}
		if(e.getKeyCode() == KeyEvent.VK_D && jtext[4].getText().equals("")){//catch the right plank
			for(int i = 0 ;i<OwnMap.jlabel.length;i++)
				for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
					if(OwnMap.mapData[i][j] ==	0){//ensure where is the person
						if(OwnMap.mapData[i][j+1] == 6){//the length of the plank equal 1
							if(OwnMap.mapData[i][j+2] == 6){//the length of the plank equal 2
								if(OwnMap.mapData[i][j+3] == 6){//the length of the plank equal 3
									OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i][j+1] = 4;
									OwnMap.mapData[i][j+2] = 4;
									OwnMap.mapData[i][j+3] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("3");
								}
								else{
									OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
									OwnMap.mapData[i][j+1] = 4;
									OwnMap.mapData[i][j+2] = 4;
									jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
									jtext[4].setText("2");
								}
							}
							else {
								OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
								OwnMap.mapData[i][j+1] = 4;
								jtext[4].setIcon(new ImageIcon("img/plank2.jpg"));
								jtext[4].setText("1");
							}
						}
						else;//there is no plank which is on the top of the people
						return;
					}

				}
		}
		if(e.getKeyCode() == KeyEvent.VK_R){//rotate the plank
			try {
				for(int i = 0 ;i<OwnMap.jlabel.length;i++)
					for(int j = 0 ; j<OwnMap.jlabel[0].length;j++){
						if(OwnMap.mapData[i][j] ==	0){//ensure where is the person

							if(OwnMap.mapData[i-1][j] == 8){//top
								//ensure the length of the plank

								if(j-1>=0 && OwnMap.mapData[i][j-1] != 6){//rotate to the left direction
									if(i-2>=0 && OwnMap.mapData[i-2][j] == 8){
										if(i-3>=0 && OwnMap.mapData[i-3][j] == 8){
											//ensure in the right direction whether the end of the plank is a stump
											if(j-4>=0 && OwnMap.mapData[i][j-4] == 1 && OwnMap.mapData[i][j-3] != 1 && OwnMap.mapData[i][j-2] != 1){
												OwnMap.mapData[i-1][j] = 4;
												OwnMap.mapData[i-2][j] = 4;
												OwnMap.mapData[i-3][j] = 4;
												OwnMap.mapData[i][j-1] = 6;
												OwnMap.mapData[i][j-2] = 6;
												OwnMap.mapData[i][j-3] = 6;
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/plank1.jpg"));
												return;
											}

										}
										else{//length equal 2
											if(j-3>=0 && OwnMap.mapData[i][j-3] == 1 && OwnMap.mapData[i][j-2] != 1){
												OwnMap.mapData[i-1][j] = 4;
												OwnMap.mapData[i-2][j] = 4;
												OwnMap.mapData[i][j-1] = 6;
												OwnMap.mapData[i][j-2] = 6;
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
									}
									else{//length equal 1
										if(j-2>=0 && OwnMap.mapData[i][j+2] == 1){
											OwnMap.mapData[i-1][j] = 4;
											OwnMap.mapData[i][j-1] = 6;
											OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));

											return;
										}
									}
								}
								if(i+1<=8 && OwnMap.mapData[i+1][j] != 8){//rotate to the bottom direction
									if(i-2>=0 && OwnMap.mapData[i-2][j] == 8){
										if(i-3>=0 && OwnMap.mapData[i-3][j] == 8){
											//ensure in the right direction whether the end of the plank is a stump
											if(i+4<=8 && OwnMap.mapData[i+4][j] == 1 && OwnMap.mapData[i+3][j] != 1 && OwnMap.mapData[i+2][j] != 1){
												OwnMap.mapData[i-1][j] = 4;
												OwnMap.mapData[i-2][j] = 4;
												OwnMap.mapData[i-3][j] = 4;
												OwnMap.mapData[i+1][j] = 8;
												OwnMap.mapData[i+2][j] = 8;
												OwnMap.mapData[i+3][j] = 8;
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/plank2.jpg"));
												return;
											}

										}
										else{//length equal 2
											if(i+3<=8 && OwnMap.mapData[i+3][j] == 1 && OwnMap.mapData[i+2][j] != 1){
												OwnMap.mapData[i-1][j] = 4;
												OwnMap.mapData[i-2][j] = 4;
												OwnMap.mapData[i+1][j] = 8;
												OwnMap.mapData[i+2][j] = 8;
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
									}
									else{//length equal 1
										if(i+2<=8 && OwnMap.mapData[i+2][j] == 1){
											OwnMap.mapData[i-1][j] = 4;
											OwnMap.mapData[i+1][j] = 8;
											OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));

											return;
										}
									}
								}
								if(j+1<=12 && OwnMap.mapData[i][j+1] != 6){//rotate to the right direction
									if(i-2>=0 && OwnMap.mapData[i-2][j] == 8){
										if(i-3>=0 && OwnMap.mapData[i-3][j] == 8){
											//ensure in the right direction whether the end of the plank is a stump
											if(j+4<=12 && OwnMap.mapData[i][j+4] == 1 && OwnMap.mapData[i][j+3] != 1 && OwnMap.mapData[i][j+2] != 1){
												OwnMap.mapData[i-1][j] = 4;
												OwnMap.mapData[i-2][j] = 4;
												OwnMap.mapData[i-3][j] = 4;
												OwnMap.mapData[i][j+1] = 6;
												OwnMap.mapData[i][j+2] = 6;
												OwnMap.mapData[i][j+3] = 6;
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/plank1.jpg"));
												return;
											}

										}
										else{//length equal 2
											if(j+3<=12 && OwnMap.mapData[i][j+3] == 1 && OwnMap.mapData[i][j+2] != 1){
												OwnMap.mapData[i-1][j] = 4;
												OwnMap.mapData[i-2][j] = 4;
												OwnMap.mapData[i][j+1] = 6;
												OwnMap.mapData[i][j+2] = 6;
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
									}
									else{//length equal 1
										if(j+2<=12 && OwnMap.mapData[i][j+2] == 1){
											OwnMap.mapData[i-1][j] = 4;
											OwnMap.mapData[i][j+1] = 6;
											OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));

											return;
										}
									}
								}

							}

							if(OwnMap.mapData[i+1][j] == 8){//bottom
								//ensure the length of the plank
								if(j-1>=0 && OwnMap.mapData[i][j-1] != 6){//rotate to the left direction
									if(i+2<=8 && OwnMap.mapData[i+2][j] == 8){
										if(i+3<=8 && OwnMap.mapData[i+3][j] == 8){
											//length equal 3
											if(j-4>=0 && OwnMap.mapData[i][j-4] == 1 && OwnMap.mapData[i][j-3] != 1 && OwnMap.mapData[i][j-2] != 1){
												OwnMap.mapData[i+1][j] = 4;
												OwnMap.mapData[i+2][j] = 4;
												OwnMap.mapData[i+3][j] = 4;
												OwnMap.mapData[i][j-1] = 6;
												OwnMap.mapData[i][j-2] = 6;
												OwnMap.mapData[i][j-3] = 6;
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}

										}
										else{
											//length equal 2
											if(j-3>=0 && OwnMap.mapData[i][j-3] == 1 && OwnMap.mapData[i][j-2] != 1){
												OwnMap.mapData[i+1][j] = 4;
												OwnMap.mapData[i+2][j] = 4;
												OwnMap.mapData[i][j-1] = 6;
												OwnMap.mapData[i][j-2] = 6;
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
									}
									else{//length of the plank equal 1
										if(j-2>=0 && OwnMap.mapData[i][j-2] == 1){
											OwnMap.mapData[i+1][j] = 4;
											OwnMap.mapData[i][j-1] = 6;
											OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));

											return;
										}
									}
								}
								if(i-1>=0 && OwnMap.mapData[i-1][j] != 8){//rotate to the top direction
									if(i+2<=8 && OwnMap.mapData[i+2][j] == 8){
										if(i+3<=8 && OwnMap.mapData[i+3][j] == 8){
											//length equal 3
											if(i-4>=0 && OwnMap.mapData[i-4][j] == 1 && OwnMap.mapData[i-3][j] != 1 && OwnMap.mapData[i-2][j] != 1){
												OwnMap.mapData[i+1][j] = 4;
												OwnMap.mapData[i+2][j] = 4;
												OwnMap.mapData[i+3][j] = 4;
												OwnMap.mapData[i-1][j] = 8;
												OwnMap.mapData[i-2][j] = 8;
												OwnMap.mapData[i-3][j] = 8;
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}

										}
										else{
											//length equal 2
											if(i-3>=0 && OwnMap.mapData[i-3][j] == 1 && OwnMap.mapData[i-2][j] != 1){
												OwnMap.mapData[i+1][j] = 4;
												OwnMap.mapData[i+2][j] = 4;
												OwnMap.mapData[i-1][j] = 8;
												OwnMap.mapData[i-2][j] = 8;
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
									}
									else{//length of the plank equal 1
										if(i-2>=0 && OwnMap.mapData[i-2][j] == 1){
											OwnMap.mapData[i+1][j] = 4;
											OwnMap.mapData[i-1][j] = 8;
											OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));

											return;
										}
									}
								}
								if(j+1<=12 && OwnMap.mapData[i][j+1] != 6){//rotate to the right direction
									if(i+2<=8 && OwnMap.mapData[i+2][j] == 8){
										if(i+3<=8 && OwnMap.mapData[i+3][j] == 8){
											//length equal 3
											if(j+4<=12 && OwnMap.mapData[i][j+4] == 1 && OwnMap.mapData[i][j+3] != 1 && OwnMap.mapData[i][j+2] != 1){
												OwnMap.mapData[i+1][j] = 4;
												OwnMap.mapData[i+2][j] = 4;
												OwnMap.mapData[i+3][j] = 4;
												OwnMap.mapData[i][j+1] = 6;
												OwnMap.mapData[i][j+2] = 6;
												OwnMap.mapData[i][j+3] = 6;
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}

										}
										else{
											//length equal 2
											if(j+3<=12 && OwnMap.mapData[i][j+3] == 1 && OwnMap.mapData[i][j+2] != 1){
												OwnMap.mapData[i+1][j] = 4;
												OwnMap.mapData[i+2][j] = 4;
												OwnMap.mapData[i][j+1] = 6;
												OwnMap.mapData[i][j+2] = 6;
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
									}
									else{//length of the plank equal 1
										if(j+2<=12 && OwnMap.mapData[i][j+2] == 1){
											OwnMap.mapData[i+1][j] = 4;
											OwnMap.mapData[i][j+1] = 6;
											OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));

											return;
										}
									}
								}

							}

							if(OwnMap.mapData[i][j-1] == 6){//left
								//ensure the length of the plank
								if(i-1>=0 && OwnMap.mapData[i-1][j] != 8){//rotate to the top direction
									if(j-2>=0 && OwnMap.mapData[i][j-2] == 6){
										if(j-3>=0 && OwnMap.mapData[i][j-3] == 6){
											//length equal 3
											if(i-4>=0 && OwnMap.mapData[i-4][j] == 1 && OwnMap.mapData[i-3][j] != 1 && OwnMap.mapData[i-2][j] != 1){
												OwnMap.mapData[i][j-1] = 4;
												OwnMap.mapData[i][j-2] = 4;
												OwnMap.mapData[i][j-3] = 4;
												OwnMap.mapData[i-1][j] = 8;
												OwnMap.mapData[i-2][j] = 8;
												OwnMap.mapData[i-3][j] = 8;
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
										else {
											if(i-3>=0 && OwnMap.mapData[i-3][j] == 1 && OwnMap.mapData[i-2][j] != 1){
												OwnMap.mapData[i][j-1] = 4;
												OwnMap.mapData[i][j-2] = 4;
												OwnMap.mapData[i-1][j] = 8;
												OwnMap.mapData[i-2][j] = 8;
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
									}
									else{
										//length equal 1
										if(i-2>=0 && OwnMap.mapData[i-2][j] == 1){
											OwnMap.mapData[i][j-1] = 4;
											OwnMap.mapData[i-1][j] = 8;
											OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
											return;
										}
									}
								}
								if(j+1<=12 && OwnMap.mapData[i][j+1] != 6){//rotate to the right direction
									if(j-2>=0 && OwnMap.mapData[i][j-2] == 6){
										if(j-3>=0 && OwnMap.mapData[i][j-3] == 6){
											//length equal 3
											if(j+4<=12 && OwnMap.mapData[i][j+4] == 1 && OwnMap.mapData[i][j+3] != 1 && OwnMap.mapData[i][j+2] != 1){
												OwnMap.mapData[i][j-1] = 4;
												OwnMap.mapData[i][j-2] = 4;
												OwnMap.mapData[i][j-3] = 4;
												OwnMap.mapData[i][j+1] = 6;
												OwnMap.mapData[i][j+2] = 6;
												OwnMap.mapData[i][j+3] = 6;
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
										else {
											//length equal 2
											if(j+3<=12 && OwnMap.mapData[i][j+3] == 1 && OwnMap.mapData[i][j+2] != 1){
												OwnMap.mapData[i][j-1] = 4;
												OwnMap.mapData[i][j-2] = 4;
												OwnMap.mapData[i][j+1] = 6;
												OwnMap.mapData[i][j+2] = 6;
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
									}
									else{
										//length equal 1
										if(j+2<=12 && OwnMap.mapData[i][j+2] == 1){
											OwnMap.mapData[i][j-1] = 4;
											OwnMap.mapData[i][j+1] = 6;
											OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/plank1.jpg"));
											return;
										}
									}
								}
								if(i+1<=8 && OwnMap.mapData[i+1][j] != 8){//rotate to the bottom direction
									if(j-2>=0 && OwnMap.mapData[i][j-2] == 6){
										if(j-3>=0 && OwnMap.mapData[i][j-3] == 6){
											//length equal 3
											if(i+4<=8 && OwnMap.mapData[i+4][j] == 1 && OwnMap.mapData[i+3][j] != 1 && OwnMap.mapData[i+2][j] != 1){
												OwnMap.mapData[i][j-1] = 4;
												OwnMap.mapData[i][j-2] = 4;
												OwnMap.mapData[i][j-3] = 4;
												OwnMap.mapData[i+1][j] = 8;
												OwnMap.mapData[i+2][j] = 8;
												OwnMap.mapData[i+3][j] = 8;
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
										else {
											//length equal 2
											if(i+3<=12 && OwnMap.mapData[i+3][j] == 1 && OwnMap.mapData[i+2][j] != 1){
												OwnMap.mapData[i][j-1] = 4;
												OwnMap.mapData[i][j-2] = 4;
												OwnMap.mapData[i+1][j] = 8;
												OwnMap.mapData[i+2][j] = 8;
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
									}
									else{
										//length equal 1
										if(i+2<=12 && OwnMap.mapData[i+2][j] == 1){
											OwnMap.mapData[i][j-1] = 4;
											OwnMap.mapData[i+1][j] = 8;
											OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
											return;
										}
									}
								}

							}

							if(OwnMap.mapData[i][j+1] == 6){//right
								//ensure the length of the plank
								if(i+1<=8 && OwnMap.mapData[i+1][j] != 8){//rotate to the bottom direction
									if(j+2<=12 && OwnMap.mapData[i][j+2] == 6){
										if(j+3<=12 && OwnMap.mapData[i][j+3] == 6){
											//length equal 3
											if(i+4<= 8 && OwnMap.mapData[i+4][j] == 1 && OwnMap.mapData[i+3][j] != 1 && OwnMap.mapData[i+2][j] != 1){
												OwnMap.mapData[i][j+1] = 4;
												OwnMap.mapData[i][j+2] = 4;
												OwnMap.mapData[i][j+3] = 4;
												OwnMap.mapData[i+1][j] = 8;
												OwnMap.mapData[i+2][j] = 8;
												OwnMap.mapData[i+3][j] = 8;
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+3][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
										else{
											//length equal 2
											if(i+3<=8 && OwnMap.mapData[i+3][j] == 1 && OwnMap.mapData[i+2][j] != 1){
												OwnMap.mapData[i][j+1] = 4;
												OwnMap.mapData[i][j+2] = 4;
												OwnMap.mapData[i+1][j] = 8;
												OwnMap.mapData[i+2][j] = 8;
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i+2][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
									}
									else{
										//length equal 1
										if(i+2<=8 && OwnMap.mapData[i+2][j] == 1){
											OwnMap.mapData[i][j+1] = 4;
											OwnMap.mapData[i+1][j] = 8;
											OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i+1][j].setIcon(new ImageIcon("img/plank2.jpg"));

											return;
										}
									}
								}
								if(j-1>=0 && OwnMap.mapData[i][j-1] != 6){//rotate to the left direction
									if(j+2<=12 && OwnMap.mapData[i][j+2] == 6){
										if(j+3<=12 && OwnMap.mapData[i][j+3] == 6){
											//length equal 3
											if(j-4>=0 && OwnMap.mapData[i][j-4] == 1 && OwnMap.mapData[i][j-3] != 1 && OwnMap.mapData[i][j-2] != 1){
												OwnMap.mapData[i][j+1] = 4;
												OwnMap.mapData[i][j+2] = 4;
												OwnMap.mapData[i][j+3] = 4;
												OwnMap.mapData[i][j-1] = 6;
												OwnMap.mapData[i][j-2] = 6;
												OwnMap.mapData[i][j-3] = 6;
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-3].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
										else{
											//length equal 2
											if(j-3>=0 && OwnMap.mapData[i][j-3] == 1 && OwnMap.mapData[i][j-2] != 1){
												OwnMap.mapData[i][j+1] = 4;
												OwnMap.mapData[i][j+2] = 4;
												OwnMap.mapData[i][j-1] = 6;
												OwnMap.mapData[i][j-2] = 6;
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));
												OwnMap.jlabel[i][j-2].setIcon(new ImageIcon("img/plank1.jpg"));

												return;
											}
										}
									}
									else{
										//length equal 1
										if(j-2>=0 && OwnMap.mapData[i][j-2] == 1){
											OwnMap.mapData[i][j+1] = 4;
											OwnMap.mapData[i][j-1] = 6;
											OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i][j-1].setIcon(new ImageIcon("img/plank1.jpg"));

											return;
										}
									}
								}
								if(i-1>=0 && OwnMap.mapData[i-1][j] != 8){//rotate to the top direction
									if(j+2<=12 && OwnMap.mapData[i][j+2] == 6){
										if(j+3<=12 && OwnMap.mapData[i][j+3] == 6){
											//length equal 3
											if(i-4>=0 && OwnMap.mapData[i-4][j] == 1 && OwnMap.mapData[i-3][j] != 1 && OwnMap.mapData[i-2][j] != 1){
												OwnMap.mapData[i][j+1] = 4;
												OwnMap.mapData[i][j+2] = 4;
												OwnMap.mapData[i][j+3] = 4;
												OwnMap.mapData[i-1][j] = 8;
												OwnMap.mapData[i-2][j] = 8;
												OwnMap.mapData[i-3][j] = 8;
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+3].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-3][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
										else{
											//length equal 2
											if(i-3>=0 && OwnMap.mapData[i-3][j] == 1 && OwnMap.mapData[i-2][j] != 1){
												OwnMap.mapData[i][j+1] = 4;
												OwnMap.mapData[i][j+2] = 4;
												OwnMap.mapData[i-1][j] = 8;
												OwnMap.mapData[i-2][j] = 8;
												OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i][j+2].setIcon(new ImageIcon("img/water1.jpg"));
												OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));
												OwnMap.jlabel[i-2][j].setIcon(new ImageIcon("img/plank2.jpg"));

												return;
											}
										}
									}
									else{
										//length equal 1
										if(i-2>=0 && OwnMap.mapData[i-2][j] == 1){
											OwnMap.mapData[i][j+1] = 4;
											OwnMap.mapData[i-1][j] = 8;
											OwnMap.jlabel[i][j+1].setIcon(new ImageIcon("img/water1.jpg"));
											OwnMap.jlabel[i-1][j].setIcon(new ImageIcon("img/plank2.jpg"));

											return;
										}
									}
								}

							}
							return;
						}
					}
			}
			catch (Exception a) {

			}

		}
	}

  /**
   * @the necessary abstract function
   * @param e the key evnt
   **/
	@Override
	public void keyTyped(KeyEvent e) {

	}

  /**
   * @the necessary abstract function
   * @param e the key evnt
   **/
	@Override
	public void keyReleased(KeyEvent e) {

	}

  /**
   * @to update the time string
   * @param s the newest time string
   **/
	public void setTimeString(String s){
		jtext[2].setText(s);
	}
}
