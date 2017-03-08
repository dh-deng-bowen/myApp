package iApp.service.servicefactory.proxy.proxyfactory;

import iApp.service.servicefactory.proxy.proxyservice.AppProxyHandler;

import java.lang.reflect.Proxy;

/**
 * Created by dh.deng.bowen on 2017/3/8.
 */
public class ProxyFactory {

    public static Object getAppProxy(Object obj) {

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AppProxyHandler(obj));
    }
}
