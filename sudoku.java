import java.util.Scanner;

public class sudoku {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        int n=0;

        System.out.println("Quantos players: ");
        n = scan.nextInt();
        int[][][] nomeEsudoku = new int[n][sudoku.length][sudoku.length];

        boolean[] nomeBoolean = new boolean[n];

        String[] nome = new String[n];

        for(int i=0;i<n;i++){
            System.out.println("O nome do "+i+" Jogador: ");
            nome[i] = scan.next();
        }

        for(int l=0;l<n;l++){
            System.out.println("\n\nJogador: "+nome[l]);
            for(int i=0;i<sudoku.length;i++){
                for(int j=0;j<sudoku[i].length;j++){
                    sudoku[i][j]=0;
                }
            }
            do{
                int i;
                int j;
                tabela(sudoku);
                System.out.print("Linha: ");
                i = scan.nextInt();
                System.out.print("Coluna: ");
                j = scan.nextInt();
                System.out.print("Que numero quer colocar: ");
                sudoku[i][j] = scan.nextInt();
                if(sudoku[i][j]>0 & sudoku[i][j]<=9){
                    System.out.println("Numero adicionado");
                    nomeEsudoku[l][i][j] = sudoku[i][j];
                }else{
                    System.out.println("Numero invalido para o sudoku");
                    sudoku[i][j] = 0;
                }
    
            }while(verificaTabela(sudoku)!=true);
    
            if(verificaSudoku(sudoku)==true){
                nomeBoolean[l] = true;
            }
        }

        for(int i=0;i<n;i++){
            for(int k=0;k<sudoku.length;k++){
                for(int z=0;z<sudoku.length;z++){
                    sudoku[k][z] = nomeEsudoku[i][k][z];
                }
            }
            if(nomeBoolean[i]==true){
                System.out.println("Sudoku: "+nome[i]+": Sim");
                tabela(sudoku);
            }
            else{
                System.out.println("Sudoku: "+nome[i]+": Nao");
                tabela(sudoku);
            }
        }
    }

    public static void tabela(int[][] sudoku){
        System.out.println("    -----------------------");
        System.out.println("L0 | "+sudoku[0][0]+" "+sudoku[0][1]+" "+sudoku[0][2]+" | "+sudoku[0][3]+" "+sudoku[0][4]+" "+sudoku[0][5]+" | "+sudoku[0][6]+" "+sudoku[0][7]+" "+sudoku[0][8]+" | ");
        System.out.println("L1 | "+sudoku[1][0]+" "+sudoku[1][1]+" "+sudoku[1][2]+" | "+sudoku[1][3]+" "+sudoku[1][4]+" "+sudoku[1][5]+" | "+sudoku[1][6]+" "+sudoku[1][7]+" "+sudoku[1][8]+" | ");
        System.out.println("L2 | "+sudoku[2][0]+" "+sudoku[2][1]+" "+sudoku[2][2]+" | "+sudoku[2][3]+" "+sudoku[2][4]+" "+sudoku[2][5]+" | "+sudoku[2][6]+" "+sudoku[2][7]+" "+sudoku[2][8]+" | ");
        System.out.println("    -----------------------");
        System.out.println("L3 | "+sudoku[3][0]+" "+sudoku[3][1]+" "+sudoku[3][2]+" | "+sudoku[3][3]+" "+sudoku[3][4]+" "+sudoku[3][5]+" | "+sudoku[3][6]+" "+sudoku[3][7]+" "+sudoku[3][8]+" | ");
        System.out.println("L4 | "+sudoku[4][0]+" "+sudoku[4][1]+" "+sudoku[4][2]+" | "+sudoku[4][3]+" "+sudoku[4][4]+" "+sudoku[4][5]+" | "+sudoku[4][6]+" "+sudoku[4][7]+" "+sudoku[4][8]+" | ");
        System.out.println("L5 | "+sudoku[5][0]+" "+sudoku[5][1]+" "+sudoku[5][2]+" | "+sudoku[5][3]+" "+sudoku[5][4]+" "+sudoku[5][5]+" | "+sudoku[5][6]+" "+sudoku[5][7]+" "+sudoku[5][8]+" | ");
        System.out.println("    -----------------------");
        System.out.println("L6 | "+sudoku[6][0]+" "+sudoku[6][1]+" "+sudoku[6][2]+" | "+sudoku[6][3]+" "+sudoku[6][4]+" "+sudoku[6][5]+" | "+sudoku[6][6]+" "+sudoku[6][7]+" "+sudoku[6][8]+" | ");
        System.out.println("L7 | "+sudoku[7][0]+" "+sudoku[7][1]+" "+sudoku[7][2]+" | "+sudoku[7][3]+" "+sudoku[7][4]+" "+sudoku[7][5]+" | "+sudoku[7][6]+" "+sudoku[7][7]+" "+sudoku[7][8]+" | ");
        System.out.println("L8 | "+sudoku[8][0]+" "+sudoku[8][1]+" "+sudoku[8][2]+" | "+sudoku[8][3]+" "+sudoku[8][4]+" "+sudoku[8][5]+" | "+sudoku[8][6]+" "+sudoku[8][7]+" "+sudoku[8][8]+" | ");
        System.out.println("    -----------------------");
    }

    public static boolean verificaTabela(int[][] sudoku){
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[0].length;j++){
                if(sudoku[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verificaLinhas(int[][] sudoku) {
	    for (int i = 0; i < 9; i++) {
	        boolean[] verifica = new boolean[9];
	        for (int j = 0; j < 9; j++) {
	            if (sudoku[i][j] < 1 || sudoku[i][j] > 9) {
	                return false;
	            }
	            if (verifica[sudoku[i][j] - 1]) {
	                return false;
	            }
	            verifica[sudoku[i][j] - 1] = true;
	        }
	    }
	    return true;
	}

    public static boolean verificaColunas(int[][] sudoku) {
	    for (int i = 0; i < 9; i++) {
	        boolean[] verifica = new boolean[9];
	        for (int j = 0; j < 9; j++) {
	            if (sudoku[j][i] < 1 || sudoku[j][i] > 9) {
	                return false;
	            }
	            if (verifica[sudoku[j][i] - 1]) {
	                return false;
	            }
	            verifica[sudoku[j][i] - 1] = true;
	        }
	    }
	    return true;
	}

    public static boolean verificaBox(int[][] sudoku) {
	    for (int i = 0; i < 9; i += 3) {
	        for (int j = 0; j < 9; j += 3) {
	            boolean[] verifica = new boolean[9];
	            for (int k = i; k < i + 3; k++) {
	                for (int l = j; l < j + 3; l++) {
	                    if (sudoku[k][l] < 1 || sudoku[k][l] > 9) {
	                        return false;
	                    }
	                    if (verifica[sudoku[k][l] - 1]) {
	                        return false;
	                    }
	                    verifica[sudoku[k][l] - 1] = true;
	                }
	            }
	        }
	    }
	    return true;
	}

    public static boolean verificaSudoku(int[][] sudoku) {
	    return verificaLinhas(sudoku) && verificaColunas(sudoku) && verificaBox(sudoku);
	}
}
