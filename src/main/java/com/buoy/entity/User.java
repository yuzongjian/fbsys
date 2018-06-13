package com.buoy.entity;

import java.io.Serializable;
import java.util.List;

import com.buoy.util.Page;

public class User implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String username;

    private String realname;

    private String password;

    private String salt;

    private Boolean locked;
    
    private String date;
    
    private Boolean deleted;
    
    private String beizhu;
    
    private Page page;
    
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	private List<Permissions> permissions;
    
    public List<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permissions> permissions) {
		this.permissions = permissions;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realname=" + realname + ", password=" + password
				+ ", salt=" + salt + ", locked=" + locked + ", date=" + date + ", deleted=" + deleted + ", beizhu="
				+ beizhu + ", permissions=" + permissions + "]";
	}

	

	
    
}