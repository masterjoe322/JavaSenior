# Java

## 1. Common Class

### 1. String 

- What is the difference of String, StringBuffer, StringBuilder? 

  ```txt
  String : Immutability, using char[] value storage
  
  StringBuffer: Variable; Thread safe , inefficiency, using char[] value storage
  
  StringBuilder: Variable, jdk 5.0 after, thread unsafe, efficiency, using char[] value storage
  ```

- StringBuffer & StringBuilder in internal storage 

  ```txt
  jdk source code:
          String str = new String(); // new char[0];
          Sting str1 = new String("abc"); // new char[]{'a', 'b', 'c'};
  
          StringBuffer sb1 = new StringBuffer(); // initial capacity is 16 // char[] value = new char[16];
          sb1.append('a'); // value[0] = 'a';
          sb1.append('b'); // value[1] = 'b';
  
          StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length + 16]; // every time when we new StringBuffer, there will be 16 capacity space.
          value[0] = 'a';
          value[1] = 'b';
          value[2] = 'c';
  
  
          - while appending
              1. if the length of the string appended to original StringBuffer, it will update capacity to (2 * capacity  + 2)
              2. I suggest StringBuffer.
  
  ```

- the efficiency of String, StringBuffer, StringBuilder? 

  ```txt
  efficiency from high to low : StringBuilder > StringBuffer > String
  ```

### 2. Date & Calendar

- System : System.currentTimeMillis();

  ```txt
  long time = System.currentTimeMillis();
  System.out.println(time);
  ```

- Date

  ```txt
  Date :
  	java.util.Date
      	|---java.sql.Date
  
  	1. two constructors :
      	- new Date();
         	- new Date(long millisecond);
  
  	2. two method
      	> toString() : show year, month, day, hour, minute, second
          > long getTime() : get millisecond of current Time
  
  	3. java.sql.Date : match database
      	> create a object : new Date(long millisecond);
          > sql.Date ---> util.Date
         		Date date = new java.sql.Date(1232131231L);
          > java.util.Date ----> java.sql.Date
          	1.
              	Date date = new java.sql.Date(1232131231L);
                  java.sql.Date date1 = (java.sql.Date)date;
             	2.
                  Date date = new Date();
                  java.sql.Date date1 = new java.sql.Date(date.getTime());
  ```

- java.text.SimpleDateFormat

    ```txt
    SimpleDateFormat : format & parse
        1. two options
        1.1 format : Date --->String
        1.2 parse : String -->Date
    // new instance : using default constructor
    	SimpleDateFormat sdf = new SimpleDateFormat();
    ```
    
- Calendar (Abstract Class)

    ```txt
    // 1. new instance
    // 1.1 : create instance of its child class (GregorianCalendar) 'cause it is an abstract class
    Calendar calendar0 = new GregorianCalendar();
    
    // 1.2 : invoke the static method (Calendar.getInstance());
    Calendar calendar1 = Calendar.getInstance();
    //System.out.println(calendar1.getClass()); 
    // class java.util.GregorianCalendar
    ```

    Since jdk1.1, Calendar replace Date, we suggest using Calendar

