/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoacif.util.exception;

/**
 *
 * @author Michel
 */
public class erroSistema extends Exception{
    
    public erroSistema(String message) {
        super(message);
    }

    public erroSistema(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
