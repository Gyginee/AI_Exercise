package Drill.Execise_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashSet;

class State {
    int farmer;
    int wolf;
    int goat;
    int rice;

    public State(int farmer, int wolf, int goat, int rice) {
        this.farmer = farmer;
        this.wolf = wolf;
        this.goat = goat;
        this.rice = rice;
    }

    public boolean isValid() {
        // Kiểm tra điều kiện hợp lệ
        if ((wolf == goat && farmer != wolf) || (goat == rice && farmer != goat)) {
            return false;
        }
        return true;
    }

    public boolean isGoal() {
        // Kiểm tra điều kiện đạt được mục tiêu
        return farmer == 1 && wolf == 1 && goat == 1 && rice == 1;
    }

    public State clone() {
        return new State(farmer, wolf, goat, rice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return farmer == state.farmer && wolf == state.wolf && goat == state.goat && rice == state.rice;
    }

    @Override
    public int hashCode() {
        return 31 * (31 * (31 * farmer + wolf) + goat) + rice;
    }

    @Override
    public String toString() {
        return String.format("Nông dân: %d, Sói: %d, Dê: %d, Lúa: %d", farmer, wolf, goat, rice);
    }
}
public class DFS {
    public static void main(String[] args) {
        dfs();
    }

    private static void dfs() {
        Stack<State> stack = new Stack<>();
        HashSet<State> visited = new HashSet<>();

        State initialState = new State(0, 0, 0, 0);
        stack.push(initialState);
        visited.add(initialState);

        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            System.out.println(currentState);

            if (currentState.isGoal()) {
                System.out.println("Đã đạt được mục tiêu!");
                break;
            }

            // Thử tất cả các bước có thể từ trạng thái hiện tại
            for (int i = 0; i < 4; i++) {
                State nextState = currentState.clone();
                nextState.farmer = 1 - nextState.farmer;

                switch (i) {
                    case 0:
                        nextState.wolf = 1 - nextState.wolf;
                        break;
                    case 1:
                        nextState.goat = 1 - nextState.goat;
                        break;
                    case 2:
                        nextState.rice = 1 - nextState.rice;
                        break;
                    case 3:
                        nextState.wolf = 1 - nextState.wolf;
                        nextState.goat = 1 - nextState.goat;
                        break;
                }

                if (nextState.isValid() && !visited.contains(nextState)) {
                    stack.push(nextState);
                    visited.add(nextState);
                }
            }
        }
    }
}