/*********************************************************
*  Name: Youssef Elhadad, Ethan Ing, Piotr Pralat        *
*  Course: ICS 4M  Pd. 8                                 *
*  Assignment summative                                  *
*  Purpose: Tank madness Game                            *
*  Due Date: May 23, 2019                                *
*********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
import java.lang.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;

public class PowerUps
{
   int x = 0;
   int y = 0;
   int sizeX = 0;
   int sizeY = 0;
   int color = 0;
   int mazex;
   int mazey;
   int gamemode; 
   int wp = 30;
   int hp = 30;
   boolean visible = true;
   int []pointsx  = new int [35];
   int [] pointsy = new int [35];
   Polygon pubox;
   Random rand = new Random();
   ImageIcon powerupicon;
   int choice;
   Tank temp;
  
   /*** PowerUps **********************************************************************
   * Purpose: sets dimensions of maze and gamemode, and chooses powerup accordingly   *
   * Parameters: x - contains x block dimensions of maze                              *
   *             y - contains y block dimensions of maze                              *
   *             mazex - stores x - coordinate of top left corner of maze             *   
   *             mazey - stores y - coordinate of top left corner of maze             * 
   *             gamemode - stores the chosen gamemode to play                        *    
   * Returns: none                                                                    *
   ***********************************************************************************/
   public PowerUps(int x, int y, int mazex, int mazey, int gamemode)
   {
      this.gamemode = gamemode;
      this.mazex = mazex;
      this.mazey = mazey;
      this.sizeX = x-1;
      this.sizeY = y-1;
      
      if (gamemode == 1)
      {
         choice = (rand.nextInt(4)) + 1;
         //choice = 4;
         if (choice == 1)
            drawingLMG();
         if (choice == 2)
            drawingTripleShot();
         if (choice == 3)
            drawingExplosiveShot();
         if (choice == 4)
            drawingLaserShot();
         if (choice == 5)
            drawingOverdrive();
         if (choice == 6)
            drawingMiniTank();
      }
      if (gamemode == 2)
      {
         choice = 7;
         drawingMoney();
      }      
   }
/*** Tank Money ********************************************************************
   * Purpose: executes Tank Money powerup                                             *
   * Parameters: tx - the tank for which the powerup is for                           *   
   * Returns: temp - the tank after powerup is executed                               *
   ***********************************************************************************/
   public Tank Money (Tank tx)
   {
      Tank temp = tx;
      return temp;
   }
/*** Tank LMG **********************************************************************
   * Purpose: executes Tank LMG powerup                                               *
   * Parameters: tx - the tank for which the powerup is for                           *   
   * Returns: temp - the tank after powerup is executed                               *
   ***********************************************************************************/
   public Tank LMG (Tank tx){
      Tank temp = tx;
      return temp;
   }
/*** Tank TripleShot ***************************************************************
   * Purpose: executes Tank Triple Shot powerup                                       *
   * Parameters: tx - the tank for which the powerup is for                           *   
   * Returns: temp - the tank after powerup is executed                               *
   ***********************************************************************************/

   public Tank TripleShot (Tank tx){
      Tank temp = tx;
      return temp;
   }
/*** Tank ExplosiveShot ************************************************************
   * Purpose: executes Tank Explosive Shot powerup                                    *
   * Parameters: tx - the tank for which the powerup is for                           *   
   * Returns: temp - the tank after powerup is executed                               *
   ***********************************************************************************/
   public Tank ExplosiveShot (Tank tx){
      Tank temp = tx;
      return temp;
   }
/*** Tank LaserShot ************************************************************
   * Purpose: executes Tank Laser Shot powerup                                    *
   * Parameters: tx - the tank for which the powerup is for                       *   
   * Returns: temp - the tank after powerup is executed                           *
   *******************************************************************************/
   public Tank LaserShot(Tank tx){
      Tank temp = tx;
      return temp;
   }
/*** Tank Overdrive ************************************************************
   * Purpose: executes Tank Overdrive powerup                                     *
   * Parameters: tx - the tank for which the powerup is for                       *   
   * Returns: temp - the tank after powerup is executed                           *
   *******************************************************************************/
   public Tank Overdrive(Tank tx){
      Tank temp = tx;
      temp.speed = 20;
      temp.width = 30;
      temp.height = 50;
      return temp;
   }
/*** Tank HackingSystem ********************************************************
   * Purpose: executes Tank Hacking System powerup                                *
   * Parameters: tx - the tank for which the powerup is for                       *   
   * Returns: temp - the tank after powerup is executed                           *
   *******************************************************************************/
   public Tank HackingSystem(Tank tx){
      Tank temp = tx;
      return temp;
   }
/*** Tank TeamLink *************************************************************
   * Purpose: executes Tank Team Link powerup                                     *
   * Parameters: tx - the tank for which the powerup is for                       *   
   * Returns: temp - the tank after powerup is executed                           *
   *******************************************************************************/
   public Tank TeamLink(Tank tx, Tank tx2){
      Tank temp = tx;
      Tank teammate = tx2;
      temp.posx = teammate.posx;
      temp.posy = teammate.posy;
   
      return temp;
   }
