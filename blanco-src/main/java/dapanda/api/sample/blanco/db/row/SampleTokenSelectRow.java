package dapanda.api.sample.blanco.db.row;

/**
 * A row class created from SQL definition (blancoDb).
 *
 * 'SampleTokenSelectRow' row is represented.
 * (1) 'token' column type:java.lang.String
 * (2) 'expired_at' column type:long
 */
@io.micronaut.core.annotation.Introspected
public class SampleTokenSelectRow {
    /**
     * Field [token].
     *
     * フィールド: [token]。
     */
    private String fToken;

    /**
     * Field [expired_at].
     *
     * フィールド: [expired_at]。
     */
    private long fExpiredAt;

    /**
     * フィールド [token] の値を設定します。
     *
     * フィールドの説明: [Field [token].]。
     *
     * @param argToken フィールド[token]に設定する値。
     */
    public void setToken(final String argToken) {
        fToken = argToken;
    }

    /**
     * フィールド [token] の値を取得します。
     *
     * フィールドの説明: [Field [token].]。
     *
     * @return フィールド[token]から取得した値。
     */
    public String getToken() {
        return fToken;
    }

    /**
     * フィールド [expired_at] の値を設定します。
     *
     * フィールドの説明: [Field [expired_at].]。
     *
     * @param argExpiredAt フィールド[expired_at]に設定する値。
     */
    public void setExpiredAt(final long argExpiredAt) {
        fExpiredAt = argExpiredAt;
    }

    /**
     * フィールド [expired_at] の値を取得します。
     *
     * フィールドの説明: [Field [expired_at].]。
     *
     * @return フィールド[expired_at]から取得した値。
     */
    public long getExpiredAt() {
        return fExpiredAt;
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
        buf.append("dapanda.api.sample.blanco.db.row.SampleTokenSelectRow[");
        buf.append("token=" + fToken);
        buf.append(",expired_at=" + fExpiredAt);
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
    public void copyTo(final SampleTokenSelectRow target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: SampleTokenSelectRow#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fToken
        // Type: java.lang.String
        target.fToken = this.fToken;
        // Name: fExpiredAt
        // Type: long
        target.fExpiredAt = this.fExpiredAt;
    }
}
