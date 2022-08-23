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
import java.util.concurrent.*;
import java.util.Timer;
import java.util.TimerTask;

public class Tank {
   
   int sizex;
   int sizey;
   double middlex;
   double middley;
   double middlex2;
   double middley2;
   int nextpoy = 0;
   int nextpox = 0;
   int nextposx = 0;
   int nextposy = 0;
   int posx, posy;
   int ix, iy;
   int width = 30, height = 50; 
   int bulletdiamter = width/3;
   int movmentx2;
   int turn = 0;
   int movmenty2;
   int numpoints = 0;
   int widthx = 1000;
   int heighty = 1000; 
   int angle = 0; 
   int movmentx = 0;
   int movmenty = 0;
   int bulletx;
   int bullety;
   int mazex = 0;
   int mazey = 0;
   boolean invincible = false;
   boolean mini = false;
   int numberofbullets = -1;
   int [] nextmovey = new int [8];
   int [] nextmovex = new int [8];
   int [] aiy = new int [8];
   int [] aix = new int [8]; 
   int [] nextmoy = new int [8];
   int [] nextmox = new int [8];
   int [] ny = new int [8];
   int [] nx = new int [8];
   int [] throughwallx =  new int [4];
   int [] throughwally =  new int [4];
   Polygon throughwall = new Polygon (throughwallx, throughwally, 4);
   
   int [] collisionpointsx = new int [numpoints];
   int [] collisionpointsy = new int [numpoints];
   int [] bulletxy = new int [2];   
   Polygon collision = new Polygon(nextmovex,nextmovey,8);
   Polygon collisionwb = new Polygon(nextmovex,nextmovey,8);
   Polygon collisionwe = new Polygon(nextmovex,nextmovey,8);
   Color tankColor;
   boolean isVisible = false;
   boolean bulletsdone;
   boolean blocked;
   boolean aicode = false;
   int lastlocationx = 0;
   int lastlocationy = 0;
   String [] verticaorhorizontal;
   int speed = 10;
   
      
   /*** Tank ********************************************************
   * Purpose: sets variables used in code to the parameters inputed *
   * Parameters: x - sets the x coordinate of the tank              *
   *             y - sets the y coordinate of the tank              *
   *             tankolour - sets the colour of the tank            *   
   *             ang1 - sets the angle of the tank                  *
   * Returns: none                                                  *
   *****************************************************************/
   
   public Tank(int x, int y, Color tankolour, int angl){
      posx = x;
      posy = y;
      angle = angl;
      setVisible(true);
      movmentx += 15*Math.sin(Math.toRadians(angle));
      movmenty += 15*Math.cos(Math.toRadians(angle));
      bulletsdone = true;
      boolean what = tankcollision(angle, movmentx,-movmenty);
      tankColor = tankolour;
   }
   
/*** setVisible **********************************************************
   * Purpose: makes tank not visible on the screen by resetting coordinates *
   * Parameters: visible - boolean that states whether it is visible or not *  
   * Returns: none                                                          *
   *************************************************************************/

