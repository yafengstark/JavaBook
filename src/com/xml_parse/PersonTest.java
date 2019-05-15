package com.xml_parse;

/**
 * @author tony
 * @date 2019/5/15 21:27
 */

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:PersonBean
 * @author: chenyoulong  Email: chen.youlong@payeco.com
 * @date :2012-9-28 下午3:10:47
 * @Description:TODO
 */
@XStreamAlias("person")
class PersonBean {
    @XStreamAlias("firstName")
    private String firstName;
    @XStreamAlias("lastName")
    private String lastName;

    @XStreamAlias("telphone")
    private PhoneNumber tel;
    @XStreamAlias("faxphone")
    private PhoneNumber fax;

    //测试一个标签下有多个同名标签
    @XStreamAlias("friends")
    private Friends friend;

    //测试一个标签下循环对象
    @XStreamAlias("pets")
    private Pets pet;

    //省略setter和getter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PhoneNumber getTel() {
        return tel;
    }

    public void setTel(PhoneNumber tel) {
        this.tel = tel;
    }

    public PhoneNumber getFax() {
        return fax;
    }

    public void setFax(PhoneNumber fax) {
        this.fax = fax;
    }

    public Friends getFriend() {
        return friend;
    }

    public void setFriend(Friends friend) {
        this.friend = friend;
    }

    public Pets getPet() {
        return pet;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }
}


@XStreamAlias("phoneNumber")
class PhoneNumber {

    @XStreamAlias("code")
    private int code;
    @XStreamAlias("number")
    private String number;

    //省略setter和getter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
// [代码]3.实体类：Friends（一个标签下有多个同名标签 ）

/**
 * 用Xstream注解的方式实现：一个标签下有多个同名标签
 *
 * @ClassName:Friends
 * @author: chenyoulong  Email: chen.youlong@payeco.com
 * @date :2012-9-28 下午4:32:24
 * @Description:TODO 5个name 中国，美国，俄罗斯，英国，法国
 * http://blog.csdn.net/menhuanxiyou/article/details/5426765
 */
class Friends {
    @XStreamImplicit(itemFieldName = "name")   //itemFieldName定义重复字段的名称，
        /*<friends>                               <friends>
            <name>A1</name>                         <String>A1</String>
            <name>A2</name>    如果没有，则会变成    =====>       <String>A1</String>
            <name>A3</name>                         <String>A1</String>
        </friends>                                </friends>
      */
    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}

//测试同一标签下循环某一对象
class Animal {
    @XStreamAlias("name")
    private String name;
    @XStreamAlias("age")
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //省略setter和getter

}

// [代码]4.2实体类：Pets（同一标签下循环对象实体2）

/**
 * 测试同一标签下循环某一对象
 *
 * @ClassName:Pets
 * @author: chenyoulong  Email: chen.youlong@payeco.com
 * @date :2012-9-28 下午6:26:01
 * @Description:TODO
 */
class Pets {
    @XStreamImplicit(itemFieldName = "pet")
    private List<Animal> animalList;

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

}


/**
 * @ClassName:PersonTest
 * @author: chenyoulong
 * @date :2012-9-28 下午3:25:09
 * @Description:TODO
 */
public class PersonTest {

    /**
     * @param args
     * @return void
     * @Title: main
     * @Description: TODO
     */
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        PersonBean per = new PersonBean();
//        per.setFirstName("chen");
//        per.setLastName("youlong");
//
//        PhoneNumber tel = new PhoneNumber();
//        tel.setCode(137280);
//        tel.setNumber("137280968");
//
//        PhoneNumber fax = new PhoneNumber();
//        fax.setCode(20);
//        fax.setNumber("020221327");
//        per.setTel(tel);
//        per.setFax(fax);
//
//
//        //测试一个标签下有多个同名标签
//        List<String> friendList = new ArrayList<String>();
//        friendList.add("A1");
//        friendList.add("A2");
//        friendList.add("A3");
//        Friends friend1 = new Friends();
//        friend1.setName(friendList);
//        per.setFriend(friend1);
//
//        //测试一个标签下循环对象
//        Animal dog = new Animal("Dolly", 2);
//        Animal cat = new Animal("Ketty", 2);
//        List<Animal> petList = new ArrayList<Animal>();
//        petList.add(dog);
//        petList.add(cat);
//        Pets pet = new Pets();
//        pet.setAnimalList(petList);
//        per.setPet(pet);
//
//        //java对象转换成xml
//        String xml = XmlUtil.toXml(per);
//        System.out.println("xml===" + xml);
//
//    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //toXml
//      String xmlStr=new PersonTest().toXml();

