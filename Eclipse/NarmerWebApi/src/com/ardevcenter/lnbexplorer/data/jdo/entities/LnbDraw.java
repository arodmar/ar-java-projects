/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aerodriguez
 */

package com.ardevcenter.lnbexplorer.data.jdo.entities;

//import java.util.Date;
//import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlRootElement;

@PersistenceCapable
@XmlRootElement
public class LnbDraw implements Comparable<LnbDraw> {

	@PrimaryKey
	@Persistent()
	private Long drawID;
	@Persistent()
	private String drawDate;
	@Persistent
	public String drawType;
	@Persistent
	private String firstNumber;
	@Persistent
	private String secondNumber;
	@Persistent
	private String thirdNumber;
	@Persistent
	private String ordinal;
	@Persistent
	private String popular;
	@Persistent
	private String letters;
	@Persistent
	private String serie;
	@Persistent
	private String folio;
	@Persistent
	private String repFolio;
	
    // Must have no-argument constructor
    public LnbDraw() {}
    public LnbDraw(String drawType) {
    	this.drawType = drawType;
    }

	public Long getDrawID() {
		return drawID;
	}

	public void setDrawID(Long drawID) {
		this.drawID = drawID;
	}

	/**
	 * @return the drawDate
	 */
	public String getDrawDate() {
		return drawDate;
	}

	/**
	 * @param drawDate
	 *            the drawDate to set
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
	 * @param drawType
	 *            the drawType to set
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
	 * @param firstNumber
	 *            the firstNumber to set
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
	 * @param secondNumber
	 *            the secondNumber to set
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
	 * @param thirdNumber
	 *            the thirdNumber to set
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
	 * @param ordinal
	 *            the ordinal to set
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
	 * @param popular
	 *            the popular to set
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
	 * @param letters
	 *            the letters to set
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
	 * @param serie
	 *            the serie to set
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
	 * @param folio
	 *            the folio to set
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
	 * @param repFolio
	 *            the repFolio to set
	 */
	public void setRepFolio(String repFolio) {
		this.repFolio = repFolio;
	}

	@Override
	public String toString() {
		return drawID.toString() + " " +  drawDate + " " + drawType + " " + firstNumber + " " + secondNumber + " " + thirdNumber + " " + letters + " " + serie + " " + folio;

	}

	public int compareTo(LnbDraw objectToCompare) {
		return this.drawDate.compareTo(objectToCompare.drawDate);
	}
}
