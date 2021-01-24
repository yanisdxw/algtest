package com.study;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Map<String,String> res = addressResolution("内蒙古自治区兴安盟科尔沁右翼前旗兴安盟居力镇子新农村大超市");
        System.out.println(res);
    }

    public void test7(){
        Map<String,String> res = addressResolution("内蒙古自治区兴安盟科尔沁右翼前旗居力镇子新农村");
        System.out.println(res);
    }

    /**从字符串地址中自动提取省县区*/
    public static Map<String,String> addressResolution(String address){
        String regex="(?<province>[^省]+自治区+市|.*?省|.*自治区|.*?行政区|.*?市)(?<city>[^市]+自治州+地区|.*?市|.*?自治州|.*?地区|.*?县|.*?盟)(?<county>[^县]+县|.*?区|.*?市|.*?旗|.*?)(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m= Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        Map<String,String> row= new LinkedHashMap<String,String>();
        if(m.find()){
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
        }
        return row;
    }
}
