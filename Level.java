
import java.util.Observable;
public class Level extends Observable{
  private static int level = 1; // to identify the level

  /**
   * @to judge whether the level is changed, if the level is changed then notify observers
   **/
  public void setLevel(int l){
    if(level!=l){
      level = l;
      setChanged();
      notifyObservers(level);
    }
  }
}