- LocalDate, LocalTime, LocalDateTime

    Since jdk1.8, LocalDate, LocalTime, LocalDateTime and so on.

    ```java
    /*
        LocalDate, LocalTime, LocalDateTime
    
        Instructions:
            1. LocalDateTime is the most commonest class we use
            2. LocalDate, LocalTime, LocalDateTime are similar to String with the immutability.
            */
        @Test
        public void test1() {
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            LocalDateTime localDateTime = LocalDateTime.now();
    
            System.out.println("localDate = " + localDate); // localDate = 2020-01-15
            System.out.println("localTime = " + localTime); // localTime = 16:00:37.683
            System.out.println("localDateTime = " + localDateTime); // localDateTime = 2020-01-15T16:00:37.684
    
            // of
            LocalDateTime localDateTime1 = LocalDateTime.of(2020, 12, 12, 12, 23);
            System.out.println(localDateTime1); // 2020-12-12T12:23a
    
    
            // common method
            // 1. getXxx()
            System.out.println(localDateTime.getDayOfWeek()); // WEDNESDAY
            System.out.println(localDateTime.getDayOfMonth()); // 15
            System.out.println(localDateTime.getDayOfYear()); // 15
            System.out.println(localDateTime.getMonthValue()); // 1
            System.out.println(localDateTime.getMinute()); // 5
    
            // Show immutability
            // withXxx(int field)
            LocalDate localDate1 = localDate.withDayOfMonth(18);
            System.out.println(localDate); // 2020-01-05
            System.out.println(localDate1); // 2020-01-18
    
            LocalDateTime localDateTime2 = localDateTime.withHour(6);
            System.out.println(localDateTime); // 2020-01-15T16:09:36.518
            System.out.println(localDateTime2); // 2020-01-15T06:09:36.518
    
            // plusXxx()
            LocalDateTime localDateTime3 = localDateTime.plusHours(12);
            System.out.println(localDateTime); // 2020-01-15T16:12:05.188
            System.out.println(localDateTime3); // 2020-01-16T04:12:05.188
    
            // minus
            LocalDateTime localDateTime4 = localDateTime.minusDays(7);
            System.out.println(localDateTime); // 2020-01-15T16:13:11.709
            System.out.println(localDateTime4); // 2020-01-08T16:13:11.709
        }
    ```

- Instant

    ```java
       /**
         * Instant
         */
        @Test
        public void test2() {
            // 1. static method now() to get object
            Instant instant = Instant.now();
            System.out.println(instant); // 2020-01-15T08:21:52.273Z
    
            // 2. Add the zone offset
            OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
            System.out.println(offsetDateTime); // 2020-01-15T16:21:52.273+08:00
    
            long epochMilli = instant.toEpochMilli();
            System.out.println(epochMilli);
    
        }
    
    
    ```

- DateTimeFormatter

    ```java
    
    
        /**
         * method 1 : predefined standard format, e.g. ISO_LOCAL_TIME, ISO_LOCAL_DATE_TIME.
         * <p>
         * method 2 : localized related format : e.g. ofLocalizedDateTime(FormatStyle.LONG);
         * <p>
         * method 3 : customized format : e.g. ofPattern("yyyy-MM-dd hh:mm:ss E");
         */
        @Test
        public void test3() {
            // method 1 :
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    
            // format : LocalDateTime ----> String
            LocalDateTime now = LocalDateTime.now();
            String format = formatter.format(now);
            System.out.println(now);
            System.out.println(format);
    
            // Parse : String -- > LocalDate
            TemporalAccessor parse = formatter.parse("2020-01-15T19:02:09.738");
            System.out.println(parse);
    
            // method 2
            DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
            // FormatStyle.SHORT, FormatStyle.MEDIUM
            String format1 = formatter1.format(now);
            System.out.println(format1);
    
            // FormatStyle.FULL, FormatStyle.LONG, FormatStyle.SHORT, FormatStyle.MEDIUM, FormatStyle.FULL
            DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
            String format2 = formatter2.format(LocalDate.now());
            System.out.println(format2);
    
    
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            String format3 = formatter3.format(LocalDateTime.now());
            System.out.println(format3);
    
            TemporalAccessor parse1 = formatter3.parse("2018-12-12 12:12:12");
            System.out.println(parse1);
    
        }
    ```

### 3. Comparable & Comparator

These two are both interface with genericity in java

- Comparable

  ```java
  /*
       Comparable
         - Like {@code String}, or Integer kind of wrappers, override method compareTo()
         - the standard for overriding compareTo()
             1. if this is greater than obj, then return an integer greater than 0
             2. if this is less than obj, then return an integer less than 0
             3. if this is equals to obj, then return 0
         - for customized class, we must implement Comparable
  */
  
  /**
    * Compare to the good according to price
    *
    * @param obj
    * @return
    */
  @Override
  public int compareTo(Object obj) {
  
      if (obj instanceof Goods) {
          Goods object = (Goods) obj;
  
          if (this.price > object.price) {
              return 1;
          } else if (this.price < object.price) {
              return -1;
          } else {
              //                return 0;
              return this.name.compareTo(object.name);
          }
  
          //            return Integer.compare(this.price, object.price);
      } else {
          throw new RuntimeException("the argument is not available!");
      }
  }
  ```

