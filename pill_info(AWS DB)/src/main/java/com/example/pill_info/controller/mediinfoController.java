package com.example.pill_info.controller;

import com.example.pill_info.repository.mediinfoRepository;
import com.example.pill_info.model.mediinfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;



@RestController
public class mediinfoController {
    @Autowired
    private mediinfoRepository infoRepository;

    @GetMapping("/api")
    public String load_save() {
        String key = "mRmkUgxI6V2dJrv%2BYEdvvULX49q%2Fdme1Px7TMAV1hXuWyAXYjtr37jwZB1HFu%2FV0fFgRQB92IAe2RxwRDK3Akw%3D%3D";
        String result = "";
        String jsonPrintString = null;
        try {
            for(int i = 1; i < 85; i++) {
                URL url = new URL("http://apis.data.go.kr/1471000/MdcinGrnIdntfcInfoService01/getMdcinGrnIdntfcInfoList01?serviceKey=" + key + "&type=json&numOfRows=300&pageNo=" + i);
                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
                JSONObject body = (JSONObject) jsonObject.get("body");
                long totalCount = (Long) body.get("totalCount");
                JSONArray items = (JSONArray) body.get("items");
                int len = items.size();
                for(int j = 0; j < items.size(); j++) {
                    JSONObject tmp = (JSONObject) items.get(j);
                    mediinfo pillObj = new mediinfo((j+(long)1)+(300*i),String.valueOf(tmp.get("ITEM_SEQ")),String.valueOf(tmp.get("ITEM_NAME")),String.valueOf(tmp.get("ITEM_IMAGE")),String.valueOf(tmp.get("PRINT_FRONT")),String.valueOf(tmp.get("PRINT_BACK")),String.valueOf(tmp.get("DRUG_SHAPE")),
                            String.valueOf(tmp.get("COLOR_CLASS1")),String.valueOf(tmp.get("COLOR_CLASS2")),String.valueOf(tmp.get("LINE_FRONT")),String.valueOf(tmp.get("LINE_BACK")),String.valueOf(tmp.get("CLASS_NO")),String.valueOf(tmp.get("CLASS_NAME"))
                            ,String.valueOf(tmp.get("ITEM_PERMIT_DATE")),String.valueOf(tmp.get("FORM_CODE_NAME")));
                    infoRepository.save(pillObj);
                    jsonPrintString = tmp.toString();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPrintString;
    }
}
