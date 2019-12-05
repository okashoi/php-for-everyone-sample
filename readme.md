# 『みんなのPHP』「7.7 PHP で堅牢なプログラミングをするためのノウハウ」ソースコード集

このリポジトリでは『[みんなのPHP　現場で役立つ最新ノウハウ！](https://amzn.to/2DRtGtm)』（技術評論社／2019年）の「7.7 PHP で堅牢なプログラミングをするためのノウハウ」に掲載したソースコードを公開しています。

また Docker Compose がインストールされている環境では実際に動かして動作を確認することができます。 併せて活用してください。

## ソースコードへのリンク

* [「型に関する仕様：戻り値の共変」の PHP のソースコード](https://github.com/okashoi/php-for-everyone-sample/tree/master/php/type-compatibility)
* [「型に関する仕様：戻り値の共変」の Java のソースコード](https://github.com/okashoi/php-for-everyone-sample/tree/master/java/type-compatibility)
* [「クラスはすべてpublic」の PHP のソースコード](https://github.com/okashoi/php-for-everyone-sample/tree/master/php/class-access)
* [「クラスはすべてpublic」の Java のソースコード](https://github.com/okashoi/php-for-everyone-sample/tree/master/java/class-access)

## （付録）Docker Compose で動作させる手順

リポジトリ全体のディレクトリ構造は以下のとおりです。

```
./
 |-- java/
 |   |-- class-access/       # 「クラスはすべてpublic」の Java のソースコード
 :   :   :
 |   |-- type-compatibility/ # 「型に関する仕様：戻り値の共変」の Java のソースコード
 :   :   :
 |   `-- Dockerfile
 |-- php/
 |   |-- class-access/       # 「クラスはすべてpublic」の PHP のソースコード
 :   :   :
 |   |-- type-compatibility/ # 「型に関する仕様：戻り値の共変」の PHP のソースコード
 :   :   :
 |   `-- Dockerfile
 |-- .env                   # Docker Compose 用の .env ファイル
 |-- Makefile
 |-- docker-compose.yml
 `-- readme.md
```

`make` コマンドを通じて、各ソースコードを動作させることができます。

```bash
# 「型に関する仕様：戻り値の共変」の PHP のソースコードの実行
$ make php/type-compatibility

# 「型に関する仕様：戻り値の共変」の Java のソースコードの実行
$ make java/type-compatibility

# 「クラスはすべてpublic」の PHP のソースコードの実行
$ make php/class-access

# 「クラスはすべてpublic」の Java のソースコードの実行
$ make java/class-access
```

少しわかりにくいですが `docker-compose run --rm 〜` と出力された行より後ろが実行結果です。
以下の例では、実行した結果 `2` が出力されたことを意味しています。

```bash
$ make java/class-access
docker-compose up --build java
Building java
Step 1/9 : FROM openjdk:14
 ---> 82a91ab5aaf5
Step 2/9 : COPY . /usr/src/myapp
 ---> Using cache
 ---> e1b66a6c8aeb
Step 3/9 : WORKDIR /usr/src/myapp/class-access
 ---> Using cache
 ---> a81f891de12c
Step 4/9 : RUN    javac Main.java
 ---> Using cache
 ---> 6d693d779023
Step 5/9 : WORKDIR /usr/src/myapp/type-compatibility
 ---> Using cache
 ---> 231c86e3aff0
Step 6/9 : RUN    javac Main.java
 ---> Using cache
 ---> 54e0701f89e8
Step 7/9 : WORKDIR /usr/src/myapp
 ---> Using cache
 ---> 188f5daab648
Step 8/9 : ENTRYPOINT ["java"]
 ---> Using cache
 ---> 68fd0f607db2
Step 9/9 : CMD ["-version"]
 ---> Using cache
 ---> 02304c70c525
Successfully built 02304c70c525
Successfully tagged php-for-everyone-sample_java:latest
Starting php-for-everyone-sample_java_1 ... done
Attaching to php-for-everyone-sample_java_1
java_1  | openjdk version "14-ea" 2020-03-17
java_1  | OpenJDK Runtime Environment (build 14-ea+12-409)
java_1  | OpenJDK 64-Bit Server VM (build 14-ea+12-409, mixed mode, sharing)
php-for-everyone-sample_java_1 exited with code 0
docker-compose run --rm java -classpath ./class-access Main
2
```

また、以下のコマンドで実行が終了したコンテナを削除できます。

```bash
$ make down
```
