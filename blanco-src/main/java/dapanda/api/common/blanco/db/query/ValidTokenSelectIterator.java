/*
 * This code is generated by blanco Framework.
 */
package dapanda.api.common.blanco.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dapanda.api.common.blanco.db.row.ValidTokenSelectRow;
import dapanda.api.core.blanco.db.common.exception.DeadlockException;
import dapanda.api.core.blanco.db.common.exception.TimeoutException;
import dapanda.api.core.blanco.db.common.util.BlancoDbDynamicClause;
import dapanda.api.core.blanco.db.common.util.BlancoDbDynamicLiteral;
import dapanda.api.core.blanco.db.common.util.BlancoDbDynamicOrderBy;
import dapanda.api.core.blanco.db.common.util.BlancoDbDynamicParameter;
import dapanda.api.core.blanco.db.common.util.BlancoDbUtil;

/**
 * [ValidTokenSelect] 有効なトークン情報の取得を行います。 (QueryIterator)
 *
 * Wraps a search-type SQL statement to provide various accessors.<br>
 * Scroll attribute: forward_only<br>
 */
public class ValidTokenSelectIterator {
    /**
     * Database connection object used internally by this class.
     *
     * Database connection object is given externally as arguments to the constructor.<br>
     * Transaction commit and rollback are not performed inside this class.
     */
    protected Connection fConnection;

    /**
     * Statement object used internally by this class.
     *
     * This object is generated from the database connection object and used internally.<br>
     * Closes this object when the close method is called.
     */
    protected PreparedStatement fStatement;

    /**
     * The result set object used internally by this class.
     *
     * This object is created from the database statement object and used internally.<br>
     * Closes this object when the close method is called.
     */
    protected ResultSet fResultSet;

    /**
     * ValidTokenSelectIteratorConstructor for the class.
     *
     * Creates a query class with a database connection object as an argument.<br>
     * After using this class, you must call the close() method.<br>
     *
     * @param conn Database connection
     */
    public ValidTokenSelectIterator(final Connection conn) {
        fConnection = conn;
    }

    /**
     * ValidTokenSelectIteratorConstructor for the class.
     *
     * Creates a query class without giving a database connection object.<br>
     */
    @Deprecated
    public ValidTokenSelectIterator() {
    }

    /**
     * ValidTokenSelectIteratorSets a database connection to the class.
     *
     * @param conn Database connection
     */
    @Deprecated
    public void setConnection(final Connection conn) {
        fConnection = conn;
    }

    /**
     * Gets the SQL statement given in the SQL definition document.
     *
     * If the # keyword is specified as the SQL input parameter, the SQL statement after replacing the corresponding part with ? can be obtained.
     *
     * @return SQL statement in the state that can be given to the JDBC driver and executed.
     */
    public String getQuery() {
        return "SELECT \n  user_id \nFROM \n  token \nWHERE \n  token = ? \n  AND UNIX_TIMESTAMP(expired_at) >= ? \n;";
    }

    /**
     * Precompiles with the SQL statement given from the SQL definition document.
     *
     * Internally calls Connection.prepareStatement.<br>
     *
     * @throws SQLException If an SQL exception occurs.
     */
    public void prepareStatement() throws SQLException {
        close();
        prepareStatement(getQuery());
    }

    /**
     * Precompiles with the given SQL statement (dynamic SQL).
     *
     * This method should only be used when you need to execute SQL that dynamically changes its contents.<br>
     * If you need to use dynamic SQL, please change "Dynamic SQL" to "Use" in the SQL definition document. After the change, it will be available externally.<br>
     * Internally calls the JDBC driver's Connection.prepareStatement.<br>
     *
     * @param query The SQL statement that you want to have precompiled. In the case of dynamic SQL, this argument is the executable SQL statement after it has been processed.
     * @throws SQLException If an SQL exception occurs.
     */
    protected void prepareStatement(final String query) throws SQLException {
        close();
        fStatement = fConnection.prepareStatement(query);
    }