- Comparator

  ```java
  /*
          Comparator : no implements java.lang.Comparable
              1. override method int compare(Object o1, Object o2);
                  - if o1 is greater than o2, return one integer greater than 0;
                  - if o1 is less than o2, return one integer less than 0;
                  - if o1 is equals o2, return 0;
  */
  
  @Test
  public void test3() {
      String[] arr = {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
      Arrays.sort(arr, new Comparator() {
  
          @Override
          public int compare(Object o1, Object o2) {
              if (o1 instanceof String && o2 instanceof String) {
                  String s1 = (String) o1;
                  String s2 = (String) o2;
                  return -s1.compareTo(s2);
              }
  
              throw new RuntimeException("Type input Error");
              //                return 0;
          }
      });
  
      System.out.println(Arrays.toString(arr));
  
  }
  ```

  

## 2. Enumeration & Annotation

### 1. Enumeration 

- enumeration description

  ```txt
  /*
      Enumeration :
          if objects are specified and limited, we can use enumeration class.
          singleton : enumeration
  
      How to use :
          1. before jdk 5.0, we use enumeration customized.
          2. jdk 5.0 : use keyword "enum" to define enumeration class and objects.
  
      Enum :
          1. toString() : return the name of the enumeration class
          2. values : return an array of all enumeration objects
          3. valueOf(String objName) : return an enumeration object with a name.
  
      About interface
          1. use keyword "enum" implements interface
              - implements the method defined in the interface we implemented.
              - for every different enumeration, we have different method implement.
                     AUTUMN("秋天", "秋高气爽") {
                          @Override
                          public void show() {
                              System.out.println("秋天不回来");
                          }
                      },
       */
  ```

- customized enumeration class

  ```java
  class Season {
  
      // 1. field : definition with "private final"
      private final String name;
  
      private final String description;
  
  
      // 2. constructor privatization, initialize name and description
      private Season(String name, String description) {
          this.name = name;
          this.description = description;
      }
  
      // 3. provide objects we will use
      public static final Season SPRING = new Season("春天", "春暖花开");
      public static final Season SUMMER = new Season("夏天", "夏日炎炎");
      public static final Season AUTUMN = new Season("秋天", "秋高气爽");
      public static final Season WINTER = new Season("冬天", "冰天雪地");
  
      public String getName() {
          return name;
      }
  
      public String getDescription() {
          return description;
      }
  
      // toString()
  
  
      @Override
      public String toString() {
          return "Season{" +
                  "name='" + name + '\'' +
                  ", description='" + description + '\'' +
                  '}';
      }
  }
  ```

- **enum** keyword define enumeration class and implements interface.

  ```java
  enum Season1 implements Info {
  
      // 1. provide objects we will use, division with "," , finish with ";";
      SPRING("春天", "春暖花开") {
          @Override
          public void show() {
              System.out.println("春天在哪里? ");
          }
      },
      SUMMER("夏天", "夏日炎炎") {
          @Override
          public void show() {
              System.out.println("宁夏");
          }
      },
      AUTUMN("秋天", "秋高气爽") {
          @Override
          public void show() {
              System.out.println("秋天不回来");
          }
      },
      WINTER("冬天", "冰天雪地") {
          @Override
          public void show() {
              System.out.println("大约在冬季");
          }
      };
  
      // 2. field : definition with "private final"
      private final String name;
  
      private final String description;
  
  
      // 3. constructor privatization, initialize name and description
      private Season1(String name, String description) {
          this.name = name;
          this.description = description;
      }
  
  
      public String getName() {
          return name;
      }
  
      public String getDescription() {
          return description;
      }
  
  
  
  /*    // toString()
      @Override
      public String toString() {
          return "Season{" +
                  "name='" + name + '\'' +
                  ", description='" + description + '\'' +
                  '}';
      }*/
  }
  
  ```

