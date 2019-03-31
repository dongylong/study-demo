//package com.monitor;
//
//import net.java.btrace.annotations.Kind;
//import net.java.btrace.annotations.Location;
//import net.java.btrace.annotations.OnMethod;
//import net.java.btrace.annotations.TLS;
//
//import static com.sun.btrace.*;
//
///**
// * @author dongyl
// * @date 12:02 2019-02-10
// * @project study-demo
// */
//@Btrace
//public class MethodTimeCost {
//    @TLS
//    private static long startTime;
//
//    @OnMethod(clazz = "/com\\.http\\.testbtrace\\..*/",method = "/.+/",location = @Location(Kind.ENTRY))
//    public static void startExecute(){
//        startTime = timeMillis();
//    }
//
//    private static long timeMillis() {
//        return 0;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
