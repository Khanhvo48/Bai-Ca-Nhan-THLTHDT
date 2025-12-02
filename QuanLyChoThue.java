

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyChoThue implements IReadWrite {
    private List<Xe> danhSachXe;
    private List<HopDongThue> danhSachHopDong;
    private String fileName;

    public QuanLyChoThue() {
        this.danhSachXe = new ArrayList<>();
        this.danhSachHopDong = new ArrayList<>();
        this.fileName = "data_cho_thue.txt";
    }

    // Quản Lý Xe
    public void themXe(Xe xe) {
        danhSachXe.add(xe);
        System.out.println("✓ Đã thêm xe: " + xe.getBienSoXe());
    }

    public boolean suaXe(String bienSoXe, Xe xeMoi) {
        for (int i = 0; i < danhSachXe.size(); i++) {
            if (danhSachXe.get(i).getBienSoXe().equals(bienSoXe)) {
                danhSachXe.set(i, xeMoi);
                System.out.println("✓ Đã cập nhật xe: " + bienSoXe);
                return true;
            }
        }
        System.out.println("✗ Không tìm thấy xe: " + bienSoXe);
        return false;
    }

    public boolean xoaXe(String bienSoXe) {
        for (Xe xe : danhSachXe) {
            if (xe.getBienSoXe().equals(bienSoXe)) {
                danhSachXe.remove(xe);
                System.out.println("✓ Đã xóa xe: " + bienSoXe);
                return true;
            }
        }
        System.out.println("✗ Không tìm thấy xe: " + bienSoXe);
        return false;
    }

    public Xe timKiemXe(String bienSoXe) {
        for (Xe xe : danhSachXe) {
            if (xe.getBienSoXe().equals(bienSoXe)) {
                return xe;
            }
        }
        return null;
    }

    public void hienThiDanhSachXe() {
        if (danhSachXe.isEmpty()) {
            System.out.println("Danh sách xe trống!");
            return;
        }
        System.out.println("\n========== DANH SÁCH XE ==========");
        for (Xe xe : danhSachXe) {
            xe.hienThiThongTin();
        }
    }

    // Quản Lý Hợp Đồng
    public void themHopDong(HopDongThue hopDong) {
        danhSachHopDong.add(hopDong);
        System.out.println("✓ Đã thêm hợp đồng: " + hopDong.getMaHopDong());
    }

    public boolean suaHopDong(String maHopDong, HopDongThue hopDongMoi) {
        for (int i = 0; i < danhSachHopDong.size(); i++) {
            if (danhSachHopDong.get(i).getMaHopDong().equals(maHopDong)) {
                danhSachHopDong.set(i, hopDongMoi);
                System.out.println("✓ Đã cập nhật hợp đồng: " + maHopDong);
                return true;
            }
        }
        System.out.println("✗ Không tìm thấy hợp đồng: " + maHopDong);
        return false;
    }

    public boolean xoaHopDong(String maHopDong) {
        for (HopDongThue hd : danhSachHopDong) {
            if (hd.getMaHopDong().equals(maHopDong)) {
                danhSachHopDong.remove(hd);
                System.out.println("✓ Đã xóa hợp đồng: " + maHopDong);
                return true;
            }
        }
        System.out.println("✗ Không tìm thấy hợp đồng: " + maHopDong);
        return false;
    }

    public HopDongThue timKiemHopDong(String maHopDong) {
        for (HopDongThue hd : danhSachHopDong) {
            if (hd.getMaHopDong().equals(maHopDong)) {
                return hd;
            }
        }
        return null;
    }

    public void hienThiDanhSachHopDong() {
        if (danhSachHopDong.isEmpty()) {
            System.out.println("Danh sách hợp đồng trống!");
            return;
        }
        System.out.println("\n========== DANH SÁCH HỢP ĐỒNG ==========");
        for (HopDongThue hd : danhSachHopDong) {
            hd.hienThiThongTin();
        }
    }

    // Thống Kê
    public List<Xe> thongKeXeDangThue() {
        List<Xe> xeDangThue = new ArrayList<>();
        for (HopDongThue hd : danhSachHopDong) {
            if (hd.getTrangThai().equals("Đang thuê")) {
                xeDangThue.add(hd.getXe());
            }
        }
        return xeDangThue;
    }

    public double thongKeDoanhThu() {
        double tongDoanhThu = 0;
        for (HopDongThue hd : danhSachHopDong) {
            tongDoanhThu += hd.tinhTienThue();
        }
        return tongDoanhThu;
    }

    // Đọc và Ghi file
    @Override
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("✓ Đọc dữ liệu từ file: " + fileName);
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("✗ Lỗi đọc file: " + e.getMessage());
        }
    }

    @Override
    public void writeFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("========== DANH SÁCH XE ==========\n");
            for (Xe xe : danhSachXe) {
                bw.write(xe.getBienSoXe() + " - " + xe.getTinhTrang() + "\n");
            }
            bw.write("\n========== DANH SÁCH HỢP ĐỒNG ==========\n");
            for (HopDongThue hd : danhSachHopDong) {
                bw.write(hd.getMaHopDong() + " - " + hd.getKhachHang() + "\n");
            }
            System.out.println("✓ Đã lưu dữ liệu vào file: " + fileName);
        } catch (IOException e) {
            System.out.println("✗ Lỗi ghi file: " + e.getMessage());
        }
    }
}

