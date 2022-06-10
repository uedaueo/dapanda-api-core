package dapanda.api.common.domain.model.common

import blanco.restgenerator.valueobject.ResponseMetaInfo
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import org.slf4j.Logger
import java.lang.reflect.Field

object Utilities {
    /**
     * ARMコードから ResponseMetaInfo クラスを取得します。
     *
     * @param armCode "{ARM003}" の書式で定義されたメッセージテンプレート
     * @param logger ロガー
     * @return metaInfo ApiResponseMetaInfoConstants から取得した ResponseMetaInfo のインスタンス
     */
    fun getResponseMetaInfoByArmCode(armCode: String?, logger: Logger): ResponseMetaInfo? {
        var metaInfo: ResponseMetaInfo? = null
        if (armCode != null && armCode.length > 7) {
            val metaCode = armCode.substring(1, armCode.length - 1).replace("ARM", "META")
            try {
                val field: Field = ApiResponseMetaInfoConstants::class.java.getField(metaCode)
                metaInfo = field[null] as ResponseMetaInfo
                //            logger.debug("!!! GOT !!! " + arm);
            } catch (e: NoSuchFieldException) {
                logger.warn(e.message)
            } catch (e: IllegalAccessException) {
                logger.warn(e.message)
            }
        }
        return metaInfo
    }
}