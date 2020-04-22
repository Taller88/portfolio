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
	
	//?¸?„°?˜?´?Š¤ë¥? ?ƒ?†ë°›ëŠ” ê²½ìš° 2ê°?ì§?
	//ë§Œì•½ ?–´?…¸?…Œ?´?…˜?œ¼ë¡œë§Œ ê°ì²´ ?ƒ?„±(xml?‚¬?š©x) - ex)ê¸°ë³¸? ?¸bean ê°ì²´ê°™ì?ê²ƒì? Repository("ê°?")ì£¼ê³  ?“°ê³? ?‹¶??ê³³ì—?„œ 	
	//						   		  @Autowired ?•˜ê³? ë³??ˆ˜ ?„ ?–¸?•  ?•Œ "ê°?"?œ¼ë¡? ?„ ?–¸	(?”„ë¡œì ?Š¸ eHR0504_WEB?˜ TestWeb ?ŒŒ?¼ ì°¸ê³ )
	//xml?— ?ˆ?„?•Œ?Š” ?´?Ÿ°ë°©ì‹?œ¼ë¡? ê°??Š¥ - ex)@Qualifier ?‚¬?š©
	
	@Autowired
	private UserDao userDao;		//?¸?„°?˜?´?Š¤ë¡? ë°›ìŒ (ê²°êµ­ ?¸?„°?˜?´?Š¤ë¥? êµ¬í˜„?•œ ê°ì²´ê°? ì£¼ì…?¨)
	
	@Autowired						//idê°’ì„ ?„£?–´ì£¼ë©´ ?´ê°ì²´ê°? ?“¤?–´?˜¨?‹¤. ê°™ì? ?¸?„°?˜?´?Š¤ ì°¸ì¡°?• ?•Œ
	@Qualifier("mailSender")		//root-context.xml?˜ bean?˜ idê°’ì„ ì£¼ë©´ ê·? ê°ì²´ ?‚¬?š©?•˜?Š”ê²ƒì„(dummyMailSenderì£¼ë©´ ê·¸ê±° ?‘?™)
	private MailSender mailSender;
	
	
	public UserServiceImple() {}
	
	
	
	
	
	/**
	 * Spring									javax.mail
	 * -------------------------------- 		-----------
	 * SimpleMailMessage		 				MimeMessage
	 * MailSender : 							Transport
	 * JavaMailSenderImpl(MailSender?˜ êµ¬í˜„ì²´ì´?‹¤)
	 * -------------------------------- 		-----------
	 * ?“±?—…?œ ?‚¬?š©??—ê²? ë©”ì¼? „?†¡
	 * @param user
	 */
	private void sendUpgradeEmail(UserVO user) {
		/*
		 POP ?„œë²„ëª… : pop.naver.com
		 SMTP ?„œë²„ëª… : smtp.naver.com
		 POP ?¬?Š¸ : 995, ë³´ì•ˆ?—°ê²?(SSL) ?•„?š”
		 SMTP ?¬?Š¸ : 465, ë³´ì•ˆ ?—°ê²?(SSL) 
		  ?•„?š”?•„?´?”” : wogns_20
		  ë¹„ë?ë²ˆí˜¸ : ?„¤?´ë²? ë¡œê·¸?¸ ë¹„ë?ë²ˆí˜¸
		*/
		
		//-----------------------------------
		//ë°›ëŠ”?‚¬?Œ
		//? œëª?
		//?‚´?š©
		//-----------------------------------
		
		String recipient = user.getEmail();//ë°›ëŠ”?‚¬?Œ
		String title = user.getName() + "?‹˜ ?“±?—…(https://cafe.naver.com/kndjang)"; //? œëª?
		//user.getLevel().name() enum?„ STring?œ¼ë¡? ë³??™˜?•˜?Š” ?•¨?ˆ˜ê°? name()
		String contents = user.getU_id() + "?‹˜ ?“±ê¸‰ì´\n"+user.getLevel().name()+"ë¡? ?“±?—…?˜?—ˆ?Šµ?‹ˆ?‹¤.";//?‚´?š© 
		
		//-----------------------------------
		//Message?— ë°›ëŠ”?‚¬?Œ,? œëª?,?‚´?š©,?¸ì¦? ?„¸?Œ… ?›„ ? „?†¡
		//? „?†¡: Java
		//-----------------------------------
		
		
		SimpleMailMessage mimeMessage = new SimpleMailMessage();	//?„¸?…˜?´ ?—†?Œ, xml?—?„œ ë§Œë“¬
	
		mimeMessage.setFrom("wogns_20@naver.com"); //ë³´ë‚´?Š” ?‚¬?Œ
		//ë°›ëŠ”?‚¬?Œ
		mimeMessage.setTo(recipient);
		
		mimeMessage.setSubject(title);//? œëª?
		mimeMessage.setText(contents);//?‚´?š©
		
		//? „?†¡
		mailSender.send(mimeMessage);
		
		LOG.debug("=====================");
		LOG.debug("mail send to =" + recipient);
		LOG.debug("=====================");
		
	}
	
	
	
