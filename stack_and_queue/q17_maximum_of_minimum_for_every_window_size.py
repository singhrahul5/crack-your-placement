def maxOfMin( arr, n):
    # code here
    prev_smaller = [-1] * n
    stack = []
    for i in range(n):
        while stack and arr[stack[-1]] >= arr[i]:
            stack.pop()
        if stack:
            prev_smaller[i] = stack[-1]
        stack.append(i)

    next_smaller = [n] * n
    stack = []
    for i in range(n - 1, -1, -1):
        while stack and arr[stack[-1]] >= arr[i]:
            stack.pop()
        if stack:
            next_smaller[i] = stack[-1]
        stack.append(i)

    ans = [0] * (n + 1)

    for i in range(n):
        win_size = next_smaller[i] - prev_smaller[i] - 1
        ans[win_size] = max(ans[win_size], arr[i])

    for i in range(n - 1, 0, -1):
        ans[i] = max(ans[i], ans[i + 1])

    return ans[1:]