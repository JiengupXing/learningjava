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

## 20190805

- 继承时父类的属性统统被复制到子类中，包括父类中的private成员，但是子类对象内部无法直接访问，必须通过父类接口方法访问

- 重载的多种方法之间往往存在一定的调用关系，即一个方法写有实现功能，其他方法采用委托方式进行调用。
  
~~~
public AudioClip getAudioClip(URL url){
    ... //真正的实现代码
}
public AudioClip getAudioClip(URL url, String name){
    ... //其他代码
    //通过重新构造一个新的URL对象，之后调用上面的同名方法
    return getAudioClip(new URL(url, name))
}

~~~

- 子类定义的方法与父类名称相同（大小写完全匹配），但参数不同，不是覆盖，二是重载；如果名称，参数相同，返回值不同，则编译不能通过
  
- 同名的非static和非static方法之间不能覆盖，方法前有final修饰符时，此方法不能在子类中进行覆盖

## 20190807
### 面向对象（下）
- this可以指代当前对象，而super没有类似功能，即没有指代父类对象的功能；子类和父类定义了同名变量，则子类对象中将父类定义的同名域变量隐藏，子类如果使用父类的x，则必须采用“super.x”的形式，覆盖的父类方法同理

- 一个类的若干个重载的构造方法之间可以相互调用，且必须使用关键字this来调用重载的其他构造方法，最大限度地提高对已有代码的复用程度,构造方法的调用必须为构造方法中的第一句
~~~
class AddClass{
    public int x = 0, y = 0, z = 0;
    AddClass(int x){
        this.x = x;
    }
    AddClass(int x, int y){
        this(x);
        this.y = y;
    }
    AddClass(int x, int y, int z){
        this(x, y);
        this.z = z;
    }
}

~~~

- 同理，子类可以调用父类的构造方法
~~~
public class SonAddClass extend AddClass{
    int a = 0, b = 0, c = 0;
    SonAddClass(int x){
        super(x);
        a = x + 7;
    }
    SonAddClass(int x, int y){
        super(x, y);
        a = x + 5;
        b = y + 7;
    }
    SonAddClass(int x, int y, int z){
        super(x, y, z);
        a = x + 3;
        b = y + 3;
        c = z + 3;
    }
}
~~~
- 成员方法中的变量如果不赋初值，则系统会提示变量没有初始化，但类的域变量则不进行提示，因为在于类生成对象时，可以进行默认初始化，类的静态属性如果不赋值，也会被默认初始化
- 