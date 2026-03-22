package com.Neo_Yaz_Bank.exception;
/** Exception levée lorsque le solde est insuffisant pour effectuer une opération
 *
 */
public class InsufficientSoldeException extends RuntimeException {
    public InsufficientSoldeException(String message) {
        super(message);
    }
}
