package dapanda.api.common.blanco.constants;

import blanco.restgenerator.valueobject.ResponseMetaInfo;

import dapanda.api.common.domain.CommonConstants.ResponseResultCode;
import io.micronaut.http.HttpStatus;

/**
 * APIが返すエラーコードを定数定義します。
 */
public class ApiResponseMetaInfoConstants {
    /**
     * 項目番号:1<br>
     * リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: パラメータに不正な値（存在しない選択肢など）が設定されていた場合
     */
    public static final ResponseMetaInfo META90001 = new ResponseMetaInfo(HttpStatus.BAD_REQUEST, ResponseResultCode.ERROR, "InvalidParam.InvalidValue", "", "");

    /**
     * 項目番号:2<br>
     * そのユーザーIDはすでに登録されています。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー登録エラー
     */
    public static final ResponseMetaInfo META90002 = new ResponseMetaInfo(HttpStatus.FORBIDDEN, ResponseResultCode.ERROR, "AuthorizeError", "", "");

    /**
     * 項目番号:3<br>
     * そのユーザーIDは登録されていません。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     */
    public static final ResponseMetaInfo META90003 = new ResponseMetaInfo(HttpStatus.FORBIDDEN, ResponseResultCode.ERROR, "AuthorizeError", "", "");

    /**
     * 項目番号:4<br>
     * パスワードが間違っています。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: ユーザー認証エラー
     */
    public static final ResponseMetaInfo META90004 = new ResponseMetaInfo(HttpStatus.FORBIDDEN, ResponseResultCode.ERROR, "AuthenticateError", "", "");

    /**
     * 項目番号:5<br>
     * トークン認証に失敗しました。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: トークン認証エラー
     */
    public static final ResponseMetaInfo META90005 = new ResponseMetaInfo(HttpStatus.FORBIDDEN, ResponseResultCode.ERROR, "AuthenticateError", "", "");

    /**
     * 項目番号:6<br>
     * システムエラー。システム管理者にお問い合わせください。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 上記に定義できないエラーが発生した場合に返却
     */
    public static final ResponseMetaInfo META99999 = new ResponseMetaInfo(HttpStatus.INTERNAL_SERVER_ERROR, ResponseResultCode.ERROR, "ServerError.InternalFailure", "", "");

    /**
     * 項目番号:7<br>
     * バリデーションエラーです。（{0}）<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: バリデーションエラーが発生した場合
     */
    public static final ResponseMetaInfo META90006 = new ResponseMetaInfo(HttpStatus.BAD_REQUEST, ResponseResultCode.ERROR, "InvalidParam.InvalidValue", "", "");

    /**
     * 項目番号:8<br>
     * このリクエストメソッドを使用することはできません。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: リクエストメソッドが無効になっている場合
     */
    public static final ResponseMetaInfo META90007 = new ResponseMetaInfo(HttpStatus.METHOD_NOT_ALLOWED, ResponseResultCode.ERROR, "MethodNotAllowedError", "", "");

    /**
     * 項目番号:9<br>
     * 認証できませんでした。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 認証エラー
     */
    public static final ResponseMetaInfo META90009 = new ResponseMetaInfo(HttpStatus.FORBIDDEN, ResponseResultCode.ERROR, "AuthenticateError", "", "");

    /**
     * 項目番号:10<br>
     * 権限がありません。<BR>
     * <BR>
     * 可変文字: <BR>
     * 用途、使う箇所: 権限エラー
     */
    public static final ResponseMetaInfo META90010 = new ResponseMetaInfo(HttpStatus.FORBIDDEN, ResponseResultCode.ERROR, "PrivilegeError", "", "");
}
