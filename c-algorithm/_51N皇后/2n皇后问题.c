//
// created by jun on 2020/8/3 下午11:01.
//

/*
基础练习 2n皇后问题
问题描述
　　给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后
和n个白皇后，使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两
个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
输入格式
　　输入的第一行为一个整数n，表示棋盘的大小。
　　接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，
如果一个整数为0，表示对应的位置不可以放皇后。
输出格式
　　输出一个整数，表示总共有多少种放法。
样例输入
4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
样例输出
2
样例输入
4
1 0 1 1
1 1 1 1
1 1 1 1
1 1 1 1
样例输出
0
*/
#include <stdio.h>

void input(int, int [][8]);
int count(int , int , int[][8],int , int*);

int main(void) {
	int n;
	int arr[8][8];	
	scanf("%d", &n);
	input(n,arr);
	int sum = 0;
	printf("%d\n", count(0, n, arr,2, &sum));
	return 0;
}

int count(int index, int n, int arr[][8],int s, int* sum) {
	if (index == n) {
		
	}
}

void input(int n, int arr[][8]) {
	int i;
	for ( i = 0; i < n; i++) {
		int j;
		for ( j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	
}
