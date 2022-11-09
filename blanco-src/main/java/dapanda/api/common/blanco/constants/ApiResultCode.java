package dapanda.api.common.blanco.constants;

import dapanda.api.common.domain.CommonConstants.ResponseResultCode;
import io.micronaut.core.annotation.Introspected;

/**
 * APIが返す結果コードを定数定義します。
 */
@Introspected
public class ApiResultCode {
    /**
     * リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * フィールド: [ARM90001]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90001 = ResponseResultCode.ERROR;

    /**
     * そのユーザーIDはすでに登録されています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * フィールド: [ARM90002]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90002 = ResponseResultCode.ERROR;

    /**
     * そのユーザーIDは登録されていません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM90003]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90003 = ResponseResultCode.ERROR;

    /**
     * パスワードが間違っています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM90004]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90004 = ResponseResultCode.ERROR;

    /**
     * トークン認証に失敗しました。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * フィールド: [ARM90005]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90005 = ResponseResultCode.ERROR;

    /**
     * システムエラー。システム管理者にお問い合わせください。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * フィールド: [ARM99999]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM99999 = ResponseResultCode.ERROR;

    /**
     * バリデーションエラーです。（{0}）&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: バリデーションエラーが発生した場合
     * フィールド: [ARM90006]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90006 = ResponseResultCode.ERROR;

    /**
     * 認証できませんでした。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 認証エラー
     * フィールド: [ARM90008]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90008 = ResponseResultCode.ERROR;

    /**
     * 権限がありません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 権限エラー
     * フィールド: [ARM90009]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM90009 = ResponseResultCode.ERROR;

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
    public void setARM90001(final ResponseResultCode argARM90001) {
        fARM90001 = argARM90001;
    }

    /**
     * フィールド [ARM90001] の値を取得します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90001]から取得した値。
     */
    public ResponseResultCode getARM90001() {
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
    public void setARM90002(final ResponseResultCode argARM90002) {
        fARM90002 = argARM90002;
    }

    /**
     * フィールド [ARM90002] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90002]から取得した値。
     */
    public ResponseResultCode getARM90002() {
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
    public void setARM90003(final ResponseResultCode argARM90003) {
        fARM90003 = argARM90003;
    }

    /**
     * フィールド [ARM90003] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90003]から取得した値。
     */
    public ResponseResultCode getARM90003() {
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
    public void setARM90004(final ResponseResultCode argARM90004) {
        fARM90004 = argARM90004;
    }

    /**
     * フィールド [ARM90004] の値を取得します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90004]から取得した値。
     */
    public ResponseResultCode getARM90004() {
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
    public void setARM90005(final ResponseResultCode argARM90005) {
        fARM90005 = argARM90005;
    }

    /**
     * フィールド [ARM90005] の値を取得します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90005]から取得した値。
     */
    public ResponseResultCode getARM90005() {
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
    public void setARM99999(final ResponseResultCode argARM99999) {
        fARM99999 = argARM99999;
    }

    /**
     * フィールド [ARM99999] の値を取得します。
     *
     * フィールドの説明: [システムエラー。システム管理者にお問い合わせください。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM99999]から取得した値。
     */
    public ResponseResultCode getARM99999() {
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
    public void setARM90006(final ResponseResultCode argARM90006) {
        fARM90006 = argARM90006;
    }

    /**
     * フィールド [ARM90006] の値を取得します。
     *
     * フィールドの説明: [バリデーションエラーです。（{0}）<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: バリデーションエラーが発生した場合
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90006]から取得した値。
     */
    public ResponseResultCode getARM90006() {
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
    public void setARM90008(final ResponseResultCode argARM90008) {
        fARM90008 = argARM90008;
    }

    /**
     * フィールド [ARM90008] の値を取得します。
     *
     * フィールドの説明: [認証できませんでした。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 認証エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90008]から取得した値。
     */
    public ResponseResultCode getARM90008() {
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
    public void setARM90009(final ResponseResultCode argARM90009) {
        fARM90009 = argARM90009;
    }

    /**
     * フィールド [ARM90009] の値を取得します。
     *
     * フィールドの説明: [権限がありません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 権限エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM90009]から取得した値。
     */
    public ResponseResultCode getARM90009() {
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
    public void copyTo(final ApiResultCode target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: ApiResultCode#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fARM90001
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90001] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM90002
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90002] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM90003
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90003] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM90004
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90004] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM90005
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90005] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM99999
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM99999] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM90006
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90006] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM90008
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90008] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM90009
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM90009] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
    }
}
