package com.lexiangmiao.sample.jvm.transfervalue;

public class TransferValueDemo {
    public void changeValue1(int age) {
        age=30;
    }

    public void changePersonName(Person person) {
        person.setName("xxx");
    }

    public void chnageValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {
        TransferValueDemo transferValue = new TransferValueDemo();

        //int age = 0.5*10; //编译失败
        //int age = 0.5; //编译失败
//        float age = 0.5; //编译失败
//        float age = 1; //正常
        int age = 20;

        /**
         * 调用方法会重新开个栈，值类型传的是副本，引用类型则是形参和实参指向一个堆对象。
         * 若方法内修改了对象的数据，则方法外的对象也会变化。
         * 对于简单引用类型，因为创建共享内存池，当在方法内赋值时，因为内存池没有所以重新指向。方法外的指向并未变化所以不变。
         */
        transferValue.changeValue1(age);
        System.out.println("age = [" + age + "]");

        Person person = new Person("abc");
        transferValue.changePersonName(person);
        System.out.println("person.name = [" + person.getName() + "]");

        String str = "abc";
        transferValue.chnageValue3(str);
        System.out.println("str = [" + str + "]");
    }
}
