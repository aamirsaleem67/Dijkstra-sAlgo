/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpathtable;

/**
 *
 * @author ubit
 */
public class edge extends vertex {
    int end;
    int weight;
    edge link;
     static edge[] edgelist=new edge[10];
    edge()
    {
        this.link=null;
    }
    
 void addedge(String str1,String str2,int w)
    {
        
        int loop=0;
        boolean check1=false,check2=false;
        boolean check3=false;
        int start=-1;
        int endindex=-1;
        while(loop!=vertex.vertexindex)
        {
            if(vertex.vertexlist[loop].key.equalsIgnoreCase(str1))
            {
                check1=true;
                start=loop;
                loop++;
                continue;
            }
            if(super.vertexlist[loop].key.equalsIgnoreCase(str2))
            {
                check2=true;
                endindex=loop;
            }
          if(check1==true && check2==true)
          {
              check3=true;
              break;
          }
          loop++;
        }
        if(check3==false)   
        {
            System.out.println("Some vertex is missing :)");
            return;
        }
        else
            if(edgelist[start]==null)
            {
                edgelist[start]=getedge();
                edgelist[start].end=endindex;
                edgelist[start].weight=w;
                //System.out.println("Succesfully stored a edge in null :)");
                return;
            }
            else{
                edge newnode=getedge();
                edge temp=edgelist[start];
                newnode.end=endindex;
                newnode.weight=w;
                while(true)
                {
                   if(temp.end==endindex)
                   {
                       System.out.println("That edge is already in the memory :)");
                       return;
                   }
                   if(temp.link==null)
                   {
                       break;
                   }
                   temp=temp.link;
                }
                temp.link=newnode;
                //System.out.println("Successfully stored a edge in not null :)");
            }
            
        } // end of bol=true else...
        
         // end of addedge..
        
        
 
    edge getedge()
    {
        return new edge();
    }
    void createedge()
    {
        for(int i=0;i<10;i++)
        {
            edgelist[i]=null;
        }
    }

}