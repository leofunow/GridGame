package com.company;


import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Player player = new Player();
		player.setPosition(6,6);
		Map map = new Map(10,10);
		map.randomGrid();
		/*for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				System.out.printf("%d ", map.getPosStatus(i, j));
			System.out.println();
		}
		System.out.println();*/
		while (player.getStatus() != "on Wall"){
			int[][] gridA = map.GetGridAround(player.getPosition());
			for(int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++)
					if(i == j && i == 1)
						System.out.print("* ");
					else
						System.out.printf("%d ", gridA[i][j]);
				System.out.println();
			}
			System.out.println("Return New Position");
			String pos = in.next();
			int[] position = new int[2];
			position = player.getPosition();
			switch (pos) {
				case ("w") -> player.setPosition(position[0] - 1, position[1] );
				case ("a") -> player.setPosition(position[0] , position[1]- 1);
				case ("s") -> player.setPosition(position[0] + 1, position[1]);
				case ("d") -> player.setPosition(position[0] , position[1]+ 1);
				default -> System.out.println("ERROR");
			}
			if(map.getPosStatus(player.getPosition()[0], player.getPosition()[1]) == 1)
				player.setStatus("on Wall");
		}
		System.out.println("You Failed");
	}
}