/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.utilities.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 *
 * @author aerodriguez
 */
public interface IFileLoader {
    public List<String> ReadLines(String file, Charset charsetType)throws IOException;
}
