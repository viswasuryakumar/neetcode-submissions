class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows=matrix.length;
        int column=matrix[0].length;
        int left=0,right=column-1,top=0,bottom=rows-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);

            }
            top++;
            // Traverse from Top to Bottom (Right column)
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            };
            right--;
            // Traverse from Right to Left (Bottom row)
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
            }
            bottom--;
             // Traverse from Bottom to Top (Left column)
             if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                    
                }
             }
             left++;
        }
        return ans;
    }
    
}