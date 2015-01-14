#!/bin/sh
# BAD for file in $( find $PWD | grep -i "\.java$" )
#/Users/zwang/dcmlui/suite/I
#have
#space/I
#rock.java
OIFS=$IFS
IFS="$"
key="action\.yaml"

find $PWD | grep -i "\.java$" |
while read line 
do 
  echo $line
  echo "===="
done


##all in one piece
#for file in "$( find $PWD | grep -i "\.java$" )"
#do
#    echo $file
#    echo "===="
#    #c = $( grep -i $key $file | wc -l )
#    #echo "$c"
#    #if [ ! -z "$c" ] && [ "$c" -gt 1 ] 
#    #then
#    #	echo $file
#    #fi
#    #echo "----"   
#done
IFS=$OIFS

