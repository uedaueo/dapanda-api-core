package dapanda.api.emulator.application

class Common {
    companion object {
        fun createUri(host: String, groupId: String, userId: String, token: String): String {
            return "http://$host/sso/$groupId/$userId/top_page/index/$token"
        }
    }
}