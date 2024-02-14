package de.dhbwka.java.example;
public class JavaQuine {
    public static void main(String[] args) {
        String code = "package de.dhbwka.java.example;%npublic class JavaQuine {%npublic static void main(String[] args) {%nString code = %c%s%c;%nSystem.out.printf(code, 34, code, 34);%n}%n}";
        System.out.printf(code, 34, code, 34);
    }
}