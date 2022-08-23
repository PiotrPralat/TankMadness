/*********************************************************
*  Name: Youssef Elhadad, Ethan Ing, Piotr Pralat        *
*  Course: ICS 4M  Pd. 8                                 *
*  Assignment summative                                  *
*  Purpose: Tank madness Game                            *
*  Due Date: May 23, 2019                                *
*********************************************************/
// import statements for the use of buttons
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Screen after clicking Play Now - Game Modes
public class GamemodeChoice extends Component implements MouseMotionListener, MouseListener  
{

   JFrame frame = new JFrame("Game Mode");
   
   boolean vis = true;
   
   // Adding tank background
   ImageIcon tank;
   Drawing draw = new Drawing();
   
   // StartScreen with buttons
   
   /*** GamemodeChoice **********************************************
   * Purpose: sets variables used in code to the parameters inputed *
   * Parameters: none                                               * 
   * Returns: none                                                  *
   *****************************************************************/

   public GamemodeChoice()
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
    
    // Drawing Class
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
         g.drawString("G A M E    M O D E", 364-30, 154);
         
         
         g.setColor(new Color(110,156,110));
         g.drawString("G A M E    M O D E", 370-30, 150);
      
      
         // Button Fonts
         Font buttonFont = new Font("impact", Font.ITALIC + Font.BOLD, 50);           
         g.setFont(buttonFont);
                  
         // Team Deathmatch shadow
         if (isInsideTDM)
         {
            g.setColor(Color.black);
            g.drawString("TEAM DEATHMATCH", 211, 754);
         }
         
         // Hardpoint shadow
         if (isInsideHP)
         {
            g.setColor(Color.black);
            g.drawString("HARDPOINT", 761, 754);
         }
         
         // Capture The Flag shadow
         if (isInsideCTF)
         {
            g.setColor(Color.black);
            g.drawString("CAPTURE THE FLAG", 215, 849);
         }
         
         // Back shadow
         if (isInsideBack)
         {
            g.setColor(Color.black);
            g.drawString("BACK", 812, 849);
         }
            
         g.setColor(new Color(110,156,110));
         g.drawString("TEAM DEATHMATCH", 215, 750);
         g.drawString("HARDPOINT", 765, 750);
         g.drawString("CAPTURE THE FLAG", 219, 845);
         g.drawString("BACK",816,845);
         
      }        
   }
   
   boolean isInsideCTF, isInsideTDM, isInsideHP, isInsideBack;
           
   int x,y;
    
    /*** mouseMoved ************************************************************
    * Purpose: Checks the movement of the mouse and the coordinates to check   *
    *          if mouse is hovering over any buttons                           *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseMoved(MouseEvent e)
   {
      x = e.getX();
      y = e.getY();  
      
      // Team Deathmatch
      if (x > 215 && x < 215 + 425 && y > 710 && y < 710 + 50)
      {
         isInsideTDM = true; 
         draw.repaint();
      }
      else
      {
         isInsideTDM = false;
         draw.repaint();
      }
      
      // Hardpoint
      if ( x > 765 && x < 765 + 232 && y > 710 && y < 710 + 50)    
      {
         isInsideHP = true; 
         draw.repaint();
      }
      else
      {
         isInsideHP = false;
         draw.repaint();
      }  
      
      // Capture The Flag
      if ( x > 220 && x < 220 + 405 && y > 805 && y < 805 + 50)
      {
         isInsideCTF = true; 
         draw.repaint();
      }
      else
      {
         isInsideCTF = false;
         draw.repaint();
      }
      
      // Back
      if ( x > 818 && x < 818 + 117 && y > 805 && y < 805 + 50)     
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
    *          go to appropiate screen depending on button clicked             *                                                                               
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseReleased(MouseEvent e) 
   {
      x = e.getX();
      y = e.getY();
      
      // Team Deathmatch button coordinate area
      boolean clickedTDM =
         x > 215 
         && x < 215 + 425
         && y > 710
         && y < 710 + 50; 
      
      if (clickedTDM) 
      {        
         vis = false;
         new TeamDeathmatch();
         isVis();                
      } 
      
      // Hardpoint button coordinate area
      boolean clickedHardpoint =
         x > 765
         && x < 765 + 232
         && y > 710
         && y < 710 + 50;
   
      if (clickedHardpoint) 
      {     
         vis = false;
         new Hardpoint();
         isVis();        
      } 
      
      // Capture The Flag button coordinate area
      boolean clickedCTF =
         x > 220
         && x < 220 + 405
         && y > 805
         && y < 805 + 50; 
      
      if (clickedCTF) 
      {        
         vis = false;
         new CaptureTheFlag();
         isVis();                
      } 
         
      // Back button coordinate area
      boolean clickedBack =
         x > 818
         && x < 818 + 117
         && y > 805
         && y < 805 + 50; 
      
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