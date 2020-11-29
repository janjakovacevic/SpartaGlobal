package com.sparta.engineering72.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sparta.engineering72.utility.ReportPacker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class JSONHandler {

    static DecimalFormat myFormatter = new DecimalFormat("###,###,###");
    public static JSONArray jsonArray = new JSONArray();
    public static ObjectMapper objectMapper=new ObjectMapper();


    public static JSONArray populateJSON(ReportPacker reportPacker){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalRabbits", myFormatter.format(reportPacker.getTotalRabbits()));
        jsonObject.put("maleRabbits", myFormatter.format(reportPacker.getMaleFoxes()));
        jsonObject.put("femaleRabbits", myFormatter.format(reportPacker.getFemaleRabbits()));
        jsonObject.put("totalFoxes", myFormatter.format(reportPacker.getTotalFoxes()));
        jsonObject.put("maleFoxes", myFormatter.format(reportPacker.getMaleFoxes()));
        jsonObject.put("femaleFoxes", myFormatter.format(reportPacker.getFemaleFoxes()));
        jsonObject.put("rabbitAgeDeaths", myFormatter.format(reportPacker.getRabbitAgeDeaths()));
        jsonObject.put("rabbitPreyDeaths", myFormatter.format(reportPacker.getRabbitPreyDeaths()));
        jsonObject.put("foxDeaths", myFormatter.format(reportPacker.getFoxDeaths()));
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    public static void writeJSONReport(BufferedWriter bufferedWriter, JSONArray jsonArray) throws IOException {
        //bufferedWriter.write(jsonArray.toJSONString());
        bufferedWriter.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));
    }

}
