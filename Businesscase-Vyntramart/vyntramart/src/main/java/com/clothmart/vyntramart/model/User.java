package com.clothmart.vyntramart.model;

public class User {
	  

	    private String uName;

	    private String uId;

	    //@Transient
	   // private String passwordConfirm;

	   // @ManyToMany
	    //private Set<Role> roles;

	    public String getUId() {
			return uId;
		}

		public void setUId(String uId) {
			this.uId = uId;
		}

		public String getUName() {
			return uName;
		}

		public void setUName(String uName) {
			this.uName = uName;
		}

		@Override
		public String toString() {
			return "User [uId=" + uId + ", uName=" + uName + "]";
		}

	}