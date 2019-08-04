# learning java
## 20190610
1. <s>Preface</s>
2. <s>Introduction to Objects</s>
## 20190611
1. <s>Everything Is an object</s>
2. Operators

- if you want to compare the actual contents of an object for equivalence? You must use
the special method equals( ) that exists for all objects (not primitives, which work fine with
== and !=)


## 20190803
### 第二章 Java语言基础
 - 小数默认为double类型，如果要给float类型赋小数值的话，需要在小数后面加上一个f

    float = 3.14f 

- 包装类的一些静态方法可以实现不同数据类型的转化，例如整数和字符串的互相转化:

    int a = Integer.parseInt("123");
    
    String s = String.valueOf(123);

- 可以在循环语句前加上一个lab，然后用break+lab的形式跳出循环、或者continue+lab的形式短路循环：

~~~
p:  for(int i=1; i<=10 ;i++)
    {
        for(int j=1; j<=10; j++)
        {
            if(j == 5)
            {
                break p;
            }
            System.out.println(j);
        }
    }
~~~


- java中return语句只能用在一个方法体的最后，如果在return之后仍有可执行的语句，则会出现编译错误

- 对于对象数组，可以这样初始化：

~~~
Integer results[] = {new Integer(3), new Integer(5)};
float f4[] = new float[]{1.0f, 2.0f, 3.0f};
String[] dogs = new String[]{new String("Fido"), new String("Spike")};
~~~

## 20190804
### 面向对象（上）
- 不能对构造方法指定类型，它有隐含的返回值，该值由系统内部使用，如果指定了相应的类型，则该方法就不是构造方法
- 当构造方法中的参数名与域变量名相同时，此时在构造方法中需要用this关键字来区分，或者使用下划线避免同名
-  静态代码块：一个类中可以使用不包含在任何方法体中的静态代码块。当类被装载时，静态代码块被执行且只被执行一次：
~~~
class StaticCodeBlock{
    static int value;
    static{
        value = 3;
        System.out.println("value = " + value);
    }
    public static void main(String[] args){

    }
}
~~~

- 单件模式是设计模式的一种，它确保一个类有且仅有一个对象，可以这样实现：
~~~
public class FighterPlane{
    private String name;
    private int missileNum;
    private FighterPlane(String _name, int _missileNum){
        name = _name;
        missileNum = _missileNum;
    }
    public static FighterPlane getInstance(String _name, int _missileNum){
        if(fp == null){
            fp = new FighterPlane(_name, _missileNum);
            return fp;
        }
    }
}
~~~