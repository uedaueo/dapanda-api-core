/*
 * This code is generated by blanco Framework.
 */
package dapanda.api.core.blanco.db.common.exception;

import java.sql.SQLException;

/**
 * Exception class to indicate that the number of rows processed in the database is not one <br>
 * This class is used in the source code generated by blancoDb <br>
 * Note: This class will be used as a file after automatic source code generation.
 * @since 2005.05.12
 * @author blanco Framework
 */
public class NotSingleRowException extends SQLException {
    /**
     * SQLState code that represents this class.<br>
     * Note: When using this class, do not rely on SQLState, but use the type of the exception class to determine the state.
     */
    protected static final String SQLSTATE_NOTSINGLEROW = "00101";

    /**
     * Create an instance of the exception object to indicate that the number of rows processed is not the expected one.
     *
     * @deprecated It is recommended to use a different constructor that can store the reason.
     */
    public NotSingleRowException() {
        super("Not single row exception has occured.", SQLSTATE_NOTSINGLEROW);
    }

    /**
     * Create an instance of the exception object to indicate that the number of rows processed is not the expected one.
     *
     * @param reason Description of the exception
     */
    public NotSingleRowException(final String reason) {
        super(reason, SQLSTATE_NOTSINGLEROW);
    }

    /**
     * Create an instance of the exception object to indicate that the number of rows processed is not the expected one.
     *
     * @param reason Description of the exception
     * @param SQLState XOPEN code or SQL 99 code that identifies the exception
     */
    public NotSingleRowException(final String reason, final String SQLState) {
        super(reason, SQLState);
    }

    /**
     * Create an instance of the exception object to indicate that the number of rows processed is not the expected one.
     *
     * @param reason Description of the exception
     * @param SQLState XOPEN code or SQL 99 code that identifies the exception
     * @param vendorCode Specific exception codes defined by the database vendor
     */
    public NotSingleRowException(final String reason, final String SQLState, final int vendorCode) {
        super(reason, SQLState, vendorCode);
    }
}