- **Enum** class

  ```java
  /*
  	Enum :
          1. toString() : return the name of the enumeration class
          2. values : return an array of all enumeration objects
          3. valueOf(String objName) : return an enumeration object with a name.
  
  */
  public static void main(String[] args) {
      Season spring = Season.SPRING;
      System.out.println(spring);
  
      Season1[] values = Season1.values();
      for (int i = 0; i < values.length; i++) {
          System.out.println(values[i]);
          values[i].show();
      }
  
  
      Thread.State[] values1 = Thread.State.values();
      for (int i = 0; i < values1.length; i++) {
          System.out.println(values1[i]);
      }
  
      Season1 winter = Season1.valueOf("WINTER"); // if there is no the object you enter, throw IllegalArgumentException.
      String description = winter.getDescription();
      System.out.println(description);
      System.out.println(winter);
  }
  
  ```

### 2. Annotation

- Annotation description

  ```txt
   /*
      Annotation use :
          Annotation is the special mark in the code. these marks will make sense when code is compiling, load class, running and so on.
      - used to javadoc
      - replaced by configuration file.
  
      Customized Annotation :
          - use keyword @interface to define Annotation
          - set field, generally using value.
          - set default value using keyword "default".
          - if there is no field, this is a mark.
  
      if there is field in your annotation, you should enter the value for your annotation when you use it.
      Generally, if we define a customized annotation, we specify two meta annotation (Retention, Target).
      HOWEVER, there is no sense that I defined the annotation "MyAnnotation".
  
      Meta-Annotation :
          - from jdk5.0, there are four meta annotations, Retention, Target, Documented, Inherited.
              - Retention :  modify the annotation's lifecycle, SOURCE\CLASS(default action)\RUNTIME(only this lifecycle, it can be read reflectively);
              - Target : where we can use TYPE\FIELD\METHOD\PARAMETER\CONSTRUCTOR\LOCAL_VARIABLE\PACKAGE\TYPE_PARAMETER(since 1.8)\TYPE_USE(since 1.8)
              - Documented : the annotation will be retained while being parsed by javadoc
              - Inherited : the subclass will have the annotation from superclass.
  
          - jdk8 :
              - Repeatable Annotation:
              - Type Annotation :
       */
  Frame = annotation + reflection + design pattern
       
  ```

- **Frame = annotation + reflection + design pattern**

- Annotation definition

  ```java
  @Inherited
  @Repeatable(MyAnnotations.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
  public @interface MyAnnotation {
      String value() default "Hello";
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
  public @interface MyAnnotations {
      MyAnnotation[] value();
  }
  ```

- How to get annotation information? 

  ```txt
  Meta-Annotation Retention lifecycle to "RUNTIME";
  ```

- JDK 8 

  - Repeatable 
  - ElementType

## 3. Collections

### 1. Collection

- collection description

  ```txt
      /*
      Collections Framework :
          1. like array, they are both a kind container, which contains more than one object or other instance. Call Java Container.
          2. these container which just can store elements in internal storage. It's none about data persistence.
          3. for array :
              1. Feature
                  - initialize with a constant length;
                  - initialize with a constant type; e.g. String[] arr = new String[5];
              2. Disadvantage :
                  - its length cannot be changed.
                  - the elements in array cannot be changed, e.g. insert, remove, update, query, inconvenient.
                  - cannot get the number of we have added, except initialized 0 or null, and so on.
                  
                  
      Collection Framework :
          |----Collection: single row data, like array.
              |----List(interface) : sorted, and repeatable
                  |----ArrayList, LinkedList, Vector, etc.
              |----Set(interface) : unsorted, unrepeatable, like collection in mathematics, unsorted, determinacy, unrepeatable
                  |----HashSet, LinkedHashSet, TreeSet, etc.
          |----Map : two rows data, key-value, similar to like function in mathematics. y = f(x), x : key, y : value.
              |----HashMap, LinkedHashMap, TreeMap, HashTable, Properties, etc.
  
  
      Collection Interface :
          1. method :
              - boolean add(E e);
              - int size();
              - boolean addAll(Collection<? extends E> c);
              - boolean isEmpty();
              - void clear();
  
  ```

  

