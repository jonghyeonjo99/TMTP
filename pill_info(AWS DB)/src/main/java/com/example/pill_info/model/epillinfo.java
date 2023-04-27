package com.example.pill_info.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class epillinfo {
    @Id
    @Column
    private String itemSeq;
    private  epillinfo() {}
    private String entpName;
    private String itemName;
    private String efcyQesitm;
    private String useMethodQesitm;
    private String atpnWarnQesitm;
    private String atpnQesitm;
    private String itrcQesitm;
    private String seQesitm;
    private String depositMethodQesitm;
    private String itemImage;

    public epillinfo (String entpName,String itemName,String itemSeq,String efcyQesitm,
                      String useMethodQesitm,String atpnWarnQesitm,String atpnQesitm,
                      String itrcQesitm,String seQesitm,String depositMethodQesitm,String itemImage) {
        super();
        this.entpName=entpName;
        this.itemName=itemName;
        this.itemSeq=itemSeq;
        this.efcyQesitm=efcyQesitm;
        this.useMethodQesitm=useMethodQesitm;
        this.atpnWarnQesitm=atpnWarnQesitm;
        this.atpnQesitm=atpnQesitm;
        this.itrcQesitm=itrcQesitm;
        this.seQesitm=seQesitm;
        this.depositMethodQesitm=depositMethodQesitm;
        this.itemImage=itemImage;
    }

}
