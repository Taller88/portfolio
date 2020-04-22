/**
 * 
 */
package com.sist.spring.member.service;

public enum Level {
	
	//BASIC(1),SILVER(2),GOLD(3); //?„¸ ê°œì˜ ?´?‡¸ ?˜¤ë¸Œì ?Š¸ 	?´ë¦„ìœ¼ë¡? ? ‘ê·¼ê??Š¥?•´ì§??Š”ê²? ?° ?¥? 
	GOLD(3, null),SILVER(2, GOLD), BASIC(1,SILVER);		//?’¤?—?„œ ë¶??„° ë§Œë“¬
	
	private final int value;
	
	private final Level next;//?‹¤?Œ?‹¨ê³„ì˜ Level
	
	//?””?´?Š¸?Š” ?•ˆë§Œë“ ?‹¤. ê·¸ëƒ¥? ˆë²¨ì? ë§Œë“¤ë©? ?•ˆ?¨
	
	Level(int value,Level next) {
		//?ƒ?„±?ë¥? ?†µ?•´?„œ 1,2,3?„ ë§Œë“¬ (enum?—?„œ public ?ƒ?„±??Š” ë¶ˆê??Š¥)
		this.value = value;
		this.next = next;
	}
	
	/**
	 * Next Level
	 * @return Level
	 */
	public Level getNextLevel() { //getter
		return this.next;
	}
	
	
	//value ê°?? ¸?˜¤?Š” ë°©ë²•(vo?—?„œ getLevel ê°?? ¸?˜¤ê³? ?•„?š”)
	public int intValue() {
		return value;
	}
	
	
	//DB?—?Š” intê°’ì„ Level?˜•?œ¼ë¡? ë³??™˜(vo?—?„œ setLevel?• ?•Œ ?•„?š”)
	public static Level valueOf(int value) {
		switch(value) {
			case 1: return BASIC;
			case 2: return SILVER;
			case 3: return GOLD;
			default: throw new AssertionError("Unknown value");
		}
	}
	
}
