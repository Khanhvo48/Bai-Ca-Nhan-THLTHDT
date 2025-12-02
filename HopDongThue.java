public class HopDongThue {
    private String maHopDong;
    private Xe xe;
    private String khachHang;
    private String ngayThue;
    private String ngayTra;
    private String trangThai;

    public HopDongThue(String maHopDong, Xe xe, String khachHang, 
                       String ngayThue, String ngayTra) {
        this.maHopDong = maHopDong;
        this.xe = xe;
        this.khachHang = khachHang;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.trangThai = "Đang thuê";
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public Xe getXe() {
        return xe;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public double tinhTienThue() {
        int soNgayThue = 7;
        double tienThueXe = xe.getGiaThueNgay() * soNgayThue;
        double phiDichVu = xe.tinhPhiDichVu();
        return tienThueXe + phiDichVu;
    }

    public void capNhatTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void hienThiThongTin() {
        System.out.println("\n========== HỢP ĐỒNG THUÊ ==========");
        System.out.println("Mã hợp đồng: " + maHopDong);
        System.out.println("Khách hàng: " + khachHang);
        System.out.println("Ngày thuê: " + ngayThue);
        System.out.println("Ngày trả: " + ngayTra);
        System.out.println("Trạng thái: " + trangThai);
        System.out.println("Biển số xe: " + xe.getBienSoXe());
        System.out.println("Tổng tiền thuê: " + tinhTienThue() + " VNĐ");
        System.out.println("===================================");
    }
}