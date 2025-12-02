public class Main {
    public static void main(String[] args) {
        QuanLyChoThue quanLy = new QuanLyChoThue();

        // Tạo xe du lịch
        XeDuLich xe1 = new XeDuLich("30A-12345", "Toyota", 2020, "Trắng", 
                                     "Tốt", 800000, 7, "SUV");
        xe1.setPhucVuAnUong(true);
        
        XeDuLich xe2 = new XeDuLich("51B-67890", "Honda", 2019, "Đen", 
                                     "Tốt", 600000, 4, "Sedan");

        // Tạo xe chở hàng
        XeChoHang xe3 = new XeChoHang("29C-11111", "Hyundai", 2018, "Xanh", 
                                       "Tốt", 1000000, 3.5, "Thùng kín");
        xe3.setPhiVanChuyen(500000);

        XeChoHang xe4 = new XeChoHang("92D-22222", "Isuzu", 2021, "Trắng", 
                                       "Tốt", 1500000, 8.0, "Lạnh");

        // Thêm xe vào hệ thống
        quanLy.themXe(xe1);
        quanLy.themXe(xe2);
        quanLy.themXe(xe3);
        quanLy.themXe(xe4);

        // Tạo hợp đồng thuê
        HopDongThue hd1 = new HopDongThue("HD001", xe1, "Nguyễn Văn A", 
                                          "01/12/2024", "08/12/2024");
        HopDongThue hd2 = new HopDongThue("HD002", xe3, "Trần Thị B", 
                                          "03/12/2024", "10/12/2024");

        quanLy.themHopDong(hd1);
        quanLy.themHopDong(hd2);

        // Hiển thị thông tin
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   HỆ THỐNG QUẢN LÝ CHO THUÊ XE        ║");
        System.out.println("╚════════════════════════════════════════╝");

        quanLy.hienThiDanhSachXe();
        quanLy.hienThiDanhSachHopDong();

        // Tìm kiếm
        System.out.println("\n========== TÌM KIẾM ==========");
        Xe xeTim = quanLy.timKiemXe("30A-12345");
        if (xeTim != null) {
            xeTim.hienThiThongTin();
        }

        // Thống kê
        System.out.println("\n========== THỐNG KÊ ==========");
        System.out.println("Số xe đang thuê: " + quanLy.thongKeXeDangThue().size());
        System.out.println("Tổng doanh thu: " + quanLy.thongKeDoanhThu() + " VNĐ");

        // Ghi file
        System.out.println("\n========== LƯU DỮ LIỆU ==========");
        quanLy.writeFile();

        // Cập nhật trạng thái
        System.out.println("\n========== CẬP NHẬT TRẠNG THÁI ==========");
        hd1.capNhatTrangThai("Đã trả");
        System.out.println("✓ Đã cập nhật trạng thái hợp đồng HD001");

        // Xóa xe
        System.out.println("\n========== XÓA XE ==========");
        quanLy.xoaXe("51B-67890");
    }
}