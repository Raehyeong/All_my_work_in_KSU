import heapq
import copy
import time

#goal state
goal_state = [[1, 2, 3], [8, 0, 4], [7, 6, 5]]

#up, down, left, right
movements = [(-1, 0), (1, 0), (0, -1), (0, 1)]

#find the empty tile
def find_empty_tile(state):
    for i in range(3):
        for j in range(3):
            if state[i][j] == 0:
                return i, j

#check if a state is valid
def is_valid(state):
    return all(0 <= state[i][j] < 9 for i in range(3) for j in range(3))

#print the puzzle state
def print_state(state):
    for row in state:
        print(" ".join(map(str, row)))
    print()

def bfs(initial_state):
    # Create a queue for BFS
    queue = [(initial_state, [])]
    visited = set()

    while queue:
        state, path = queue.pop(0)
        if state == goal_state:
            return path

        empty_i, empty_j = find_empty_tile(state)

        for move_i, move_j in movements:
            new_i, new_j = empty_i + move_i, empty_j + move_j
            if 0 <= new_i < 3 and 0 <= new_j < 3:
                new_state = copy.deepcopy(state)
                new_state[empty_i][empty_j], new_state[new_i][new_j] = new_state[new_i][new_j], new_state[empty_i][empty_j]
                if tuple(map(tuple, new_state)) not in visited and is_valid(new_state):
                    queue.append((new_state, path + [(new_i, new_j)]))
                    visited.add(tuple(map(tuple, new_state)))

def ucs(initial_state):
    priority_queue = [(0, initial_state, [])]
    visited = set()

    while priority_queue:
        cost, state, path = heapq.heappop(priority_queue)
        if state == goal_state:
            return path

        empty_i, empty_j = find_empty_tile(state)

        for move_i, move_j in movements:
            new_i, new_j = empty_i + move_i, empty_j + move_j
            if 0 <= new_i < 3 and 0 <= new_j < 3:
                new_state = copy.deepcopy(state)
                new_state[empty_i][empty_j], new_state[new_i][new_j] = new_state[new_i][new_j], new_state[empty_i][empty_j]
                if tuple(map(tuple, new_state)) not in visited and is_valid(new_state):
                    new_cost = cost + 1
                    heapq.heappush(priority_queue, (new_cost, new_state, path + [(new_i, new_j)]))
                    visited.add(tuple(map(tuple, new_state)))

def heuristic(state):
    total_distance = 0
    for i in range(3):
        for j in range(3):
            if state[i][j] != 0:
                target_i, target_j = divmod(state[i][j] - 1, 3)
                total_distance += abs(target_i - i) + abs(target_j - j)
    return total_distance

def best_first_search(initial_state, heuristic):
    priority_queue = [(heuristic(initial_state), initial_state, [])]
    visited = set()

    while priority_queue:
        _, state, path = heapq.heappop(priority_queue)
        if state == goal_state:
            return path

        empty_i, empty_j = find_empty_tile(state)

        for move_i, move_j in movements:
            new_i, new_j = empty_i + move_i, empty_j + move_j
            if 0 <= new_i < 3 and 0 <= new_j < 3:
                new_state = copy.deepcopy(state)
                new_state[empty_i][empty_j], new_state[new_i][new_j] = new_state[new_i][new_j], new_state[empty_i][empty_j]
                if tuple(map(tuple, new_state)) not in visited and is_valid(new_state):
                    heapq.heappush(priority_queue, (heuristic(new_state), new_state, path + [(new_i, new_j)]))
                    visited.add(tuple(map(tuple, new_state)))

#Nilsson's sequence score
def nilsson_sequence_score(state):
    score = 0
    for i in range(3):
        for j in range(3):
            if state[i][j] != 0:
                target_i, target_j = divmod(state[i][j] - 1, 3)
                if (i, j) != (target_i, target_j):
                    score += 2
                    if (i, j) != (0, 0) and state[i][j] == goal_state[i][j]:
                        score -= 2
                    elif (i, j) != (0, 1) and state[i][j] == goal_state[i][j]:
                        score -= 2
    return score

def a_star_nilsson(initial_state):
    priority_queue = [(nilsson_sequence_score(initial_state) + 0, initial_state, [])]
    visited = set()

    while priority_queue:
        _, state, path = heapq.heappop(priority_queue)
        if state == goal_state:
            return path
        empty_i, empty_j = find_empty_tile(state)
        for move_i, move_j in movements:
            new_i, new_j = empty_i + move_i, empty_j + move_j
            if 0 <= new_i < 3 and 0 <= new_j < 3:
                new_state = copy.deepcopy(state)
                new_state[empty_i][empty_j], new_state[new_i][new_j] = new_state[new_i][new_j], new_state[empty_i][empty_j]
                if tuple(map(tuple, new_state)) not in visited and is_valid(new_state):
                    new_cost = len(path) + 1
                    heapq.heappush(priority_queue, (new_cost + nilsson_sequence_score(new_state), new_state, path + [(new_i, new_j)]))
                    visited.add(tuple(map(tuple, new_state)))

def measure_time(func, state):
    start_time = time.time()
    result = func(state)
    end_time = time.time()
    elapsed_time = end_time - start_time
    return result, elapsed_time

# 초기 상태
initial_state = [[2, 5, 3], [1, 6, 4], [0, 8, 7]]

# 각 알고리즘의 실행 시간 측정
print("Initial State:")
print_state(initial_state)

# Breadth-First Search
bfs_result, bfs_time = measure_time(bfs, initial_state)
print("Breadth-First Search Result:")
print("Number of moves:", len(bfs_result))
for move in bfs_result:
    print(move)
print("Execution Time (BFS):", bfs_time, "seconds")
print()

# Uniform-Cost Search
ucs_result, ucs_time = measure_time(ucs, initial_state)
print("Uniform-Cost Search Result:")
print("Number of moves:", len(ucs_result))
for move in ucs_result:
    print(move)
print("Execution Time (UCS):", ucs_time, "seconds")
print()

# Best-First Search
best_first_search_result, best_first_search_time = measure_time(best_first_search, initial_state)
print("Best-First Search Result:")
print("Number of moves:", len(best_first_search_result))
for move in best_first_search_result:
    print(move)
print("Execution Time (Best-First Search):", best_first_search_time, "seconds")
print()

# A* Algorithm (Nilsson)
a_star_result, a_star_time = measure_time(a_star_nilsson, initial_state)
print("A* Algorithm Result:")
print("Number of moves:", len(a_star_result))
for move in a_star_result:
    print(move)
print("Execution Time (A* Algorithm):", a_star_time, "seconds")