package sudoku.main;

import java.util.ArrayList;

import sudoku.mass.MassObject;

public class AnswerSudoku extends MakeSudoku{

	public static final int[] MASSNUM = {5, 12, 14, 16, 19, 20, 26, 29, 31, 33, 34, 37, 43, 46, 47, 49, 51, 54, 60, 61, 64, 66, 68, 75};
	public static final int[] MASSVALUE = {7, 0, 6, 4, 5, 3, 7, 0, 1, 8, 3, 1, 0, 2, 5, 4, 7, 1, 0, 2, 7, 1, 2, 8};

	/**
	 * 数独を解答する
	 */
	public void getAnswer() throws ArrayIndexOutOfBoundsException{

		// インスタンスの生成
		ArrayList<MassObject> list = getList();

		// 初期設定
		for(int b = 0; b < MASSNUM.length; b++){
			MassObject mass = list.get(MASSNUM[b]);
			int numberX = MASSVALUE[b];
			mass.setDecisionFlag(true);
			mass.setDecisionNumber(numberX);

			for(MassObject masu : list){

				// 同じグループのフラグ更新
				setFlag(mass, masu, numberX);

			}
		}

		int counter = 0;

		while(true){
			// 設定マスナンバーの決定
			setTargetMasu(list);
			MassObject target = list.get(TARGET_MASS_N);

			int sNum = target.getPossibleNumber().get(0);


			target.setDecisionFlag(true);
			target.setDecisionNumber(sNum);

			// 同じグループのフラグ更新
			searchSameObject(list, target, sNum);

			// フィールド初期化
			TARGET_MASS_N = -1;
			TARGET_MASS_P = 10;

			counter++;
			// カウンターが空きマス数でループ終了
			if(counter == LAST_MASS - MASSNUM.length){
				break;
			}
		}

		// 出力
		printSudoku(list);
	}
}
