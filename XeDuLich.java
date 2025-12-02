public class XeDuLich extends Xe {
    private int soChoNgoi;
    private String loaiXe;
    private boolean coPhucVuAnUong;
    private String kieuDongCo;

    public XeDuLich(String bienSoXe, String hangXe, int namSx, String mauXe, 
                    String tinhTrangXe, double giaThueNgay, int soChoNgoi, String loaiXe) {
        super(bienSoXe, hangXe, namSx, mauXe, tinhTrangXe, giaThueNgay);
        this.soChoNgoi = soChoNgoi;
        this.loaiXe = loaiXe;
        this.coPhucVuAnUong = false;
        this.kieuDongCo = "Xăng";
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setPhucVuAnUong(boolean coPhucVu) {
        this.coPhucVuAnUong = coPhucVu;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("\n===== XE DU LỊCH =====");
        super.hienThiThongTin();
        System.out.println("Số chỗ ngồi: " + soChoNgoi);
        System.out.println("Loại xe: " + loaiXe);
        System.out.println("Phục vụ ăn uống: " + (coPhucVuAnUong ? "Có" : "Không"));
        System.out.println("Kiểu động cơ: " + kieuDongCo);
    }

    @Override
    public double tinhPhiDichVu() {
        double phi = 0;
        if (coPhucVuAnUong) {
            phi += 200000; // Phí phục vụ ăn uống
        }
        if (soChoNgoi >= 16) {
            phi += 500000; // Phí xe lớn
        }
        return phi;
    }

    public boolean kiemTraBaoHiem() {
        return namSx >= 2015; // Xe từ 2015 trở lên có bảo hiểm đầy đủ
    }
}