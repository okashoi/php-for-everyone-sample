.PHONY: up up/* down java/* php/*

up: up/java up/php

up/java:
	docker-compose up --build java

up/php:
	docker-compose up --build php

down:
	docker-compose down

java/class-access: up/java
	docker-compose run --rm java -classpath ./class-access Main

java/type-compatibility: up/java
	docker-compose run --rm java -classpath ./type-compatibility Main

php/class-access: up/php
	docker-compose run --rm php class-access/index.php

php/type-compatibility: up/php
	docker-compose run --rm php type-compatibility/index.php
