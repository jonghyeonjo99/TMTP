package com.example.ApiParsing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Pill2 {    //entity : db에 저장될 테이블
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Pill2() {}
    private String ENTP_NAME;
    private String ITEM_NAME;
    private String ITEM_SEQ;
    private String EFCYQESITM;
    private String USE_METHOD_QESITM;
    private String ATPN_WARN_QESITM;
    private String ATPN_QESITM;
    private String ITRC_QESITM;
    private String SE_QESITM;
    private String DEPOSIT_METHOD_QESITM;
    private String ITEM_IMAGE;



    public Pill2(Long id, String ENTP_NAME, String ITEM_NAME, String ITEM_SEQ, String EFCYQESITM, String USE_METHOD_QESITM,
                 String ATPN_WARN_QESITM, String ATPN_QESITM, String ITRC_QESITM, String SE_QESITM,
                 String DEPOSIT_METHOD_QESITM, String ITEM_IMAGE){
        super();
        this.id = id;
        this.ENTP_NAME = ENTP_NAME;
        this.ITEM_NAME = ITEM_NAME;
        this.ITEM_SEQ = ITEM_SEQ;
        this.EFCYQESITM = EFCYQESITM;
        this.USE_METHOD_QESITM = USE_METHOD_QESITM;
        this.ATPN_WARN_QESITM = ATPN_WARN_QESITM;
        this.ATPN_QESITM = ATPN_QESITM;
        this.ITRC_QESITM = ITRC_QESITM;
        this.SE_QESITM = SE_QESITM;
        this.DEPOSIT_METHOD_QESITM = DEPOSIT_METHOD_QESITM;
        this.ITEM_IMAGE = ITEM_IMAGE;
    }
}
