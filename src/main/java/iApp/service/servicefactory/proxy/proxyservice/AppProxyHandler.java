package iApp.service.servicefactory.proxy.proxyservice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by dh.deng.bowen on 2017/3/8.
 */
public class AppProxyHandler implements InvocationHandler{

    private Object obj;

    public AppProxyHandler(Object obj) {

        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object rtn = method.invoke(obj, args);
        return rtn;
    }
}
