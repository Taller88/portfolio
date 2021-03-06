package com.sist.spring.member.service.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.sist.spring.cmn.DTO;
import com.sist.spring.member.service.Level;
import com.sist.spring.member.service.UserDao;
import com.sist.spring.member.service.UserService;
import com.sist.spring.member.service.UserVO;

import javax.mail.*;
import javax.mail.internet.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * 		case BASIC: return user.getLogin()>=50;
			case SILVER: return user.getRecommend()>=30;
	 */
	public static final int MIN_LOGINCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMENDCOUNT_FOR_GOD = 30;
	
	//?Έ?°??΄?€λ₯? ??λ°λ κ²½μ° 2κ°?μ§?
	//λ§μ½ ?΄?Έ??΄??Όλ‘λ§ κ°μ²΄ ??±(xml?¬?©x) - ex)κΈ°λ³Έ? ?Έbean κ°μ²΄κ°μ?κ²μ? Repository("κ°?")μ£Όκ³  ?°κ³? ?Ά??κ³³μ? 	
	//						   		  @Autowired ?κ³? λ³?? ? ?Έ?  ? "κ°?"?Όλ‘? ? ?Έ	(?λ‘μ ?Έ eHR0504_WEB? TestWeb ??Ό μ°Έκ³ )
	//xml? ???? ?΄?°λ°©μ?Όλ‘? κ°??₯ - ex)@Qualifier ?¬?©
	
	@Autowired
	private UserDao userDao;		//?Έ?°??΄?€λ‘? λ°μ (κ²°κ΅­ ?Έ?°??΄?€λ₯? κ΅¬ν? κ°μ²΄κ°? μ£Όμ?¨)
	
	@Autowired						//idκ°μ ?£?΄μ£Όλ©΄ ?΄κ°μ²΄κ°? ?€?΄?¨?€. κ°μ? ?Έ?°??΄?€ μ°Έμ‘°? ?
	@Qualifier("mailSender")		//root-context.xml? bean? idκ°μ μ£Όλ©΄ κ·? κ°μ²΄ ?¬?©??κ²μ(dummyMailSenderμ£Όλ©΄ κ·Έκ±° ??)
	private MailSender mailSender;
	
	
	public UserServiceImple() {}
	
	
	
	
	
	/**
	 * Spring									javax.mail
	 * -------------------------------- 		-----------
	 * SimpleMailMessage		 				MimeMessage
	 * MailSender : 							Transport
	 * JavaMailSenderImpl(MailSender? κ΅¬νμ²΄μ΄?€)
	 * -------------------------------- 		-----------
	 * ?±?? ?¬?©??κ²? λ©μΌ? ?‘
	 * @param user
	 */
	private void sendUpgradeEmail(UserVO user) {
		/*
		 POP ?λ²λͺ : pop.naver.com
		 SMTP ?λ²λͺ : smtp.naver.com
		 POP ?¬?Έ : 995, λ³΄μ?°κ²?(SSL) ??
		 SMTP ?¬?Έ : 465, λ³΄μ ?°κ²?(SSL) 
		  ????΄? : wogns_20
		  λΉλ?λ²νΈ : ?€?΄λ²? λ‘κ·Έ?Έ λΉλ?λ²νΈ
		*/
		
		//-----------------------------------
		//λ°λ?¬?
		//? λͺ?
		//?΄?©
		//-----------------------------------
		
		String recipient = user.getEmail();//λ°λ?¬?
		String title = user.getName() + "? ?±?(https://cafe.naver.com/kndjang)"; //? λͺ?
		//user.getLevel().name() enum? STring?Όλ‘? λ³???? ?¨?κ°? name()
		String contents = user.getU_id() + "? ?±κΈμ΄\n"+user.getLevel().name()+"λ‘? ?±????΅??€.";//?΄?© 
		
		//-----------------------------------
		//Message? λ°λ?¬?,? λͺ?,?΄?©,?Έμ¦? ?Έ? ? ? ?‘
		//? ?‘: Java
		//-----------------------------------
		
		
		SimpleMailMessage mimeMessage = new SimpleMailMessage();	//?Έ??΄ ??, xml?? λ§λ¬
	
		mimeMessage.setFrom("wogns_20@naver.com"); //λ³΄λ΄? ?¬?
		//λ°λ?¬?
		mimeMessage.setTo(recipient);
		
		mimeMessage.setSubject(title);//? λͺ?
		mimeMessage.setText(contents);//?΄?©
		
		//? ?‘
		mailSender.send(mimeMessage);
		
		LOG.debug("=====================");
		LOG.debug("mail send to =" + recipient);
		LOG.debug("=====================");
		
	}
	
	
	
