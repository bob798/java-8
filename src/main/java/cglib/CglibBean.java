//package cglib;
//
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public final class CglibBean {
//
//  private Object object = null;
//
//  private BeanMap beanMap = null;
//
//  public  CglibBean() {
//    super();
//  }
//
//  public CglibBean(Map<String, Class<?>> porpertyMap) {
//    this.object = generateBean(porpertyMap);
//    this.beanMap = BeanMap.create(this.object);
//  }
//
//  public Object getObject() {
//    return this.object;
//  }
//
//  public void setValue(String property, Object value) {
//    beanMap.put(property, value);
//  }
//
//  public Object getValue(String property) {
//    return beanMap.get(property);
//  }
//
//  public static Object generateBean(Map<String, Class<?>> propertyMap) {
//    if (propertyMap == null || propertyMap.isEmpty()) {
//      return null;
//    }
//    BeanGenerator beanGenerator = new BeanGenerator();
//    propertyMap.forEach(beanGenerator::addProperty);
//    return beanGenerator.create();
//  }
//
//  public static void main(String[] args) throws ClassNotFoundException {
//    Map<String, Class<?>> propertyMap = new HashMap<>();
//    propertyMap.put("id", Class.forName("java.lang.Integer"));
//    propertyMap.put("name", Class.forName("java.lang.String"));
//    propertyMap.put("address", Class.forName("java.lang.String"));
//
//    CglibBean bean = new CglibBean(propertyMap);
//    bean.setValue("id", 798);
//    bean.setValue("name", "bob");
//    bean.setValue("address", "beijing");
//    System.out.println(new Gson().toJson(bean.beanMap));
//    System.out.println(underlineToCamel("id_1"));
//    Map<String, Object> map = new HashMap<>();
//    String name = "";
//    map.put("id", 123);
//    map.put(name, "bob");
//    System.out.println(new Gson().toJson(map));
//
//
//  }
//
//  public static String underlineToCamel(String name) {
//    // 快速检查
//    if (StringUtils.isEmpty(name)) return "";
//    StringBuilder result = new StringBuilder();
//    // 用下划线将原始字符串分割
//    String[] camels = name.split("_");
//    // 跳过原始字符串中开头、结尾的下换线或双重下划线
//    // 处理真正的驼峰片段
//    Arrays.stream(camels).filter(camel -> !StringUtils.isEmpty(camel)).forEach(camel -> {
//      if (result.length() == 0) {
//        // 第一个驼峰片段，全部字母都小写
//        result.append(camel);
//      } else {
//        // 其他的驼峰片段，首字母大写
//        result.append(capitalFirst(camel));
//      }
//    });
//    return result.toString();
//  }
//  public static String capitalFirst(String name) {
//    if (!StringUtils.isEmpty(name)) {
//      return name.substring(0, 1).toUpperCase() + name.substring(1);
//    }
//    return "";
//  }
//
//}
