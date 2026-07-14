class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m =  matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        //step-1 check if there's any 0 in the first row
        for(int j=0;j<m;j++){
            if(matrix[0][j] == 0){
                row0 = true;
                break;
            }

        }
        //step-2 check if the ther's any 0 in first column.
        for(int j=0;j<n;j++){
            if(matrix[j][0]==0){
                col0=true;
                break;
            }
        }

        //step-3 use matrix[0][j] and matrix[i][0] to mark rows and colums
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] =0; // mark row
                    matrix[0][j]=0; //mark col 
                }
            }
        }

        // Step 4: Zero out cells based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Step 5: Zero the first row if needed
        if(row0){
            for(int j=0;j<m;j++){
                matrix[0][j] = 0;
            }
        }

        if(col0){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }

    }
}