/*** Tank MiniTank ************************************************************
   * Purpose: executes Tank Mini Tank powerup                                     *
   * Parameters: tx - the tank for which the powerup is for                       *   
   * Returns: temp - the tank after powerup is executed                           *
   *******************************************************************************/
   public Tank MiniTank(Tank tx){
      Tank temp =tx;
      temp.speed = 10;
      temp.width = 30/3;
      temp.height = 50/3;
      temp.mini = true;
      return temp;
   }
/*** drawingLMG *****************************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingLMG()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("LMG.jpg");
      setcollisionpoints(x, y);
   }
/*** drawingTripleShot **********************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingTripleShot()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("3.jpg");
      setcollisionpoints(x, y);
   }
/*** drawingExplosiveShot *******************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingExplosiveShot()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("Explosive.jpg");
      setcollisionpoints(x, y);
   }
/*** drawingLaserShot ***********************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingLaserShot()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("laser.jpg");
      setcollisionpoints(x, y);
   }
/*** drawingOverdrive ***********************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingOverdrive()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("overdrive.jpg");
      setcollisionpoints(x, y);
   }
/*** drawingHackingSystem *******************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingHackingSystem()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("hacked.jpg");
      setcollisionpoints(x, y);
   }
/*** drawingTeamLink ************************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingTeamLink()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("team.jpg");
      setcollisionpoints(x, y);
   }
/******** drawingMiniTank *******************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingMiniTank()
   {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-1)) + 1) * 100;
      powerupicon = new ImageIcon("MIni.jpg");
      setcollisionpoints(x, y);
   }
/*** drawingMoney ***************************************************************
   * Purpose: sets coordinates and image icon of powerup                           *
   * Parameters: none                                                              *   
   * Returns: none                                                                 *
   ********************************************************************************/
   public void drawingMoney() {
      x = mazex + ((rand.nextInt(sizeX-1)) + 1) * 100;
      y = mazey + ((rand.nextInt(sizeY-2)) + 1) * 100;
      powerupicon = new ImageIcon("money.jpg");
      setcollisionpoints(x, y);
   }
/*** setcollisionpoints *********************************************************
   * Purpose: sets collision points for powerups in order for tanks to collide with*
   * Parameters: x - x - coordinate of top left corner of block that powerup is in * 
   *             y - y - coordinate of top left corner of block that powerup is in *   
   * Returns: none                                                                 *
   ********************************************************************************/     
   public void setcollisionpoints(int x, int b){
      int g = x+((100 - wp)/2);
      int k = b+((100 - hp)/2);;
      int start = 0;
      pointsx[0] = g;
      pointsx[1] = pointsx[0]+wp/5;
      pointsx[2] = pointsx[1]+wp/5;
      pointsx[3] = pointsx[2]+wp/5;
      pointsx[4] = pointsx[3]+wp/5;
      pointsx[5] = pointsx[0];
      pointsx[6] = pointsx[1];
      pointsx[7] = pointsx[2];
      pointsx[8] = pointsx[3];
      pointsx[9] = pointsx[4];
      pointsx[10] = pointsx[0];
      pointsx[11] = pointsx[1];
      pointsx[12] = pointsx[2];
      pointsx[13] = pointsx[3];
      pointsx[14] = pointsx[4];
      pointsx[15] = pointsx[0];
      pointsx[16] = pointsx[1];
      pointsx[17] = pointsx[2];
      pointsx[18] = pointsx[3];
      pointsx[19] = pointsx[4];
      pointsx[20] = pointsx[0];
      pointsx[21] = pointsx[1];
      pointsx[22] = pointsx[2];
      pointsx[23] = pointsx[3];
      pointsx[24] = pointsx[4];
     
      
      pointsy[0] = k;
      pointsy[1] = pointsy[0];
      pointsy[2] = pointsy[1];
      pointsy[3] = pointsy[2];
      pointsy[4] = pointsy[3];
      pointsy[5] = pointsy[0]+hp/5;
      pointsy[6] = pointsy[5];
      pointsy[7] = pointsy[5];
      pointsy[8] = pointsy[5];
      pointsy[9] = pointsy[5];
      pointsy[10] = pointsy[5]+hp/5;
      pointsy[11] = pointsy[10];
      pointsy[12] = pointsy[10];
      pointsy[13] = pointsy[10];
      pointsy[14] = pointsy[10];
      pointsy[15] = pointsy[10]+hp/5;
      pointsy[16] = pointsy[15];
      pointsy[17] = pointsy[15];
      pointsy[18] = pointsy[15];
      pointsy[19] = pointsy[15];
      pointsy[20] = pointsy[15]+hp/5;
      pointsy[21] = pointsy[20];
      pointsy[22] = pointsy[20];
      pointsy[23] = pointsy[20];
      pointsy[24] = pointsy[20];
    
   
   }
  
   
}