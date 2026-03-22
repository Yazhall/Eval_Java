package com.Neo_Yaz_Bank.exception;
/** Exception levée lorsqu'un client est introuvable
 */
public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
