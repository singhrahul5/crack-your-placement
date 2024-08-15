def backspace_compare(self, s: str, t: str) -> bool:
    s_idx = len(s) - 1
    t_idx = len(t) - 1

    s_backspace = 0
    t_backspace = 0

    while s_idx >= 0 and t_idx >= 0:
        if s[s_idx] == "#":
            s_idx -= 1
            s_backspace += 1
        elif s_backspace > 0:
            s_idx -= 1
            s_backspace -= 1
        elif t[t_idx] == "#":
            t_idx -= 1
            t_backspace += 1
        elif t_backspace > 0:
            t_idx -= 1
            t_backspace -= 1
        elif s[s_idx] != t[t_idx]:
            return False
        else:
            s_idx -= 1
            t_idx -= 1

    while s_idx >= 0:
        if s[s_idx] == "#":
            s_backspace += 1
        elif s_backspace > 0:
            s_backspace -= 1
        else:
            break

        s_idx -= 1

    while t_idx >= 0:
        if t[t_idx] == "#":
            t_backspace += 1
        elif t_backspace > 0:
            t_backspace -= 1
        else:
            break

        t_idx -= 1

    return s_idx == -1 and t_idx == -1