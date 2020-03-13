import java.util.*;


public class 我爱软工 {
    static int[][] maze;//迷宫，用二维数组实现
    static int n;//数组大小
    static int min;//步长

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        min = n * n;
        maze = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                maze[i][j] = sc.nextInt();
        recursion(1, 1, 0);//起始点为（1，1），步长记录先记0
        if (min == n * n)
            System.out.println("No solution");
        else
            System.out.println(min);
    }

    public static void recursion(int x, int y, int count) {
        if (x == n - 2 && y == n - 2)//判断终点达成
            min = Math.min(count, min);
        else {
            maze[x][y] = 1;//走过的位置不能重复走，那么改成非0即可
            if (y < n - 1 && maze[x][y + 1] == 0) {
                recursion(x, y + 1, count + 1);            //右
            }
            if (x < n - 1 && maze[x + 1][y] == 0) {
                recursion(x + 1, y, count + 1);            //下
            }
            if (x > 1 && maze[x - 1][y] == 0) {
                recursion(x - 1, y, count + 1);            //上
            }
            if (y > 1 && maze[x][y - 1] == 0) {
                recursion(x, y - 1, count + 1);            //左
            }
            //贾璐（假路），走不到终点，回到起点
            maze[x][y] = 0;//即从该处相邻地方出发没有找到完整路径，所以将之前走过的这条路径状态恢复
        }
    }

}
