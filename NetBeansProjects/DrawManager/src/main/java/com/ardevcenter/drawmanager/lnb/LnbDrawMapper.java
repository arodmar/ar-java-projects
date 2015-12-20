/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.drawmanager.lnb;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aerodriguez
 */
public class LnbDrawMapper {

    public static LnbDrawRawEntity mapDraw(List<String> draw) {
        
         LnbDrawRawEntity mapping = null;
         
        //If not valid draw data return
        if(!isValidDrawData(draw)){
            return mapping;
        }
               
        //String playedDate = DateFunctions.parseDateToStandardFormat(draw.get(LnbDrawMappingDefinition.DRAW_DATE_MAPPING_INDEX), "dd-MM-yyyy");
        Date playedDate = DateFunctions.parseDateFromString(draw.get(LnbDrawMappingDefinition.DRAW_DATE_MAPPING_INDEX), "dd-MM-yyyy");
        if (playedDate != null) {
            mapping = new LnbDrawRawEntity();
            mapping.setDrawID(playedDate.getTime());
            mapping.setDrawDate(DateFunctions.parseDateToString(playedDate));
            mapping.setDrawType(draw.get(LnbDrawMappingDefinition.DRAW_TYPE_MAPPING_INDEX).substring(0, 1));
            mapping.setFirstNumber(draw.get(LnbDrawMappingDefinition.FIRST_PRIZE_MAPPING_INDEX));
            mapping.setSecondNumber(draw.get(LnbDrawMappingDefinition.SECOND_PRIZE_MAPPING_INDEX));
            mapping.setThirdNumber(draw.get(LnbDrawMappingDefinition.THIRD_PRIZE_MAPPING_INDEX));            
            mapping.setOrdinal("");
            mapping.setPopular("");
            mapping.setLetters(draw.get(LnbDrawMappingDefinition.LETTERS_MAPPING_INDEX));
            mapping.setSerie(draw.get(LnbDrawMappingDefinition.SERIE_MAPPING_INDEX));
            mapping.setFolio(draw.get(LnbDrawMappingDefinition.FOLIO_MAPPING_INDEX));
            // Mapping V1.2
            //mapping.setRepFolio(draw.get(LnbDrawMappingDefinition.REP_FOLIO_MAPPING_INDEX));            
            mapping.setRepFolio("");
        }
        return mapping;
    }

    public static List<LnbDrawRawEntity> mapDraws(List<List<String>> draws) {
        List<LnbDrawRawEntity> mappedDraws = new ArrayList<>();
        for (List<String> draw : draws) {
            LnbDrawRawEntity mappedDraw = mapDraw(draw);
            if (mappedDraw != null) {
                mappedDraws.add(mappedDraw);
            }
        }
        return mappedDraws;
    }
    
    public static Boolean isValidDrawData(List<String> draw)
    {
        //Validatate if the draw has draw date information
        return (draw.size()-1>=LnbDrawMappingDefinition.DRAW_DATE_MAPPING_INDEX)?true:false;
    }

}
