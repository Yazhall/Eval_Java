package com.Neo_Yaz_Bank.exception;
/** Exception levée lorsque le montant saisi est invalide, négatif ou nul
 */
public class InvalideAmountException extends RuntimeException {
    public InvalideAmountException(String message) {
        super(message);
    }
}
