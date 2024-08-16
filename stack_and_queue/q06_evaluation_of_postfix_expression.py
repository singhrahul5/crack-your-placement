def evaluate_postfix(self, s):
    stack = []

    for char in s:
        if char == "*":
            second = stack.pop()
            first = stack.pop()
            stack.append(first * second)
        elif char == "/":
            second = stack.pop()
            first = stack.pop()
            stack.append(first // second)
        elif char == "+":
            second = stack.pop()
            first = stack.pop()
            stack.append(first + second)
        elif char == "-":
            second = stack.pop()
            first = stack.pop()
            stack.append(first - second)
        else:
            stack.append(int(char))

    return stack.pop()
