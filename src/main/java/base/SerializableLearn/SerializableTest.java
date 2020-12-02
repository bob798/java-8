package SerializableLearn;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("Bob");
        person.setSex("man");

        // 1.序列化Person

        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/bob/person_file"));
//        oos.writeObject(person);
//        oos.close();
//        System.out.println("transfer finished ");

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/bob/person_file"));
//        Person  input = (Person) ois.readObject();
//        System.out.println(input);  // 输出 Person{name='Bob', sex='man'}


        // 2. Person 增加一个属性 age，再还原
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/bob/person_file"));
        Person input = (Person) ois.readObject();
        System.out.println(input);  // 输出 Person{name='Bob', sex='man'}

        /*
        如下错误

        Exception in thread "main" java.io.InvalidClassException: SerializableLearn.Person;
        local class incompatible: stream classdesc serialVersionUID = 4931284437279492033,
        local class serialVersionUID = 6984666338929641664
        意思是：当前person类的serialVersionUID和二进制文件中person类的serialVersionUID不一致。

        serialVersionUID : 是java编译器对class进行摘要算法生成的唯一指纹


         */

        /*
         那么对类进行增加一个字段后，如何仍能进行还原呢？
         根据错误信息，应该有一些启发。
         我们可以指定类的slVersionUID，使Person类的serialVersionUID唯一。可以生成，也可以自己设置。

     */

        // 3. Person类指定serialVersionUID 再还原

        /*
        private static final long serialVersionUID = 1;
         */

    }



    }

