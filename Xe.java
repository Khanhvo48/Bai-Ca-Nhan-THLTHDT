public abstract class Xe {
    protected String bienSoXe;
    protected String hangXe;
    protected int namSx;
    protected String mauXe;
    protected double giaChoThueNgay;
    protected String tinhTrangXe;

    public Xe(String bienSoXe, String hangXe, int namSx, String mauXe, 
              String tinhTrangXe, double giaChoThueNgay) {
        this.bienSoXe = bienSoXe;
        this.hangXe = hangXe;
        this.namSx = namSx;
        this.mauXe = mauXe;
        this.tinhTrangXe = tinhTrangXe;
        this.giaChoThueNgay = giaChoThueNgay;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public double getGiaThueNgay() {
        return giaChoThueNgay;
    }

    public void setGiaThueNgay(double gia) {
        this.giaChoThueNgay = gia;
    }

    public String getTinhTrang() {
        return tinhTrangXe;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrangXe = tinhTrang;
    }

    public void hienThiThongTin() {
        System.out.println("Biển số: " + bienSoXe);
        System.out.println("Hãng xe: " + hangXe);
        System.out.println("Năm SX: " + namSx);
        System.out.println("Màu xe: " + mauXe);
        System.out.println("Giá thuê/ngày: " + giaChoThueNgay + " VNĐ");
        System.out.println("Tình trạng: " + tinhTrangXe);
    }

    public abstract double tinhPhiDichVu();
}