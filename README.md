- Forked from: https://github.com/jsundqvist/jvncsender

## Install new release version

- To be picked up as a maven dependency in other projects
```sh
mvn clean install
```
```xml
    <dependency>
      <groupId>be.jedi</groupId>
      <artifactId>jvncsender</artifactId>
      <version>${jvncsender.version}</version>
    </dependency>
```
- Update local-maven-repo in kamehouse with the latest version following the instructions in kamehouse cmd README.md

## Create new release version

- On dev branch update ${RELEASE_VERSION} in `<version>` in pom.xml, commit and push
- Then run:
```sh
export RELEASE_VERSION=X.XX
git checkout master
git merge master dev
git push origin master
git tag -a v${RELEASE_VERSION} -m "Release v${RELEASE_VERSION}"
git push origin v${RELEASE_VERSION}
git checkout dev
```

Original README.txt:
---------------------

Please note that jvncsender uses:

- http://www.tightvnc.com/
- http://www.jcraft.com/jsch/ (as it is used by tightvnc)


Usage from the commandline: 

usage: java -jar jvncsender.jar [-list] [-help] -host <hostname> -port <port> -text <text> [-password <password>] [-wait <seconds>]
 -help                  print this message
 -host <hostname>       hostname or ip-address to send it to
 -list                  list keymappings
 -password <password>   password to use
 -port <port>           port to connect to f.i. 5900
 -text <text>           text to send, (can be use multiple times)
 -wait <seconds>        seconds to wait in between sending different texts (default=1s)

text can also take special keys f.i. like "linux ks=ks.cfg<RETURN>"
use -list options to see all keymappings

