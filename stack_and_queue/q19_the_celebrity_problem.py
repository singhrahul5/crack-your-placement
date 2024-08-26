def celebrity( mat):
    # code here
    n = len(mat)
    row = [0] * n
    col = [0] * n

    for i in range(n):
        for j in range(n):
            row[i] += mat[i][j]
            col[j] += mat[i][j]

    for i in range(n):
        if row[i] == 0 and col[i] == n - 1:
            return i

    return -1