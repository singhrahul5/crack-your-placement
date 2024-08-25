def removeDuplicates(s: str, k: int) -> str:
    stack = []

    for char in s:
        if len(stack) == 0 or stack[-1][0] != char:
            stack.append([char, 1])
        else:
            stack[-1][1] += 1

        if stack[-1][1] == k:
            stack.pop()

    ans = ""

    for char, freq in stack:
        ans += char * freq

    return ans
