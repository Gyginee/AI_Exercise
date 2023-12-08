# Giải Bài toán Bình Nước bằng Thuật toán A*
## Mục Đích
Mã code này giải quyết bài toán đong bình nước bằng thuật toán A*

## Cấu Trúc Mã

1. **Class `TrangThai`**:
    - Mô tả từng trạng thái của bình nước.
    - Thuộc tính: `binhA`, `binhB`, `binhC` biểu diễn dung tích của từng bình.
    - Phương thức:
        - `equals`: So sánh xem hai trạng thái có bằng nhau không.
        - `hashCode`: Tạo mã băm cho trạng thái.

2. **Class `Node` implements Comparable**:
    - Biểu diễn một nút trong đồ thị tìm kiếm A*.
    - Thuộc tính: `trangThai`, `cha`, `chiPhi` (g(n)), `heuristic` (h(n)).
    - Phương thức:
        - `compareTo`: So sánh hai nút dựa trên chi phí tổng (g(n) + h(n)).

3. **Class `AStar`**:
    - Chứa phương thức main và triển khai thuật toán A*.
    - Các hằng số `DUNG_TICH_A`, `DUNG_TICH_B`, `DUNG_TICH_C` là dung tích của các bình nước.

4. **Phương thức `main`**:
    - Khởi tạo trạng thái ban đầu và mục tiêu.
    - Gọi phương thức `thucHienThuatToanAStar` để thực hiện thuật toán.

5. **Phương thức `thucHienThuatToanAStar`**:
    - Sử dụng `PriorityQueue` để quản lý tập hợp các nút theo thứ tự ưu tiên.
    - Sử dụng `HashSet` để lưu trạng thái đã xét.
    - Hiển thị chi tiết từng bước thực hiện thuật toán, bao gồm trạng thái đang xét, chi phí, và heuristic.
    - Khi tìm ra giải pháp, hiển thị đường đi giải pháp.

6. **Phương thức `sinhTrangThaiLienKe`**:
    - Sinh ra các trạng thái liên kết từ một trạng thái cho trước.

7. **Phương thức `themTrangThaiNeuChuaCo`**:
    - Thêm một trạng thái vào danh sách nếu nó chưa tồn tại.

8. **Phương thức `heuristic`**:
    - Sử dụng khoảng cách Manhattan để tính heuristic giữa hai trạng thái.

9. **Phương thức `inLoiGiai`**:
    - In ra đường đi giải pháp từ trạng thái ban đầu đến trạng thái mục tiêu.

## Định Dạng Kết Quả Output

- Mỗi bước di chuyển sẽ hiển thị trạng thái đang xét, chi phí, và heuristic.
- Khi tìm ra giải pháp, hiển thị đường đi giải pháp từ trạng thái ban đầu đến trạng thái mục tiêu.
