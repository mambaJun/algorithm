class 四数之和_18:
    def four_sum(self, nums, target):
        def find_n_sum(nums, target, n, result, results):
            if len(nums) < n or n < 2 or target < nums[0] * n or target > nums[-1] * n:
                return
            if n == 2:
                l, r = 0, len(nums) - 1
                while l < r:
                    s = nums[l] + nums[r]
                    if s == target:
                        results.append(result + [nums[l], nums[r]])
                        while l < r and nums[l] == nums[l + 1]:
                            l += 1
                        l += 1
                        while l < r and nums[r] == nums[r - 1]:
                            r -= 1
                        r -= 1
                    elif s < target:
                        l += 1
                    else:
                        r -= 1
            else:
                for i in range(len(nums) - n + 1):
                    if i == 0 or (i > 0 and nums[i - 1] != nums[i]):
                        find_n_sum(nums[i + 1], target - nums[i], n - 1, result + [nums[i], result])

        results = []
        find_n_sum(sorted(nums), target, 4, [], results)
        return results
