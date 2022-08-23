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

// Screen after clicked Capture the flag mode
public class CaptureTheFlag extends Component implements MouseMotionListener, MouseListener, ActionListener
{

   JFrame frame = new JFrame("Map Options");
   
   boolean vis = true;
   
   // Adding tank background
   ImageIcon tank;
   Drawing draw = new Drawing();
   
   int playupto = 5;
   
   // CTF map options
   /*** CaptureTheFlag **********************************************
   * Purpose: sets variables used in code to the parameters inputed *
   * Parameters: none                                               * 
   * Returns: none                                                  *
   *****************************************************************/
   public CaptureTheFlag()
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
         g.drawString("C A P T U R E    T H E    F L A G", 200-50, 154);
         
         
         g.setColor(new Color(110,156,110));
         g.drawString("C A P T U R E    T H E    F L A G", 206-50, 150);
      
         Font buttonFont = new Font("impact", Font.ITALIC + Font.BOLD, 50);
         
         g.setFont(buttonFont);
         
         
         // CUSTOM MAP ONE shadow
         if (isInsideCM1)
         {
            g.setColor(Color.black);
            g.drawString("CUSTOM MAP ONE", 211, 754);
         }
         
         // CUSTOM MAP TWO shadow
         if (isInsideCM2)
         {
            g.setColor(Color.black);
            g.drawString("CUSTOM MAP TWO", 670, 754);
         }
         
         // Random MAP shadow
         if (isInsideRandom)
         {
            g.setColor(Color.black);
            g.drawString("RANDOM MAP", 235, 849);
         }
         
         // Back shadow
         if (isInsideBack)
         {
            g.setColor(Color.black);
            g.drawString("BACK", 802, 849);
         }
            
         g.setColor(new Color(110,156,110));
         g.drawString("CUSTOM MAP ONE", 215, 750);
         g.drawString("CUSTOM MAP TWO", 674, 750);
         g.drawString("RANDOM MAP", 239, 845);
         g.drawString("BACK",806,845);
         
      }        
   }
   
   // True if coordinates are inside
   boolean isInsideCM1, isInsideCM2, isInsideRandom, isInsideBack;
           
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
      
      // CUSTOM MAP ONE coordinates
      if (x > 215 && x < 215 + 350 && y > 710 && y < 710 + 50)
      {
         isInsideCM1 = true; 
         draw.repaint();
      }
      else
      {
         isInsideCM1 = false;
         draw.repaint();
      }
      
      // CUSTOM MAP TWO coordinates
      if ( x > 675 && x < 675 + 370 && y > 710 && y < 710 + 50)    
      {
         isInsideCM2 = true; 
         draw.repaint();
      }
      else
      {
         isInsideCM2 = false;
         draw.repaint();
      }  
      
      // RANDOM MAP coordinates
      if ( x > 235 && x < 235 + 270 && y > 805 && y < 805 + 50)
      {
         isInsideRandom = true; 
         draw.repaint();
      }
      else
      {
         isInsideRandom = false;
         draw.repaint();
      }
      
      // Back coordinates
      if ( x > 803 && x < 803 + 117 && y > 805 && y < 805 + 50)     
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
 
   /*** mouseReleased **********************************************************
    * Purpose: Checks the coordinates where the mouse was released and will    *
    *          go to appropiate screen depending on button clicked/released    *                                                                          
    * Parameters: MouseEvent e - tracks x and y coordinates of mouse           *                                   
    * Returns: none                                                            *
    ***************************************************************************/
   public void mouseReleased(MouseEvent e) 
   {
      x = e.getX();
      y = e.getY();
      
      // CUSTOM MAP ONE button coordinate area
      boolean clickedTM1 =
         x > 215 
         && x < 215 + 350
         && y > 710
         && y < 710 + 55; 
      
      if (clickedTM1) 
      {        
         vis = false;
         new CustomMapOneCTF(4,0,0, 1000,1000,1, playupto);
         isVis();                
      } 
      
      // CUSTOM MAP TWO button coordinate area
      boolean clickedCM2 =
         x > 675
         && x < 675 + 370
         && y > 710
         && y < 710 + 55;
   
      if (clickedCM2) 
      {     
         vis = false;
         new CustomMapOneCTF(4,0,0, 1000,1000,2,playupto);
         isVis();        
      } 
      
      // Capture The Flag button coordinate area
      boolean clickedRandom =
         x > 235
         && x < 235 + 270
         && y > 805
         && y < 805 + 50; 
      
      if (clickedRandom) 
      {        
         vis = false;
         new CustomMapOneCTF(4,0,0, 1000,1000,0,playupto);
         isVis();                
      } 
         
      // Back button coordinate area
      boolean clickedBack =
         x > 803
         && x < 803 + 117
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