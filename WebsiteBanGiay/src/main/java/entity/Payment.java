package entity;

public class Payment {
    private int maHD , accountID, amount;
    private String phuongThuc;
    
    public Payment(int maHD, int accountID, int amount, String phuongThuc)
    {
        this.maHD = maHD;
        this.accountID = accountID;
        this.amount = amount;
        this.phuongThuc = phuongThuc;
    }
    
    public int getMaHD() 
    {
	return maHD;
    }
    
    public void setMaHD(int maHD) 
    {
        this.maHD = maHD;
    }
    
    public int getAccountID() 
    {
	return accountID;
    }
    
    public void setAccountHD(int accountID) 
    {
        this.accountID = accountID;
    }
    
    public int getAmount() 
    {
	return amount;
    }
    
    public void setAmount(int amount) 
    {
        this.amount = amount;
    }
    
    public String getPhuongThuc() 
    {
	return phuongThuc;
    }
    
    public void setPhuongThuc(String phuongThuc) 
    {
        this.phuongThuc = phuongThuc;
    }
    
    
}
