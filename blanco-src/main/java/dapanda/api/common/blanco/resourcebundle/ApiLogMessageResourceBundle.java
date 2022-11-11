package dapanda.api.common.blanco.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * APIのログ用メッセージの英語版を定義します。
 *
 * リソースバンドル定義: [ApiLogMessage]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>ja
 * <LI>en
 * </UL>
 */
public class ApiLogMessageResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * ApiLogMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[ApiLogMessage]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public ApiLogMessageResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("dapanda/api/common/blanco/resourcebundle/ApiLogMessage");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * ApiLogMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[ApiLogMessage]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public ApiLogMessageResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("dapanda/api/common/blanco/resourcebundle/ApiLogMessage", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * ApiLogMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[ApiLogMessage]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public ApiLogMessageResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("dapanda/api/common/blanco/resourcebundle/ApiLogMessage", locale, loader);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * Gets the resource bundle object held internally.
     *
     * @return The resource bundle object held internally.
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90001]
     *
     * [90001 リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}] (ja)<br>
     * [90001 Invalid value set for request parameter. Item: {0}, value: {1}] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[ALM90001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90001(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "90001 リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90001");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[ApiLogMessage], key[ALM90002]
     *
     * [90002 そのユーザーIDはすでに登録されています。] (ja)<br>
     * [90002 User ID is already registered.] (en)<br>
     *
     * @return key[ALM90002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90002() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90002 そのユーザーIDはすでに登録されています。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90002");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90003]
     *
     * [90003 そのユーザーIDは登録されていません。] (ja)<br>
     * [90003 User ID is not registered.] (en)<br>
     *
     * @return key[ALM90003]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90003() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90003 そのユーザーIDは登録されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90003");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90004]
     *
     * [90004 データベースから取得した値がNULLです。] (ja)<br>
     * [90004 The value from the database is NULL.] (en)<br>
     *
     * @return key[ALM90004]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90004() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90004 データベースから取得した値がNULLです。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90004");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90005]
     *
     * [90005 トークン認証に失敗しました。] (ja)<br>
     * [90005 Incorrect token.] (en)<br>
     *
     * @return key[ALM90005]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90005() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90005 トークン認証に失敗しました。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90005");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90006]
     *
     * [90006 トークン 認証は不要です。] (ja)<br>
     * [90006 Token authentication is not required.] (en)<br>
     *
     * @return key[ALM90006]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90006() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90006 トークン 認証は不要です。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90006");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90007]
     *
     * [90007 HttpHeaderにtokenが設定されていません。] (ja)<br>
     * [90007 HttpHeader is not set to token.] (en)<br>
     *
     * @return key[ALM90007]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90007() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90007 HttpHeaderにtokenが設定されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90007");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90008]
     *
     * [90008 このリクエストメソッドを使用することはできません。] (ja)<br>
     * [90008 Request method is not allowed.] (en)<br>
     *
     * @return key[ALM90008]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90008() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90008 このリクエストメソッドを使用することはできません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90008");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90009]
     *
     * [90009 認証できませんでした。] (ja)<br>
     * [90009 Could not be authenticated.] (en)<br>
     *
     * @return key[ALM90009]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90009() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90009 認証できませんでした。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90009");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM90010]
     *
     * [90010 権限がありません。] (ja)<br>
     * [90010 No privilege.] (en)<br>
     *
     * @return key[ALM90010]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm90010() {
        // 初期値として定義書の値を利用します。
        String strFormat = "90010 権限がありません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM90010");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}
