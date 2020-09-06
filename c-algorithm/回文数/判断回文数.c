//
// created by jun on 2020/4/3 下午9:51.
//
/*
编程判断一个字符串是否是回文，当字符串是回文时，输出字符串：yes!，
否则输出字符串：no!。所谓回文即正向与反向的拼写都一样，如adgda。　　长度在100以内，且全为小写字母
样例输入
adgda
样例输出
yes!
*/
#include <stdio.h>
#include <stdbool.h>

bool judge(char *);

int q_length(char *);

int main(void) {
    char str[128];
    fgets(str, 128, stdin);
    printf(judge(str) ? "yes\n" : "no\n");
    return 0;
}

int q_length(char *str) {
    int length = 0;
    while (*str++ != '\0') {
        length++;
//        str++;
    }
    return length - 1;
}

// 双指针
bool judge(char *string) {
    int tail = q_length(string) - 1;

    printf("%d\n", tail);
    int head = 0;
    while (head < tail) {
        if (string[head] != string[tail]) {
            return false;
        }
        head++;
        tail--;
    }
    return true;
}