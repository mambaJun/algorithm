//
// created by jun on 2020/4/3 下午9:35.
//
#include<stdlib.h>
#include<stdio.h>

typedef struct Node {
    int value;
    struct * Node next;
} T_Node;

typedef struct {
    int value;
    int min;
    MinStack *next;
} MinStack;

/** initialize your data structure here. */

MinStack *minStackCreate() {
    MinStack *p_head = malloc(sizeof(MinStack));
    p_head->min = 7FFFFFFF;
    p_head->value = NULL;
    p_head->next = NULL;
    return p_head;
}

void minStackPush(MinStack *obj, int x) {
}

void minStackPop(MinStack *obj) {

}

int minStackTop(MinStack *obj) {

}

int minStackGetMin(MinStack *obj) {

}

void minStackFree(MinStack *obj) {

}