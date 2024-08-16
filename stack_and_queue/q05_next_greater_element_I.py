from typing import List


def next_greater_element(self, nums1: List[int], nums2: List[int]) -> List[int]:
    nums2_dict = {nums2[i]: i for i in range(len(nums2))}
    # print(nums2_dict)
    stack = []
    next_greater = [-1] * len(nums2)

    for i in range(len(nums2) - 1, -1, -1):
        while len(stack) > 0 and stack[-1] < nums2[i]:
            stack.pop()

        if len(stack) > 0:
            next_greater[i] = stack[-1]

        stack.append(nums2[i])

    ans = []
    for ele in nums1:
        ans.append(next_greater[nums2_dict[ele]])

    return ans
