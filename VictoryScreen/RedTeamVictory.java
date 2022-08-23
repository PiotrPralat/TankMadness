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

// Victory Screen
public class RedTeamVictory extends Component implements MouseMotionListener, MouseListener  
{
     
   JFrame frame = new JFrame("Victory");
   
   boolean vis = true;
   
   // Adding drawings
   ImageIcon redTank, yellowTank, purpleTank, blueTank;
   Drawing draw = new Drawing();
   int teamonepoints, teamtwopoints, numberoftanks;
   
   // Victory Screen for red team
   /*** RedTeamVictory *********************************************
   * Purpose: sets variables used in code to the parameters inputed *
   * Parameters: numberoftanks - number of tanks being played       *
   *             teamonepoints - points for team one                *
   *             teamtwopoints - points for team one                * 
   * Returns: none                                                  *
   *****************************************************************/
   public RedTeamVictory(int numberoftanks, int teamonepoints, int teamtwopoints)
   {
      this.teamonepoints = teamonepoints;
      this.teamtwopoints = teamtwopoints;
      this.numberoftanks = numberoftanks;
      
      // adding tank images
      redTank = new ImageIcon("RedTank.jpg");
      purpleTank = new ImageIcon("PurpleTank.jpg");
      yellowTank = new ImageIcon("YellowTank.jpg");
      blueTank = new ImageIcon("BlueTank1v1.jpg");
   
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
      
          // Team Deathmatch shadow
         if (isInsideExit)
         {
            g.setColor(Color.black);
            g.drawString("EXIT", 27, 63);
         }                   
         
         if (numberoftanks > 2)
         {
            g.drawImage(redTank.getImage(),60,450,380,290,this);
            g.drawImage(purpleTank.getImage(),465,450,380,290,this);
            g.drawImage(blueTank.getImage(),990,100,180,130,this);
            g.drawImage(yellowTank.getImage(),780,100,180,130,this);
         }
         else if (numberoftanks <= 2)
         {
            g.drawImage(redTank.getImage(),270,450,380,290,this);
            g.drawImage(blueTank.getImage(),870,100,180,130,this);
         }
      
         // Score
         Font scoreV = new Font("impact", Font.BOLD, 100);
         g.setFont(scoreV);
              
         g.setColor(Color.black);
         g.drawString(Integer.toString(teamonepoints), 421,839);
          
         g.setColor(new Color(255,204,0));
         g.drawString(Integer.toString(teamonepoints), 427,835);
         
         Font scoreL = new Font("impact", Font.PLAIN, 50);
         g.setFont(scoreL);         
         g.setColor(Color.black);
         g.drawString(Integer.toString(teamtwopoints), 970,280);   
      
         Font title = new Font("impact", Font.BOLD, 100);
         
         g.setFont(title);
         g.setColor(Color.black);
         g.drawString("V I C T O R Y", 235, 414);
         
         
         g.setColor(new Color(255,204,0));
         g.drawString("V I C T O R Y", 241, 410);
         
         g.setColor(Color.red);
         g.drawLine(600,0,1200,1000);
         g.setColor(Color.black);
         g.drawLine(580,0,1180,1000);
         
         g.setFont(buttonFont);
         g.setColor(new Color(110,156,110));
         g.drawString("EXIT",30,60);
         
         
      }  
   }
   
   boolean isInsideExit = false;           
   int x,y;
    
    /*** mouseMoved ************************************************************
    * Purpose: Checks the movement of the mouse and the coordinates to check   *
    *          if mouse is hovering over "Exit" button                         *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseMoved(MouseEvent e)
   {
      x = e.getX();
      y = e.getY();  
      
      // Exit button
      if (x > 35 && x < 35 + 90 && y > 20 && y < 20 + 50)
      {
         isInsideExit = true; 
         draw.repaint();
      }
      else
      {
         isInsideExit = false;
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
    *          return back to start screen if user clicks on "Exit" button     *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseReleased(MouseEvent e) 
   {
      x = e.getX();
      y = e.getY();
      
      // Exit button coordinate area
      boolean clickedExit =
         x > 35 
         && x < 35 + 90
         && y > 20
         && y < 20 + 50; 
      
      if (clickedExit) 
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