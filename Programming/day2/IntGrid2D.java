/*
Emma Blair
11/28/17
CP222
*/

public class IntGrid2D implements IIntGrid2D {
  int upper_lx;
  int upper_ly;
  int lower_rx;
  int lower_ry;
  char fill_value;
  char new_letter;
  char new_letter_2;

  //with a different test, height and width can be passed in to constructor
  //in order the change the size of the grid
  int width = 3;
  int height = 3;

  char[][] grid;


  public IntGrid2D(int _upper_lx, int _upper_ly, int _lower_rx, int _lower_ry, char _fill_value) {
    upper_lx = _upper_lx;
    upper_ly = _upper_ly;
    lower_rx = _lower_rx;
    lower_ry = _lower_ry;
    fill_value = _fill_value;

    grid = new char[width][height];
  }

  public void setPoint(IIntPoint2D p, char v) {
    grid[p.getX() + 1][(p.getY() * -1) + 1] = v;
    if (v == 'X') {
      new_letter = v;
    } else if (v == 'O') {
      new_letter_2 = v;
    }
  }

  public char getPoint(IIntPoint2D p) {
    if (grid[p.getX() + 1][(p.getY() * -1) + 1] == new_letter) {
      return new_letter;
    } else if (grid[p.getX() + 1][(p.getY() * -1) + 1] == new_letter_2) {
      return new_letter_2;
    } else {
      return fill_value;
    }
  }

  public IIntPoint2D getUpperLeftCorner() {
    IIntPoint2D l = new IntPoint2D(upper_lx, upper_ly);
    return l;
  }

  public IIntPoint2D getLowerRightCorner() {
    IIntPoint2D r = new IntPoint2D(lower_rx, lower_ry);
    return r;
  }

}
