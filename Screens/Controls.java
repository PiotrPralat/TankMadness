/*********************************************************
*  Name: Youssef Elhadad, Ethan Ing, Piotr Pralat        *
*  Course: ICS 4M  Pd. 8                                 *
*  Assignment summative                                  *
*  Purpose: Tank madness Game                            *
*  Due Date: May 23, 2019                                *
*********************************************************/
// import statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Victory Screens
public class Controls extends Component implements MouseMotionListener, MouseListener  
{     
   
   JFrame frame = new JFrame("Controls");
   
   boolean vis = true;
   
   // Adding drawings
   ImageIcon keyboard,red,blue,yellow,purple;
   
   Drawing draw = new Drawing();
   
   /*** Controls ****************************************************
   * Purpose: sets variables used in code to the parameters inputed *
   * Parameters: none                                               * 
   * Returns: none                                                  *
   *****************************************************************/
   public Controls()
   {
      blue = new ImageIcon("blue.png");
      red = new ImageIcon("red.png");
      yellow = new ImageIcon("yellow.png");
      purple = new ImageIcon("purple.png");
      keyboard = new ImageIcon("keyboard.png");
   
      frame.add(draw);
      draw.addMouseMotionListener(this);
      draw.addMouseListener(this);
      
      // Set Background color
      frame.getContentPane().setBackground(Color.white);
      
      // Set screen size
      frame.setSize(1275,1500);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }    
     
   class Drawing extends JComponent
   {  
       /*** paint *****************************************************************
       * Purpose: Draws all images and text on screen                             *                                                                          
       * Parameters: Graphics g - GUI graphics for drawing                        *                                   
       * Returns: none                                                            *
       ***************************************************************************/
      public void paint(Graphics g)
      {
      
         Font buttonFont = new Font("impact", Font.ITALIC + Font.BOLD, 50);          
         g.setFont(buttonFont);
      
          // Exit button
         if (isInsideBack)
         {
            g.setColor(Color.black);
            g.drawString("BACK", 27, 63);
         }
                     
         g.drawImage(keyboard.getImage(),280,200,700,250,this);
         g.drawImage(blue.getImage(),300,450,100,100,this);
         g.drawImage(yellow.getImage(),450,450,100,100,this);
         g.drawImage(red.getImage(),750,450,100,100,this);
         g.drawImage(purple.getImage(),900,450,100,100,this);
                       
         Font title = new Font("impact", Font.BOLD, 90);            
         g.setFont(title);
         g.setColor(Color.black);
         g.drawString("C O N T R O L S", 400, 116);
         
         
         g.setColor(new Color(110,156,110));
         g.drawString("C O N T R O L S", 406, 110);
         
         
         g.setFont(buttonFont);
         g.setColor(new Color(110,156,110));
         g.drawString("BACK",30,60);
         
         
         Font sub = new Font("impact", Font.BOLD, 15);            
         g.setFont(sub);
         
         g.setColor(Color.black);
         g.drawString("Q - shoot",300,570);
         g.drawString("W - move forward",300,590);
         g.drawString("S - move backward",300,610);
         g.drawString("A - rotate left",300,630);
         g.drawString("D - rotate right",300,650);
         
         g.drawString("T - shoot",450,570);
         g.drawString("Y - move forward",450,590);
         g.drawString("H - move backward",450,610);
         g.drawString("G - rotate left",450,630);
         g.drawString("J - rotate right",450,650);
      
         g.drawString("M- shoot",730,570);
         g.drawString("up - move forward",730,590);
         g.drawString("down - move backward",730,610);
         g.drawString("left- rotate left",730,630);
         g.drawString("right - rotate right",730,650);
         
         g.drawString("7 - shoot",900,570);
         g.drawString("8 - move forward",900,590);
         g.drawString("5 - move backward",900,610);
         g.drawString("4 - rotate left",900,630);
         g.drawString("6 - rotate right",900,650);
      
      
         
      }  
   }
   
   boolean isInsideBack = false;
           
   int x,y;
    
    /*** mouseMoved ************************************************************
    * Purpose: Checks the movement of the mouse and the coordinates to check   *
    *          if mouse is hovering over "BACK" button                         *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseMoved(MouseEvent e)
   {
      x = e.getX();
      y = e.getY();  
      
      // Back button
      if (x > 35 && x < 35 + 105 && y > 20 && y < 20 + 50)
      {
         isInsideBack = true; 
         draw.repaint();
      }
      else
      {
         isInsideBack = false;
         draw.repaint();
      }
      
   }
    
    /*** isVis *****************************************************************
    * Purpose: makes frame invisible (not visible)                             *                                                                        
    * Parameters: none                                                         *                                  
    * Returns: none                                                            *
    ***************************************************************************/
   public void isVis()
   {
      if (!vis)
         frame.setVisible(false);
   } 
   
   // *** Need because implementing MouseMotionListener - Not used in code ***
   public void mouseDragged(MouseEvent e)
   {
   
   }
 
    
    /*** mouseReleased *********************************************************
    * Purpose: Checks the coordinates where the mouse was released and will    *
    *          return back to start screen if user clicks on "BACK" button     *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseReleased(MouseEvent e) 
   {
      x = e.getX();
      y = e.getY();
      
      // Back button coordinate area
      boolean clickedBack =
         x > 35 
         && x < 35 + 105
         && y > 20
         && y < 20 + 50; 
      
      if (clickedBack) 
      {        
         vis = false;
         new StartScreen();
         isVis();                
      } 
   }
   
   // *** Need because implementing MouseListener - Not used in code ***
   public void mousePressed (MouseEvent e) 
   {
   }
   
   public void mouseClicked (MouseEvent e) 
   {
   }

   public void mouseEntered (MouseEvent e) 
   {
   }

   public void mouseExited (MouseEvent e) 
   {
   }  
       
}