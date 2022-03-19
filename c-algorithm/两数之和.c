//
// created by jun on 2022/1/14 下午11:04.
//
#include<stdlib.h>
#include<stdio.h>


struct ListNode {
    int val;
    struct ListNode *next;
};

void printList(struct ListNode * head) {
	printf("开始打印");
	struct ListNode * tail = head;
	while (!tail)
	{
		printf("%d ", tail->val);
		tail = tail->next;
	}
	putchar('\n');
}

struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2) {
    struct ListNode *head = malloc(sizeof(struct ListNode));
    struct ListNode *tail = head;

    int carry = 0;

    while (l1 || l2) {
        int n1 = l1 ? l1->val : 0;
        int n2 = l2 ? l2->val : 0;
        int sum = n1 + n2 + carry;
        struct ListNode *node = malloc(sizeof(struct ListNode));
        node->val = sum % 10;
        node->next = NULL;
        tail->next = node;
        tail = node;

        carry = sum / 10;

        if (!l1) l1 = l1->next;
        if (!l2) l2 = l2->next;
    }

    if (carry > 0) {
        struct ListNode *node = malloc(sizeof(struct ListNode));
        node->val = carry;
        node->next = NULL;
        tail->next = node;
        tail = node;
    }
    return head->next;
}

struct ListNode * createList() {
    struct ListNode * head = malloc(sizeof(struct ListNode));
    struct ListNode * tail = head;
    for (int i = 0; i < 3; i++) {
        struct ListNode * node = malloc(sizeof(struct ListNode));
	printf("请输入：");
        scanf("%d", &node->val);
        node->next = NULL;
        tail->next = node;
        tail = node;
    }
    printList(head);
    return head->next;
}



int main(void) {
    struct ListNode * l1 = createList();
    struct ListNode * l2 = createList();
    printList(l1);
    return 0;
}