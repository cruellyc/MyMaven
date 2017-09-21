@echo off

set pkgName=LycObject
set appName=测试打包

rd /s /q %pkgName%

call cordova create %pkgName% com.liyc.%pkgName% "%appName%"
copy /y config\config.xml %pkgName%\config.xml
xcopy /s config\res %pkgName%\res\

cd %pkgName%
rd /s /q www
md www
xcopy /s ..\..\src\main\webapp\html\phone www\

call cordova platform add android
call cordova build android
cd ..
copy %pkgName%\platforms\android\ant-build\CordovaApp-debug.apk output\%pkgName%.apk

:EOF
