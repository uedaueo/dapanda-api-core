package dapanda.api.common.blanco.constants;

import io.micronaut.core.annotation.Introspected;

/**
 * APIが返すエラーコードを定数定義します。
 */
@Introspected
public class ApiErrorCode {
    /**
     * リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * フィールド: [ARM001]。
     * デフォルト: [&quot;InvalidParam.InvalidValue&quot;]。
     */
    private String fARM001 = "InvalidParam.InvalidValue";

    /**
     * そのユーザーIDはすでに登録されています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * フィールド: [ARM002]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM002 = "AuthorizeError";

    /**
     * そのユーザーIDは登録されていません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM003]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM003 = "AuthorizeError";

    /**
     * パスワードが間違っています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM004]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM004 = "AuthorizeError";

    /**
     * トークン認証に失敗しました。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * フィールド: [ARM005]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM005 = "AuthorizeError";

    /**
     * システムエラー。システム管理者にお問い合わせください。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * フィールド: [ARM006]。
     * デフォルト: [&quot;ServerError.InternalFailure&quot;]。
     */
    private String fARM006 = "ServerError.InternalFailure";

    /**
     * フィールド [ARM001] の値を設定します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     *
     * @param argARM001 フィールド[ARM001]に設定する値。
     */
    public void setARM001(final String argARM001) {
        fARM001 = argARM001;
    }

    /**
     * フィールド [ARM001] の値を取得します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * デフォルト: [&quot;InvalidParam.InvalidValue&quot;]。
     *
     * @return フィールド[ARM001]から取得した値。
     */
    public String getARM001() {
        return fARM001;
    }

    /**
     * フィールド [ARM002] の値を設定します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     *
     * @param argARM002 フィールド[ARM002]に設定する値。
     */
    public void setARM002(final String argARM002) {
        fARM002 = argARM002;
    }

    /**
     * フィールド [ARM002] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM002]から取得した値。
     */
    public String getARM002() {
        return fARM002;
    }

    /**
     * フィールド [ARM003] の値を設定します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     *
     * @param argARM003 フィールド[ARM003]に設定する値。
     */
    public void setARM003(final String argARM003) {
        fARM003 = argARM003;
    }

    /**
     * フィールド [ARM003] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM003]から取得した値。
     */
    public String getARM003() {
        return fARM003;
    }

    /**
     * フィールド [ARM004] の値を設定します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     *
     * @param argARM004 フィールド[ARM004]に設定する値。
     */
    public void setARM004(final String argARM004) {
        fARM004 = argARM004;
    }

    /**
     * フィールド [ARM004] の値を取得します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM004]から取得した値。
     */
    public String getARM004() {
        return fARM004;
    }

    /**
     * フィールド [ARM005] の値を設定します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     *
     * @param argARM005 フィールド[ARM005]に設定する値。
     */
    public void setARM005(final String argARM005) {
        fARM005 = argARM005;
    }

    /**
     * フィールド [ARM005] の値を取得します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM005]から取得した値。
     */
    public String getARM005() {
        return fARM005;
    }

    /**
     * フィールド [ARM006] の値を設定します。
     *
     * フィールドの説明: [システムエラー。システム管理者にお問い合わせください。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     *
     * @param argARM006 フィールド[ARM006]に設定する値。
     */
    public void setARM006(final String argARM006) {
        fARM006 = argARM006;
    }

    /**
     * フィールド [ARM006] の値を取得します。
     *
     * フィールドの説明: [システムエラー。システム管理者にお問い合わせください。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * デフォルト: [&quot;ServerError.InternalFailure&quot;]。
     *
     * @return フィールド[ARM006]から取得した値。
     */
    public String getARM006() {
        return fARM006;
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
    public void copyTo(final ApiErrorCode target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: ApiErrorCode#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fARM001
        // Type: java.lang.String
        target.fARM001 = this.fARM001;
        // Name: fARM002
        // Type: java.lang.String
        target.fARM002 = this.fARM002;
        // Name: fARM003
        // Type: java.lang.String
        target.fARM003 = this.fARM003;
        // Name: fARM004
        // Type: java.lang.String
        target.fARM004 = this.fARM004;
        // Name: fARM005
        // Type: java.lang.String
        target.fARM005 = this.fARM005;
        // Name: fARM006
        // Type: java.lang.String
        target.fARM006 = this.fARM006;
    }
}
