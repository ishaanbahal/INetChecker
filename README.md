INetChecker
===========

Small application which checks for internet connectivity and beeps when connected. Good for people on a college shared LAN where internet connectivity is lost frequently

Requirements:
JDK 6 or 7

Compile the classes using:<br>
javac INetChecker.java<br>
javac ChatGui2.java<br>
javac Audio.java<br>
<br>
<br>
Edit the INet.sh according to the path of the folder where the source files are.<br>
<br>
Edit Internet Checker.sh also according to the path of the folder of the source files.<br>
<br>
If the audio throws an exception, you probably have OpenJdk IcedTea7 installed. Try using the Oracle JRE/JDK.<br>
<br>
Run the Command Line program using either the script <b>INet.sh</b> or by typing <b>java INetChecker --run</b><br>
<br>
For the GUI, use <b>java ChatGUI2</b> or the script <b>Internet Checker.sh</b><br>
