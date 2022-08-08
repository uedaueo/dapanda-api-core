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
     * フィールド: [ARM90001]。
     * デフォルト: [&quot;InvalidParam.InvalidValue&quot;]。
     */
    private String fARM90001 = "InvalidParam.InvalidValue";

    /**
     * そのユーザーIDはすでに登録されています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * フィールド: [ARM90002]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM90002 = "AuthorizeError";

    /**
     * そのユーザーIDは登録されていません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM90003]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM90003 = "AuthorizeError";

    /**
     * パスワードが間違っています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM90004]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM90004 = "AuthorizeError";

    /**
     * トークン認証に失敗しました。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * フィールド: [ARM90005]。
     * デフォルト: [&quot;AuthorizeError&quot;]。
     */
    private String fARM90005 = "AuthorizeError";

    /**
     * システムエラー。システム管理者にお問い合わせください。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * フィールド: [ARM99999]。
     * デフォルト: [&quot;ServerError.InternalFailure&quot;]。
     */
    private String fARM99999 = "ServerError.InternalFailure";

    /**
     * フィールド [ARM90001] の値を設定します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     *
     * @param argARM90001 フィールド[ARM90001]に設定する値。
     */
    public void setARM90001(final String argARM90001) {
        fARM90001 = argARM90001;
    }

    /**
     * フィールド [ARM90001] の値を取得します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * デフォルト: [&quot;InvalidParam.InvalidValue&quot;]。
     *
     * @return フィールド[ARM90001]から取得した値。
     */
    public String getARM90001() {
        return fARM90001;
    }

    /**
     * フィールド [ARM90002] の値を設定します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     *
     * @param argARM90002 フィールド[ARM90002]に設定する値。
     */
    public void setARM90002(final String argARM90002) {
        fARM90002 = argARM90002;
    }

    /**
     * フィールド [ARM90002] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM90002]から取得した値。
     */
    public String getARM90002() {
        return fARM90002;
    }

    /**
     * フィールド [ARM90003] の値を設定します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     *
     * @param argARM90003 フィールド[ARM90003]に設定する値。
     */
    public void setARM90003(final String argARM90003) {
        fARM90003 = argARM90003;
    }

    /**
     * フィールド [ARM90003] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM90003]から取得した値。
     */
    public String getARM90003() {
        return fARM90003;
    }

    /**
     * フィールド [ARM90004] の値を設定します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     *
     * @param argARM90004 フィールド[ARM90004]に設定する値。
     */
    public void setARM90004(final String argARM90004) {
        fARM90004 = argARM90004;
    }

    /**
     * フィールド [ARM90004] の値を取得します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM90004]から取得した値。
     */
    public String getARM90004() {
        return fARM90004;
    }

    /**
     * フィールド [ARM90005] の値を設定します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     *
     * @param argARM90005 フィールド[ARM90005]に設定する値。
     */
    public void setARM90005(final String argARM90005) {
        fARM90005 = argARM90005;
    }

    /**
     * フィールド [ARM90005] の値を取得します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * デフォルト: [&quot;AuthorizeError&quot;]。
     *
     * @return フィールド[ARM90005]から取得した値。
     */
    public String getARM90005() {
        return fARM90005;
    }

    /**
     * フィールド [ARM99999] の値を設定します。
     *
     * フィールドの説明: [システムエラー。システム管理者にお問い合わせください。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     *
     * @param argARM99999 フィールド[ARM99999]に設定する値。
     */
    public void setARM99999(final String argARM99999) {
        fARM99999 = argARM99999;
    }

    /**
     * フィールド [ARM99999] の値を取得します。
     *
     * フィールドの説明: [システムエラー。システム管理者にお問い合わせください。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * デフォルト: [&quot;ServerError.InternalFailure&quot;]。
     *
     * @return フィールド[ARM99999]から取得した値。
     */
    public String getARM99999() {
        return fARM99999;
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

        // Name: fARM90001
        // Type: java.lang.String
        target.fARM90001 = this.fARM90001;
        // Name: fARM90002
        // Type: java.lang.String
        target.fARM90002 = this.fARM90002;
        // Name: fARM90003
        // Type: java.lang.String
        target.fARM90003 = this.fARM90003;
        // Name: fARM90004
        // Type: java.lang.String
        target.fARM90004 = this.fARM90004;
        // Name: fARM90005
        // Type: java.lang.String
        target.fARM90005 = this.fARM90005;
        // Name: fARM99999
        // Type: java.lang.String
        target.fARM99999 = this.fARM99999;
    }
}
