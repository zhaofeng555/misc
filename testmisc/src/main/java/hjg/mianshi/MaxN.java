package hjg.mianshi;

public class MaxN {

	public static void main(String[] args) {
		int arr[][]={{4,5,6},{7,0,9},{10,11,12}};
		int rs[][]=setZeros(arr);
		print(rs);
	}
	
	static void print(int[][]matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j]+ "\t");
			}
			System.out.println();
		}
	}
	
	public static int[][] setZeros(int[][] matrix){
		int []row=new int[matrix.length];
		int []column=new int[matrix[0].length];
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i]=1;
					column[j]=1;
				}
			}
		}
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if((row[i]==1 || column[j]==1)){
					matrix[i][j]=0;
				}
			}
		}
		
		return matrix;
	}

}
