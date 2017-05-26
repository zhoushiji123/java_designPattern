package com.zsj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zsj on 2017/5/26.
 */
public class ReflectTest {

    public static void main(String[] args) {
        String classpath = "com.zsj.reflect.User";
        getConstructors(classpath);
    }


    /**
     * 获得父类的接口
     * @param classpath
     */
    public  static void  getFatherAndInterface(String classpath){
        try {
            Class c = Class.forName(classpath);
            Class father = c.getSuperclass();
            System.out.println("父类是："+father);

            Class[] interfaces = c.getInterfaces();
            System.out.println("实现的接口有：");
            for(int i=0;i<interfaces.length;i++){
                System.out.print(interfaces[i].getName()+" ");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获得所有的构造函数和对应参数,并实例化
     * @param classpath
     */
    public static void getConstructors(String classpath){
        try {
            Class c = Class.forName(classpath);
            Constructor cons[] = c.getConstructors();
            for(int i=0;i<cons.length;i++){
                Class params[] = cons[i].getParameterTypes();
                System.out.print("构造函数["+cons[i].getName()+"](");
                for (int j = 0; j < params.length; j++) {
                    if (j == params.length - 1)
                        System.out.print(params[j].getName());
                    else
                        System.out.print(params[j].getName() + ",");
                }
                System.out.println(")");
            }
            User user = (User) cons[1].newInstance(1,"zsj");
            user.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e2){
            e2.printStackTrace();
        }catch (InvocationTargetException e3){
            e3.printStackTrace();
        }catch (InstantiationException e4){
            e4.printStackTrace();
        }
    }
}
