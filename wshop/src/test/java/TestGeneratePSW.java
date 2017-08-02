import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Administrator on 2017/7/30.
 */
public class TestGeneratePSW {

    public  static  void main(String args[]) throws  Exception{
        String password = "123456";
        System.out.println(generatePSW(password));
    }

    public static String generatePSW(String psw) throws  Exception{
        Md5Hash md51 = new Md5Hash(new Md5Hash(psw));
        System.out.println("psw1:"+md51+",salt:"+md51.getSalt()+",times:"+md51.getIterations());
        return md51.toString();
    }

}
