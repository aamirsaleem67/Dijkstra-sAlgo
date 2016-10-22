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
public class ShortestPathTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        backtrack obj=new backtrack();
       obj.addvertex("Karachi");
       obj.addvertex("Lahore");
       obj.addvertex("Faislabad");
       obj.addvertex("Multan");
       obj.addvertex("Rawalpindi");
       obj.addvertex("Hyderabad");
       obj.createedge();
       
	/*obj.addedge("A","C",5);
	//obj.addedge("B","D",12);
        //obj.addedge("B","E",6);
        //obj.addedge("C","B",8);
        //obj.addedge("C","E",12);
        //obj.addedge("D","F",4);
        //obj.addedge("E","D",5);
        //obj.addedge("E","F",6); */
       
        obj.addedge("Karachi","Lahore",1030);
        obj.addedge("Karachi", "Faislabad", 1230);
        obj.addedge("Lahore","Multan",350);
        obj.addedge("Lahore","Rawalpindi",376);
        obj.addedge("Faislabad","Lahore",185);
        obj.addedge("Faislabad","Rawalpindi",322);
        obj.addedge("Multan","Hyderabad",742);
        obj.addedge("Rawalpindi","Multan",547);
        obj.addedge("Rawalpindi","Hyderabad",1289);
        
        
        obj.createtablelist();
        obj.shortestpathtable(5,5);
        System.out.println("SHORTEST PATH TABLE :");
        obj.print(5, 5);
        obj.tracking(5, 5, false);
        System.out.println("The SHORTEST PATH IS :");
        obj.printtracklist();
        
    }
    
}
