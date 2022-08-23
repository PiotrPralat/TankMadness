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

// Start Screen class - starts game
public class StartScreen extends Component implements MouseMotionListener, MouseListener  
{

   JFrame frame = new JFrame("Tank Madness");
   
   boolean vis = true;
   
   // Adding tank background
   ImageIcon tank;
   Drawing draw = new Drawing();
   
   // StartScreen with buttons
   /*** StartScreen *************************************************
   * Purpose: sets variable used in code to the parameters inputed *
   * Parameters: none                                               * 
   * Returns: none                                                  *
   *****************************************************************/

   public StartScreen()
   {
      // adding an Image Icon
      tank = new ImageIcon("tank.jpg");
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
    
    // Drawing class
   class Drawing extends JComponent
   {
       /*** paint *****************************************************************
       * Purpose: Draws all images and text on screen                             *                                                                          
       * Parameters: Graphics g - GUI graphics for drawing                        *                                   
       * Returns: none                                                            *
       ***************************************************************************/
      public void paint(Graphics g)
      {
         g.drawImage(tank.getImage(),190,150,850,550,this);
         
         Font title = new Font("impact", Font.BOLD, 85);
         
         g.setFont(title);
         g.setColor(Color.black);
         g.drawString("T A N K    M A D N E S S", 294-50, 154);
         
         g.setColor(new Color(110,156,110));
         g.drawString("T A N K    M A D N E S S", 300-50, 150);
      
         Font buttonFont = new Font("impact", Font.ITALIC + Font.BOLD, 50);
         
         g.setFont(buttonFont);
         
         if (isInsidePlay)
         {
            g.setColor(Color.black);
            g.drawString("PLAY NOW", 250, 804);
         }
      
         if (isInsideRules)
         {
            g.setColor(Color.black);
            g.drawString("RULES",560,804);
         }
         
         if(isInsideControls)
         {
            g.setColor(Color.black);
            g.drawString("CONTROLS",786,804);
         }
            
         g.setColor(new Color(110,156,110));
         g.drawString("PLAY NOW", 254, 800);
         g.drawString("RULES",564,800);
         g.drawString("CONTROLS",790,800);
         
      }        
   }
   
   boolean isInsidePlay, isInsideRules, isInsideControls;
         
   int x, y;
    
    /*** mouseMoved ************************************************************
    * Purpose: Checks the movement of the mouse and the coordinates to check   *
    *          if mouse is hovering over buttons                               *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseMoved(MouseEvent e)
   {
      x = e.getX();
      y = e.getY();  
      
      // Play button
      if (x > 251 && x < 251 + 205 && y > 755 && y < 755 + 50)
      {
         isInsidePlay = true; 
         draw.repaint();
      }
      else
      {
         isInsidePlay = false;
         draw.repaint();
      }
      
      // Rules button
      if ( x > 561 && x < 561 + 130 && y > 755 && y < 755 + 50)
      {
         isInsideRules = true; 
         draw.repaint();
      }
      else
      {
         isInsideRules = false;
         draw.repaint();
      }
      
      // Controls button
      if ( x > 788 && x < 788 + 210 && y > 755 && y < 755 + 50)
      {
         isInsideControls = true; 
         draw.repaint();
      }
      else
      {
         isInsideControls = false;
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
    *          return back to start screen if user clicks on buttons           *                                                                   
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseReleased(MouseEvent e){
      x = e.getX();
      y = e.getY();
   
      // Play button coordinate area
      boolean clickedPlay =
         x > 251
         && x < 251 + 205
         && y > 755
         && y < 755 + 50; 
      
      if (clickedPlay) 
      {        
         vis = false;
         new GamemodeChoice();
         isVis();
                    
      } 
      
      // Rule button coordinate area
      boolean clickedRules =
         x > 561
         && x < 561 + 130
         && y > 755
         && y < 755 + 50;
   
      if (clickedRules) 
      {     
         vis = false;
         new Rules();
         isVis();        
      } 
      
      // Controls button coordinate arear
      boolean clickedControls =
         x > 788
         && x < 788 + 210
         && y > 755
         && y < 755 + 50;
   
      if (clickedControls) 
      {     
         vis = false;
         new Controls();
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
                  
   public static void main (String [] args)
   {
      new StartScreen();
   }
}