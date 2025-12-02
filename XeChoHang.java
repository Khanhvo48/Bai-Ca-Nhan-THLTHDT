public class XeChoHang extends Xe {
    private double taiTrong;
    private String loaiThungXe;
    private String soDangKy;
    private double phiVanChuyen;

    public XeChoHang(String bienSoXe, String hangXe, int namSx, String mauXe, 
                     String tinhTrangXe, double giaThueNgay, double taiTrong, String loaiThungXe) {
        super(bienSoXe, hangXe, namSx, mauXe, tinhTrangXe, giaThueNgay);
        this.taiTrong = taiTrong;
        this.loaiThungXe = loaiThungXe;
        this.soDangKy = "DK" + bienSoXe;
        this.phiVanChuyen = 0;
    }

    public double getTaiTrong() {
        return taiTrong;
    }

    public String getLoaiThungXe() {
        return loaiThungXe;
    }

    public void setPhiVanChuyen(double phi) {
        this.phiVanChuyen = phi;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("\n===== XE CHỞ HÀNG =====");
        super.hienThiThongTin();
        System.out.println("Tải trọng: " + taiTrong + " tấn");
        System.out.println("Loại thùng xe: " + loaiThungXe);
        System.out.println("Số đăng ký: " + soDangKy);
        System.out.println("Phí vận chuyển: " + phiVanChuyen + " VNĐ");
    }

    @Override
    public double tinhPhiDichVu() {
        double phi = phiVanChuyen;
        if (taiTrong > 5) {
            phi += 1000000; // Phí xe tải trọng lớn
        }
        if (loaiThungXe.equals("Lạnh")) {
            phi += 800000; // Phí thùng lạnh
        }
        return phi;
    }

    public boolean kiemTraDangKiem() {
        int namHienTai = 2025;
        return (namHienTai - namSx) <= 10; // Xe dưới 10 năm còn đăng kiểm
    }
}