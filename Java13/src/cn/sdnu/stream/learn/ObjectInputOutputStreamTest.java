package cn.sdnu.stream.learn;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:21 PM
 */
public class ObjectInputOutputStreamTest {

    /*
     Serialization: Save the java object in internal storage to hard disk or transfer onto network.
     Using ObjectOutputStream to make it.
     */

    @Test
    public void testObjectOutputStream() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("Hello world"));

            oos.flush(); // refresh

//            oos.writeObject(new Person("Wang",  12));
//            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    Deserialization: data from file into object in java
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Object object = ois.readObject();
            Person p = (Person) ois.readObject();
            String str = (String) object;
            System.out.println(str);
            System.out.println("p = " + p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
