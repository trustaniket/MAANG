package Java8Functions;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

enum EnumABC {
    FUNDING("abc", "def");

    private String desc;
    private String type;

    EnumABC(String desc, String type){
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }
}

public class Solution {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();

        System.out.println(EnumABC.FUNDING.name());

        /*StatusEnum statusEnum1 = StatusEnum.FUNDING_REJECTED;
        //statusEnum1.execute(map);
        String abc = "FR_1234_afdfs_dfgsdfsd";
        System.out.println(StringUtils.split(abc, "_")[1]);*/



    }
}
