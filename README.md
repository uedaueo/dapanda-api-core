# dapanda-api-core project

## build手順
* Java11, mysqlが必要なのでインストール。
* dapanda-api-coreには現状トークン認証のサンプルがあるのでDBの設定が必要。
mysqlを使えるようにしdapanda-api-coreにあるsample.sqlを使ってデータベースの作成を行う。
* application.ymlのデータベースの設定をしている箇所(datasources.default)を環境に合わせて修正する。
* gradle.propertiesのデータベースの設定をしている箇所を環境に合わせて修正する。(blancoDbJdbcUrl, blancoDbJdbcUser, blancoDbJdbcPasswordを修正する)
* 下記コマンドを実行。
```
./gradlew meta -- blanco-meta配下のエクセルを修正、追加等を行なった場合実行
./gradlew build
```
ローカルmavenリポジトリにpublishする場合は以下のコマンドを実行
```
./gradlew publishToMavenLocal
```