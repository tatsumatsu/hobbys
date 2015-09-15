package sudoku.main;

import java.util.ArrayList;
import java.util.List;

import sudoku.mass.MassObject;

public class MakeSudoku {

	// 書き込み対象マス
	protected static int TARGET_MASS_N = -1;

	protected static int TARGET_MASS_P = 10;

	protected static int LAST_MASS = 81;

	public void getSudoku() throws ArrayIndexOutOfBoundsException{

		// インスタンスの生成
		ArrayList<MassObject> list = getList();

		// リストの先頭にランダムな値を設定
		MassObject first_Masu = list.get(0);
		int fNum = first_Masu.getPossibleNumber().get(0);
		first_Masu.setDecisionFlag(true);
		first_Masu.setDecisionNumber(fNum);

		for(MassObject mass : list){
			// 設定されている場合処理を飛ばす
			if(mass.isDecisionFlag()){
				continue;
			}

			// 同じグループのフラグ更新
			setFlag(first_Masu, mass, fNum);

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
			// カウンターがマス数-1でループ終了
			if(counter == LAST_MASS - 1){
				break;
			}
		}

		// 出力
		printSudoku(list);
	}

	/** マスオブジェクトを持つリストの生成 */
	public static ArrayList<MassObject> getList(){

		ArrayList<MassObject> list = new ArrayList<MassObject>();

		for(int a = 0; a < LAST_MASS; a++){
			list.add(new MassObject(a));
		}

		return list;
	}

	/** 同グループ検索 */
	public static void searchSameObject(ArrayList<MassObject> list, MassObject target, int sNum){

		for(MassObject mass : list){
			// 設定されている場合処理を飛ばす
			if(mass.isDecisionFlag()){
				continue;
			}

			// 同じグループのフラグ更新
			setFlag(target, mass, sNum);

		}
	}


	/**
	 * 設置可能番号の数を調べ、その数が少ないマスナンバーをフィールドに設定する。
	 * @param list
	 */
	public static void setTargetMasu(List<MassObject> list){

		for(MassObject mass : list){

			if(mass.isDecisionFlag()){
				continue;
			}

			if(mass.getPossibleNumber_k() < TARGET_MASS_P){
				TARGET_MASS_P = mass.getPossibleNumber_k();
				TARGET_MASS_N = mass.getMasuNumber();
			}

		}

	}

	/**
	 * フラグ更新
	 */
	public static void setFlag(MassObject target, MassObject sameg, int sNum){

		if(sameg.getK_yoko() == target.getK_yoko() || sameg.getK_tate() == target.getK_tate() || sameg.getK_block() == target.getK_block()){
			sameg.setMyFlag(sNum);
		}
	}

	/** 出力処理 */
	public static void printSudoku(ArrayList<MassObject> list){

		int kaigyo = 1;
		for(MassObject mass : list){
			System.out.print(mass.getDecisionNumber() + 1 + " ");
			if(kaigyo % 9 == 0){
				System.out.println("");
			}
			kaigyo++;
		}
	}

}
