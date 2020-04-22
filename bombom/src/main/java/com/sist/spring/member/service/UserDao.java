package com.sist.spring.member.service;

import java.util.List;

import com.sist.spring.cmn.DTO;

public interface UserDao {
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
	 * ? „ì²´ì¡°?šŒ
	 * @param dto
	 * @return List<DTO>
	 */
	public List<?> getAll(DTO dto);
}
