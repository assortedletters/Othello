/**Daniel Kessler 
 * testing class for Othello methods
  */
import org.junit.*;
import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

public class OthelloTester extends Othello {
  
  /** tests getRow method. 
    */
  @Test
  public void testGetRow() {
    assertEquals(getRow(getSpaces()[0][0]), 0);
    assertEquals(getRow(getSpaces()[0][4]), 0);
    assertEquals(getRow(getSpaces()[0][7]), 0);
    assertEquals(getRow(getSpaces()[3][0]), 3);
    assertEquals(getRow(getSpaces()[3][3]), 3);
    assertEquals(getRow(getSpaces()[5][4]), 5);
    assertEquals(getRow(getSpaces()[5][0]), 5);
    assertEquals(getRow(getSpaces()[7][3]), 7);
    assertEquals(getRow(getSpaces()[7][0]), 7);
    assertEquals(getRow(getSpaces()[7][7]), 7);
    try {
      getRow(new JButton());
    } catch(NoSuchElementException e) {
      }
  }
  /**tests getColumn method
    */
  @Test
  public void testGetColumn() {
    assertEquals(getColumn(getSpaces()[0][0]), 0);
    assertEquals(getColumn(getSpaces()[0][4]), 4);
    assertEquals(getColumn(getSpaces()[0][7]), 7);
    assertEquals(getColumn(getSpaces()[3][0]), 0);
    assertEquals(getColumn(getSpaces()[3][3]), 3);
    assertEquals(getColumn(getSpaces()[5][4]), 4);
    assertEquals(getColumn(getSpaces()[5][0]), 0);
    assertEquals(getColumn(getSpaces()[7][3]), 3);
    assertEquals(getColumn(getSpaces()[7][0]), 0);
    assertEquals(getColumn(getSpaces()[7][7]), 7);
    try {
      getColumn(new JButton());
    } catch(NoSuchElementException e) {
      }
  }
}
  
  

   