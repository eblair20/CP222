

public class IntPoint2D implements IIntPoint2D {

  int x;
  int y;

  public IntPoint2D(int new_x, int new_y) {
    x = new_x;
    y = new_y;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public int manhattanDistance(IIntPoint2D o){
     return Math.abs(x - o.getX()) + Math.abs(y - o.getY());
  }

  public double distance(IIntPoint2D o){
    return Math.sqrt(Math.pow(x - o.getX(), 2) + Math.pow(y - o.getY(), 2));
  }

  public String toString(){
    return "x = " + x + " y = " + y;
  }

  public boolean equals(Object o){
    if (o.equals(x) && o.equals(y)) {
      return true;
    }
    else {
      return false;
    }
  }

  public int hashcode(){
    return (x<<16)+y;
  }

}
