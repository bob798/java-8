package base;

public class StringLearn {

    public static void main(String[] args) {

        String s = "test";
        String ss = new String();
        System.out.println("String lenth ::: "+ss.length());  // String lenth ::: 0 默认是 ""

        String abc = "abc";
        String abc2 = new String("abc");
        System.out.println(abc+"  "+abc2); // abc  abc
        System.out.println(abc.equals(abc2));               // true
        System.out.println("abc hash ::: "+abc.hashCode());  //abc hash ::: 96354

        System.out.println("length:::"+abc.length());
        compareVersion("1.2.3a", "1.2.4a");

    }

    /**
     *  实现版本号比较
     * 支持任意数字字母版本号比较，这里实现的是用点号（.）作为分隔符
     * 支持任意长度的小版本号比较
     */
    public static int compareVersion(String ver1, String ver2){
        if(ver1 == null && ver2 == null){
            throw new RuntimeException("版本号不能都为空"); }
        if(ver1 == null){
            return -1; }
        if(ver2 == null){
            return 1; }
        if(ver1.equals(ver2)) {
            return 0; }

        String [] version1 = ver1.split("\\.");
        String [] version2 = ver2.split("\\.");

        String defValue = "0000000000";
        String format = "%" + defValue.length() + "s";
        StringBuilder ver1Builder = new StringBuilder(version1.length * 10);
        StringBuilder ver2Builder = new StringBuilder(version2.length * 10);

        if(version1.length > version2.length) {
            for (int i=0; i<version1.length ;i++ ) {
                ver1Builder.append(String.format(format, version1[i]).replace(' ', '0'));
                ver2Builder.append(version2.length > i? String.format(format, version2[i]).replace(' ', '0') : defValue); }

        } else if(version1.length < version2.length){
            for (int i=0; i<version2.length ;i++ ) {
                ver2Builder.append(String.format(format, version2[i]).replace(' ', '0'));
                ver1Builder.append(version1.length > i? String.format(format, version1[i]).replace(' ', '0') : defValue); }

        } else {
            for (int i=0; i<version2.length ;i++ ) {
                ver1Builder.append(String.format(format, version1[i]).replace(' ', '0'));
                ver2Builder.append(String.format(format, version2[i]).replace(' ', '0')); } }
        return ver1Builder.toString().compareTo(ver2Builder.toString()); }}
