[![Build Status](https://travis-ci.org/omaru/friend-package.svg?branch=master)](https://travis-ci.org/omaru/friend-package)
[![Code Coverage](https://codecov.io/gh/omaru/friend-package/branch/master/graph/badge.svg)](https://codecov.io/gh/omaru/friend-package)
[![Maintainability](https://api.codeclimate.com/v1/badges/bee3a0b59ad97f96234e/maintainability)](https://codeclimate.com/github/omaru/friend-package/maintainability)
# Send Packages to a Friend
## Packaging
   -  jar file will be contained inside `$PROJECT_HOME/build/libs` folder.
   - once packaged execute with `java -jar $PROJECTNAME.jar`.
```bash
./gradlew  build
``` 
### Usage
once is packaged just run 
```bash
java -ja $PROJECTNAME.jar -i /path/to/file/data.txt
``` 
if no parameter is sent it will run the `data.txt` sample under `resources` folder.
While executing it will present read line and below what it packaged as output.
```bash
usage: package-friend
 -i </path/to/file.txt>   ingest testing data from path,if none provided
                          reads from classpath by default
81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
1
-
4
75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
2
-
7,2
``` 
#### Running Sample
![running](https://user-images.githubusercontent.com/877539/61487385-05763480-a963-11e9-8974-077cf313d34a.gif)
#### Tooling
- gradle
- spring (core)
- commons-cli
- lombok
- travis
- codecov
- codeclimate
## Contributing
Pull requests are welcome.
