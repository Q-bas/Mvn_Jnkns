package excelStdy;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {    

    public static void main(String[] args) throws IOException {
        dataDriven d = new dataDriven();
        ArrayList<String> data = d.getData("purchase");
        //String usernm = data.get(0);
        System.out.println(data.get(1));
    }
}
