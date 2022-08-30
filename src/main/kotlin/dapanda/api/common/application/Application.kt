package dapanda.api.common.application

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.context.env.PropertySource
import io.micronaut.runtime.Micronaut.build

/** DB 接続情報の環境変数 */
private const val DB_SECRETS = "DB_SECRETS"

/** Aurora エンドポイントの正規表現一致グループ数 */
private const val AURORA_ENDPOINT_PATTERN_GROUP_COUNT = 3

/**
 * アプリケーションの実行
 */
object Application {

	// DB 接続情報を取得
	val additionalProperties =
		getEscapedDbPasswordPropertySource()

	@JvmStatic
	fun main(args: Array<String>) {
		build()
			.args(*args)
			.packages("dapanda.api")
			.mainClass(Application.javaClass)
			.propertySources(additionalProperties)
			.environmentVariableExcludes(DB_SECRETS)
			.start()
	}
}

/**
 * 環境変数に指定した Secrets Manager の DB 接続情報（JSON）を分解してプロパティソースに変換する。
 *
 * 現時点の ECS Fargate では、Secrets Manager の値（JSON）から個別の値（host など）を
 * 取り出すことができない。そのため、ここで JSON 文字列を解析する処理を行う。
 *
 * @return エスケープ済みパスワードを設定するためのプロパティソースを返す。
 */
private fun getEscapedDbPasswordPropertySource(): PropertySource {
	val map: MutableMap<String, Any> = mutableMapOf()
	System.getenv(DB_SECRETS)?.also { dbSecretsEnv ->
		val objectMapper = ObjectMapper()
		objectMapper.readValue(dbSecretsEnv, DbSecrets::class.java).let { dbSecrets ->
			dbSecrets.host?.also { host ->
				map["db.host"] = host
			}
			dbSecrets.hostReadOnly?.also { hostReadOnly ->
				map["db.hostRead"] = hostReadOnly
			}
			dbSecrets.port?.also { port ->
				map["db.port"] = port
			}
			dbSecrets.username?.also { username ->
				map["db.username"] = username
			}
			dbSecrets.password?.also { password ->
				map["db.password"] = password
			}
		}
	}
	return PropertySource.of("escapedDbPassword", map)
}

/**
 * DB 接続情報
 *
 * パスワードは、エスケープ処理をする
 * パスワードに "${" を含む場合、Micronaut のプロパティホルダーと認識されエラーとなる。
 * そのため、"${" を、プレースホルダ "${dummy:${}" に置換する。
 * プレースホルダ "${dummy:${}" は、「dummy」がプロパティ名で、コロン以降（「${」）がデフォルト値となる。
 * 「dummy」は、未設定とし、解決されない前提として、デフォルト値「${」に変換されるようにする。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class DbSecrets {
	/** ホスト */
	var host: String? = null

	/** ポート */
	var port: Int? = null

	/** ユーザ名 */
	var username: String? = null

	/** パスワード */
	var password: String? = null
		get() = field?.replace("\${", "\${dummy:\${}")

	/** 参照専用ホスト */
	val hostReadOnly: String?
		get() = host?.let { hostReadWrite ->
			Regex("""([^.]+\.cluster)(-[^.]+.ap-northeast-1.rds.amazonaws.com)""")
				.find(hostReadWrite)
				?.groupValues
				?.takeIf { it.size == AURORA_ENDPOINT_PATTERN_GROUP_COUNT }
				?.let { groupValues ->
					// Aurora のエンドポイント形式に一致してる場合、
					// 参照専用エンドポイントの形式に置換する
					// groupValues[0] には、全体の文字列が格納されている。
					"${groupValues[1]}-ro${groupValues[2]}"
				}
				?: host
		}
}
