package dapanda.api.common.application

import io.micronaut.runtime.Micronaut.build

/**
 * アプリケーションの実行
 */
object Application {
	@JvmStatic
	fun main(args: Array<String>) {
		build()
			.args(*args)
			.packages("dapanda.api")
			.start()
	}
}
