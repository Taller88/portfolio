/**
 * 
 */
package com.sist.spring.member.service;

public enum Level {
	
	//BASIC(1),SILVER(2),GOLD(3); //?Έ κ°μ ?΄?Έ ?€λΈμ ?Έ 	?΄λ¦μΌλ‘? ? κ·Όκ??₯?΄μ§??κ²? ?° ?₯? 
	GOLD(3, null),SILVER(2, GOLD), BASIC(1,SILVER);		//?€?? λΆ??° λ§λ¬
	
	private final int value;
	
	private final Level next;//?€??¨κ³μ Level
	
	//??΄?Έ? ?λ§λ ?€. κ·Έλ₯? λ²¨μ? λ§λ€λ©? ??¨
	
	Level(int value,Level next) {
		//??±?λ₯? ?΅?΄? 1,2,3? λ§λ¬ (enum?? public ??±?? λΆκ??₯)
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
	
	
	//value κ°?? Έ?€? λ°©λ²(vo?? getLevel κ°?? Έ?€κ³? ??)
	public int intValue() {
		return value;
	}
	
	
	//DB?? intκ°μ Level??Όλ‘? λ³??(vo?? setLevel? ? ??)
	public static Level valueOf(int value) {
		switch(value) {
			case 1: return BASIC;
			case 2: return SILVER;
			case 3: return GOLD;
			default: throw new AssertionError("Unknown value");
		}
	}
	
}
