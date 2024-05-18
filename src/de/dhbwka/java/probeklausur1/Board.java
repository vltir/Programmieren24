package de.dhbwka.java.probeklausur1;

import java.util.Arrays;

public class Board {
    private final Field[] fields = new Field[62];
    private Field miss;

    public Board() {
        generateFields();
    }

    public Field parseField(String label){
        for (Field field : fields) {
            if(field!=null&&label.equalsIgnoreCase(field.getLabel())){
                return field;
            }
        }
        if (label.equalsIgnoreCase(miss.getLabel())){
            return miss;
        }
        return null;
    }

    private void generateFields(){
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 20; j++) {
                String label="";
                if(i==2){
                    label+="D";
                }else if(i==3){
                    label += "T";
                }
                label += j;
                fields[i*j]=new Field(label,i*j,i==2);
            }
        }
        fields[60]=new Field("25",25,false);
        fields[61]=new Field("BULL",50,true);
        miss = new Field("x",0,false);
    }
}
