package com.github.yumyum.map.web.dto.restaurant;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RestaurantDTO {
    private Integer id;
    private Integer RSTR_ID;
    private String RSTR_NM;
    private String RSTR_RDNMADR;
    private String RSTR_LNNO_ADRES;
    private Double RSTR_LA;
    private Double RSTR_LO;
    private String RSTR_TELNO;
    private String BSNS_STATM_BZCND_NM;
    private String BSNS_LCNC_NM;
    private String RSTR_INTRCN_CONT;
    private String RSTR_AREA_CLSF_NM;
}
//    public class RestaurantDTO {
//        private Integer rstrId;
//        private String rstrNm;
//        private String rstrRdnmadr;
//        private String rstrLnnoAdres;
//        private Double rstrLa;
//        private Double rstrLo;
//        private String rstrTelno;
//        private String bsnsStatmBzcndNm;
//        private String bsnsLcncNm;
//        private String rstrIntrcnCont;
//        private String rstrAreaClsfNm;
//    }
