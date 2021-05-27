/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Radiu
 */
package exceptions;

/**
 *
 * @author Radiu
 */

public class ConnectionException extends Exception
{
    private String message;
    public ConnectionException(String message)
    {
        super(message);
    }

}
