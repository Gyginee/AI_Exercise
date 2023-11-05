package Drill.Execise_1;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
    }

    public static void main(String[] args) {
        timKiemBFS();
    }

    public static String taoMoTa(TrangThai trangThai) {
        String moTa = "";
        String bo1 = "";
        String bo2 = "";

        if (trangThai.nongDan == 0) {
            bo1 += "Nông dân, ";
        } else {
            bo2 += "Nông dân, ";
        }

        if (trangThai.soi == 0) {
            bo1 += "Sói, ";
        } else {
            bo2 += "Sói, ";
        }

        if (trangThai.de == 0) {
            bo1 += "Dê, ";
        } else {
            bo2 += "Dê, ";
        }

        if (trangThai.lua == 0) {
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

    public static void timKiemBFS() {
        Queue<TrangThai> hangDoi = new LinkedList<>();
        HashSet<TrangThai> daQua = new HashSet<>();

        TrangThai trangThaiBanDau = new TrangThai(0, 0, 0, 0);
        hangDoi.add(trangThaiBanDau);
        daQua.add(trangThaiBanDau);

        int buoc = 0; // Đếm số bước

        while (!hangDoi.isEmpty()) {
            TrangThai trangThaiHienTai = hangDoi.poll();
            String moTa = taoMoTa(trangThaiHienTai);

            if (!moTa.isEmpty()) {
                System.out.println("Bước " + buoc + ":");
                System.out.println(moTa);
                buoc++;
            }

            if (trangThaiHienTai.laTrangThaiMucTieu()) {
                System.out.println("Tất cả đã qua bờ 2!");
                break;
            }

            for (int diChuyen = 0; diChuyen < 4; diChuyen++) {
                TrangThai trangThaiTiepTheo = trangThaiHienTai.trangThaiTiepTheo(diChuyen);
                if (trangThaiTiepTheo != null) {
                    if (trangThaiTiepTheo.laTrangThaiHopLe() && !daQua.contains(trangThaiTiepTheo)) {
                        hangDoi.add(trangThaiTiepTheo);
                        daQua.add(trangThaiTiepTheo);
                    } else {
                        System.out.println("Phương án không khả quan, thực hiện lại!\n");
                        buoc = 1;
                    }
                }
            }
        }
    }
}
