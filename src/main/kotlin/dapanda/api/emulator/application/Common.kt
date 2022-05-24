package dapanda.api.emulator.application

/**
 * 共通で使用する処理
 */
class Common {
    companion object {
        fun createUri(host: String, groupId: String, userId: String, token: String): String {
            return "http://$host/sso/$groupId/$userId/top_page/index/$token"
        }
    }
}