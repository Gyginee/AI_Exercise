package Drill.Execise_1;
import java.util.HashSet;

public class DFS {

    static class TrangThai {
        int nongDan, soi, de, lua;

        public TrangThai(int nongDan, int soi, int de, int lua) {
            this.nongDan = nongDan;
            this.soi = soi;
            this.de = de;
            this.lua = lua;
        }

        public boolean laTrangThaiHopLe() {
            if ((soi == 1 && lua == 1 && nongDan == 0) || (soi == 1 && de == 1 && nongDan == 0)) {
                return false;
            }
            return true;
        }

        public boolean laTrangThaiMucTieu() {
            return nongDan == 1 && soi == 1 && de == 1 && lua == 1;
        }

        public TrangThai trangThaiTiepTheo(int diChuyen) {
            if (nongDan == diChuyen) {
                return new TrangThai(1 - nongDan, soi, de, lua);
            } else if (soi == diChuyen) {
                return new TrangThai(nongDan, 1 - soi, de, lua);
            } else if (de == diChuyen) {
                return new TrangThai(nongDan, soi, 1 - de, lua);
            } else if (lua == diChuyen) {
                return new TrangThai(nongDan, soi, de, 1 - lua);
            }
            return null;
        }

        public String layMoTa() {
            String moTa = "";
            String bo1 = "";
            String bo2 = "";

            if (nongDan == 0) {
                bo1 += "Nông dân, ";
            } else {
                bo2 += "Nông dân, ";
            }

            if (soi == 0) {
                bo1 += "Sói, ";
            } else {
                bo2 += "Sói, ";
            }

            if (de == 0) {
                bo1 += "Dê, ";
            } else {
                bo2 += "Dê, ";
            }

            if (lua == 0) {
                bo1 += "Lúa";
            } else {
                bo2 += "Lúa";
            }

            if (!bo1.isEmpty()) {
                moTa += "- Bờ 1: " + bo1 + "\n";
            }
            if (!bo2.isEmpty()) {
                moTa += "- Bờ 2: " + bo2 + "\n";
            }

            return moTa;
        }
    }

    static HashSet<TrangThai> daQua = new HashSet<>();

    public static void main(String[] args) {
        TrangThai trangThaiBanDau = new TrangThai(0, 0, 0, 0);
        daQua.add(trangThaiBanDau);
        int buoc = timKiemDFS(trangThaiBanDau, 0);
        if (buoc == -1) {
            System.out.println("Không tìm thấy giải pháp.");
        }
    }

    public static int timKiemDFS(TrangThai trangThaiHienTai, int buoc) {
        if (trangThaiHienTai.laTrangThaiMucTieu()) {
            System.out.println("Tìm thấy giải pháp sau " + buoc + " bước.");
            System.out.println(trangThaiHienTai.layMoTa());
            return buoc;
        }

        for (int diChuyen = 0; diChuyen < 4; diChuyen++) {
            TrangThai trangThaiTiepTheo = trangThaiHienTai.trangThaiTiepTheo(diChuyen);
            if (trangThaiTiepTheo != null && trangThaiTiepTheo.laTrangThaiHopLe() && !daQua.contains(trangThaiTiepTheo)) {
                daQua.add(trangThaiTiepTheo);
                System.out.println("Bước " + buoc + ": Di chuyển " + diChuyen);
                System.out.println(trangThaiTiepTheo.layMoTa());
                int ketQua = timKiemDFS(trangThaiTiepTheo, buoc + 1);
                if (ketQua != -1) {
                    return ketQua;
                }
            }
        }

        return -1;
    }
}
