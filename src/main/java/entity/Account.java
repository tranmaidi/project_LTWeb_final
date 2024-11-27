package entity;


public class Account {
    private int id;
    private String user;
    private String pass;
    private int isAdmin;
    private String email;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public Account(int id, String pass, int isAdmin, String email,String user) {
		
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.isAdmin = isAdmin;
		this.email = email;
	}

	public Account() {
		
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin
				+ ", email=" + email + "]";
	}

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

   
   

    
}