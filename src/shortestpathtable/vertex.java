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
public class vertex {
    String key;
    int visited;
    static vertex[] vertexlist=new vertex[10];
    static int vertexindex=0;
    vertex()
    {
        this.key=null;
        visited=0;
    }
    void addvertex(String str)
    {
        boolean check=true;
        int loop=0;
     while(loop!=vertexindex)   
     {
         if(vertexlist[loop].key.equalsIgnoreCase(str))
         {
             check=false;
             break;
         }
         loop++;
     }
     if(check==true)
     {
         vertexlist[loop]=getvertex();
         vertexlist[loop].key=str;
         vertexindex++;
     }
     else if(check==false)
     {
         System.out.println(vertexlist[loop].key+ "  vertex is already in the memory :)");
     }
        
    }
    vertex getvertex()
    {
        return new vertex();
    }
}