//	/**
//	 * ?“±?—…?œ ?‚¬?š©??—ê²? ë©”ì¼? „?†¡ (javax.mail?‚¬?š©)
//	 * @param user
//	 */
//	private void sendUpgradeEmail(UserVO user) {
//		/*
//		 POP ?„œë²„ëª… : pop.naver.com
//		 SMTP ?„œë²„ëª… : smtp.naver.com
//		 POP ?¬?Š¸ : 995, ë³´ì•ˆ?—°ê²?(SSL) ?•„?š”
//		 SMTP ?¬?Š¸ : 465, ë³´ì•ˆ ?—°ê²?(SSL) 
//		  ?•„?š”?•„?´?”” : wogns_20
//		  ë¹„ë?ë²ˆí˜¸ : ?„¤?´ë²? ë¡œê·¸?¸ ë¹„ë?ë²ˆí˜¸
//		*/
//		String smtpHost ="smtp.naver.com";
//		final String userId = "wogns_20";
//		final String userPass = "@chl1995314@";
//		int port = 465;
//		//-----------------------------------
//		//ë°›ëŠ”?‚¬?Œ
//		//? œëª?
//		//?‚´?š©
//		//SMTP?„œë²? ?„¤? •
//		//?¸ì¦?
//		//-----------------------------------		
//		String recipient = user.getEmail();//ë°›ëŠ”?‚¬?Œ
//		String title = user.getName() + "?‹˜ ?“±?—…(https://cafe.naver.com/kndjang)"; //? œëª?
//		//user.getLevel().name() enum?„ STring?œ¼ë¡? ë³??™˜?•˜?Š” ?•¨?ˆ˜ê°? name()
//		String contents = user.getU_id() + "?‹˜ ?“±ê¸‰ì´\n"+user.getLevel().name()+"ë¡? ?“±?—…?˜?—ˆ?Šµ?‹ˆ?‹¤.";//?‚´?š© 
//		Properties props = System.getProperties();//SMTP?„œë²? ?„¤? •
//		props.put("mail.smtp.host", smtpHost);
//		props.put("mail.smtp.port", port);
//		props.put("mail.smtp.auth", true);
//		props.put("mail.smtp.ssl.enable", true);
//		props.put("mail.smtp.ssl.trust", smtpHost);
//		
//		//?¸ì¦?
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
//		//Message?— ë°›ëŠ”?‚¬?Œ,? œëª?,?‚´?š©,?¸ì¦? ?„¸?Œ… ?›„ ? „?†¡
//		//? „?†¡: Java
//		//-----------------------------------
//		Message mimeMessage = new MimeMessage(session);
//		try {
//			mimeMessage.setFrom(new InternetAddress("wogns_20@naver.com")); //ë³´ë‚´?Š” ?‚¬?Œ
//			//ë°›ëŠ”?‚¬?Œ
//			mimeMessage.setRecipient(Message.RecipientType.TO
//					, new InternetAddress(recipient)); //CC?Š” ì°¸ì¡°/ BCC?Š” ?ˆ¨??ì°¸ì¡° / TO?Š” ?•œ?‚¬?Œ
//			
//			mimeMessage.setSubject(title);//? œëª?
//			mimeMessage.setText(contents);//?‚´?š©
//			
//			//? „?†¡
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
	   * ìµœì´ˆê°??…?‹œ : Level.BASIC
	   * @param user
	   */
	public int add(UserVO user) {
		  //Level null -> Level.BASIC
		if(null == user.getLevel()) {
			user.setLevel(Level.BASIC);
		}
		
	    return userDao.doInsert(user);
		
	}
	
	
	//?“±?—…ì¡°ê±´				
	private boolean canUpgradeLevel(UserVO user){				
		Level currentLevel =user.getLevel();
		
		switch(currentLevel) {
			case BASIC: return user.getLogin()>= MIN_LOGINCOUNT_FOR_SILVER;
			case SILVER: return user.getRecommend()>= MIN_RECCOMENDCOUNT_FOR_GOD;
			case GOLD: return false;
			default: throw new IllegalArgumentException("Unknown Level" + currentLevel);
			
		} 
		
	}	
	
	
	
	
	//? ˆë²¨ì—…ê·¸ë ˆ?´?“œ 
	public void upgradeLevel(UserVO user) {
		//BASIC -> SILVER
		//SILVER -> GOLD
		
//		Level currentLevel =user.getLevel();
		
		//GOLD(3, null),SILVER(2, GOLD), BASIC(1,SILVER) ?˜•?ƒœë¡? enum ë³??™˜?–ˆ?Œ
		Level nextLevel =user.getLevel().getNextLevel();
		
		if(null == nextLevel) {
			//Goldê°? ?“¤?–´?˜¤ë©? ?˜ˆ?™¸(ë§ˆì?ë§‰êº¼ j05_128) ê·¸ëƒ¥ ì½˜ì†”ë§? ì°ê¸°?š©
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			LOG.debug(user.getLevel()+"?? ?—…ê·¸ë ˆ?´?“œ ë¶ˆê??Š¥ ?•©?‹ˆ?‹¤.");
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			throw new IllegalArgumentException(user.getLevel() + "?? ?—…ê·¸ë ˆ?´?“œ ë¶ˆê??Š¥ ?•©?‹ˆ?‹¤.");
		} else {
			//?‚˜ë¨¸ì? ?°?´?„°?“¤
			//BASIC -> SILVER
			//SILVER -> GOLD
			user.setLevel(nextLevel);
		}
		
		//?—¬ê¸°ê¹Œì§? ?‚´? ¤?˜¤ë©? BASIC, SILVER, SILVER, GOLD, GOLD ?œ?ƒ?ƒœ?„
		
		//?Š¸?œ?­?…˜ì²˜ë¦¬
		//GOLD?? ?—…ê·¸ë ˆ?´?“œ ë¶ˆê??Š¥ sss?•©?‹ˆ?‹¤.(j04_128)
		//?˜ˆ?‹œë¡? ë¡¤ë°± ì¼??´?Š¤ ë§Œë“ ê²ƒì„, Transaction ?˜ˆ?™¸ ë°œìƒ?š©
		//ex)test-applicationContext.xml?—?„œ pointcut?´?‚˜ ë©”ì†Œ?“œ ? œ??ë¡? ì£¼ë©´ 2ë²? ?—…ê·¸ë ˆ?´?“œ?˜ê³? 4ë²ˆì°¨ë¡??—?„œ ë¬´ì¡°ê±? ?˜ˆ?™¸ê±¸ë¦¬ê²? ?•˜ë¯?ë¡?
		//   2ë²? 4ë²? ?‘˜?‹¤ ?—…ê·¸ë ˆ?´?“œ ?•ˆ?¨
		//ex)test-applicationContext.xml?—?„œ pointcut?´?‚˜ ë©”ì†Œ?“œ ?‹¤ë¥´ê²Œ ì£¼ë©´(?Š¸?œ?­?…˜?•ˆ??ê²?) 
		//   j04_128?¼?•Œ?Š” ?•„?˜?—?„œ ?˜ˆ?™¸ê±¸ë¦¬ë¯?ë¡? ?˜ˆ?™¸??ê³?(?—…ê·¸ë ˆ?´?“œ?•ˆ?¨) ?‚˜ë¨¸ì? ?°?´?„°?Š” ë¡¤ë°±ì²˜ë¦¬?Š” ?•ˆ?¨(ì¦? j02_128?Š” ?˜ˆ?™¸?„ ?•ˆ??ë¯?ë¡? upgrade?¨)
		//?•„?˜ ì£¼ì„?„ ë§‰ìœ¼ë©? rollback?•ˆ?œ ?ƒ?ƒœë¡? ê·¸ëƒ¥ ?‹¤ ?—…ê·¸ë ˆ?´?“œ ?¨!(ë§ˆì?ë§‰ì—?Š” ë§‰ìœ¼ë©´ë¨ ?Š¸?œ?­?…˜?†Œ?Š¤?Š” ë°°í¬?•ˆ?•˜?Š”ê²ƒì„)
		String id ="j04_128";
		if(user.getU_id().equals(id)) {
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			LOG.debug(user.getLevel() + "?? ?—…ê·¸ë ˆ?´?“œ ë¶ˆê??Š¥ ?•©?‹ˆ?‹¤.");
			LOG.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			throw new IllegalArgumentException(user.getLevel() + "?? ?—…ê·¸ë ˆ?´?“œ ë¶ˆê??Š¥ sss?•©?‹ˆ?‹¤.");
		}

		userDao.doUpdate(user);
		
		//mail send
		sendUpgradeEmail(user);
		
		
	}
	
	/**
	 * ?Š¸?œ?­?…˜ ì½”ë“œê°? ?†Œ?Š¤?—?„œ ?‚¬?¼ì§? : UserServiceTxë¡? ?´?™?‹œ?‚¨?›„ (DI)?†µ?•´ ì£¼ì… ë¶?ê°?ê¸°ëŠ¥ ë¶??—¬.
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
	public void upgradeLevels(UserVO userVO) throws Exception {
		//?Š¸?œ?­?…˜ê¸°ëŠ¥?„ ?™¸ë¶??—?„œ ?„£?–´ì¤?ê²? UserServiceTx
		List<UserVO> list = (List<UserVO>) userDao.getAll(userVO);
		for(UserVO user:list) {
			if(canUpgradeLevel(user)==true ) {		//upgrade???ƒ ?„ ë³?
				upgradeLevel(user);					//upgrade?ˆ˜?–‰
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
