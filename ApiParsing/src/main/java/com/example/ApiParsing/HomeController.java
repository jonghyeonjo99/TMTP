package com.example.ApiParsing;

import com.example.ApiParsing.repository.Pill2InfoRepository;
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
public class HomeController {

    @Autowired
    private Pill2InfoRepository pill2InfoRepository;

    @GetMapping("/api")
    public String index() {return "index";}

    @PostMapping("/api")
    public String local_save(@RequestParam("date")String date, Model model){
        // 인증키 (받아와야함)
        String key = "9YVcCLEsJ2Tr5lLKjqNo%2FgP%2BLRBxCxCk6tYCimBFhNKKuvXqxvDlBsBbkDsOkrWpmrKyKEZeK4mebXLyhccFpg%3D%3D";
        // 파싱한 데이터를 저장할 변수
        String result = "";

        try {
            for(int i = 1; i<85; i++){
                URL url = new URL("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?serviceKey=" + key+ "&type=json&pageNo="+i+"&startPage=1&numOfRows=1");
                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                result = bf.readLine();


                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
                JSONObject body = (JSONObject) jsonObject.get("body");
                long totalCount = (Long) body.get("totalCount");
                JSONArray items = (JSONArray) body.get("items");
                int len = items.size();

                for (int j=0; j<items.size(); j++){
                    JSONObject tmp= (JSONObject) items.get(j);
                    Pill2 Pill2obj = new Pill2((j+(long)1)+(100*i),
                            String.valueOf(tmp.get("ENTP_NAME")),
                            String.valueOf(tmp.get("ITEM_NAME")),
                            String.valueOf(tmp.get("ITEM_SEQ")),
                            String.valueOf(tmp.get("EFCYQESITM")),
                            String.valueOf(tmp.get("USE_METHOD_QESITM")),
                            String.valueOf(tmp.get("ATPN_WARN_QESITM")),
                            String.valueOf(tmp.get("ATPN_QESITM")),
                            String.valueOf(tmp.get("ITRC_QESITM")),
                            String.valueOf(tmp.get("SE_QESITM")),
                            String.valueOf(tmp.get("DEPOSIT_METHOD_QESITM")),
                            String.valueOf(tmp.get("ITEM_IMAGE")));
                    pill2InfoRepository.save(Pill2obj);           ///  이름 안바뀜??????
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/findname";
    }
}