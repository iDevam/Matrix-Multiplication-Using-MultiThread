
public class MatrixBuilder {
	
	private final int size=2000;
	private int matrix[][] = new int[size][size];
	
	public int getSize() {
		return size;
	}



	public int[][] getMatrix() {
		return matrix;
	}

	

	public void makeMatrix() {
	
		 for ( int i = 0; i < matrix.length; i++) {
				for ( int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = (int) (Math.random() * 10);
				}
			}
		 	
	}
	
	public void print(){
		
		System.out.print("C = [");
	    for (int i=0;i<matrix.length;i++){
	        for (int j=0;j<matrix[i].length;j++){
	            System.out.print(matrix[i][j] + ",");
	        }
	        System.out.println();
	    }
	    System.out.print(" ]\n\n");
	}
	
	
	

}
