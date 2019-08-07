FROM openjdk:8
EXPOSE  8080
ADD /target/user-gallery.jar user-gallery.jar
ENTRYPOINT [ "java", "-jar", "user-gallery.jar" ]