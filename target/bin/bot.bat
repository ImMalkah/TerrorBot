@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\net\dv8tion\JDA\5.0.0-alpha.4\JDA-5.0.0-alpha.4.jar;"%REPO%"\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;"%REPO%"\org\jetbrains\annotations\16.0.1\annotations-16.0.1.jar;"%REPO%"\com\neovisionaries\nv-websocket-client\2.14\nv-websocket-client-2.14.jar;"%REPO%"\com\squareup\okhttp3\okhttp\3.13.0\okhttp-3.13.0.jar;"%REPO%"\com\squareup\okio\okio\1.17.2\okio-1.17.2.jar;"%REPO%"\club\minnced\opus-java\1.1.1\opus-java-1.1.1.jar;"%REPO%"\club\minnced\opus-java-api\1.1.1\opus-java-api-1.1.1.jar;"%REPO%"\net\java\dev\jna\jna\4.4.0\jna-4.4.0.jar;"%REPO%"\club\minnced\opus-java-natives\1.1.1\opus-java-natives-1.1.1.jar;"%REPO%"\org\apache\commons\commons-collections4\4.1\commons-collections4-4.1.jar;"%REPO%"\net\sf\trove4j\trove4j\3.0.3\trove4j-3.0.3.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.10.1\jackson-databind-2.10.1.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.10.1\jackson-annotations-2.10.1.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.10.1\jackson-core-2.10.1.jar;"%REPO%"\org\slf4j\slf4j-api\2.0.0-alpha6\slf4j-api-2.0.0-alpha6.jar;"%REPO%"\ch\qos\logback\logback-classic\1.2.10\logback-classic-1.2.10.jar;"%REPO%"\ch\qos\logback\logback-core\1.2.10\logback-core-1.2.10.jar;"%REPO%"\org\apache\maven\plugins\maven-enforcer-plugin\3.0.0\maven-enforcer-plugin-3.0.0.jar;"%REPO%"\org\apache\maven\maven-artifact\3.1.1\maven-artifact-3.1.1.jar;"%REPO%"\org\apache\maven\maven-plugin-api\3.1.1\maven-plugin-api-3.1.1.jar;"%REPO%"\org\apache\maven\maven-model\3.1.1\maven-model-3.1.1.jar;"%REPO%"\org\eclipse\sisu\org.eclipse.sisu.plexus\0.0.0.M5\org.eclipse.sisu.plexus-0.0.0.M5.jar;"%REPO%"\javax\enterprise\cdi-api\1.0\cdi-api-1.0.jar;"%REPO%"\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;"%REPO%"\javax\inject\javax.inject\1\javax.inject-1.jar;"%REPO%"\com\google\guava\guava\10.0.1\guava-10.0.1.jar;"%REPO%"\org\sonatype\sisu\sisu-guice\3.1.0\sisu-guice-3.1.0-no_aop.jar;"%REPO%"\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;"%REPO%"\org\eclipse\sisu\org.eclipse.sisu.inject\0.0.0.M5\org.eclipse.sisu.inject-0.0.0.M5.jar;"%REPO%"\org\apache\maven\maven-core\3.1.1\maven-core-3.1.1.jar;"%REPO%"\org\apache\maven\maven-settings\3.1.1\maven-settings-3.1.1.jar;"%REPO%"\org\apache\maven\maven-settings-builder\3.1.1\maven-settings-builder-3.1.1.jar;"%REPO%"\org\apache\maven\maven-repository-metadata\3.1.1\maven-repository-metadata-3.1.1.jar;"%REPO%"\org\apache\maven\maven-model-builder\3.1.1\maven-model-builder-3.1.1.jar;"%REPO%"\org\apache\maven\maven-aether-provider\3.1.1\maven-aether-provider-3.1.1.jar;"%REPO%"\org\eclipse\aether\aether-spi\0.9.0.M2\aether-spi-0.9.0.M2.jar;"%REPO%"\org\eclipse\aether\aether-impl\0.9.0.M2\aether-impl-0.9.0.M2.jar;"%REPO%"\org\eclipse\aether\aether-api\0.9.0.M2\aether-api-0.9.0.M2.jar;"%REPO%"\org\eclipse\aether\aether-util\0.9.0.M2\aether-util-0.9.0.M2.jar;"%REPO%"\org\codehaus\plexus\plexus-interpolation\1.19\plexus-interpolation-1.19.jar;"%REPO%"\org\codehaus\plexus\plexus-classworlds\2.5.1\plexus-classworlds-2.5.1.jar;"%REPO%"\org\codehaus\plexus\plexus-component-annotations\1.5.5\plexus-component-annotations-1.5.5.jar;"%REPO%"\org\sonatype\plexus\plexus-sec-dispatcher\1.3\plexus-sec-dispatcher-1.3.jar;"%REPO%"\org\sonatype\plexus\plexus-cipher\1.4\plexus-cipher-1.4.jar;"%REPO%"\org\codehaus\plexus\plexus-utils\3.3.0\plexus-utils-3.3.0.jar;"%REPO%"\org\apache\maven\enforcer\enforcer-api\3.0.0\enforcer-api-3.0.0.jar;"%REPO%"\org\apache\maven\enforcer\enforcer-rules\3.0.0\enforcer-rules-3.0.0.jar;"%REPO%"\org\apache\maven\shared\maven-common-artifact-filters\3.2.0\maven-common-artifact-filters-3.2.0.jar;"%REPO%"\org\apache\maven\shared\maven-shared-utils\3.3.3\maven-shared-utils-3.3.3.jar;"%REPO%"\org\apache\commons\commons-lang3\3.12.0\commons-lang3-3.12.0.jar;"%REPO%"\commons-codec\commons-codec\1.15\commons-codec-1.15.jar;"%REPO%"\commons-io\commons-io\2.11.0\commons-io-2.11.0.jar;"%REPO%"\org\apache-extras\beanshell\bsh\2.0b6\bsh-2.0b6.jar;"%REPO%"\org\apache\maven\shared\maven-dependency-tree\3.1.0\maven-dependency-tree-3.1.0.jar;"%REPO%"\org\apache\maven\resolver\maven-resolver-util\1.6.1\maven-resolver-util-1.6.1.jar;"%REPO%"\org\apache\maven\resolver\maven-resolver-api\1.6.1\maven-resolver-api-1.6.1.jar;"%REPO%"\org\apache\maven\maven-compat\3.1.1\maven-compat-3.1.1.jar;"%REPO%"\org\apache\maven\wagon\wagon-provider-api\2.4\wagon-provider-api-2.4.jar;"%REPO%"\co\terrorsquad\TerrorBot\1.0-SNAPSHOT\TerrorBot-1.0-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="bot" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" Bot %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
