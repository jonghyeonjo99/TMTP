package com.example.pill_info.controller;

import com.example.pill_info.model.epillinfo;
import com.example.pill_info.repository.epillinfoRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
public class epillinfoController {
    @Autowired
    private epillinfoRepository infoRepository3;

    @GetMapping("/epill_api")
    public String load_save() {
        String key = "mRmkUgxI6V2dJrv%2BYEdvvULX49q%2Fdme1Px7TMAV1hXuWyAXYjtr37jwZB1HFu%2FV0fFgRQB92IAe2RxwRDK3Akw%3D%3D";
        String result3 = "";
        String jsonPrintString = null;
        try {
            for(int i = 1; i < 45; i++) {
                URL url = new URL("https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?serviceKey=" + key + "&pageNo=" + i + "&type=json&numOfRows=100");
                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
                result3 = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(result3);
                JSONObject body = (JSONObject) jsonObject.get("body");
                JSONArray items = (JSONArray) body.get("items");
                int len = items.size();
                for(int j = 0; j < items.size(); j++) {
                    JSONObject tmp = (JSONObject) items.get(j);
                    epillinfo epillObj = new epillinfo(
                            String.valueOf(tmp.get("entpName")),
                            String.valueOf(tmp.get("itemName")),
                            String.valueOf(tmp.get("itemSeq")),
                            String.valueOf(tmp.get("efcyQesitm")),
                            String.valueOf(tmp.get("useMethodQesitm")),
                            String.valueOf(tmp.get("atpnWarnQesitm")),
                            String.valueOf(tmp.get("atpnQesitm")),
                            String.valueOf(tmp.get("itrcQesitm")),
                            String.valueOf(tmp.get("seQesitm")),
                            String.valueOf(tmp.get("depositMethodQesitm")),
                            String.valueOf(tmp.get("itemImage")));
                    infoRepository3.save(epillObj);
                    jsonPrintString = tmp.toString();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPrintString;
    }
}
