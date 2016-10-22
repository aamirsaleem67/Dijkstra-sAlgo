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
public class backtrack extends table {
    
    int iPosition;
    int yPosition;
    static int markindex=0;
    String value1;
    static backtrack[] backlist=new backtrack[10];
    String[] shortarr=new String[10];
    int indexshort=0;
    backtrack()
    {
        this.value1="";
    }
    void tracking(int i,int j,boolean check)
    {
        if(i-1==-1)
        {
            shortarr[indexshort]=backlist[i].value1;
            indexshort++;
            return;
        }
        else if(i==vertexindex-1&&j==vertexindex-1)
        {
            shortarr[indexshort]=backlist[i].value1;
            indexshort++;
            if(tablelist[i][j].value!=tablelist[i-1][j].value)
            {
                i=i-1;
                tracking(i,j,true);
            }
            else{
                i=i-1;
                tracking(i,j,false);
            }
        }
        else{
            if(check==false)
            {
                if(tablelist[i][j].value!=tablelist[i-1][j].value)
                {
                    i=i-1;
                    tracking(i,j,true);
                }
                else{
                    i=i-1;
                    tracking(i,j,false);
                }
            }
            else if(check==true)
            {
                j=backlist[i].yPosition;
                shortarr[indexshort]=backlist[i].value1;
                indexshort++;
                if(tablelist[i][j].value!=tablelist[i-1][j].value)
                {
                    i=i-1;
                    tracking(i,j,true);
                }
                else{
                    i=i-1;
                    tracking(i,j,false);
                }
            }
        }
       
    }
    void printtracklist()
    {
        for(int i=indexshort-1;i>=0;i--)
	{
		if(i==0)
		{
			System.out.print(shortarr[i]);
		}
		else{
			System.out.print(shortarr[i]+"->");
		}
	}
        System.out.println();
        
    }
    
    backtrack getbacklist()
    {
        return (new backtrack());
    }
    
}
