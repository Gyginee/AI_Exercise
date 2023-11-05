## Giải Thích Code Sử Dụng Cho Bài Toán Người Nông Dân Qua Sông
### Mục Đích
Mã code này giải quyết bài toán về việc di chuyển các thành phần (người chăn, sói, dê, cỏ) qua sông sử dụng thuật toán tìm kiếm theo Chiều Rộng (BFS) và thuật toán tìm kiếm theo Chiều Sâu (DFS) .

## BFS
### Cấu Trúc Mã

1. **Class TrangThai**:
    - Lớp này mô tả từng trạng thái của bài toán.
    - Thuộc tính: `nongDan`, `soi`, `de`, `lua` biểu diễn vị trí của các đối tượng.
    - Phương thức:
        - `laTrangThaiHopLe`: kiểm tra trạng thái có hợp lệ không.
        - `laTrangThaiMucTieu`: kiểm tra trạng thái đã đạt đến mục tiêu chưa.
        - `trangThaiTiepTheo`: tạo các trạng thái kế tiếp dựa trên bước di chuyển.

2. **HashSet `daQua`**:
    - Lưu trữ các trạng thái đã duyệt qua.

3. **Hàm `main`**:
    - Khởi tạo trạng thái ban đầu với tất cả các đối tượng ở bờ bắt đầu.
    - Bắt đầu quá trình duyệt BFS từ trạng thái ban đầu và in kết quả.

4. **Hàm `timKiemBFS`**:
    - Triển khai thuật toán BFS để tìm kiếm từ trạng thái ban đầu đến trạng thái mục tiêu.
    - Sử dụng hàng đợi và tập hợp để duyệt qua từng trạng thái và theo dõi các trạng thái đã xét.
    - Khi tìm ra lời giải, in ra từng bước di chuyển và thông báo khi tất cả các thành phần đã qua bờ còn đích.

### Định Dạng Output

Mỗi bước di chuyển, mã in ra số bước di chuyển, mô tả bước di chuyển được thực hiện và trạng thái sau bước di chuyển. Khi tìm thấy giải pháp, nó sẽ thông báo đã hoàn thành và mô tả trạng thái cuối cùng.

## DFS
### Cấu Trúc Mã

1. **Class TrangThai**:
    - Lớp này đại diện cho từng trạng thái của bài toán.
    - Thuộc tính: `nongDan`, `soi`, `de`, `lua` biểu diễn vị trí của các đối tượng.
    - Phương thức: 
        - `laTrangThaiHopLe`: kiểm tra trạng thái có hợp lệ không.
        - `laTrangThaiMucTieu`: kiểm tra trạng thái đã đạt đến mục tiêu chưa.
        - `trangThaiTiepTheo`: tạo các trạng thái kế tiếp dựa trên bước di chuyển.

2. **HashSet `daQua`**:
    - Lưu trữ các trạng thái đã duyệt qua.

3. **Hàm `main`**:
    - Tạo trạng thái ban đầu với tất cả các đối tượng ở bờ bắt đầu.
    - Bắt đầu quá trình duyệt DFS từ trạng thái ban đầu và in kết quả.

4. **Hàm `timKiemDFS`**:
    - Hàm đệ quy duyệt các trạng thái và tìm giải pháp.
    - Nếu trạng thái là mục tiêu, in ra kết quả và mô tả trạng thái.
    - Nếu không phải mục tiêu, duyệt qua các bước di chuyển và tiếp tục duyệt đệ quy các trạng thái mới.

### Định Dạng Output

Mỗi bước di chuyển, mã in ra số bước di chuyển, bước di chuyển được thực hiện (0, 1, 2, hoặc 3 - đại diện cho việc di chuyển người nông dân, sói, dê, và cải), và mô tả trạng thái sau bước di chuyển đó. Khi tìm thấy giải pháp, nó sẽ thông báo với số bước cần thiết để đạt được giải pháp và mô tả trạng thái cuối cùng.
