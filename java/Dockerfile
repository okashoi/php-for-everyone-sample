FROM openjdk:14

COPY . /usr/src/myapp

WORKDIR /usr/src/myapp/class-access
RUN    javac Main.java

WORKDIR /usr/src/myapp/type-compatibility
RUN    javac Main.java

WORKDIR /usr/src/myapp

ENTRYPOINT ["java"]

CMD ["-version"]
