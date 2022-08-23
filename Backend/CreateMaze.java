
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

public class CreateMaze extends JFrame implements KeyListener{  
   
   int [] reset = {0,0};
  
   // Laser clicked booleans for laser firing stages
   boolean laserClickedt1 = false;
   boolean laserClickedt2 = false;
   boolean laserClickedt3 = false;
   boolean laserClickedt4 = false;
  
   // First, second, and third second of laser firing
   boolean firstsecondt1 = true;
   boolean secondsecondt1 = false;
   boolean thirdsecondt1 = false; 
   boolean firstsecondt2 = true;
   boolean secondsecondt2 = false;
   boolean thirdsecondt2 = false;
   boolean firstsecondt3 = true;
   boolean secondsecondt3 = false;
   boolean thirdsecondt3 = false;
   boolean firstsecondt4 = true;
   boolean secondsecondt4 = false;
   boolean thirdsecondt4 = false;
   boolean aicod = false;
   int cellx;
   int celly;
   int goalx = 0;
   int goaly = 0;
   boolean ableToShoot = false;
   int turning = 0;
   boolean aishoot = false;
   boolean t1leftclick = false;
   boolean t1rightclick = false;
   boolean t1upclick = false;
   boolean t1downclick = false;
   boolean t1bullet = false;
   boolean t2leftclick = false;
   boolean t2rightclick = false;
   boolean t2upclick = false;
   boolean t2downclick = false;
   boolean t3leftclick = false;
   boolean t3rightclick = false;
   boolean t3upclick = false;
   boolean t3downclick = false;
   boolean t4leftclick = false;
   boolean t4rightclick = false;
   boolean t4upclick = false;
   boolean t4downclick = false;
   boolean t1powerup = true;
   boolean t2powerup = true;
   boolean t3powerup = true;
   boolean t4powerup = true;
   boolean gamedone = false;
  
   int playupto;
   boolean moveback = false;
   boolean machinegunfiret1 = false;
   BulletTester [] machinegunt1 = new BulletTester [100000];
   int machinegunbulletst1 = 0;
   Polygon aifire = new Polygon (reset,reset,2);
   boolean explosiveshott1 = false;
   boolean explosiont1 = false;
   BulletTester explosionshott1;
  
   boolean lazerfiret1 = false;
   Polygon lazert1 = new Polygon (reset, reset, 2);
 
   boolean tripleshott1 = false;
   BulletTester [] triplet1 = new BulletTester [100000];
   int numberoftriplebulletst1 = 0;
  
   boolean normalfiret1 = true;
  
   boolean machinegunfiret2 = false;
   BulletTester [] machinegunt2 = new BulletTester [100000];
   int machinegunbulletst2 = 0;
  
   boolean explosiveshott2 = false;
   boolean explosiont2 = false;
   BulletTester explosionshott2;
  
   boolean lazerfiret2 = false;
   Polygon lazert2 = new Polygon (reset, reset, 2);
 
   boolean tripleshott2 = false;
   BulletTester [] triplet2 = new BulletTester [1000];
   int numberoftriplebulletst2 = 0;
  
   boolean normalfiret2 = true;

   boolean machinegunfiret3 = false;
   BulletTester [] machinegunt3 = new BulletTester [100000];
   int machinegunbulletst3 = 0;
  
   boolean explosiveshott3 = false;
   boolean explosiont3 = false;
   BulletTester explosionshott3;
  
   boolean lazerfiret3 = false;
   Polygon lazert3 = new Polygon (reset, reset, 2);
 
   boolean tripleshott3 = false;
   BulletTester [] triplet3 = new BulletTester [10000];
   int numberoftriplebulletst3 = 0;
  
   boolean normalfiret3 = true;
  
   boolean machinegunfiret4 = false;
   BulletTester [] machinegunt4 = new BulletTester [100000];
   int machinegunbulletst4 = 0;
  
   boolean explosiveshott4 = false;
   boolean explosiont4 = false;
   BulletTester explosionshott4;
  
   boolean lazerfiret4 = false;
   Polygon lazert4 = new Polygon (reset, reset, 2);
 
   boolean tripleshott4 = false;
   BulletTester [] triplet4 = new BulletTester [10000];
   int numberoftriplebulletst4 = 0;
  
   boolean normalfiret4 = true;

   boolean aicode = false;
   boolean t1death = false;
   boolean t2death = false;
   boolean t3death = false;
   boolean t4death = false;
   Keys check = new Keys();
     
   int widthx = 1275;
   int heighty = 1500;
   int mazex = 100;
   int mazey = 50;
   int sizeX;
   int sizeY;
   int teamonepoints = 0;
   int teamtwopoints = 0;
   int reloadbulletst1 = 5;
   int bulletexplosionxt1 = -1000;
   int bulletexplosionyt1 = -1000;
   int bulletexplosionxt2 = -1000;
   int bulletexplosionyt2 = -1000;
   int bulletexplosionxt3 = -1000;
   int bulletexplosionyt3 = -1000;
   int bulletexplosionxt4 = -1000;
   int bulletexplosionyt4 = -1000;
  
   Random rand = new Random();

      
   int choice, x, y;
   int num = 0;
   int []bulletxy = new int [8];
     
   int [][] region = new int [sizeX][sizeY];
   int [][] north = new int[sizeX][sizeY];
   int [][] south = new int[sizeX][sizeY];
   int [][] east = new int[sizeX][sizeY];
   int [][] west = new int[sizeX][sizeY];
   int [][][][] direction = new int [20][20][20][20]; // [sizeX][sizeY][sizeX][sizeY];
   int [][][][] distance = new int [20][20][20][20]; // [sizeX][sizeY][sizeX][sizeY];
  
   String [] verticaorhorizontal;
  
   int [] collisionpointsx;
   int [] collisionpointsy;
   Polygon explosion = new Polygon(reset,reset,2);
   Polygon explosion2 = new Polygon(reset,reset,2);
   Polygon explosion3 = new Polygon(reset,reset,2);
   Polygon explosion4 = new Polygon(reset,reset,2);
  
   int numpoints = 0;
   int totalnumberofbullets =0;
   int numberoftanks = 0;
   JFrame frame = new JFrame("Video Game");
  
   boolean vis = true;
  
  
   Color purple = new Color(102,0,153);
   Tank t1;
   Tank t2;
   Tank t3;
   Tank t4;
  
   BulletTester [] t1b = new BulletTester [10000];
   BulletTester [] t2b = new BulletTester [10000];
   BulletTester [] t3b = new BulletTester [10000];
   BulletTester [] t4b = new BulletTester [10000]; 
   int numberofbulletst1 = 0;
   int numberofbulletst2 = 0;
   int numberofbulletst3 = 0;
   int numberofbulletst4 = 0;
  
   public Drawing draw = new Drawing ();
  
   ImageIcon tankdead = new ImageIcon("Tankcollide.png");
   ImageIcon bulletexplosion = new ImageIcon("explosiveshot.png");
   boolean mazedone = false;
   boolean death = false;
   ImageIcon tank, redTank, blueTank, purpleTank, yellowTank, blueTank2, shot,team, hacked,explosive,laser,lmg,mini,overdrive;
  
  
   boolean once = false;

       /*** CreateMaze ************************************************************
    * Purpose: Gets variables set up and sets up images and frame              *                                                                         
    * Parameters: tanks - number of tanks  team1 - team one points stored      *
    * team1 - team two points stored                                           *
    * team2 - team two points stored                                           *
    * playupto - stores how much game goes up to                               *
    * Returns: none                                                            *
    ***************************************************************************/

   public CreateMaze(int tanks, int team1, int team2, int playupto) {
   
      this.playupto = playupto;
      numberoftanks = tanks;
      teamonepoints = team1;
      teamtwopoints = team2;
      PU f = new PU();
      f.start();
      check.start();
      direction = new int [20][20][20][20]; // [sizeX][sizeY][sizeX][sizeY];
      distance = new int [20][20][20][20]; // [sizeX][sizeY][sizeX][sizeY];
   
      // Tank pictures
      redTank = new ImageIcon("RedTank.jpg");
      blueTank = new ImageIcon("BlueTank1v1.jpg");
      purpleTank = new ImageIcon("PurpleTank.jpg");
      yellowTank = new ImageIcon("YellowTank.jpg");
      blueTank2 = new ImageIcon("BlueTank2v2.jpg");
      shot = new ImageIcon("3.jpg");
      team = new ImageIcon("Team.jpg");
      hacked = new ImageIcon("hacked.jpg");
      explosive = new ImageIcon("Explosive.jpg");
      laser = new ImageIcon("laser.jpg");
      lmg = new ImageIcon("LMG.jpg");
      mini = new ImageIcon("MIni.jpg");
      overdrive = new ImageIcon("overdrive.jpg");
     
      frame.getContentPane().setBackground(Color.white);
      seteverything();
     
   }
       /*** isVis *****************************************************************
    * Purpose: makes frame invisible (not visible)                             *                                                                       
    * Parameters: none                                                         *                                 
    * Returns: none                                                            *
    ***************************************************************************/
   public void isVis()
   {
      if (!vis)
         frame.dispose();
   }
      /*** seteverything *********************************************************
   * Purpose: sets up frame, images, and tank information                     *                                                                         
   * Parameters: none                                                         * 
   * Returns: none                                                            *
   ***************************************************************************/
   public void seteverything (){
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(widthx,heighty);
      frame.setLayout(new BorderLayout());
      frame.addKeyListener(this);
      sizeX = (rand.nextInt(3)) + 10;
      sizeY = (rand.nextInt(2)) + 4;
      //sizeX = 3;
      //sizeY = 3;
      int center = ((widthx)-(sizeX*100))/2;
      mazex = center;
      bulletexplosionxt1 = -1000;
      bulletexplosionyt1 = -1000;
      bulletexplosionxt2 = -1000;
      bulletexplosionyt2 = -1000;
      bulletexplosionxt3 = -1000;
      bulletexplosionyt3 = -1000;
      bulletexplosionxt4 = -1000;
      bulletexplosionyt4 = -1000;
     
     
      int spawn1X = mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35;
      int spawn1Y = mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35;
      int spawn2X = mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35;
      int spawn2Y = mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35;
     
      while (spawn1X == spawn2X && spawn1Y == spawn2Y)
      {
         spawn1X = mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35;
         spawn1Y = mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35;
         spawn2X = mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35;
         spawn2Y = mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35;
      }
     
      if(numberoftanks == 1){
         aicode = true;
         aicod = true;
         t1 = new Tank(spawn1X,spawn1Y, Color.red,(rand.nextInt(12) + 1) * 30);
         t2 = new Tank(spawn2X,spawn2Y, Color.blue, 0);
         t3 = new Tank(mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35,mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35, Color.yellow,(rand.nextInt(12) + 1) * 30);
         t4 = new Tank(mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35,mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35, purple,(rand.nextInt(12) + 1) * 30); 
         //t2 = new Tank(t1.posx +200,t1.posy, Color.blue, 0);
      }
      if (!aicode)
      {
         t1 = new Tank(mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35,mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35, Color.red,(rand.nextInt(12) + 1) * 30);
         t2 = new Tank(mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35,mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35, Color.blue,(rand.nextInt(12) + 1) * 30);
         t3 = new Tank(mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35,mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35, Color.yellow,(rand.nextInt(12) + 1) * 30);
         t4 = new Tank(mazex + (rand.nextInt(sizeX-1) + 1) * 100 + 35,mazey + (rand.nextInt(sizeY-1) + 1) * 100 + 35, purple,(rand.nextInt(12) + 1) * 30); 
      }
     
      t1.setVisible(true);
      t2.setVisible(true);
      t1powerup = true;
      t2powerup = true;
      t3powerup = true;
      t4powerup = true;
      explosionshott1 = new BulletTester (0,0,30,0);
      machinegunfiret1 = false;
      explosiveshott1 = false;
      explosiont1 = false;
      explosionshott2 = new BulletTester (0,0,30,0);
      explosionshott3 = new BulletTester (0,0,30,0);
      explosionshott4 = new BulletTester (0,0,30,0);
      t1death = false;
      t2death = false;
      t3death = false;
      t4death = false;
      if(numberoftanks == 3){
         t3.setVisible(true);
         t4.setVisible(false);
      }
      else if(numberoftanks >= 4){
         t3.setVisible(true);
         t4.setVisible(true);
      }
      else {
         t3.setVisible(false);
         t4.setVisible(false);
      }
      t1leftclick = false; t1rightclick = false; t1upclick = false;t1downclick = false;t1bullet = false;
      t2leftclick = false;t2rightclick = false;t2upclick = false;t2downclick = false;
      t3leftclick = false;t3rightclick = false;t3upclick = false;t3downclick = false;
      t4leftclick = false;t4rightclick = false;t4upclick = false;t4downclick = false;
      check = new Keys();
      rand = new Random();   
      num = 0;
      bulletxy = new int [8];
      region = new int [sizeX][sizeY];
      north = new int[sizeX][sizeY];
      south = new int[sizeX][sizeY];
      east = new int[sizeX][sizeY];
      west = new int[sizeX][sizeY];
      numpoints = 0;
      totalnumberofbullets =0;
      purple = new Color(102,0,153);
      t1b = new BulletTester [5];
      t2b = new BulletTester [5];
      t3b = new BulletTester [5];
      t4b = new BulletTester [5]; 
      numberofbulletst1 = 0;
      numberofbulletst2 = 0;
      numberofbulletst3 = 0;
      numberofbulletst4 = 0;
      draw = new Drawing ();
      tankdead = new ImageIcon("Tankcollide.png");
      mazedone = false;
      verticaorhorizontal = new String [1800];
      collisionpointsx = new int [1800];
      collisionpointsy = new int [1800];
      numpoints = 0;
      for(int y =0; y<1800; y++){
         verticaorhorizontal [y] = null;
         collisionpointsx [y] = 0;
         collisionpointsy [y] = 0;
      }
      if(gamedone){
         sizeX = 0;
         sizeY = 0;
         cellx = 0;
         celly = 0;
         goalx = 0;
         goaly = 0;
         region = new int [sizeX][sizeY];
         north = new int[sizeX][sizeY];
         south = new int[sizeX][sizeY];
         east = new int[sizeX][sizeY];
         west = new int[sizeX][sizeY];
      }
      frame.add(draw);
      frame.setVisible(true);
   
   }
  
