## Giải Thích Code Sử Dụng Cho Bài Toán Người Nông Dân Qua Sông
### Mục Đích
Mã code này giải quyết bài toán về việc di chuyển các thành phần (Nông dân, sói, dê, lúa) qua sông sử dụng thuật toán tìm kiếm theo Chiều Rộng (BFS) và thuật toán tìm kiếm theo Chiều Sâu (DFS).

## BFS
### Cấu Trúc Code

1. **Lớp State**:
    - Lớp này đại diện cho mỗi trạng thái của bài toán.
    - Các thuộc tính: `farmer`, `wolf`, `goat`, `rice` biểu thị vị trí của các đối tượng.
    - Phương thức:
        - `isValid`: kiểm tra xem trạng thái có hợp lệ không.
        - `isGoal`: kiểm tra xem trạng thái có phải là trạng thái mục tiêu không.
        - `clone`: tạo một bản sao của trạng thái.
        - `equals`: kiểm tra tính bằng nhau với một đối tượng khác.
        - `hashCode`: tạo mã băm cho trạng thái.
        - `toString`: cung cấp một chuỗi định dạng.

2. **Lớp BFS**:
    - Bao gồm phương thức `main` để bắt đầu BFS.
    - Phương thức `bfs`:
        - Thực hiện thuật toán BFS.
        - Sử dụng một hàng đợi và một danh sách để theo dõi các trạng thái đã duyệt qua.
        - In ra mỗi trạng thái và dừng lại khi đạt đến trạng thái mục tiêu.

### Định Dạng Output

Đối với mỗi bước, code sẽ in ra trạng thái hiện tại. Khi đạt đến trạng thái mục tiêu, xuất thông báo thành công cùng với trạng thái cuối cùng.

## DFS
### Cấu Trúc Code

1. **Lớp State**:
    - Lớp này đại diện cho mỗi trạng thái của bài toán.
    - Các thuộc tính: `farmer`, `wolf`, `goat`, `rice` biểu thị vị trí của các đối tượng.
    - Phương thức:
        - `isValid`: kiểm tra xem trạng thái có hợp lệ không.
        - `isGoal`: kiểm tra xem trạng thái có phải là trạng thái mục tiêu không.
        - `clone`: tạo một bản sao của trạng thái.
        - `equals`: kiểm tra tính bằng nhau với một đối tượng khác.
        - `hashCode`: tạo mã băm cho trạng thái.
        - `toString`: cung cấp một chuỗi định dạng.

2. **Lớp DFS**:
    - Bao gồm phương thức `main` để bắt đầu DFS.
    - Phương thức `dfs`:
        - Thực hiện thuật toán DFS.
        - Sử dụng một ngăn xếp và một tập hợp để theo dõi các trạng thái đã duyệt qua.
        - In ra mỗi trạng thái và dừng lại khi đạt đến trạng thái mục tiêu.

### Định Dạng Output

Đối với mỗi bước, code sẽ in ra trạng thái hiện tại. Khi đạt đến trạng thái mục tiêu, xuất thông báo thành công cùng với trạng thái cuối cùng.
