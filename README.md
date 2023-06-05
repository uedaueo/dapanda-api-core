# dapanda-api-core project

## build手順
* Java11以上（17推奨）, mysqlが必要なのでインストール。
* dapanda-api-coreには現状トークン認証のサンプルがあるのでDBの設定が必要。
mysqlを使えるようにしdapanda-api-coreにあるsampleTable.sqlを使ってデータベースの作成を行う。
* ~~application.ymlのデータベースの設定をしている箇所(datasources.default)を環境に合わせて修正する。~~
* DB 接続情報については、環境変数またはコマンドライン引数で指定する。
* gradle.propertiesのデータベースの設定をしている箇所を環境に合わせて修正する。~~(blancoDbJdbcUrl, blancoDbJdbcUser, blancoDbJdbcPasswordを修正する)~~
  * gradle.properties を直接修正せずに、local.gradle に設定する
  * local.gradle は .gitignore に入れているので、設定変更をしない場合でも必ず空ファイルを作成すること
* 下記コマンドを実行。
```
./gradlew meta -- blanco-meta配下のエクセルを修正、追加等を行なった場合実行
./gradlew build
```
ローカルmavenリポジトリにpublishする場合は以下のコマンドを実行
```
./gradlew publishToMavenLocal
```
github-pages で用意したオレオレ maven repo に publish する場合は以下のコマンドを実行
```agsl
./gradlew pubPush
```

## DB 接続情報の設定方法
DB 接続情報の設定は、環境変数または、コマンドラインで行える。
AWS 環境上では、環境変数を利用する。
ローカル環境では、コマンドラインを利用する。

### 環境変数で設定する場合
環境変数名は、`DB_SECRETS`となる。
設定する値は、AWS Secrets Manager 形式で以下のように設定する。

```json5
{
  "host": "192.168.1.1",
  "port": "3306",
  "username": "root",
  "password": "password"
}
```

環境変数を受け取る処理は、
`dapanda.api.common.application.Application`
に実装している。

### コマンドラインで設定する場合
以下のように実行する。
```
gradlew run -PjvmArgs="-Ddb.host=192.168.1.1 -Ddb.port=33360"
```

### 複数DBを使いたい場合

Replication で検索専用 DB にアクセスする場合など。

* application.yml の datasource: に、default: 以外の名前（たとえば readonly）で設定を追記する
* dataSource を DI する際に、@Named("readonly") と指定する

```kotlin
@Prototype
class UserRepository(
    private val dataSource: DataSource,
    @Named("readonly")
    private val dataSourceReadOnly: DataSource
) {
    // .....
}
```

## ビルドについて
gradle でのクリーンビルドは、以下のように行う。
この方法は、キャッシュやバックグランド実行を行わない。
Micronaut の Bean 定義が、正常に生成されない場合などで、このコマンドを実行する。
```
gradlew --no-build-cache --no-daemon clean build
```

IntelliJ の場合は、`Run/Debug Configurations` の `VM options` に
`-Dorg.gradle.caching=false -Dorg.gradle.daemon=false` を設定する。

## gradle version について

以下のコマンドでgradleのバージョンを上げる事ができる。dapanda-api-core 1.0.x では gradle 8.1.1 以上を推奨する。

```
./gradlew wrapper --gradle-version=8.1.1
```