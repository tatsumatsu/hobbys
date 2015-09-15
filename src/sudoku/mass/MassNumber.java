package sudoku.mass;

public interface MassNumber {
	// グループ分け
	public static final int[] yoko_0 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	public static final int[] yoko_1 = {9, 10, 11, 12, 13, 14, 15, 16, 17};
	public static final int[] yoko_2 = {18, 19, 20, 21, 22, 23, 24, 25, 26};
	public static final int[] yoko_3 = {27, 28, 29, 30, 31, 32, 33, 34, 35};
	public static final int[] yoko_4 = {36, 37, 38, 39, 40, 41, 42, 43, 44};
	public static final int[] yoko_5 = {45, 46, 47, 48, 49, 50, 51, 52, 53};
	public static final int[] yoko_6 = {54, 55, 56, 57, 58, 59, 60, 61, 62};
	public static final int[] yoko_7 = {63, 64, 65, 66, 67, 68, 69, 70, 71};
	public static final int[] yoko_8 = {72, 73, 74, 75, 76, 77, 78, 79, 80};
	public static final int[] tate_0 = {0, 9, 18, 27, 36, 45, 54, 63, 72};
	public static final int[] tate_1 = {1, 10, 19, 28, 37, 46, 55, 64, 73};
	public static final int[] tate_2 = {2, 11, 20, 29, 38, 47, 56, 65, 74};
	public static final int[] tate_3 = {3, 12, 21, 30, 39, 48, 57, 66, 75};
	public static final int[] tate_4 = {4, 13, 22, 31, 40, 49, 58, 67, 76};
	public static final int[] tate_5 = {5, 14, 23, 32, 41, 50, 59, 68, 77};
	public static final int[] tate_6 = {6, 15, 24, 33, 42, 51, 60, 69, 78};
	public static final int[] tate_7 = {7, 16, 25, 34, 43, 52, 61, 70, 79};
	public static final int[] tate_8 = {8, 17, 26, 35, 44, 53, 62, 71, 80};
	public static final int[] block_0 = {0, 1, 2, 9, 10, 11, 18, 19, 20};
	public static final int[] block_1 = {3, 4, 5, 12, 13, 14, 21, 22, 23};
	public static final int[] block_2 = {6, 7, 8, 15, 16, 17, 24, 25, 26};
	public static final int[] block_3 = {27, 28, 29, 36, 37, 38, 45, 46, 47};
	public static final int[] block_4 = {30, 31, 32, 39, 40, 41, 48, 49, 50};
	public static final int[] block_5 = {33, 34, 35, 42, 43, 44, 51, 52, 53};
	public static final int[] block_6 = {54, 55, 56, 63, 64, 65, 72, 73, 74};
	public static final int[] block_7 = {57, 58, 59, 66, 67, 68, 75, 76, 77};
	public static final int[] block_8 = {60, 61, 62, 69, 70, 71, 78, 79, 80};

	public static final int[][] yoko = {yoko_0, yoko_1, yoko_2, yoko_3, yoko_4, yoko_5, yoko_6, yoko_7, yoko_8};
	public static final int[][] tate = {tate_0, tate_1, tate_2, tate_3, tate_4, tate_5, tate_6, tate_7, tate_8};
	public static final int[][] block = {block_0, block_1, block_2, block_3, block_4, block_5, block_6, block_7, block_8};

}
