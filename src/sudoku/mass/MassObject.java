package sudoku.mass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MassObject implements MassNumber{


	/** マス番号 */
	private int masuNumber = -1;

	/** マス設定番号 */
	private int decisionNumber = -1;

	/** マスの設定可能番号 */
	private boolean number_0 = true;
	private boolean number_1 = true;
	private boolean number_2 = true;
	private boolean number_3 = true;
	private boolean number_4 = true;
	private boolean number_5 = true;
	private boolean number_6 = true;
	private boolean number_7 = true;
	private boolean number_8 = true;

	/** マスの横、縦、ブロックのグループ情報 */
	private int k_yoko = -1;
	private int k_tate = -1;
	private int k_block = -1;

	/** 設定未済フラグ */
	private boolean decisionFlag = false;

	/**
	 * コンストラクタ
	 */
	public MassObject(int masuNum){
		this.masuNumber = masuNum;
		int i = 0;

		// 横グループ情報を設定
		for(int[] yoko_ : yoko){
			for(int yoko_n : yoko_){
				if(masuNum == yoko_n){
					k_yoko = i;
				}
			}

			if(k_yoko != -1){
				i = 0;
				break;
			}
			i++;
		}


		// 縦グループ情報を設定
		for(int[] tate_ : tate){
			for(int tate_n : tate_){
				if(masuNum == tate_n){
					k_tate = i;
				}
			}

			if(k_tate != -1){
				i = 0;
				break;
			}
			i++;
		}

		// ブロックグループ情報を設定
		for(int[] block_ : block){
			for(int block_n : block_){
				if(masuNum == block_n){
					k_block = i;
				}
			}

			if(k_block != -1){
				i = 0;
				break;
			}
			i++;
		}
	}

	/**
	 * @return masuNumber
	 */
	public int getMasuNumber() {
		return masuNumber;
	}

	/**
	 * 設定可能ナンバーの数を取得
	 */
	public int getPossibleNumber_k(){
		int result = 0;
		boolean[] bl = new boolean[]{number_0, number_1, number_2, number_3, number_4, number_5, number_6, number_7, number_8};
		for(boolean tar : bl){
			if(tar){
				result++;
			}
		}

		return result;
	}

	/**
	 * 設定可能なナンバーをリストで返す
	 */
	public List<Integer> getPossibleNumber(){
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		boolean[] bl = new boolean[]{number_0, number_1, number_2, number_3, number_4, number_5, number_6, number_7, number_8};
		for(boolean tar : bl){
			if(tar){
				list.add(i);
			}
			i++;
		}

		Collections.shuffle(list);

		return list;
	}

	/**
	 * フラグを更新する
	 */
	public void setMyFlag(int num){
		switch(num){
		case 0:
			number_0 = false;
			break;
		case 1:
			number_1 = false;
			break;
		case 2:
			number_2 = false;
			break;
		case 3:
			number_3 = false;
			break;
		case 4:
			number_4 = false;
			break;
		case 5:
			number_5 = false;
			break;
		case 6:
			number_6 = false;
			break;
		case 7:
			number_7 = false;
			break;
		case 8:
			number_8 = false;
			break;
		}
	}

	/**
	 * @return decisionNumber
	 */
	public int getDecisionNumber() {
		return decisionNumber;
	}

	/**
	 * @param decisionNumber セットする decisionNumber
	 */
	public void setDecisionNumber(int decisionNumber) {
		this.decisionNumber = decisionNumber;
	}

	/**
	 * @return decisionFlag
	 */
	public boolean isDecisionFlag() {
		return decisionFlag;
	}


	/**
	 * @param decisionFlag セットする decisionFlag
	 */
	public void setDecisionFlag(boolean decisionFlag) {
		this.decisionFlag = decisionFlag;
	}

	/**
	 * @return k_yoko
	 */
	public int getK_yoko() {
		return k_yoko;
	}

	/**
	 * @return k_tate
	 */
	public int getK_tate() {
		return k_tate;
	}

	/**
	 * @return k_block
	 */
	public int getK_block() {
		return k_block;
	}

}
