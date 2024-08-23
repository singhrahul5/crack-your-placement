from typing import List


def evalRPN(tokens: List[str]) -> int:

    def calc(operand1: int, operand2: int, operator: str) -> int:
        if operator == '+':
            return operand1 + operand2
        elif operator == '-':
            return operand1 - operand2
        elif operator == '*':
            return operand1 * operand2
        else:
            return int(operand1 / operand2)

    stack = []
    for token in tokens:
        if token in ('+', '-', '*', '/'):
            second = stack.pop()
            first = stack.pop()
            stack.append(calc(first, second, token))
        else:
            stack.append(int(token))

        # print(stack)

    return stack.pop()



