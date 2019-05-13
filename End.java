

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End extends JPanel{
  private JFrame jf; // the JFrame
  private JLabel quit; // the quit button
  private JLabel createNew; // the create new one button
  /**
   * @the Constructor
   * @param tf to destinguish whether the player pass all the levels,0 means the player fail, 1 means the player success.
   **/
  public End(int tf){
    if(tf == 0){
      jf = new JFrame();
      jf.setSize(600,500);
      quit = new JLabel(new ImageIcon("img/quit.png"));
      quit.addMouseListener(new MouseListener() {

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
      this.setLayout(null);
      quit.setBounds(400, 350, 150, 80);
      this.add(quit);
      jf.add(this);
      jf.setResizable(false);
      jf.setVisible(true);
    }
    if(tf == 1){
      jf = new JFrame();
      jf.setSize(600,500);
      createNew = new JLabel(new ImageIcon("img/createNew.png"));
      createNew.setBounds(390, 350, 150, 80);
      createNew.addMouseListener(new MouseListener(){

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            new CreateOwn();
            jf.setVisible(false);
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
      quit = new JLabel(new ImageIcon("img/quit.png"));
      quit.setBounds(60, 340, 150, 80);
      quit.addMouseListener(new MouseListener() {

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
      this.add(quit);
      this.add(createNew);
      this.setLayout(null);
      jf.setResizable(false);
      jf.add(this);
      jf.setVisible(true);
    }
  }
}
