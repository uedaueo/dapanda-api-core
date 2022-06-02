package dapanda.api.common.blanco.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * APIの返却用メッセージの英語版を定義します。
 *
 * リソースバンドル定義: [ApiResultMessage]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>ja
 * <LI>en
 * </UL>
 */
public class ApiResultMessageResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * ApiResultMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[ApiResultMessage]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public ApiResultMessageResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("dapanda/api/common/blanco/resourcebundle/ApiResultMessage");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * ApiResultMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[ApiResultMessage]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public ApiResultMessageResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("dapanda/api/common/blanco/resourcebundle/ApiResultMessage", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * ApiResultMessageResourceBundleクラスのコンストラクタ。
     *
     * 基底名[ApiResultMessage]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public ApiResultMessageResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("dapanda/api/common/blanco/resourcebundle/ApiResultMessage", locale, loader);
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
     * bundle[ApiResultMessage], key[ARM001]
     *
     * [リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}] (ja)<br>
     * [Invalid value set for request parameter. Item: {0}, value: {1}] (en)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[ARM001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getArm001(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ARM001");
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
     * bundle[ApiResultMessage], key[ARM002]
     *
     * [そのユーザーIDはすでに登録されています。] (ja)<br>
     * [User ID is already registered.] (en)<br>
     *
     * @return key[ARM002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getArm002() {
        // 初期値として定義書の値を利用します。
        String strFormat = "そのユーザーIDはすでに登録されています。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ARM002");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiResultMessage], key[ARM003]
     *
     * [そのユーザーIDは登録されていません。] (ja)<br>
     * [User ID is not registered.] (en)<br>
     *
     * @return key[ARM003]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getArm003() {
        // 初期値として定義書の値を利用します。
        String strFormat = "そのユーザーIDは登録されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ARM003");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiResultMessage], key[ARM004]
     *
     * [パスワードが間違っています。] (ja)<br>
     * [Incorrect password.] (en)<br>
     *
     * @return key[ARM004]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getArm004() {
        // 初期値として定義書の値を利用します。
        String strFormat = "パスワードが間違っています。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ARM004");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[ApiResultMessage], key[ARM005]
     *
     * [トークン認証に失敗しました。] (ja)<br>
     * [Incorrect token.] (en)<br>
     *
     * @return key[ARM005]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getArm005() {
        // 初期値として定義書の値を利用します。
        String strFormat = "トークン認証に失敗しました。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ARM005");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}