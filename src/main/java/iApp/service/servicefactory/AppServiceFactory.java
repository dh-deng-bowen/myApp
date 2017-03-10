package iApp.service.servicefactory;

import iApp.service.services.interfaces.ITestSV;

/**
 * Created by dh.deng.bowen on 2017/3/8.
 */
public class AppServiceFactory {

    public static <T> T getService(Class<T> clazz) throws Exception{

        return (T) AppServiceHandler.getService(clazz);
    }
}