package com.grt.bsearch;

//240
public class Search2DMatrix2 {
	public static void main(String[] args){
		Search2DMatrix2 obj = new Search2DMatrix2();
		int[][] matrix = {
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}
		                };
		boolean result = obj.searchMatrix(matrix, 5);
		System.out.println("result:"+result);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0){
			return false;
		}
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m-1;
        int j = 0;
        
        while(i>=0 && j<n){
        	//System.out.println("matrix[i][j]:"+matrix[i][j]+" i:"+i+" j:"+j);
        	if(matrix[i][j]==target){
        		return true;
        	}else if(matrix[i][j]>target){
        		i--;
        	}else if(matrix[i][j]<target){
        		j++;
        	}
        }
        return false;
    }
}
