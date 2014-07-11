package hjg.qunaer;

import java.util.Random;

public class Grid {
	static int n=10;
	public static void main(String[] args) {
		int grid[][]={
				{2,  2,  2,  2,  2,  1,  2,  1,  0,  0},  
				{0,  3,  1,  3,  0,  1,  3,  0,  1,  3} ,
				{3,  1,  2,  2,  1,  0,  1,  2,  0,  3} ,
				{2,  1,  2,  2,  1,  3,  3,  1,  2,  0} ,
				{2,  0,  2,  3,  0,  1,  0,  0,  1,  0} ,
				{1,  2,  0,  1,  1,  0,  0,  1,  3,  1}  ,
				{3,  2,  3,  1,  3,  3,  0,  1,  3,  2} ,
				{0,  2,  0,  2,  1,  1,  1,  2,  0,  1} ,
				{0,  2,  2,  0,  3,  0,  1,  2,  0,  1} ,
				{2,  0,  2,  3,  3,  0,  2,  0,  1,  2}  
		};
//		int grid[][] = new int[n][n];
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[i].length; j++) {
//				grid[i][j] = new Random().nextInt(4);
//			}
//		}
		
		print(grid);
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int rs = iswin(i, j, grid);
				if(-1 != rs){
					System.out.println(rs);
				}
			}
		}
	}
	
	static void print(int grid[][]){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]+ ",  ");
			}
			System.out.println();
		}
	}
	
	static int iswin(int x,int y, int grid[][]){
		boolean isYRight =y<=5;
		if(isYRight){
			if(grid[x][y]==grid[x][y+1] && grid[x][y]==grid[x][y+2] && grid[x][y]==grid[x][y+3] && grid[x][y]==grid[x][y+4]){
				System.out.println("x = "+x+" , y = "+y+ " , rs = 1");
				return 1;
			}
		}
		boolean isXRight = x<=5;
		if(isXRight){
			if(grid[x][y]==grid[x+1][y] && grid[x][y]==grid[x+2][y] && grid[x][y]==grid[x+3][y] && grid[x][y]==grid[x+4][y]){
				System.out.println("x = "+x+" , y = "+y+ " , rs = 2");
				return 2;
			}
		}
		
		boolean isXYRight =(x<=5&&y<=5);
		if(isXYRight){
			if(grid[x][y]==grid[x+1][y+1] && grid[x][y]==grid[x+2][y+2] && grid[x][y]==grid[x+3][y+3] && grid[x][y]==grid[x+4][y+4]){
				System.out.println("x = "+x+" , y = "+y+ " , rs = 3");
				return 3;
			}
		}
		boolean isYSRight =(x>=5&&y<=5);
		if(isYSRight){
			if(grid[x][y]==grid[x-1][y+1] && grid[x][y]==grid[x-2][y+2] && grid[x][y]==grid[x-3][y+3] && grid[x][y]==grid[x-4][y+4]){
				System.out.println("x = "+x+" , y = "+y+ " , rs = 4");
				return 4;
			}
		}
		
		return -1;
	}
	
}
