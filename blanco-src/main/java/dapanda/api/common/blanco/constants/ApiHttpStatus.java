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
     * フィールド: [ARM90001]。
     * デフォルト: [HttpStatus.BAD_REQUEST]。
     */
    private HttpStatus fARM90001 = HttpStatus.BAD_REQUEST;

    /**
     * そのユーザーIDはすでに登録されています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * フィールド: [ARM90002]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM90002 = HttpStatus.FORBIDDEN;

    /**
     * そのユーザーIDは登録されていません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM90003]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM90003 = HttpStatus.FORBIDDEN;

    /**
     * パスワードが間違っています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM90004]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM90004 = HttpStatus.FORBIDDEN;

    /**
     * トークン認証に失敗しました。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * フィールド: [ARM90005]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM90005 = HttpStatus.FORBIDDEN;

    /**
     * システムエラー。システム管理者にお問い合わせください。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * フィールド: [ARM99999]。
     * デフォルト: [HttpStatus.INTERNAL_SERVER_ERROR]。
     */
    private HttpStatus fARM99999 = HttpStatus.INTERNAL_SERVER_ERROR;

    /**
     * バリデーションエラーです。（{0}）&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: バリデーションエラーが発生した場合
     * フィールド: [ARM90006]。
     * デフォルト: [HttpStatus.BAD_REQUEST]。
     */
    private HttpStatus fARM90006 = HttpStatus.BAD_REQUEST;

    /**
     * 認証できませんでした。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 認証エラー
     * フィールド: [ARM90008]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM90008 = HttpStatus.FORBIDDEN;

    /**
     * 権限がありません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 権限エラー
     * フィールド: [ARM90009]。
     * デフォルト: [HttpStatus.FORBIDDEN]。
     */
    private HttpStatus fARM90009 = HttpStatus.FORBIDDEN;

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
    public void setARM90001(final HttpStatus argARM90001) {
        fARM90001 = argARM90001;
    }

    /**
     * フィールド [ARM90001] の値を取得します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * デフォルト: [HttpStatus.BAD_REQUEST]。
     *
     * @return フィールド[ARM90001]から取得した値。
     */
    public HttpStatus getARM90001() {
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
    public void setARM90002(final HttpStatus argARM90002) {
        fARM90002 = argARM90002;
    }

    /**
     * フィールド [ARM90002] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM90002]から取得した値。
     */
    public HttpStatus getARM90002() {
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
    public void setARM90003(final HttpStatus argARM90003) {
        fARM90003 = argARM90003;
    }

    /**
     * フィールド [ARM90003] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM90003]から取得した値。
     */
    public HttpStatus getARM90003() {
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
    public void setARM90004(final HttpStatus argARM90004) {
        fARM90004 = argARM90004;
    }

    /**
     * フィールド [ARM90004] の値を取得します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM90004]から取得した値。
     */
    public HttpStatus getARM90004() {
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
    public void setARM90005(final HttpStatus argARM90005) {
        fARM90005 = argARM90005;
    }

    /**
     * フィールド [ARM90005] の値を取得します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM90005]から取得した値。
     */
    public HttpStatus getARM90005() {
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
    public void setARM99999(final HttpStatus argARM99999) {
        fARM99999 = argARM99999;
    }

    /**
     * フィールド [ARM99999] の値を取得します。
     *
     * フィールドの説明: [システムエラー。システム管理者にお問い合わせください。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * デフォルト: [HttpStatus.INTERNAL_SERVER_ERROR]。
     *
     * @return フィールド[ARM99999]から取得した値。
     */
    public HttpStatus getARM99999() {
        return fARM99999;
    }

    /**
     * フィールド [ARM90006] の値を設定します。
     *
     * フィールドの説明: [バリデーションエラーです。（{0}）<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: バリデーションエラーが発生した場合
     *
     * @param argARM90006 フィールド[ARM90006]に設定する値。
     */
    public void setARM90006(final HttpStatus argARM90006) {
        fARM90006 = argARM90006;
    }

    /**
     * フィールド [ARM90006] の値を取得します。
     *
     * フィールドの説明: [バリデーションエラーです。（{0}）<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: バリデーションエラーが発生した場合
     * デフォルト: [HttpStatus.BAD_REQUEST]。
     *
     * @return フィールド[ARM90006]から取得した値。
     */
    public HttpStatus getARM90006() {
        return fARM90006;
    }

    /**
     * フィールド [ARM90008] の値を設定します。
     *
     * フィールドの説明: [認証できませんでした。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 認証エラー
     *
     * @param argARM90008 フィールド[ARM90008]に設定する値。
     */
    public void setARM90008(final HttpStatus argARM90008) {
        fARM90008 = argARM90008;
    }

    /**
     * フィールド [ARM90008] の値を取得します。
     *
     * フィールドの説明: [認証できませんでした。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 認証エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM90008]から取得した値。
     */
    public HttpStatus getARM90008() {
        return fARM90008;
    }

    /**
     * フィールド [ARM90009] の値を設定します。
     *
     * フィールドの説明: [権限がありません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 権限エラー
     *
     * @param argARM90009 フィールド[ARM90009]に設定する値。
     */
    public void setARM90009(final HttpStatus argARM90009) {
        fARM90009 = argARM90009;
    }

    /**
     * フィールド [ARM90009] の値を取得します。
     *
     * フィールドの説明: [権限がありません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 権限エラー
     * デフォルト: [HttpStatus.FORBIDDEN]。
     *
     * @return フィールド[ARM90009]から取得した値。
     */
    public HttpStatus getARM90009() {
        return fARM90009;
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

        // Name: fARM90001
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90001] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM90002
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90002] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM90003
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90003] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM90004
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90004] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM90005
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90005] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM99999
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM99999] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM90006
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90006] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM90008
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90008] is an unsupported type[io.micronaut.http.HttpStatus].
        // Name: fARM90009
        // Type: io.micronaut.http.HttpStatus
        // Field[fARM90009] is an unsupported type[io.micronaut.http.HttpStatus].
    }
}
