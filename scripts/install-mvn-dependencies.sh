#!/bin/bash

# Only need to run this once to install the jar into my local-maven-repo folder. 
# Once it's there, it will be picked up in the pom's dependencies

mvn deploy:deploy-file -DgroupId=com.tightvnc -DartifactId=vncviewer -Dversion=1.3.10 -Durl=file:./local-maven-repo/ -DrepositoryId=local-maven-repo -DupdateReleaseInfo=true -Dfile=./lib/vncviewer-1.3.10-manual-package.jar