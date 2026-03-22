package com.Neo_Yaz_Bank.exception;
/** Exception levée lorsqu'un compte bancaire est introuvable
 */
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
