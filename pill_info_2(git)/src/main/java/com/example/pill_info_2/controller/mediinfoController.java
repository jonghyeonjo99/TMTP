package com.example.pill_info_2.controller;

import com.example.pill_info_2.repository.mediinfoRepository;
import com.example.pill_info_2.model.mediinfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
public class mediinfoController {
    @Autowired
    private mediinfoRepository infoRepository;
    @PostMapping("/api")
    public String load_save(@RequestParam("date")String date, Model model) {
        String key = "mRmkUgxI6V2dJrv%2BYEdvvULX49q%2Fdme1Px7TMAV1hXuWyAXYjtr37jwZB1HFu%2FV0fFgRQB92IAe2RxwRDK3Akw%3D%3D";
        String result = "";

        try {
            String requestDate = date;
            int ans = Integer.parseInt(requestDate); /* string to int*/
            URL url = new URL("http://apis.data.go.kr/1471000/MdcinGrnIdntfcInfoService01/getMdcinGrnIdntfcInfoList01?serviceKey=" + key + "&type=json&numOfRows=300&pageNo=" + requestDate);
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
            JSONObject body = (JSONObject) jsonObject.get("body");
            long totalCount = (Long) body.get("totalCount");
            JSONArray items = (JSONArray) body.get("items");
            int len = items.size();
            for(int i = 0; i < items.size(); i++) {
                JSONObject tmp = (JSONObject) items.get(i);
                mediinfo pillObj = new mediinfo(i+(long)1,String.valueOf(tmp.get("ITEM_SEQ")),String.valueOf(tmp.get("ITEM_NAME")),String.valueOf(tmp.get("ITEM_IMAGE")),String.valueOf(tmp.get("PRINT_FRONT")),String.valueOf(tmp.get("PRINT_BACK")),String.valueOf(tmp.get("DRUG_SHAPE")),
                        String.valueOf(tmp.get("COLOR_CLASS1")),String.valueOf(tmp.get("COLOR_CLASS2")),String.valueOf(tmp.get("LINE_FRONT")),String.valueOf(tmp.get("LINE_BACK")),String.valueOf(tmp.get("CLASS_NO")),String.valueOf(tmp.get("CLASS_NAME"))
                        ,String.valueOf(tmp.get("ITEM_PERMIT_DATE")),String.valueOf(tmp.get("FORM_CODE_NAME")));
                infoRepository.save(pillObj);s

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/findname";
    }
}
