/*问题描述
　　为库设计新函数DelPack，删除输入字符串中所有的重复元素。不连续的重复元素也要删除。
　　要求写成函数，函数内部使用指针操作。
样例输入
1223445667889
样例输出
13579
样例输入
else
样例输出
ls
数据规模和约定
　　字符串数组最大长度为100。

最初想法：用一个数组去统计相应字符串位置的字符在整个字符串出现的次数，输出时为1就输出其余不考虑

*/
#if 1
#include<stdio.h>
#include <stdlib.h>

void sc_jg(char *);
void sc(char *,char);

int main(void)
{
    char str[128];
    gets(str);
    sc_jg(str);
    puts(str);
    return 0;
}

void sc(char * sh,char c)
{
    char * x = sh ;
    do
    {
        if( * sh != c )
        {
            * x = * sh ;
            x ++ ;
        }
    }
    while( * sh ++ != '\0' );
}

void sc_jg(char * s)
{
    while( * s != '\0')
    {
        sc (s + 1, * s );
        s ++ ;
    }
}
#endif


#if 0
#include<stdio.h>

void sc_jg(char *);
int q_cd(char *);

int main(void)
{
	char str[128];
	gets(str);
	sc_jg(str);
	return 0;
}

int q_cd(char * s)
{
	int cd = 0 ;
	while( * s != '\0' )
	{
		cd ++ ;
		s ++ ;
	}
	return cd ;
}

void sc_jg(char * s)
{
	int cd = q_cd(s);
	int tj[100] = {0};//不能写长度为什么？ int tj[cd] = {0};导致数组变大
	int i , j ;
	for( i = 0 ; i < cd ; i ++)
	{
		for( j = 0 ; j < cd ; j ++)
		{
			if( s[i] == s[j] )
			{
				tj[i] ++ ;
			}
		}
	}
	for( i = 0 ; i < cd ; i ++)
	{
		if( tj[i] == 1 )
		{
			printf("%c", s[i] );
		}
	}
}
#endif