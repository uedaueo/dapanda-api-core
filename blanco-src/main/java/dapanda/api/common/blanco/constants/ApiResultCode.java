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
     * フィールド: [ARM001]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM001 = ResponseResultCode.ERROR;

    /**
     * そのユーザーIDはすでに登録されています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * フィールド: [ARM002]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM002 = ResponseResultCode.ERROR;

    /**
     * そのユーザーIDは登録されていません。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM003]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM003 = ResponseResultCode.ERROR;

    /**
     * パスワードが間違っています。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * フィールド: [ARM004]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM004 = ResponseResultCode.ERROR;

    /**
     * トークン認証に失敗しました。&lt;BR&gt;
     *
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * フィールド: [ARM005]。
     * デフォルト: [ResponseResultCode.ERROR]。
     */
    private ResponseResultCode fARM005 = ResponseResultCode.ERROR;

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
    public void setARM001(final ResponseResultCode argARM001) {
        fARM001 = argARM001;
    }

    /**
     * フィールド [ARM001] の値を取得します。
     *
     * フィールドの説明: [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM001]から取得した値。
     */
    public ResponseResultCode getARM001() {
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
    public void setARM002(final ResponseResultCode argARM002) {
        fARM002 = argARM002;
    }

    /**
     * フィールド [ARM002] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDはすでに登録されています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM002]から取得した値。
     */
    public ResponseResultCode getARM002() {
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
    public void setARM003(final ResponseResultCode argARM003) {
        fARM003 = argARM003;
    }

    /**
     * フィールド [ARM003] の値を取得します。
     *
     * フィールドの説明: [そのユーザーIDは登録されていません。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM003]から取得した値。
     */
    public ResponseResultCode getARM003() {
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
    public void setARM004(final ResponseResultCode argARM004) {
        fARM004 = argARM004;
    }

    /**
     * フィールド [ARM004] の値を取得します。
     *
     * フィールドの説明: [パスワードが間違っています。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM004]から取得した値。
     */
    public ResponseResultCode getARM004() {
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
    public void setARM005(final ResponseResultCode argARM005) {
        fARM005 = argARM005;
    }

    /**
     * フィールド [ARM005] の値を取得します。
     *
     * フィールドの説明: [トークン認証に失敗しました。<BR>]。
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     * デフォルト: [ResponseResultCode.ERROR]。
     *
     * @return フィールド[ARM005]から取得した値。
     */
    public ResponseResultCode getARM005() {
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
    public void copyTo(final ApiResultCode target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: ApiResultCode#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fARM001
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM001] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM002
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM002] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM003
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM003] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM004
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM004] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
        // Name: fARM005
        // Type: dapanda.api.common.domain.CommonConstants.ResponseResultCode
        // Field[fARM005] is an unsupported type[dapanda.api.common.domain.CommonConstants.ResponseResultCode].
    }
}
