package dapanda.api.common.blanco.constants;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpStatus;

/**
 * APIが返すHttpStatusを定数定義します。
 */
@Introspected
public class ApiHttpStatus {
    /**
     * リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * フィールド: [ARM001]。
     * デフォルト: [HttpStatus.BAD_REQUEST]。
     */
    private HttpStatus fARM001 = HttpStatus.BAD_REQUEST;

    /**
     * そのユーザーIDはすでに登録されています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * フィールド: [ARM002]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM002 = HttpStatus.FORBIDDEN;

    /**
     * そのユーザーIDは登録されていません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM003]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM003 = HttpStatus.FORBIDDEN;

    /**
     * パスワードが間違っています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM004]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM004 = HttpStatus.FORBIDDEN;

    /**
     * トークン認証に失敗しました。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * フィールド: [ARM005]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM005 = HttpStatus.FORBIDDEN;

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
    public void setARM001(final HttpStatus argARM001) {
        fARM001 = argARM001;
    }

    /**
     * フィールド [ARM001] の値を取得します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * デフォルト: [HttpStatus.BAD_REQUEST]。
     *
     * @return フィールド[ARM001]から取得した値。
     */
    public HttpStatus getARM001() {
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
    public void setARM002(final HttpStatus argARM002) {
        fARM002 = argARM002;
    }

    /**
     * フィールド [ARM002] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM002]から取得した値。
     */
    public HttpStatus getARM002() {
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
    public void setARM003(final HttpStatus argARM003) {
        fARM003 = argARM003;
    }

    /**
     * フィールド [ARM003] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM003]から取得した値。
     */
    public HttpStatus getARM003() {
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
    public void setARM004(final HttpStatus argARM004) {
        fARM004 = argARM004;
    }

    /**
     * フィールド [ARM004] の値を取得します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM004]から取得した値。
     */
    public HttpStatus getARM004() {
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
    public void setARM005(final HttpStatus argARM005) {
        fARM005 = argARM005;
    }

    /**
     * フィールド [ARM005] の値を取得します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM005]から取得した値。
     */
    public HttpStatus getARM005() {
        return fARM005;
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
    public void copyTo(final ApiHttpStatus target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: ApiHttpStatus#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fARM001
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM001] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM002
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM002] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM003
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM003] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM004
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM004] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM005
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM005] is an unsupported type[io.micronaut.http.HttpStatus].
    }
}
