package com.grt.bsearch;

//74
public class Search2DMatrix {
	public static void main(String[] args){
		Search2DMatrix obj = new Search2DMatrix();
		int[][] matrix = {
                 {1,   3,  5,  7},
                 {10, 11, 16, 20},
                 {23, 30, 34, 50}
                };
		boolean result = obj.searchMatrix(matrix, 13);
		System.out.println("result:"+result);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0){
			return false;
		}
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        while(left<=right){
        	int mid = left+(right-left)/2;
        	if(matrix[mid/n][mid%n]==target){
        		return true;
        	}else if(matrix[mid/n][mid%n]>target){
        		right = mid-1;
        	}else{
        		left = left+1;
        	}
        }
        
        return false;
    }
}
