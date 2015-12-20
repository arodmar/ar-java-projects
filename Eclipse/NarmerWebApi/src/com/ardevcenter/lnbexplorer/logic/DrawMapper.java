/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.lnbexplorer.logic;

import com.ardevcenter.lnbexplorer.data.jdo.entities.LnbDraw;
import com.ardevcenter.utilities.DateFunctions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aerodriguez
 */
public class DrawMapper {

    public static LnbDraw mapDraw(List<String> draw) {
        
         LnbDraw mapping = null;
         
        //If not valid draw data return
        if(!isValidDrawData(draw)){
            return mapping;
        }
               
        //String playedDate = DateFunctions.parseDateToStandardFormat(draw.get(DrawMappingDefinition.DRAW_DATE_MAPPING_INDEX), "dd-MM-yyyy");
        Date playedDate = DateFunctions.parseDateFromString(draw.get(DrawMappingDefinition.DRAW_DATE_MAPPING_INDEX), "dd-MM-yyyy");
        if (playedDate != null) {
            mapping = new LnbDraw();
            mapping.setDrawID(playedDate.getTime());
            mapping.setDrawDate(DateFunctions.parseDateToString(playedDate));
            mapping.setDrawType(draw.get(DrawMappingDefinition.DRAW_TYPE_MAPPING_INDEX).substring(0, 1));
            mapping.setFirstNumber(draw.get(DrawMappingDefinition.FIRST_PRIZE_MAPPING_INDEX));
            mapping.setSecondNumber(draw.get(DrawMappingDefinition.SECOND_PRIZE_MAPPING_INDEX));
            mapping.setThirdNumber(draw.get(DrawMappingDefinition.THIRD_PRIZE_MAPPING_INDEX));            
            mapping.setOrdinal("");
            mapping.setPopular("");
            mapping.setLetters(draw.get(DrawMappingDefinition.LETTERS_MAPPING_INDEX));
            mapping.setSerie(draw.get(DrawMappingDefinition.SERIE_MAPPING_INDEX));
            mapping.setFolio(draw.get(DrawMappingDefinition.FOLIO_MAPPING_INDEX));
            mapping.setRepFolio(draw.get(DrawMappingDefinition.REP_FOLIO_MAPPING_INDEX));
        }
        return mapping;
    }

    public static List<LnbDraw> mapDraws(List<List<String>> draws) {
        List<LnbDraw> mappedDraws = new ArrayList<>();
        for (List<String> draw : draws) {
            LnbDraw mappedDraw = mapDraw(draw);
            if (mappedDraw != null) {
                mappedDraws.add(mappedDraw);
            }
        }
        return mappedDraws;
    }
    
    public static Boolean isValidDrawData(List<String> draw)
    {
        //Validatate if the draw has draw date information
        return (draw.size()-1>=DrawMappingDefinition.DRAW_DATE_MAPPING_INDEX)?true:false;
    }

}
