package com.sist.spring.member.service;

import java.sql.SQLException;
import java.util.List;

import com.sist.spring.cmn.DTO;



public interface UserService {

	/**
	 * ?“±ë¡?
	 * @param dto
	 * @return int
	 */
	public int doInsert(DTO dto);
	
	/**
	 * ?ˆ˜? •
	 * @param dto
	 * @return int
	 */
	public int doUpdate(DTO dto);
	
	/**
	 * ?‹¨ê±´ì¡°?šŒ
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto);
	
	/**
	 * ?‚­? œ
	 * @param dto
	 * @return int
	 */
	public int doDelete(DTO dto);
	
	/**
	 * ëª©ë¡ì¡°íšŒ
	 * @param dto
	 * @return List<DTO>
	 */
	public List<?> doRetrieve(DTO dto);
	
	/**
     * ìµœì´ˆê°??…?‹œ : Level.BASIC
     * @param user
     */
	int add(UserVO user);

	/**
	 * ?‚¬?š©? ?“±?—…
	 * 1. ? „ì²? ?‚¬?š©?ë¥? ?½?–´ ?“¤?¸?‹¤.
	 * 2. ?“±?—… ???ƒ? ?„ ë³„í•œ?‹¤.
	 *   2.1. BASIC ?‚¬?š©?: ë¡œê·¸?¸ CNT 50  ?´?ƒ(=?¬?•¨)?´ë©? -> SILVER
	 *   2.2. SILVER ?‚¬?š©? : ì¶”ì²œCNT 30?´?ƒ?´ë©? (=?¬?•¨)?´ë©? -> GOLD
	 *   2.3. GOLD???ƒ ?•„?‹˜
	 * 3. ?“±?—…?•œ?‹¤.
	 * @throws SQLException 
	 * 
	 */
	void upgradeLevels(UserVO userVO) throws Exception;

}