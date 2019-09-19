
import java.util.Scanner;
public class Battleship {
		public static void main(String[] args) {
			int x;
			int y;
			int mapsize;
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Size of board (nxn) : ");
			mapsize = input.nextInt();
			
			System.out.print("please enter x coordinate: ");
			x = input.nextInt();
			while((x < 0) || (x > mapsize - 1)) {
				System.out.print("Thats out of range try again");
				x = input.nextInt();
			}
			
			System.out.print("please enter y coordinate:  ");
			y = input.nextInt();
			while((y < 0) || (y > mapsize - 1)) {
				System.out.print("Thats out of range try again");
				y = input.nextInt();
			}

			//coordinate you chose
			System.out.println("You Picked ("+x+","+y+")");
			
			//print your new game
			System.out.println("The Board is "+mapsize+ " X " +mapsize+"");
			
			// print map with updated midpoint
			System.out.println("Heres your fresh game board now let find the coordinate you picked");
			printmap(newgame(mapsize));
			
			System.out.println("Map Update with mid point that you chose");
			printmap(addmid(x,y,newgame(mapsize),mapsize));
			
			
			//Print map with edges and coordinate on it;
			System.out.println("edges = '2' and corners = '3'");
			printmap(addedge(x,y,addmid(x,y,newgame(mapsize),mapsize), mapsize));
			System.out.println();
			
			//Final list
			coors(addedge(x,y,addmid(x,y,newgame(mapsize),mapsize), mapsize));
			
		}// END OF MAIN
		public static int[][] newgame(int size){
			int[][] map = new int[size][size];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = 0;
				}
			}
			return map;
		}
		public static void printmap(int[][] array) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j] +" ");
					
				}
				System.out.println();
			}
		}
		public static boolean inrange(int num, int size) {
			boolean r = false;
			if (num >= 0 || num <= size) {
				r = true;
			}
			return r;
		}
		public static int[][] addmid(int x, int y, int[][] array, int mapsize){
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j<array[0].length; j++) {
			if(i == x && j == y) {
				array[i][j] = 1;
			}
				}
			}
			return array;
			
		}
		public static int[][] addedge(int x, int y, int[][] array, int mapsize){
			int min = 0;
			int max = mapsize-1;
			int edge = 2;
			int corner = 3;
			
			
	//if (x,y) is a corner
	if( (x == min||x==max) && (y == min||y == max)) {
		// corner where x and y are either both max or min value
		if(x==y) {
			//bottom right
			if(x==max && y ==max) {
			array[x-1][y] = edge;
			array[x][y-1]= edge;
			array[x-1][y-1] = corner;
			}
			// top left
			else {
				array[x][y+1] = edge;
				array [x+1][y] = edge;
				array[x+1][y+1] = corner;	
			}
		}		
// Where only x is either 0 or max and y is either 0 or max
		else if((x==min && y == max)||(x ==max && y == min)) {
			
			// top elements
				if(x == min & y== max ) {
					array[x-1][y] = edge;
					array[x][y+1] = edge;
					array[x+1][y+1] = corner;
					
				}
				// bot left
				else {
					array[x][y-1] = edge;
					array[x+1][y] = edge;
					array[x+1][y-1] = edge;
				}
				
			}
	}
	// Wall Elements top or bottom
	// top or bottom wall elements
		else if((x == min || x==max) && ( y != min || y != max)){
			//top wall
			if(x == min && y!=min) 
			{
				array[x-1][y] = edge;
				array[x+1][y] = edge;
				array[x-1][y+1] = corner;
				array[x][y+1] = edge;
				array[x+1][y+1] = corner;	
				
			}
			//bottom wall
			else 
			{
				array[x-1][y-1] = corner;
				array[x][y-1] = edge;
				array[x+1][y-1] = corner;
				array[x-1][y] = edge;
				array[x+1][y] = edge;	
			}
		}
	// Wall elemenets left and right wall
		else if((x != min || x!=max) && ( y == min || y == max)){
			//Left wall
			if(y== min)
			{
				array[x][y-1] = edge;
				array[x+1][y-1] = corner;	
				array[x+1][y] = edge;
				array[x][y+1] = edge;
				array[x+1][y+1] = corner;
			}
			//Right wall
			else {
				array[x-1][y-1] = corner ;
				array[x][y-1] = edge;
				array[x][y+1] = edge;
				array[x-1][y] = edge;
				array[x+1][y+1] = corner;
			}	
		}	
		else {
			// top elements
						array[x-1][y-1] = corner;
						array[x][y-1] = edge;
						array[x+1][y-1] = corner;
						array[x-1][y] = edge;
						array[x+1][y] = edge;
						array[x-1][y+1] = corner;
						array[x][y+1] = edge;
						array[x+1][y+1] = corner;
								
		}	
		return array;
		}
		public static void coors (int[][] array) 
		{
			int edges = 0;
			int corners = 0;
			int rest = 0;
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					if(array[i][j] == 2) 
					{
					edges++;
					}
					else if(array[i][j] == 3)
					{
					corners++;
					}
					else
					{
					rest++;	
					}
				}
			}
			System.out.print("With the coordinats that you put turns out they're " +edges+ " edges, "+corners+" corners, and "+rest+" empty spaces");
		}
}
	



	

	
	
	
	
	
	
	
	

