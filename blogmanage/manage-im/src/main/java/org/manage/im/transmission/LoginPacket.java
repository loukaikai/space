package org.manage.im.transmission;

 
import org.manage.im.transmission.packet.Packet;
import org.manage.im.utils.CommandConstant;

import lombok.Data;

/** 
 * @ClassName: LoginPacket
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月8日 下午5:00:31
 */
@Data
public class LoginPacket implements Packet {
	
	private Integer userId;
	
	private String userName;
	
	private String passWord;
	
	@Override
	public int getCommand() {
		return CommandConstant.LOGIN_QUEST;
	}

}
