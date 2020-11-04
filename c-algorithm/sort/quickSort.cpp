#include<iostream>

using namespace std;

void swap(int nums[], int left, int right) {
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
}

void sort(int nums[], int s, int e) {
    int left = s;
    int right = e;
    int num = nums[s];

    while (left != right) {
        while (left < right && nums[right] >= num) right--;
        swap(nums, left, right);
        while (left < right && nums[left] <= num) left++;
        swap(nums, left, right);
    }
    sort(nums, s, left - 1);
    sort(nums, left + 1, e);
}

int main(void) {

    int n;
    cin >> n;
    int nums[n];
    for (int i = 0; i < n; i++) cin >> nums[i];


    for (int i = 0; i < n; i++) cout << nums[i] << " ";
    cout << endl;

    sort(nums, 0, n - 1);
    for (int i = 0; i < n; i++) cout << nums[i] << " ";
    cout << endl;

    return 0;
}