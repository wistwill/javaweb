import base.BaseTest;
import com.ian.commons.shiro.PasswordHash;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Encoder;
@Log4j2
public class test extends BaseTest {

	@Autowired PasswordHash passwordHash;

	@Test
	public void aaa() {
		//        String aa = StringUtils.getUUId();
		//        String aa = "5aaC5qKm5oqA5pyvAAAAAA==";
		//        String aa = "dGVzdA==";
		String aa = "test";
		//        String pwd = passwordHash.toHex("admin", aa);
		String pwd = passwordHash.toHex( "test", aa );
		System.out.println( pwd );
	}

	/**
	 *将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 */
	@Test
	public void Base64Test(){
		//图片转化成base64字符串
		String imgFile = ";//待处理的图片
		InputStream in = null;
		byte[] data = null;
		//读取图片字节数组
		try {
			in = new FileInputStream( imgFile );
			data = new byte[ in.available() ];
			in.read( data );
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		encoder.encode( data );//Base64编码过的字节数组字符串
		log.info( "encoder:" + encoder.encode( data ) );
	}
}