    /**
     * Sets the SQL input parameters to be given to the SQL statement.
     *
     * Internally, the PreparedStatement is set with SQL input parameters.
     *
     * @param token Value in 'token' column
     * @param expiredDateTime Value in 'expiredDateTime' column
     * @throws SQLException If an SQL exception occurs.
     */
    public void setInputParameter(final String token, final Long expiredDateTime) throws SQLException {
        if (fStatement == null) {
            prepareStatement();
        }

        int index = 1;
        fStatement.setString(index, token);
        index++;

        if (expiredDateTime == null) {
            fStatement.setNull(index, java.sql.Types.BIGINT);
        } else {
            fStatement.setLong(index, expiredDateTime.longValue());
        }
        index++;

    }

    /**
     * Executes a search-type query.<br>
     *
     * @throws DeadlockException If a database deadlock occurs.
     * @throws TimeoutException If a database timeout occurs.
     * @throws SQLException If an SQL exception occurs.
     */
    public void executeQuery() throws DeadlockException, TimeoutException, SQLException {
        if (fStatement == null) {
            // Since PreparedStatement has not yet been obtained, it is obtained by calling the prepareStatement() method prior to executing PreparedStatement.executeQuery().
            prepareStatement();
        }
        if (fResultSet != null) {
            // Since the previous result set (ResultSet) is still there, releases it.
            fResultSet.close();
            fResultSet = null;
        }

        try {
            fResultSet = fStatement.executeQuery();
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * Moves the cursor to the next line from the current position.
     *
     * @return True if the new current row is valid, false if there are no more rows.
     * @throws DeadlockException If a database deadlock occurs.
     * @throws TimeoutException If a database timeout occurs.
     * @throws SQLException If an SQL exception occurs.
     */
    public boolean next() throws DeadlockException, TimeoutException, SQLException {
        if (fResultSet == null) {
            executeQuery();
        }

        try {
            return fResultSet.next();
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * Gets the data of the current row as an object.
     *
     * Before calling this method, you need to call a method that manipulates the cursor, such as next().
     *
     * @return Row object.
     * @throws SQLException If an SQL exception occurs.
     */
    public ValidTokenSelectRow getRow() throws SQLException {
        ValidTokenSelectRow result = new ValidTokenSelectRow();
        result.setUserId(fResultSet.getString(1));

        return result;
    }

    /**
     * Gets the statement (java.sql.PreparedStatement).
     * @deprecated Basically, Statement does not need to be used directly from the outside.
     *
     * @return The java.sql.PreparedStatement object used internally
     */
    public PreparedStatement getStatement() {
        return fStatement;
    }

    /**
     * Gets the internally held ResultSet object.
     *
     * @deprecated Basically, you don't need to use ResultSet directly from outside.
     *
     * @return The ResultSet object.
     */
    public ResultSet getResultSet() {
        return fResultSet;
    }

    /**
     * Gets the search results in the form of a list.
     *
     * The list will contain the ValidTokenSelect class.<br>
     * This can be used when the number of search results is known in advance and the number is small.<br>
     * If you have a large number of search results, it is recommended that you do not use this method, but use the next() method instead.<br>
     * This QueryIterator is FORWARD_ONLY (forward cursor). If you know that you will be working with a large amount of data, avoid using this getList method as much as possible or regenerate the source code as a scrolling cursor.
     *
     * @param size The number of lines to read.
     * @return ValidTokenSelectClass List, which will return an empty list if the search results are zero.
     * @throws SQLException If an SQL exception occurs.
     */
    public List<ValidTokenSelectRow> getList(final int size) throws SQLException {
        List<ValidTokenSelectRow> result = new ArrayList<ValidTokenSelectRow>(8192);
        for (int count = 1; count <= size; count++) {
            if (next() == false) {
                break;
            }
            result.add(getRow());
        }
        return result;
    }

    /**
     * Closes this class.
     *
     * Calls the close() method on the JDBC resource object that was created internally.<br>
     * Make sure to call this method after using the class.
     *
     * @throws SQLException If an SQL exception occurs.
     */
    public void close() throws SQLException {
        try {
            if (fResultSet != null) {
                fResultSet.close();
                fResultSet = null;
            }
        } finally {
            if (fStatement != null) {
                fStatement.close();
                fStatement = null;
            }
        }
    }
}
