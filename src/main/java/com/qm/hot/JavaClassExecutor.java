package com.qm.hot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaClassExecutor {
    public static String execute(byte[] classBytes) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classBytes);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "com/qm/hot/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }
}
