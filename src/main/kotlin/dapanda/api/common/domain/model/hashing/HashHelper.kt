package dapanda.api.common.domain.model.hashing

import java.security.MessageDigest

private const val SHA256 = "SHA-256"

/**
 * 文字列にsaltを付与し，sha256でハッシュ
 * @return sha256ハッシュ文字列を返す
 */
fun String.sha256WithSalt(salt: String): String {
    val digitStr = this + salt
    return hashString(digitStr, SHA256)
}

/**
 * 文字列をsha256でハッシュ
 * @return sha256ハッシュ文字列を返す
 */
fun String.sha256(): String {
    return hashString(this, SHA256)
}

/**
 * ハッシュ文字列を作成する
 * @param input ハッシュ対象文字列
 * @param algorithm ハッシュアルゴリズム
 * @return ハッシュ文字列を返す
 */
private fun hashString(input: String, algorithm: String): String {
    return MessageDigest
        .getInstance(algorithm)
        .digest(input.toByteArray())
        .fold("") { str, it -> str + "%02x".format(it) }
}