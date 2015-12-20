/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.lnbexplorer.entities;

/**
 *
 * @author aerodriguez
 */
public class LnbDraw implements Comparable<LnbDraw> {

    private String drawDate;
    private String drawType;
    private String firstNumber;
    private String secondNumber;
    private String thirdNumber;
    private String ordinal;
    private String popular;
    private String letters;
    private String serie;
    private String folio;
    private String repFolio;

    /**
     * @return the drawDate
     */
    public String getDrawDate() {
        return drawDate;
    }

    /**
     * @param drawDate the drawDate to set
     */
    public void setDrawDate(String drawDate) {
        this.drawDate = drawDate;
    }

    /**
     * @return the drawType
     */
    public String getDrawType() {
        return drawType;
    }

    /**
     * @param drawType the drawType to set
     */
    public void setDrawType(String drawType) {
        this.drawType = drawType;
    }

    /**
     * @return the firstNumber
     */
    public String getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public String getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the thirdNumber
     */
    public String getThirdNumber() {
        return thirdNumber;
    }

    /**
     * @param thirdNumber the thirdNumber to set
     */
    public void setThirdNumber(String thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    /**
     * @return the ordinal
     */
    public String getOrdinal() {
        return ordinal;
    }

    /**
     * @param ordinal the ordinal to set
     */
    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }

    /**
     * @return the popular
     */
    public String getPopular() {
        return popular;
    }

    /**
     * @param popular the popular to set
     */
    public void setPopular(String popular) {
        this.popular = popular;
    }

    /**
     * @return the letters
     */
    public String getLetters() {
        return letters;
    }

    /**
     * @param letters the letters to set
     */
    public void setLetters(String letters) {
        this.letters = letters;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return the repFolio
     */
    public String getRepFolio() {
        return repFolio;
    }

    /**
     * @param repFolio the repFolio to set
     */
    public void setRepFolio(String repFolio) {
        this.repFolio = repFolio;
    }

    @Override
    public String toString() {
        return drawDate + " " + 
                drawType + " " + 
                firstNumber + " " + 
                secondNumber + " " + 
                thirdNumber + " " + 
                letters + " " + 
                serie + " " + 
                folio;
                
    }
    

      public  int compareTo(LnbDraw objectToCompare) {
        return this.drawDate.compareTo(objectToCompare.drawDate);
    }
}