        //toBean
//      PersonBean per=new PersonTest().toBean();
        String xmlStr="<person>"+
                "<firstName>chen</firstName>"+
                "<lastName>youlong</lastName>"+
                "<telphone>"+
                "<code>137280</code>"+
                "<number>137280968</number>"+
                "</telphone>"+
                "<faxphone>"+
                "<code>20</code>"+
                "<number>020221327</number>"+
                "</faxphone>"+
                "<friends>"+
                "<name>A1</name>"+
                "<name>A2</name>"+
                "<name>A3</name>"+
                "</friends>"+
                "<pets>"+
                "<pet>"+
                "<name>doly</name>"+
                "<age>2</age>"+
                "</pet>"+
                "<pet>"+
                "<name>Ketty</name>"+
                "<age>2</age>"+
                "</pet>"+
                "</pets>"+
                "</person>";
//用泛型的知识
        PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);
        System.out.println("person=firstname=="+person.getFirstName());
        System.out.println("person==Friends==name1=="+person.getFriend().getName().get(0));
//        System.out.println("person==Pets==name2=="+person.getPet().getAnimalList().get(1).getName());

/*
//效果与以下方法类同,(以下代码较为直观)
XStream xstream=new XStream(new DomDriver()); //注意：不是new Xstream(); 否则报错：

        xstream.processAnnotations(PersonBean.class);
        PersonBean person=(PersonBean)xstream.fromXML(xmlStr);
        System.out.println("person=firstname=="+person.getFirstName());
        System.out.println("person==Friends==name1=="+person.getFriend().getName().get(0));
        System.out.println("person==Pets==name=="+person.getPet().getAnimalList().get(1).getName());
*/


    }
}


/**
 * 输出xml和解析xml的工具类
 *
 * @ClassName:XmlUtil
 * @author: chenyoulong  Email: chen.youlong@payeco.com
 * @date :2012-9-29 上午9:51:28
 * @Description:TODO
 */
class XmlUtil {
    /**
     * java 转换成xml
     *
     * @param obj 对象实例
     * @return String xml字符串
     * @Title: toXml
     * @Description: TODO
     */
    public static String toXml(Object obj) {
        XStream xstream = new XStream();
//          XStream xstream=new XStream(new DomDriver()); //直接用jaxp dom来解释
//          XStream xstream=new XStream(new DomDriver("utf-8")); //指定编码解析器,直接用jaxp dom来解释

        ////如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
        xstream.processAnnotations(obj.getClass()); //通过注解方式的，一定要有这句话
        return xstream.toXML(obj);
    }

    /**
     * 将传入xml文本转换成Java对象
     *
     * @param xmlStr
     * @param cls    xml对应的class类
     * @return T   xml对应的class类的实例对象
     * <p>
     * 调用的方法实例：PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);
     * @Title: toBean
     * @Description: TODO
     */
    public static <T> T toBean(String xmlStr, Class<T> cls) {
        //注意：不是new Xstream(); 否则报错：java.lang.NoClassDefFoundError: org/xmlpull/v1/XmlPullParserFactory
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        T obj = (T) xstream.fromXML(xmlStr);
        return obj;
    }

    /**
     * 写到xml文件中去
     *
     * @param obj      对象
     * @param absPath  绝对路径
     * @param fileName 文件名
     * @return boolean
     * @Title: writeXMLFile
     * @Description: TODO
     */

    public static boolean toXMLFile(Object obj, String absPath, String fileName) {
        String strXml = toXml(obj);
        String filePath = absPath + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
//                log.error("创建{"+ filePath +"}文件失败!!!" + Strings.getStackTrace(e));
                return false;
            }
        }// end if
        OutputStream ous = null;
        try {
            ous = new FileOutputStream(file);
            ous.write(strXml.getBytes());
            ous.flush();
        } catch (Exception e1) {
//            log.error("写{"+ filePath +"}文件失败!!!" + Strings.getStackTrace(e1));
            return false;
        } finally {
            if (ous != null)
                try {
                    ous.close();
                } catch (IOException e) {
//                    log.error("写{"+ filePath +"}文件关闭输出流异常!!!" + Strings.getStackTrace(e));
                }
        }
        return true;
    }

    /**
     * 从xml文件读取报文
     *
     * @param absPath  绝对路径
     * @param fileName 文件名
     * @param cls
     * @return T
     * @throws Exception
     * @Title: toBeanFromFile
     * @Description: TODO
     */
    public static <T> T toBeanFromFile(String absPath, String fileName, Class<T> cls) throws Exception {
        String filePath = absPath + fileName;
        InputStream ins = null;
        try {
            ins = new FileInputStream(new File(filePath));
        } catch (Exception e) {
            throw new Exception("读{" + filePath + "}文件失败！", e);
        }

//        String encode = useEncode(cls);
        String encode = "";
        XStream xstream = new XStream(new DomDriver(encode));
        xstream.processAnnotations(cls);
        T obj = null;
        try {
            obj = (T) xstream.fromXML(ins);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new Exception("解析{" + filePath + "}文件失败！", e);
        }
        if (ins != null)
            ins.close();
        return obj;
    }

}