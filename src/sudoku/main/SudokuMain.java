package sudoku.main;


public class SudokuMain {




	public static void main(String[] args) {

		while(true){

			try{

				MakeSudoku instance = new MakeSudoku();
				instance.getSudoku();
				break;

			}catch(Exception e){
				System.out.println("失敗、リトライ");
			}

		}
	}
}
