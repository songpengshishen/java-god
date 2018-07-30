package com.wsp.java.god.algorithm.search.dfs;

import java.util.Scanner;

/**
 * 利用DFS深度优先搜索从迷宫中找出从起点至指定终点的最短路径
 *
 * @author wsp
 */
public class MazeDfsSearch {


    private int minStep = Integer.MAX_VALUE;/*最小步骤*/
    private int targetX = 0;/*目标点的x轴坐标值*/
    private int targetY = 0;/*目标点的y轴坐标值*/
    private int startX = 0;/*起点*/
    private int startY = 0;/*终点*/
    private int mazeX, mazeY;/*迷宫x和y值*/
    int[][] maze = new int[51][51];/*迷宫*/
    int[][] record = new int[51][51];/*记录尝试走过的路*/
    int[][] nextMap = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};/*下一步地图*/


    public static void main(String[] args) {
        new MazeDfsSearch().startGame();
    }


    public void startGame(){
         System.out.println("请输入迷宫的x,y");
         Scanner scanner = new Scanner(System.in);
         while (scanner.hasNext()){
               String xy = scanner.next();
               if(xy.equals("q")){
                   break;
               }
               mazeX  =Integer.valueOf(xy.split(",")[0]);
               mazeY  =Integer.valueOf(xy.split(",")[1]);
         }
         System.out.println("请输入迷宫的每个点的值(0正常的路,1是障碍物)");

         for(int i = 0 ; i<mazeX;i++){
             for(int j = 0;j<mazeY;j++){
                 int val = scanner.nextInt();
                  maze[i][j] =  val;
             }
         }
        System.out.println("请输入迷宫的起点");
        while (scanner.hasNext()){
            String xy = scanner.next();
            if(xy.equals("q")){
                break;
            }
            startX  =Integer.valueOf(xy.split(",")[0]);
            startY  =Integer.valueOf(xy.split(",")[1]);
        }

        System.out.println("请输入迷宫的指点终点");
        while (scanner.hasNext()){
            String xy = scanner.next();
            if(xy.equals("q")){
                break;
            }
            targetX  =Integer.valueOf(xy.split(",")[0]);
            targetY  =Integer.valueOf(xy.split(",")[1]);
        }

        System.out.println("当前迷宫布局 : ");
        for(int i = 0;i<mazeX;i++){
            for(int j = 0 ;j<mazeY;j++){
                System.out.print(maze[i][j] + "\t");
            }
            System.out.print("\n");
        }

        record[startX][startY] = 1;
        dfsMaze(startX,startY,0);
        System.out.println("最短步数:" + minStep);
        scanner.close();
    }

    /**
     * 通过深度优先搜索查询出迷宫到达指定点的最短路径
     *
     * @param x    当前走到点的x
     * @param y    当前走到点的y
     * @param step 走过的步骤
     */
    public void dfsMaze(int x, int y, int step) {

        int currentX = 0, currentY = 0;

        /**
         * 到达迷宫指定点
         */
        if (x == targetX && y == targetY) {
            minStep = Math.min(step, minStep);
            return;
        }
        /**
         * 穷举循环上下左右四个方向的步骤
         */
        for (int k = 0; k <= 3; k++) {
            currentX = x + nextMap[k][0];
            currentY = y + nextMap[k][1];
            //是否越界
            if (currentX < 1 || currentX > mazeX || currentY < 1 || currentY > mazeY) {
                 continue;
            }
            //如果不是障碍物,并且没走过就记录下当前点,继续走
            if(maze[currentX][currentY] == 0 && record[currentX][y] == 0){
                record[currentX][currentY]=1;//记录下走过这个点
                dfsMaze(currentX,currentY,step+1);//递归走下一个点
                record[currentX][currentY]=0;/*一条路尝试完取消记录*/
            }
        }
        return;
    }
}
