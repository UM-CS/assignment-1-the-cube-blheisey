package com.example.project;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Cube {

	//A cube for edge sliding 
    static String[][] Cube = {
		{null, null, null, "w0", "w1", "w2", null, null, null},
		{null, null, null, "w3", "w4", "w5", null, null, null},
		{null, null, null, "w6", "w7", "w8", null, null, null},
{"b0", "b1", "b2", "o0",  "o1",  "o2",  "g0", "g1", "g2", "r0",  "r1",  "r2"},
{"b3", "b4", "b5", "o3",  "o4",  "o5",  "g3", "g4", "g5", "r3",  "r4",  "r5"},
{"b6", "b7", "b8", "o6",  "o7",  "o8",  "g6", "g7", "g8", "r6",  "r7",  "r8"},
		{null, null, null, "y0", "y1", "y2", null, null, null},
		{null, null, null, "y3", "y4", "y5", null, null, null},
		{null, null, null, "y6", "y7", "y8", null, null, null}, 
};                                       

	static void rotate(String[][] Cube, int rowIndex, int colIndex){

		String Temp = "";

		Temp = Cube[rowIndex][colIndex];
		Cube[rowIndex][colIndex] = Cube[rowIndex + 2][colIndex];
		Cube[rowIndex + 2][colIndex] = Cube[rowIndex + 2][colIndex + 2];
		Cube[rowIndex + 2][colIndex + 2] = Cube[rowIndex][colIndex + 2];
		Cube[rowIndex][colIndex + 2] = Temp;

		Temp = Cube[rowIndex][colIndex + 1];
		Cube[rowIndex][colIndex + 1] = Cube[rowIndex + 1][colIndex];
		Cube[rowIndex + 1][colIndex] = Cube[rowIndex + 2][colIndex + 1];
		Cube[rowIndex + 2][colIndex + 1] = Cube[rowIndex + 1][colIndex + 2];
		Cube[rowIndex + 1][colIndex + 2] = Temp;


	}


	/*
	* 		1 -> 2 -> 3
	* 		/\       \/
	* 		4    5    6
	* 		/\       \/
	* 		7 <- 8 <- 9
	* 
	* 	 Clockwise Rotation
	*
	*/




	static void U(String[][] Cube){

		rotate(Cube, 0, 3); //rotating white face clockwise

		String[] temp = {Cube[3][0], Cube[3][1], Cube[3][2]}; //holding onto the blue layer

		for(int i = 0; i < 9; i++){
		Cube[3][i] = Cube[3][i + 3];
		}

		Cube[3][9] = temp[0];
		Cube[3][10] = temp[1];
		Cube[3][11] = temp[2];

	}


	static void Uprime(String[][] Cube){
		U(Cube);
		U(Cube);
		U(Cube);
	}


	static void D(String[][] Cube){

		rotate(Cube, 6, 3); //rotating yellow face clockwise

		String[] temp = {Cube[5][9], Cube[5][10], Cube[5][11]}; //holding onto the red layer

		for(int i = 11; i > 2; i--){
		Cube[5][i] = Cube[5][i - 3];
		}

		Cube[5][0] = temp[0];
		Cube[5][1] = temp[1];
		Cube[5][2] = temp[2];
	}


	static void Dprime(String[][] Cube){
		D(Cube);
		D(Cube);
		D(Cube);
	}


	static void L(String[][] Cube){

		rotate(Cube, 3, 3); //rotating orange face clockwise

		String[] temp = {Cube[0][3], Cube[1][3], Cube[2][3]}; //holding onto the white layer

		Cube[0][3] = Cube[3][0];
		Cube[1][3] = Cube[4][0];
		Cube[2][3] = Cube[5][0];

		String[] Temp = {Cube[3][6], Cube[4][6], Cube[5][6]}; //holding onto the green layer

		Cube[3][6] = temp[0];
		Cube[4][6] = temp[1];
		Cube[5][6] = temp[2];

		String[] TEMP = {Cube[6][5], Cube[7][5], Cube[8][5]}; //holding onto the yellow layer

		Cube[6][5] = Temp[0];
		Cube[7][5] = Temp[1];
		Cube[8][5] = Temp[2];

		Cube[3][0] = TEMP[0];
		Cube[4][0] = TEMP[1];
		Cube[5][0] = TEMP[2];
	}

	static void Lprime(String[][] Cube){
		L(Cube);
		L(Cube);
		L(Cube);
	}

	static void R(String[][] Cube){ 

		rotate(Cube, 3, 9); //rotating red face clockwise

		String[] temp = {Cube[0][5], Cube[1][5], Cube[2][5]}; //holding onto the white layer

		Cube[0][5] = Cube[3][8];
		Cube[1][5] = Cube[4][8];
		Cube[2][5] = Cube[5][8];

		String[] Temp = {Cube[3][2], Cube[4][2], Cube[5][2]}; 

		Cube[3][2] = temp[0];
		Cube[4][2] = temp[1];
		Cube[5][2] = temp[2];

		String[] TEMP = {Cube[6][5], Cube[7][5], Cube[8][5]}; 

		Cube[6][5] = Temp[0];
		Cube[7][5] = Temp[1];
		Cube[8][5] = Temp[2];

		Cube[3][8] = TEMP[0];
		Cube[4][8] = TEMP[1];
		Cube[5][8] = TEMP[2];
		}

		static void Rprime(String[][] Cube){
		R(Cube);
		R(Cube);
		R(Cube);
	}

	static void F(String[][] Cube){

		rotate(Cube, 3, 6);

		String[] temp = {Cube[2][3], Cube[2][4], Cube[2][5]}; //holding onto the white layer

		Cube[2][3] = Cube[5][5];
		Cube[2][4] = Cube[4][5];
		Cube[2][5] = Cube[3][5];

		String[] Temp = {Cube[3][9], Cube[4][9], Cube[5][9]}; 

		Cube[3][9] = temp[0];
		Cube[4][9] = temp[1];
		Cube[5][9] = temp[2];

		String[] TEMP = {Cube[8][3], Cube[8][4], Cube[8][5]}; 

		Cube[8][3] = Temp[2];
		Cube[4][4] = Temp[1];
		Cube[8][5] = Temp[0];

		Cube[8][3] = TEMP[0];
		Cube[8][4] = TEMP[1];
		Cube[8][5] = TEMP[2];
		}

		static void Fprime(String[][] Cube){
		F(Cube);
		F(Cube);
		F(Cube);
	}

	static void B(String[][] Cube){

		rotate(Cube, 3, 0);

		String[] temp = {Cube[0][3], Cube[0][4], Cube[0][5]};

		Cube[0][3] = Cube[3][11];
		Cube[0][4] = Cube[4][11];
		Cube[0][5] = Cube[5][11];


		String[] Temp = {Cube[3][3], Cube[4][3], Cube[5][3]}; 

		Cube[3][3] = temp[2];
		Cube[4][3] = temp[1];
		Cube[5][3] = temp[0];

		String[] TEMP = {Cube[8][3], Cube[8][4], Cube[8][5]}; 

		Cube[8][3] = Temp[0];
		Cube[8][4] = Temp[1];
		Cube[8][5] = Temp[2];

		Cube[3][11] = TEMP[2];
		Cube[4][11] = TEMP[1];
		Cube[5][11] = TEMP[0];

	}

	static void Bprime(String[][] Cube){
		B(Cube);
		B(Cube);
		B(Cube);
	}

	static void printCube(String[][] Cube) {

		for(int i = 0; i < 3; i++){
			for(int j = 3; j < 6; j++){
				System.out.print(Cube[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}

		System.out.println("");

		for(int i = 3; i < 6; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(Cube[i][j]);
				System.out.print("|");
			}	
			System.out.println("");
		}

		System.out.println("");

		for(int i = 3; i < 6; i ++){
			for(int j = 3; j < 6; j ++){
				System.out.print(Cube[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}

		System.out.println("");

		for(int i = 3; i < 6; i ++){
			for(int j = 6; j < 9; j ++){
				System.out.print(Cube[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}

		System.out.println("");

		for(int i = 3; i < 6; i ++){
			for(int j = 9; j < 12; j ++){
				System.out.print(Cube[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}

		System.out.println("");

		for(int i = 6; i < 9; i ++){
			for(int j = 3; j < 6; j ++){
				System.out.print(Cube[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}

		System.out.println("");
	}





	public static void main(final String[] args) {

		printCube(Cube);
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> moves = new ArrayList<>();
		boolean moveAgain = true;

		while (moveAgain) {
        
			System.out.println("Please enter a move(\"u\", \"u'\", \"d\", \"d'\", \"l\", \"l'\", \"r\", \"r'\", \"f\", \"f'\", \"b\", \"b'\")");
			String move = scanner.next();
			
			moves.add(move);

			switch (move) {
				case "u":{
					U(Cube);
					break; 
				}
				case "u'":{
					Uprime(Cube);
					break;
				}
				case "d":{
					D(Cube);
					break;
				}
				case "d'":{
					Dprime(Cube);
					break;
				}
				case "l":{
					L(Cube);
					break;
				}
				case "l'":{
					Lprime(Cube);
					break;
				}
				case "r":{
					R(Cube);
					break;
				}
				case "r'":{
					Rprime(Cube);
					break;
				}
				case "f":{
					F(Cube);
					break;
				}
				case "f'":{
					Fprime(Cube);
					break;
				}
				case "b":{
					B(Cube);
				}
				case "b'":{
					Bprime(Cube);
					break;
				}
			}
			printCube(Cube);
			System.out.print("Keep moving? (\"y\" or \"n\") ");
			String solve = scanner.next();
			if (solve.equalsIgnoreCase("n")) {
				moveAgain = false;
			}
		}
		scanner.close();
		System.out.println("");
		System.out.print("Moves to solve: ");
		Collections.reverse(moves);
        
        for (String move : moves) {
            System.out.print(move);
			System.out.print(" ");
		}
	}			
}




	
	



