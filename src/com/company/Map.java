package com.company;

import java.util.Random;

public class Map {
    private int[] mapsize =  new int[2];
    private int[][] grid;
    private int[][] tempgrid = new int[3][3];
    public Map(int x, int y) {
        mapsize[0] = x;
        mapsize[1] = y;
        grid = new int[mapsize[0]][mapsize[1]];
    }

    public int[] getMapsize() {
        return mapsize;
    }

    public void setMapsize(int x, int y) {
        mapsize[0] = x;
        mapsize[1] = y;


        grid = new int[mapsize[0]][mapsize[1]];
    }

    public void randomGrid(){
        for(int x = 0; x < mapsize[0]; x++){
            for(int y = 0; y < mapsize[1]; y++){
                Random random = new Random();
                /*if(x == 0 || y == 0 || x == mapsize[0] - 1|| y == mapsize[1] - 1)
                    grid[x][y] = 1;
                else*/
                grid[x][y] = random.nextInt(4)/3;
            }
        }
    }
    public int getPosStatus(int x, int y){
        try {
            return grid[x][y];
        }
        catch (ArrayIndexOutOfBoundsException p)
        {
            System.out.println("END OF MAP, TURN BACK");
            return 0;
        }
    }
    public int[][] getGrid() {
        return grid;
    }

    public int[][] GetGridAround(int[] position){
        try {
            for (int i = position[0] - 1; i < position[0] + 2; i++)
                for (int j = position[1] - 1; j < position[1] + 2; j++) {
                    tempgrid[i + 1 - position[0]][j + 1 - position[1]] = grid[i][j];
                }
        }
        catch (ArrayIndexOutOfBoundsException p)
        {
            System.out.println("TURN BACK");
        }
        return tempgrid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
