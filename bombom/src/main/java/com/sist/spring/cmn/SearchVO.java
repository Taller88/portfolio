/**
 * 
 */
package com.sist.spring.cmn;

/**
 * @author sist
 *
 */
public class SearchVO extends DTO {
	//?éò?ù¥Ïß? ?Ç¨?ù¥Ï¶?
	private int pageSize;
	//?éò?ù¥Ïß? num
	private int pageNum;
	
	//Í≤??ÉâÍµ¨Î∂Ñ
	private String searchDiv;
	
	//Í≤??Éâ?ñ¥
	private String searchWord;
	
	public SearchVO() {}

	

	public SearchVO(int pageSize, int pageNum, String searchDiv, String searchWord) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
	}
	
	


	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}



	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}



	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	/**
	 * @return the searchDiv
	 */
	public String getSearchDiv() {
		return searchDiv;
	}

	/**
	 * @param searchDiv the searchDiv to set
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	/**
	 * @return the searchWord
	 */
	public String getSearchWord() {
		return searchWord;
	}

	/**
	 * @param searchWord the searchWord to set
	 */
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}



	@Override
	public String toString() {
		return "SearchVO [pageSize=" + pageSize + ", pageNum=" + pageNum + ", searchDiv=" + searchDiv + ", searchWord="
				+ searchWord + ", toString()=" + super.toString() + "]";
	}

	
	
}
