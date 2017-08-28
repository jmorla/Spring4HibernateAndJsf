package org.jmorla.common.exception;

/**
 * Created by jmorla on 27/08/17.
 */
public class SpringHibernateWebException extends Exception {

    public SpringHibernateWebException(){
        super("An application error occurred");
    }
}
