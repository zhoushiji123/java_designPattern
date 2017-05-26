package com.zsj.reflect;

import java.lang.reflect.*;

/**
 * Created by zsj on 2017/5/26.
 * 反射操作。
 */
public class ReflectTest {

    public static void main(String[] args) {
        String classpath = "com.zsj.reflect.User";
        String methodName = "execute";
        String fieldName  =  "username";
        invokeField(classpath,fieldName,"反射机制");
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

    /**
     * 获得所有属性
     * @param classpath
     */
    public static void getFields(String classpath){
        try {
            Class c = Class.forName(classpath);
            Field fields[] = c.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                int mod = fields[i].getModifiers(); //修饰符标号
                String modifier = Modifier.toString(mod);  //修饰符
                Class type =  fields[i].getType();  //属性类型
                String name = fields[i].getName();  //属性名称
                System.out.println(modifier+" "+type+""+name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获得所有方法和参数
     * @param classpath
     */
    public static void getMethods(String classpath){
        try {
            Class c = Class.forName(classpath);
            Method methods[] = c.getMethods();
            for(int i=0;i<methods.length;i++){
                Class returnTyre = methods[i].getReturnType();
                Class params[] = methods[i].getParameterTypes();
                int mod = methods[i].getModifiers();   //修饰符标号
                String modifier = Modifier.toString(mod);
                System.out.print(modifier+" "+returnTyre.getName());
                System.out.print("(");
                for(int j=0;j<params.length;j++){
                    System.out.print(params[j].getName()+" "+params[j].getCanonicalName());
                    if(j < params.length -1 )
                        System.out.print(",");
                }
                System.out.println(")");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 反射调用方法，需要提前知道方法名和具体参数
     * @param classpath
     * @param methodName
     */
    public static void invokeMethod(String classpath,String methodName){
        try {
            Class c = Class.forName(classpath);
            Method method = c.getMethod(methodName); //没有参数的方法直接方法名
            method.invoke(c.newInstance()); //调用

            method = c.getMethod(methodName,int.class,String.class);//有参数的方法
            method.invoke(c.newInstance(),10,"qq"); //参数

            method = c.getMethod(methodName,String.class);//有参数的方法
            method.invoke(c.newInstance(),"ggg"); //参数

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过反射修改成员变量
     * @param classPath
     * @param fieldName
     * @param value
     */
    public static void invokeField(String classPath,String fieldName,Object value){
        try {
            Class c = Class.forName(classPath);
            Object obj = c.newInstance();
            Field field = c.getDeclaredField(fieldName);  //获得属性
            field.setAccessible(true);  //访问private变量必须的操作，表示通过权限检查
            System.out.println(field.get(obj)); //获得属性当前的值

            field.set(obj,value); //属性保存的对象，和新的value
            System.out.println(field.get(obj));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
