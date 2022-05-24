package dapanda.api.emulator.blanco.db.row;

/**
 * A row class created from SQL definition (blancoDb).
 *
 * 'UserSelectRow' row is represented.
 * (1) 'password' column type:java.lang.String
 */
@io.micronaut.core.annotation.Introspected
public class UserSelectRow {
    /**
     * Field [password].
     *
     * フィールド: [password]。
     */
    private String fPassword;

    /**
     * フィールド [password] の値を設定します。
     *
     * フィールドの説明: [Field [password].]。
     *
     * @param argPassword フィールド[password]に設定する値。
     */
    public void setPassword(final String argPassword) {
        fPassword = argPassword;
    }

    /**
     * フィールド [password] の値を取得します。
     *
     * フィールドの説明: [Field [password].]。
     *
     * @return フィールド[password]から取得した値。
     */
    public String getPassword() {
        return fPassword;
    }

    /**
     * Gets the string representation of this value object.
     *
     * <P>Precautions for use</P>
     * <UL>
     * <LI>Only the shallow range of the object will be subject to the stringification process.
     * <LI>Do not use this method if the object has a circular reference.
     * </UL>
     *
     * @return String representation of a value object.
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("dapanda.api.emulator.blanco.db.row.UserSelectRow[");
        buf.append("password=" + fPassword);
        buf.append("]");
        return buf.toString();
    }

    /**
     * Copies this value object to the specified target.
     *
     * <P>Cautions for use</P>
     * <UL>
     * <LI>Only the shallow range of the object will be subject to the copying process.
     * <LI>Do not use this method if the object has a circular reference.
     * </UL>
     *
     * @param target target value object.
     */
    public void copyTo(final UserSelectRow target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: UserSelectRow#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fPassword
        // Type: java.lang.String
        target.fPassword = this.fPassword;
    }
}