      /*** generatemaze **********************************************************
   * Purpose: using arrays creates stores positons of walls (randomized)      *                                                                         
   * Parameters: none                                                         * 
   * Returns: none                                                            *
   ***************************************************************************/
   public void generatemaze () {
      try{
         if(!mazedone){
            for (int i = 0; i < sizeX; i++)
            {
               for (int j = 0; j < sizeY; j++)
               {
                  num++;
                  north[i][j] = 0;
                  south[i][j] = 0;
                  east[i][j] = 0;
                  west[i][j] = 0;
                  region[i][j] = num;
                  for (int k = 0; k < sizeX ; k++)
                  {
                     for (int l = 0; l < sizeY ; l++)
                     {
                        direction[i][j][k][l] = 0;
                        distance[i][j][k][l] = 0;
                     }
                  }
               }
            }
            int numRegion = sizeX*sizeY;
            if(!gamedone){
               while (numRegion != 1)
               {
                  choice = (rand.nextInt(4) + 1);
                  x = (rand.nextInt(sizeX));
                  y = (rand.nextInt(sizeY));
               
               
                  if (choice == 1 && y < sizeY - 1 && region[x][y] != region[x][y+1])
                  {
                     north[x][y] = 1;
                     south [x][y + 1] = 1;
                  
                     int oldRegion = region[x][y+1];
                     int newRegion = region[x][y];
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           for (int k = 0; k < sizeX; k++)
                           {
                              for (int l = 0 ; l < sizeY; l++)
                              {
                                 if ((region[i][j] == newRegion) && (region[k][l] == oldRegion))
                                 {
                                    direction[i][j][k][l] = direction[i][j][x][y];
                                    direction[k][l][i][j] = direction[k][l][x][y+1];
                                    distance[i][j][k][l] = distance[i][j][x][y] + 1 + distance[x][y+1][k][l];
                                    distance[k][l][i][j] = distance[i][j][k][l];
                                 
                                    direction[x][y][k][l] = 1;
                                    direction[x][y+1][i][j] = 2;
                                 }
                              }
                           }
                        }
                     }
                      
                  
                  
                  
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           if (region[i][j] == oldRegion)
                              region[i][j] = newRegion;
                        }
                     }
                     numRegion = numRegion - 1;
                  
                  
                  
                  }
               
                  if (choice == 2 && y > 0 && region[x][y] != region[x][y-1])
                  {
                     south[x][y] = 1;
                     north [x][y - 1] = 1;
                  
                     int oldRegion = region[x][y-1];
                     int newRegion = region[x][y];
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           for (int k = 0; k < sizeX; k++)
                           {
                              for (int l = 0 ; l < sizeY; l++)
                              {
                                 if ((region[i][j] == newRegion) && (region[k][l] == oldRegion))
                                 {
                                    direction[i][j][k][l] = direction[i][j][x][y];
                                    direction[k][l][i][j] = direction[k][l][x][y-1];
                                    distance[i][j][k][l] = distance[i][j][x][y] + 1 + distance[x][y-1][k][l];
                                    distance[k][l][i][j] = distance[i][j][k][l];
                                 
                                    direction[x][y][k][l] = 2;
                                    direction[x][y-1][i][j] = 1;
                                 }
                              }
                           }
                        }
                     }
                      
                  
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           if (region[i][j] == oldRegion)
                              region[i][j] = newRegion;
                        }
                     }
                     numRegion = numRegion - 1;
                  }
               
                  if (choice == 3 && x < sizeX - 1 && region[x][y] != region[x+1][y])
                  {
                     east [x][y] = 1;
                     west [x + 1][y] = 1;
                  
                     int oldRegion = region[x+1][y];
                     int newRegion = region[x][y];
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           for (int k = 0; k < sizeX; k++)
                           {
                              for (int l = 0 ; l < sizeY; l++)
                              {
                                 if ((region[i][j] == newRegion) && (region[k][l] == oldRegion))
                                 {
                                    direction[i][j][k][l] = direction[i][j][x][y];
                                    direction[k][l][i][j] = direction[k][l][x+1][y];
                                    distance[i][j][k][l] = distance[i][j][x][y] + 1 + distance[x+1][y][k][l];
                                    distance[k][l][i][j] = distance[i][j][k][l];
                                 
                                    direction[x][y][k][l] = 3;
                                    direction[x+1][y][i][j] = 4;
                                 }
                              }
                           }
                        }
                     }
                      
                  
                  
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           if (region[i][j] == oldRegion)
                              region[i][j] = newRegion;
                        }
                     }
                     numRegion = numRegion - 1;
                  }
               
                  if (choice == 4 && x > 0 && region[x][y] != region[x-1][y])
                  {
                     west [x][y] = 1;
                     east [x-1][y] = 1;
                  
                     int oldRegion = region[x-1][y];
                     int newRegion = region[x][y];
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           for (int k = 0; k < sizeX; k++)
                           {
                              for (int l = 0 ; l < sizeY; l++)
                              {
                                 if ((region[i][j] == newRegion) && (region[k][l] == oldRegion))
                                 {
                                    direction[i][j][k][l] = direction[i][j][x][y];
                                    direction[k][l][i][j] = direction[k][l][x-1][y];
                                    distance[i][j][k][l] = distance[i][j][x][y] + 1 + distance[x-1][y][k][l];
                                    distance[k][l][i][j] = distance[i][j][k][l];
                                 
                                    direction[x][y][k][l] = 4;
                                    direction[x-1][y][i][j] = 3;
                                 }
                              }
                           }
                        }
                     }
                      
                  
                  
                     for (int i = 0; i < sizeX; i++)
                     {
                        for (int j = 0; j < sizeY; j++)
                        {
                           if (region[i][j] == oldRegion)
                              region[i][j] = newRegion;
                        }
                     }
                     numRegion = numRegion - 1;
                  }
               }
            }
         }
      }
      //https://www.tutorialspoint.com/How-to-handle-Java-Array-Index-Out-of-Bounds-Exception
      catch (NullPointerException e) {
         
      }
      catch (ArrayIndexOutOfBoundsException e) {}
   }
   boolean deathdonet1 = false;
   boolean deathdonet2 = false;
   boolean deathdonet3 = false;
   boolean deathdonet4 = false;
  
   PowerUps [] pu = new PowerUps [5];
   int current = -1;
   int puX [] = {0,0,0,0,0};
   int puY [] = {0,0,0,0,0};
   int color [] = {0,0,0,0,0};
  
   boolean again = false;
  
   class PU extends Thread
   {  
      @Override
          /*** run *******************************************************************
      * Purpose: generates powerups and spawns them using timer and making sure  *
      *  that only five powerups are on at one time                              *                                                                           
      * Parameters: none                                                         *  
      * Returns: none                                                            *
      ***************************************************************************/
      public void run()
      {
         try
         {
            while(true)
            {
               if(current < 4)
               {
                  int powerTime = 5 + (int)(Math.random() * 15);
                  sleep(powerTime * 1000);
               
                  current++;
                  
                  pu[current] = new PowerUps(sizeX, sizeY, mazex, mazey,1);
                  puX[current] = pu[current].x;
                  puY[current] = pu[current].y;
               
               
                  for (int i = 0; i < current; i++)
                     if (pu[i].x == pu[current].x && pu[i].y == pu[current].y)
                        again = true;
                     
                  while (again)
                  {
                     pu[current] = new PowerUps(sizeX, sizeY, mazex, mazey,1);
                     puX[current] = pu[current].x;
                     puY[current] = pu[current].y;
                  
                     for (int i = 0; i < current; i++)
                        if (pu[i].x != pu[current].x)
                           if (pu[i].y != pu[current].y)
                              again = false;
                  }
               }
               
               draw.repaint();
            }
         }catch (InterruptedException e) {}
         //https://www.tutorialspoint.com/How-to-handle-Java-Array-Index-Out-of-Bounds-Exception
         catch (ArrayIndexOutOfBoundsException e) {}
      }
   }            
   class Drawing extends JComponent {
   
       /*** paint *****************************************************************
       * Purpose: Draws all images and text on screen                             *                                                                         
       * Parameters: Graphics g - GUI graphics for drawing                        *                                  
       * Returns: none                                                            *
       ***************************************************************************/
      public void paint (Graphics g) {
      
       // ITEMS
      
       // Score
         Font score = new Font("impact", Font.PLAIN, 30);
         g.setFont(score);
         g.setColor(new Color(70,70,70));
      
         if (numberoftanks > 2)
         {
            g.drawImage(redTank.getImage(),435,640,115,65,this);
            g.drawImage(blueTank.getImage(),735,640,115,65,this);
            g.drawImage(purpleTank.getImage(),435,715,115,65,this);
            g.drawImage(yellowTank.getImage(),735,715,115,65,this);
           
            g.drawString(Integer.toString(teamonepoints), 485,810); 
            g.drawString(Integer.toString(teamtwopoints), 783,810);
         }
         else if (numberoftanks <=2)
         {
            g.drawImage(redTank.getImage(),435,660,115,65,this);
            g.drawImage(blueTank.getImage(),735,660,115,65,this);
           
            g.drawString(Integer.toString(teamonepoints), 485,800); 
            g.drawString(Integer.toString(teamtwopoints), 783,800);
         
         }
      
         Font itemTitle = new Font("impact", Font.BOLD, 37);
        
         g.setFont(itemTitle);
         g.setColor(Color.black);
               
          
       
         g.setColor(Color.white);
         g.fillRect(100,100,(100*t1.sizex),(100*t1.sizey));
         g.setColor(Color.black);
           
         if(!mazedone){  
            verticaorhorizontal = new String [18000];
            collisionpointsx = new int [18000];
            collisionpointsy = new int [18000];
            numpoints = 0;
         }
         generatemaze();
         if(!gamedone){
            for (int i = 0; i < sizeX; i++){
               for (int j = 0; j < sizeY; j++){
                 
                 
                 
                  /*if (direction[i][j][0][0] == 1) {
                     g.drawLine(mazex + 50 + (100 * i), mazey+ 50 + (100 * j), mazex + 50 + (100 * i), mazey+100 + (100 * j));
                     g.drawLine(mazex + 40 + (100 * i), mazey+ 90 + (100 * j), mazex + 50 + (100 * i), mazey+100 + (100 * j));
                     g.drawLine(mazex + 60 + (100 * i), mazey+ 90 + (100 * j), mazex + 50 + (100 * i), mazey+100 + (100 * j));
                  }
                  if (direction[i][j][0][0] == 2) {
                     g.drawLine(mazex + 50 + (100 * i), mazey+ 50 + (100 * j), mazex + 50 + (100 * i), mazey+0 + (100 * j));
                     g.drawLine(mazex + 40 + (100 * i), mazey+ 10 + (100 * j), mazex + 50 + (100 * i), mazey+0 + (100 * j));
                     g.drawLine(mazex + 60 + (100 * i), mazey+ 10 + (100 * j), mazex + 50 + (100 * i), mazey+0 + (100 * j));                                          
                  }
                  if (direction[i][j][0][0] == 3) {
                     g.drawLine(mazex + 50 + (100 * i), mazey+ 50 + (100 * j), mazex + 100 + (100 * i), mazey+50 + (100 * j));
                     g.drawLine(mazex + 90 + (100 * i), mazey+ 60 + (100 * j), mazex + 100 + (100 * i), mazey+50 + (100 * j));
                     g.drawLine(mazex + 90 + (100 * i), mazey+ 40 + (100 * j), mazex + 100 + (100 * i), mazey+50 + (100 * j));                                          
                  } 
                  if (direction[i][j][0][0] == 4) {
                     g.drawLine(mazex + 50 + (100 * i), mazey+ 50 + (100 * j), mazex + 0 + (100 * i), mazey+50 + (100 * j));
                     g.drawLine(mazex + 10 + (100 * i), mazey+ 60 + (100 * j), mazex + 0 + (100 * i), mazey+50 + (100 * j));
                     g.drawLine(mazex + 10 + (100 * i), mazey+ 40 + (100 * j), mazex + 0 + (100 * i), mazey+50 + (100 * j));
                  }*/
                  if (north[i][j] == 0){
                     g.drawLine (mazex + (100 * i), mazey+100 + (100 * j), mazex+100 + (100 * i), mazey+100 + (100 * j));
                     if(!mazedone){
                        for(int l = numpoints; l<(numpoints+100); l++){
                           collisionpointsx[l] = (mazex + (100*i))+(l-numpoints);
                           collisionpointsy[l] = (mazey+100 + (100*j));
                           verticaorhorizontal [l] = "v";
                        }
                        numpoints+=100;
                     }
                  }
                  if (south[i][j] == 0){
                     g.drawLine (mazex + (100 * i), mazey + (100 * j), mazex+100 + (100 * i), mazey + (100 * j));
                     if(!mazedone){
                        for(int l = numpoints; l < (numpoints+100); l++){
                           collisionpointsx[l] = (mazex + (100*i)) + (l-numpoints);
                           collisionpointsy[l] = (mazey + (100*j));
                           verticaorhorizontal [l] = "v";
                        }
                        numpoints+=100;
                     }
                  }
                  if (west[i][j] == 0){
                     g.drawLine (mazex + (100 * i), mazey + (100 * j), mazex + (100 * i), mazey+100 + (100 * j));
                     if(!mazedone){
                        for(int l = numpoints; l<(numpoints+100); l++){
                           collisionpointsx[l] = (mazex + (100*i));
                           collisionpointsy[l] = (mazey + (100*j))+(l-numpoints);
                           verticaorhorizontal [l] = "h";
                        }
                        numpoints+=100;
                     }
                  }
                  if (east[i][j] == 0){
                     g.drawLine(mazex+100 + (100 * i), mazey + (100 * j), mazex+100 + (100 * i), mazey+100 + (100 * j));
                     if(!mazedone){
                        for(int l = numpoints; l<(numpoints+100); l++){
                           collisionpointsx[l] = (mazex+100 + (100*i));
                           collisionpointsy[l] = (mazey + (100*j))+(l-numpoints);
                           verticaorhorizontal [l] = "h";
                        }
                        numpoints+=100;
                     }
                  }
               }
            }
         }
         if(!mazedone){
            t1.collisionpointsx = collisionpointsx;
            t1.collisionpointsy = collisionpointsy;
            t1.verticaorhorizontal = verticaorhorizontal;
            t1.numpoints = numpoints;
            t2.collisionpointsx = collisionpointsx;
            t2.collisionpointsy = collisionpointsy;
            t2.verticaorhorizontal = verticaorhorizontal;
            t2.numpoints = numpoints;
            t3.collisionpointsx = collisionpointsx;
            t3.collisionpointsy = collisionpointsy;
            t3.verticaorhorizontal = verticaorhorizontal;
            t3.numpoints = numpoints;
            t4.collisionpointsx = collisionpointsx;
            t4.collisionpointsy = collisionpointsy;
            t4.verticaorhorizontal = verticaorhorizontal;
            t4.numpoints = numpoints;
         }
         
         if (mazedone){
            for (int i = 0; i < 5; i++)
            {
               if (puX[i] != 0 || puY[i] != 0)
               {
                  Graphics2D g2D = (Graphics2D)g.create();
                  g.drawImage(pu[i].powerupicon.getImage(),pu[i].x + ((100 - pu[i].wp)/2),pu[i].y + ((100 - pu[i].wp)/2),pu[i].wp,pu[i].hp,this);
               }
            }
         }
        
        
         if(!t1.isVisible && !deathdonet1){
            g.drawImage(tankdead.getImage(),t1.lastlocationx,t1.lastlocationy,50,50,this);
            // all timer codes are from this website: https://www.geeksforgeeks.org/java-util-timer-class-java/
            Timer laserThirdt2 =  new Timer();
            TimerTask laser3t2 =
                              new TimerTask() {
                                 public void run (){
                                    deathdonet1 = true;
                                    cancel();
                                 }
                              };
            laserThirdt2.scheduleAtFixedRate(laser3t2,1500,1500);
         
         }
         if(!t2.isVisible && !deathdonet2){
            g.drawImage(tankdead.getImage(),t2.lastlocationx,t2.lastlocationy,50,50,this);
            Timer laserThirdt2 =  new Timer();
            TimerTask laser3t2 =
                              new TimerTask() {
                                 public void run (){
                                    deathdonet2 = true;
                                    cancel();
                                 }
                              };
            laserThirdt2.scheduleAtFixedRate(laser3t2,1500,1500);
         
         }
         if(numberoftanks >=4){
            if(!t4.isVisible && !deathdonet4){
               g.drawImage(tankdead.getImage(),t4.lastlocationx,t4.lastlocationy,50,50,this);
               Timer laserThirdt2 =  new Timer();
               TimerTask laser3t2 =
                              new TimerTask() {
                                 public void run (){
                                    deathdonet4 = true;
                                    cancel();
                                 }
                              };
               laserThirdt2.scheduleAtFixedRate(laser3t2,1500,1500);
            
            }
            if(!t3.isVisible && !deathdonet3){
               g.drawImage(tankdead.getImage(),t3.lastlocationx,t3.lastlocationy,50,50,this);
               Timer laserThirdt2 =  new Timer();
               TimerTask laser3t2 =
                              new TimerTask() {
                                 public void run (){
                                    deathdonet3 = true;
                                    cancel();
                                 }
                              };
               laserThirdt2.scheduleAtFixedRate(laser3t2,1500,1500);
            
            }
         }
         if(mazedone){
            if(explosiont1 = true){
               g.drawImage(bulletexplosion.getImage(),bulletexplosionxt1-15, bulletexplosionyt1-15,90,90,this);
               /*/*/
            
            }
            if(explosiont2 = true){
               g.drawImage(bulletexplosion.getImage(),bulletexplosionxt2-15, bulletexplosionyt2-15,90,90,this);
              
            }
            if(explosiont3 = true){
               g.drawImage(bulletexplosion.getImage(),bulletexplosionxt3-15, bulletexplosionyt3-15,90,90,this);
              
            }
            if(explosiont4 = true){
               g.drawImage(bulletexplosion.getImage(),bulletexplosionxt4-15, bulletexplosionyt4-15,90,90,this);
            
            }
         }
         Graphics2D graphics2Dt1 = (Graphics2D)g.create();
         graphics2Dt1 = (Graphics2D)g.create();
         graphics2Dt1.rotate(Math.toRadians(t1.angle),(t1.posx+t1.width/2),(t1.posy+t1.height/2));
         graphics2Dt1.setColor(t1.tankColor);
         graphics2Dt1.fillRect(t1.posx,t1.posy+t1.height/5,t1.width, t1.height-t1.height/3);
         graphics2Dt1.fillRect((t1.posx+t1.width/3),t1.posy,t1.width/3,t1.height/4);
         graphics2Dt1.setColor(Color.black);
         graphics2Dt1.drawOval((t1.posx+2),(t1.posy+t1.height/4),t1.width*26/30,t1.width*26/30);
         graphics2Dt1.drawRect((t1.posx+t1.width/3),t1.posy,t1.width/3,t1.height/4+t1.width/3);
         graphics2Dt1.setColor(t1.tankColor);
         graphics2Dt1.fillOval((t1.posx+3),(t1.posy+t1.height/4+1),t1.width*24/30,t1.width*24/30);
         graphics2Dt1.setColor(Color.black);
         Graphics2D graph2Dt1 = (Graphics2D)g.create();
        
         if(mazedone){
            for(int i = 0; i<numberofbulletst1; i++)
               if(t1b[i].move)
                  graph2Dt1.fillOval(t1b[i].bulletx, t1b[i].bullety, t1b[i].diameterofbullet,t1b[i].diameterofbullet);
            g.setColor(Color.green);
            //g.fillPolygon(t1.throughwall);
            g.fillPolygon(lazert1);
            //g.fillPolygon(aifire);
            g.setColor(Color.black);
            for(int i = 0; i<machinegunbulletst1; i++)
               if(machinegunt1[i].move)
                  graph2Dt1.fillOval(machinegunt1[i].bulletx, machinegunt1[i].bullety, machinegunt1[i].diameterofbullet,machinegunt1[i].diameterofbullet);
            if(explosionshott1.move)
               graph2Dt1.fillOval(explosionshott1.bulletx, explosionshott1.bullety, explosionshott1.diameterofbullet,explosionshott1.diameterofbullet);
            for(int j = 0; j<numberoftriplebulletst1; j++)
               if(triplet1[j].move)
                  graph2Dt1.fillOval(triplet1[j].bulletx, triplet1[j].bullety, triplet1[j].diameterofbullet,triplet1[j].diameterofbullet);
            if(machinegunfiret1){
               graphics2Dt1.drawRect((t1.posx+t1.width/3),t1.posy, 1, 10);
               graphics2Dt1.drawRect((t1.posx+t1.width/3+5),t1.posy, 1, 10);
               graphics2Dt1.drawRect((t1.posx+t1.width/3+5),t1.posy+35, 1, 10);
               graphics2Dt1.drawRect((t1.posx+t1.width/3+10),t1.posy, 1, 10);
            }
         }
        
         //g.fillPolygon(t2.collision);
         Graphics2D graphics2Dt2 = (Graphics2D)g.create();
         graphics2Dt2 = (Graphics2D)g.create();
         graphics2Dt2.rotate(Math.toRadians(t2.angle),(t2.posx+t2.width/2),(t2.posy+t2.height/2));
         graphics2Dt2.setColor(t2.tankColor);
         graphics2Dt2.fillRect(t2.posx,t2.posy+t2.height/5,t2.width, t2.height-t2.height/3);
         graphics2Dt2.fillRect((t2.posx+t2.width/3),t2.posy,t2.width/3,t2.height/4);
         graphics2Dt2.setColor(Color.black);
         graphics2Dt2.drawOval((t2.posx+2),(t2.posy+t2.height/4),t2.width*26/30,t2.width*26/30);
         graphics2Dt2.drawRect((t2.posx+t2.width/3),t2.posy,t2.width/3,t2.height/4+10);
         graphics2Dt2.setColor(t2.tankColor);
         graphics2Dt2.fillOval((t2.posx+3),(t2.posy+t2.height/4+1),t2.width*24/30,t2.width*24/30);
         Graphics2D graph2Dt2 = (Graphics2D)g.create();
         if(mazedone){
            for(int i = 0; i<numberofbulletst2; i++)
               if(t2b[i].move)
                  graph2Dt2.fillOval(t2b[i].bulletx, t2b[i].bullety, t2b[i].diameterofbullet,t2b[i].diameterofbullet);
            g.setColor(Color.green);
            g.fillPolygon(lazert2);
         
            g.setColor(Color.black);
            for(int i = 0; i<machinegunbulletst2; i++)
               if(machinegunt2[i].move)
                  graph2Dt2.fillOval(machinegunt2[i].bulletx, machinegunt2[i].bullety, machinegunt2[i].diameterofbullet,machinegunt2[i].diameterofbullet);
            if(explosionshott2.move)
               graph2Dt2.fillOval(explosionshott2.bulletx, explosionshott2.bullety, explosionshott2.diameterofbullet,explosionshott2.diameterofbullet);
            for(int j = 0; j<numberoftriplebulletst2; j++)
               if(triplet2[j].move)
                  graph2Dt2.fillOval(triplet2[j].bulletx, triplet2[j].bullety, triplet2[j].diameterofbullet,triplet2[j].diameterofbullet);
            if(machinegunfiret2){
               graphics2Dt2.setColor(Color.black);
               graphics2Dt2.drawRect((t2.posx+t2.width/3),t2.posy, 1, 10);
               graphics2Dt2.drawRect((t2.posx+t2.width/3+5),t2.posy, 1, 10);
               graphics2Dt2.drawRect((t2.posx+t2.width/3+5),t2.posy+35, 1, 10);
               graphics2Dt2.drawRect((t2.posx+t2.width/3+10),t2.posy, 1, 10);
            }
         }
      
        
         Graphics2D graphics2Dt3 = (Graphics2D)g.create();
         graphics2Dt3 = (Graphics2D)g.create();
         graphics2Dt3.rotate(Math.toRadians(t3.angle),(t3.posx+t3.width/2),(t3.posy+t3.height/2));
         graphics2Dt3.setColor(t3.tankColor);
         graphics2Dt3.fillRect(t3.posx,t3.posy+t3.height/5,t3.width, t3.height-t3.height/3);
         graphics2Dt3.fillRect((t3.posx+t3.width/3),t3.posy,t3.width/3,t3.height/4);
         graphics2Dt3.setColor(Color.black);
         graphics2Dt3.drawOval((t3.posx+2),(t3.posy+t3.height/4),t3.width*26/30,t3.width*26/30);
         graphics2Dt3.drawRect((t3.posx+t2.width/3),t3.posy,t3.width/3,t3.height/4+10);
         graphics2Dt3.setColor(t3.tankColor);
         graphics2Dt3.fillOval((t3.posx+3),(t3.posy+t3.height/4+1),t3.width*24/30,t3.width*24/30);
         Graphics2D graph2Dt3 = (Graphics2D)g.create();
         graphics2Dt3.setColor(Color.black);
         if(mazedone){
            for(int i = 0; i<numberofbulletst3; i++)
               if(t3b[i].move)
                  graph2Dt3.fillOval(t3b[i].bulletx, t3b[i].bullety, t3b[i].diameterofbullet,t3b[i].diameterofbullet);
            g.setColor(Color.green);
            g.fillPolygon(lazert3);
         
            g.setColor(Color.black);
            for(int i = 0; i<machinegunbulletst3; i++)
               if(machinegunt3[i].move)
                  graph2Dt3.fillOval(machinegunt3[i].bulletx, machinegunt3[i].bullety, machinegunt3[i].diameterofbullet,machinegunt3[i].diameterofbullet);
            if(explosionshott3.move)
               graph2Dt3.fillOval(explosionshott3.bulletx, explosionshott3.bullety, explosionshott3.diameterofbullet,explosionshott3.diameterofbullet);
            for(int j = 0; j<numberoftriplebulletst3; j++)
               if(triplet3[j].move)
                  graph2Dt3.fillOval(triplet3[j].bulletx, triplet3[j].bullety, triplet3[j].diameterofbullet,triplet3[j].diameterofbullet);
            if(machinegunfiret3){
               graphics2Dt3.setColor(Color.black);
               graphics2Dt3.drawRect((t3.posx+t3.width/3),t3.posy, 1, 10);
               graphics2Dt3.drawRect((t3.posx+t3.width/3+5),t3.posy, 1, 10);
               graphics2Dt3.drawRect((t3.posx+t3.width/3+5),t3.posy+30, 1, 10);
               graphics2Dt3.drawRect((t3.posx+t3.width/3+10),t3.posy, 1, 10);
            }
         }
      
         Graphics2D graphics2Dt4 = (Graphics2D)g.create();
         graphics2Dt4 = (Graphics2D)g.create();
         graphics2Dt4.rotate(Math.toRadians(t4.angle),(t4.posx+t4.width/2),(t4.posy+t4.height/2));
         graphics2Dt4.setColor(t4.tankColor);
         graphics2Dt4.fillRect(t4.posx,t4.posy+t4.height/5,t4.width, t4.height-t4.height/3);
         graphics2Dt4.fillRect((t4.posx+t4.width/3),t4.posy,t4.width/3,t4.height/4);
         graphics2Dt4.setColor(Color.black);
         graphics2Dt4.drawOval((t4.posx+2),(t4.posy+t4.height/4),t4.width*26/30,t4.width*26/30);
         graphics2Dt4.drawRect((t4.posx+t4.width/3),t4.posy,t4.width/3,t4.height/4+10);
         graphics2Dt4.setColor(t4.tankColor);
         graphics2Dt4.fillOval((t4.posx+3),(t4.posy+t4.height/4+1),t4.width*24/30,t4.width*24/30);
         Graphics2D graph2Dt4 = (Graphics2D)g.create();
         if(mazedone){
            for(int i = 0; i<numberofbulletst4; i++)
               if(t4b[i].move)
                  graph2Dt4.fillOval(t4b[i].bulletx, t4b[i].bullety, t4b[i].diameterofbullet,t4b[i].diameterofbullet);
            g.setColor(Color.green);
            g.fillPolygon(lazert4);
         
            g.setColor(Color.black);
            for(int i = 0; i<machinegunbulletst4; i++)
               if(machinegunt4[i].move)
                  graph2Dt4.fillOval(machinegunt4[i].bulletx, machinegunt4[i].bullety, machinegunt4[i].diameterofbullet,machinegunt4[i].diameterofbullet);
            if(explosionshott4.move)
               graph2Dt4.fillOval(explosionshott4.bulletx, explosionshott4.bullety, explosionshott4.diameterofbullet,explosionshott4.diameterofbullet);
            for(int j = 0; j<numberoftriplebulletst4; j++)
               if(triplet4[j].move)
                  graph2Dt4.fillOval(triplet4[j].bulletx, triplet4[j].bullety, triplet4[j].diameterofbullet,triplet4[j].diameterofbullet);
            if(machinegunfiret4){
               graphics2Dt4.setColor(Color.black);
               graphics2Dt4.drawRect((t4.posx+t4.width/3),t4.posy, 1, 10);
               graphics2Dt4.drawRect((t4.posx+t4.width/3+5),t4.posy, 1, 10);
               graphics2Dt4.drawRect((t4.posx+t4.width/3+5),t4.posy+35, 1, 10);
               graphics2Dt4.drawRect((t4.posx+t4.width/3+10),t4.posy, 1, 10);
            }
           
            // Tank 1 Laser stages of firing
            if(laserClickedt1){
               if(firstsecondt1){
                                
                  graphics2Dt1.setColor(Color.green);
                  graphics2Dt1.fillOval((t1.posx+t1.width/3-2),t1.posy+11, 14, 5);
                 
                  graphics2Dt1.setColor(Color.black);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy-1, 14, 5);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy+5, 14, 5);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy+11, 14, 5);                   
                 
                 
                  Timer laserFirst =  new Timer();
                  TimerTask laser1 =
                              new TimerTask() {
                                 public void run (){
                                    firstsecondt1 = false;
                                    secondsecondt1 = true;
                                    cancel();
                                 }
                              };
                  laserFirst.scheduleAtFixedRate(laser1,700,700);
               
               }
               if(secondsecondt1){
                 
                  graphics2Dt1.setColor(Color.green);
                  graphics2Dt1.fillOval((t1.posx+t1.width/3-2),t1.posy+11, 14, 5);
                  graphics2Dt1.fillOval((t1.posx+t1.width/3-2),t1.posy+5, 14, 5);
                                      
                  graphics2Dt1.setColor(Color.black);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy-1, 14, 5);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy+5, 14, 5);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy+11, 14, 5);
                 
                  Timer laserSecond =  new Timer();
                  TimerTask laser2 =
                              new TimerTask() {
                                 public void run (){
                                    secondsecondt1 = false;
                                    thirdsecondt1 = true;
                                    cancel();
                                 }
                              };
                  laserSecond.scheduleAtFixedRate(laser2,700,700);
               
               }
               if(thirdsecondt1){
                 
                  graphics2Dt1.setColor(Color.green);
                  graphics2Dt1.fillOval((t1.posx+t1.width/3-2),t1.posy+11, 14, 5);
                  graphics2Dt1.fillOval((t1.posx+t1.width/3-2),t1.posy+5, 14, 5);
                  graphics2Dt1.fillOval((t1.posx+t1.width/3-2),t1.posy-1, 14, 5);
                                      
                  graphics2Dt1.setColor(Color.black);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy-1, 14, 5);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy+5, 14, 5);
                  graphics2Dt1.drawOval((t1.posx+t1.width/3-2),t1.posy+11, 14, 5);
               
                  Timer laserThird =  new Timer();
                  TimerTask laser3 =
                              new TimerTask() {
                                 public void run (){
                                    thirdsecondt1 = false; 
                                    firstsecondt1 = true;
                                    cancel();
                                 }
                              };
                  laserThird.scheduleAtFixedRate(laser3,3000,3000);
               
               }
            }
               // Tank 2 Laser stages of Firing
            if(laserClickedt2){
               if(firstsecondt2){
                 
                 
                  graphics2Dt2.setColor(Color.green);
                  graphics2Dt2.fillOval((t2.posx+t2.width/3-2),t2.posy+11, 14, 5);
                 
                  graphics2Dt2.setColor(Color.black);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy-1, 14, 5);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy+5, 14, 5);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy+11, 14, 5);                   
                 
                 
                  Timer laserFirstt2 =  new Timer();
                  TimerTask laser1t2 =
                              new TimerTask() {
                                 public void run (){
                                    firstsecondt2 = false;
                                    secondsecondt2 = true;
                                    cancel();
                                 }
                              };
                  laserFirstt2.scheduleAtFixedRate(laser1t2,700,700);
                 
               }
               if(secondsecondt2){
                 
                  graphics2Dt2.setColor(Color.green);
                  graphics2Dt2.fillOval((t2.posx+t2.width/3-2),t2.posy+11, 14, 5);
                  graphics2Dt2.fillOval((t2.posx+t2.width/3-2),t2.posy+5, 14, 5);
                                      
                  graphics2Dt2.setColor(Color.black);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy-1, 14, 5);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy+5, 14, 5);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy+11, 14, 5);
                 
                  Timer laserSecondt2 =  new Timer();
                  TimerTask laser2t2 =
                              new TimerTask() {
                                 public void run (){
                                    secondsecondt2 = false;
                                    thirdsecondt2 = true;
                                    cancel();
                                 }
                              };
                  laserSecondt2.scheduleAtFixedRate(laser2t2,700,700);
                 
               }
               if(thirdsecondt2){
                 
                  graphics2Dt2.setColor(Color.green);
                  graphics2Dt2.fillOval((t2.posx+t2.width/3-2),t2.posy+11, 14, 5);
                  graphics2Dt2.fillOval((t2.posx+t2.width/3-2),t2.posy+5, 14, 5);
                  graphics2Dt2.fillOval((t2.posx+t2.width/3-2),t2.posy-1, 14, 5);
                                      
                  graphics2Dt2.setColor(Color.black);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy-1, 14, 5);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy+5, 14, 5);
                  graphics2Dt2.drawOval((t2.posx+t2.width/3-2),t2.posy+11, 14, 5);
                 
                  Timer laserThirdt2 =  new Timer();
                  TimerTask laser3t2 =
                              new TimerTask() {
                                 public void run (){
                                    thirdsecondt2 = false; 
                                    firstsecondt2 = true;
                                    cancel();
                                 }
                              };
                  laserThirdt2.scheduleAtFixedRate(laser3t2,3000,3000);
                 
               }
            }
              
               // Tank 3 Laser stages of Firing
            if(laserClickedt3){
               if(firstsecondt3){
                 
                 
                  graphics2Dt3.setColor(Color.green);
                  graphics2Dt3.fillOval((t3.posx+t3.width/3-2),t3.posy+11, 14, 5);
                 
                  graphics2Dt3.setColor(Color.black);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy-1, 14, 5);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy+5, 14, 5);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy+11, 14, 5);                   
                 
                 
                  Timer laserFirstt3 =  new Timer();
                  TimerTask laser1t3 =
                              new TimerTask() {
                                 public void run (){
                                    firstsecondt3 = false;
                                    secondsecondt3 = true;
                                    cancel();
                                 }
                              };
                  laserFirstt3.scheduleAtFixedRate(laser1t3,700,700);
                 
               }
               if(secondsecondt3){
                 
                  graphics2Dt3.setColor(Color.green);
                  graphics2Dt3.fillOval((t3.posx+t3.width/3-2),t3.posy+11, 14, 5);
                  graphics2Dt3.fillOval((t3.posx+t3.width/3-2),t3.posy+5, 14, 5);
                                      
                  graphics2Dt3.setColor(Color.black);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy-1, 14, 5);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy+5, 14, 5);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy+11, 14, 5);
                 
                  Timer laserSecondt3 =  new Timer();
                  TimerTask laser2t3 =
                              new TimerTask() {
                                 public void run (){
                                    secondsecondt3 = false;
                                    thirdsecondt3 = true;
                                    cancel();
                                 }
                              };
                  laserSecondt3.scheduleAtFixedRate(laser2t3,700,700);
                 
               }
               if(thirdsecondt3){
                 
                  graphics2Dt3.setColor(Color.green);
                  graphics2Dt3.fillOval((t3.posx+t3.width/3-2),t3.posy+11, 14, 5);
                  graphics2Dt3.fillOval((t3.posx+t3.width/3-2),t3.posy+5, 14, 5);
                  graphics2Dt3.fillOval((t3.posx+t3.width/3-2),t3.posy-1, 14, 5);
                                      
                  graphics2Dt3.setColor(Color.black);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy-1, 14, 5);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy+5, 14, 5);
                  graphics2Dt3.drawOval((t3.posx+t3.width/3-2),t3.posy+11, 14, 5);
                 
                  Timer laserThirdt3 =  new Timer();
                  TimerTask laser3t3 =
                              new TimerTask() {
                                 public void run (){
                                    thirdsecondt3 = false; 
                                    firstsecondt3 = true;
                                    cancel();
                                 }
                              };
                  laserThirdt3.scheduleAtFixedRate(laser3t3,3000,3000);
                 
               }
            }
              
            // Tank 4 Laser stages of Firing
            if(laserClickedt4){
               if(firstsecondt4){                
                 
                  graphics2Dt4.setColor(Color.green);
                  graphics2Dt4.fillOval((t4.posx+t4.width/3-2),t4.posy+11, 14, 5);
                 
                  graphics2Dt4.setColor(Color.black);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy-1, 14, 5);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy+5, 14, 5);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy+11, 14, 5);                   
                 
                 
                  Timer laserFirstt4 =  new Timer();
                  TimerTask laser1t4 =
                              new TimerTask() {
                                 public void run (){
                                    firstsecondt4 = false;
                                    secondsecondt4 = true;
                                    cancel();
                                 }
                              };
                  laserFirstt4.scheduleAtFixedRate(laser1t4,700,700);
                 
               }
              
               if(secondsecondt4){
                 
                  graphics2Dt4.setColor(Color.green);
                  graphics2Dt4.fillOval((t4.posx+t4.width/3-2),t4.posy+11, 14, 5);
                  graphics2Dt4.fillOval((t4.posx+t4.width/3-2),t4.posy+5, 14, 5);
                                      
                  graphics2Dt4.setColor(Color.black);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy-1, 14, 5);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy+5, 14, 5);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy+11, 14, 5);
                 
                  Timer laserSecondt4 =  new Timer();
                  TimerTask laser2t4 =
                              new TimerTask() {
                                 public void run (){
                                    secondsecondt4 = false;
                                    thirdsecondt4 = true;
                                    cancel();
                                 }
                              };
                  laserSecondt4.scheduleAtFixedRate(laser2t4,700,700);
                 
               }
               if(thirdsecondt4){
                 
                  graphics2Dt4.setColor(Color.green);
                  graphics2Dt4.fillOval((t4.posx+t4.width/3-2),t4.posy+11, 14, 5);
                  graphics2Dt4.fillOval((t4.posx+t4.width/3-2),t4.posy+5, 14, 5);
                  graphics2Dt4.fillOval((t4.posx+t4.width/3-2),t4.posy-1, 14, 5);
                                      
                  graphics2Dt4.setColor(Color.black);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy-1, 14, 5);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy+5, 14, 5);
                  graphics2Dt4.drawOval((t4.posx+t4.width/3-2),t4.posy+11, 14, 5);
                 
                  Timer laserThirdt4 =  new Timer();
                  TimerTask laser3t4 =
                              new TimerTask() {
                                 public void run (){
                                    thirdsecondt4 = false; 
                                    firstsecondt4 = true;
                                    cancel();
                                 }
                              };
                  laserThirdt4.scheduleAtFixedRate(laser3t4,3000,3000);                   
               }
            }
         }
        
         mazedone = true;
      }
   }  
   int h = 0;
   int p = 0;
   boolean o = true;
   int prevX [] = new int [1000];
   int prevY [] = new int [1000];
   class Keys extends Thread {
      /*** run ************************************************************************************
   * Purpose: Tracks keys being clicked and performs actions based on clicks and runs ai code  *                                                                         
   * Parameters: none                                                                          *                                  
   * Returns: none                                                                             *
   ********************************************************************************************/
      public void run() {
         try{
            while(true){
               sleep(60);
               if (t1leftclick) {
                  sleep(10);
                  t1.lrotate();
                  draw.repaint();
               
               }
               if (t1rightclick) {
                  sleep(10);
                  t1.rrotate();
                  draw.repaint();
               
               }
               if (t1upclick) {
                  t1.up();
                  draw.repaint();
               }
               if (t1downclick) {
                  t1.down();
                  draw.repaint();
               
               }
               if (t2leftclick) {
                  t2.lrotate();
                  draw.repaint();
               
               }
               if (t2rightclick) {
                  t2.rrotate();
                  draw.repaint();
               
               }
               if (t2upclick) {
                  t2.up();
                  draw.repaint();
               }
               if (t2downclick) {
                  t2.down();
                  draw.repaint();
               
               }
               if (t3leftclick) {
                  t3.lrotate();
                  draw.repaint();
               }
               if (t3rightclick) {
                  t3.rrotate();
                  draw.repaint();
               
               }
               if (t3upclick) {
                  t3.up();
                  draw.repaint();
               }
               if (t3downclick) {
                  t3.down();
                  draw.repaint();
               }
               if (t4leftclick) {
                  t4.lrotate();
                  draw.repaint();
               
               }
               if (t4rightclick) {
                  t4.rrotate();
                  draw.repaint();
               }
               if (t4upclick) {
                  t4.up();
                  draw.repaint();
               }
               if (t4downclick) {
                  t4.down();
                  draw.repaint();
               }
              
               if(!aicode){
                  if (teamonepoints == playupto && once == false)
                  {
                     once = true;
                     new RedTeamVictory(numberoftanks,teamonepoints, teamtwopoints);
                     frame.setVisible(false);
                  }
               
                  if (teamtwopoints == playupto && once == false)
                  {
                     once = true;
                     new BlueTeamVictory(numberoftanks,teamonepoints, teamtwopoints);
                     frame.setVisible(false);
                  }
               
               }
               boolean tankfound = false;
              
               if(!aicode){
                  if (teamonepoints == playupto && once == false)
                  {
                     once = true;
                     new RedTeamVictory(numberoftanks,teamonepoints, teamtwopoints);
                     frame.setVisible(false);
                  }
               
                  if (teamtwopoints == playupto && once == false)
                  {
                     once = true;
                     new BlueTeamVictory(numberoftanks,teamonepoints, teamtwopoints);
                     frame.setVisible(false);
                  }
               
               }
              
               //ai code
               if(mazedone){
                  int ang1 = t2.angle;
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
                  if(aicode && !gamedone){
                  
                    
                     t2.aicode = true;
                    
                     //int centx = t2.posx;
                     //int centy = t2.posy;
                     if(!moveback){
                        o = true;
                        goalx = (int) Math.floor(((t1.posx+t1.width/2) - mazex)/100.0);
                        goaly = (int) Math.floor(((t1.posy+t1.height/2) - mazey)/100.0);
                       
                        for (int i = 0; i < current; i++)
                        {
                           int cellpx = (int) Math.floor((pu[i].x - mazex)/100.0);
                           int cellpy = (int) Math.floor((pu[i].y - mazey)/100.0);
                           if (distance[cellx][celly][goalx][goaly] > distance[cellx][celly][cellpx][cellpy])
                           {
                              goalx = cellpx;
                              goaly = cellpy;
                           }
                        
                        }
                     }
                     
                     else if(moveback && o == true)
                     {
                        o = false;
                        goalx = prevX[p-10];
                        goaly = prevY[p-10];
                     }     
                     p++;
                     prevX[p] = cellx;
                     prevY[p] = celly; 
                                                                      
                     cellx = (int) Math.floor((t2.posx - mazex)/100.0);
                     celly = (int) Math.floor((t2.posy - mazey)/100.0);
                                     
                     //int nextx = cellx;
                     //int nexty = celly;
                    
                     if (((t2.posx - mazex - 35) % 100 == 0) && ((t2.posy - mazey - 35) % 100 == 0) ){
                        t2.movmentx = 0;
                        t2.movmenty = 0;
                        if (direction[cellx][celly][goalx][goaly] == 1) { t2.angle = 180; t2.movmentx = 0; t2.movmenty = t2.speed/2; }
                        if (direction[cellx][celly][goalx][goaly] == 2) { t2.angle = 0; t2.movmentx = 0; t2.movmenty = -t2.speed/2; }
                        if (direction[cellx][celly][goalx][goaly] == 3) { t2.angle = 90; t2.movmentx = t2.speed/2; t2.movmenty = 0; }
                        if (direction[cellx][celly][goalx][goaly] == 4) { t2.angle = 270; t2.movmentx = -t2.speed/2; t2.movmenty = 0; }
                     }
                    
                     if (distance[cellx][celly][goalx][goaly] <= 1) {
                     
                        double stax1 = t2.nextmovex[1] - 20*Math.cos(Math.toRadians(t2.angle));
                        double stay1 = t2.nextmovey[1] - 20*Math.sin(Math.toRadians(t2.angle));
                        double stax2 = t2.nextmovex[2] + 20*Math.cos(Math.toRadians(t2.angle));
                        double stay2 = t2.nextmovey[2] + 20*Math.sin(Math.toRadians(t2.angle));
                       
                        int [] shootx = {(int)stax1,(int)stax2,((int)((stax2)-(100)*Math.sin(Math.toRadians(ang1)))), (int)((stax1)-(100)*Math.sin(Math.toRadians(ang1)))};
                        int [] shooty = {(int)stay1,(int)stay2,((int)((stay2)-(100)*Math.cos(Math.toRadians(ang1)))), (int)((stay1)-(100)*Math.cos(Math.toRadians(ang1)))};
                         
                        for(int b = 0; b<numpoints;b++){
                           if(aifire.contains(collisionpointsx[b],collisionpointsy[b])){
                              if(verticaorhorizontal[b].equals("h")){
                                 if(collisionpointsx[b] < shootx[2]){
                                    shootx[2] = collisionpointsx[b];
                                 }
                                 if (collisionpointsx[b] > shootx[2]){
                                    shootx[2] = collisionpointsx[b];
                                 }
                                 if(collisionpointsx[b] < shootx[3]){
                                    shootx[3] = collisionpointsx[b];
                                 }
                                 if(collisionpointsx[b] > shootx[3]){
                                    shootx[3] = collisionpointsx[b];
                                 }
                              }
                              if(verticaorhorizontal[b].equals("v")){
                                 if(collisionpointsy[b] < shooty[2]){
                                    shooty[2] = collisionpointsy[b];
                                 }
                                 if (collisionpointsx[b] > shooty[2]){
                                    shooty[2] = collisionpointsy[b];
                                 }
                                 if(collisionpointsy[b] < shooty[3]){
                                    shooty[3] = collisionpointsy[b];
                                 }
                                 if(collisionpointsy[b] > shooty[3]){
                                    shooty[3] = collisionpointsy[b];
                                 }                            
                              }
                           }
                        }
                                                                    
                        if(!moveback){
                        
                           aifire = new Polygon (shootx,shooty,4);                
                           for (int i = 0; i < 8; i++)
                              if(aifire.contains(t1.nextmovex[i], t1.nextmovey[i]))
                                 ableToShoot = true;
                        }
                        if (ableToShoot == true) {
                                        
                           moveback = true;
                           if(lazerfiret2){
                              double starx1 = t2.nextmovex[1] - 7.5*Math.cos(Math.toRadians(t2.angle));
                              double stary1 = t2.nextmovey[1] - 7.5*Math.sin(Math.toRadians(t2.angle));
                              double starx2 = t2.nextmovex[2] + 7.5*Math.cos(Math.toRadians(t2.angle));
                              double stary2 = t2.nextmovey[2] + 7.5*Math.sin(Math.toRadians(t2.angle));
                           
                              final int [] lazerx = {(int)starx1,(int)starx2,((int)((starx2)-(750)*Math.sin(Math.toRadians(ang1)))), (int)((starx1)-(750)*Math.sin(Math.toRadians(ang1)))};
                              final int [] lazery = {(int)stary1,(int)stary2,((int)((stary2)-(750)*Math.cos(Math.toRadians(ang1)))), (int)((stary1)-(750)*Math.cos(Math.toRadians(ang1)))};
                                
                              Timer lt2bfire =  new Timer();
                              TimerTask t2lazerfire =
                                 new TimerTask() {
                                    public void run(){
                                       lazert2 = new Polygon (lazerx, lazery, 4);
                                       for(int v = 0; v<8;v++){
                                          if(lazert2.contains(t1.nextmox[v], t1.nextmoy[v])){
                                             deadt1();
                                          }
                                          if(lazert2.contains(t3.nextmox[v], t3.nextmoy[v])){
                                             deadt3();
                                          }
                                          if(lazert2.contains(t4.nextmox[v], t4.nextmoy[v])){
                                             deadt4();
                                          }
                                       }
                                       draw.repaint();
                                       Timer lt2b =  new Timer();
                                       TimerTask t1lazer =
                                          new TimerTask() {
                                             public void run(){
                                                lazert2 = new Polygon (reset, reset, 2);
                                                draw.repaint();
                                                t2powerup = true;
                                                normalfiret2 = true;
                                                cancel();
                                             }
                                          };
                                       lt2b.scheduleAtFixedRate(t1lazer,2000,2000);
                                       cancel();
                                    }
                                 };
                           
                              lazerfiret2 = false;
                              lt2bfire.scheduleAtFixedRate(t2lazerfire,2000,2000);
                           }
                           else if(normalfiret2) {
                              boolean reload = false;
                              if(numberofbulletst2 == 5){
                                 if(t2b [0].move == false)
                                    reload = true;
                              }
                              if(reload){
                                 BulletTester [] temp = new BulletTester [1000];
                                 for(int i = 0; i<4; i++){
                                    temp [i] = t2b[i+1];
                                 }
                                 numberofbulletst2--;
                                 totalnumberofbullets--;
                                 t2b = temp;
                              }
                              if(numberofbulletst2 < 5){
                                 t2b [numberofbulletst2]= new BulletTester (t2.nextmovex[1], t2.nextmovey[1], t2.angle, t2.bulletdiamter);
                              
                                 numberofbulletst2++;
                                 totalnumberofbullets++;
                              }
                           }
                           else if (tripleshott2){
                              int startx1 = t2.nextmovex[1]-(int)(10*Math.cos(Math.toRadians(t2.angle)));
                              int starty1 = t2.nextmovey[1]-(int)(10*Math.sin(Math.toRadians(t2.angle)));
                              int startx2 = t2.nextmovex[1]+(int)(10*Math.cos(Math.toRadians(t2.angle)));
                              int starty2 = t2.nextmovey[1]+(int)(10*Math.sin(Math.toRadians(t2.angle)));
                           
                              triplet2[numberoftriplebulletst2] = new BulletTester (t2.nextmovex[1], t2.nextmovey[1], t2.angle, t2.bulletdiamter);
                              triplet2[numberoftriplebulletst2+1] = new BulletTester (startx1-(int)(10*Math.sin(Math.toRadians(t2.angle))),(starty1-(int)(10*Math.cos(Math.toRadians(ang1)))), t2.angle, t2.bulletdiamter);
                              triplet2[numberoftriplebulletst2+2] = new BulletTester (startx2-(int)(10*Math.sin(Math.toRadians(t2.angle))),(starty2-(int)(10*Math.cos(Math.toRadians(ang1)))), t2.angle, t2.bulletdiamter);
                              triplet2[numberoftriplebulletst2].biggerbullet = true;
                              triplet2[numberoftriplebulletst2+1].biggerbullet = true;
                              triplet2[numberoftriplebulletst2+2].biggerbullet = true;
                              numberoftriplebulletst2 +=3;
                              draw.repaint();
                              if(numberoftriplebulletst2+3 > 6){
                                 t2powerup = true;
                                 normalfiret2 = true;
                                 tripleshott2 = false;
                              }
                           }
                           else if(machinegunfiret2){
                              machinegunt2[machinegunbulletst2]= new BulletTester (t2.nextmovex[1], t2.nextmovey[1], t2.angle, t2.bulletdiamter);
                              machinegunt2[machinegunbulletst2].diameterofbullet = t2.width/6;
                              machinegunt2[machinegunbulletst2].bulletx += t2.width/6;
                              machinegunbulletst2++;
                           }
                           else if(explosiveshott2){
                              explosionshott2 = new BulletTester (t2.nextmovex[1] + (int)( 10*Math.sin(Math.toRadians(ang1))), t2.nextmovey[1] - (int) (10*Math.cos(Math.toRadians(ang1))), t2.angle, t2.bulletdiamter);
                              explosionshott2.diameterofbullet = 2*t2.width/3;
                              explosionshott2.bulletx -= t2.width/6;
                              explosionshott2.biggerbullet = true;
                              explosiveshott2 = false;
                              Timer bulletexplodet2b =  new Timer();
                              TimerTask t2bexplode =
                                 new TimerTask() {
                                    public void run (){
                                       int x1horx = explosionshott2.bulletx+150;
                                       int x2horx = explosionshott2.bulletx-150;
                                       int y1vet = explosionshott2.bullety+150 ;
                                       int y2vet = explosionshott2.bullety-150;
                                       int [] explosionx = {x1horx,x2horx,x2horx,x1horx};
                                       int [] explosiony = {y1vet,y1vet,y2vet,y2vet};
                                       explosion2 = new Polygon (explosionx,explosiony,4);
                                    
                                       for(int b = 0; b<collisionpointsx.length;b++){
                                          if(explosion2.contains(collisionpointsx[b],collisionpointsy[b])){
                                             if(verticaorhorizontal[b].equals("h")){
                                                if(collisionpointsx[b] < explosionshott2.bulletx){
                                                   x2horx = collisionpointsx[b];
                                                }
                                                else{
                                                   x1horx = collisionpointsx[b];
                                                }
                                             }
                                             if(verticaorhorizontal[b].equals("v")){
                                                if(collisionpointsy[b] < explosionshott2.bullety){
                                                   y2vet = collisionpointsy[b];
                                                }
                                                else{
                                                   y1vet = collisionpointsy[b];
                                                }
                                             }
                                          }
                                       }
                                    
                                       int [] explosion2x = {x1horx,x2horx,x2horx,x1horx};
                                       int [] explosion2y = {y1vet,y1vet,y2vet,y2vet};
                                       explosionx = explosion2x;
                                       explosiony = explosion2y;
                                    
                                       explosion2 = new Polygon (explosionx,explosiony,4);
                                    
                                       for(int g =0; g<8;g++){
                                          if(explosion2.contains(t1.nextmox[g], t1.nextmoy[g])){
                                             deadt1();
                                          }
                                          if(explosion2.contains(t2.nextmox[g], t2.nextmoy[g])){
                                             deadt2();
                                          }
                                          if(explosion2.contains(t3.nextmox[g], t3.nextmoy[g])){
                                             deadt3();
                                          }
                                          if(explosion2.contains(t4.nextmox[g], t4.nextmoy[g])){
                                             deadt4();
                                          }
                                       }
                                       explosiont2 = true;
                                       explosiveshott2 = false;
                                       t2powerup = true; 
                                       bulletexplosionxt2 = explosionshott2.bulletx-15;
                                       bulletexplosionyt2 = explosionshott2.bullety-15;
                                       draw.repaint();
                                       explosion = null;
                                       explosionx = null;
                                       explosiony = null;
                                       explosiont2 = false;
                                       explosiveshott2 = false;
                                       explosionshott2 = new BulletTester (0,0,30,0);
                                       normalfiret2 = true;
                                       draw.repaint();
                                       cancel();
                                    }
                                 };
                           }
                           //aicode = false;
                           ableToShoot = false;  
                           //if(t1.isVisible){
                           Timer resetmove2b =  new Timer();
                           TimerTask t2bmove =
                                 new TimerTask() {
                                    public void run (){
                                       moveback = false;
                                       aicode = true;
                                       ableToShoot = true;
                                       cancel();
                                    }
                                 };
                          
                           resetmove2b.scheduleAtFixedRate(t2bmove,2000,2000);
                           //}
                           draw.repaint();
                        }
                     }
                       
                     t2.tankcollision(t2.angle, t2.movmentx,-t2.movmenty);
                     t2.posx += 2*t2.movmentx;
                     t2.posy += 2*t2.movmenty;
                    
                    
                  }
                     /*h++;
                     t2.movmentx += (t2.speed/2)*Math.sin(Math.toRadians(t2.angle))-t2.movmentx;
                     t2.movmenty += (t2.speed/2)*Math.cos(Math.toRadians(t2.angle))-t2.movmenty;
                     if(!t2.tankcollision(t2.angle, -t2.movmentx,+t2.movmenty)){
                        if(h%18 ==0 && !tankfound)
                           if(!t2.tankcollision(t2.angle+90, -10*t2.movmentx,+10*t2.movmenty)){
                              t2.posy -= 4*t2.movmenty;
                              t2.posx += 4*t2.movmentx;
                              t2.angle = t2.angle + 90;
                              System.out.println("right turn");
                              t2.posy += 8*t2.movmenty;
                              t2.posx -= 8*t2.movmentx;
                           }
                           else if(!t2.tankcollision(t2.angle-90, -10*t2.movmentx,+10*t2.movmenty)){
                              t2.posy -= 4*t2.movmenty;
                              t2.posx += 4*t2.movmentx;
                              t2.angle = t2.angle - 90;
                              System.out.println("left turn");
                              t2.posy += 8*t2.movmenty;
                              t2.posx -= 8*t2.movmentx;
                           }
                          
                        t2.posy += t2.movmenty;
                        t2.posx -= t2.movmentx;
                     }
                     /*else {
                        t2.posy -= t2.movmenty;
                        t2.posx += t2.movmentx; 
                        if(!t2.tankcollision(t2.angle+90, -2*t2.movmentx,2*t2.movmenty)){
                           t2.angle = t2.angle + 90;
                        }
                        else if(!t2.tankcollision(t2.angle-90, -2*t2.movmentx,2*t2.movmenty)){
                           t2.angle = t2.angle - 90;                                                         }
                        else if(!t2.tankcollision(t2.angle+180, -2*t2.movmentx,+2*t2.movmenty)){
                           t2.angle = t2.angle +180;
                        }
                        t2.posy += t2.movmenty;
                        t2.posx -= t2.movmentx;
                    
                     }*/
                  //}
               }                  
               //acitivating powerups
               for(int t = 0; t < current+1; t++){
                  if(t1powerup)
                     if(current >=-1)
                        if(t1.gainpower (pu[t])){
                           pu[t].x = -1000;
                           pu[t].y = -1000;
                        //LMG for t1
                           if(pu[t].choice == 1){
                              t1.width = 30;
                              t1.height = 50;
                              t1.speed = 10;
                              t1 = pu[t].LMG(t1);
                              machinegunfiret1 = true;
                              t1powerup = false;
                              Timer resetbulletst1b =  new Timer();
                              normalfiret1 = false;
                              TimerTask t1breset =
                                 new TimerTask() {
                                    public void run (){
                                       machinegunfiret1 = false;
                                       normalfiret1 = true;
                                       t1powerup = true;
                                       cancel();
                                    }
                                 };
                              resetbulletst1b.scheduleAtFixedRate(t1breset,8000,8000);
                           }
                           
                           else if(pu[t].choice == 2){
                              t1.width = 30;
                              t1.height = 50;
                              t1.speed = 10;
                              t1 = pu[t].TripleShot(t1);
                              t1powerup = false;
                              normalfiret1 = false;
                              tripleshott1 = true;
                           }
                           //explosive shot for t1
                           else if(pu[t].choice == 3){
                              t1.width = 30;
                              t1.height = 50;
                              t1.speed = 10;
                              explosiveshott1 = true;
                              t1powerup = false;
                              normalfiret1 = false;
                           }
                           
                           else if(pu[t].choice == 4){
                              t1.width = 30;
                              t1.height = 50;
                              t1.speed = 10;
                              t1 = pu[t].LaserShot(t1);
                              t1powerup = false;
                              lazerfiret1= true;
                              normalfiret1 = false;
                           }
                           
                           else if(pu[t].choice == 5){
                              t1.width = 30;
                              t1.height = 50;
                              t1.speed = 10;
                              t1 = pu[t].Overdrive(t1);  
                           //t1reset.cancel();
                              t1powerup = false;
                              Timer resetpowerupt1 =  new Timer();
                              TimerTask t1reset =
                                 new TimerTask() {
                                    public void run (){
                                       t1.width = 30;
                                       t1.height = 50;
                                       t1.speed = 10;
                                       t1powerup = true;
                                       cancel();
                                    }
                                 };
                              resetpowerupt1.scheduleAtFixedRate(t1reset,10000,10000);
                           }
                           
                           else if(pu[t].choice == 8){
                              t1.width = 30;
                              t1.height = 50;
                              t1.speed = 10;
                              t1 = pu[t].HackingSystem(t1);
                              t1powerup = false;
                           //t1reset.cancel();
                           }
                           if(numberoftanks == 4){
                              if(pu[t].choice == 7){
                                 t1.width = 30;
                                 t1.height = 50;
                                 t1.speed = 10;
                                 t1 = pu[t].TeamLink(t1,t4);
                              }
                           }
                           else if(pu[t].choice == 6){
                              t1.width = 30;
                              t1.height = 50;
                              t1.speed = 10;
                              t1 = pu[t].MiniTank(t1);
                              t1powerup = false;
                              Timer resetpowerupt1 =  new Timer();
                              TimerTask t1reset =
                                 new TimerTask() {
                                    public void run (){
                                       t1.posx = ((t1.posx-mazex)/100)*100+mazex + 30;
                                       t1.posy = ((t1.posy-mazey)/100)*100+mazey + 30;
                                       t1.width = 30;
                                       t1.height = 50;
                                       t1.speed = 10;
                                       t1.mini = false;
                                       t1powerup = true;
                                       cancel();
                                    }
                                 };
                              resetpowerupt1.scheduleAtFixedRate(t1reset,10000,10000);
                           }
                           draw.repaint();
                           PowerUps temp = pu [t];
                        
                           pu [t] = pu [current];
                           pu[t].x = pu[current].x ;
                           pu[t].y = pu[current].y;
                           pu[current] = pu [t];
                           current--;
                           draw.repaint();
                           System.out.println(current);
                        }
               }
               for(int t = 0; t < current+1; t++){
                  if(t2powerup)
                     if(current >=-1)
                        if(t2.gainpower (pu[t])){
                           System.out.println("t2 - power up gained");
                           pu[t].x = -1000;
                           pu[t].y = -1000;
                        //LMG for t1
                           if(pu[t].choice == 1){
                              t2.width = 30;
                              t2.height = 50;
                              t2.speed = 10;
                              t2 = pu[t].LMG(t2);
                              machinegunfiret2 = true;
                              t2powerup = false;
                              Timer resetbulletst2b =  new Timer();
                              normalfiret2 = false;
                              TimerTask t2breset =
                                 new TimerTask() {
                                    public void run (){
                                       machinegunfiret2 = false;
                                       normalfiret2 = true;
                                       t2powerup = true;
                                       cancel();
                                    }
                                 };
                              resetbulletst2b.scheduleAtFixedRate(t2breset,8000,8000);
                           }
                           
                           else if(pu[t].choice == 2){
                              t2.width = 30;
                              t2.height = 50;
                              t2.speed = 10;
                              t2 = pu[t].TripleShot(t2);
                              t2powerup = false;
                              normalfiret2 = false;
                              tripleshott2 = true;
                           }
                           //explosive shot for t1
                           else if(pu[t].choice == 3){
                              t2.width = 30;
                              t2.height = 50;
                              t2.speed = 10;
                              explosiveshott2 = true;
                              t2powerup = false;
                              normalfiret2 = false;
                           }
                           
                           else if(pu[t].choice == 4){
                              t2.width = 30;
                              t2.height = 50;
                              t2.speed = 10;
                              t2 = pu[t].LaserShot(t2);
                              t2powerup = false;
                              lazerfiret2= true;
                              normalfiret2 = false;
                           }
                           
                           else if(pu[t].choice == 5){
                              t2.width = 30;
                              t2.height = 50;
                              t2.speed = 10;
                              t2 = pu[t].Overdrive(t2);  
                           //t1reset.cancel();
                              t2powerup = false;
                              Timer resetpowerupt2 =  new Timer();
                              TimerTask t2reset =
                                 new TimerTask() {
                                    public void run (){
                                       t2.width = 30;
                                       t2.height = 50;
                                       t2.speed = 10;
                                       t2powerup = true;
                                       cancel();
                                    }
                                 };
                              resetpowerupt2.scheduleAtFixedRate(t2reset,10000,10000);
                           }
                           
                           else if(pu[t].choice == 8){
                              t2.width = 30;
                              t2.height = 50;
                              t2.speed = 10;
                              t2 = pu[t].HackingSystem(t2);
                              t2powerup = false;
                           //t1reset.cancel();
                           }
                           if(numberoftanks == 4){
                              if(pu[t].choice == 7){
                                 t2.width = 30;
                                 t2.height = 50;
                                 t2.speed = 10;
                                 t2 = pu[t].TeamLink(t2,t3);
                              }
                           }
                           else if(pu[t].choice == 6){
                              t2.width = 30;
                              t2.height = 50;
                              t2.speed = 10;
                              t2 = pu[t].MiniTank(t2);
                              t2powerup = false;
                              Timer resetpowerupt2 =  new Timer();
                              TimerTask t2reset =
                                 new TimerTask() {
                                    public void run (){
                                       t2.posx = ((t2.posx-mazex)/100)*100+mazex + 30;
                                       t2.posy = ((t2.posy-mazey)/100)*100+mazey + 30;
                                       t2.width = 30;
                                       t2.height = 50;
                                       t2.speed = 10;
                                       t2powerup = true;
                                       t2.mini = false;
                                       cancel();
                                    }
                                 };
                              resetpowerupt2.scheduleAtFixedRate(t2reset,10000,10000);
                           }
                           draw.repaint();
                           PowerUps temp = pu [t];
                        
                           pu [t] = pu [current];
                           pu[t].x = pu[current].x ;
                           pu[t].y = pu[current].y;
                           pu[current] = pu [t];
                           current--;
                           draw.repaint();
                           System.out.println(current);
                        }
               }
               for(int t = 0; t < current+1; t++){
                  if(t3powerup)
                     if(current >=-1)
                        if(t3.gainpower (pu[t])){
                           System.out.println("t3 - power up gained");
                           pu[t].x = -1000;
                           pu[t].y = -1000;
                        //LMG for t3
                           if(pu[t].choice == 1){
                              t3.width = 30;
                              t3.height = 50;
                              t3.speed = 10;
                              t3 = pu[t].LMG(t3);
                              machinegunfiret3 = true;
                              t3powerup = false;
                              Timer resetbulletst3b =  new Timer();
                              normalfiret3 = false;
                              TimerTask t3breset =
                                 new TimerTask() {
                                    public void run (){
                                       machinegunfiret3 = false;
                                       normalfiret3 = true;
                                       t3powerup = true;
                                       cancel();
                                    }
                                 };
                              resetbulletst3b.scheduleAtFixedRate(t3breset,8000,8000);
                           }
                           
                           else if(pu[t].choice == 2){
                              t3.width = 30;
                              t3.height = 50;
                              t3.speed = 10;
                              t3 = pu[t].TripleShot(t3);
                              t3powerup = false;
                              normalfiret3 = false;
                              tripleshott3 = true;
                           }
                           //explosive shot for t3
                           else if(pu[t].choice == 3){
                              t3.width = 30;
                              t3.height = 50;
                              t3.speed = 10;
                              explosiveshott3 = true;
                              t3powerup = false;
                              normalfiret3 = false;
                           }
                           
                           else if(pu[t].choice == 4){
                              t3.width = 30;
                              t3.height = 50;
                              t3.speed = 10;
                              t3 = pu[t].LaserShot(t3);
                              t3powerup = false;
                              lazerfiret3= true;
                              normalfiret3 = false;
                           }
                           
                           else if(pu[t].choice == 5){
                              t3.width = 30;
                              t3.height = 50;
                              t3.speed = 10;
                              t3 = pu[t].Overdrive(t3);  
                           //t3reset.cancel();
                              t3powerup = false;
                              Timer resetpowerupt3 =  new Timer();
                              TimerTask t3reset =
                                 new TimerTask() {
                                    public void run (){
                                       t3.width = 30;
                                       t3.height = 50;
                                       t3.speed = 10;
                                       t3powerup = true;
                                       cancel();
                                    }
                                 };
                              resetpowerupt3.scheduleAtFixedRate(t3reset,10000,10000);
                           }
                           
                           else if(pu[t].choice == 8){
                              t3.width = 30;
                              t3.height = 50;
                              t3.speed = 10;
                              t3 = pu[t].HackingSystem(t3);
                              t3powerup = false;
                           //t3reset.cancel();
                           }
                           if(numberoftanks == 4){
                              if(pu[t].choice == 7){
                                 t3.width = 30;
                                 t3.height = 50;
                                 t3.speed = 10;
                                 t3 = pu[t].TeamLink(t3,t2);
                              }
                           }
                           else if(pu[t].choice == 6){
                              t3.width = 30;
                              t3.height = 50;
                              t3.speed = 10;
                              t3 = pu[t].MiniTank(t3);
                              t3powerup = false;
                              Timer resetpowerupt3 =  new Timer();
                              TimerTask t3reset =
                                 new TimerTask() {
                                    public void run (){
                                       t3.posx = ((t3.posx-mazex)/100)*100+mazex + 30;
                                       t3.posy = ((t3.posy-mazey)/100)*100+mazey + 30;
                                       t3.width = 30;
                                       t3.height = 50;
                                       t3.speed = 10;
                                       t3.mini = false;
                                       t3powerup = true;
                                       cancel();
                                    }
                                 };
                              resetpowerupt3.scheduleAtFixedRate(t3reset,10000,10000);
                           }
                           draw.repaint();
                           PowerUps temp = pu [t];
                        
                           pu [t] = pu [current];
                           pu[t].x = pu[current].x ;
                           pu[t].y = pu[current].y;
                           pu[current] = pu [t];
                           current--;
                           draw.repaint();
                           System.out.println(current);
                        }
               }                 
              
               for(int t = 0; t < current+1; t++){
                  if(t4powerup)
                     if(current >=-1)
                        if(t4.gainpower (pu[t])){
                           System.out.println("t4 - power up gained");
                           pu[t].x = -1000;
                           pu[t].y = -1000;
                        //LMG for t4
                           if(pu[t].choice == 1){
                              t4.width = 30;
                              t4.height = 50;
                              t4.speed = 10;
                              t4 = pu[t].LMG(t4);
                              machinegunfiret4 = true;
                              t4powerup = false;
                              Timer resetbulletst4b =  new Timer();
                              normalfiret4 = false;
                              TimerTask t4breset =
                                 new TimerTask() {
                                    public void run (){
                                       machinegunfiret4 = false;
                                       normalfiret4 = true;
                                       t4powerup = true;
                                       cancel();
                                    }
                                 };
                              resetbulletst4b.scheduleAtFixedRate(t4breset,8000,8000);
                           }
                           
                           else if(pu[t].choice == 2){
                              t4.width = 30;
                              t4.height = 50;
                              t4.speed = 10;
                              t4 = pu[t].TripleShot(t4);
                              t4powerup = false;
                              normalfiret4 = false;
                              tripleshott4 = true;
                           }
                           //explosive shot for t4
                           else if(pu[t].choice == 3){
                              t4.width = 30;
                              t4.height = 50;
                              t4.speed = 10;
                              explosiveshott4 = true;
                              t4powerup = false;
                              normalfiret4 = false;
                           }
                           
                           else if(pu[t].choice == 4){
                              t4.width = 30;
                              t4.height = 50;
                              t4.speed = 10;
                              t4 = pu[t].LaserShot(t4);
                              t4powerup = false;
                              lazerfiret4= true;
                              normalfiret4 = false;
                           }
                           
                           else if(pu[t].choice == 5){
                              t4.width = 30;
                              t4.height = 50;
                              t4.speed = 10;
                              t4 = pu[t].Overdrive(t4);  
                           //t4reset.cancel();
                              t4powerup = false;
                              Timer resetpowerupt4 =  new Timer();
                              TimerTask t4reset =
                                 new TimerTask() {
                                    public void run (){
                                       t4.width = 30;
                                       t4.height = 50;
                                       t4.speed = 10;
                                       t4powerup = true;
                                       cancel();
                                    }
                                 };
                              resetpowerupt4.scheduleAtFixedRate(t4reset,10000,10000);
                           }
                           
                           else if(pu[t].choice == 8){
                              t4.width = 30;
                              t4.height = 50;
                              t4.speed = 10;
                              t4 = pu[t].HackingSystem(t4);
                              t4powerup = false;
                           //t4reset.cancel();
                           }
                           if(numberoftanks == 4){
                              if(pu[t].choice == 7){
                                 t4.width = 30;
                                 t4.height = 50;
                                 t4.speed = 10;
                                 t4 = pu[t].TeamLink(t4,t1);
                              }
                           }
                           else if(pu[t].choice == 6){
                              t4.width = 30;
                              t4.height = 50;
                              t4.speed = 10;
                              t4 = pu[t].MiniTank(t4);
                              t4powerup = false;
                              Timer resetpowerupt4 =  new Timer();
                              TimerTask t4reset =
                                 new TimerTask() {
                                    public void run (){
                                       t4.posx = ((t4.posx-mazex)/100)*100+mazex + 30;
                                       t4.posy = ((t4.posy-mazey)/100)*100+mazey + 30;
                                       t4.width = 30;
                                       t4.height = 50;
                                       t4.speed = 10;
                                       t4.mini = false;
                                       t4powerup = true;
                                       cancel();
                                    }
                                 };
                              resetpowerupt4.scheduleAtFixedRate(t4reset,10000,10000);
                           }
                           draw.repaint();
                           PowerUps temp = pu [t];
                        
                           pu [t] = pu [current];
                           pu[t].x = pu[current].x ;
                           pu[t].y = pu[current].y;
                           pu[current] = pu [t];
                           current--;
                           draw.repaint();
                           System.out.println(current);
                        }
               }
            }
         }
         catch (InterruptedException e) {
         
         }
         catch (NullPointerException e) {
         
         }
         catch (ArrayIndexOutOfBoundsException e) {}
      }
   }
   int team1 = 0;
   int team2 = 0;
   Timer timer1 =  new Timer();
   TimerTask taskt1 =
      new TimerTask() {
      /*** run ************************************************************
      * Purpose: activates a timer to restart the game after tank dies    *                                                                        
      * Parameters: none                                                  *                                 
      * Returns: none                                                     *
      ********************************************************************/
         public void run (){
            gamedone = true;
            seteverything();
            teamtwopoints++;
            north = null;
            south = null;
            east = null;
            west = null;
            region = null;
            sizeX = 1000;
            sizeY = 1000;
            mazex = 10000;
            mazey = 10000;
            frame.dispose();
            if(teamtwopoints != playupto && teamonepoints != playupto)
               new CreateMaze(numberoftanks, teamonepoints, teamtwopoints, playupto);
            frame.setVisible(false);
            //draw.repaint();
            cancel();
         }
      };
   Timer timer2 =  new Timer();
   TimerTask taskt2 =
      new TimerTask() {
      /*** run ************************************************************
      * Purpose: activates a timer to restart the game after tank dies    *                                                                        
      * Parameters: none                                                  *                                 
      * Returns: none                                                     *
      ********************************************************************/
         public void run (){
            gamedone = true;
            seteverything();
            teamonepoints++;
            north = null;
            south = null;
            east = null;
            west = null;
            region = null;
            sizeX = 10000;
            sizeY = 10000;
            mazex = 10000;
            mazey = 10000;
            gamedone = true;
            frame.dispose();
            if(teamtwopoints != playupto && teamonepoints != playupto)
               new CreateMaze(numberoftanks, teamonepoints, teamtwopoints, playupto);
            frame.setVisible(false);
            generatemaze();
            cancel();
         }
      };
   Timer timer3 =  new Timer();
   TimerTask taskt3 =
      new TimerTask() {
      /*** run ************************************************************
      * Purpose: activates a timer to restart the game after tank dies    *                                                                        
      * Parameters: none                                                  *                                 
      * Returns: none                                                     *
      ********************************************************************/
         public void run (){
            gamedone = true;
            seteverything();
            teamonepoints++;
            gamedone = true;
            north = null;
            south = null;
            region = null;
            east = null;
            west = null;
            sizeX = 10000;
            sizeY = 10000;
            mazex = 10000;
            mazey = 1000;
            frame.dispose();
            if(teamtwopoints != playupto && teamonepoints != playupto)
               new CreateMaze(numberoftanks, teamonepoints, teamtwopoints, playupto);
            frame.setVisible(false);
            generatemaze();
            cancel();
         }
      };
     
   Timer timer4 =  new Timer();
   TimerTask taskt4 =
      new TimerTask() {
      /*** run ************************************************************
      * Purpose: activates a timer to restart the game after tank dies    *                                                                        
      * Parameters: none                                                  *                                 
      * Returns: none                                                     *
      ********************************************************************/
         public void run (){
            gamedone = true;
            seteverything();
            teamtwopoints++;
            gamedone = true;
            north = null;
            south = null;
            east = null;
            region = null;
            west = null;
            sizeX = 0;
            sizeY = 0;
            mazex = 0;
            mazey = 0;
            frame.dispose();
            if(teamtwopoints != playupto && teamonepoints != playupto)
               new CreateMaze(numberoftanks, teamonepoints, teamtwopoints, playupto);
            frame.setVisible(false);
            generatemaze();
            cancel();
         }
      };
   
   
     
     /*** throughwall ***********************************************************
  * Purpose: Tracks keys being clicked and performs actions based on clicks  *                                                                        
  * Parameters: none                                                         *                                 
  * Returns: none                                                            *
  ***************************************************************************/
   public boolean throughwall (Tank t1) {
      Tank temp = t1;
      boolean goingthroughwall = false;
      for(int g = 0; g<numpoints; g++){
         if(temp.throughwall.contains(collisionpointsx[g],collisionpointsy[g])){
            goingthroughwall = true;
         }
      }
     
      return goingthroughwall;
   }
  
  
    // *** BULLET CLASS ***
   class BulletTester {
   
      int bulletx = 0;
      int bullety = 0;
      int velx = 0;
      int vely = 0;
      int angle = 120;
      int diameterofbullet;
     
      int [] bulletpointsx = new int [4];
      int [] bulletpointsy = new int [4];
      int [] bulletangle = new int [2];
      int [] bulletcordinates = new int [2];
      boolean move = false;
      boolean biggerbullet = false;
      Polygon bullet = new Polygon (bulletpointsx, bulletpointsy,4);
     
      // Bullet Timer
      Timer t =  new Timer();
      TimerTask task =
         new TimerTask() {
         
                /*** run *******************************************************************
                * Purpose: Bullet will dissappear after 6 seconds                          *                                                                       
                * Parameters: none                                                         *
                * Returns: none                                                            *
                ***************************************************************************/
            public void run (){
               move = false;
               cancel();
            }
         };
   
      Keys check = new Keys();
   
      /*** BulletTester **********************************************************
   * Purpose: Tracks keys being clicked and performs actions based on clicks  *                                                                         
   * Parameters: buex - x bullet position,  buey - y bullet position           *
   *  ang - angle of the bullet shot,  width - width of the nose of the tank   *                                  
   * Returns: none                                                            *
   ***************************************************************************/
   
      public BulletTester (int buex, int buey, int ang, int width){
         check.start();
         angle = ang;
         bulletangle [0] = angle;
         bulletangle [1] = angle;
        
         bulletx = buex;
         bullety = buey;
        
         if(angle == 0){
            bulletx = buex;
            bullety = buey - 20;
         }
         else if(angle == 180) {
            bulletx = buex - width/3 - 3;
            bullety = buey + 15;
         }
         else if(angle == 270) {
            bulletx = buex - 15;
            bullety = buey  - width/3- 3;
         }
         diameterofbullet = width;
        
         keypress ();
      }
     
          /*** keypress **************************************************************
          * Purpose: Bullet timer starts and will last for 6 seconds                 *                                                                       
          * Parameters: none                                                         *
          * Returns: none                                                            *
          ***************************************************************************/
      public void keypress () {
         move = true;
         t.scheduleAtFixedRate(task,6000,6000);
         draw.repaint();            
      }
      
          /*** movebullet ************************************************************
          * Purpose: Tracks coordinates of bullets being shot and moving             *                                                                       
          * Parameters: none                                                         *
          * Returns: none                                                            *
          ***************************************************************************/
      public void movebullet() {
      
         if(!move){
            bulletx = -1000;
            bullety = -1000;
         }
        
         if(move) {
            numpoints = numpoints;
            bulletcordinates[0] = bulletx;
            bulletcordinates[1] = bullety;
            velx+=(10*Math.sin(Math.toRadians(bulletangle[0]))) - velx;
            vely+=(10*Math.cos(Math.toRadians(bulletangle[1]))) - vely;
         
            bulletpointsx [0] += (bulletx+velx)- bulletpointsx [0];
            bulletpointsx [1] = bulletpointsx [0]+ (diameterofbullet);
            bulletpointsx [2] = bulletpointsx [0] + (diameterofbullet);
            bulletpointsx [3] = bulletpointsx [0] ;
         
            bulletpointsy [0] += (bullety-vely) - bulletpointsy [0];
            bulletpointsy [1] = bulletpointsy [0];
            bulletpointsy [2] = bulletpointsy [0]  + (diameterofbullet);
            bulletpointsy [3] = bulletpointsy [0]  + (diameterofbullet);
         
            bullet = new Polygon (bulletpointsx, bulletpointsy,4);
         
            boolean collid = false;
         
            for(int u = 0; u < numpoints && !collid; u++){
               if (bullet.contains(collisionpointsx[u], collisionpointsy[u])){
                  if(verticaorhorizontal[u] == "h"){
                     collid = true;
                     if(bulletangle[0] + 180 > 360){
                        bulletangle[0] = bulletangle[0] - 180;
                     }
                     else
                        bulletangle[0] = bulletangle[0]+180;
                  }
                  else if(verticaorhorizontal[u] == "v"){
                     collid = true;
                     if(bulletangle[1] + 180 > 360){
                        bulletangle[1] = bulletangle[1] - 180;
                     }
                     else
                        bulletangle[1] = bulletangle[1]+180;
                  
                  }
               }
            }
         
            bulletx += (3*Math.sin(Math.toRadians(bulletangle[0])));
            bullety -= (3*Math.cos(Math.toRadians(bulletangle[1])));
         
         }
         draw.repaint();
      }
      
       // Key thread
      class Keys extends Thread {
      
            /*** run *******************************************************************
            * Purpose: Kills any tank that collides with a bullet                      *                                                                       
            * Parameters: none                                                         *
            * Returns: none                                                            *
            ***************************************************************************/
         public void run() {
            try{
               while(true){
                  if(teamonepoints >= playupto && teamtwopoints >= playupto){
                     playupto++;
                  }
                  else{
                     if (teamonepoints == playupto && once == false)
                     {
                        once = true;
                        frame.setVisible(false);
                        new RedTeamVictory(numberoftanks, teamonepoints, teamtwopoints);
                     }
                     if (teamtwopoints == playupto && once == false)
                     {
                        once = true;
                        frame.setVisible(false);
                        new BlueTeamVictory(numberoftanks,teamonepoints, teamtwopoints);
                     }
                  }
               
                  sleep(10);
                  if(move){
                     movebullet();
                  }
                  draw.repaint();
                  if(biggerbullet){
                     if(collidewithbullet (t1.collisionwe)){
                        move = false;
                        movebullet();
                        deadt1();
                     }
                     if(collidewithbullet (t2.collisionwe)){
                        move = false;
                        movebullet();
                        deadt2();                     
                     }
                     if(collidewithbullet (t3.collisionwe)){
                        move = false;
                        movebullet();
                        deadt3();
                     }
                     if(collidewithbullet (t4.collisionwe)){
                        move = false;
                        movebullet();
                        deadt4();
                     }
                  }
                  else{
                     if(collidewithbullet (t1.collisionwb)){
                        move = false;
                        movebullet();
                        deadt1 ();
                     }
                     if(collidewithbullet (t2.collisionwb)){
                        move = false;
                        movebullet();
                        deadt2 ();
                     
                     }
                     if(collidewithbullet (t3.collisionwb)){
                        move = false;
                        movebullet();
                        deadt3 ();
                     }
                     if(collidewithbullet (t4.collisionwb)){
                        move = false;
                        movebullet();
                        deadt4 ();
                     }
                  } 
               }
            }
            catch (InterruptedException e) {
            
            }
            catch (NullPointerException e) {
            
            }
            catch (ArrayIndexOutOfBoundsException e) {}
         }
      }
      
    /*** collidewithbullet******************************************************
       * Purpose: To check if polygons collide with bullets                       *                                                                         
       * Parameters: Polygon c - polygon used to detect if collision occured      *
       * Returns: collide - true if polygon collided with bullet                  *
                          - false if collided with bullet                         *
       ***************************************************************************/
      public boolean collidewithbullet (Polygon c){
         Polygon hit = c;
         boolean collide = false;
         if(move)
            for(int h = 0; h < 4; h++)
               if(hit.contains(bulletpointsx[h],bulletpointsy[h])){
                  collide = true;
               }
         return collide;
      }
   
   }
   
     /*** deadt1 ***************************************************************
       * Purpose: To make tank 1 not visible, add money to opposing team,         *
       *          and delay 3 seconds before restarting a new game                *                                                                         
       * Parameters: none                                                         *
       * Returns: none                                                            *
       ***************************************************************************/
   public void deadt1 (){
      t1.setVisible (false);
      team2++;
      if(numberoftanks == 4){
         if(team2 == 2){
         
            if(!death)
               timer1.scheduleAtFixedRate(taskt1,3000,3000);
            death = true;
         }
      }
      else {
         if(!death)
            timer1.scheduleAtFixedRate(taskt1,3000,3000);
         death = true;
      }
   }
  
    /*** deadt2 ****************************************************************
       * Purpose: To make tank 2 not visible, add money to opposing team,         *
       *          and delay 3 seconds before restarting a new game                *                                                                         
       * Parameters: none                                                         *
       * Returns: none                                                            *
       ***************************************************************************/
   public void deadt2 (){
      t2.setVisible (false);
      team1++;
      if(numberoftanks == 4){
         if(team1 == 2){
            if(!death)
               timer2.scheduleAtFixedRate(taskt2,3000,3000);
            death = true;
         }
      }
      else {
         if(!death)
            timer2.scheduleAtFixedRate(taskt2,3000,3000);
         death = true;
      }
   }
  
    /*** deadt3 ****************************************************************
       * Purpose: To make tank 3 not visible, add money to opposing team,         *
       *          and delay 3 seconds before restarting a new game                *                                                                         
       * Parameters: none                                                         *
       * Returns: none                                                            *
       ***************************************************************************/
   public void deadt3 (){
      t3.setVisible (false);
      team1++;
      if(numberoftanks == 4){
         if(team1 == 2){
            if(!death)
               timer3.scheduleAtFixedRate(taskt3,3000,3000);
            death = true;
         }
      }
      else {
         if(!death)
            timer3.scheduleAtFixedRate(taskt3,3000,3000);
         death = true;
      }     
   }
   
    /*** deadt4 ****************************************************************
       * Purpose: To make tank 4 not visible, add money to opposing team,         *
       *          and delay 3 seconds before restarting a new game                *                                                                         
       * Parameters: none                                                         *
       * Returns: none                                                            *
       ***************************************************************************/
   public void deadt4 (){
      t4.setVisible (false);
      team2++;
      if(numberoftanks == 4){
         if(team2 == 2){
            if(!death)
               timer4.scheduleAtFixedRate(taskt4,3000,3000);
            death = true;
         }
      }
      else {
         if(!death)
            timer4.scheduleAtFixedRate(taskt4,3000,3000);
         death = true;
      }
   }         
 
   int tt1 = 0;
   int tt2 = 0;
   int tt3 = 0;
   int tt4 = 0;
  
       /*** keyPressed ************************************************************
       * Purpose: moves all tanks based on what key is pressed                    *                                                                         
       * Parameters: keyEvent e                                                   *
       * Returns: none                                                            *
       ***************************************************************************/
   public void keyPressed(KeyEvent e) {
      try{
         int keyCode = e.getKeyCode();
      
         if(t1.isVisible &&!laserClickedt1){
            if( keyCode== KeyEvent.VK_UP ){
               t1upclick = true;
            }
            else if (keyCode == KeyEvent.VK_DOWN){
               t1downclick = true;
            }
            else if (keyCode == KeyEvent.VK_LEFT){
               t1leftclick = true;
            }
            else if (keyCode == KeyEvent.VK_RIGHT){
               t1rightclick = true;
            }
            else if (keyCode == KeyEvent.VK_M){
               int ang1 = t1.angle;
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
            
            // Tank 1 Laser ray
               if(lazerfiret1){
               
                  t1upclick = false;
                  t1downclick = false;
                  t1rightclick = false;
                  t1leftclick = false;
               
                  laserClickedt1 = true;
               
                  double startx1 = t1.nx[1] - 7.5*Math.cos(Math.toRadians(t1.angle));
                  double starty1 = t1.ny[1] - 7.5*Math.sin(Math.toRadians(t1.angle));
                  double startx2 = t1.nx[2] + 7.5*Math.cos(Math.toRadians(t1.angle));
                  double starty2 = t1.ny[2] + 7.5*Math.sin(Math.toRadians(t1.angle));
               
                  final int [] lazerx = {(int)startx1,(int)startx2,((int)((startx2)-(750)*Math.sin(Math.toRadians(ang1)))), (int)((startx1)-(750)*Math.sin(Math.toRadians(ang1)))};
                  final int [] lazery = {(int)starty1,(int)starty2,((int)((starty2)-(750)*Math.cos(Math.toRadians(ang1)))), (int)((starty1)-(750)*Math.cos(Math.toRadians(ang1)))};
                                
                  Timer lt1bfire =  new Timer();
                  TimerTask t1lazerfire =
                           new TimerTask() {
                              public void run(){
                                 lazert1 = new Polygon (lazerx, lazery, 4);
                                 for(int v = 0; v<8;v++){
                                    if(lazert1.contains(t2.nextmox[v], t2.nextmoy[v])){
                                       deadt2();
                                    }
                                    if(lazert1.contains(t3.nextmox[v], t3.nextmoy[v])){
                                       deadt3();
                                    }
                                    if(lazert1.contains(t4.nextmox[v], t4.nextmoy[v])){
                                       deadt4();
                                    }
                                 }
                                 draw.repaint();
                                 Timer lt1b =  new Timer();
                                 TimerTask t1lazer =
                                    new TimerTask() {
                                       public void run(){
                                          laserClickedt1 = false;
                                          lazert1 = new Polygon (reset, reset, 2);
                                          draw.repaint();
                                          t1powerup = true;
                                          normalfiret1 = true;
                                          cancel();
                                       }
                                    };
                                 lt1b.scheduleAtFixedRate(t1lazer,2000,2000);
                                 cancel();
                              }
                           };
                          
                  lazerfiret1 = false;
                  lt1bfire.scheduleAtFixedRate(t1lazerfire,2000,2000);
               }
               else if(!throughwall(t1)){
                  if(normalfiret1) {
                     boolean reload = false;
                     if(numberofbulletst1 == 5){
                        if(t1b [0].move == false)
                           reload = true;
                     }
                     if(reload){
                        BulletTester [] temp = new BulletTester [1000];
                        for(int i = 0; i<4; i++){
                           temp [i] = t1b[i+1];
                        }
                        numberofbulletst1--;
                        totalnumberofbullets--;
                        t1b = temp;
                     }
                     if(numberofbulletst1 < 5){
                        t1b [numberofbulletst1]= new BulletTester (t1.nx[1], t1.ny[1], t1.angle, t1.bulletdiamter);
                        numberofbulletst1++;
                        totalnumberofbullets++;
                     }
                     if(t1.mini){
                        t1b [numberofbulletst1].bulletx -= (int) (5*Math.sin(Math.toRadians(ang1)));
                        t1b [numberofbulletst1].bullety -= (int) (5*Math.cos(Math.toRadians(ang1)));
                     }
                  }
                  else if (tripleshott1){
                     int startx1 = t1.nx[1]-(int)(10*Math.cos(Math.toRadians(t1.angle)));
                     int starty1 = t1.ny[1]-(int)(10*Math.sin(Math.toRadians(t1.angle)));
                     int startx2 = t1.nx[1]+(int)(10*Math.cos(Math.toRadians(t1.angle)));
                     int starty2 = t1.ny[1]+(int)(10*Math.sin(Math.toRadians(t1.angle)));
                  
                     triplet1[numberoftriplebulletst1] = new BulletTester (t1.nx[1], t1.ny[1], t1.angle, t1.bulletdiamter);
                     triplet1[numberoftriplebulletst1+1] = new BulletTester (startx1-(int)(10*Math.sin(Math.toRadians(t1.angle))),(starty1-(int)(10*Math.cos(Math.toRadians(ang1)))), t1.angle, t1.bulletdiamter);
                     triplet1[numberoftriplebulletst1+2] = new BulletTester (startx2-(int)(10*Math.sin(Math.toRadians(t1.angle))),(starty2-(int)(10*Math.cos(Math.toRadians(ang1)))), t1.angle, t1.bulletdiamter);
                     triplet1[numberoftriplebulletst1].biggerbullet = true;
                     triplet1[numberoftriplebulletst1+1].biggerbullet = true;
                     triplet1[numberoftriplebulletst1+2].biggerbullet = true;
                     numberoftriplebulletst1 +=3;
                     tt1 +=3;
                     System.out.println(numberoftriplebulletst1);
                     draw.repaint();
                     if(tt1+3 > 6){
                        t1powerup = true;
                        normalfiret1 = true;
                        tripleshott1 = false;
                        tt1 = 0;
                     }
                  }
                  else if(machinegunfiret1){
                     machinegunt1[machinegunbulletst1]= new BulletTester (t1.nx[1], t1.ny[1], t1.angle, t1.bulletdiamter);
                     machinegunt1[machinegunbulletst1].diameterofbullet = t1.width/6;
                     machinegunt1[machinegunbulletst1].bulletx += t1.width/6;
                     machinegunbulletst1++;
                  }
                  else if(explosiveshott1){
                     explosionshott1 = new BulletTester (t1.nextmovex[1] - (int) (25*Math.sin(Math.toRadians(ang1))), t1.nextmovey[1] - (int) (25*Math.cos(Math.toRadians(ang1))), t1.angle, t1.bulletdiamter);
                     explosionshott1.diameterofbullet = 2*t1.width/3;
                     explosionshott1.bulletx -= t1.width/6;
                     explosionshott1.biggerbullet = true;
                     explosiveshott1 = false;
                     Timer bulletexplodet1b =  new Timer();
                     TimerTask t1bexplode =
                           new TimerTask() {
                              public void run (){
                                 int x1horx = explosionshott1.bulletx+150;
                                 int x2horx = explosionshott1.bulletx-150;
                                 int y1vet = explosionshott1.bullety+150 ;
                                 int y2vet = explosionshott1.bullety-150;
                                 int [] explosionx = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosiony = {y1vet,y1vet,y2vet,y2vet};
                                 explosion = new Polygon (explosionx,explosiony,4);
                                
                                 for(int b = 0; b<collisionpointsx.length;b++){
                                    if(explosion.contains(collisionpointsx[b],collisionpointsy[b])){
                                       if(verticaorhorizontal[b].equals("h")){
                                          if(collisionpointsx[b] < explosionshott1.bulletx){
                                             x2horx = collisionpointsx[b];
                                          }
                                          else{
                                             x1horx = collisionpointsx[b];
                                          }
                                       }
                                       if(verticaorhorizontal[b].equals("v")){
                                          if(collisionpointsy[b] < explosionshott1.bullety){
                                             y2vet = collisionpointsy[b];
                                          }
                                          else{
                                             y1vet = collisionpointsy[b];
                                          }
                                       }
                                    }
                                 }
                                
                                 int [] explosion1x = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosion1y = {y1vet,y1vet,y2vet,y2vet};
                                 explosionx = explosion1x;
                                 explosiony = explosion1y;
                                
                                 explosion = new Polygon (explosionx,explosiony,4);
                              
                                 for(int g =0; g<8;g++){
                                    if(explosion.contains(t1.nextmox[g], t1.nextmoy[g])){
                                       deadt1();
                                    }
                                    if(explosion.contains(t2.nextmox[g], t2.nextmoy[g])){
                                       deadt2();
                                    }
                                    if(explosion.contains(t3.nextmox[g], t3.nextmoy[g])){
                                       deadt3();
                                    }
                                    if(explosion.contains(t4.nextmox[g], t4.nextmoy[g])){
                                       deadt4();
                                    }
                                 }
                                 explosiont1 = true;
                                 bulletexplosionxt1 = ((explosionshott1.bulletx-mazex)/100)*100 +mazex + 25;
                                 bulletexplosionyt1 = ((explosionshott1.bullety-mazey)/100)*100 +mazey + 25;
                                 Timer lasert1 =  new Timer();
                                 TimerTask laser3t1 =
                                    new TimerTask() {
                                       public void run (){
                                          bulletexplosionxt1 = -1000;
                                          bulletexplosionyt1 = -1000;
                                          cancel();
                                       }
                                    };
                                 lasert1.scheduleAtFixedRate(laser3t1,1500,1500);
                                 explosiveshott1 = false;
                                 t1powerup = true; 
                                 draw.repaint();
                                 explosion = null;
                                 explosionx = null;
                                 explosiony = null;
                                 explosiont1 = false;
                                 explosiveshott1 = false;
                                 explosionshott1.bulletx = - 1000;
                                 explosionshott1.bullety = - 1000;
                                 explosionshott1 = new BulletTester (0,0,30,0);
                                 normalfiret1 = true;
                                 draw.repaint();
                                 cancel();
                              }
                           };
                     bulletexplodet1b.scheduleAtFixedRate(t1bexplode,4000,4000);
                  }
               }
               else if(!lazerfiret1)
                  deadt1();
               draw.repaint();
            
            }
         }
      
      // Tank 2 movement
         if(t2.isVisible && !laserClickedt2 && !aicod){
            if( keyCode== KeyEvent.VK_W){
               t2upclick = true;
            }
            else if (keyCode == KeyEvent.VK_S){
               t2downclick = true;
            }
            else if (keyCode == KeyEvent.VK_A){
               t2leftclick = true;
            }
            else if (keyCode == KeyEvent.VK_D){
               t2rightclick = true;
            }
            else if (keyCode == KeyEvent.VK_Q){
               int ang1 = t2.angle;
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
            
            // Tank 2 Laser ray
               if(lazerfiret2){
               
                  t2upclick = false;
                  t2downclick = false;
                  t2rightclick = false;
                  t2leftclick = false;
               
                  laserClickedt2 = true;
               
                  double startx1 = t2.nx[1] - 7.5*Math.cos(Math.toRadians(t2.angle));
                  double starty1 = t2.ny[1] - 7.5*Math.sin(Math.toRadians(t2.angle));
                  double startx2 = t2.nx[2] + 7.5*Math.cos(Math.toRadians(t2.angle));
                  double starty2 = t2.ny[2] + 7.5*Math.sin(Math.toRadians(t2.angle));
               
                  final int [] lazerx = {(int)startx1,(int)startx2,((int)((startx2)-(750)*Math.sin(Math.toRadians(ang1)))), (int)((startx1)-(750)*Math.sin(Math.toRadians(ang1)))};
                  final int [] lazery = {(int)starty1,(int)starty2,((int)((starty2)-(750)*Math.cos(Math.toRadians(ang1)))), (int)((starty1)-(750)*Math.cos(Math.toRadians(ang1)))};
                                
                  Timer lt2bfire =  new Timer();
                  TimerTask t2lazerfire =
                           new TimerTask() {
                              public void run(){
                                 lazert2 = new Polygon (lazerx, lazery, 4);
                                 for(int v = 0; v<8;v++){
                                    if(lazert2.contains(t1.nextmox[v], t1.nextmoy[v])){
                                       deadt1();
                                    }
                                    if(lazert2.contains(t3.nextmox[v], t3.nextmoy[v])){
                                       deadt3();
                                    }
                                    if(lazert2.contains(t4.nextmox[v], t4.nextmoy[v])){
                                       deadt4();
                                    }
                                 }
                                 draw.repaint();
                                 Timer lt2b =  new Timer();
                                 TimerTask t1lazer =
                                    new TimerTask() {
                                       public void run(){
                                          laserClickedt2 = false;
                                          lazert2 = new Polygon (reset, reset, 2);
                                          draw.repaint();
                                          t2powerup = true;
                                          normalfiret2 = true;
                                          cancel();
                                       }
                                    };
                                 lt2b.scheduleAtFixedRate(t1lazer,2000,2000);
                                 cancel();
                              }
                           };
                          
                  lazerfiret2 = false;
                  lt2bfire.scheduleAtFixedRate(t2lazerfire,2000,2000);
               }
               
               else if(!throughwall(t2)){
                  if(normalfiret2) {
                     boolean reload = false;
                     if(numberofbulletst2 == 5){
                        if(t2b [0].move == false)
                           reload = true;
                     }
                     if(reload){
                        BulletTester [] temp = new BulletTester [1000];
                        for(int i = 0; i<4; i++){
                           temp [i] = t2b[i+1];
                        }
                        numberofbulletst2--;
                        totalnumberofbullets--;
                        t2b = temp;
                     }
                     if(numberofbulletst2 < 5){
                        t2b [numberofbulletst2]= new BulletTester (t2.nx[1], t2.ny[1], t2.angle, t2.bulletdiamter);
                     
                        numberofbulletst2++;
                        totalnumberofbullets++;
                     }
                     if(t2.mini){
                        t2b [numberofbulletst2].bulletx -= (int) (5*Math.sin(Math.toRadians(ang1)));
                        t2b [numberofbulletst2].bullety -= (int) (5*Math.cos(Math.toRadians(ang1)));
                     }
                  }
                  else if (tripleshott2){
                     int startx1 = t2.nx[1]-(int)(10*Math.cos(Math.toRadians(t2.angle)));
                     int starty1 = t2.ny[1]-(int)(10*Math.sin(Math.toRadians(t2.angle)));
                     int startx2 = t2.nx[1]+(int)(10*Math.cos(Math.toRadians(t2.angle)));
                     int starty2 = t2.ny[1]+(int)(10*Math.sin(Math.toRadians(t2.angle)));
                     triplet2[numberoftriplebulletst2] = new BulletTester (t2.nx[1], t2.ny[1], t2.angle, t2.bulletdiamter);
                     triplet2[numberoftriplebulletst2+1] = new BulletTester (startx1-(int)(10*Math.sin(Math.toRadians(t2.angle))),(starty1-(int)(10*Math.cos(Math.toRadians(ang1)))), t2.angle, t2.bulletdiamter);
                     triplet2[numberoftriplebulletst2+2] = new BulletTester (startx2-(int)(10*Math.sin(Math.toRadians(t2.angle))),(starty2-(int)(10*Math.cos(Math.toRadians(ang1)))), t2.angle, t2.bulletdiamter);
                     triplet2[numberoftriplebulletst2].biggerbullet = true;
                     triplet2[numberoftriplebulletst2+1].biggerbullet = true;
                     triplet2[numberoftriplebulletst2+2].biggerbullet = true;
                     numberoftriplebulletst2 +=3;
                     tt2 +=3;
                     draw.repaint();
                     if(tt2+3 > 6){
                        t2powerup = true;
                        normalfiret2 = true;
                        tripleshott2 = false;
                        tt2 =0;
                     }
                  }
                  else if(machinegunfiret2){
                     machinegunt2[machinegunbulletst2]= new BulletTester (t2.nx[1], t2.ny[1], t2.angle, t2.bulletdiamter);
                     machinegunt2[machinegunbulletst2].diameterofbullet = t2.width/6;
                     machinegunt2[machinegunbulletst2].bulletx += t2.width/6;
                     machinegunbulletst2++;
                  }
                  else if(explosiveshott2){
                     explosionshott2 = new BulletTester (t2.nextmovex[1] - (int) (25*Math.sin(Math.toRadians(ang1))), t2.nextmovey[1] - (int) (25*Math.cos(Math.toRadians(ang1))), t2.angle, t2.bulletdiamter);
                     explosionshott2.diameterofbullet = 2*t2.width/3;
                     explosionshott2.bulletx -= t2.width/6;
                     explosionshott2.biggerbullet = true;
                     explosiveshott2 = false;
                     Timer bulletexplodet2b =  new Timer();
                     TimerTask t2bexplode =
                           new TimerTask() {
                              public void run (){
                                 int x1horx = explosionshott2.bulletx+150;
                                 int x2horx = explosionshott2.bulletx-150;
                                 int y1vet = explosionshott2.bullety+150 ;
                                 int y2vet = explosionshott2.bullety-150;
                                 int [] explosionx = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosiony = {y1vet,y1vet,y2vet,y2vet};
                                 explosion2 = new Polygon (explosionx,explosiony,4);
                                
                                 for(int b = 0; b<collisionpointsx.length;b++){
                                    if(explosion2.contains(collisionpointsx[b],collisionpointsy[b])){
                                       if(verticaorhorizontal[b].equals("h")){
                                          if(collisionpointsx[b] < explosionshott2.bulletx){
                                             x2horx = collisionpointsx[b];
                                          }
                                          else{
                                             x1horx = collisionpointsx[b];
                                          }
                                       }
                                       if(verticaorhorizontal[b].equals("v")){
                                          if(collisionpointsy[b] < explosionshott2.bullety){
                                             y2vet = collisionpointsy[b];
                                          }
                                          else{
                                             y1vet = collisionpointsy[b];
                                          }
                                       }
                                    }
                                 }
                                
                                 int [] explosion2x = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosion2y = {y1vet,y1vet,y2vet,y2vet};
                                 explosionx = explosion2x;
                                 explosiony = explosion2y;
                                
                                 explosion2 = new Polygon (explosionx,explosiony,4);
                              
                                 for(int g =0; g<8;g++){
                                    if(explosion2.contains(t1.nextmox[g], t1.nextmoy[g])){
                                       deadt1();
                                    }
                                    if(explosion2.contains(t2.nextmox[g], t2.nextmoy[g])){
                                       deadt2();
                                    }
                                    if(explosion2.contains(t3.nextmox[g], t3.nextmoy[g])){
                                       deadt3();
                                    }
                                    if(explosion2.contains(t4.nextmox[g], t4.nextmoy[g])){
                                       deadt4();
                                    }
                                 }
                                 explosiont2 = true;
                                 Timer lasert1 =  new Timer();
                                 TimerTask laser3t1 =
                                    new TimerTask() {
                                       public void run (){
                                          bulletexplosionxt2 = -1000;
                                          bulletexplosionyt2 = -1000;
                                          cancel();
                                       }
                                    };
                                 lasert1.scheduleAtFixedRate(laser3t1,1500,1500);
                                 explosiveshott2 = false;
                                 t2powerup = true; 
                                 bulletexplosionxt2 = ((explosionshott2.bulletx-mazex)/100)*100 +mazex + 25;
                                 bulletexplosionyt2 = ((explosionshott2.bullety-mazey)/100)*100 +mazey + 25;
                                 draw.repaint();
                                 explosion = null;
                                 explosionx = null;
                                 explosiony = null;
                                 explosiont2 = false;
                                 explosiveshott2 = false;
                                 explosionshott2.bulletx = - 1000;
                                 explosionshott2.bullety = - 1000;
                                 explosionshott2 = new BulletTester (0,0,30,0);
                                 normalfiret2 = true;
                                 draw.repaint();
                                 cancel();
                              }
                           };
                     bulletexplodet2b.scheduleAtFixedRate(t2bexplode,4000,4000);
                  }
                  draw.repaint();
               }
               else if(!lazerfiret2)
                  deadt2(); 
               draw.repaint();
              
            }
         }
      
      // Tank 3 movement
         if(t3.isVisible && !laserClickedt3){
            if( keyCode== KeyEvent.VK_Y){
               t3upclick = true;
            }
            else if (keyCode == KeyEvent.VK_H){
               t3downclick = true;
            }
            else if (keyCode == KeyEvent.VK_G){
               t3leftclick = true;
            }
            else if (keyCode == KeyEvent.VK_J){
               t3rightclick = true;
            }
            else if (keyCode == KeyEvent.VK_T){
               int ang1 = t3.angle;
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
            
            // Tank 3 Laser ray
               if(lazerfiret3){
               
                  t3upclick = false;
                  t3downclick = false;
                  t3rightclick = false;
                  t3leftclick = false;
               
                  laserClickedt3 = true;
               
                  double startx1 = t3.nx[1] - 7.5*Math.cos(Math.toRadians(t3.angle));
                  double starty1 = t3.ny[1] - 7.5*Math.sin(Math.toRadians(t3.angle));
                  double startx2 = t3.nx[2] + 7.5*Math.cos(Math.toRadians(t3.angle));
                  double starty2 = t3.ny[2] + 7.5*Math.sin(Math.toRadians(t3.angle));
               
                  final int [] lazerx = {(int)startx1,(int)startx2,((int)((startx2)-(750)*Math.sin(Math.toRadians(ang1)))), (int)((startx1)-(750)*Math.sin(Math.toRadians(ang1)))};
                  final int [] lazery = {(int)starty1,(int)starty2,((int)((starty2)-(750)*Math.cos(Math.toRadians(ang1)))), (int)((starty1)-(750)*Math.cos(Math.toRadians(ang1)))};
                                
                  Timer lt3bfire =  new Timer();
                  TimerTask t3lazerfire =
                           new TimerTask() {
                              public void run(){
                                 lazert3 = new Polygon (lazerx, lazery, 4);
                                 for(int v = 0; v<8;v++){
                                    if(lazert3.contains(t1.nextmox[v], t1.nextmoy[v])){
                                       deadt1();
                                    }
                                    if(lazert3.contains(t2.nextmox[v], t2.nextmoy[v])){
                                       deadt2();
                                    }
                                    if(lazert3.contains(t4.nextmox[v], t4.nextmoy[v])){
                                       deadt4();
                                    }
                                 }
                                 draw.repaint();
                                 Timer lt3b =  new Timer();
                                 TimerTask t3lazer =
                                    new TimerTask() {
                                       public void run(){
                                          laserClickedt3 = false;
                                          lazert3 = new Polygon (reset, reset, 2);
                                          draw.repaint();
                                          t3powerup = true;
                                          normalfiret3 = true;
                                          cancel();
                                       }
                                    };
                                 lt3b.scheduleAtFixedRate(t3lazer,2000,2000);
                                 cancel();
                              }
                           };
                          
                  lazerfiret3 = false;
                  lt3bfire.scheduleAtFixedRate(t3lazerfire,2000,2000);
               }
               
               else if(!throughwall(t3)){
                  if(normalfiret3) {
                     boolean reload = false;
                     if(numberofbulletst3 == 5){
                        if(t3b [0].move == false)
                           reload = true;
                     }
                     if(reload){
                        BulletTester [] temp = new BulletTester [1000];
                        for(int i = 0; i<4; i++){
                           temp [i] = t3b[i+1];
                        }
                        numberofbulletst3--;
                        totalnumberofbullets--;
                        t3b = temp;
                     }
                     if(numberofbulletst3 < 5){
                        t3b [numberofbulletst3]= new BulletTester (t3.nx[1], t3.ny[1], t3.angle, t3.bulletdiamter);
                        numberofbulletst3++;
                        totalnumberofbullets++;
                     }
                     if(t3.mini){
                        t3b [numberofbulletst3].bulletx -= (int) (5*Math.sin(Math.toRadians(ang1)));
                        t3b [numberofbulletst3].bullety -= (int) (5*Math.cos(Math.toRadians(ang1)));
                     }
                  }
                  else if (tripleshott3){
                     int startx1 = t3.nx[1]-(int)(10*Math.cos(Math.toRadians(t3.angle)));
                     int starty1 = t3.ny[1]-(int)(10*Math.sin(Math.toRadians(t3.angle)));
                     int startx2 = t3.nx[1]+(int)(10*Math.cos(Math.toRadians(t3.angle)));
                     int starty2 = t3.ny[1]+(int)(10*Math.sin(Math.toRadians(t3.angle)));
                  
                     triplet3[numberoftriplebulletst3] = new BulletTester (t3.nx[1], t3.ny[1], t3.angle, t3.bulletdiamter);
                     triplet3[numberoftriplebulletst3+1] = new BulletTester (startx1-(int)(10*Math.sin(Math.toRadians(t3.angle))),(starty1-(int)(10*Math.cos(Math.toRadians(ang1)))), t3.angle, t3.bulletdiamter);
                     triplet3[numberoftriplebulletst3+2] = new BulletTester (startx2-(int)(10*Math.sin(Math.toRadians(t3.angle))),(starty2-(int)(10*Math.cos(Math.toRadians(ang1)))), t3.angle, t3.bulletdiamter);
                     triplet3[numberoftriplebulletst3].biggerbullet = true;
                     triplet3[numberoftriplebulletst3+1].biggerbullet = true;
                     triplet3[numberoftriplebulletst3+2].biggerbullet = true;
                     numberoftriplebulletst3 +=3;
                     tt3 +=3;
                     draw.repaint();
                     if(tt3+3 > 6){
                        t3powerup = true;
                        normalfiret3 = true;
                        tripleshott3 = false;
                        tt3 = 0;
                     }
                  }
                  else if(machinegunfiret3){
                     machinegunt3[machinegunbulletst3]= new BulletTester (t3.nx[1], t3.ny[1], t3.angle, t3.bulletdiamter);
                     machinegunt3[machinegunbulletst3].diameterofbullet = t3.width/6;
                     machinegunt3[machinegunbulletst3].bulletx += t3.width/6;
                     machinegunbulletst3++;
                  }
                  else if(explosiveshott3){
                     explosionshott3 = new BulletTester (t3.nextmovex[1] - (int) (25*Math.sin(Math.toRadians(ang1))), t3.nextmovey[1] - (int) (25*Math.cos(Math.toRadians(ang1))), t3.angle, t3.bulletdiamter);
                     explosionshott3.diameterofbullet = 2*t3.width/3;
                     explosionshott3.bulletx -= t3.width/6;
                     explosionshott3.biggerbullet = true;
                     explosiveshott3 = false;
                     Timer bulletexplodet3b =  new Timer();
                     TimerTask t3bexplode =
                           new TimerTask() {
                              public void run (){
                                 int x1horx = explosionshott3.bulletx+150;
                                 int x2horx = explosionshott3.bulletx-150;
                                 int y1vet = explosionshott3.bullety+150 ;
                                 int y2vet = explosionshott3.bullety-150;
                                 int [] explosionx = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosiony = {y1vet,y1vet,y2vet,y2vet};
                                 explosion3 = new Polygon (explosionx,explosiony,4);
                                
                                 for(int b = 0; b<collisionpointsx.length;b++){
                                    if(explosion3.contains(collisionpointsx[b],collisionpointsy[b])){
                                       if(verticaorhorizontal[b].equals("h")){
                                          if(collisionpointsx[b] < explosionshott3.bulletx){
                                             x2horx = collisionpointsx[b];
                                          }
                                          
                                          else{
                                             x1horx = collisionpointsx[b];
                                          }
                                       }
                                       if(verticaorhorizontal[b].equals("v")){
                                          if(collisionpointsy[b] < explosionshott3.bullety){
                                             y2vet = collisionpointsy[b];
                                          }
                                          else{
                                             y1vet = collisionpointsy[b];
                                          }
                                       }
                                    }
                                 }
                                
                                 int [] explosion3x = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosion3y = {y1vet,y1vet,y2vet,y2vet};
                                 explosionx = explosion3x;
                                 explosiony = explosion3y;
                                
                                 explosion3 = new Polygon (explosionx,explosiony,4);
                              
                                 for(int g =0; g<8;g++){
                                    if(explosion3.contains(t1.nextmox[g], t1.nextmoy[g])){
                                       deadt1();
                                    }
                                    if(explosion3.contains(t2.nextmox[g], t2.nextmoy[g])){
                                       deadt2();
                                    }
                                    if(explosion3.contains(t3.nextmox[g], t3.nextmoy[g])){
                                       deadt3();
                                    }
                                    if(explosion3.contains(t4.nextmox[g], t4.nextmoy[g])){
                                       deadt4();
                                    }
                                 }
                                 explosiont3 = true;
                                 Timer lasert1 =  new Timer();
                                 TimerTask laser3t1 =
                                    new TimerTask() {
                                       public void run (){
                                          bulletexplosionxt3 = -1000;
                                          bulletexplosionyt3 = -1000;
                                          cancel();
                                       }
                                    };
                                 lasert1.scheduleAtFixedRate(laser3t1,1500,1500);
                                 explosiveshott3 = false;
                                 t3powerup = true; 
                                 bulletexplosionxt3 = ((explosionshott3.bulletx-mazex)/100)*100 +mazex + 25;
                                 bulletexplosionyt3 = ((explosionshott3.bullety-mazey)/100)*100 +mazey + 25;
                                 draw.repaint();
                                 explosion = null;
                                 explosionx = null;
                                 explosiony = null;
                                 explosiont3 = false;
                                 explosiveshott3 = false;
                                 explosionshott3.bulletx = - 1000;
                                 explosionshott3.bullety = - 1000;
                                 explosionshott3 = new BulletTester (0,0,30,0);
                                 normalfiret3 = true;
                                 draw.repaint();
                                 cancel();
                              }
                           };
                     bulletexplodet3b.scheduleAtFixedRate(t3bexplode,4000,4000);
                  }
                  draw.repaint();   
               }
               else if(!lazerfiret3)
                  deadt3();
               draw.repaint();
            }
         }
         if(t4.isVisible &&!laserClickedt4){
            if( keyCode== KeyEvent.VK_NUMPAD8){
               t4upclick = true;
            }
            else if (keyCode == KeyEvent.VK_NUMPAD5){
               t4downclick = true;
            }
            else if (keyCode == KeyEvent.VK_NUMPAD4){
               t4leftclick = true;
            }
            else if (keyCode == KeyEvent.VK_NUMPAD6){
               t4rightclick = true;
            }
            else if (keyCode == KeyEvent.VK_NUMPAD7){
               int ang1 = t4.angle;
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
            
            // Tank 4 Laser ray
               if(lazerfiret4){
               
                  t4upclick = false;
                  t4downclick = false;
                  t4rightclick = false;
                  t4leftclick = false;
               
                  laserClickedt4 = true;
               
                  double startx1 = t4.nx[1] - 7.5*Math.cos(Math.toRadians(t4.angle));
                  double starty1 = t4.ny[1] - 7.5*Math.sin(Math.toRadians(t4.angle));
                  double startx2 = t4.nx[2] + 7.5*Math.cos(Math.toRadians(t4.angle));
                  double starty2 = t4.ny[2] + 7.5*Math.sin(Math.toRadians(t4.angle));
               
                  final int [] lazerx = {(int)startx1,(int)startx2,((int)((startx2)-(750)*Math.sin(Math.toRadians(ang1)))), (int)((startx1)-(750)*Math.sin(Math.toRadians(ang1)))};
                  final int [] lazery = {(int)starty1,(int)starty2,((int)((starty2)-(750)*Math.cos(Math.toRadians(ang1)))), (int)((starty1)-(750)*Math.cos(Math.toRadians(ang1)))};
                                
                  Timer lt4bfire =  new Timer();
                  TimerTask t4lazerfire =
                           new TimerTask() {
                              public void run(){
                                 lazert4 = new Polygon (lazerx, lazery, 4);
                                 for(int v = 0; v<8;v++){
                                    if(lazert4.contains(t1.nextmox[v], t1.nextmoy[v])){
                                       deadt1();
                                    }
                                    if(lazert4.contains(t2.nextmox[v], t2.nextmoy[v])){
                                       deadt2();
                                    }
                                    if(lazert4.contains(t3.nextmox[v], t3.nextmoy[v])){
                                       deadt3();
                                    }
                                 }
                                 draw.repaint();
                                 Timer lt4b =  new Timer();
                                 TimerTask t4lazer =
                                    new TimerTask() {
                                       public void run(){
                                          laserClickedt4 = false;
                                          lazert4 = new Polygon (reset, reset, 2);
                                          draw.repaint();
                                          t4powerup = true;
                                          normalfiret4 = true;
                                          cancel();
                                       }
                                    };
                                 lt4b.scheduleAtFixedRate(t4lazer,2000,2000);
                                 cancel();
                              }
                           };
                          
                  lazerfiret4 = false;
                  lt4bfire.scheduleAtFixedRate(t4lazerfire,2000,2000);
               }
               
               else if(!throughwall(t4)){
                  if(normalfiret4) {
                     boolean reload = false;
                     if(numberofbulletst4 == 5){
                        if(t4b [0].move == false)
                           reload = true;
                     }
                     if(reload){
                        BulletTester [] temp = new BulletTester [1000];
                        for(int i = 0; i<4; i++){
                           temp [i] = t4b[i+1];
                        }
                        numberofbulletst4--;
                        totalnumberofbullets--;
                        t4b = temp;
                     }
                     if(numberofbulletst4 < 5){
                        t4b [numberofbulletst4]= new BulletTester (t4.nx[1], t4.ny[1], t4.angle, t4.bulletdiamter);
                        numberofbulletst4++;
                        totalnumberofbullets++;
                     }
                     if(t4.mini){
                        t4b [numberofbulletst4].bulletx -= (int) (5*Math.sin(Math.toRadians(ang1)));
                        t4b [numberofbulletst4].bullety -= (int) (5*Math.cos(Math.toRadians(ang1)));
                     }
                  }
                  else if (tripleshott4){
                     int startx1 = t4.nx[1]-(int)(10*Math.cos(Math.toRadians(t4.angle)));
                     int starty1 = t4.ny[1]-(int)(10*Math.sin(Math.toRadians(t4.angle)));
                     int startx2 = t4.nx[1]+(int)(10*Math.cos(Math.toRadians(t4.angle)));
                     int starty2 = t4.ny[1]+(int)(10*Math.sin(Math.toRadians(t4.angle)));
                  
                     triplet4[numberoftriplebulletst4] = new BulletTester (t4.nx[1], t4.ny[1], t4.angle, t4.bulletdiamter);
                     triplet4[numberoftriplebulletst4+1] = new BulletTester (startx1-(int)(10*Math.sin(Math.toRadians(t4.angle))),(starty1-(int)(10*Math.cos(Math.toRadians(ang1)))), t4.angle, t4.bulletdiamter);
                     triplet4[numberoftriplebulletst4+2] = new BulletTester (startx2-(int)(10*Math.sin(Math.toRadians(t4.angle))),(starty2-(int)(10*Math.cos(Math.toRadians(ang1)))), t4.angle, t4.bulletdiamter);
                     triplet4[numberoftriplebulletst4].biggerbullet = true;
                     triplet4[numberoftriplebulletst4+1].biggerbullet = true;
                     triplet4[numberoftriplebulletst4+2].biggerbullet = true;
                     numberoftriplebulletst4 +=3;
                     tt4 +=3;
                     draw.repaint();
                     if(tt4+3 > 6){
                        t4powerup = true;
                        normalfiret4 = true;
                        tripleshott4 = false;
                        tt4 = 0;
                     }
                  }
                  else if(machinegunfiret4){
                     machinegunt4[machinegunbulletst4]= new BulletTester (t4.nx[1], t4.ny[1], t4.angle, t4.bulletdiamter);
                     machinegunt4[machinegunbulletst4].diameterofbullet = t4.width/6;
                     machinegunt4[machinegunbulletst4].bulletx += t4.width/6;
                     machinegunbulletst4++;
                  }
                  else if(explosiveshott4){
                     explosionshott4 = new BulletTester (t4.nextmovex[1] - (int) (25*Math.sin(Math.toRadians(ang1))), t4.nextmovey[1] - (int) (25*Math.cos(Math.toRadians(ang1))), t4.angle, t4.bulletdiamter);
                     explosionshott4.diameterofbullet = 2*t4.width/3;
                     explosionshott4.bulletx -= t4.width/6;
                     explosionshott4.biggerbullet = true;
                     explosiveshott4 = false;
                     Timer bulletexplodet4b =  new Timer();
                     TimerTask t4bexplode =
                           new TimerTask() {
                              public void run (){
                                 int x1horx = explosionshott4.bulletx+150;
                                 int x2horx = explosionshott4.bulletx-150;
                                 int y1vet = explosionshott4.bullety+150 ;
                                 int y2vet = explosionshott4.bullety-150;
                                 int [] explosionx = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosiony = {y1vet,y1vet,y2vet,y2vet};
                                 explosion4 = new Polygon (explosionx,explosiony,4);
                                
                                 for(int b = 0; b<collisionpointsx.length;b++){
                                    if(explosion4.contains(collisionpointsx[b],collisionpointsy[b])){
                                       if(verticaorhorizontal[b].equals("h")){
                                          if(collisionpointsx[b] < explosionshott4.bulletx){
                                             x2horx = collisionpointsx[b];
                                          }
                                          else{
                                             x1horx = collisionpointsx[b];
                                          }
                                       }
                                       if(verticaorhorizontal[b].equals("v")){
                                          if(collisionpointsy[b] < explosionshott4.bullety){
                                             y2vet = collisionpointsy[b];
                                          }
                                          else{
                                             y1vet = collisionpointsy[b];
                                          }
                                       }
                                    }
                                 }
                                
                                 int [] explosion4x = {x1horx,x2horx,x2horx,x1horx};
                                 int [] explosion4y = {y1vet,y1vet,y2vet,y2vet};
                                 explosionx = explosion4x;
                                 explosiony = explosion4y;
                                
                                 explosion4 = new Polygon (explosionx,explosiony,4);
                              
                                 for(int g =0; g<8;g++){
                                    if(explosion4.contains(t1.nextmox[g], t1.nextmoy[g])){
                                       deadt1();
                                    }
                                    if(explosion4.contains(t2.nextmox[g], t2.nextmoy[g])){
                                       deadt2();
                                    }
                                    if(explosion4.contains(t3.nextmox[g], t3.nextmoy[g])){
                                       deadt3();
                                    }
                                    if(explosion4.contains(t4.nextmox[g], t4.nextmoy[g])){
                                       deadt4();
                                    }
                                 }
                                 explosiont4 = true;
                                 Timer lasert1 =  new Timer();
                                 TimerTask laser3t1 =
                                    new TimerTask() {
                                       public void run (){
                                          bulletexplosionxt4 = -1000;
                                          bulletexplosionyt4 = -1000;
                                          cancel();
                                       }
                                    };
                                 lasert1.scheduleAtFixedRate(laser3t1,1500,1500);
                                 explosiveshott4 = false;
                                 t4powerup = true; 
                                 bulletexplosionxt4 = ((explosionshott4.bulletx-mazex)/100)*100 +mazex + 25;
                                 bulletexplosionyt4 = ((explosionshott4.bullety-mazey)/100)*100 +mazey + 25;
                                 draw.repaint();
                                 explosion = null;
                                 explosionx = null;
                                 explosiony = null;
                                 explosiont4 = false;
                                 explosiveshott4 = false;
                                 explosionshott4.bulletx = - 1000;
                                 explosionshott4.bullety = - 1000;
                                 explosionshott4 = new BulletTester (0,0,30,0);
                                 normalfiret4 = true;
                                 draw.repaint();
                                 cancel();
                              }
                           };
                     bulletexplodet4b.scheduleAtFixedRate(t4bexplode,4000,4000);
                  }
                  draw.repaint();
               }
               else if(!lazerfiret4)
                  deadt4();
               draw.repaint();
            }
         }
         //to get catch statments 
      }//https://www.tutorialspoint.com/How-to-handle-Java-Array-Index-Out-of-Bounds-Exception 
      catch (NullPointerException t) {
         
      }
      catch (ArrayIndexOutOfBoundsException t) {}
   }             /*** keyTyped **************************************************************
   * Purpose: unused                                                          *                                                                        
   * Parameters: none                                                         *                                  
   * Returns: none                                                            *
   ***************************************************************************/
   public void keyTyped(KeyEvent e){}
   
      /*** keyReleased ***********************************************************
   * Purpose: when key is released then change boolean to false               *                                                                        
   * Parameters: e - monitors key activity                                    *                                  
   * Returns: none                                                            *
   ***************************************************************************/
   public void keyReleased(KeyEvent e){
      int keyCode = e.getKeyCode();
      if( keyCode== KeyEvent.VK_UP &&t1upclick){
         t1upclick = false;
      }
      else if (keyCode == KeyEvent.VK_DOWN &&t1downclick){
         t1downclick = false;
      }
      else if (keyCode == KeyEvent.VK_LEFT &&t1leftclick){
         t1leftclick = false;
      }
      else if (keyCode == KeyEvent.VK_RIGHT &&t1rightclick){
         t1rightclick = false;
      } 
      else if( keyCode== KeyEvent.VK_W &&t2upclick){
         t2upclick = false;
      }
      else if (keyCode == KeyEvent.VK_S &&t2downclick){
         t2downclick = false;
      }
      else if (keyCode == KeyEvent.VK_A &&t2leftclick){
         t2leftclick = false;
      }
      else if (keyCode == KeyEvent.VK_D &&t2rightclick){
         t2rightclick = false;
      }
      else if( keyCode== KeyEvent.VK_Y &&t3upclick){
         t3upclick = false;
      }
      else if (keyCode == KeyEvent.VK_H &&t3downclick){
         t3downclick = false;
      }
      else if (keyCode == KeyEvent.VK_G &&t3leftclick){
         t3leftclick = false;
      }
      else if (keyCode == KeyEvent.VK_J &&t3rightclick){
         t3rightclick = false;
      }
      else if( keyCode== KeyEvent.VK_NUMPAD8 &&t4upclick){
         t4upclick = false;
      }
      else if (keyCode == KeyEvent.VK_NUMPAD5 &&t4downclick){
         t4downclick = false;
      }
      else if (keyCode == KeyEvent.VK_NUMPAD4 &&t4leftclick){
         t4leftclick = false;
      }
      else if (keyCode == KeyEvent.VK_NUMPAD6 &&t4rightclick){
         t4rightclick = false;
      }
   }
}
