from pyautogui import *
from time import *
from os import startfile
os.startfile('"C:\Program Files\PuTTY\putty.exe"')
sleep(1)
write('151.248.113.116')
hotkey('Enter')
sleep(1)
write('''root
9cXWqEs-$pmk
cd javaserver/java-server
mvn spring-boot:run
''')

        
