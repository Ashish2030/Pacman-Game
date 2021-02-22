import java.awt.Font;
import java.awt.event.KeyEvent;
import java.applet.Applet;
import java.lang.Math;
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.*;
class pacman
{
static int a,b,c,d,score=0,flag=0,h,b1, x=0,flag11=10,heighscore=0;
 static  char[][] array=new char [30][30];
  static boolean gameover=true;
  static  String playername,highscoreplayername;
  static int row,col,e;
  static int arr[]=new int [4];
  static int k=0;
  static int x1,x2,x3,x4,y1,y2,y3,y4;
static   long timeToSleep = 1000L;
static  TimeUnit time = TimeUnit.MILLISECONDS;
  static char u;
  static int p;
  static int quit=1;
//-------------------------------------------------------- clear screen----------------------------------------------------------------------
public static void cls()
    {
	    try
        {
		    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception E)
		{
			System.out.println(E);
		}
    }

//-------------------------------------------------------- array ----------------------------------------------------------------------
 public  void makearray()
{
       for(int i=0;i<30;i++)
         {
        for(int j=0;j<30;j++)
        {
           array[i][j]='*';
        }
        }
    //-------------------------------------------------------border----------------------------------------------------------------------------------------
         for(int i=0;i<30;i++)
        {
        array[i][0]='|';
        array[i][29]='|';
        }
        for(int j=0;j<30;j++)
        {
        array[29][j]='=';
        array[0][j]='=';
       }
    //-------------------------------------------------------border----------------------------------------------------------------------------------------       //-------------------------------------------------------WALL----------------------------------------------------------------------------------------
    array[22][1]='W';
       array[22][2]='W';
         array[22][3]='W';
        array[22][4]='W';
        array[22][5]='W';
       array[22][6]='W';
       array[22][7]='W';
       array[22][8]='W';

         array[22][9]='W';
         array[16][9]='W';
           array[17][9]='W';
          array[18][9]='W';
            array[19][9]='W';
                array[20][9]='W';
                array[21][9]='W';
               array[22][9]='W';
              array[5][1]='W';
                   array[5][2]='W';
                 array[5][3]='W';
                     array[5][4]='W';
                        array[5][5]='W';
                           array[5][6]='W';
                           array[5][7]='W';
                           array[6][7]='W';
                          array[7][7]='W';
                         array[8][7]='W';
                     array[9][7]='W';
                        array[25][18]='W';
                       array[24][18]='W';
                               array[23][18]='W';
                          array[22][18]='W';
                         array[21][18]='W';
                           array[20][18]='W';
                             array[19][18]='W';
                           array[18][18]='W';
                              array[17][18]='W';
                        array[16][18]='W';
                            array[16][19]='W';
                             array[16][20]='W';
                             array[16][21]='W';
                              array[16][22]='W';
                             array[16][23]='W';
                             array[16][24]='W';
                              array[3][18]='W';
                             array[4][18]='W';
                             array[5][18]='W';
                             array[6][18]='W';
                                array[7][18]='W';
                              array[8][18]='W';
                            array[9][18]='W';
                               array[9][19]='W';
                         array[9][20]='W';
                           array[9][21]='W';
                          array[9][22]='W';
                            array[9][23]='W';
                        array[9][24]='W';
                        array[21][13]='W';
                          array[20][13]='W';
                            array[19][13]='W';
                              array[18][13]='W';
                                array[17][13]='W';

                        array[16][13]='W';
                        array[16][14]='W';
                          array[16][15]='W';
                            array[15][15]='W';
                              array[14][15]='W';
                              array[13][15]='W';
                              array[12][15]='W';
                              array[11][15]='W';
                              array[12][1]='W';
                                array[12][2]='W';
                                  array[12][3]='W';
                                    array[12][4]='W';
                                      array[12][5]='W';
                                        array[12][6]='W';
                                        array[13][6]='W';
                                          array[14][6]='W';
                                            array[15][6]='W';
                                              array[16][6]='W';
                                                array[17][6]='W';
                                  array[26][25]='W';
                                      array[25][25]='W';
                                          array[24][25]='W';
                                              array[23][25]='W';
                                              array[22][25]='W';
                                                array[21][25]='W';
                                                array[2][11]='W';
                                                  array[3][11]='W';
                                                    array[4][11]='W';
                                                      array[5][11]='W';
                                                        array[6][11]='W';
                                                          array[7][11]='W';
                                                            array[7][12]='W';
                                                              array[7][13]='W';
                                                                array[7][14]='W';
                                                                  array[7][15]='W';
                                                                    array[27][11]='W';
                                                                        array[27][12]='W';
                                                                            array[27][13]='W';
                                                                                array[27][14]='W';
                                                                                    array[27][15]='W';
                                                                                        array[27][16]='W';
                                                                                          array[26][16]='W';
                                                                                            array[25][16]='W';
                                                                                              array[24][16]='W';
                                                                                                array[23][16]='W';
  //------------------------------------------------------------------------------------WALL----------------------------------------------------------------------
}
static void print1()
{
  cls();
   System.out.println();
    System.out.println();
     System.out.println();
      System.out.println();
       System.out.println();
        System.out.println();
 for (int i = 29; i >=0; i--)
              {

                  System.out.print("\t\t\t\t\t");
              for (int j = 0; j < array[i].length; j++)
               {
               System.out.print(array[i][j]+" ");
               }
             System.out.println();
             }

}
//-------------------------------------------------------------------------------------------------input-------------------------------------------------------------
public static  void input()
{
Scanner sc=new Scanner(System.in);
 e=sc.nextLine().charAt(0);
switch(e)
{
  case 'a':
  {
    flag=1;
    break;
  }
  case 'A':
  {
    flag=1;
    break;
  }
  case 's':
  {
    flag=2;
    break;
  }
  case 'S':
  {
    flag=2;
    break;
  }
  case 'w':
  {
    flag=3;
    break;
  }
  case 'W':
  {
    flag=3;
    break;
  }

  case 'd':
  {
    flag=4;
    break;
  }
  case 'D':
  {
    flag=4;
    break;
  }
  case 'Q':
  {
    quit=0;
    break;
  }
  case 'q':
  {
quit=0;
    break;
  }
  case 'p':
  {
    flag11=1;
    break;
  }
  case 'P':
  {
    flag11=1;
    break;
  }
  case 'R':
  {
    flag11=0;
    break;
  }
  case 'r':
  {
    flag11=0;
    break;
  }
  default :
  {
     break;
  }
}
}
//--------------------------------------------------------------------------fruit--------------------------------------------------------------------------
static  void enemy1()
{
 a=rollDice();
 b=rollDice();
if(array[a][b]!='W'||array[a][b]!='F'||array[a][b]!='@'||array[a][b]!='E')
{
array[a][b]='E';
x1=a;
y1=b;
}
else
{
enemy1();
}
}
static  void enemy2()
{
 a=rollDice();
 b=rollDice();
if(array[a][b]!='W'||array[a][b]!='F'||array[a][b]!='@'||array[a][b]!='E')
{
array[a][b]='E';
x2=a;
y2=b;
}
else
{
enemy2();
}
}
static  void enemy3()
{
 a=rollDice();
 b=rollDice();
if(array[a][b]!='W'||array[a][b]!='F'||array[a][b]!='@'||array[a][b]!='E')
{
array[a][b]='E';
x3=a;
y3=b;
}
else
{
enemy3();
}
}
static  void enemy4()
{
 a=rollDice();
 b=rollDice();
if(array[a][b]!='W'||array[a][b]!='F'||array[a][b]!='@'||array[a][b]!='E')
{
array[a][b]='E';
x4=a;
y4=b;
}
else
{
enemy4();
}
}


//-----------------------------------------------------------------------------------------logic----------------------------------------------------------------------------------
public static void logic()
{
  try
  {
  if (flag==1)
  {
    for (int i = 29; i >=0; i--)
      {
        for (int j = 0; j < array[i].length; j++)
            {
                  if(array[i][j]=='@')
                  {
                    row=i;
                    col=j;
                  }
              }
  }
if(array[row][col-1]=='E')
{
  System.out.println("GAMEOVER");

gameover=false;

}
if((array[row][col-1]!='W')&&(array[row][col-1]!='|'))
{
  if(array[row][col-1]=='*')
  {
    score++;
  }
  if(array[row][col-1]=='F')
  {
    score=score+5;
    fruit();
  }
  array[row][col-1]='@';
  array[row][col]=' ';

}
}
//-------------------------------------------------------------------------
else if(flag==2)
{
  for (int i = 29; i >=0; i--)
    {
      for (int j = 0; j < array[i].length; j++)
          {
                if(array[i][j]=='@')
                {
                  row=i;
                  col=j;
                }
            }
}
if(array[row-1][col-1]=='E')
{
  System.out.println("GAMEOVER");
    time.sleep(timeToSleep);
gameover=false;

}

if((array[row-1][col]!='W')&&(array[row-1][col]!='='))
{
  if(array[row-1][col]=='*')
  {
    score++;
  }
  if(array[row-1][col]=='F')
  {
    score=score+5;
    fruit();
  }
array[row-1][col]='@';
array[row][col]=' ';
}

}
else if(flag==3)
{
  for (int i = 29; i >=0; i--)
    {
      for (int j = 0; j < array[i].length; j++)
          {
                if(array[i][j]=='@')
                {
                  row=i;
                  col=j;
                }
            }
}
if(array[row+1][col]=='E')
{
  System.out.println("GAMEOVER");
    time.sleep(timeToSleep);
gameover=false;

}
if((array[row+1][col]!='W')&&(array[row+1][col]!='='))
{
  if(array[row+1][col]=='*')
  {
    score++;
  }
  if(array[row+1][col]=='F')
  {
    score=score+5;
    fruit();
  }
array[row+1][col]='@';
array[row][col]=' ';
}
}
else if(flag==4)
{
  for (int i = 29; i >=0; i--)
    {
      for (int j = 0; j < array[i].length; j++)
          {
                if(array[i][j]=='@')
                {
                  row=i;
                  col=j;
                }
            }
}
if(array[row][col+1]=='E')
{
  System.out.println("GAMEOVER");
    time.sleep(timeToSleep);
gameover=false;

}
if((array[row][col+1]!='W')&&(array[row][col+1]!='|'))
{
  if(array[row][col+1]=='*')
  {
    score++;
  }
  if(array[row][col+1]=='F')
  {
    score=score+5;
    fruit();
  }
array[row][col+1]='@';
array[row][col]=' ';
}
}
else
{

}
}
catch(Exception e)
{

}
}
//-------------------------------------------------------------------------random for ememy-----------------------------------------------------------------------------------
static int random1()
 {
 int range,min,max,rand;
 min = 0;
 max = 1;
 range = max-min+1;
 rand = (int)(Math.random()*range)+min;
 return rand;
  }
//---------------------------------------------------------------random function--------------------------------------------------------------------
       static int rollDice()
        {
        int range,min,max,rand;
        min = 1;
        max = 28;
        range = max-min+1;
        rand = (int)(Math.random()*range)+min;
        return rand;
         }
         //------------------------------------------------------------------------------------------head---------------------------------------------------------------
         static  void head()
         {
          a=rollDice();
          b=rollDice();
         if(array[a][b]!='W'||array[a][b]!='@'||array[a][b]!='F')
         {
         array[a][b]='@';
         }
         else
         {
         head();
         }
         }
         //-----------------------------------------------------------------------logic1------------------------------------------------------------
         static void logic1()
         {
           for (int i = 29; i >=0; i--)
                {
                  for (int j = 0; j < array[i].length; j++)
                      {
                        if(array[i][j]=='E')
                        {
                          int a=random1();
                          if(a==1)
                          {
                            flag=1;
                            arr[k++]=flag;
                          }
                          else
                          {
                            flag=2;
                            arr[k++]=flag;
                          }
                        }
                      }
                    }
          }
          //____________________________________________________________________________________________
          static  void fruit()
          {
           a=rollDice();
           b=rollDice();
          if(array[a][b]!='W')
          {
          array[a][b]='F';
          }
          else
          {
          fruit();
          }
          }
//--------------------------------------------------
    static  void loop()
    {
      input();
      if(flag11==1)
      {
        loop();
      }

    }
public static void main(String arg[])
{

  Scanner sc=new Scanner (System.in);
System.out.println("Name :");
playername=sc.nextLine();
  try
  {
    FileInputStream fin1=new  FileInputStream(".snake_high_score.dat");
    BufferedReader bf1=new BufferedReader(new FileReader("snake_player.dat"));
    heighscore=fin1.read();
    highscoreplayername=bf1.readLine();
  fin1.close();
  bf1.close();
  }
  catch(Exception e)
  {
  heighscore=0;
  highscoreplayername=" ";
  }
  pacman a=new pacman();
  a.makearray();
  a.head();
  fruit();
  fruit();
  fruit();
  fruit();
  fruit();
  enemy1();
  enemy2();
  enemy3();
  enemy4();
  a.logic1();
  a.print1();
  System.out.println("score = "+score);
   System.out.println("heighscore = "+heighscore);
    System.out.println("High_scorername :"+highscoreplayername);

try
{
  while(gameover)
  {
    flag=0;
  a.input();
if(flag11==1)
{
  x=1;
  System.out.println("You Pause the game");
  loop();
}
if(x==1)
{

if(flag11==0)
{
  System.out.println("You resume the game");
  flag11=10;
  x=0;
  time.sleep(timeToSleep);
}
}
  if(quit==0)
  {
    System.out.println("You quit the game");
      time.sleep(timeToSleep);
    break;
  }
  a.logic();
  if(gameover==false)
  {
    System.out.println("GAMEOVER");
      time.sleep(timeToSleep);
    try
    {
      FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
      FileWriter fw1=new FileWriter("snake_player.dat",false);
      BufferedWriter bf1=new BufferedWriter(fw1);
 if(score>heighscore)
 {
   fout1.write(score);
   bf1.write(playername);
 }
 else
 {
     fout1.write(heighscore);
     bf1.write(highscoreplayername);

 }
 fout1.close();
 bf1.close();
    }
    catch(Exception e)
    {
    System.out.println("Error");
    }

    break;
  }
  for(int i=0;i<4;i++)
  {
    if(i==0)
    {

      if(arr[i]==1)
      {
        if(array[x1][y1+1]=='@')
        {
          System.out.println("GAMEOVER");
          try
          {
            FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
            FileWriter fw1=new FileWriter("snake_player.dat",false);
            BufferedWriter bf1=new BufferedWriter(fw1);
       if(score>heighscore)
       {
         fout1.write(score);
         bf1.write(playername);
       }
       else
       {
           fout1.write(heighscore);
           bf1.write(highscoreplayername);

       }
       fout1.close();
       bf1.close();
          }
          catch(Exception e)
          {
          System.out.println("Error");
          }
          gameover=false;
     break;
        }
         else if((array[x1][y1+1]=='W')||(array[x1][y1+1]=='|')||(array[x1][y1+1]=='E'))
        {

          u=array[x1][y1-1];
          array[x1][y1-1]='E';
          array[x1][y1]=u;
          y1=y1-1;
            arr[i]=3;

        }
        else if((array[x1][y1+1]=='F')&&((array[x1][y1+2]==' ')||(array[x1][y1+2]=='*')))
        {
          u=array[x1][y1+2];
          array[x1][y1+2]='E';
          array[x1][y1]=u;
          y1=y1+2;
        }
        else if((array[x1][y1+1]=='F')&&((array[x1][y1+2]!=' '||array[x1][y1+2]!='*')))
        {
          arr[i]=3;
          u=array[x1][y1-1];
          array[x1][y1-1]='E';
          array[x1][y1]=u;
          y1=y1-1;
        }
        else if((array[x1][y1+1]!='W')||(array[x1][y1+1]!='|')||(array[x1][y1+1]!='E')||  (array[x1][y1+1]!='F'))
        {
          u=array[x1][y1+1];
          array[x1][y1+1]='E';
          array[x1][y1]=u;
          y1=y1+1;
        }
      else
      {

      }
    }
    else if(arr[i]==3)
    {
      if(array[x1][y1-1]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
      if(score>heighscore)
      {
       fout1.write(score);
       bf1.write(playername);
      }
      else
      {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

      }
      fout1.close();
      bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
      break;
      }

      else if((array[x1][y1-1]=='W')||(array[x1][y1-1]=='|')||(array[x1][y1-1]=='E'))
      {

        u=array[x1][y1+1];
        array[x1][y1+1]='E';
        array[x1][y1]=u;
        y1=y1+1;
          arr[i]=1;
      }
      else if((array[x1][y1-1]=='F')&&((array[x1][y1-2]==' '||array[x1][y1-2]=='*')))
      {
        u=array[x1][y1-2];
        array[x1][y1-2]='E';
        array[x1][y1]=u;
        y1=y1-2;
      }
      else if((array[x1][y1-1]=='F')&&((array[x1][y1-2]!=' '||array[x1][y1-2]!='*')))
      {
        arr[i]=1;
        u=array[x1][y1+1];
        array[x1][y1+1]='E';
        array[x1][y1]=u;
        y1=y1+1;
      }
    else  if((array[x1][y1-1]!='W')||(array[x1][y1-1]!='|')||(array[x1][y1-1]!='E')||  (array[x1][y1-1]!='F'))
      {
        u=array[x1][y1-1];
        array[x1][y1-1]='E';
        array[x1][y1]=u;
        y1=y1-1;
      }


    else
    {

    }
    }
    else if(arr[i]==2)
    {
      if(array[x1-1][y1]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
      if(score>heighscore)
      {
       fout1.write(score);
       bf1.write(playername);
      }
      else
      {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

      }
      fout1.close();
      bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
      break;
      }
    else   if(array[x1-1][y1]=='W'||array[x1-1][y1]=='='||array[x1-1][y1]=='E')
      {

        u=array[x1+1][y1];
        array[x1+1][y1]='E';
        array[x1][y1]=u;
        x1=x1+1;
          arr[i]=4;
      }
      else if((array[x1-1][y1]=='F')&&((array[x1-2][y1]==' '||array[x1-2][y1]=='*')))
      {
        u=array[x1-2][y1];
        array[x1-2][y1]='E';
        array[x1][y1]=u;
        x1=x1-2;
      }
      else if((array[x1-1][y1]=='F')&&((array[x1-2][y1]!=' '||array[x1-2][y1]!='*')))
      {
        arr[i]=4;
        u=array[x1+1][y1];
        array[x1+1][y1]='E';
        array[x1][y1]=u;
        x1=x1+1;
      }
      else if(array[x1-1][y1]!='W'||array[x1-1][y1]!='|'||array[x1-1][y1]!='E'||  array[x1-1][y1]!='F')
      {
        u=array[x1-1][y1];
        array[x1-1][y1]='E';
        array[x1][y1]=u;
        x1=x1-1;
      }



    else
    {

    }
    }
else if(arr[i]==4)
{
gameover=false;
  if(array[x1+1][y1]=='@')
  {
    System.out.println("GAMEOVER");
      time.sleep(timeToSleep);
    try
    {
      FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
      FileWriter fw1=new FileWriter("snake_player.dat",false);
      BufferedWriter bf1=new BufferedWriter(fw1);
  if(score>heighscore)
  {
   fout1.write(score);
   bf1.write(playername);
  }
  else
  {
     fout1.write(heighscore);
     bf1.write(highscoreplayername);

  }
  fout1.close();
  bf1.close();
    }
    catch(Exception e)
    {
    System.out.println("Error");
    }
    gameover=false;
  break;
  }
  else if(array[x1+1][y1]=='W'||array[x1+1][y1]=='='||array[x1+1][y1]=='E')
  {
    arr[i]=2;
    u=array[x1-1][y1];
    array[x1-1][y1]='E';
    array[x1][y1]=u;
    x1=x1-1;
  }
  else if((array[x1+1][y1]=='F')&&((array[x1+2][y1]==' '||array[x1+2][y1]=='*')))
  {
    u=array[x1+2][y1];
    array[x1+2][y1]='E';
    array[x1][y1]=u;
    x1=x1+2;
  }
  else if((array[x1+1][y1]=='F')&&((array[x1+2][y1]!=' '||array[x1+2][y1]!='*')))
  {
    arr[i]=4;
    u=array[x1-1][y1];
    array[x1-1][y1]='E';
    array[x1][y1]=u;
    x1=x1-1;
  }
  else if(array[x1+1][y1]!='W'||array[x1+1][y1]!='|'||array[x1+1][y1]!='E'||  array[x1+1][y1]!='F')
  {
    u=array[x1+1][y1];
    array[x1+1][y1]='E';
    array[x1][y1]=u;
    x1=x1+1;
  }
  else
  {

  }
}
else
{

}
  }
  else   if(i==1)
    {
      if(arr[i]==1)
      {
        if(array[x2][y2+1]=='@')
        {
          System.out.println("GAMEOVER");
            time.sleep(timeToSleep);
          try
          {
            FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
            FileWriter fw1=new FileWriter("snake_player.dat",false);
            BufferedWriter bf1=new BufferedWriter(fw1);
       if(score>heighscore)
       {
         fout1.write(score);
         bf1.write(playername);
       }
       else
       {
           fout1.write(heighscore);
           bf1.write(highscoreplayername);

       }
       fout1.close();
       bf1.close();
          }
          catch(Exception e)
          {
          System.out.println("Error");
          }
          gameover=false;
     break;
   }
        else  if((array[x2][y2+1]=='W')||(array[x2][y2+1]=='|')||(array[x2][y2+1]=='E'))
        {

          u=array[x2][y2-1];
          array[x2][y2-1]='E';
          array[x2][y2]=u;
          y2=y2-1;
            arr[i]=3;

        }
        else if((array[x2][y2+1]=='F')&&((array[x2][y2+2]==' ')||(array[x2][y2+2]=='*')))
        {
          u=array[x2][y2+2];
          array[x2][y2+2]='E';
          array[x2][y2]=u;
          y2=y2+2;
        }
        else if((array[x2][y2+1]=='F')&&((array[x2][y2+2]!=' '||array[x2][y2+2]!='*')))
        {
          arr[i]=3;
          u=array[x2][y2-1];
          array[x2][y2-1]='E';
          array[x2][y2]=u;
          y2=y2-1;
        }
        else if((array[x2][y2+1]!='W')||(array[x2][y2+1]!='|')||(array[x2][y2+1]!='E')||  (array[x2][y2+1]!='F'))
        {
          u=array[x2][y2+1];
          array[x2][y2+1]='E';
          array[x2][y2]=u;
          y2=y2+1;
        }
      else
      {

      }
    }
    else if(arr[i]==3)
    {
      if(array[x2][y2-1]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
     if(score>heighscore)
     {
       fout1.write(score);
       bf1.write(playername);
     }
     else
     {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

     }
     fout1.close();
     bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
   break;
 }
      else if((array[x2][y2-1]=='W')||(array[x2][y2-1]=='|')||(array[x2][y2-1]=='E'))
      {

        u=array[x2][y2+1];
        array[x2][y2+1]='E';
        array[x2][y2]=u;
        y2=y2+1;
          arr[i]=1;
      }
      else if((array[x2][y2-1]=='F')&&((array[x2][y2-2]==' '||array[x2][y2-2]=='*')))
      {
        u=array[x2][y2-2];
        array[x2][y2-2]='E';
        array[x2][y2]=u;
        y2=y2-2;
      }
      else if((array[x2][y2-1]=='F')&&((array[x2][y2-2]!=' '||array[x2][y2-2]!='*')))
      {
        arr[i]=1;
        u=array[x2][y2+1];
        array[x2][y2+1]='E';
        array[x2][y2]=u;
        y2=y2+1;
      }
    else  if((array[x2][y2-1]!='W')||(array[x2][y2-1]!='|')||(array[x2][y2-1]!='E')||  (array[x2][y2-1]!='F'))
      {
        u=array[x2][y2-1];
        array[x2][y2-1]='E';
        array[x2][y2]=u;
        y2=y2-1;
      }


    else
    {

    }
    }
    else if(arr[i]==2)
    {
      if(array[x2-1][y2]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
     if(score>heighscore)
     {
       fout1.write(score);
       bf1.write(playername);
     }
     else
     {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

     }
     fout1.close();
     bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
   break;
 }
      else if(array[x2-1][y2]=='W'||array[x2-1][y2]=='='||array[x2-1][y2]=='E')
      {

        u=array[x2+1][y2];
        array[x2+1][y2]='E';
        array[x2][y2]=u;
        x2=x2+1;
          arr[i]=4;
      }
      else if((array[x2-1][y2]=='F')&&((array[x2-2][y2]==' '||array[x2-2][y2]=='*')))
      {
        u=array[x2-2][y2];
        array[x2-2][y2]='E';
        array[x2][y2]=u;
        x2=x2-2;
      }
      else if((array[x2-1][y2]=='F')&&((array[x2-2][y2]!=' '||array[x2-2][y2]!='*')))
      {
        arr[i]=4;
        u=array[x2+1][y2];
        array[x2+1][y2]='E';
        array[x2][y2]=u;
        x2=x2+1;
      }
      else if(array[x2-1][y2]!='W'||array[x2-1][y2]!='|'||array[x2-1][y2]!='E'||  array[x2-1][y2]!='F')
      {
        u=array[x2-1][y2];
        array[x2-1][y2]='E';
        array[x2][y2]=u;
        x2=x2-1;
      }



    else
    {

    }
    }
else if(arr[i]==4)
{
  if(array[x2+1][y2]=='@')
  {
    System.out.println("GAMEOVER");
      time.sleep(timeToSleep);
    try
    {
      FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
      FileWriter fw1=new FileWriter("snake_player.dat",false);
      BufferedWriter bf1=new BufferedWriter(fw1);
 if(score>heighscore)
 {
   fout1.write(score);
   bf1.write(playername);
 }
 else
 {
     fout1.write(heighscore);
     bf1.write(highscoreplayername);

 }
 fout1.close();
 bf1.close();
    }
    catch(Exception e)
    {
    System.out.println("Error");
    }
    gameover=false;
break;
}
  else if(array[x2+1][y2]=='W'||array[x2+1][y2]=='='||array[x2+1][y2]=='E')
  {
    arr[i]=2;
    u=array[x2-1][y2];
    array[x2-1][y2]='E';
    array[x2][y2]=u;
    x2=x2-1;
  }
  else if((array[x2+1][y2]=='F')&&((array[x2+2][y2]==' '||array[x2+2][y2]=='*')))
  {
    u=array[x2+2][y2];
    array[x2+2][y2]='E';
    array[x2][y2]=u;
    x2=x2+2;
  }
  else if((array[x2+1][y2]=='F')&&((array[x2+2][y2]!=' '||array[x2+2][y2]!='*')))
  {
    arr[i]=4;
    u=array[x2-1][y2];
    array[x2-1][y2]='E';
    array[x2][y2]=u;
    x2=x2-1;
  }
  else if(array[x2+1][y2]!='W'||array[x2+1][y2]!='|'||array[x2+1][y2]!='E'||  array[x2+1][y2]!='F')
  {
    u=array[x2+1][y2];
    array[x2+1][y2]='E';
    array[x2][y2]=u;
    x2=x2+1;
  }
  else
  {

  }
}
else
{

}
  }
  else   if(i==2)
    {
      if(arr[i]==1)
      {
        if(array[x3][y3+1]=='@')
        {
          System.out.println("GAMEOVER");
            time.sleep(timeToSleep);
          try
          {
            FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
            FileWriter fw1=new FileWriter("snake_player.dat",false);
            BufferedWriter bf1=new BufferedWriter(fw1);
       if(score>heighscore)
       {
         fout1.write(score);
         bf1.write(playername);
       }
       else
       {
           fout1.write(heighscore);
           bf1.write(highscoreplayername);

       }
       fout1.close();
       bf1.close();
          }
          catch(Exception e)
          {
          System.out.println("Error");
          }
          gameover=false;
     break;
   }
        else if((array[x3][y3+1]=='W')||(array[x3][y3+1]=='|')||(array[x3][y3+1]=='E'))
        {

          u=array[x3][y3-1];
          array[x3][y3-1]='E';
          array[x3][y3]=u;
          y3=y3-1;
            arr[i]=3;

        }
        else if((array[x3][y3+1]=='F')&&((array[x3][y3+2]==' ')||(array[x3][y3+2]=='*')))
        {
          u=array[x3][y3+2];
          array[x3][y3+2]='E';
          array[x3][y3]=u;
          y3=y3+2;
        }
        else if((array[x3][y3+1]=='F')&&((array[x3][y3+2]!=' '||array[x3][y3+2]!='*')))
        {
          arr[i]=3;
          u=array[x3][y3-1];
          array[x3][y3-1]='E';
          array[x3][y3]=u;
          y3=y3-1;
        }
        else if((array[x3][y3+1]!='W')||(array[x3][y3+1]!='|')||(array[x3][y3+1]!='E')||  (array[x3][y3+1]!='F'))
        {
          u=array[x3][y3+1];
          array[x3][y3+1]='E';
          array[x3][y3]=u;
          y3=y3+1;
        }
      else
      {

      }
    }
    else if(arr[i]==3)
    {
      if(array[x3][y3-1]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
     if(score>heighscore)
     {
       fout1.write(score);
       bf1.write(playername);
     }
     else
     {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

     }
     fout1.close();
     bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
   break;
 }
       else if((array[x3][y3-1]=='W')||(array[x3][y3-1]=='|')||(array[x3][y3-1]=='E'))
      {

        u=array[x3][y3+1];
        array[x3][y3+1]='E';
        array[x3][y3]=u;
        y3=y3+1;
          arr[i]=1;
      }
      else if((array[x3][y3-1]=='F')&&((array[x3][y3-2]==' '||array[x3][y3-2]=='*')))
      {
        u=array[x3][y3-2];
        array[x3][y3-2]='E';
        array[x3][y3]=u;
        y3=y3-2;
      }
      else if((array[x3][y3-1]=='F')&&((array[x3][y3-2]!=' '||array[x3][y3-2]!='*')))
      {
        arr[i]=1;
        u=array[x3][y3+1];
        array[x3][y3+1]='E';
        array[x3][y3]=u;
        y3=y3+1;
      }
    else  if((array[x3][y3-1]!='W')||(array[x3][y3-1]!='|')||(array[x3][y3-1]!='E')||  (array[x3][y3-1]!='F'))
      {
        u=array[x3][y3-1];
        array[x3][y3-1]='E';
        array[x3][y3]=u;
        y3=y3-1;
      }


    else
    {

    }
    }
    else if(arr[i]==2)
    {
      if(array[x3-1][y3]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
     if(score>heighscore)
     {
       fout1.write(score);
       bf1.write(playername);
     }
     else
     {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

     }
     fout1.close();
     bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
   break;
 }
       else if(array[x3-1][y3]=='W'||array[x3-1][y3]=='='||array[x3-1][y3]=='E')
      {

        u=array[x3+1][y3];
        array[x3+1][y3]='E';
        array[x3][y3]=u;
        x3=x3+1;
          arr[i]=4;
      }
      else if((array[x3-1][y3]=='F')&&((array[x3-2][y3]==' '||array[x3-2][y3]=='*')))
      {
        u=array[x3-2][y3];
        array[x3-2][y3]='E';
        array[x3][y3]=u;
        x3=x3-2;
      }
      else if((array[x3-1][y3]=='F')&&((array[x3-2][y3]!=' '||array[x3-2][y3]!='*')))
      {
        arr[i]=4;
        u=array[x3+1][y3];
        array[x3+1][y3]='E';
        array[x3][y3]=u;
        x3=x3+1;
      }
      else if(array[x3-1][y3]!='W'||array[x3-1][y3]!='|'||array[x3-1][y3]!='E'||  array[x3-1][y3]!='F')
      {
        u=array[x3-1][y3];
        array[x3-1][y3]='E';
        array[x3][y3]=u;
        x3=x3-1;
      }



    else
    {

    }
    }
else if(arr[i]==4)
{
  if(array[x3+1][y3]=='@')
  {
    System.out.println("GAMEOVER");
      time.sleep(timeToSleep);
    try
    {
      FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
      FileWriter fw1=new FileWriter("snake_player.dat",false);
      BufferedWriter bf1=new BufferedWriter(fw1);
 if(score>heighscore)
 {
   fout1.write(score);
   bf1.write(playername);
 }
 else
 {
     fout1.write(heighscore);
     bf1.write(highscoreplayername);

 }
 fout1.close();
 bf1.close();
    }
    catch(Exception e)
    {
    System.out.println("Error");
    }
    gameover=false;
break;
}
  else if(array[x3+1][y3]=='W'||array[x3+1][y3]=='='||array[x3+1][y3]=='E')
  {
    arr[i]=2;
    u=array[x3-1][y3];
    array[x3-1][y3]='E';
    array[x3][y3]=u;
    x3=x3-1;
  }
  else if((array[x3+1][y3]=='F')&&((array[x3+2][y3]==' '||array[x3+2][y3]=='*')))
  {
    u=array[x3+2][y3];
    array[x3+2][y3]='E';
    array[x3][y3]=u;
    x3=x3+2;
  }
  else if((array[x3+1][y3]=='F')&&((array[x3+2][y3]!=' '||array[x3+2][y3]!='*')))
  {
    arr[i]=4;
    u=array[x3-1][y3];
    array[x3-1][y3]='E';
    array[x3][y3]=u;
    x3=x3-1;
  }
  else if(array[x3+1][y3]!='W'||array[x3+1][y3]!='|'||array[x3+1][y3]!='E'||  array[x3+1][y3]!='F')
  {
    u=array[x3+1][y3];
    array[x3+1][y3]='E';
    array[x3][y3]=u;
    x3=x3+1;
  }
  else
  {

  }
}
else
{

}
  }
else   if(i==3)
    {
      if(array[x4][y4+1]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
     if(score>heighscore)
     {
       fout1.write(score);
       bf1.write(playername);
     }
     else
     {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

     }
     fout1.close();
     bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
   break;
 }
      else if(arr[i]==1)
      {
         if((array[x4][y4+1]=='W')||(array[x4][y4+1]=='|')||(array[x4][y4+1]=='E'))
        {

          u=array[x4][y4-1];
          array[x4][y4-1]='E';
          array[x4][y4]=u;
          y4=y4-1;
            arr[i]=3;

        }
        else if((array[x4][y4+1]=='F')&&((array[x4][y4+2]==' ')||(array[x4][y4+2]=='*')))
        {
          u=array[x4][y4+2];
          array[x4][y4+2]='E';
          array[x4][y4]=u;
          y4=y4+2;
        }
        else if((array[x4][y4+1]=='F')&&((array[x4][y4+2]!=' '||array[x4][y4+2]!='*')))
        {
          arr[i]=3;
          u=array[x4][y4-1];
          array[x4][y4-1]='E';
          array[x4][y4]=u;
          y4=y4-1;
        }
        else if((array[x4][y4+1]!='W')||(array[x4][y4+1]!='|')||(array[x4][y4+1]!='E')||  (array[x4][y4+1]!='F'))
        {
          u=array[x4][y4+1];
          array[x4][y4+1]='E';
          array[x4][y4]=u;
          y4=y4+1;
        }
      else
      {

      }
    }
    else if(arr[i]==3)
    {
      if(array[x4][y4-1]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
     if(score>heighscore)
     {
       fout1.write(score);
       bf1.write(playername);
     }
     else
     {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

     }
     fout1.close();
     bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
   break;
 }

      else if((array[x4][y4-1]=='W')||(array[x4][y4-1]=='|')||(array[x4][y4-1]=='E'))
      {

        u=array[x4][y4+1];
        array[x4][y4+1]='E';
        array[x4][y4]=u;
        y4=y4+1;
          arr[i]=1;
      }
      else if((array[x4][y4-1]=='F')&&((array[x4][y4-2]==' '||array[x4][y4-2]=='*')))
      {
        u=array[x4][y4-2];
        array[x4][y4-2]='E';
        array[x4][y4]=u;
        y4=y4-2;
      }
      else if((array[x4][y4-1]=='F')&&((array[x4][y4-2]!=' '||array[x4][y4-2]!='*')))
      {
        arr[i]=1;
        u=array[x4][y4+1];
        array[x4][y4+1]='E';
        array[x4][y4]=u;
        y4=y4+1;
      }
    else  if((array[x4][y4-1]!='W')||(array[x4][y4-1]!='|')||(array[x4][y4-1]!='E')||  (array[x4][y4-1]!='F'))
      {
        u=array[x4][y4-1];
        array[x4][y4-1]='E';
        array[x4][y4]=u;
        y4=y4-1;
      }


    else
    {

    }
    }
    else if(arr[i]==2)
    {
      if(array[x4-1][y4]=='@')
      {
        System.out.println("GAMEOVER");
          time.sleep(timeToSleep);
        try
        {
          FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
          FileWriter fw1=new FileWriter("snake_player.dat",false);
          BufferedWriter bf1=new BufferedWriter(fw1);
     if(score>heighscore)
     {
       fout1.write(score);
       bf1.write(playername);
     }
     else
     {
         fout1.write(heighscore);
         bf1.write(highscoreplayername);

     }
     fout1.close();
     bf1.close();
        }
        catch(Exception e)
        {
        System.out.println("Error");
        }
        gameover=false;
   break;
 }
       if(array[x4-1][y4]=='W'||array[x4-1][y4]=='='||array[x4-1][y4]=='E')
      {

        u=array[x4+1][y4];
        array[x4+1][y4]='E';
        array[x4][y4]=u;
        x4=x4+1;
          arr[i]=4;
      }
      else if((array[x4-1][y4]=='F')&&((array[x4-2][y4]==' '||array[x4-2][y4]=='*')))
      {
        u=array[x4-2][y4];
        array[x4-2][y4]='E';
        array[x4][y4]=u;
        x4=x4-2;
      }
      else if((array[x4-1][y4]=='F')&&((array[x4-2][y4]!=' '||array[x4-2][y4]!='*')))
      {
        arr[i]=4;
        u=array[x4+1][y4];
        array[x4+1][y4]='E';
        array[x4][y4]=u;
        x4=x4+1;
      }
      else if(array[x4-1][y4]!='W'||array[x4-1][y4]!='|'||array[x4-1][y4]!='E'||  array[x4-1][y4]!='F')
      {
        u=array[x4-1][y4];
        array[x4-1][y4]='E';
        array[x4][y4]=u;
        x4=x4-1;
      }



    else
    {

    }
    }
else if(arr[i]==4)
{
  if(array[x4+1][y4]=='@')
  {
    System.out.println("GAMEOVER");
      time.sleep(timeToSleep);
    try
    {
      FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
      FileWriter fw1=new FileWriter("snake_player.dat",false);
      BufferedWriter bf1=new BufferedWriter(fw1);
 if(score>heighscore)
 {
   fout1.write(score);
   bf1.write(playername);
 }
 else
 {
     fout1.write(heighscore);
     bf1.write(highscoreplayername);

 }
 fout1.close();
 bf1.close();
    }
    catch(Exception e)
    {
    System.out.println("Error");
    }
    gameover=false;
break;
}

  else if(array[x4+1][y4]=='W'||array[x4+1][y4]=='='||array[x4+1][y4]=='E')
  {
    arr[i]=2;
    u=array[x4-1][y4];
    array[x4-1][y4]='E';
    array[x4][y4]=u;
    x4=x4-1;
  }
  else if((array[x4+1][y4]=='F')&&((array[x4+2][y4]==' '||array[x4+2][y4]=='*')))
  {
    u=array[x4+2][y4];
    array[x4+2][y4]='E';
    array[x4][y4]=u;
    x4=x4+2;
  }
  else if((array[x4+1][y4]=='F')&&((array[x4+2][y4]!=' '||array[x4+2][y4]!='*')))
  {
    arr[i]=4;
    u=array[x4-1][y4];
    array[x4-1][y4]='E';
    array[x4][y4]=u;
    x4=x4-1;
  }
  else if(array[x4+1][y4]!='W'||array[x4+1][y4]!='|'||array[x4+1][y4]!='E'||  array[x4+1][y4]!='F')
  {
    u=array[x4+1][y4];
    array[x4+1][y4]='E';
    array[x4][y4]=u;
    x4=x4+1;
  }
  else
  {

  }
}
else
{

}
  }
  else
  {

  }
}

    a.print1();
    System.out.println("score = "+score);
     System.out.println("heighscore = "+heighscore);
      System.out.println("High_scorername = "+highscoreplayername);

  }

}
catch (InterruptedException e)
   {
     System.out.println("Interrupted "+ "while Sleeping");
   }
}
}
