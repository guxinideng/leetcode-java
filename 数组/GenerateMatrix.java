
// 59. 螺旋矩阵 II
// 给你一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵。
import java.util.Arrays;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int d=0,r=0,c=0;
        for(int i=1;i<=n*n;i++){
            arr[r][c]=i;
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != 0){
                d = (d+1)%4;
                nr = r + dir[d][0];
                nc = c + dir[d][1];
            }
            r = nr;
            c = nc;
        }
        
        return arr;
    }

    public static void main(String[] args) {
        GenerateMatrix solution = new GenerateMatrix();

        int[][] result = solution.generateMatrix(3);
        System.out.println("测试 n=3 期望=[[1,2,3],[8,9,4],[7,6,5]]，实际：");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
