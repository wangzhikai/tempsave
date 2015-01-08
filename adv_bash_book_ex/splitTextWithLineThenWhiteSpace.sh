#!/bin/sh
# keywords: read file line split white space
File='./textWithWhiteSpace.txt'
cat $File |
while read line
do 
    #Book chapter-7 eg 7-5
    if [ -z $line ] #any line with white space(s) will be by passed 
    then
        continue
    fi
    echo "==One line read=="
    for a in "$line"
    do 
       echo $a
    done
    echo "Split:"
    for a in $line 
    do 
       echo $a
    done
done 

#File='./yytextWithWhiteSpace.txt'
#{
#  read line
#  echo $line
#} < $File


# one line
#for  w in "$(cat ./textWithWhiteSpace.txt)" 
#do
#   echo $w
#done

# Line is not checked
#for  w in $(cat ./textWithWhiteSpace.txt) 
#do
#   echo $w
#done
