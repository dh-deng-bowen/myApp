package iApp.service.servicefactory;

import iApp.service.servicefactory.proxy.proxyfactory.ProxyFactory;
import iApp.service.services.interfaces.ITestSV;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by dh.deng.bowen on 2017/3/8.
 */
public class AppServiceHandler {

    private static Log log = LogFactory.getLog("AppServiceHandler");

    public static <T> T getService(Class<T> interfacee) throws Exception{

        if (null != interfacee) {

            return (T) ProxyFactory.getAppProxy(getInstance(interfacee));
        }

        return null;
    }

    private static <T> T getInstance(Class<T> interfacee) throws Exception {

        T t = null;

        try{
            StringBuffer implNameBuffer = new StringBuffer("");

            String tempName = interfacee.getName().replaceAll("interfaces", "impls");
            String[] temp = tempName.split("\\.");
            String interfaceName = temp[temp.length - 1];

            if (interfaceName == null || "".equals(interfaceName)) {

                return null;
            }

            if (!interfaceName.startsWith("I")) {

                throw new Exception("接口命名不规范");
            }

            if (!interfaceName.endsWith("SV")) {

                throw new Exception("接口命名不规范");
            }

            temp[temp.length - 1] = temp[temp.length - 1].substring(1) + "Impl";

            for (int i = 0; i < temp.length - 1; i ++) {

                implNameBuffer.append(temp[i]).append(".");
            }

            implNameBuffer.append(interfaceName.substring(1));
            implNameBuffer.append("Impl");

            t =  (T) Class.forName(implNameBuffer.toString()).newInstance();
        }catch(Exception e){

            log.error(e);
            return null;
        }

        return t;
    }

    public static void main(String[] args) throws Exception{

        ITestSV sv = AppServiceHandler.getService(ITestSV.class);
        sv.printout();
        System.out.println("Finish");
    }
}
