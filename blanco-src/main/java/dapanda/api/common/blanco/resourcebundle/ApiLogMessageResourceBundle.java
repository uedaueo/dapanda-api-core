package dapanda.api.common.blanco.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * APIのログ用メッセージの日本語版を定義します。
 *
 * リソースバンドル定義: [ApiLogMessage]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>ja
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
     * bundle[ApiLogMessage], key[ALM001]
     *
     * [0001 リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[ALM001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm001(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "0001 リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM001");
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
     * bundle[ApiLogMessage], key[ALM002]
     *
     * [0002 そのユーザーIDはすでに登録されています。] (ja)<br>
     *
     * @return key[ALM002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm002() {
        // 初期値として定義書の値を利用します。
        String strFormat = "0002 そのユーザーIDはすでに登録されています。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM002");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM003]
     *
     * [0003 そのユーザーIDは登録されていません。] (ja)<br>
     *
     * @return key[ALM003]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm003() {
        // 初期値として定義書の値を利用します。
        String strFormat = "0003 そのユーザーIDは登録されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM003");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM004]
     *
     * [0004 データベースから取得した値がNULLです。] (ja)<br>
     *
     * @return key[ALM004]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm004() {
        // 初期値として定義書の値を利用します。
        String strFormat = "0004 データベースから取得した値がNULLです。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM004");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM005]
     *
     * [0005 トークン認証に失敗しました。] (ja)<br>
     *
     * @return key[ALM005]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm005() {
        // 初期値として定義書の値を利用します。
        String strFormat = "0005 トークン認証に失敗しました。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM005");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiLogMessage], key[ALM006]
     *
     * [0006 トークン 認証不要は不要です。] (ja)<br>
     *
     * @return key[ALM006]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAlm006() {
        // 初期値として定義書の値を利用します。
        String strFormat = "0006 トークン 認証不要は不要です。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ALM006");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}
