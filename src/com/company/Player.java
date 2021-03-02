package com.company;

public class Player{
    private int[] position = new int[2];
    private int[] old_position = new int[2];
    private String status;
    public Player() {
        position = new int[]{0, 0};
        status = "normal";
    }
    public Player(int[] position, String status) {
        this.position = position;
        this.status = status;
    }

    public int[] getPosition() {
        return position;
    }

    public void returnBack(){
        position = old_position;

    }
    public void setPosition(int x, int y) {
        position[0] = x;
        position[1] = y;
        old_position = position;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