//	/**
//	 * ?±?? ?¬?©??κ²? λ©μΌ? ?‘ (javax.mail?¬?©)
//	 * @param user
//	 */
//	private void sendUpgradeEmail(UserVO user) {
//		/*
//		 POP ?λ²λͺ : pop.naver.com
//		 SMTP ?λ²λͺ : smtp.naver.com
//		 POP ?¬?Έ : 995, λ³΄μ?°κ²?(SSL) ??
//		 SMTP ?¬?Έ : 465, λ³΄μ ?°κ²?(SSL) 
//		  ????΄? : wogns_20
//		  λΉλ?λ²νΈ : ?€?΄λ²? λ‘κ·Έ?Έ λΉλ?λ²νΈ
//		*/
//		String smtpHost ="smtp.naver.com";
//		final String userId = "wogns_20";
//		final String userPass = "@chl1995314@";
//		int port = 465;
//		//-----------------------------------
//		//λ°λ?¬?
//		//? λͺ?
//		//?΄?©
//		//SMTP?λ²? ?€? 
//		//?Έμ¦?
//		//-----------------------------------		
//		String recipient = user.getEmail();//λ°λ?¬?
//		String title = user.getName() + "? ?±?(https://cafe.naver.com/kndjang)"; //? λͺ?
//		//user.getLevel().name() enum? STring?Όλ‘? λ³???? ?¨?κ°? name()
//		String contents = user.getU_id() + "? ?±κΈμ΄\n"+user.getLevel().name()+"λ‘? ?±????΅??€.";//?΄?© 
//		Properties props = System.getProperties();//SMTP?λ²? ?€? 
//		props.put("mail.smtp.host", smtpHost);
//		props.put("mail.smtp.port", port);
//		props.put("mail.smtp.auth", true);
//		props.put("mail.smtp.ssl.enable", true);
//		props.put("mail.smtp.ssl.trust", smtpHost);
//		
//		//?Έμ¦?
//		Session session = Session.getInstance(props, new Authenticator() {
//			String uName = userId;
//			String passwd = userPass;
//			
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(uName,passwd);
//			}
//			
//		});
//		
//		session.setDebug(true);
//		
//		//-----------------------------------
//		//Message? λ°λ?¬?,? λͺ?,?΄?©,?Έμ¦? ?Έ? ? ? ?‘
//		//? ?‘: Java
//		//-----------------------------------
//		Message mimeMessage = new MimeMessage(session);
//		try {
//			mimeMessage.setFrom(new InternetAddress("wogns_20@naver.com")); //λ³΄λ΄? ?¬?
//			//λ°λ?¬?
//			mimeMessage.setRecipient(Message.RecipientType.TO
//					, new InternetAddress(recipient)); //CC? μ°Έμ‘°/ BCC? ?¨??μ°Έμ‘° / TO? ??¬?
//			
//			mimeMessage.setSubject(title);//? λͺ?
//			mimeMessage.setText(contents);//?΄?©
//			
//			//? ?‘
//			Transport.send(mimeMessage);
//			
//			
//		} catch (AddressException e) {
//			LOG.debug("=====================");
//			LOG.debug("AddressException=" + e.getMessage());
//			LOG.debug("=====================");
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			LOG.debug("=====================");
//			LOG.debug("MessagingException=" + e.getMessage());
//			LOG.debug("=====================");
//			e.printStackTrace();
//		}		
//		
//		LOG.debug("=====================");
//		LOG.debug("mail send to =" + recipient);
//		LOG.debug("=====================");
//		
//	}
	
	/**
	   * μ΅μ΄κ°??? : Level.BASIC
	   * @param user
	   */
	public int add(UserVO user) {
		  //Level null -> Level.BASIC
		if(null == user.getLevel()) {
			user.setLevel(Level.BASIC);
		}
		
	    return userDao.doInsert(user);
		
	}
	
	
	//?±?μ‘°κ±΄				
	private boolean canUpgradeLevel(UserVO user){				
		Level currentLevel =user.getLevel();
		
		switch(currentLevel) {
			case BASIC: return user.getLogin()>= MIN_LOGINCOUNT_FOR_SILVER;
			case SILVER: return user.getRecommend()>= MIN_RECCOMENDCOUNT_FOR_GOD;
			case GOLD: return false;
			default: throw new IllegalArgumentException("Unknown Level" + currentLevel);
			
		} 
		
	}	
	
	
	
	
	//? λ²¨μκ·Έλ ?΄? 
	public void upgradeLevel(UserVO user) {
		//BASIC -> SILVER
		//SILVER -> GOLD
		
//		Level currentLevel =user.getLevel();
		
		//GOLD(3, null),SILVER(2, GOLD), BASIC(1,SILVER) ??λ‘? enum λ³????
		Level nextLevel =user.getLevel().getNextLevel();
		
		if(null == nextLevel) {
			//Goldκ°? ?€?΄?€λ©? ??Έ(λ§μ?λ§κΊΌ j05_128) κ·Έλ₯ μ½μλ§? μ°κΈ°?©
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			LOG.debug(user.getLevel()+"?? ?κ·Έλ ?΄? λΆκ??₯ ?©??€.");
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			throw new IllegalArgumentException(user.getLevel() + "?? ?κ·Έλ ?΄? λΆκ??₯ ?©??€.");
		} else {
			//?λ¨Έμ? ?°?΄?°?€
			//BASIC -> SILVER
			//SILVER -> GOLD
			user.setLevel(nextLevel);
		}
		
		//?¬κΈ°κΉμ§? ?΄? €?€λ©? BASIC, SILVER, SILVER, GOLD, GOLD ????
		
		//?Έ??­?μ²λ¦¬
		//GOLD?? ?κ·Έλ ?΄? λΆκ??₯ sss?©??€.(j04_128)
		//??λ‘? λ‘€λ°± μΌ??΄?€ λ§λ κ²μ, Transaction ??Έ λ°μ?©
		//ex)test-applicationContext.xml?? pointcut?΄? λ©μ? ? ??λ‘? μ£Όλ©΄ 2λ²? ?κ·Έλ ?΄??κ³? 4λ²μ°¨λ‘??? λ¬΄μ‘°κ±? ??Έκ±Έλ¦¬κ²? ?λ―?λ‘?
		//   2λ²? 4λ²? ??€ ?κ·Έλ ?΄? ??¨
		//ex)test-applicationContext.xml?? pointcut?΄? λ©μ? ?€λ₯΄κ² μ£Όλ©΄(?Έ??­????κ²?) 
		//   j04_128?Ό?? ???? ??Έκ±Έλ¦¬λ―?λ‘? ??Έ??κ³?(?κ·Έλ ?΄???¨) ?λ¨Έμ? ?°?΄?°? λ‘€λ°±μ²λ¦¬? ??¨(μ¦? j02_128? ??Έ? ???λ―?λ‘? upgrade?¨)
		//?? μ£Όμ? λ§μΌλ©? rollback?? ??λ‘? κ·Έλ₯ ?€ ?κ·Έλ ?΄? ?¨!(λ§μ?λ§μ? λ§μΌλ©΄λ¨ ?Έ??­???€? λ°°ν¬???κ²μ)
		String id ="j04_128";
		if(user.getU_id().equals(id)) {
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			LOG.debug(user.getLevel() + "?? ?κ·Έλ ?΄? λΆκ??₯ ?©??€.");
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			throw new IllegalArgumentException(user.getLevel() + "?? ?κ·Έλ ?΄? λΆκ??₯ sss?©??€.");
		}

		userDao.doUpdate(user);
		
		//mail send
		sendUpgradeEmail(user);
		
		
	}
	
	/**
	 * ?Έ??­? μ½λκ°? ??€?? ?¬?Όμ§? : UserServiceTxλ‘? ?΄???¨? (DI)?΅?΄ μ£Όμ λΆ?κ°?κΈ°λ₯ λΆ??¬.
	 * ?¬?©? ?±?
	 * 1. ? μ²? ?¬?©?λ₯? ?½?΄ ?€?Έ?€.
	 * 2. ?±? ???? ? λ³ν?€.
	 *   2.1. BASIC ?¬?©?: λ‘κ·Έ?Έ CNT 50  ?΄?(=?¬?¨)?΄λ©? -> SILVER
	 *   2.2. SILVER ?¬?©? : μΆμ²CNT 30?΄??΄λ©? (=?¬?¨)?΄λ©? -> GOLD
	 *   2.3. GOLD??? ??
	 * 3. ?±???€.
	 * @throws SQLException 
	 * 
	 */
	public void upgradeLevels(UserVO userVO) throws Exception {
		//?Έ??­?κΈ°λ₯? ?ΈλΆ??? ?£?΄μ€?κ²? UserServiceTx
		List<UserVO> list = (List<UserVO>) userDao.getAll(userVO);
		for(UserVO user:list) {
			if(canUpgradeLevel(user)==true ) {		//upgrade??? ? λ³?
				upgradeLevel(user);					//upgrade??
			}
		}//for
	
	}

	@Override
	public int doInsert(DTO dto) {
		return userDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return userDao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return userDao.doSelectOne(dto);
	}

	@Override
	public int doDelete(DTO dto) {
		return userDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return userDao.doRetrieve(dto);
	}
	
	
}
