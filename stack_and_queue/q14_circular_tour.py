def tour(lis, n):
    # Code here
    start = 0
    total_from_start = 0
    total_before_start = 0
    for i in range(n):
        petrol, dist = lis[i]

        total_from_start += petrol - dist

        if total_from_start < 0:
            start = i + 1
            total_before_start += total_from_start
            total_from_start = 0

    return start if total_from_start + total_before_start >= 0 else -1