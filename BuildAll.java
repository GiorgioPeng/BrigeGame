
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;
public class BuildAll extends JFrame implements Observer{
	private int level = 1; // the initial level equal 1
	private CreateMap map; // the game map
	private ControlPeople people;//the control panel

  /**
   * @the constructor to build the game map and the control panel
   **/
	public BuildAll(){
		this.setBackground(Color.BLUE);
		this.setSize(600, 500);
		map = new CreateMap(this.getWidth(), this.getHeight(), level);
		people = new ControlPeople(130,430,level,this);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		people.addKeyListener(people);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.add(map);
		this.add(people);
	}

	public ControlPeople getPp(){
		return people;
	}

	/**
	 * @repaint the map of the next level
	 **/
	public void rp(int l){
		this.remove(people);
		this.remove(map);
		people = null;
		map = null;
		map = new CreateMap(this.getWidth(), this.getHeight(), l);
		people = new ControlPeople(130,430,l,this);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		people.addKeyListener(people);
		this.add(map);
		this.add(people);
		this.repaint();
		this.setVisible(true);
		people.requestFocus();
		people.jtext[0].setText("Level "+l);
	}

  /**
   * @go to the next level
   * @param arg the data which is passed by the Observer
   **/
	@Override
	public void update(Observable o, Object arg) {
		Integer l = (Integer) arg;
		switch(l) {
			case 2:
				rp(l);
				break;
			case 3:
				rp(l);
				break;
			case 4:
				rp(l);
				break;
			default:
				break;

		}
	}


/**
 * @set this JFrame is not visible
 **/
 public void setVisi(){
	 this.setVisible(true);
	 this.runTimeStop(people);
 }


 /**
  * @the timer to tell the players how much time do they have
  * @param people to ensure which level the player playing
  **/
 public void runTimeStop(ControlPeople people){
   //create a new Thread to timekeeping
	 new Thread(new Runnable(){

		 @Override
		 public void run() {
			 int time = 180;
			 int min = 0;
			 int sec = 0;
			 String timeString = "";
			 while(time>0){
				 min = time/60;
				 sec = time - min*60;
				 if(sec<10){
					 timeString = min+":0"+sec;
					 people.setTimeString(timeString);
				 }
				 else{
					 timeString = min+":"+sec;
					 people.setTimeString(timeString);
				 }
				 try {
					 Thread.sleep(1000);
				 } catch(InterruptedException e) {
					 e.printStackTrace();
				 }
				 time--;

         //if the player pass all levels
				 if(people.getLevel() == 5){
					 setVisible(false);
					 new End(1){
						 public void paintComponent(Graphics g){
							 super.paintComponent(g);
							 ImageIcon i = new ImageIcon("img/congratulation.png");
							 g.drawImage(i.getImage(),0,0,this.getWidth(),this.getHeight(),i.getImageObserver());
						 }
				 		};
				 	break;

	   	 	}
		 }

      //the player dose not pass all the levels
	   	 if(people.getLevel()!=5&&people.getLevel()!=4){
	   		 setVisible(false);
	   		 new End(0){
	   			 public void paintComponent(Graphics g){
	   				 super.paintComponent(g);
	   				 ImageIcon i = new ImageIcon("img/GameOver.png");
	   				 g.drawImage(i.getImage(),0,0,this.getWidth(),this.getHeight(),i.getImageObserver());
	   			 }
		     };
	   	 }


		 }
	 }).start();

 }
}
