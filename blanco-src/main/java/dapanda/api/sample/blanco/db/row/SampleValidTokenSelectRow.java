package dapanda.api.sample.blanco.db.row;

/**
 * A row class created from SQL definition (blancoDb).
 *
 * 'SampleValidTokenSelectRow' row is represented.
 * (1) 'user_id' column type:java.lang.String
 */
@io.micronaut.core.annotation.Introspected
public class SampleValidTokenSelectRow {
    /**
     * Field [user_id].
     *
     * フィールド: [user_id]。
     */
    private String fUserId;

    /**
     * フィールド [user_id] の値を設定します。
     *
     * フィールドの説明: [Field [user_id].]。
     *
     * @param argUserId フィールド[user_id]に設定する値。
     */
    public void setUserId(final String argUserId) {
        fUserId = argUserId;
    }

    /**
     * フィールド [user_id] の値を取得します。
     *
     * フィールドの説明: [Field [user_id].]。
     *
     * @return フィールド[user_id]から取得した値。
     */
    public String getUserId() {
        return fUserId;
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
        buf.append("dapanda.api.sample.blanco.db.row.SampleValidTokenSelectRow[");
        buf.append("user_id=" + fUserId);
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
    public void copyTo(final SampleValidTokenSelectRow target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: SampleValidTokenSelectRow#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fUserId
        // Type: java.lang.String
        target.fUserId = this.fUserId;
    }
}
