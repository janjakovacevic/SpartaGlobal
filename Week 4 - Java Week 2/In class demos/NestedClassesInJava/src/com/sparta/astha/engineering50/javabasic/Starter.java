package com.sparta.astha.engineering50.javabasic;

import java.lang.reflect.InvocationTargetException;

public class Starter {

    public static void start(){
        // write your code here
        //runNonStaticNestedClass();
        //runStaticNestedClass();
        //runLocalNestedClass();
        runAnonymousClass();

        //Practice

        //runAnonymousClassPractice();
    }

    private static void runAnonymousClassPractice() {
        ImplementingAnonymousClassesPractice anonymousClassesPractice=new ImplementingAnonymousClassesPractice();
        anonymousClassesPractice.londonAcademy.aboutMethod();
        anonymousClassesPractice.spartanConsultants.getGraduationStatus();
    }




    public static void runNonStaticNestedClass() {
        //System.out.println(NonStaticNestedClass.x);
        NonStaticNestedClass nonStaticNestedClass = new NonStaticNestedClass();
        // System.out.println(nonStaticNestedClass.getNum);
        //nonStaticNestedClass.nonStaticMethod();//not able to access from the instance object
        //nonStaticNestedClass.InnerNonStaticClass()=nonStaticNestedClass.new InnerNonStaticClass();
        NonStaticNestedClass.InnerNonStaticClass innerNonStaticClass = nonStaticNestedClass.new InnerNonStaticClass();
        //NonStaticNestedClass.InnerNonStaticClass innerNonStaticClass1=new NonStaticNestedClass.InnerNonStaticClass();
        innerNonStaticClass.nonStaticMethod(50);
    }
    //nonStaticNestedClass.nonStaticMethod();Outer. inner

    public static void runStaticNestedClass() {
        //Goal--->I want to access the nested class's print method
        StaticNestedClass.InnerStaticClass innerStaticClass = new StaticNestedClass.InnerStaticClass();
        innerStaticClass.print(6);
        //When print is a static method
        //StaticNestedClass.InnerStaticClass.print(6);
    }



    public static void runLocalNestedClass() {
        LocalNestedClass localNestedClass=new LocalNestedClass();
        localNestedClass.outerMethod();

    }

    public static void runAnonymousClass(){
        ImplementingAnonymousClass implementingAnonymousClass=new ImplementingAnonymousClass();
        implementingAnonymousClass.londonAcademy.aboutMethod();
        implementingAnonymousClass.spartanOnsite.graduateStatus();
        ImplementingAnonymousClassesPractice implementingAnonymousClassesPractice=new ImplementingAnonymousClassesPractice();


            try {
                implementingAnonymousClassesPractice.londonAcademy.getClass().getMethod("test").invoke(implementingAnonymousClassesPractice.londonAcademy);
            } catch (IllegalAccessException | InvocationTargetException |NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

//        try {
//            implementingAnonymousClassesPractice.londonAcademy.getClass().getMethod("test").invoke();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }


