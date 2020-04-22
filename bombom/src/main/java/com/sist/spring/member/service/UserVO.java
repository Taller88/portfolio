/**
 * 
 */
package com.sist.spring.member.service;

import com.sist.spring.cmn.DTO;

/**
 * @author sist
 *
 */
public class UserVO extends DTO {
	
	//?ò§?ùº?Å¥DB?óê Level?ù¥?ùº?äî ?òï?Éú?äî ?óÜ?ñ¥?Ñú ?ù∏?ä∏?òï?úºÎ°? Î∞õÍ≥† ?ó¨Í∏∞ÏÑú?äî Level?ù¥?ùº?äî enum?ùÑ ?ù¥?ö©?ïòÎØ?Î°? level?? Level?òï
	
	/**?Ç¨?ö©?ûêID*/
	private String u_id	  ;
	/**?ù¥Î¶?*/
	private String name   ;
	/**ÎπÑÎ≤à*/
	private String passwd ;
	/**Level*/
	private Level level;
	/**Î°úÍ∑∏?ù∏ ?öü?àò*/
	private int login;
	/**Ï∂îÏ≤ú*/
	private int recommend;
	/**?ù¥Î©îÏùº*/
	private String email;
	/**?ì±Î°ùÏùº*/
	private String regDt; 
	
	
	public UserVO() {}

	public UserVO(String u_id, String name, String passwd, Level level, int login, int recommend, String email,
			String regDt) {
		super();
		this.u_id = u_id;
		this.name = name;
		this.passwd = passwd;
		this.level = level;
		this.login = login;
		this.recommend = recommend;
		this.email = email;
		this.regDt = regDt;
	}


	/**
	 * @return the u_id
	 */
	public String getU_id() {
		return u_id;
	}

	/**
	 * @param u_id the u_id to set
	 */
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	
	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the login
	 */
	public int getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(int login) {
		this.login = login;
	}

	/**
	 * @return the recommend
	 */
	public int getRecommend() {
		return recommend;
	}

	/**
	 * @param recommend the recommend to set
	 */
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "UserVO [u_id=" + u_id + ", name=" + name + ", passwd=" + passwd + ", level=" + level + ", login="
				+ login + ", recommend=" + recommend + ", email=" + email + ", regDt=" + regDt + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + login;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + recommend;
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (level != other.level)
			return false;
		if (login != other.login)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (recommend != other.recommend)
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		return true;
	}

	

	
}
