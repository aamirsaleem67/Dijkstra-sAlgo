/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpathtable;

import static java.lang.Float.POSITIVE_INFINITY;

/**
 *
 * @author ubit
 */
public class table extends edge {
    double value;
    int marked;
    double mv=POSITIVE_INFINITY;
    int mp;
    static table[][] tablelist=new table[10][10];
    table()
    {
        this.marked=0;
    }
    void shortestpathtable(int rowmax,int colmax)
    {
        int i,j;
        int w;
        double destvalue;
        double min;
        for(i=0;i<=rowmax;i++)
        {
            for(j=0;j<=colmax;j++)
            {
               if(i==0&&j==0)
               {
                   tablelist[i][j].value=0;
                   continue;
                  
               }
               else if(i==0&&j!=0)
               {
                  tablelist[i][j].value=POSITIVE_INFINITY; 
                  continue;
               }
               try{
               if(tablelist[i-1][j].marked==1)
                   
               {
                   
                   tablelist[i][j].value=tablelist[i-1][j].value;
                   tablelist[i][j].marked=tablelist[i-1][j].marked;
               }
               
               
               else{
                   w=returnedweight(mp,j);
                   destvalue=tablelist[i-1][j].value;
                   if(w==-1)
                   {
                       min=destvalue;
                       tablelist[i][j].value=min;
                   }
                   else{
                       min=minimumvalueformula(destvalue,mv,w);
                       tablelist[i][j].value=min;
                   }
               }
               }
               catch(Exception e)
               {
                   System.out.println(e.getMessage());
               }
            }  // end of inner loop..
            table obj1=new table();
            table obj2=new table();
            obj1.mv=POSITIVE_INFINITY;
            leastvalueofrow(i,j,obj1,obj2,0);
            tablelist[i][obj2.mp].marked=1;
            mv=obj1.mv;
            mp=obj2.mp;
            backtrack a=new backtrack();
            backtrack.backlist[backtrack.markindex]=a.getbacklist();
            backtrack.backlist[backtrack.markindex].iPosition=i;
            backtrack.backlist[backtrack.markindex].yPosition=mp;
            backtrack.backlist[backtrack.markindex].value1=vertexlist[mp].key;
            backtrack.markindex++;
        }// end of outer loop..
    }
    
    void createtablelist()
    {
        int i,j;
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
             tablelist[i][j]=new table();   
            }
        }
    }
    
    int returnedweight(int source,int dest)
    {
        boolean check=false;
        edge temp=edge.edgelist[source];
        if(temp==null)
        {
            return -1;
        }
        else{
            while(temp!=null)
            {
               if(temp.end==dest) 
               {
                   check=true;
                   break;
               }
             temp=temp.link;   
            }
                }
        if(check==true)
        {
            return temp.weight;
        }
        else{        
            return -1;
        }
    }
    
    double minimumvalueformula(double dv,double markvalue,int w)  
  {
      if(markvalue+w<dv)
      {
          return (markvalue+w);
      }
      else{
      return dv;
      }
  }
    
    void leastvalueofrow(int source,int dest,table obj1,table obj2,int loop1)
    {
        if(loop1==dest)
        {
            return;
        }
        if(tablelist[source][loop1].marked==1)
        {
            loop1++;
            leastvalueofrow(source,dest,obj1,obj2,loop1);
        }
        else if(tablelist[source][loop1].marked==0)
        {
            if(obj1.mv<tablelist[source][loop1].value)
            {
                loop1++;
                leastvalueofrow(source,dest,obj1,obj2,loop1);
            }
            else{
                obj1.mv=tablelist[source][loop1].value;
                obj2.mp=loop1;
                loop1++;
                leastvalueofrow(source,dest,obj1,obj2,loop1);
            }
        }
        
    }
      
    void print(int rowmax,int colmax)
    {
        int i,j;
        for(i=0;i<=rowmax;i++)
        {
            
                for(j=0;j<=colmax;j++)
                {
                    System.out.print(tablelist[i][j].value+"  \t");
                    
                }
            System.out.println();
            
        }
       
    }

    
} // end of class..
