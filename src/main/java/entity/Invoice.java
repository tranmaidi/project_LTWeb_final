package entity;

import java.util.Date;

public class Invoice {
	private int maHD;
	private int accountID;
	private double tongGia;
	Date ngayXuat;
        private String phuongThuc;
	public Invoice(int maHD, int accountID, double tongGia, Date ngayXuat, String phuongThuc) {
		this.maHD = maHD;
		this.accountID = accountID;
		this.tongGia = tongGia;
		this.ngayXuat = ngayXuat;
                this.phuongThuc = phuongThuc;
	}
	public Invoice() {
		
	}
	@Override
	public String toString() {
		return "Invoice [maHD=" + maHD + ", accountID=" + accountID + ", tongGia=" + tongGia + ", ngayXuat=" + ngayXuat
				+ "]";
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public double getTongGia() {
		return tongGia;
	}
	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}
	public Date getNgayXuat() {
		return ngayXuat;
	}
	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
        public String getPhuongThuc() {
		return phuongThuc;
	}
	public void setPhuongThuc(String phuongThuc) {
		this.phuongThuc = phuongThuc;
	}
}
