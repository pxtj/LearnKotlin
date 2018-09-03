package com.porify.kotlin;

import com.porify.kotlin.chapter4.*;

import java.io.File;
import java.util.ArrayList;

public class JavaMain {

    public static void main(String[] args) {
        System.out.println("This Java Main;");

        char c = Chapter3Kt.lastChar("Java");
        System.out.println(c);

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            arrayList.add("Alpha_" + i);
        }
        System.out.println(arrayList);
        String toString = KotlinUtilsKt.joinToString(arrayList, ", ", "", "");
        System.out.println(toString);

        c = Chapter3Kt.getLastChar("Java");
        System.out.println(c);

        c = Chapter3Kt.lastChar2("Kotlin");
        System.out.println(c);

        String string = "12.345-6.A";
        System.out.println(string);
        String[] strings = string.split("\\.");
        for (String str : strings) {
            System.out.println(str);
        }

        File file1 = new File("/User");
        File file2 = new File("/user");
        int compare = CaseInsensitiveFileComparator.INSTANCE.compare(file1, file2);
        System.out.println(compare);

        Person zhangSan = PersonUtil.PersonFactor.fromJson("zhangSanInJava@12222");
        System.out.println(zhangSan);

        Person zhaoliu = CompanionClassKt.fromXml(PersonUtil.PersonFactor, "zhaoliuInJava/123454");
        System.out.println(zhaoliu);

        ObjectClassKt.changeSalary(zhaoliu, 46548547);

    }

    void postponeComputation(int delay, Runnable computation) {

    }
}