   public void setVisible (boolean visible)
   {
      isVisible = visible;
      if(!isVisible){
         lastlocationx = posx;
         lastlocationy = posy;
         posx = -10000;
         posy = -10000;
      
         tankcollision(0,0,0);
      }   
   }
   
/*** tankcollision *************************************************************
   * Purpose: to check if tank will collide with any walls or bullets             *
   * Parameters: mox - how much the tank will move on the x - axis                *
   *             moy - how much the tank will move on the y - axis                *
   *             ang - the angle that the tank is travelling with                 *   
   * Returns: blocked - if it collides it returns true otherwise it returns false *
   *******************************************************************************/
   boolean tankcollision (int ang, double mox, double moy){
      blocked = false;
      int ang1 = ang;
      int angw = ang;
      int moveex = 0;
      int moveey = 0;
      nextpoy = 0;
      nextpox = 0;
      nextposx = 0;
      nextposy = 0;
      int ang1x = ang1;
      int ang1y = -ang1;
      
      moveex =(int)mox;
      moveey =(int)moy;
      
      
      nextpox += (((posx+width/2)+((height/2)*Math.sin(Math.toRadians(ang1x)))) + moveex)-nextpox;   
      nextpoy += (((posy+height/2)-((height/2)*Math.cos(Math.toRadians(ang1y)))) + moveey)-nextpoy;
         
      nextposx += ((nextpox - ((width/6)*Math.cos(Math.toRadians(ang1x)))))-nextposx;
      nextposy += ((nextpoy + ((width/6)*Math.sin(Math.toRadians(ang1y)))))-nextposy;
      
      if(ang1 == 90)
         ang1 = 270;
      else if(ang1 > 0 && ang1 < 90){
         ang1 = 360 - ang1;
      }
      else if(ang1 >= 270 && ang1 < 360)
         ang1 = 360-ang1;
         
      else if(ang1 > 90 && ang1 < 180)
         ang1 = 270 - (ang1 - 90);
         
      else if(ang1 > 180 && ang1 < 270)
         ang1 = 90 + (270 - ang1);
      else if(ang1 == 270)
         ang1 = 90;
      
      nextmovex [0] += ((nextposx+((height/5)*Math.sin(Math.toRadians(ang1)))))-nextmovex[0];
      nextmovex [1] += (nextmovex[0]-(height/5*Math.sin(Math.toRadians(ang1))))-nextmovex[1];
      nextmovex [2] += (nextmovex[1]+(width/3*Math.cos(Math.toRadians(angw))))-nextmovex[2];
      nextmovex [3] += (nextmovex[0]+(width/3*Math.cos(Math.toRadians(angw))))-nextmovex[3];
      nextmovex [4] += (nextmovex[3]+(width/3*Math.cos(Math.toRadians(angw))))-nextmovex[4];
      nextmovex [5] += (nextmovex[4]+((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmovex[5];
      nextmovex [6] += (nextmovex[5] - ((width)*Math.cos(Math.toRadians(angw))))-nextmovex[6];
      nextmovex [7] += (nextmovex[6]-((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmovex[7];
      
      nextmovey [0] += ((nextposy+((height/5)*Math.cos(Math.toRadians(ang1)))))-nextmovey[0];
      nextmovey [1] += (nextmovey[0]-(height/5*Math.cos(Math.toRadians(ang1))))-nextmovey[1];
      nextmovey [2] += (nextmovey[1]+(width/3*Math.sin(Math.toRadians(angw))))-nextmovey[2];
      nextmovey [3] += (nextmovey[0]+(width/3*Math.sin(Math.toRadians(angw))))-nextmovey[3];
      nextmovey [4] += (nextmovey[3]+(width/3*Math.sin(Math.toRadians(angw))))-nextmovey[4];
      nextmovey [5] += (nextmovey[4]+((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmovey[5];
      nextmovey [6] += (nextmovey[5] - ((width)*Math.sin(Math.toRadians(angw))))-nextmovey[6];
      nextmovey [7] += (nextmovey[6]-((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmovey[7];
      
      nextpox += (((posx+width/2)+((height/2)*Math.sin(Math.toRadians(ang1x)))))-nextpox;   
      nextpoy += (((posy+height/2)-((height/2)*Math.cos(Math.toRadians(ang1y)))))-nextpoy;
         
      nextposx += ((nextpox - ((width/6)*Math.cos(Math.toRadians(ang1x)))))-nextposx;
      nextposy += ((nextpoy + ((width/6)*Math.sin(Math.toRadians(ang1y)))))-nextposy;
     
      
      nx [0] += ((nextposx+((height/5)*Math.sin(Math.toRadians(ang1)))))-nx[0];
      nx [1] += (nx[0]-(height/5*Math.sin(Math.toRadians(ang1))))-nx[1];
      nx [2] += (nx[1]+(width/3*Math.cos(Math.toRadians(angw))))-nx[2];
      nx [3] += (nx[0]+(width/3*Math.cos(Math.toRadians(angw))))-nx[3];
      nx [4] += (nx[3]+(width/3*Math.cos(Math.toRadians(angw))))-nx[4];
      nx [5] += (nx[4]+((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nx[5];
      nx [6] += (nx[5] - ((width)*Math.cos(Math.toRadians(angw))))-nx[6];
      nx [7] += (nx[6]-((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nx[7];
      
      ny [0] += ((nextposy+((height/5)*Math.cos(Math.toRadians(ang1)))))-ny[0];
      ny [1] += (ny[0]-(height/5*Math.cos(Math.toRadians(ang1))))-ny[1];
      ny [2] += (ny[1]+(width/3*Math.sin(Math.toRadians(angw))))-ny[2];
      ny [3] += (ny[0]+(width/3*Math.sin(Math.toRadians(angw))))-ny[3];
      ny [4] += (ny[3]+(width/3*Math.sin(Math.toRadians(angw))))-ny[4];
      ny [5] += (ny[4]+((2*height/3)*Math.cos(Math.toRadians(ang1)))) - ny[5];
      ny [6] += (ny[5] - ((width)*Math.sin(Math.toRadians(angw))))-ny[6];
      ny [7] += (ny[6]-((2*height/3)*Math.cos(Math.toRadians(ang1)))) - ny[7]; 
      
      int nminix = 0;
      int nminiy = 0;
      int nextx = 0;
      int nexty = 0;
      int [] minix = new int [8];
      int [] miniy = new int [8];
      
      nminix += (((posx+width/2)+((height/2)*Math.sin(Math.toRadians(ang1x)))))-nminix;   
      nminiy += (((posy+height/2)-((height/2)*Math.cos(Math.toRadians(ang1y)))))-nminiy;
         
      nextx += ((nminix - ((width/12)*Math.cos(Math.toRadians(ang1x)))))-nextx;
      nexty += ((nminiy + ((width/12)*Math.sin(Math.toRadians(ang1y)))))-nexty;
     
      
      minix [0] += ((nextx+((height/22)*Math.sin(Math.toRadians(ang1)))))-minix[0];
      minix [1] += (minix[0]-(height/22*Math.sin(Math.toRadians(ang1))))-minix[1];
      minix [2] += (minix[1]+(width/20*Math.cos(Math.toRadians(angw))))-minix[2];
      minix [3] += (minix[0]+(width/22*Math.cos(Math.toRadians(angw))))-minix[3];
      minix [4] += (minix[3]+(width/22*Math.cos(Math.toRadians(angw))))-minix[4];
      minix [5] += (minix[4]+((2*height/22)*Math.sin(Math.toRadians(ang1)))) - minix[5];
      minix [6] += (minix[5] - ((width)*Math.cos(Math.toRadians(angw))))-minix[6];
      minix [7] += (minix[6]-((2*height/22)*Math.sin(Math.toRadians(ang1)))) - minix[7];
      
      miniy [0] += ((nexty+((height/22)*Math.cos(Math.toRadians(ang1)))))-miniy[0];
      miniy [1] += (miniy[0]-(height/22*Math.cos(Math.toRadians(ang1))))-miniy[1];
      miniy [2] += (miniy[1]+(width/22*Math.sin(Math.toRadians(angw))))-miniy[2];
      miniy [3] += (miniy[0]+(width/22*Math.sin(Math.toRadians(angw))))-miniy[3];
      miniy [4] += (miniy[3]+(width/22*Math.sin(Math.toRadians(angw))))-miniy[4];
      miniy [5] += (miniy[4]+((2*height/22)*Math.cos(Math.toRadians(ang1)))) - miniy[5];
      miniy [6] += (miniy[5] - ((width)*Math.sin(Math.toRadians(angw))))-miniy[6];
      miniy [7] += (miniy[6]-((2*height/22)*Math.cos(Math.toRadians(ang1)))) - miniy[7];  
         
      moveex =(int)mox;
      moveey =(int)moy;
      
      throughwallx[0] = nextmovex[1] - moveex;
      throughwallx[1] = nextmovex[2]- moveex;
      throughwallx[3] += nextmovex[1]-((2*height/5)*Math.sin(Math.toRadians(ang1)))-throughwallx[3];
      throughwallx[2] += nextmovex[2]-((2*height/5)*Math.sin(Math.toRadians(ang1)))-throughwallx[2];
      
      throughwally[0] = nextmovey[1]- moveey;
      throughwally[1] = nextmovey[2]- moveey;
      throughwally[3] += nextmovey[1]-((2*height/5)*Math.cos(Math.toRadians(ang1)))-throughwally[3];
      throughwally[2] += nextmovey[2]-((2*height/5)*Math.cos(Math.toRadians(ang1)))-throughwally[2];
      
      
      throughwall = new Polygon (throughwallx, throughwally, 4);
      
      int nextpx = 0;
      int nextpy = 0;
      int nextpsx = 0;
      int nextpsy = 0;
      
      nextpx = posx + moveex;//(posx+width/2)+((height/2)-(50-(height/2)));//*Math.sin(Math.toRadians(ang1x)))) + moveex)-nextpx;   
      nextpy = posy - 10+ moveey;//*Math.cos(Math.toRadians(ang1y)))) + moveey)-nextpy;
         
      nextpsx = nextpx - 15;//*Math.cos(Math.toRadians(ang1x)))))-nextpsx;
      nextpsy = nextpy;// + ((width/2)-(50-(width/2)));//*Math.sin(Math.toRadians(ang1y)))))-nextpsy;
      
      
      aix [0] = nextpsx;
      aix [1] = (aix[0]);//(((height)+(2*height/3))*Math.sin(Math.toRadians(ang1))))-aix[1];
      aix [2] = (aix[1]+70);//(((width)+(2*width))*Math.cos(Math.toRadians(angw))))-aix[2];
      aix [3] = (aix[0]+70);//(((width)+(2*width))*Math.cos(Math.toRadians(angw))))-aix[3];
      aix [4] = nextpsx;
      aix [5] = (aix[0]);//(((height)+(2*height/3))*Math.sin(Math.toRadians(ang1))))-aix[5];
      aix [6] = (aix[1]+70);//(((width)+(2*width))*Math.cos(Math.toRadians(angw))))-aix[6];
      aix [7] = (aix[0]+70);//(((width)+(2*width))*Math.cos(Math.toRadians(angw))))-aix[7];
      
      aiy [0] = nextpsy;
      aiy [1] = (aiy[0]+70);//(((height)+(2*height/3))*Math.cos(Math.toRadians(ang1))))-aiy[1];
      aiy [2] = (aiy[1]);//(((width)+(2*width))*Math.sin(Math.toRadians(angw))))-aiy[2];
      aiy [3] = (aiy[0]);//(((width)+(2*width))*Math.sin(Math.toRadians(angw))))-aiy[3];
      aiy [4] = nextpsy;
      aiy [5] = (aiy[0]+70);//(((height)+(2*height/3))*Math.cos(Math.toRadians(ang1))))-aiy[5];
      aiy [6] = (aiy[1]);//(((width)+(2*width))*Math.sin(Math.toRadians(angw))))-aiy[6];
      aiy [7] = (aiy[0]);//(((width)+(2*width))*Math.sin(Math.toRadians(angw))))-aiy[7];
      
        
        
      if(!aicode){
         collision = new Polygon(nextmovex,nextmovey,8);
      }
      else if(aicode){
         collision = new Polygon(aix,aiy,4);
      }
      //to check collisio with bullet:
      int a = ang;
      int movex = 0;
      movex += -5*Math.sin(Math.toRadians(a)) - movex;
      int movey  = 0;
      movey += -5*Math.cos(Math.toRadians(a)) - movey;
      
      if(a == 0 || a == 180){
         ang1x = -ang1x;
         ang1y = -ang1y;
      }
      int nex = 0;
      int nx = 0;
      int ney =0;
      int ny = 0;
      ix = posx;
      iy = posy;
      if(invincible){
         ix = -100;
         iy = -100;
      }
      nex += (((ix+width/2)+((4*height/7)*Math.sin(Math.toRadians(ang1x)))))-nex;   
      ney += (((iy+height/2)-((4*height/7)*Math.cos(Math.toRadians(ang1y)))))-ney;
         
      nx += ((nex - ((width/6)*Math.cos(Math.toRadians(ang1x)))))-nx;
      ny += ((ney + ((width/6)*Math.sin(Math.toRadians(ang1y)))))-ny;
      
      nextmox [0] += ((nx+((height/5)*Math.sin(Math.toRadians(ang1))))) - nextmox[0];//- moveex + movex - nextmox[0];
      nextmox [1] += (nextmox[0]-(height/50*Math.sin(Math.toRadians(ang1))))-nextmox[1];
      nextmox [2] += (nextmox[1]+(width/3*Math.cos(Math.toRadians(angw))))-nextmox[2];
      nextmox [3] += (nextmox[0]+(width/3*Math.cos(Math.toRadians(angw))))-nextmox[3];
      nextmox [4] += (nextmox[3]+(width/3*Math.cos(Math.toRadians(angw))))-nextmox[4];
      nextmox [5] += (nextmox[4]+((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmox[5];
      nextmox [6] += (nextmox[5] - ((width)*Math.cos(Math.toRadians(angw))))-nextmox[6];
      nextmox [7] += (nextmox[6]-((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmox[7];
      
      nextmoy [0] += ((ny+((height/5)*Math.cos(Math.toRadians(ang1)))))- nextmoy[0];//moveey +movey -nextmoy[0];
      nextmoy [1] += (nextmoy[0]-(height/50*Math.cos(Math.toRadians(ang1))))-nextmoy[1];
      nextmoy [2] += (nextmoy[1]+(width/3*Math.sin(Math.toRadians(angw))))-nextmoy[2];
      nextmoy [3] += (nextmoy[0]+(width/3*Math.sin(Math.toRadians(angw))))-nextmoy[3];
      nextmoy [4] += (nextmoy[3]+(width/3*Math.sin(Math.toRadians(angw))))-nextmoy[4];
      nextmoy [5] += (nextmoy[4]+((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmoy[5];
      nextmoy [6] += (nextmoy[5] - ((width)*Math.sin(Math.toRadians(angw))))-nextmoy[6];
      nextmoy [7] += (nextmoy[6]-((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmoy[7];
       
      if(!mini)           
         collisionwb = new Polygon(nextmox,nextmoy,8);
      
      else if(mini){
         collisionwb = new Polygon(minix,miniy,8);
      }
      //collision with big bullet/triple bullet
      
      if(a == 0 || a == 180){
         ang1x = -ang1x;
         ang1y = -ang1y;
      }
      
      nex += (((posx+width/2)+((2*height/5)*Math.sin(Math.toRadians(ang1x)))) + movex)-nex;   
      ney += (((posy+height/2)-((2*height/5)*Math.cos(Math.toRadians(ang1y)))) + movey)-ney;
         
      nx += ((nex - ((width/6)*Math.cos(Math.toRadians(ang1x)))))-nx;
      ny += ((ney + ((width/6)*Math.sin(Math.toRadians(ang1y)))))-ny;
      
      nextmox [0] += ((nx+((height/5)*Math.sin(Math.toRadians(ang1))))) - nextmox[0];//- moveex + movex - nextmox[0];
      nextmox [1] += (nextmox[0]-(height/50*Math.sin(Math.toRadians(ang1))))-nextmox[1];
      nextmox [2] += (nextmox[1]+(width/3*Math.cos(Math.toRadians(angw))))-nextmox[2];
      nextmox [3] += (nextmox[0]+(width/3*Math.cos(Math.toRadians(angw))))-nextmox[3];
      nextmox [4] += (nextmox[3]+(width/3*Math.cos(Math.toRadians(angw))))-nextmox[4];
      nextmox [5] += (nextmox[4]+((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmox[5];
      nextmox [6] += (nextmox[5] - ((width)*Math.cos(Math.toRadians(angw))))-nextmox[6];
      nextmox [7] += (nextmox[6]-((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmox[7];
      
      nextmoy [0] += ((ny+((height/5)*Math.cos(Math.toRadians(ang1)))))- nextmoy[0];//moveey +movey -nextmoy[0];
      nextmoy [1] += (nextmoy[0]-(height/50*Math.cos(Math.toRadians(ang1))))-nextmoy[1];
      nextmoy [2] += (nextmoy[1]+(width/3*Math.sin(Math.toRadians(angw))))-nextmoy[2];
      nextmoy [3] += (nextmoy[0]+(width/3*Math.sin(Math.toRadians(angw))))-nextmoy[3];
      nextmoy [4] += (nextmoy[3]+(width/3*Math.sin(Math.toRadians(angw))))-nextmoy[4];
      nextmoy [5] += (nextmoy[4]+((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmoy[5];
      nextmoy [6] += (nextmoy[5] - ((width)*Math.sin(Math.toRadians(angw))))-nextmoy[6];
      nextmoy [7] += (nextmoy[6]-((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmoy[7];
                  
      collisionwe = new Polygon(nextmox,nextmoy,8);
      
      for(int y = 0; y < numpoints; y++){
         if (collision.contains(collisionpointsx[y], collisionpointsy[y])){
            blocked = true;
            nextpox += (((posx+width/2)+((height/2)*Math.sin(Math.toRadians(ang1x)))) - moveex)-nextpox;   
            nextpoy += (((posy+height/2)-((height/2)*Math.cos(Math.toRadians(ang1y)))) - moveey)-nextpoy;
         
            nextposx += ((nextpox - ((width/6)*Math.cos(Math.toRadians(ang1x)))))-nextposx;
            nextposy += ((nextpoy + ((width/6)*Math.sin(Math.toRadians(ang1y)))))-nextposy;
         
         
            nextmovex [0] += ((nextposx+((height/5)*Math.sin(Math.toRadians(ang1)))))-nextmovex[0];
            nextmovex [1] += (nextmovex[0]-(height/5*Math.sin(Math.toRadians(ang1))))-nextmovex[1];
            nextmovex [2] += (nextmovex[1]+(width/3*Math.cos(Math.toRadians(angw))))-nextmovex[2];
            nextmovex [3] += (nextmovex[0]+(width/3*Math.cos(Math.toRadians(angw))))-nextmovex[3];
            nextmovex [4] += (nextmovex[3]+(width/3*Math.cos(Math.toRadians(angw))))-nextmovex[4];
            nextmovex [5] += (nextmovex[4]+((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmovex[5];
            nextmovex [6] += (nextmovex[5] - ((width)*Math.cos(Math.toRadians(angw))))-nextmovex[6];
            nextmovex [7] += (nextmovex[6]-((2*height/3)*Math.sin(Math.toRadians(ang1)))) - nextmovex[7];
         
            nextmovey [0] += ((nextposy+((height/5)*Math.cos(Math.toRadians(ang1)))))-nextmovey[0];
            nextmovey [1] += (nextmovey[0]-(height/5*Math.cos(Math.toRadians(ang1))))-nextmovey[1];
            nextmovey [2] += (nextmovey[1]+(width/3*Math.sin(Math.toRadians(angw))))-nextmovey[2];
            nextmovey [3] += (nextmovey[0]+(width/3*Math.sin(Math.toRadians(angw))))-nextmovey[3];
            nextmovey [4] += (nextmovey[3]+(width/3*Math.sin(Math.toRadians(angw))))-nextmovey[4];
            nextmovey [5] += (nextmovey[4]+((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmovey[5];
            nextmovey [6] += (nextmovey[5] - ((width)*Math.sin(Math.toRadians(angw))))-nextmovey[6];
            nextmovey [7] += (nextmovey[6]-((2*height/3)*Math.cos(Math.toRadians(ang1)))) - nextmovey[7];
            collision = new Polygon(nextmovex,nextmovey,8);
         }
      }
      return blocked;
   }
/*** up **********************************************************************
   * Purpose: moves tank forward at a set speed, making sure no collision occurs*
   * Parameters: none                                                           * 
   * Returns: none                                                              *
   *****************************************************************************/
   public void up () {
      if(isVisible){
         movmentx += speed*Math.sin(Math.toRadians(angle))-movmentx;
         movmenty += speed*Math.cos(Math.toRadians(angle))-movmenty;
         if(!aicode){
            if(!tankcollision(angle, movmentx,-movmenty)){
               posy = posy - movmenty;
               posx = posx + movmentx;
            }
            posy = posy;
            posx = posx;
         }
         else if (aicode){
            if(!tankcollision(angle, movmentx,-movmenty)){
               posy = posy - movmenty;
               posx = posx + movmentx;
            }
            else{
               turn++;
               if(turn % 5 ==0){
                  down();
                  down();
                  down();
                  down();
                  lrotate();
                  lrotate();
                  lrotate();
                  lrotate();
               }
               else 
                  rrotate();
            }
         
         }
      }
   }
   
/*** down ************************************************************************
   * Purpose: moves tank backforward at a set speed, making sure no collision occurs*
   * Parameters: none                                                               * 
   * Returns: none                                                                  *
   *********************************************************************************/
   public void down () { 
      if(isVisible){
         int sped= speed;
         if(aicode)
            sped = speed/2;
         movmentx += sped*Math.sin(Math.toRadians(angle)) - movmentx;
         movmenty += sped*Math.cos(Math.toRadians(angle)) - movmenty;
      
         if(!tankcollision(angle, -movmentx,movmenty)){
            posy = posy + movmenty;
            posx = posx - movmentx;
         }
         posy = posy;
         posx = posx;
      
      }
   }
/*** rrotate *********************************************************************
   * Purpose: rotates tank 90 degrees to the right, making sure no collision occurs *
   * Parameters: none                                                               * 
   * Returns: none                                                                  *
   *********************************************************************************/
   public void rrotate () {
      if(isVisible){
         int angletest = angle;
         if(angle + 30 < 360)
            angletest += 30;
         else
            angletest = 0;
         
         if(!tankcollision(angletest, 0,0))
            angle =angletest;
      }  
   }
/*** lrotate *********************************************************************
   * Purpose: rotates tank 90 degrees to the left, making sure no collision occurs  *
   * Parameters: none                                                               * 
   * Returns: none                                                                  *
   *********************************************************************************/
   public void lrotate () {
      if(isVisible){
         int angletest = angle;
      
         if(angletest - 30 < 0)
            angletest = 360 - 30;
         else 
            angletest -= 30;
         if(!tankcollision(angletest, 0,0))
            angle =angletest;
      }
   }  
   /*** gainpower ************************************************************************
   * Purpose: checks to see if tank collides with powerup and return boolean accordingly *
   * Parameters: tx - a powerup object that has corrdinates of the powerup               * 
   * Returns: collide - boolean that indicates whether or not tank collides with powerup *
   **************************************************************************************/
   public boolean gainpower (PowerUps tx){
      PowerUps test = tx;
      boolean collide = false;
      for(int h = 0; h < 8; h++)
         if(collision.contains(test.pointsx[h],test.pointsy[h])){
            collide = true;
         }
      if(collide){
         test.x = -1000;
         test.y = -1000;
         test.setcollisionpoints(test.x, test.y);
         test.visible = false;
      }
      return collide;
   
   }
}