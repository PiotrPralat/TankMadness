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

// Screen after clicked TDM mode
public class TeamDeathmatch extends Component implements MouseMotionListener, MouseListener, ActionListener
{

   JFrame frame = new JFrame("Player Options");
   
   boolean vis = true;
   
   // Adding tank background
   ImageIcon tank;
   Drawing draw = new Drawing();
   
   int playupto = 5;
   
   // TDM screen
   /*** TeamDeathMatch **********************************************
   * Purpose: sets variables used in code to the parameters inputed *
   * Parameters: none                                               * 
   * Returns: none                                                  *
   *****************************************************************/

   public TeamDeathmatch()
   {
      // adding an Image Icon
      tank = new ImageIcon("tank.jpg");
      frame.add(draw);
      
      draw.addMouseMotionListener(this);
      draw.addMouseListener(this);
      
      // Set Background color
      frame.getContentPane().setBackground(Color.white);
      
      String[] points = { "20", "15", "10", "5" };
   
      JPanel background = new JPanel();
      JLabel upTo = new JLabel("Play Up To:");
      upTo.setFont(new Font("impact", Font.BOLD, 30));
      background.add(upTo);
      
      JComboBox <String> upToPoints = new JComboBox<>(points);
      upToPoints.setSelectedIndex(3);
      upToPoints.addActionListener(this);
      
      upToPoints.setPreferredSize(new Dimension(115, 72));
      DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
      dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
      upToPoints.setRenderer(dlcr); 
      
      background.add(upToPoints, BorderLayout.SOUTH);
      background.setBackground(Color.white);
      frame.add(background, BorderLayout.SOUTH);  
       
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
         g.drawString("T E A M    D E A T H M A T C H", 199-55, 154);
         
         
         g.setColor(new Color(110,156,110));
         g.drawString("T E A M    D E A T H M A T C H", 205-55, 150);
      
         Font buttonFont = new Font("impact", Font.ITALIC + Font.BOLD, 50);
         
         g.setFont(buttonFont);
         
         
         // 1V1 shadow
         if (isInside1V1)
         {
            g.setColor(Color.black);
            g.drawString("PLAYER VS PLAYER", 216, 754);
         }
         
         // 1VC shadow
         if (isInside1VC)
         {
            g.setColor(Color.black);
            g.drawString("PLAYER VS COMPUTER", 666, 754);
         }
         
         // Capture The Flag shadow
         if (isInside2V2)
         {
            g.setColor(Color.black);
            g.drawString("2 PLAYERS VS 2 PLAYERS", 136, 849);
         }
         
         // Back shadow
         if (isInsideBack)
         {
            g.setColor(Color.black);
            g.drawString("BACK", 821, 849);
         }
      
                     
         g.setColor(new Color(110,156,110));
         g.drawString("PLAYER VS PLAYER", 220, 750);
         g.drawString("PLAYER VS COMPUTER", 670, 750);
         g.drawString("2 PLAYERS VS 2 PLAYERS", 140, 845);        
         g.drawString("BACK",825,845);
      }        
   }
   
   boolean isInside1V1, isInside1VC, isInside2V2, isInsideBack;
   
   int x, y;
    
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
   
      
      // 1 V 1
      if (x > 215 && x < 215 + 360 && y > 710 && y < 710 + 50)
      {
         isInside1V1 = true; 
         draw.repaint();
      }
      else
      {
         isInside1V1 = false;
         draw.repaint();
      }
      
      // 1 V C
      if ( x > 670 && x < 670 + 430 && y > 710 && y < 710 + 50)    
      {
         isInside1VC = true; 
         draw.repaint();
      }
      else
      {
         isInside1VC = false;
         draw.repaint();
      }  
      
      // 2 V 2
      if ( x > 138 && x < 138 + 478 && y > 805 && y < 805 + 50)
      {
         isInside2V2 = true; 
         draw.repaint();
      }
      else
      {
         isInside2V2 = false;
         draw.repaint();
      }
      
      // Back
      if ( x > 828 && x < 828 + 121 && y > 805 && y < 805 + 50)     
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
    *          return back to start screen if user clicks on "Exit" button     *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseReleased(MouseEvent e) 
   {
      x = e.getX();
      y = e.getY();
      
      // 1V1 button coordinate area
      boolean clicked1V1 =
         x > 215 
         && x < 215 + 360
         && y > 710
         && y < 710 + 50; 
      
      if (clicked1V1) 
      {        
         vis = false;
         new CreateMaze(2,0,0, playupto);
         isVis();                
      } 
      
      // 1VC button coordinate area
      boolean clicked1VC =
         x > 670
         && x < 670 + 430
         && y > 710
         && y < 710 + 50;
   
      if (clicked1VC) 
      {     
         vis = false;
         new CreateMaze(1,0,0, playupto);
         isVis();        
      } 
      
      // 2V2 button coordinate area
      boolean clicked2V2 =
         x > 138
         && x < 138 + 478
         && y > 805
         && y < 805 + 50; 
      
      if (clicked2V2) 
      {        
         vis = false;
         new CreateMaze(4,0,0, playupto);
         isVis();                
      } 
         
      // Back button coordinate area
      boolean clickedBack =
         x > 828
         && x < 828 + 121
         && y > 805
         && y < 805 + 50; 
      
      if (clickedBack) 
      {        
         vis = false;
         new GamemodeChoice();
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
    
    /*** actionPerformed *********************************************
    * Purpose: Stores the amount of points the player chose to go    *
    *          up to in a variable (from a list of options)          *
    * Parameters: Actionevent e - sees what list option user clicks  * 
    * Returns: none                                                  *
    *****************************************************************/
   public void actionPerformed(ActionEvent e) {
      JComboBox cb = (JComboBox)e.getSource();
      String Playupto = (String)cb.getSelectedItem();
      int points = (int)Integer.parseInt(Playupto);
      playupto = points;
   }   
    
}