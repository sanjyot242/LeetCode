class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int maxA = 0;
        int n = heights.length;
        for(int i = 0 ; i<= n ; i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>= heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width ;
                if(st.isEmpty()) width = i;
                else width = i - st.peek() - 1;
                maxA = Math.max(maxA , height*width);
            }
            st.push(i);
        }
        return maxA;
    }
}

//brute force
// int maxArea = 0;
//         for(int i = 0 ; i <heights.length;i++){
//              int minHeight = Integer.MAX_VALUE;
//              for(int j=i;j<heights.length;j++){
//                 minHeight = Math.min(minHeight, heights[j]);
//                 maxArea = Math.max(maxArea, minHeight * (j - i + 1));
//              }
//         }
//         return maxArea;


// Optimal 1 
// int[] leftSmall = new int[heights.length];
//         int[] rightSmall = new int[heights.length];
//         Stack<Integer> stack = new Stack<>();

//         for(int i = 0 ; i < heights.length;i++){
//             while(!stack.isEmpty()&& heights[stack.peek()] >= heights[i]){
//                 stack.pop();
//             }

//             if(stack.isEmpty()) leftSmall[i]=0;
//             else leftSmall[i] = stack.peek()+1;
//             stack.push(i);
//         }

//         while (!stack.isEmpty()) stack.pop();

//         for(int i=heights.length-1;i>=0;i--){
//             while(!stack.isEmpty()&& heights[stack.peek()] >= heights[i]){
//                 stack.pop();
//             }
//             if(stack.isEmpty()) rightSmall[i]=heights.length-1;
//             else rightSmall[i] = stack.peek()-1;
//             stack.push(i);
//         }

//         int maxA = 0;
//         for (int i = 0; i < heights.length ; i++) {
//             maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
//         }
//         return maxA;