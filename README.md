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