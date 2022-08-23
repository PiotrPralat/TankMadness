

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

// Rules screen
public class Rules extends Component implements MouseMotionListener, MouseListener  
{     
   
   JFrame frame = new JFrame("Rules");
   
   boolean vis = true;
   
   // Adding drawings
   ImageIcon screen, redTank, yellowTank, purpleTank, blueTank;
   Drawing draw = new Drawing();

   /*** Rules ****************************************************
   * Purpose: sets variables used in code to the parameters inputed *
   * Parameters: none                                               * 
   * Returns: none                                                  *
   *****************************************************************/ 
   public Rules()
   {
               
      // adding an Image Icon
      screen = new ImageIcon("Screen.png");
   
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
         
         
         Font buttonFont = new Font("impact", Font.ITALIC + Font.BOLD, 50);          
         g.setFont(buttonFont);
      
          // back button
         if (isInsideBack)
         {
            g.setColor(Color.black);
            g.drawString("BACK", 27, 63);
         }
                             
                       
         Font title = new Font("impact", Font.BOLD, 90);            
         g.setFont(title);
         g.setColor(Color.black);
         g.drawString("R U L E S", 500, 116);
         
         
         g.setColor(new Color(110,156,110));
         g.drawString("R U L E S", 506, 110);
         
         
         g.setFont(buttonFont);
         g.setColor(new Color(110,156,110));
         g.drawString("BACK",30,60);
         
         
         
         // Subtitles
         Font subTitle = new Font("impact", Font.BOLD, 40); 
         Font description = new Font("serif",Font.PLAIN,15);
         g.setFont(subTitle);
         g.setColor(Color.red);
            
         g.drawString("Teams",170,180);
         g.drawString("Maze",170,300);
         g.drawString("Bullets",170,430);
         g.drawString("Game Modes",170,580);
         g.drawString("Items/Powerups",170,820);
         
         g.setFont(description);
         g.setColor(Color.black);
         g.drawString("The game is played by two teams. In the two player mode, one player controls the red tank while the other player controls the blue tank. The red tank is always controlled",170,210);
         g.drawString("by a player, and depending on the game mode selected, the blue tank will be controlled by either an AI or another user. If the four player gamemode type is selected then",170,225); 
         g.drawString("the players can also control a purple tank and a yellow tank. The yellow and blue tank will be in one team, and the other team will include the red and purple tank.",170,240);
         
         
         g.drawString("The randomly generated sequence of barriers in the maze-like field will act as walls that objects cannot go through.",170,330);
         g.drawString("This means that if a tank goes next to the wall it will not be able to go through it and can only move through the",170,345);
         g.drawString("empty space in between. Furthermore, the bullets will also bounce off the walls and move in the opposite direction",170,360);
         g.drawString("if they make contact with the wall. Also, the bullets will not be able to go through the walls.",170,375);
         
         
         g.drawString("The bullets will be fired from the nose of the tank and will be the same size and diameter as the width of the nose. The bullets will be circular in shape and move in a",170,460);
         g.drawString("straight line in the direction from where they were fired. If the bullets make contact with any of the tanks, then the tanks explode by having an explosion icon",170,475);
         g.drawString("cover the tank and the other team gets a point/coins depending on the gamemode. If the bullets do not make contact with any of the tanks for six seconds, then",170,490);
         g.drawString("they will immediately disappear and be removed from the game. In particular, that means that they should not reappear on the screen and cannot do any damage to the",170,505);
         g.drawString("tanks. A player can only fire five bullets at time. Once a bullet is fired and six seconds have passed it should reload into the tank and be able to be fired again.",170,520);
         
         
         g.drawString("Game modes can go up to 5, 10, 15, or 20 points, depending on what the player chooses in the game mode option screen.",170,610);
         g.drawString("A play up to button will be on the bottom of the Game mode screen.",170,625);
         
         g.drawString("1. Team Deathmatch - either 1 Player vs Computer, 2 Players vs 2 Players, or Player vs Player. Respawn occurs after each round.",170,655);
         g.drawString("                                    Objective is to kill and shoot opposing players and a point is awarded to a team that kills all the opposing players each round.",170,670);
         
         g.drawString("2. Hardpoint - only 2 Players vs 2 Players. Respawn occurs after 2 seconds for each tank. Objective is to gain a position and fight over specified hardpoint locations ",170,700);
         g.drawString("                       which will appear as a blue square randomly on the map.  Points are rewarded to any player who is in the hardpoint when it disappears after 20 seconds.",170,715);
         
         g.drawString("3. Capture The Flag - only 2 Players vs 2 Players. Respawn occurs after 2 seconds for each tank. Objective is to grab the opponents flag and bring it back to ",170,745);                     
         g.drawString("                                   your flag. Points are awarded to teams that succesfully carry the opposing teams flag back to their flag at their own base.",170,760);
         
         
         g.drawString("Powerups and items provide beneficial abilities to the tanks being used. These abilities range from increased speed, to increased fire rate, or teleportation.",170,850);
         g.drawString("There are 4 powerups which can be picked up in Team Deathmatch as they will randomly spawn every 5-15 seconds. There are also 8 items which can be bought from",170,865);
         g.drawString("your team's money in game for Capture The Flag and Hardpoint. Your money bank will appear in your top corner and the item shop will be on your side. In game money",170,880);
         g.drawString("can be picked up in Capture The flag and Hardpoint. Money will also be rewarded to a team when the opposing team gets killed. Strategize when purchasing items.",170,895);
         g.drawImage(screen.getImage(),940,255,200,170,this);
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
    *          return back to start screen if user clicked "BACK" button       *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseReleased(MouseEvent e) 
   {
      x = e.getX();
      y = e.getY();
      
      // Exit button coordinate area
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