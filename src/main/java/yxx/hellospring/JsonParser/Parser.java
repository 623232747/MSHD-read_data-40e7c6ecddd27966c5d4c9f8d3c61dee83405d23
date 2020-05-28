/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */

package yxx.hellospring.JsonParser;

import yxx.hellospring.POJO.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashMap;

public class Parser {
    //基类
    public String code;
    int resourceCode;
    static HashMap<String, String> locationMap = new HashMap<String, String>();

    public String getLocation(String locationCode) {
        String provinceCode = locationCode.substring(0, 2) + "0000";
        String cityCode = locationCode.substring(0, 4) + "00";
        String countyCode = locationCode.substring(0, 6);
        String countrysideCode = locationCode.substring(0, 9);
        // String villageCode = locationCode.substring(0, 12);
        String province = locationMap.get(provinceCode);
        String city = locationMap.get(cityCode);
        String county = locationMap.get(countyCode);
        String countryside = locationMap.get(countrysideCode);
        province = province != null ? province : "";
        city = city != null ? city : "";
        county = county != null ? county : "";
        countryside = countryside != null ? countryside : "";
        String location = province + city + county + countryside;
        return location;
    }

    public POJOInterface parse(String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        code = jsonObject.getString("Code");
        String locationCode = code.substring(0, 12);
        String disasterCode = code.substring(12, 15);
        String date = jsonObject.getString("Date");
        String location = getLocation(locationCode);
        String reporting_unit = resourceCode + jsonObject.getString("ReportingUnit");
        if (disasterCode.equals("111")) {
            // DeathStatistics

            int number = jsonObject.getIntValue("Number");

            Deathstatistics deathstatistics = new Deathstatistics();

            deathstatistics.setId(code);
            deathstatistics.setDate(date);
            deathstatistics.setNumber(number);
            deathstatistics.setReportingUnit(reporting_unit);
            deathstatistics.setLocation(location);

            return deathstatistics;
        } else if (disasterCode.equals("221")) {
            // CivilStructure

            String basically_intact_square = jsonObject.getString("BasicallyIntactSquare");
            String damaged_square = jsonObject.getString("DamagedSquare");
            String destroyed_square = jsonObject.getString("DestroyedSquare");
            String note = jsonObject.getString("Note");

            Civilstructure civilstructure = new Civilstructure();

            civilstructure.setId(code);
            civilstructure.setDate(date);
            civilstructure.setLocation(location);
            civilstructure.setBasicallyIntactSquare(basically_intact_square);
            civilstructure.setDamagedSquare(damaged_square);
            civilstructure.setDestroyedSquare(destroyed_square);
            civilstructure.setNote(note);
            civilstructure.setReportingUnit(reporting_unit);

            return civilstructure;
        } else if (disasterCode.equals("336")) {
            // CommDisaster

            String type = jsonObject.getString("Type");
            String grade = jsonObject.getString("Grade");
            byte[] picture = jsonObject.getBytes("Picture");
            String note = jsonObject.getString("Note");

            Commdisaster commdisaster = new Commdisaster();

            commdisaster.setId(code);
            commdisaster.setDate(date);
            commdisaster.setLocation(location);
            commdisaster.setGrade(grade);
            commdisaster.setNote(note);
            commdisaster.setPicture(picture);
            commdisaster.setType(type);
            commdisaster.setReportingUnit(reporting_unit);

            return commdisaster;
        } else if (disasterCode.equals("441")) {
            // CollapseRecord

            String type = jsonObject.getString("Type");
            String status = jsonObject.getString("Status");
            String note = jsonObject.getString("Note");
            byte[] picture = jsonObject.getBytes("Picture");

            Collapserecord collapserecord = new Collapserecord();

            collapserecord.setId(code);
            collapserecord.setDate(date);
            collapserecord.setLocation(location);
            collapserecord.setType(type);
            collapserecord.setStatus(status);
            collapserecord.setNote(note);
            collapserecord.setPicture(picture);
            collapserecord.setReportingUnit(reporting_unit);

            return collapserecord;
        } else if (disasterCode.equals("552")) {
            // DisasterPrediction

            float longitude = jsonObject.getFloatValue("Longitude");
            float latitude = jsonObject.getFloatValue("Latitude");
            float depth = jsonObject.getFloatValue("Depth");
            float magnitude = jsonObject.getFloatValue("Magnitude");
            String intensity = jsonObject.getString("Intensity");
            String type = jsonObject.getString("Type");
            byte[] picture = jsonObject.getBytes("Picture");
            String note = jsonObject.getString("Note");

            Disasterprediction disasterprediction = new Disasterprediction();

            disasterprediction.setId(code);
            disasterprediction.setDate(date);
            disasterprediction.setLocation(location);
            disasterprediction.setLongitude(longitude);
            disasterprediction.setLatitude(latitude);
            disasterprediction.setDepth(depth);
            disasterprediction.setMagnitude(magnitude);
            disasterprediction.setIntensity(intensity);
            disasterprediction.setType(type);
            disasterprediction.setPicture(picture);
            disasterprediction.setNote(note);
            disasterprediction.setReportingUnit(reporting_unit);

            return disasterprediction;
        }
        //System.out.println(Code);
        return null;
    }

    public Parser(int resourceCode) {
        try {
            // 初始化“地址-Code”映射（加载txt文件）
            InputStream in = this.getClass().getResourceAsStream("/2018全国行政区划（含乡镇数据及代码）.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String tempLine = null;
            while ((tempLine = reader.readLine()) != null) {
                String[] strings = tempLine.split("\t");
                String codeString = strings[0];
                String nameString = strings[1].substring(0, strings[1].length() - 1);
                locationMap.put(codeString, nameString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.resourceCode = resourceCode;
    }

//    public static void main(String[] args) {
//        //Test
//        POJOInterface p = new Parser(202)
//                .parse("{\"Code\":'3604241000001112000',\"Date\":\"2020-02-01\n" +
//                        "00:00:00\",\"Number\":1,\"ReportingUnit\":'中国神奇现象研究协会'}");
//        Deathstatistics deathstatistics = (Deathstatistics) p;
//        System.out.println(deathstatistics.toString());
//    }
}
