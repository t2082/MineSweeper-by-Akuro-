package ms.model;

import java.util.Random;

public class MSArrayMines {
	private int arr_mine[][];
	private Random rd;
	
	public MSArrayMines(int w, int h, int mine) {
		arr_mine = new int[w][h];
		rd = new Random();

		arrayBombInit(w,h,mine);
		numAroundInit(w,h);

//		for(int i=0; i<w; i++) {
//			for(int j=0; j<h; j++) {
//				System.out.print(arr_mine[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	public MSArrayMines(int[][] arr_mine) {
		this.arr_mine = arr_mine;
	}
	
	public int[][] getarr_mine() {
		return arr_mine;
	}

	public void setarr_mine(int[][] arr_mine) {
		this.arr_mine = arr_mine;
	}

	public void arrayBombInit(int w, int h, int mine) {
		// Cho tọa độ X và Y random
		int locateX = rd.nextInt(w);
		int locateY = rd.nextInt(h);
		// lấy vị trí bất kỳ trong mảng boom để đặt bomb = 9
		arr_mine[locateX][locateY] = 9;
		// lúc này tổng số quả bom = 1 <=> đếm = 1
		int count = 1;
		/* Xét xem đã đủ bom chưa, nếu count != boom (count < boom)
										1. Random tiếp tọa độ XY
										2. Nếu tọa độ đó chưa có bom (!=9)
												Thêm bomb vào
												Cho biến đếm về 0;
												Duyệt mảng 2 chiều đếm số bom trong mảng
		 */
		while(count != mine) {
			locateX = rd.nextInt(w);
			locateY = rd.nextInt(h);
			if(arr_mine[locateX][locateY] != 9) {
				arr_mine[locateX][locateY] = 9;
				count = 0;
				for(int i=0; i<w; i++) {
					for(int j=0; j<h;j++) {
						if(arr_mine[i][j] == 9)
							count++;
					}
				}
			}
		}
	}



	private void numAroundInit(int w, int h) {
		for(int i=0; i<w; i++) {
			for(int j=0; j<h;j++) {
				if(arr_mine[i][j] == 0) {
					int count =0;
					for(int k = i-1; k <= i+1; k++) {
						for(int l = j-1; l<=j+1; l++) { 
							if(k>=0 && k<w && l>=0 && l<h) {
								if(arr_mine[k][l]==9) 
									count++;
							}
						}
					}
					arr_mine[i][j] = count;
				}

			}
		}
	}
	
	
	
	public int open(int i, int j) {
		return arr_mine[i][j];
	}
	
}
