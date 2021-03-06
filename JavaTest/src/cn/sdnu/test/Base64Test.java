package cn.sdnu.test;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:11 PM
 */
public class Base64Test {
    /*
    __VIEWSTATE=dDw0MTg3MjExMDA7dDw7bDxpPDE%2BOz47bDx0PDtsPGk8MT47aTwxNT47aTwxNz47aTwyMz47aTwyNT47aTwyNz47aTwyOT47aTwzMD47aTwzMj47aTwzND47aTwzNj47aTw0OD47aTw1Mj47PjtsPHQ8dDw7dDxpPDIxPjtAPFxlOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjAwMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjAxMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTMtMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7MjAxOC0yMDE5OzIwMTktMjAyMDsyMDIwLTIwMjE7PjtAPFxlOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjAwMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjAxMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTMtMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7MjAxOC0yMDE5OzIwMTktMjAyMDsyMDIwLTIwMjE7Pj47Pjs7Pjt0PHA8O3A8bDxvbmNsaWNrOz47bDxwcmV2aWV3KClcOzs%2BPj47Oz47dDxwPDtwPGw8b25jbGljazs%2BO2w8d2luZG93LmNsb3NlKClcOzs%2BPj47Oz47dDxwPHA8bDxUZXh0Oz47bDzlrablj7fvvJoyMDE3MTEwMTAzMTg7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOWnk%2BWQje%2B8muS5lOW5v%2BmAmjs%2BPjs%2BOzs%2BO3Q8cDxwPGw8VGV4dDs%2BO2w85a2m6Zmi77ya5L%2Bh5oGv56eR5a2m5LiO5bel56iL5a2m6ZmiOz4%2BOz47Oz47dDxwPHA8bDxUZXh0Oz47bDzkuJPkuJrvvJo7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOiuoeeul%2BacuuenkeWtpuS4juaKgOacr%2B%2B8iOmdnuW4iOiMg%2B%2B8iTs%2BPjs%2BOzs%2BO3Q8cDxwPGw8VGV4dDs%2BO2w86KGM5pS%2F54%2Bt77ya6K6h5bel5pysMTcwMzs%2BPjs%2BOzs%2BO3Q8QDA8O0AwPDs7O0AwPHA8bDxWaXNpYmxlOz47bDxvPGY%2BOz4%2BOzs7Oz47Ozs7Ozs7Ozs7Pjs7Ozs7Ozs7Oz47Oz47dDxAMDw7Ozs7Ozs7Ozs7Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPEhIWFk7Pj47Pjs7Pjt0PEAwPDs7Ozs7Ozs7Ozs%2BOzs%2BOz4%2BOz4%2BOz6LmZcOIYEd1WONqkDX%2Bl0C6j2L%2BA%3D%3D&ddlXN=2019-2020&ddlXQ=1&txtQSCJ=0&txtZZCJ=100&Button5=%B0%B4%D1%A7%C4%EA%B2%E9%D1%AF
     */


    @Test
    public void test1() throws UnsupportedEncodingException {
        String str = "dDw0MTg3MjExMDA7dDw7bDxpPDE%2BOz47bDx0PDtsPGk8MT47aTwxNT47aTwxNz47aTwyMz47aTwyNT47aTwyNz47aTwyOT47aTwzMD47aTwzMj47aTwzND47aTwzNj47aTw0OD47aTw1Mj47PjtsPHQ8dDw7dDxpPDIxPjtAPFxlOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjAwMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjAxMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTMtMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7MjAxOC0yMDE5OzIwMTktMjAyMDsyMDIwLTIwMjE7PjtAPFxlOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjAwMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjAxMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTMtMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7MjAxOC0yMDE5OzIwMTktMjAyMDsyMDIwLTIwMjE7Pj47Pjs7Pjt0PHA8O3A8bDxvbmNsaWNrOz47bDxwcmV2aWV3KClcOzs%2BPj47Oz47dDxwPDtwPGw8b25jbGljazs%2BO2w8d2luZG93LmNsb3NlKClcOzs%2BPj47Oz47dDxwPHA8bDxUZXh0Oz47bDzlrablj7fvvJoyMDE3MTEwMTAzMTg7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOWnk%2BWQje%2B8muS5lOW5v%2BmAmjs%2BPjs%2BOzs%2BO3Q8cDxwPGw8VGV4dDs%2BO2w85a2m6Zmi77ya5L%2Bh5oGv56eR5a2m5LiO5bel56iL5a2m6ZmiOz4%2BOz47Oz47dDxwPHA8bDxUZXh0Oz47bDzkuJPkuJrvvJo7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOiuoeeul%2BacuuenkeWtpuS4juaKgOacr%2B%2B8iOmdnuW4iOiMg%2B%2B8iTs%2BPjs%2BOzs%2BO3Q8cDxwPGw8VGV4dDs%2BO2w86KGM5pS%2F54%2Bt77ya6K6h5bel5pysMTcwMzs%2BPjs%2BOzs%2BO3Q8QDA8O0AwPDs7O0AwPHA8bDxWaXNpYmxlOz47bDxvPGY%2BOz4%2BOzs7Oz47Ozs7Ozs7Ozs7Pjs7Ozs7Ozs7Oz47Oz47dDxAMDw7Ozs7Ozs7Ozs7Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPEhIWFk7Pj47Pjs7Pjt0PEAwPDs7Ozs7Ozs7Ozs%2BOzs%2BOz4%2BOz4%2BOz6LmZcOIYEd1WONqkDX%2Bl0C6j2L%2BA%3D%3D&ddlXN=2019-2020&ddlXQ=1&txtQSCJ=0&txtZZCJ=100&Button5=%B0%B4%D1%A7%C4%EA%B2%E9%D1%AF";

        String s = Base64.base64Decode(str);
        System.out.println(s);
    }

}
