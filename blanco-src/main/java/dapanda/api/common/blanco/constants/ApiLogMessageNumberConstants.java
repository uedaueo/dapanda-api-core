package dapanda.api.common.blanco.constants;

/**
 * APIが返すメッセージNo.です。
 */
public class ApiLogMessageNumberConstants {
    /**
     * 項目番号:1<br>
     * リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}<BR>
     * <BR>
     * API名: <BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: 不正値エラー
     * 用途、使う箇所: リクエストパラメータに不正な値が設定されている場合
     */
    public static final String ALM90001 = "90001";

    /**
     * 項目番号:2<br>
     * そのユーザーIDはすでに登録されています。<BR>
     * <BR>
     * API名: ユーザー登録API<BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: ユーザー登録エラー
     * 用途、使う箇所: ユーザー登録に失敗した場合
     */
    public static final String ALM90002 = "90002";

    /**
     * 項目番号:3<br>
     * そのユーザーIDは登録されていません。<BR>
     * <BR>
     * API名: ログインAPI<BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: ユーザー認証エラー
     * 用途、使う箇所: ユーザー認証に失敗した場合
     */
    public static final String ALM90003 = "90003";

    /**
     * 項目番号:4<br>
     * データベースから取得した値がNULLです。<BR>
     * <BR>
     * API名: ログインAPI<BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: ユーザー認証エラー
     * 用途、使う箇所: ユーザー認証に失敗した場合
     */
    public static final String ALM90004 = "90004";

    /**
     * 項目番号:5<br>
     * トークン認証に失敗しました。<BR>
     * <BR>
     * API名: トークン認証<BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: トークン認証エラー
     * 用途、使う箇所: トークン認証に失敗した場合
     */
    public static final String ALM90005 = "90005";

    /**
     * 項目番号:6<br>
     * トークン 認証は不要です。<BR>
     * <BR>
     * API名: トークン認証<BR>
     * メッセージ区分: INFO<BR>
     * メッセージ種別: トークン認証情報
     * 用途、使う箇所: トークン認証必要可否
     */
    public static final String ALM90006 = "90006";

    /**
     * 項目番号:7<br>
     * HttpHeaderにtokenが設定されていません。<BR>
     * <BR>
     * API名: トークン認証<BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: トークン認証エラー
     * 用途、使う箇所: トークン認証に失敗した場合
     */
    public static final String ALM90007 = "90007";

    /**
     * 項目番号:8<br>
     * 認証できませんでした。<BR>
     * <BR>
     * API名: 認証<BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: 認証エラー
     * 用途、使う箇所: 認証に失敗した場合
     */
    public static final String ALM90008 = "90008";

    /**
     * 項目番号:9<br>
     * 権限がありません。<BR>
     * <BR>
     * API名: 権限<BR>
     * メッセージ区分: ERROR<BR>
     * メッセージ種別: 権限エラー
     * 用途、使う箇所: 権限チェックに失敗した場合
     */
    public static final String ALM90009 = "90009";
}
