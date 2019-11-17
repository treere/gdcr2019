#include <assert.h>
#include <stdlib.h>
#include <stdio.h>

typedef struct Board {
	char* data;
	int rows;
	int cols;
} Board;

Board create_board(int rows, int cols) {
	Board b ;
	b.rows = rows;
	b.cols = cols;
	b.data = calloc(rows*cols, sizeof(char));

	return b;
}

int linear_index(Board board, int row, int col) {
	return row*board.cols+col;
}

void set_alive(Board board, int row, int col) {
	int index = linear_index(board,row,col);
	board.data[index] = 1;
}

int is_alive(Board board, int row, int col) {
	int index = linear_index(board,row,col);
	return board.data[index];
}

void free_board(Board board) {
	free(board.data);
}

int check_index(Board board, int row, int col) {
	return row >= 0 && col >= 0 && row < board.rows && col < board.cols;
}

int count_neighbor(Board board, int row, int col) {
	int sum = 0; 

	for (int r=-1; r<=1; r++) {
		for (int c=-1; c<=1; c++) {
			if (r==0 && c==0) { continue; }
			if (!check_index(board,row+r, col+c)) { continue; }
			int index = linear_index(board,row+r,col+c);
			if (board.data[index]) {
				sum++;
			}
		}
	}

	return sum;
}

void test_create_and_set_value_in_board(void) {
	Board board = create_board(10,10);
	assert(!is_alive(board, 0,0));

	set_alive(board, 0,0);
	assert(is_alive(board, 0,0));

	free_board(board);
}

void test_count_neighbors(void) {
	Board board = create_board(10,10);
	set_alive(board, 5,5);
	set_alive(board, 5,4);
	set_alive(board, 6,6);

	int count = count_neighbor(board, 5,5);
	assert(count == 2);
}

int main (void) {
	printf("Starting tests\n");
	test_create_and_set_value_in_board();
	test_count_neighbors();

	printf("DONE!\n");
	return 0;
}
